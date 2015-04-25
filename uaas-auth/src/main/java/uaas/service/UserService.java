package uaas.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uaas.domain.User;
import uaas.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;

	@Transactional
	public void create(User user) {
		userRepo.saveAndFlush(user);
		user.setPath("/" + user.getId());
	}

}
