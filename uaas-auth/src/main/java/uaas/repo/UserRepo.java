package uaas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import uaas.domain.User;

public interface UserRepo extends JpaRepository<User, Long>{

}
