package uaas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uaas.domain.Role;
import uaas.service.RoleService;

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

	@RequestMapping("/")
	public String index(Integer page, Integer size) {

		return null;
	}

	@RequestMapping("/create")
	public String create(ModelMap mm) {
		log.info("创建角色");
		
		mm.addAttribute("role", new Role());
		return "/role/create";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Role role, ModelMap mm) {

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
