package com.thinkgem.jeesite.common.dao;

import java.util.List;

import com.thinkgem.jeesite.common.entity.InseranceRule;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
@MyBatisDao
public interface InseranceRuleMapper {
    int deleteByPrimaryKey(String id);

    int insert(InseranceRule record);

    int insertSelective(InseranceRule record);

    InseranceRule selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InseranceRule record);

    int updateByPrimaryKey(InseranceRule record);

	List<InseranceRule> findList(InseranceRule entity);//保险规则制定---崔亚光
}