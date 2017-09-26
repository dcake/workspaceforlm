package com.thinkgem.jeesite.modules.rule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.dao.UsersMapper;
import com.thinkgem.jeesite.common.entity.Users;
import com.thinkgem.jeesite.common.persistence.Page;

/** 
 * @author 作者:cuiyg
 * @version 创建时间：2017年8月7日 上午11:37:43 
 * 类说明: 分级管理service
 */
@Service("gradedMangerService")
@Transactional(readOnly=true)
public class GradedMangerService {
	@Autowired
	private UsersMapper usersMapper;
	/**
	 * 功能：分类管理分页
	 * 创-建人：崔亚光
	 * 日期：2017-08-07
	 */
	public Page<Users> findPage(Page<Users> page, Users users) {
		users.setPage(page);
		page.setList(usersMapper.findList(users));
		return page;
	}
	/**
	 * 获取货主/车主实体
	 * 崔亚光
	 * 2017-08-09
	 * @param id
	 * @return
	 */
	public Users getUser(String id) {
		return usersMapper.selectByPrimaryKey(id);
	}
	/**
	 * 功能：保存分级管理编辑信息
	 * 作者：崔亚光
	 * 日期：2017-08-09
	 * @param id
	 * @return
	 */
	@Transactional(readOnly=false)
	public void save(Users users) {
		usersMapper.updateLevel(users);
	}
	/**
	 * 获取货主/车主详情
	 * 崔亚光
	 * 2017-08-09
	 * @param id
	 * @return
	 */
	public Users getInfo(String id) {
		return usersMapper.getInfo(id);
	}
	
}
