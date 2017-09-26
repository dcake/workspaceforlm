package com.thinkgem.jeesite.modules.rule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.dao.InseranceRuleMapper;
import com.thinkgem.jeesite.common.entity.InseranceRule;
import com.thinkgem.jeesite.common.persistence.Page;

/** 
 * @author 作者:cuiyg
 * @version 创建时间：2017年8月8日 下午2:17:51 
 * 类说明: 平台垫资付款设置service
 */
@Service("inseranceRuleService")
@Transactional
public class InseranceRuleService {
	@Autowired
	private InseranceRuleMapper inseranceRuleMapper;

	
	/**
	 * 功能：保险规则制定分页
	 * 作者：崔亚光
	 * 日期：2017-08-08
	 */
	public Page<InseranceRule> findPage(Page<InseranceRule> page,
			InseranceRule entity) {
		entity.setPage(page);
		page.setList(inseranceRuleMapper.findList(entity));
		return page;
	}


}
