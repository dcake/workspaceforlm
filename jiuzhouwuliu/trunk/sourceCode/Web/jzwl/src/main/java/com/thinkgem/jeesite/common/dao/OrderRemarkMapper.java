package com.thinkgem.jeesite.common.dao;

import java.util.List;
import java.util.Map;

import com.thinkgem.jeesite.common.entity.OrderRemark;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
@MyBatisDao
public interface OrderRemarkMapper {
    int insert(OrderRemark record);

    int insertSelective(OrderRemark record);
    /**
     * @description	根据经纪人ID查询该经纪人的评价
     * @author 文帅
     * @date 2017年8月24日 上午9:34:38
     * @param paramMap
     * @return
     */
    List<OrderRemark> findEvaluationList(Map<String, Object> paramMap);
    /**
     * @description	根据车主ID查询车主评价列表
     * @author 文帅
     * @date 2017年8月26日 上午10:24:37
     * @param paramMap
     * @return
     */
    List<OrderRemark> findDriverEvaluationList(Map<String, Object> paramMap);
    /**
     * @description	根据经纪人ID查询该经纪人的评价数量
     * @author 文帅
     * @date 2017年8月31日 下午4:29:56
     * @param paramMap
     * @return
     */
    Integer findEvaluationCount(Map<String, Object> paramMap);
    
    /**
     * 根据订单获取评价信息
     *   
     * @author 张彦学
     * 日期 2017年9月1日
     * @param id 订单id
     * @return
     */
    OrderRemark findOrderRemarkByGoodsownerOrder(String id);
}