package com.thinkgem.jeesite.modules.users.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.common.entity.AgentDeal;
import com.thinkgem.jeesite.common.entity.AgentOrder;
import com.thinkgem.jeesite.common.entity.Goods;
import com.thinkgem.jeesite.common.entity.GoodsBilling;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;
import com.thinkgem.jeesite.modules.users.entity.OrderAgentInfo;
import com.thinkgem.jeesite.modules.users.entity.OrderDriverInfo;
import com.thinkgem.jeesite.modules.users.entity.OrderGoodsownerInfo;
import com.thinkgem.jeesite.modules.users.entity.OrderManager;
import com.thinkgem.jeesite.modules.users.service.OrderManagerService;

/**
 * 订单管理
 *   
 * @author 张彦学
 * 日期 2017年8月11日
 */
@Controller
@RequestMapping(value = "${adminPath}/users/orderManager")
public class OrderManagerController {
	
	@Autowired
	private OrderManagerService orderManagerService;
	
	/**
	 * 订单管理列表
	 *   
	 * @author 张彦学
	 * 日期 2017年8月11日
	 * @return
	 */
	@RequestMapping(value = "/orderManagerList")
	public String orderManagerList(OrderManager  om,Model model,HttpServletRequest request, HttpServletResponse response){
		Page<OrderManager> page = orderManagerService.findUsersListForPage(new Page<OrderManager>(request, response), om);
		model.addAttribute("orderManager", om);
		model.addAttribute("page", page);
		for(OrderManager o:page.getList()){
			//货物类型
			o.setGoodsType(DictUtils.getDictLabel(o.getGoodsType(),"goods_type",o.getGoodsType()));
			//订单状态
			o.setStatus(DictUtils.getDictLabel(o.getStatus(), "order_status", o.getStatus()));
			if("1".equals(o.getGoodsBelongto())){
				//当货物归属为经纪人时，查询经纪人交易信息（多个）
				if(StringUtils.isNotEmpty(o.getAgentOrderId())){
					double money=0;
					List<AgentDeal> list = orderManagerService.selectAgentDealByOrderId(o.getAgentOrderId());
					for(AgentDeal d:list){
						money+=d.getOilCardMoney()+d.getRestMoney();
					}
					o.setMoney(money);
				}
			}else{
				//当货物归属为货主（一个）
				o.setMoney(o.getGoodsMoney());
			}
			o.setIsHasInsurance(DictUtils.getDictLabel(o.getIsHasInsurance(),"yes_no",o.getIsHasInsurance()));
			o.setIsBill(DictUtils.getDictLabel(o.getIsBill(),"yes_no",o.getIsBill()));
		}
		return "modules/users/orderManagerList";
	}
	
