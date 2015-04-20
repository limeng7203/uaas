package uaas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uaas.domain.App;
import uaas.exception.BussinessException;
import uaas.service.AppService;

/**
 * 应用控制器<br>
 * 
 * <pre>
 * 这个章节练习大家的ModelAndView使用，
 * 我会在其他章节使用简便方法，直接返回字符串的方式专项不同视图。
 * 
 * Spring中可以使用两个简便方式：
 * 1、forward
 * 2、redirect
 * 
 * forward：
 *   return "forward:/hello" => 转发到能够匹配 /hello 的 controller 上  
 *   return "hello" => 实际上还是转发，只不过是框架会找到该逻辑视图名对应的 View 并渲染  
 *   return "/hello" => 同 return "hello" 
 *   return "forward:/hello"; 
 * 
 * redirect:
 *      重定向到 /hello 资源  
 *      return "redirect:/hello"; 
 * 
 * forward内部转发，地址栏不改变
 * redirect浏览器请求，地址栏改变
 * 
 * </pre>
 * 
 * 
 * @author percy
 *
 */
@Controller
@RequestMapping("/app")
public class AppController {
	private Logger log = LoggerFactory.getLogger(getClass());
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

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(App app) {
		ModelAndView mav = new ModelAndView("/app/info");
		try {
			appService.create(app);
			mav.addObject("app", app);
			mav.addObject("info", "应用（" + app.getId() + "）创建成功");
		} catch (BussinessException e) {
			mav = new ModelAndView("/app/create");
			mav.addObject("error", e);
			mav.addObject("app", app);
		}
		return mav;
	}

	@RequestMapping("/info/{id}")
	public ModelAndView info(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("/app/info");
		try {
			App app = appService.get(id);
			mav.addObject("app", app);
		} catch (BussinessException e) {
			mav.addObject("error", e);
		}
		return mav;
	}

	@RequestMapping("/update/{id}")
	public ModelAndView update(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("/app/update");
		App app = appService.get(id);
		mav.addObject("app", app);
		return mav;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView modify(App app) {
		ModelAndView mav = new ModelAndView("/app/info");
		try {
			appService.update(app);
			mav.addObject("app", app);
			mav.addObject("info", "应用（" + app.getId() + "）更新成功");
		} catch (BussinessException e) {
			mav = new ModelAndView("/app/update");
			mav.addObject("error", e);
			mav.addObject("app", app);
		}
		return mav;
	}

	/**
	 * 根据名称模糊查询
	 * 
	 * @param name
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping("/queryByName")
	public ModelAndView queryByName(String name, Integer page, Integer size) {
		ModelAndView mav = new ModelAndView("/app/index");
		Page<App> apps = appService.findByNameLike(name, (null == page ? 0
				: page), (null == size ? 20 : size));
		mav.addObject("page", apps);
		log.debug("apps" + apps.getContent().size());
		return mav;
	}

}
