package com.thinkgem.jeesite.modules.users.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.thinkgem.jeesite.common.dao.DriverMasterChangeMapper;
import com.thinkgem.jeesite.common.entity.DriverMasterChange;
import com.thinkgem.jeesite.common.persistence.Page;
/**
 * 
 * @author wanghan
 *
 */
@Service
public class CaptainTransferService {
	@Resource
	private DriverMasterChangeMapper driverMasterChangeMapper;
	/**
	 * 查询车队长身份转让审核列表
	 */
	public Page<DriverMasterChange> findPage(Page<DriverMasterChange> page, DriverMasterChange driverMasterChange){
		
		driverMasterChange.setPage(page);
	    List<DriverMasterChange> list = driverMasterChangeMapper.selectDriverMasterChange(driverMasterChange);
		page.setList(list);
		return page;
	}
	/**
	 * 审核列表
	 */
	public DriverMasterChange selectDetail(String id){
		DriverMasterChange select = driverMasterChangeMapper.selectDetail(id);
		return select;
	}
	/**
	 * 发布转让审核
	 *   
	 */
	public void bidAuditCheck(DriverMasterChange driverMasterChange){
		driverMasterChange.preUpdate();
		driverMasterChange.setUpdateDate(new Date());
		driverMasterChangeMapper.updateByPrimaryKeySelective(driverMasterChange);
	}
}
