package uaas.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import uaas.domain.App;

public interface AppRepo extends JpaRepository<App, Long> {

	Page<App> findByStateNot(Integer state, Pageable pageable);

	App findByName(String name);

	App findByCode(String code);

}
