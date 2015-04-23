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

import uaas.domain.Role;
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
		role.setCreated(new Date());
		role.setUpdated(new Date());
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

}
