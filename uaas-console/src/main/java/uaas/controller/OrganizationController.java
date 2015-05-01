package uaas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uaas.domain.Organization;
import uaas.exception.BussinessException;
import uaas.service.OrganizationService;

@Controller
@RequestMapping("/organization")
public class OrganizationController {
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private OrganizationService organizationService;

	/**
	 * 部门首页
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public String index() {
		return "/organization/index";
	}

	/**
	 * 创建部门页面
	 * 
	 * @return
	 */
	@RequestMapping("/create")
	public String create(ModelMap mm) {
		Organization organization = new Organization();
		Organization parent = new Organization();
		organization.setParent(parent);
		mm.addAttribute("organization", organization);
		return "/organization/create";
	}

	/**
	 * 存储部门信息
	 * 
	 * @param organization
	 * @param mm
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Organization organization, ModelMap mm) {
		try {
			organizationService.create(organization);
			mm.addAttribute("organization", organization);
		} catch (BussinessException e) {
			mm.addAttribute("error", e);
			mm.addAttribute("organization", organization);
			log.info("创建应用失败！");
		}

		return "/organization/info";
	}

	@RequestMapping("/info/{id}")
	public String info(@PathVariable Long id, ModelMap mm) {
//		Organization organization = organizationService.get(id);
		return "/organization/info";
	}

}
