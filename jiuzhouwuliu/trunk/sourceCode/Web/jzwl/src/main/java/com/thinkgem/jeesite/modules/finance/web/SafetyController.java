package com.thinkgem.jeesite.modules.finance.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description	财务管理
 * @author 文帅
 * @date 2017年8月7日 上午11:16:50
 */
@Controller
@RequestMapping(value="${adminPath}/finance/safety")
public class SafetyController {
	
	/**
	 * @description	跳转到保险管理列表页面
	 * @author 文帅
	 * @date 2017年8月7日 下午2:17:09
	 * @param request
	 * @return
	 */
	@RequestMapping(value = {"list", ""})
	public String list(HttpServletRequest request) {
		return "modules/finance/safetyList";
	}
}
