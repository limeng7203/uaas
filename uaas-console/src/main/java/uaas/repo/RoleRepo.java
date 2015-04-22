package uaas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import uaas.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

}
