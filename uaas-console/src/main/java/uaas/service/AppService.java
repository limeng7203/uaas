package uaas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import uaas.domain.App;
import uaas.repo.AppRepo;

@Service
public class AppService {

	@Autowired
	private AppRepo appRepo;

	public Page<App> list(int page, int size) {
		Page<App> apps = appRepo
				.findByStateNot(-1, new PageRequest(page, size));
		return apps;
	}

}
