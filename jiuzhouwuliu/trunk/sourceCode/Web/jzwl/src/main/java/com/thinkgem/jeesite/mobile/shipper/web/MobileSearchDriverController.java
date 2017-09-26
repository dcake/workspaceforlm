package com.thinkgem.jeesite.mobile.shipper.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.entity.Drivers;
import com.thinkgem.jeesite.common.utils.AjaxBeanUtil;
import com.thinkgem.jeesite.mobile.shipper.service.MobileSearchDriverService;

/**
 * @desc 货主app--找车
 * @author yaotengfei
 * @date 2017年9月20日上午10:04:52
 */
@Controller
@RequestMapping(value = "/MobileSearchDriver")
public class MobileSearchDriverController {

	@Autowired
	private MobileSearchDriverService mobileSearchDriverService;
	
	/**
	 * @desc 获取搜索条件
	 * @author yaotengfei
	 * @date 2017年9月20日上午10:32:37
	 * @return
	 */
	@RequestMapping(value = "/getConditions")
	@ResponseBody
	public AjaxBeanUtil getConditions(){
		return mobileSearchDriverService.getConditions();
	}
	
	/**
	 * @desc 根据条件查询司机
	 * @author yaotengfei
	 * @date 2017年9月20日下午3:18:50
	 * @param drivers
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getDriverByCons")
	@ResponseBody
	public AjaxBeanUtil getDriverByCons(Drivers drivers,HttpServletRequest request){
		return mobileSearchDriverService.getDriverByCons(drivers,request);
	}
}
