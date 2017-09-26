package com.thinkgem.jeesite.modules.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.dao.GoodsMapper;
import com.thinkgem.jeesite.common.dao.InseranceCompanyMapper;
import com.thinkgem.jeesite.common.entity.AgentDeal;
import com.thinkgem.jeesite.common.entity.DriverLogisticsPosition;
import com.thinkgem.jeesite.common.entity.Goods;
import com.thinkgem.jeesite.common.entity.GoodsBilling;
import com.thinkgem.jeesite.common.entity.InseranceCompany;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.users.entity.OrderAgentInfo;
import com.thinkgem.jeesite.modules.users.entity.OrderDriverInfo;
import com.thinkgem.jeesite.modules.users.entity.OrderGoodsownerInfo;
import com.thinkgem.jeesite.modules.users.entity.OrderManager;

/**
 * @ClassName OrderManagerService
 * @description TODO(订单管理)
 * @author pangchengxiang
 * @date 2017年8月14日 上午11:34:57
 */
@Service
@Transactional
public class OrderManagerService {
	
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private InseranceCompanyMapper inseranceCompanyMapper;
	/**
	 * 获取用户 分页数据
	 * @param page:分页对象
	 * @param users：用户对象参数
	 * @return
	 */
	public Page<OrderManager> findUsersListForPage(Page<OrderManager> page, OrderManager  om) {
		om.setPage(page);
		page.setList(goodsMapper.findOrderListForPage(om));
		return page;	
	}
	
	/**
	 * @description	：获取货物
	 * @author pangchengxiang
	 * @date 2017年8月15日 下午2:36:16
	 * @return Goods
	 */
	public Goods selectGoodsByPrimaryKey(String id){
		return goodsMapper.selectByPrimaryKey(id);
	};
	
	/**
	 * @description	：根据id查询保险公司
	 * @author pangchengxiang
	 * @date 2017年8月18日 下午3:07:02
	 * @return InseranceCompany
	 */
	public InseranceCompany selectInseranceCompanyByPrimaryKey(String id){
		return inseranceCompanyMapper.selectByPrimaryKey(id);
	};
	
	/**
	 * @description	：获取订单明细中货主信息
	 * @author pangchengxiang
	 * @date 2017年8月15日 下午2:36:16
	 * @return List<OrderGoodsownerInfo>
	 */
	public List<OrderGoodsownerInfo> selectGoodsownerInfoByGoodsidForOrder(Goods goods){
		return goodsMapper.selectGoodsownerInfoByGoodsidForOrder(goods);
	};
	
	/**
	 * @description	：获取订单明细中车主信息
	 * @author pangchengxiang
	 * @date 2017年8月15日 下午2:36:16
	 * @return List<OrderDriverInfo>
	 */
	public List<OrderDriverInfo> selectDriverInfoByGoodsidForOrder(Goods goods){
		return goodsMapper.selectDriverInfoByGoodsidForOrder(goods);
	};
	
	/**
	 * @description	：获取订单明细中经纪人信息
	 * @author pangchengxiang
	 * @date 2017年8月15日 下午2:36:16
	 * @return List<OrderAgentInfo>
	 */
	public List<OrderAgentInfo> selectAgentInfoByGoodsidForOrder(Goods goods){
		return goodsMapper.selectAgentInfoByGoodsidForOrder(goods);
	};
	
	/**
	 * @description	：根据货物查询订单
	 * @author pangchengxiang
	 * @date 2017年8月16日 下午6:23:11
	 * @return List<GoodsBilling>
	 */
	public List<GoodsBilling> selectBillingByGoods(Goods goods){
		return goodsMapper.selectBillingByGoods(goods);
	}
	
	/**
	 * @description	：获取车主竞价信息
	 * @author pangchengxiang
	 * @date 2017年8月17日 下午3:52:52
	 * @return List<OrderDriverInfo>
	 */
	public List<OrderDriverInfo> selectDriverCompletePrice(String id){
		return goodsMapper.selectDriverCompletePrice(id);
	};
	/**
	 * @description	：获取经纪人竞价信息
	 * @author pangchengxiang
	 * @date 2017年8月17日 下午3:53:05
	 * @return List<OrderAgentInfo>
	 */
	public List<OrderAgentInfo> selectAgentCompletePrice(String id){
		return goodsMapper.selectAgentCompletePrice(id);
	};
	
	/**
	 * @description	：根据车主订单id查询物流信息
	 * @author pangchengxiang
	 * @date 2017年8月18日 下午1:56:20
	 * @return List<DriverLogisticsPositionMapper>
	 */
	public List<DriverLogisticsPosition> selectDriverLogistics(String id){
		return goodsMapper.selectDriverLogistics(id);
	};
	
	/**
	 * @description	：根据经纪人订单id获取交易信息
	 * @author pangchengxiang
	 * @date 2017年8月19日 上午9:30:31
	 * @return List<AgentDeal>
	 */
	public List<AgentDeal> selectAgentDealByOrderId(String id){
		return  goodsMapper.selectAgentDealByOrderId(id);
	};
}
