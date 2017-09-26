package com.thinkgem.jeesite.mobile.shipper.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.utils.AjaxBeanUtil;
import com.thinkgem.jeesite.mobile.shipper.service.MobileRecentPersonService;
/**
 * @description	最近联系人
 * @author 文帅
 * @date 2017年9月4日 下午4:15:25
 */
@Controller
@RequestMapping(value="${adminPath}/mobileRecentPerson")
public class MobileRecentPersonController {
	@Autowired
	private MobileRecentPersonService mobileRecentPersonService;
	
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
	 * @description	最近联系人列表
	 * @author 文帅
	 * @date 2017年9月4日 下午4:16:33
	 * @param currentPage
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="findRecentPersonList",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil findRecentPersonList(String currentPage,String userId){
		return mobileRecentPersonService.findRecentPersonList(currentPage,userId);
	}
}
