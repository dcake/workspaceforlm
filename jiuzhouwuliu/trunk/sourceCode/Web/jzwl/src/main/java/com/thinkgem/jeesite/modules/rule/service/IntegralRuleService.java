package com.thinkgem.jeesite.modules.rule.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.dao.IntegralRuleMapper;
import com.thinkgem.jeesite.common.entity.IntegralRule;
import com.thinkgem.jeesite.common.utils.IdGen;

/** 
 * @author 作者:cuiyg
 * @version 创建时间：2017年8月7日 下午5:05:36 
 * 类说明: 积分管理Service
 */
@Service("integralRuleService")
@Transactional(readOnly=true)
public class IntegralRuleService {
	@Autowired
	private IntegralRuleMapper integralRuleMapper;
	
	/**
	 * 获取积分管理实体
	 * 崔亚光
	 * 2017-08-07
	 * @return
	 */
	public IntegralRule getIntegralRule() {
		return integralRuleMapper.findEntity();
	}
	/**
	 * 保存积分管理
	 * 崔亚光
	 * 2017-08-07
	 * @return
	 */
	@Transactional(readOnly=false)
	public void save(IntegralRule entity) {
		if(StringUtils.isNotBlank(entity.getId())){
		entity.preUpdate();
		integralRuleMapper.updateSelective(entity);
		}else{
			entity.setId(IdGen.uuid());
			entity.preInsert();
			integralRuleMapper.insert(entity);
		}
	}

}
