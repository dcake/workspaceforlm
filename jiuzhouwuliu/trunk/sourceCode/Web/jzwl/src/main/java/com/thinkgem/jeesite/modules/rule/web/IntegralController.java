package com.thinkgem.jeesite.modules.rule.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.entity.IntegralRule;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.rule.service.IntegralRuleService;

/** 
 * @author 作者:cuiyg
 * @version 创建时间：2017年8月7日 下午5:02:21 
 * 类说明: 积分管理controller
 */
@Controller
@RequestMapping(value = "${adminPath}/rule/integral")
public class IntegralController extends BaseController{
	@Autowired
	private IntegralRuleService integralRuleService;
	/**
	 * 获取积分管理实体
	 * 崔亚光
	 * 2017-08-07
	 * @return
	 */
	@RequestMapping("list")
	public String list(Model model){
		IntegralRule i=integralRuleService.getIntegralRule();
		model.addAttribute("integralRule", i);
		return "/modules/rule/integral";
	}
	/**
	 * 保存积分管理
	 * 崔亚光
	 * 2017-08-07
	 * @return
	 */
	@RequestMapping("save")
	@ResponseBody
	public String save(IntegralRule entity){
		integralRuleService.save(entity);
		String result="1";
		return result;
	}
}
