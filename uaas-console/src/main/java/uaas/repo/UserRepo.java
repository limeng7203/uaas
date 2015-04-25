package uaas.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uaas.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {

	List<User> findByOrganizationId(Long id);

}
