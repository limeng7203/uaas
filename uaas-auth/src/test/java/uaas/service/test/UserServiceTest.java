package uaas.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import uaas.config.WebConfig;
import uaas.domain.User;
import uaas.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WebConfig.class)
@WebAppConfiguration
@TransactionConfiguration(defaultRollback = false)
public class UserServiceTest {
	@Autowired
	private UserService userService;
	
	@Test
	public void testCreate() {
		User user = new User();
		user.setUsername("esa232");
		userService.create(user);
	}
	

}
