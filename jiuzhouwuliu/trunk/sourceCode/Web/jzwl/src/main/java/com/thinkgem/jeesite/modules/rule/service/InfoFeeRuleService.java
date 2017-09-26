package com.thinkgem.jeesite.modules.rule.service;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.dao.InfoFeeRuleMapper;
import com.thinkgem.jeesite.common.entity.InfoFeeRule;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/** 
 * @author 作者:cuiyg
 * @version 创建时间：2017年8月8日 上午10:20:44 
 * 类说明: 信息费设置service
 */
@Service("infoFeeRuleService")
@Transactional(readOnly=true)
public class InfoFeeRuleService {
	@Autowired
	private InfoFeeRuleMapper infoFeeRuleMapper;

	
	/**
	 * 信息费设置分页
	 * 崔亚光
	 * 时间：2017-08-08
	 */
	public Page<InfoFeeRule> findPage(Page<InfoFeeRule> page, InfoFeeRule entity) {
		entity.setPage(page);
		page.setList(infoFeeRuleMapper.findList(entity));
		return page;
	}
	 /**
		 * 新建规则保存
		 * 崔亚光
		 * 时间：2017-08-08
		 */
	@Transactional(readOnly=false)
	public void save(InfoFeeRule entity) {
		if(StringUtils.isNotBlank(entity.getId())){
			 entity.setUpdateBy(UserUtils.getUser().getLoginName());
			 entity.setUpdateDate(new Date());
			 infoFeeRuleMapper.updateByPrimaryKeySelective(entity);
		}else{
			 entity.setId(IdGen.uuid());
			 entity.setCreateBy(UserUtils.getUser().getLoginName());
			 entity.setCreateDate(new Date());
			 entity.setUpdateBy(UserUtils.getUser().getLoginName());
			 entity.setUpdateDate(new Date());
			 infoFeeRuleMapper.insert(entity);
		}
		
	}
	/**
	 * 获取信息费实体
	 * 崔亚光
	 * 2017-08-09
	 * @param id
	 * @return
	 */
	public InfoFeeRule getInfo(String id) {
		return infoFeeRuleMapper.selectByPrimaryKey(id);
	}
	 /**
	  * 删除
	  * 崔亚光
	  * 2017-08-16
	  */
	@Transactional(readOnly=false)
	public void delete(String id) {
		infoFeeRuleMapper.deleteByPrimaryKey(id);
	}
	
}
