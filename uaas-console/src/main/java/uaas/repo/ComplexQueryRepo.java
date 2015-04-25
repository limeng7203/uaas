package uaas.repo;

import java.util.List;

import uaas.domain.Role;
import uaas.service.criteria.RoleCriteria;
import uaas.service.rest.OrganizationVO;

/**
 * 综合复杂查询<br>
 * 
 * 
 * @author percy
 *
 */
public interface ComplexQueryRepo {

	/**
	 * 查询角色
	 * 
	 * @param criteria
	 * @return
	 */
	List<Role> findRoleByCriteriaTotal(RoleCriteria criteria);

	/**
	 * 获取所有部门
	 * 
	 * @return
	 */
	List<OrganizationVO> findAllOrganiation();

}
