package uaas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uaas.domain.Role;
import uaas.repo.RoleRepo;

@Service
public class RoleService {
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private RoleRepo roleRepo;

	public Long create(Role role) {
		role.setCode(role.getName());
		role.setState(1);
		roleRepo.save(role);
		return role.getId();
	}

}
