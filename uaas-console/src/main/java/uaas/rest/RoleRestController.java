package uaas.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uaas.exception.BussinessException;
import uaas.service.RoleService;

@RestController
@RequestMapping("/role/rest")
public class RoleRestController {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private RoleService roleService;

	/**
	 * 改变状态
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/enabled/{id}")
	public Boolean enabled(@PathVariable Long id) {
		try {
			roleService.enabled(id);
			log.info("改变角色状态：" + id);
			return true;
		} catch (BussinessException e) {
			log.info("更新角色状态失败：" + id);
			return false;
		}
	}

	/**
	 * 删除角色
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	public Boolean delete(@PathVariable Long id) {
		try {
			roleService.delete(id);
			log.info("删除角色：" + id);
			return true;
		} catch (BussinessException e) {
			log.info("删除角色失败：" + id);
			return false;
		}
	}

}
