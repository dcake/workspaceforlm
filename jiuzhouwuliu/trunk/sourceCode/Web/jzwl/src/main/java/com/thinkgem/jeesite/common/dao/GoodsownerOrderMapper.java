package com.thinkgem.jeesite.common.dao;

import java.util.List;
import java.util.Map;

import com.thinkgem.jeesite.common.entity.Goods;
import com.thinkgem.jeesite.common.entity.GoodsownerOrder;
import com.thinkgem.jeesite.common.entity.Goodsowners;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
@MyBatisDao
public interface GoodsownerOrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(GoodsownerOrder record);

    int insertSelective(GoodsownerOrder record);

    GoodsownerOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GoodsownerOrder record);

    int updateByPrimaryKey(GoodsownerOrder record);

	/**
	 * @description	：查询货主订单
	 * @author pangchengxiang
	 * @date 2017年8月22日 上午9:54:49
	 * @return List<Goodsowners>
	 */
	List<Goodsowners> findOrderList(Goodsowners goodsowners);
	
	/**
	 * 根据查询状态查询订单
	 *   
	 * @author 张彦学
	 * 日期 2017年9月1日
	 * @param paramMap
	 * @return
	 */
	public List<Goods> findShipperOrderList(Map<String, Object> paramMap);
	
	/**
	 * 根据订单id查询订单详情
	 *   
	 * @author 张彦学
	 * 日期 2017年9月1日
	 * @param id
	 * @return
	 */
	public GoodsownerOrder findOrderDetail(String id);
	
	/**
	 * 根据货物id查询货品信息
	 *   
	 * @author 张彦学
	 * 日期 2017年9月4日
	 * @param orderId
	 * @return
	 */
	Goods findGoodsByOrderId(String orderId);
	
	/**
	 * @description	根据货物ID查询货主订单
	 * @author 文帅
	 * @date 2017年9月2日 上午11:26:51
	 * @param goodsId
	 * @return
	 */
	GoodsownerOrder findOrderByGoodId(String goodsId);
	/**
	 * @description	根据用户ID查询货主订单列表
	 * @author 文帅
	 * @date 2017年9月4日 下午4:38:14
	 * @param userId
	 * @return
	 */
	List<GoodsownerOrder> findOrderByUserId(String userId);
	/**
	 * @description	根据用户ID查询用户订单
	 * @author 文帅
	 * @date 2017年9月5日 下午4:53:08
	 * @param paramMap
	 * @return
	 */
	List<GoodsownerOrder> findShipList(Map<String, Object> paramMap);
	/**
	 * @description	根据货主ID查询发货次数（仅仅查已完成的）
	 * @author 文帅
	 * @date 2017年9月8日 下午3:05:26
	 * @param goodsownersId
	 * @return
	 */
	Integer findShipCount(String goodsownersId);

	Integer findCount(String userid);//根据货主ID查询交易数  崔亚光
}