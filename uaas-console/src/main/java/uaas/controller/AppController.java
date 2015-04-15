package uaas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import uaas.domain.App;
import uaas.exception.BussinessException;
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
	public ModelAndView index(Integer page, Integer size) {
		ModelAndView mav = new ModelAndView("/app/index");
		Page<App> apps = appService.list((null == page ? 0 : page),
				(null == size ? 20 : size));
		mav.addObject("page", apps);
		return mav;
	}

	@RequestMapping("/create")
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView("/app/create");
		mav.addObject("app", new App());
		return mav;
	}

	@RequestMapping("/save")
	public ModelAndView save(App app) {
		ModelAndView mav = new ModelAndView("/app/create");
		mav.addObject(new BussinessException("aa", "bb"));
		mav.addObject("app", app);
//		throw new BussinessException("aa", "bb");
		return mav;
	}

}
