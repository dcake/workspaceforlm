/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.mobile.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.security.shiro.session.SessionDAO;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.mobile.utils.AjaxBeanUtil;
import com.thinkgem.jeesite.modules.users.security.AppFormAuthenticationFilter;
import com.thinkgem.jeesite.modules.users.security.AppAuthorizingRealm.AppPrincipal;
import com.thinkgem.jeesite.modules.users.service.AppUserService;
import com.thinkgem.jeesite.modules.users.util.AppUserUtils;

/**
 * 登录Controller
 * @author ThinkGem
 * @version 2013-5-31
 */
@Controller
public class APPLoginController extends BaseController{
	
	@Autowired
	private SessionDAO sessionDAO;
	@Autowired
	private AppUserService appUserService;
	
	/**
	 * 登录
	 */
	/*@ResponseBody
	@RequestMapping(value = "${appPath}/login", method = RequestMethod.GET)
	public AjaxBeanUtil login(HttpServletRequest request, HttpServletResponse response, Model model) {
		Principal principal = UserUtils.getPrincipal();
		if (logger.isDebugEnabled()){
			logger.debug("login, active session size: {}", sessionDAO.getActiveSessions(false).size());
		}
		// 如果已登录，再次访问主页，则退出原账号。
		if (Global.TRUE.equals(Global.getConfig("notAllowRefreshIndex"))){
			CookieUtils.setCookie(response, "LOGINED", "false");
		}
		return new AjaxBeanUtil("success",true, principal);
	}*/

	/**
	 * 登录失败，真正登录的POST请求由Filter完成
	 */
	@ResponseBody
	@RequestMapping(value = "${appPath}/login", method = RequestMethod.POST)
	public AjaxBeanUtil loginFail(HttpServletRequest request, HttpServletResponse response, Model model) {
		AppPrincipal principal = AppUserUtils.getPrincipal();
		// 如果已经登录，则跳转到管理首页
		if(principal != null){
			return appUserService.getUserLoginInfo();
		}
		String exception = (String)request.getAttribute(AppFormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		String message = (String)request.getAttribute(AppFormAuthenticationFilter.DEFAULT_MESSAGE_PARAM);
		
		if (StringUtils.isBlank(message) || StringUtils.equals(message, "null")){
			message = "用户或密码错误, 请重试";
			return new AjaxBeanUtil(message,false);
		}
		
		if (logger.isDebugEnabled()){
			logger.debug("login fail, active session size: {}, message: {}, exception: {}", 
					sessionDAO.getActiveSessions(false).size(), message, exception);
		}
		
		if (!UnauthorizedException.class.getName().equals(exception)){
		}
		
		return new AjaxBeanUtil("登录失败",false);
	}
	
}
