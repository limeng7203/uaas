package uaas.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	public void enabled(Long id) {
		try {
			appService.enabled(id);
			log.info("改变应用状态：" + id);
		} catch (BussinessException e) {
			log.info("更新应用失败：" + id);
		}
	}

	@RequestMapping("/delete/{id}")
	public void delete(Long id) {
		try {
			appService.delete(id);
		} catch (BussinessException e) {
			log.info("删除应用失败：" + id);
		}
	}

}
