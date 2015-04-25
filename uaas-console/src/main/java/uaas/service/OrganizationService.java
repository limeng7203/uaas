package uaas.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uaas.domain.Organization;
import uaas.domain.User;
import uaas.exception.BussinessException;
import uaas.repo.ComplexQueryRepo;
import uaas.repo.OrganizationRepo;
import uaas.repo.UserRepo;
import uaas.service.rest.OrganizationVO;

/**
 * 部门业务<br>
 * <pre>
 * 部门服务虽然功能不是很多，但是涉及到了层级关系，像移动、删除包含子部门
 * 其实业务还是蛮多的。
 * 
 * 类似这样的业务在后续的资源管理中也是如此。
 * 
 * 解释：
 * 为什么使用JPA了，那为什么还使用基本属性，为什么不使用关联操作呢，
 * 原因就是部门和用户，我希望都是弱关系，例如删除某个部门了，那么无论怎样，该用户都可以正常的登陆使用。
 * 删除了这个用户，这个部门显示正常，至于负责人另说，所以使用弱关系。
 * 
 * </pre>
 * @author percy
 *
 */
@Service
public class OrganizationService {
	@Autowired
	private OrganizationRepo organizationRepo;
	@Autowired
	private ComplexQueryRepo complexQueryRepo;
	@Autowired
	private UserRepo userRepo;

	/**
	 * 获取所有部门
	 * 
	 * @return
	 */
	public List<OrganizationVO> findAll() {
		List<OrganizationVO> organizations = complexQueryRepo
				.findAllOrganiation();
		return organizations;
	}

	/**
	 * 创建部门
	 * 
	 * @param organization
	 * @return
	 */
	@Transactional
	public Long create(Organization organization) {
		if (null != organization.getParent()
				&& null != organization.getParent().getId()) {
			List<Organization> organizations = organizationRepo
					.findByParentIdAndNameAndStateNot(organization.getParent()
							.getId(), organization.getName(), -1);
			if (organizations.size() > 0) {
				throw new BussinessException("organization_name_exist",
						"该部门下已经有了相同的名字部门");
			}
		}
		organization.setCode(organization.getName());
		organization.setCreated(new Date());
		organization.setUpdated(new Date());
		organization.setState(1);

		if (null != organization.getParent()
				&& null != organization.getParent().getId()) {
			Organization parent = organizationRepo.findOne(organization
					.getParent().getId());
			organization.setLevel(parent.getLevel() + 1);
			organization.setPath(parent.getPath() + "/"
					+ organization.getName());
			organization.setParent(parent);
		} else {
			organization.setLevel(1);
			organization.setPath("/" + organization.getName());
		}

		if (null != organization.getLeaderId()) {
			User user = userRepo.findOne(organization.getLeaderId());
			if (null != user && 1 != user.getState()) {
				organization.setLeaderName(user.getRealname());
			} else {
				organization.setLeaderId(null);
			}
		}

		organizationRepo.saveAndFlush(organization);

		if (null != organization.getParent()
				&& null != organization.getParent().getId()) {
			organization.setPathId(organization.getParent().getId() + "/"
					+ organization.getId());
		} else {
			organization.setPathId("/" + organization.getId());
		}

		return organization.getId();
	}

	/**
	 * 更新部门<br>
	 * 
	 * <pre>
	 * 1、是否修改了名称
	 * 2、该部门是否顶级部门
	 * 3、是否修改了负责人
	 * 4、用户所在部门
	 * </pre>
	 * 
	 * @param organization
	 */
	@Transactional
	public void update(Organization organization) {
		Organization dbOrganization = organizationRepo.findOne(organization
				.getId());

		// 修改部门名称
		if (!organization.getName().equals(dbOrganization.getName())) {
			dbOrganization.setName(organization.getName());
			dbOrganization.setCode(organization.getName());
			dbOrganization.setUpdated(new Date());
			String oldPath = dbOrganization.getPath();
			String newPath = "";
			List<Organization> subOrganizations = organizationRepo
					.findByPathLike(oldPath + "/%");
			if (null != dbOrganization.getParent()) {
				newPath = dbOrganization.getParent().getPath() + "/"
						+ dbOrganization.getName();
			} else {
				newPath = "/" + dbOrganization.getName();
			}

			dbOrganization.setPath(newPath);
			for (Organization sub : subOrganizations) {
				String subPath = sub.getPath();
				subPath = subPath.replaceFirst(oldPath, newPath);
				sub.setPath(subPath);
			}
			organizationRepo.save(dbOrganization);
			organizationRepo.save(subOrganizations);

			List<User> users = userRepo.findByOrganizationId(dbOrganization
					.getId());
			for (User user : users) {
				user.setOrganizationName(dbOrganization.getName());
				user.setOrganizationPath(newPath);
			}
			userRepo.save(users);
		}

		if (null == organization.getLeaderId()
				&& null != dbOrganization.getLeaderId()) {
			dbOrganization.setLeaderId(null);
			dbOrganization.setLeaderName(null);
			organizationRepo.save(dbOrganization);
		} else if (null != organization.getLeaderId()
				&& organization.getLeaderId() != dbOrganization.getLeaderId()) {
			User user = userRepo.getOne(organization.getLeaderId());
			organization.setLeaderName(user.getRealname());
			organizationRepo.save(dbOrganization);
		}

	}

