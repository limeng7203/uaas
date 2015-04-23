package uaas.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import uaas.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

	Page<Role> findByStateNot(int i, Pageable pageable);

}
