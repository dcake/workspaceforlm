package com.thinkgem.jeesite.common.dao;

import com.thinkgem.jeesite.common.entity.IntegralRule;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
@MyBatisDao
public interface IntegralRuleMapper {
    int insert(IntegralRule record);
    //获取积分管理实体===崔亚光
    IntegralRule findEntity();
    int insertSelective(IntegralRule record);
    void updateSelective(IntegralRule record);//保存积分管理实体===崔亚光
}