	/**
	 * 获取部门信息
	 * 
	 * @param id
	 * @return
	 */
	public Organization get(Long id) {
		Organization organization = organizationRepo.findOne(id);
		if (null == organization || -1 == organization.getState()) {
			throw new BussinessException("organization_not_found_exception",
					"该部门不存在或者已经被删除");
		}
		return organization;
	}

	/**
	 * 移动部门<br>
	 * 
	 * <pre>
	 * 1、是否顶级部门
	 * 2、是否有子部门
	 * 3、维护Path, PathId, Level
	 * 4、维护用户所在部门的Path
	 * 
	 * 所以这个业务如果子部门较多，或者关联的用户较多，业务相对来说很慢。
	 * 如果简便这个业务就是只能移动没有子部门的节点，但是这样相对来说不太友好，
	 * 计算机的处理能力肯定比人快很多，这个功能不常用，也不建议使用。
	 * 
	 * </pre>
	 * 
	 * @param id
	 * @param targetId
	 */
	@Transactional
	public void move(Long id, Long targetId) {
		// 移动到顶级部门
		if (null == targetId) {
			Organization dbOrg = organizationRepo.getOne(id);
			String oldPath = dbOrg.getPath();
			String oldPathId = dbOrg.getPathId();
			String newPath = "/" + dbOrg.getName();
			String newPathId = "/" + dbOrg.getId();
			Integer minusLevel = dbOrg.getLevel() - 1;
			dbOrg.setLevel(1);
			dbOrg.setPath(newPath);
			dbOrg.setPathId(newPathId);

			List<User> users = userRepo.findByOrganizationId(dbOrg.getId());
			for (User user : users) {
				user.setOrganizationPath(dbOrg.getPath());
			}
			userRepo.save(users);

			List<Organization> subOrganizations = organizationRepo
					.findByPathLike(oldPath + "/%");
			for (Organization sub : subOrganizations) {
				String subPath = sub.getPath();
				String subPathId = sub.getPathId();
				subPath = subPath.replaceFirst(oldPath, newPath);
				subPathId = subPathId.replaceFirst(oldPathId, newPathId);
				sub.setPath(subPath);
				sub.setPathId(subPathId);
				sub.setLevel(sub.getLevel() - minusLevel);

				List<User> subUsers = userRepo.findByOrganizationId(dbOrg
						.getId());
				for (User user : subUsers) {
					user.setOrganizationPath(sub.getPath());
				}
				userRepo.save(subUsers);
			}
			organizationRepo.save(dbOrg);
			organizationRepo.save(subOrganizations);
			return;
		}

		// 不能移动到子部门下
		Organization dbOrg = organizationRepo.getOne(id);
		Organization dbTargetOrg = organizationRepo.getOne(targetId);
		if (null == dbTargetOrg || -1 == dbTargetOrg.getState()) {
			throw new BussinessException("target_organization_not_found",
					"目标部门不存在或者已经被删除");
		}
		if (dbTargetOrg.getPathId().contains(dbOrg.getPathId() + "/")) {
			throw new BussinessException(
					"target_organization_not_subOrganization", "目标部门不能是其子部门");
		}

		String oldPath = dbOrg.getPath();
		String oldPathId = dbOrg.getPathId();
		String newPath = dbTargetOrg.getPath() + "/" + dbOrg.getName();
		String newPathId = dbTargetOrg.getPathId() + "/" + dbOrg.getId();

		List<User> users = userRepo.findByOrganizationId(dbOrg.getId());
		for (User user : users) {
			user.setOrganizationPath(dbOrg.getPath());
		}
		userRepo.save(users);

		List<Organization> subOrganizations = organizationRepo
				.findByPathLike(oldPath + "/%");
		for (Organization sub : subOrganizations) {
			String subPath = sub.getPath();
			String subPathId = sub.getPathId();
			subPath = subPath.replaceFirst(oldPath, newPath);
			subPathId = subPathId.replaceFirst(oldPathId, newPathId);
			sub.setPath(subPath);
			sub.setPathId(subPathId);

			List<User> subUsers = userRepo.findByOrganizationId(dbOrg.getId());
			for (User user : subUsers) {
				user.setOrganizationPath(sub.getPath());
			}
			userRepo.save(subUsers);
		}
		organizationRepo.save(dbOrg);
		organizationRepo.save(subOrganizations);
	}

	/**
	 * 删除部门：状态：-1
	 * 
	 * @param id
	 */
	@Transactional
	public void delete(Long id) {
		Organization dbOrg = organizationRepo.getOne(id);
		if (null == dbOrg) {
			throw new BussinessException("organization_not_exist", "部门不存在");
		}
		String oldPath = dbOrg.getPath();

		dbOrg.setState(-1);
		List<User> users = userRepo.findByOrganizationId(dbOrg.getId());
		for (User user : users) {
			user.setOrganizationId(null);
			user.setOrganizationName(null);
			user.setOrganizationPath(null);
		}
		userRepo.save(users);
		List<Organization> subOrganizations = organizationRepo
				.findByPathLike(oldPath + "/%");
		for (Organization sub : subOrganizations) {
			sub.setState(-1);
			List<User> subUsers = userRepo.findByOrganizationId(dbOrg.getId());
			for (User user : subUsers) {
				user.setOrganizationId(null);
				user.setOrganizationName(null);
				user.setOrganizationPath(null);
			}
			userRepo.save(subUsers);
		}
		organizationRepo.save(dbOrg);
		organizationRepo.save(subOrganizations);
	}

}
