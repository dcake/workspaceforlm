package com.thinkgem.jeesite.mobile.shipper.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.entity.Goods;
import com.thinkgem.jeesite.common.entity.UsersBankCard;
import com.thinkgem.jeesite.common.utils.AjaxBeanUtil;
import com.thinkgem.jeesite.mobile.shipper.service.MobileUsersBankCardService;
/**
 * @description	我的-银行卡
 * @author 王瀚
 */
@Controller
@RequestMapping(value="${adminPath}/mobileUsersBankCard")
public class MobileUsersBankCardController {
	@Autowired
	private MobileUsersBankCardService mobileBankCardService;
	/**
	 * @description	测试页面
	 * @author 王瀚
	 * @return
	 */
	@RequestMapping(value="goBankCardTest")
	public String goBankCardTest(){
		return "mobile/test/bankCardTest";
	}
	/**
	 * @description	添加银行卡
	 * @author 王瀚
	 * @return
	 */
	@RequestMapping(value="addUsersBankCard",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil addUsersBankCard(UsersBankCard usersBankCard,HttpServletRequest request){
		return mobileBankCardService.addUsersBankCard(usersBankCard,request);
	}
	/**
	 * @description	查询银行卡列表
	 * @author 王瀚
	 * @return
	 */
	@RequestMapping(value="findBankList",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil findBankList(){
		return mobileBankCardService.findBankList();
	}
}
