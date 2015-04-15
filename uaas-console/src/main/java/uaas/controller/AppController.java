package uaas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import uaas.domain.App;
import uaas.service.AppService;

@Controller
@RequestMapping("/app")
public class AppController {
	@Autowired
	private AppService appService;

	/**
	 * 首页
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public ModelAndView index(int page, int size) {
		ModelAndView mav = new ModelAndView("/app/index");
		Page<App> apps = appService.list(page, size);
		mav.addObject("page", apps);
		return mav;
	}

}
