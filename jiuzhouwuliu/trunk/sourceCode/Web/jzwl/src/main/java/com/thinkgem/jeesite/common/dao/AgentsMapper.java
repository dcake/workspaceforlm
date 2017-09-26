package com.thinkgem.jeesite.common.dao;

import java.util.List;

import com.thinkgem.jeesite.common.entity.Agents;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface AgentsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Agents record);

    int insertSelective(Agents record);

    Agents selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Agents record);

    int updateByPrimaryKey(Agents record);
    //经纪人列表
    List<Agents>findList(Agents agents);
    
    Agents selectByPrimaryKeyId(String id);
    
    Agents findOrderListId(String id);
    
    Agents findByUserId(String userId);

	void update(Agents a);
	
	Agents findAgentsByUserId(String userId);
	
	/**
	 * 根据货主订单查询经纪人
	 *   
	 * @author 张彦学
	 * 日期 2017年9月2日
	 * @param id
	 * @return
	 */
	Agents findAgetnsByGoodsownerOrder(String id);
}