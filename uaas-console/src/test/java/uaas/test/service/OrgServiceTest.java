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
import uaas.domain.Organization;
import uaas.repo.OrganizationRepo;
import uaas.service.OrganizationService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WebConfig.class)
@WebAppConfiguration
@TransactionConfiguration(defaultRollback = false)
public class OrgServiceTest {

	@Autowired
	OrganizationService organizationService;
	
	@Autowired
	OrganizationRepo organizationRepo;

	@Test
	public void testCreate() {
		Organization organization = new Organization();
		organization.setName("test");
		organizationService.create(organization);
	}
	
	@Test
	public void testFindByPath() {
		List<Organization> organizations= organizationRepo.findByPathLike("%test%");
		System.out.println("========" + organizations.size());
	}

}
