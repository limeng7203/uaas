package uaas.test.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import uaas.config.WebConfig;
import uaas.domain.App;
import uaas.service.AppService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WebConfig.class)
@WebAppConfiguration
@TransactionConfiguration(defaultRollback = false)
public class AppServiceTest {
	@Autowired
	private AppService appService;
	
	@Test
	public void testFindAll() {
		List<App> apps = appService.findAll();
		System.out.println(apps.size());
	}
	
	@Test
	public void testCreate() {
		App app = new App();
		app.setCode("uaas");
		app.setName("uaas");
		app.setUrl("http://uaas/");
		app.setSecret("123456");
		appService.create(app);
	}
	
}
