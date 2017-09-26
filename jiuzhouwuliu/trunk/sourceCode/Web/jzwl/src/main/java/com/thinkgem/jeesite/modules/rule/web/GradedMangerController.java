package com.thinkgem.jeesite.modules.rule.web;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.entity.Users;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.CacheUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.rule.service.GradedMangerService;
import com.thinkgem.jeesite.modules.sys.entity.Dict;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/** 
 * @author 作者:cuiyg
 * @version 创建时间：2017年8月7日 上午11:23:53 
 * 类说明: 分级管理Controller
 */
@Controller
@RequestMapping(value = "${adminPath}/rule/gradedManger")
public class GradedMangerController extends BaseController{
	@Autowired
	private GradedMangerService gradedMangerService;
	
	
	@RequestMapping("list")
	public String list(Users user, HttpServletRequest request, HttpServletResponse response, Model model){
		//从缓存里取字典列表
				Map<String, List<Dict>> dictMap = (Map<String, List<Dict>>)CacheUtils.get("dictMap");
				if (dictMap!=null){
					model.addAttribute("users_user_sort", dictMap.get("users_user_sort"));
				}
		Page<Users> page = gradedMangerService.findPage(new Page<Users>(request, response), user); 
		for(Users u:page.getList()){
			if(dictMap!=null){
				for(int i=0;i<dictMap.get("users_user_sort").size();i++){
				if(dictMap.get("users_user_sort").get(i).getValue().equals(u.getUserSort())){
				u.setUserSortStr(dictMap.get("users_user_sort").get(i).getLabel());
				}
				}
			}
		}
		model.addAttribute("user", user);
		model.addAttribute("page", page);
		return "modules/rule/gradedMangerList";
	}
	/**
	 * 功能：车主/经纪人详情
	 * 作者：崔亚光
	 * 日期：2017-08-09
	 * @param id
	 * @return
	 */
	@RequestMapping("carInfo")
	public String info(String id,Model model){
		Users user=gradedMangerService.getInfo(id);
		model.addAttribute("drivers", user);
		return "modules/rule/carDetail";
	}
	/**
	 * 功能：货主详情
	 * 作者：崔亚光
	 * 日期：2017-08-09
	 * @param id
	 * @return
	 */
	@RequestMapping("goodsInfo")
	public String goodsInfo(String id,Model model){
		Users user=gradedMangerService.getInfo(id);
		model.addAttribute("drivers", user);
		return "modules/rule/goodsDetail";
	}
	/**
	 * 功能：车主/经纪人表单
	 * 作者：崔亚光
	 * 日期：2017-08-09
	 * @param id
	 * @return
	 */
	@RequestMapping("carForm")
	public String carForm(String id,Model model){
		Users u=gradedMangerService.getUser(id);
		model.addAttribute("user", u);
		if(u.getUserSort().equals("1")){
			model.addAttribute("type","车主");
		}
		if(u.getUserSort().equals("2")){
			model.addAttribute("type","经纪人");
		}
		return "/modules/rule/carForm";
	}
	/**
	 * 功能：货主表单
	 * 作者：崔亚光
	 * 日期：2017-08-09
	 * @param id
	 * @return
	 */
	@RequestMapping("goodsForm")
	public String goodsForm(String id,Model model){
		Users u=gradedMangerService.getUser(id);
		model.addAttribute("user", u);
		return "/modules/rule/goodsForm";
	}
	/**
	 * 功能：保存分级管理编辑信息
	 * 作者：崔亚光
	 * 日期：2017-08-09
	 * @param id
	 * @return
	 */
	@RequestMapping("save")
	@ResponseBody
	public String save(Users users){
		users.setUpdateBy(UserUtils.getUser().getLoginName());
		users.setUpdateDate(new Date());
		gradedMangerService.save(users);
		String status="1";
		return status;
	}
}
