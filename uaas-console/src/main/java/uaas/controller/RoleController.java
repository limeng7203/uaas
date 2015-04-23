package uaas.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uaas.domain.App;
import uaas.domain.Role;
import uaas.service.AppService;
import uaas.service.RoleService;
import uaas.service.criteria.RoleCriteria;

/**
 * 角色
 * 
 * @author percy
 *
 */
@Controller
@RequestMapping("/role")
public class RoleController {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private RoleService roleService;
	@Autowired
	private AppService appService;

	@RequestMapping("/")
	public String index(RoleCriteria criteria, ModelMap mm) {
		Page<Role> roles = roleService.list(criteria);
		mm.addAttribute("page", roles);
		log.info("角色首页");
		return "/role/index";
	}

	@RequestMapping("/create")
	public String create(ModelMap mm) {
		log.info("创建角色页面");
		List<App> apps = appService.findAll();
		mm.addAttribute("apps", apps);
		mm.addAttribute("role", new Role());
		return "/role/create";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Role role, ModelMap mm) {
		roleService.create(role);
		return "/role/info";
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable Long id) {
		return null;
	}

	@RequestMapping("/modify")
	public String modify(Role role, ModelMap mm) {
		return null;
	}
}
