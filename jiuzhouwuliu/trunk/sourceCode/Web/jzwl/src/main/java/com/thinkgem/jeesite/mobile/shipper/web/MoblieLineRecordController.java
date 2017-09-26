package com.thinkgem.jeesite.mobile.shipper.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.utils.AjaxBeanUtil;
import com.thinkgem.jeesite.mobile.shipper.service.MobileLineRecordService;
/**
 * @description	线路记录
 * @author 文帅
 * @date 2017年9月4日 下午3:19:00
 */
@Controller
@RequestMapping(value="${adminPath}/moblieLineRecord")
public class MoblieLineRecordController {
	@Autowired
	private MobileLineRecordService mobileLineRecordService;
	
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
	 * @description	查询线路记录列表
	 * @author 文帅
	 * @date 2017年9月4日 下午3:20:39
	 * @param currentPage
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="findLineList",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil findLineList(String currentPage,String userId){
		return mobileLineRecordService.findLineList(currentPage,userId);
	}
}
