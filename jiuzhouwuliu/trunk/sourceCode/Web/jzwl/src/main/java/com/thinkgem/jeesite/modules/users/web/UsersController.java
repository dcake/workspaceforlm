package com.thinkgem.jeesite.modules.users.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.entity.Users;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.rule.service.GradedMangerService;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;
import com.thinkgem.jeesite.modules.users.service.UsersService;

/**
 * @ClassName UserController
 * @description TODO(用户控制层)
 * @author pangchengxiang
 * @date 2017年8月7日 下午4:24:48
 */
@Controller
@RequestMapping(value="${adminPath}/users")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	@Autowired
	private GradedMangerService gradedMangerService;
	/**
	 * @description	：加载用户列表
	 * @author pangchengxiang
	 * @date 2017年8月7日 下午4:27:23
	 * @return String
	 */
	@RequestMapping(value="/queryList")
	public String queryList(Users users,Model model,HttpServletRequest request, HttpServletResponse response){
		Page<Users> page = usersService.findUsersListForPage(new Page<Users>(request, response), users);
		model.addAttribute("user", users);
		model.addAttribute("page", page);
		for(Users u:page.getList()){
			u.setUserSortStr(DictUtils.getDictLabel(u.getUserSort(),"users_user_sort",u.getUserSort()));
		}
		return "modules/users/userList";
	}
	/**
	 * 审核表单
	 * 崔亚光
	 * 2017-08-11
	 */
	@RequestMapping("form")
	public String form(String id,String userSort,Model model){
		model.addAttribute("userSort", userSort);
		Users u=new Users();
		if(userSort.equals("0")){//货主
			u=usersService.getGoods(id);
			model.addAttribute("users", u);
			return "modules/users/userGoodsForm";
		}
		if(userSort.equals("2")){
			u=usersService.getAgents(id);
			model.addAttribute("users", u);
			return "modules/users/userAgentsForm";
		}
		else{//车主
			u=gradedMangerService.getInfo(id);
			u.setTruckType(DictUtils.getDictLabel(u.getTruckType(),"truck_type",u.getTruckType()));
			model.addAttribute("users", u);
			return "modules/users/userCarForm";
		}
	}
	/**
	 * 审核用户
	 * 崔亚光
	 * 2017-08-15
	 */
	@RequestMapping("check")
	@ResponseBody
	public String check(Users users){
		usersService.check(users);
		String status="1";
		return status;
		
	}
	
}
