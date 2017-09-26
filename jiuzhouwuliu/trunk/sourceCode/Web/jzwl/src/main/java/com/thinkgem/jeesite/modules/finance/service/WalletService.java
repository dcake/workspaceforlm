package com.thinkgem.jeesite.modules.finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.dao.UsersAccountOperateMapper;
import com.thinkgem.jeesite.common.entity.UsersAccountOperate;
import com.thinkgem.jeesite.common.persistence.Page;
/**
 * @description	钱包管理
 * @author 文帅
 * @date 2017年8月9日 上午10:30:05
 */
@Service
@Transactional
public class WalletService {
	@Autowired
	private UsersAccountOperateMapper usersAccountOperateMapper;
	
	/**
	 * @description	查询钱包明细分页
	 * @author 文帅
	 * @date 2017年8月9日 上午10:32:14
	 * @param page
	 * @param users
	 * @return
	 */
	public Page<UsersAccountOperate> findListByUserId(Page<UsersAccountOperate> page, UsersAccountOperate  usersAccountOperate) {
		usersAccountOperate.setPage(page);
		page.setList(usersAccountOperateMapper.findListByUserId(usersAccountOperate));
		return page;	
	}
	
	/**
	 * @description	根据用户ID查询钱包明细
	 * @author 文帅
	 * @date 2017年8月14日 下午5:26:05
	 * @return
	 */
	public List<UsersAccountOperate> findList(UsersAccountOperate usersAccountOperate){
		return usersAccountOperateMapper.findListByUserId(usersAccountOperate);
	}
}
