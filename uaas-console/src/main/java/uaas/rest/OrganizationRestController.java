package uaas.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uaas.exception.BussinessException;
import uaas.service.OrganizationService;
import uaas.service.rest.OrganizationVO;

@RestController
@RequestMapping("/org/rest")
public class OrganizationRestController {
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private OrganizationService organizationService;

	@RequestMapping(name = "/findAll")
	public List<OrganizationVO> findAll() {
		log.info("获取所有部门");
		try {
			List<OrganizationVO> organizations = organizationService.findAll();
			return organizations;
		} catch (BussinessException e) {
			log.error("获取所有部门出错：" + e.getMessage(), e.getCause());
			try {
				throw new Exception("业务异常：", e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (Exception e) {
			try {
				throw new Exception("未知异常：", e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return new ArrayList<OrganizationVO>();
	}

}
