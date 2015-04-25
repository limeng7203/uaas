package uaas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import uaas.domain.Organization;

public interface OrganizationRepo extends JpaRepository<Organization, Long> {

}
