package com.thinkgem.jeesite.common.dao;

import com.thinkgem.jeesite.common.entity.AgentDeal;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface AgentDealMapper {
    int deleteByPrimaryKey(String id);

    int insert(AgentDeal record);

    int insertSelective(AgentDeal record);

    AgentDeal selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AgentDeal record);

    int updateByPrimaryKey(AgentDeal record);
}