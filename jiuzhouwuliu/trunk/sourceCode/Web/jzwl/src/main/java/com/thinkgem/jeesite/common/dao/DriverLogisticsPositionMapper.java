package com.thinkgem.jeesite.common.dao;

import java.util.List;

import com.thinkgem.jeesite.common.entity.DriverLogisticsPosition;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
@MyBatisDao
public interface DriverLogisticsPositionMapper {
    int deleteByPrimaryKey(String id);

    int insert(DriverLogisticsPosition record);

    int insertSelective(DriverLogisticsPosition record);

    DriverLogisticsPosition selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DriverLogisticsPosition record);

    int updateByPrimaryKey(DriverLogisticsPosition record);
    
    /**
     * 根据订单获取物流位置信息
     *   
     * @author 张彦学
     * 日期 2017年9月1日
     * @param id
     * @return
     */
    List<DriverLogisticsPosition> findDriverLogisticsPositionByGoodsownerOrder(String id);
    
    /**
     * 根据车主订单id 查询物流位置信息
     *   
     * @author 张彦学
     * 日期 2017年9月2日
     * @param driverOrderId
     * @return
     */
    List<DriverLogisticsPosition> findDriverLogisticsPositionByDriverOrderId(String driverOrderId);
}