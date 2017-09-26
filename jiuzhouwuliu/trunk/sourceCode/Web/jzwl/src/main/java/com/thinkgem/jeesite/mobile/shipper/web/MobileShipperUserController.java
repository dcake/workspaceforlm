package com.thinkgem.jeesite.mobile.shipper.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.mobile.shipper.service.MobileShipperUserService;
import com.thinkgem.jeesite.mobile.utils.AjaxBeanUtil;

/**
 * @desc 货主端用户相关接口
 * @author yaotengfei
 * @date 2017年8月21日下午4:56:40
 */
@Controller
@RequestMapping(value="/MobileShipperUser")
public class MobileShipperUserController {

	@Autowired
	private MobileShipperUserService mobileShipperUserService;
	
	/**
	 * @desc 根据userid获取货主信息
	 * @author yaotengfei
	 * @date 2017年9月5日上午9:17:30
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/getUserInfoByUserId", method= RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil getUserInfoByUserId(String userId){
		return mobileShipperUserService.getUserInfoByUserId(userId);
	}
	
	/**
	 * @desc 获取货主身份
	 * @author yaotengfei
	 * @date 2017年8月21日下午5:10:49
	 * @return
	 */
	@RequestMapping(value="/getShipperIdentity", method= RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil getShipperIdentity(){
		return mobileShipperUserService.getShipperIdentity();
	}
	
	/**
	 * @desc 货主身份认证
	 * @author yaotengfei
	 * @date 2017年8月21日下午5:24:51
	 * @param request
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value="/identityAuthentication", method= RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil identityAuthentication(HttpServletRequest request) throws IllegalStateException, IOException{
		return mobileShipperUserService.identityAuthentication(request);
	}

}
