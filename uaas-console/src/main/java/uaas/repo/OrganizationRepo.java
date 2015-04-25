package uaas.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uaas.domain.Organization;

public interface OrganizationRepo extends JpaRepository<Organization, Long> {

	@Query("from Organization org where org.parent.id = ?1 and org.name = ?2 and org.state != ?3")
	List<Organization> findByParentIdAndNameAndStateNot(Long id, String name, Integer state);

	List<Organization> findByPathLike(String path);

}
