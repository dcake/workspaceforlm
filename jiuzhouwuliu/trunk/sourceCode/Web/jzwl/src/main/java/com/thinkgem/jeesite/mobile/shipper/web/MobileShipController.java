package com.thinkgem.jeesite.mobile.shipper.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.entity.Goods;
import com.thinkgem.jeesite.common.entity.GoodsownerOrder;
import com.thinkgem.jeesite.common.utils.AjaxBeanUtil;
import com.thinkgem.jeesite.mobile.shipper.service.MobileShipService;
/**
 * @description	货主端-发货
 * @author 文帅
 * @date 2017年8月21日 下午3:44:42
 */
@Controller
@RequestMapping(value="/mobileShip")
public class MobileShipController {
	@Autowired
	private MobileShipService mobileShipService;
	
	/**
	 * @description	测试页面
	 * @author 文帅
	 * @date 2017年8月21日 下午4:47:31
	 * @return
	 */
	@RequestMapping(value="goShipperTest")
	public String goShipperTest(){
		return "mobile/test/shipperTest";
	}
	/**
	 * @description	添加或修改保存货物
	 * @author 文帅
	 * @date 2017年8月21日 下午3:57:57
	 * @param goods
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="addGoods",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil addGoods(Goods goods,HttpServletRequest request) throws IOException{
		return mobileShipService.addGoods(goods,request);
	}
	
	/**
	 * @description	根据用户ID查询发货人和发货人列表
	 * @author 文帅
	 * @date 2017年8月21日 下午5:36:37
	 * @param userId
	 * @param shipperName 发货人姓名
	 * @param reciverName 收货人姓名
	 * @return
	 */
	@RequestMapping(value="findShipperList",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil findShipperList(String userId,String shipperName,String reciverName){
		return mobileShipService.findShipperList(userId,shipperName,reciverName);
	}
	/**
	 * @description	根据类型查询需求车型，货物类型，货物单位
	 * @author 文帅
	 * @date 2017年8月22日 上午9:22:41
	 * @param type 字典类型
	 * @return
	 */
	@RequestMapping(value="findDictList",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil findDictList(String type){
		return mobileShipService.findDictList(type);
	}
	/**
	 * @description	查询所有的省
	 * @author 文帅
	 * @date 2017年8月22日 上午9:50:54
	 * @param type 城市类型(省-2，市-3，区-4)
	 * @return
	 */
	@RequestMapping(value="findGeoInfoList",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil findGeoInfoList(HttpServletRequest request,String type){
		return mobileShipService.findGeoInfoList(request,type);
	}
	
	/**
	 * @description	查询保险公司列表
	 * @author 文帅
	 * @date 2017年8月22日 上午10:53:59
	 * @return
	 */
	@RequestMapping(value="findInsCompanyList",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil findInsCompanyList(){
		return mobileShipService.findInsCompanyList();
	}
	
	/**
	 * @description	发布竞价
	 * @author 文帅
	 * @date 2017年8月22日 上午11:46:20
	 * @param userId 用户ID
	 * @param priceMin 最小竞价区间
	 * @param price_max 最大竞价区间
	 * @param publicSel 竞价人选（0车主 1经纪人）
	 * @return
	 */
	@RequestMapping(value="publishBid",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil publishBid(GoodsownerOrder goodsownerOrder){
		return mobileShipService.publishBid(goodsownerOrder);
	}
	
	/**
	 * @description	查询经纪人列表
	 * @author 文帅
	 * @date 2017年8月22日 下午5:28:07
	 * @param currentPage
	 * @return
	 */
	@RequestMapping(value="findAgentsList",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil findAgentsList(String currentPage,String userId){
		return mobileShipService.findAgentsList(currentPage,userId);
	}
	
	/**
	 * @description	根据经济人ID查询经纪人详情
	 * @author 文帅
	 * @date 2017年8月23日 下午3:06:10
	 * @param agentId
	 * @return
	 */
	@RequestMapping(value="lookAgentDetail",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil lookAgentDetail(String agentId,String userId){
		return mobileShipService.lookAgentDetail(agentId,userId);
	}
	/**
	 * @description	根据车主ID查询车主详情
	 * @author 文帅
	 * @date 2017年9月12日 下午12:03:13
	 * @param agentId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="lookDriverDetail",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil lookDriverDetail(String jingJiaRenId,String userId){
		return mobileShipService.lookDriverDetail(jingJiaRenId,userId);
	}
	
	/**
	 * @description	收藏和取消收藏
	 * @author 文帅
	 * @date 2017年8月23日 下午4:28:23
	 * @param userId
	 * @param agentId
	 * @param  type用于判断是车主还是经纪人（1车主、2经纪人）
	 * @return
	 */
	@RequestMapping(value="collectOrCancel",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil collectOrCancel(String userId,String agentId,String type){
		return mobileShipService.collectOrCancel(userId,agentId,type);
	}
	
	/**
	 * @description	根据经纪人ID查询经纪人评价
	 * @author 文帅
	 * @date 2017年8月23日 下午6:07:24
	 * @param currentPage
	 * @param agentId
	 * @return
	 */
	@RequestMapping(value="findEvaluationList",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil findEvaluationList(String currentPage,String agentId){
		return mobileShipService.findEvaluationList(currentPage,agentId);
	}
	
	/**
	 * @description	确认委托
	 * @author 文帅
	 * @date 2017年8月24日 上午10:06:19
	 * @param agentId
	 * @return
	 */
	@RequestMapping(value="confirmConsign",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil confirmConsign(String agentId,String goodsId,String goodsownerOrderid,String userId){
		return mobileShipService.confirmConsign(agentId,goodsId,goodsownerOrderid,userId);
	}
	/**
	 * @description	发货列表
	 * @author 文帅
	 * @date 2017年9月5日 下午4:43:12
	 * @param currentPage
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="findShipList",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil findShipList(String currentPage,String userId){
		return mobileShipService.findShipList(currentPage,userId);
	}
	/**
	 * @description	删除货主订单
	 * @author 文帅
	 * @date 2017年9月6日 下午3:00:52
	 * @param goodsownerOrderId
	 * @return
	 */
	@RequestMapping(value="delGoodsownerOrder",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil delGoodsownerOrder(String goodsownerOrderId){
		return mobileShipService.delGoodsownerOrder(goodsownerOrderId);
	}
	/**
	 * @description	根据货主订单ID查询货物及订单详情
	 * @author 文帅
	 * @date 2017年9月6日 下午3:50:38
	 * @param goodsownerOrderId
	 * @return
	 */
	@RequestMapping(value="findGoodsByOrderId",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil findGoodsByOrderId(String goodsownerOrderId){
		return mobileShipService.findGoodsByOrderId(goodsownerOrderId);
	}
}
