package com.thinkgem.jeesite.modules.rule.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.common.entity.InseranceRule;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.CacheUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.rule.service.InseranceRuleService;
import com.thinkgem.jeesite.modules.sys.entity.Dict;

/** 
 * @author 作者:cuiyg
 * @version 创建时间：2017年8月8日 下午2:16:04 
 * 类说明: 保险规则制定Controller
 */
@Controller
@RequestMapping(value = "${adminPath}/rule/inseranceRule")
public class InseranceRuleController extends BaseController{
	@Autowired
	private InseranceRuleService inseranceRuleService;
	/**
	 * 功能：保险规则制定分页
	 * 作者：崔亚光
	 * 日期：2017-08-08
	 */
	@RequestMapping("list")
	public String list(InseranceRule entity, HttpServletRequest request, HttpServletResponse response, Model model){
		//从缓存里取字典列表
		Map<String, List<Dict>> dictMap = (Map<String, List<Dict>>)CacheUtils.get("dictMap");
		if (dictMap!=null){
			model.addAttribute("goods_type", dictMap.get("goods_type"));
		}
		Page<InseranceRule> page=inseranceRuleService.findPage(new Page<InseranceRule>(request,response),entity);
		for(InseranceRule u:page.getList()){
			if(dictMap!=null){
				for(int i=0;i<dictMap.get("goods_type").size();i++){
				if(dictMap.get("goods_type").get(i).getValue().equals(u.getGoodsType())){
				u.setGoodsTypeStr(dictMap.get("goods_type").get(i).getLabel());
				}
				}
			}
		}
		model.addAttribute("page", page);
		return "/modules/rule/inseranceRuleList";
	}
}
