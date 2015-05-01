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
import uaas.exception.BussinessException;
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
		List<App> apps = appService.findAll();
		Page<Role> roles = roleService.list(criteria);
		mm.addAttribute("apps", apps);
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
		log.debug("===============role.app" + role.getApp().getId());
		log.debug("===============role.name" + role.getName());
		try {
			roleService.create(role);
			mm.addAttribute("info", "角色（" + role.getId() + "）创建成功");
			mm.addAttribute("role", role);
		} catch (BussinessException e) {
			mm.addAttribute("error", e);
			mm.addAttribute("role", role);
			return "/role/create";
		}
		return "/role/info";
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable Long id, ModelMap mm) {
		try {
			Role role = roleService.get(id);
			mm.addAttribute("role", role);
		} catch (BussinessException e) {
			mm.addAttribute("error", e);
			log.info("修改角色获取失败：" + id);
		}
		return "/role/update";
	}

	@RequestMapping("/modify")
	public String modify(Role role, ModelMap mm) {
		try {
			roleService.update(role);
			mm.addAttribute("role", role);
			mm.addAttribute("info", "角色（" + role.getId() + "）更新成功");
			log.info("成功更新应用：" + role.getId());
		} catch (BussinessException e) {
			mm.addAttribute("error", e);
			mm.addAttribute("role", role);
			log.info("更新应用失败：" + role.getId());
			return "/role/update";
		}

		return "/role/info";
	}

	@RequestMapping("/info/{id}")
	public String info(@PathVariable Long id, ModelMap mm) {
		try {
			Role role = roleService.get(id);
			mm.addAttribute("role", role);
		} catch (BussinessException e) {
			mm.addAttribute("error", e);
			log.info("获取角色失败：" + id);
		}
		return "/role/info";
	}
}
