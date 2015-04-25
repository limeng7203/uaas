package uaas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/organization")
public class OrganizationController {

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
	 * 创建部门
	 * 
	 * @return
	 */
	@RequestMapping("/create")
	public String create() {
		return "/organization/index";
	}

}
