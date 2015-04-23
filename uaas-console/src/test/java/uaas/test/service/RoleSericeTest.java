package uaas.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import uaas.config.WebConfig;
import uaas.domain.App;
import uaas.domain.Role;
import uaas.service.AppService;
import uaas.service.RoleService;
import uaas.service.criteria.RoleCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WebConfig.class)
@WebAppConfiguration
@TransactionConfiguration(defaultRollback = false)
public class RoleSericeTest {
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private AppService appService;
	
	@Test
	public void testList() {
		RoleCriteria creiteria = new RoleCriteria();
		Page<Role> roles = roleService.list(creiteria);
		System.out.println(roles.getTotalElements());
	}

	@Test
	public void testCreate() {
		
//		App app = new App();
//		app.setCode("uaas12");
//		app.setName("uaas12");
//		app.setUrl("http://uaas1/");
//		app.setSecret("123456");
//		appService.create(app);
		App app = new App();
		app.setId(1L);
		Role role = new Role();
		role.setApp(app);
		role.setName("admin中国");
		roleService.create(role);
	}
}
