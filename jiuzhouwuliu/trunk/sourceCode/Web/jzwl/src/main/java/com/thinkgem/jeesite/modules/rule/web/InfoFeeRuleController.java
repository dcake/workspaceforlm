package com.thinkgem.jeesite.modules.rule.web;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.entity.InfoFeeRule;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.rule.service.InfoFeeRuleService;
/** 
 * @author 作者:cuiyg
 * @version 创建时间：2017年8月8日 上午10:18:05 
 * 类说明: 信息费设置Controller
 */
@Controller
@RequestMapping(value = "${adminPath}/rule/infoFeeRule")
public class InfoFeeRuleController extends BaseController{
	@Autowired
	private InfoFeeRuleService infoFeeRuleService;
	/**
	 * 信息费设置分页
	 * 崔亚光
	 * 时间：2017-08-08
	 */
	@RequestMapping("list")
	public String list(InfoFeeRule entity, HttpServletRequest request, HttpServletResponse response, Model model){
		Page<InfoFeeRule> page=infoFeeRuleService.findPage(new Page<InfoFeeRule>(request,response),entity);
		for(InfoFeeRule s : page.getList()){
			java.text.NumberFormat nf = java.text.NumberFormat.getInstance();   
			nf.setGroupingUsed(false);
			s.setInfoFeeStr(nf.format(s.getInfoFee()));
		}
		//List<Dict> goods_type = DictUtils.getDictList("goods_type");
		model.addAttribute("page", page);
		//model.addAttribute("goods_type", goods_type);
		return "/modules/rule/infoFeeRuleList";
	}
	/**
	 * 新建规则表单
	 * 崔亚光
	 * 时间：2017-08-08
	 */
	 @RequestMapping("form")
	 public String form(String id, Model model){
		 InfoFeeRule info=infoFeeRuleService.getInfo(id);
		 java.text.NumberFormat nf = java.text.NumberFormat.getInstance();   
			nf.setGroupingUsed(false);
			info.setInfoFeeStr(nf.format(info.getInfoFee()));
		 model.addAttribute("info", info);
		 return "/modules/rule/infoFeeForm";
	 }
	 /**
	 * 规则保存
	 * 崔亚光
	 * 时间：2017-08-08
	 */
	 @RequestMapping("save")
	 @ResponseBody
	 public String save(InfoFeeRule entity){
		 infoFeeRuleService.save(entity);
		 String status="1";
		 return status;
	 }
	 /**
	  * 删除
	  * 崔亚光
	  * 2017-08-16
	  */
	 @RequestMapping("delete")
	 public String delete(String id,RedirectAttributes redirectAttributes){
		 infoFeeRuleService.delete(id);
		 //addMessage(redirectAttributes, "删除成功");
		 return "redirect:" + adminPath + "/rule/infoFeeRule/list?repage";
	 }
}
