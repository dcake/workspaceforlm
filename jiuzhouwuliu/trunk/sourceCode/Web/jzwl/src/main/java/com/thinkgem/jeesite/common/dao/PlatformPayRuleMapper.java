package com.thinkgem.jeesite.common.dao;

import java.util.List;

import com.thinkgem.jeesite.common.entity.PlatformPayRule;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
@MyBatisDao
public interface PlatformPayRuleMapper {
    int deleteByPrimaryKey(String id);

    int insert(PlatformPayRule record);

    int insertSelective(PlatformPayRule record);

    PlatformPayRule selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PlatformPayRule record);

    int updateByPrimaryKey(PlatformPayRule record);

	List<PlatformPayRule> findList(PlatformPayRule entity);//平台垫资付款设置分页--崔亚光
}