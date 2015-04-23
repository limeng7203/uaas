package uaas.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import uaas.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

	Page<Role> findByStateNot(int i, Pageable pageable);

	Role findByIdAndStateNot(Long id, int i);

	List<Role> findByAppId(Long id);

}
