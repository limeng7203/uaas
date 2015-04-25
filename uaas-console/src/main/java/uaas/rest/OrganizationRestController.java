package uaas.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uaas.service.OrganizationService;
import uaas.service.rest.OrganizationVO;

@RestController
@RequestMapping("/org/rest")
public class OrganizationRestController {
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private OrganizationService organizationService;
	
	public List<OrganizationVO> findAll() {
		log.info("获取所有部门");
		List<OrganizationVO> organizations = organizationService.findAll();
		return organizations;
	}
	
}
