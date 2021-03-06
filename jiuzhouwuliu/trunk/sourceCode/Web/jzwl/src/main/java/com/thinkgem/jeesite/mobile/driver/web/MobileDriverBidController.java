package com.thinkgem.jeesite.mobile.driver.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.utils.AjaxBeanUtil;
import com.thinkgem.jeesite.mobile.driver.service.MobileDriverBidService;
/**
 * @description	车主端-竞价
 * @author 文帅
 * @date 2017年9月7日 上午9:40:05
 */
@Controller
@RequestMapping(value="${adminPath}/mobileDriverBid")
public class MobileDriverBidController {
	@Autowired
	private MobileDriverBidService mobileDriverBidService;
	
	/**
	 * @description	车主端测试页面
	 * @author 文帅
	 * @date 2017年8月21日 下午4:47:31
	 * @return
	 */
	@RequestMapping(value="goDriverTest")
	public String goShipperTest(){
		return "mobile/test/driverTest";
	}
	
	/**
	 * @description	查询竞价列表
	 * @author 文帅
	 * @date 2017年9月7日 上午10:14:46
	 * @return
	 */
	@RequestMapping(value="findDriverBidList",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil findDriverBidList(String currentPage,String userId){
		return mobileDriverBidService.findDriverBidList(currentPage,userId);
	}
	/**
	 * @description	查询货主参与的竞价列表（我的竞价）
	 * @author 文帅
	 * @date 2017年9月8日 上午10:49:43
	 * @param currentPage
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="myBidList",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil myBidList(String currentPage,String userId){
		return mobileDriverBidService.myBidList(currentPage,userId);
	}
	
	/**
	 * @description	查看竞价详情
	 * @author 文帅
	 * @date 2017年9月8日 下午2:14:29
	 * @param goodsId
	 * @param type 用于判断是竞价的经纪人发布的货物还是货主发布的货物（0-货主，1-经纪人）
	 * @return
	 */
	@RequestMapping(value="lookBidDetail",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil lookBidDetail(String goodsId,String type){
		return mobileDriverBidService.lookBidDetail(goodsId,type);
	}
	/**
	 * @description	出价
	 * @author 文帅
	 * @date 2017年9月8日 下午5:08:58
	 * @param orderId 订单ID
	 * @param userId 当前登录用户ID
	 * @param type 用于判断是经纪人/货主发起的竞价（0货主 1经纪人）
	 * @return
	 */
	@RequestMapping(value="offerPrice",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil offerPrice(String orderId,String userId,String type,Double jingjiaPrice,String teamMemberId){
		return mobileDriverBidService.offerPrice(orderId,userId,type,jingjiaPrice,teamMemberId);
	}
	/**
	 * @description	根据用户ID查询车队队员
	 * @author 文帅
	 * @date 2017年9月8日 下午5:40:38
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="findTeamMembers",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil findTeamMembers(String currentPage,String userId){
		return mobileDriverBidService.findTeamMembers(currentPage,userId);
	}

}
