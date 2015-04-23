package uaas.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uaas.domain.Resource;

public interface ResourceRepo extends JpaRepository<Resource, Long> {

	List<Resource> findByAppId(Long id);

}
