package uaas.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 * 
 * @author percy
 *
 */
@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(HttpServletResponse response) {
		
		
		return "index";
	}

}
