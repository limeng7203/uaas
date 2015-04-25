package uaas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uaas.repo.ComplexQueryRepo;
import uaas.repo.OrganizationRepo;
import uaas.service.rest.OrganizationVO;

@Service
public class OrganizationService {
	@Autowired
	private OrganizationRepo organizationRepo;
	@Autowired
	private ComplexQueryRepo complexQueryRepo;
	
	/**
	 * 获取所有部门
	 * 
	 * @return
	 */
	public List<OrganizationVO> findAll() {
		List<OrganizationVO> organizations = complexQueryRepo.findAllOrganiation();
		return organizations;
	}

}
