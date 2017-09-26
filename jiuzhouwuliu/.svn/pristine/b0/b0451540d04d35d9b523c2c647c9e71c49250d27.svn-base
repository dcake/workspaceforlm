package com.thinkgem.jeesite.mobile.common.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.utils.AjaxBeanUtil;
import com.thinkgem.jeesite.mobile.common.service.MobileCommonBalanceService;


/**
 * 余额接口
 * @author liusiyu
 * @date 2017-9-4
 */
@Controller
@RequestMapping(value="/MobileCommonBalance")
public class MobileCommonBalanceController {
	@Autowired
	private MobileCommonBalanceService mobileCommonBalanceService;
	
	/**
	 * 测试页面
	 * @author liusiyu
	 * @date 2017-9-6
	 * @return
	 */
	@RequestMapping(value = "/goBalanceTest")
	public String goBalanceTest(){
		return "mobile/test/balanceTest";
	}
	
	/**
	 * 获取最新提现&充值记录
	 * @author liusiyu
	 * @date 2017-9-5
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getLateBalance",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil getLateBalance(HttpServletRequest request){
		return mobileCommonBalanceService.getUserLateBalance(request);
	}
	
	/**
	 * 获取用户消费/充值操作记录
	 * @author liusiyu
	 * @date 2017-9-4
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getAccountOperate", method= RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil getAccountOperate(HttpServletRequest request){
		return mobileCommonBalanceService.findAccountOperateList(request);
	}
	
	/**
	 * 用户充值
	 * @author liusiyu
	 * @date 2017-9-5
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/userRecharged", method= RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil userRecharged(HttpServletRequest request){
		return mobileCommonBalanceService.userRecharged(request);
	}
	
	/**
	 * 用户提现操作
	 * @author liusiyu
	 * @date 2017-9-13
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/userWithdrawCash", method= RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil userWithdrawCash(HttpServletRequest request){
		return mobileCommonBalanceService.userWithdrawCash(request);
	}
}
