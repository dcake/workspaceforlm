package com.thinkgem.jeesite.modules.rule.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.entity.PlatformPayRule;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.AjaxBeanUtil;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.rule.service.PlatformPayRuleService;

/** 
 * @author 作者:cuiyg
 * @version 创建时间：2017年8月8日 下午2:16:04 
 * 类说明: 平台垫资付款设置Controller
 */
@Controller
@RequestMapping(value = "${adminPath}/rule/platformPayRule")
public class PlatformPayRuleController extends BaseController{
	@Autowired
	private PlatformPayRuleService platformPayRuleService;
	/**
	 * 功能：平台垫资付款设置分页
	 * 作者：崔亚光
	 * 日期：2017-08-08
	 */
	@RequestMapping("list")
	public String list(PlatformPayRule entity, HttpServletRequest request, HttpServletResponse response, Model model){
		Page<PlatformPayRule> page=platformPayRuleService.findPage(new Page<PlatformPayRule>(request,response),entity);
		for(PlatformPayRule s : page.getList()){
			java.text.NumberFormat nf = java.text.NumberFormat.getInstance();   
			nf.setGroupingUsed(false);
			s.setTransportMinFeeStr(nf.format(s.getTransportMinFee()));
			s.setTransportMaxFeeStr(nf.format(s.getTransportMaxFee()));
			s.setOilCardFeeStr(nf.format(s.getOilCardFee()));
		}
		model.addAttribute("page", page);
		return "/modules/rule/platformPayRuleList";
	}
	/**
	 * 功能：平台垫资付款设置表单
	 * 作者：崔亚光
	 * 日期：2017-08-08
	 */
	@RequestMapping("form")
	public String form(String id, Model model){
		if(StringUtils.isNotBlank(id)){
		PlatformPayRule pr=platformPayRuleService.getEntity(id);
		java.text.NumberFormat nf = java.text.NumberFormat.getInstance();   
		nf.setGroupingUsed(false);
		pr.setTransportMinFeeStr(nf.format(pr.getTransportMinFee()));
		pr.setTransportMaxFeeStr(nf.format(pr.getTransportMaxFee()));
		pr.setOilCardFeeStr(nf.format(pr.getOilCardFee()));
		model.addAttribute("plat", pr);
		}
		return "/modules/rule/platformForm";
	}
	/**
	 * 功能：平台垫资付款设置保存
	 * 作者：崔亚光
	 * 日期：2017-08-09
	 */
	@RequestMapping("save")
	@ResponseBody
	public String save(PlatformPayRule entity){
		platformPayRuleService.save(entity);
		String status="1";
		return status;
	}
	
	 /**
	  * 删除
	  * 崔亚光
	  * 2017-08-16
	  */
	 @RequestMapping("delete")
	 @ResponseBody
	 public AjaxBeanUtil delete(String id,RedirectAttributes redirectAttributes){
		 platformPayRuleService.delete(id);
		 //addMessage(redirectAttributes, "删除成功");
		 return new AjaxBeanUtil("删除成功！",true);
	 }
}
