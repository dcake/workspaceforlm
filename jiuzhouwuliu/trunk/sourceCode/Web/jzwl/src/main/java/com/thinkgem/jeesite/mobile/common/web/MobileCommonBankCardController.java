package com.thinkgem.jeesite.mobile.common.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.entity.UsersBankCard;
import com.thinkgem.jeesite.common.utils.AjaxBeanUtil;
import com.thinkgem.jeesite.mobile.common.service.MobileCommonBankCardService;

/**
 * @desc 个人中心--钱包--银行卡接口
 * @author yaotengfei
 * @date 2017年9月2日上午9:27:27
 */
@Controller
@RequestMapping(value="/MobileCommonBankCard")
public class MobileCommonBankCardController {

	@Autowired
	private MobileCommonBankCardService mobileCommonBankCardService;
	
	/**
	 * @desc 获取银行卡列表
	 * @author yaotengfei
	 * @date 2017年9月2日上午9:49:23
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/getBankCardListByUserId", method= RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil getBankCardListByUserId(String userId){
		return mobileCommonBankCardService.getBankCardListByUserId(userId);
	}
	
	/**
	 * @desc 添加银行卡
	 * @author yaotengfei
	 * @date 2017年9月2日上午10:54:23
	 * @param usersBankCard
	 * @return
	 */
	@RequestMapping(value="/addBankCard", method= RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil addBankCard(UsersBankCard usersBankCard){
		return mobileCommonBankCardService.addBankCard(usersBankCard);
	}
	
	/**
	 * @desc 删除银行卡
	 * @author yaotengfei
	 * @date 2017年9月2日上午11:12:44
	 * @param bankCardId
	 * @return
	 */
	@RequestMapping(value="/delBankCard", method= RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil delBankCard(String bankCardId){
		return mobileCommonBankCardService.delBankCard(bankCardId);
	}
}
