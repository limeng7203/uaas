package uaas.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uaas.exception.BussinessException;
import uaas.service.AppService;

@RestController
@RequestMapping("/app/rest")
public class AppRestController {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private AppService appService;

	@RequestMapping("/enabled/{id}")
	public Boolean enabled(@PathVariable Long id) {
		try {
			appService.enabled(id);
			log.info("改变应用状态：" + id);
			return true;
		} catch (BussinessException e) {
			log.info("更新应用失败：" + id);
			return false;
		}
	}

	@RequestMapping("/delete/{id}")
	public Boolean delete(@PathVariable Long id) {
		try {
			appService.delete(id);
			log.info("删除应用：" + id);
			return true;
		} catch (BussinessException e) {
			log.info("删除应用失败：" + id);
			return false;
		}
	}

}
