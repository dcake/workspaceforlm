package com.thinkgem.jeesite.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.common.entity.DriverMasterChange;
import com.thinkgem.jeesite.common.entity.Goods;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
@MyBatisDao
public interface DriverMasterChangeMapper {
    int deleteByPrimaryKey(String id);

    int insert(DriverMasterChange record);

    int insertSelective(DriverMasterChange record);

    DriverMasterChange selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DriverMasterChange record);

    int updateByPrimaryKey(DriverMasterChange record);
    
    /**
     * 查询车队长身份转让列表  
     */
    List<DriverMasterChange> selectDriverMasterChange(DriverMasterChange driverMasterChange);
    /**
     * 审核列表
     */
    DriverMasterChange selectDetail(String id);
}