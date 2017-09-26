package com.thinkgem.jeesite.modules.finance.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.entity.Users;
import com.thinkgem.jeesite.common.entity.UsersAccountOperate;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import com.thinkgem.jeesite.modules.finance.entity.ExportUsersWallet;
import com.thinkgem.jeesite.modules.finance.entity.ExportWalletDetail;
import com.thinkgem.jeesite.modules.finance.service.WalletService;
import com.thinkgem.jeesite.modules.sys.entity.Dict;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;
import com.thinkgem.jeesite.modules.users.service.UsersService;

/**
 * @description	钱包管理
 * @author 文帅
 * @date 2017年8月7日 下午2:16:17
 */
@Controller
@RequestMapping(value="${adminPath}/finance/wallet")
public class WalletController {
	@Autowired
	private UsersService usersService;
	@Autowired
	private WalletService walletService;
	
	/**
	 * @description	跳转到钱包管理列表页面
	 * @author 文帅
	 * @date 2017年8月7日 下午2:18:10
	 * @param request
	 * @return
	 */
	@RequestMapping(value = {"list", ""})
	public String list(Users users,Model model,HttpServletRequest request,HttpServletResponse response) {
		Page<Users> page = usersService.findPassUsersListForPage(new Page<Users>(request, response), users);
		model.addAttribute("page", page);
		for(Users u:page.getList()){
			u.setUserSort(DictUtils.getDictLabel(u.getUserSort(),"users_user_sort",u.getUserSort()));
		}
		List<Dict> userSortList=DictUtils.getDictList("users_user_sort");
		model.addAttribute("users", users);
		model.addAttribute("userSortList", userSortList);
		return "modules/finance/walletList";
	}
	
	/**
	 * @description	跳转到钱包详情页面
	 * @author 文帅
	 * @date 2017年8月7日 下午4:55:17
	 * @param request
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = {"goWalletDetail", ""})
	public String goWalletDetail(HttpServletRequest request,HttpServletResponse response,Model model,UsersAccountOperate usersAccountOperate) {
		Page<UsersAccountOperate> page=walletService.findListByUserId(new Page<UsersAccountOperate>(request, response),usersAccountOperate);
		for(UsersAccountOperate u:page.getList()){
			u.setOperateType(DictUtils.getDictLabel(u.getOperateType(),"users_account_operate_operate_type",u.getOperateType()));
		}
		List<Dict> operateTypeList=DictUtils.getDictList("users_account_operate_operate_type");
		Users user=usersService.findUserById(usersAccountOperate.getUserid());
		model.addAttribute("user", user);
		model.addAttribute("operateTypeList", operateTypeList);
		model.addAttribute("page", page);
		return "modules/finance/walletDetail";
	}
	
	/**
	 * @description	钱包列表导出
	 * @author 文帅
	 * @date 2017年8月14日 下午4:55:32
	 * @param users
	 * @param response
	 * @param request
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/export")
	public String export(Users users,HttpServletResponse response,HttpServletRequest request, RedirectAttributes redirectAttributes){
		List<Users> usersList= usersService.findPassUsersList(users);
		List<ExportUsersWallet> list=new ArrayList<ExportUsersWallet>();
		for(Users u:usersList){
			ExportUsersWallet exportUsersWallet=new ExportUsersWallet();
			exportUsersWallet.setUsername(u.getUsername());
			exportUsersWallet.setTruename(u.getTruename());
			exportUsersWallet.setPhoneno(u.getPhoneno());
			exportUsersWallet.setUserSort(DictUtils.getDictLabel(u.getUserSort(),"users_user_sort",u.getUserSort()));
			if(null==u.getAccountMoney()){
				exportUsersWallet.setAccountMoney("0.00");
			}else{
				exportUsersWallet.setAccountMoney(StringUtils.formatNumberToString(u.getAccountMoney(), "0.00"));
			}
			if(null==u.getCurrentPoint()){
				exportUsersWallet.setCurrentPoint("0.00");
			}else{
				exportUsersWallet.setCurrentPoint(StringUtils.formatNumberToString(u.getCurrentPoint(),"0"));
			}
			list.add(exportUsersWallet);
		}
		try {
			new ExportExcel("钱包管理", ExportUsersWallet.class, 2).setDataList(list).write(response, "钱包管理.xlsx").dispose();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect: ${adminPath}/finance/wallet/list";
	}
	
	/**
	 * @description	钱包明细导出
	 * @author 文帅
	 * @date 2017年8月14日 下午5:22:48
	 * @param users
	 * @param response
	 * @param request
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/walletDetailExport")
	public String walletDetailExport(UsersAccountOperate usersAccountOperate,HttpServletResponse response,HttpServletRequest request, RedirectAttributes redirectAttributes){
		List<UsersAccountOperate> accountOperateList= walletService.findList(usersAccountOperate);
		List<ExportWalletDetail> list=new ArrayList<ExportWalletDetail>();
		for(UsersAccountOperate u:accountOperateList){
			ExportWalletDetail exportWalletDetail=new ExportWalletDetail();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			String DateStr=sdf.format(u.getCreateDate());
			exportWalletDetail.setCreatDate(DateStr);
			exportWalletDetail.setOperateType(DictUtils.getDictLabel(u.getOperateType(),"users_account_operate_operate_type",u.getOperateType()));
			if(null==u.getOperatMoney()){
				exportWalletDetail.setOperatMoney("0.00");
			}else{
				exportWalletDetail.setOperatMoney(StringUtils.formatNumberToString(u.getOperatMoney(),"0.00"));
			}
			if(null==u.getIntegralScore()){
				exportWalletDetail.setIntegralScore("0");
			}else{
				exportWalletDetail.setIntegralScore(StringUtils.formatNumberToString(u.getIntegralScore(),"0"));
			}
			if(null==u.getRestMoney()){
				exportWalletDetail.setRestMoney("0.00");
			}else{
				exportWalletDetail.setRestMoney(StringUtils.formatNumberToString(u.getRestMoney(),"0.00"));
			}
			if(null==u.getTotalScore()){
				exportWalletDetail.setTotalScore("0");
			}else{
				exportWalletDetail.setTotalScore(StringUtils.formatNumberToString(u.getTotalScore(),"0"));
			}
			list.add(exportWalletDetail);
		}
		try {
			new ExportExcel("钱包明细", ExportWalletDetail.class, 2).setDataList(list).write(response, "钱包明细.xlsx").dispose();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect: ${adminPath}/finance/wallet/goWalletDetail";
	}
}
