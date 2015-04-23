package uaas.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import uaas.domain.App;
import uaas.domain.Role;
import uaas.exception.BussinessException;
import uaas.repo.AppRepo;
import uaas.repo.ComplexQueryRepo;
import uaas.repo.RoleRepo;
import uaas.service.criteria.RoleCriteria;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class RoleService {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private RoleRepo roleRepo;
	@Autowired
	private AppRepo appRepo;
	@Autowired
	private ComplexQueryRepo complexQueryRepo;

	/**
	 * 创建角色
	 * 
	 * @param role
	 * @return
	 */
	@Transactional
	public Long create(Role role) {
		log.info("创建角色");

		role.setCode(role.getName());
		role.setState(1);
		App app = appRepo.findByIdAndStateNot(role.getApp().getId(), -1);
		role.setCreated(new Date());
		role.setUpdated(new Date());
		role.setApp(app);
		roleRepo.save(role);
		return role.getId();
	}

	public Page<Role> list(RoleCriteria criteria) {
		PageHelper.startPage(criteria.getPage(), criteria.getSize());
		List<Role> roles = complexQueryRepo.findRoleByCriteriaTotal(criteria);
		PageInfo<Role> page = new PageInfo<Role>(roles);
		return new PageImpl<Role>(roles, new PageRequest(criteria.getPage(),
				criteria.getSize()), page.getTotal());
	}

	/**
	 * 获取角色
	 * 
	 * @param id
	 * @return
	 */
	public Role get(Long id) {
		Role role = roleRepo.findByIdAndStateNot(id, -1);
		if (null == role) {
			throw new BussinessException("role_not_found_exception",
					"该角色不存在或者已经被删除");
		}
		return role;
	}

	/**
	 * 修改角色
	 * 
	 * @param role
	 */
	@Transactional
	public void update(Role role) {
		Role dbRole = roleRepo.findOne(role.getId());
		if (-1 == dbRole.getState()) {
			throw new BussinessException("role_deleted_exception", "该角色已经被删除");
		}
		App app = appRepo.getOne(role.getId());
		if (-1 == app.getState()) {
			throw new BussinessException("app_deleted_exception",
					"该角色关联的应用已经被删除");
		}
		dbRole.setApp(app);
		dbRole.setName(role.getName());
		dbRole.setCode(role.getName());
		dbRole.setUpdated(new Date());
	}

	/**
	 * 启用/禁用角色
	 * 
	 * @param id
	 */
	@Transactional
	public void enabled(Long id) {
		Role role = roleRepo.findOne(id);

		if (null == role) {
			throw new BussinessException("role_not_exist", "应用不存在");
		}

		if (0 == role.getState()) {
			role.setState(1);
		} else {
			role.setState(0);
		}
	}

	/**
	 * 删除角色
	 * 
	 * @param id
	 */
	@Transactional
	public void delete(Long id) {
		Role dbRole = roleRepo.findOne(id);
		dbRole.setState(-1);
		roleRepo.save(dbRole);
	}

}