	/**
	 * @description	：获取订单详情信息
	 * @author pangchengxiang
	 * @date 2017年8月15日 下午2:31:37
	 * @return String
	 */
	@RequestMapping(value = "/orderManagerDetail")
	public String orderManagerDetail(String id,Model model){
		//货物信息
		Goods goods = orderManagerService.selectGoodsByPrimaryKey(id);
		//设置保险公司名称
		if(StringUtils.isNoneEmpty(goods.getInsuranceCompanyId())){
			goods.setInsuranceCompanyId(orderManagerService.selectInseranceCompanyByPrimaryKey(goods.getInsuranceCompanyId()).getCompanyName());
		}
		//货物类型
		goods.setGoodsType(DictUtils.getDictLabel(goods.getGoodsType(), "goods_type", goods.getGoodsType()));
		//需求车型
		goods.setNeedTruckType(DictUtils.getDictLabel(goods.getNeedTruckType(), "truck_type", goods.getNeedTruckType()));
		//开票状态
		goods.setIsHasBill(DictUtils.getDictLabel(goods.getIsHasBill(), "is_has_bill", goods.getIsHasBill()));
		//判断货物属于货主或经纪人
		List<OrderGoodsownerInfo> goodsOwnerInfo = orderManagerService.selectGoodsownerInfoByGoodsidForOrder(goods);
		if(goodsOwnerInfo.size()>0){
			//货主信息
			if(goodsOwnerInfo.size()>0){
				//设置货主支付方式
				goodsOwnerInfo.get(0).setPayStyle(DictUtils.getDictLabel(goodsOwnerInfo.get(0).getPayStyle(), "goodsowner_recive_money_pay_style", goodsOwnerInfo.get(0).getPayStyle()));
				model.addAttribute("u", goodsOwnerInfo.get(0));
				goods.setOrderStatus(goodsOwnerInfo.get(0).getOrderStatus());
				//竞价经纪人信息
				List<OrderAgentInfo> completePriceAgentInfo = orderManagerService.selectAgentCompletePrice(id);
				model.addAttribute("completePriceAgentInfo", completePriceAgentInfo);
				//竞价车主信息
				if(StringUtils.isNotEmpty(goodsOwnerInfo.get(0).getOrderId())){
					List<OrderDriverInfo> completePriceDriverInfo = orderManagerService.selectDriverCompletePrice(goodsOwnerInfo.get(0).getOrderId());
					model.addAttribute("completePriceDriverInfo", completePriceDriverInfo);
				}
			}
		}else{
			//经纪人信息
			List<OrderAgentInfo> orderAgentInfo = orderManagerService.selectAgentInfoByGoodsidForOrder(goods);
			if(orderAgentInfo.size()>0){
				model.addAttribute("u", orderAgentInfo.get(0));
				goods.setOrderStatus(orderAgentInfo.get(0).getOrderStatus());
				//竞价车主信息
				if(StringUtils.isNotEmpty(orderAgentInfo.get(0).getOrderId())){
					List<OrderDriverInfo> completePriceDriverInfo = orderManagerService.selectDriverCompletePrice(orderAgentInfo.get(0).getOrderId());
					model.addAttribute("completePriceDriverInfo", completePriceDriverInfo);
				}
			}
		}
		if(StringUtils.isNotEmpty(goods.getOrderStatus())){
			goods.setOrderStatus(DictUtils.getDictLabel(goods.getOrderStatus(), "order_status", goods.getOrderStatus()));
		}
		//车主信息
		List<OrderDriverInfo> orderDriverInfo = orderManagerService.selectDriverInfoByGoodsidForOrder(goods);
		for(OrderDriverInfo o :orderDriverInfo){
			if(StringUtils.isNotEmpty(o.getOrderId())){
				o.setDriverLogisticsPosition(orderManagerService.selectDriverLogistics(o.getOrderId()));
			}
		}
		//开票信息
		List<GoodsBilling> goodsBilling = orderManagerService.selectBillingByGoods(goods);
		if(goodsBilling.size()>0){
			model.addAttribute("goodsBilling", goodsBilling.get(0));
		}
		model.addAttribute("orderDriverInfoList", orderDriverInfo);
		model.addAttribute("goods", goods);
		model.addAttribute("imgList", imgList(goods));
		return "modules/users/orderManagerDetail";
	}
	
	private List<String> imgList(Goods goods){
		List<String> list = new ArrayList<String>();
		if(StringUtils.isNotEmpty(goods.getGoodsImg1())){
			list.add(goods.getGoodsImg1());
		}
		if(StringUtils.isNotEmpty(goods.getGoodsImg2())){
			list.add(goods.getGoodsImg2());
		}
		if(StringUtils.isNotEmpty(goods.getGoodsImg3())){
			list.add(goods.getGoodsImg3());
		}
		if(StringUtils.isNotEmpty(goods.getGoodsImg4())){
			list.add(goods.getGoodsImg4());
		}
		if(StringUtils.isNotEmpty(goods.getGoodsImg5())){
			list.add(goods.getGoodsImg5());
		}
		if(StringUtils.isNotEmpty(goods.getGoodsImg6())){
			list.add(goods.getGoodsImg6());
		}
		if(StringUtils.isNotEmpty(goods.getGoodsImg7())){
			list.add(goods.getGoodsImg7());
		}
		if(StringUtils.isNotEmpty(goods.getGoodsImg8())){
			list.add(goods.getGoodsImg8());
		}
		return list;
	}
	
}
