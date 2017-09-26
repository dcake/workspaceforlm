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

import com.thinkgem.jeesite.common.entity.DriveOrder;
import com.thinkgem.jeesite.common.entity.Users;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import com.thinkgem.jeesite.modules.finance.entity.ExportDriveOrder;
import com.thinkgem.jeesite.modules.finance.entity.ExportUsersWallet;
import com.thinkgem.jeesite.modules.finance.service.InformationFeeService;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;

/**
 * @description	信息费管理
 * @author 文帅
 * @date 2017年8月7日 下午2:16:17
 */
@Controller
@RequestMapping(value="${adminPath}/finance/informationFee")
public class InformationFeeController {
	@Autowired
	private InformationFeeService informationFeeService;
	/**
	 * @description	跳转到信息费管理列表页面
	 * @author 文帅
	 * @date 2017年8月7日 下午2:18:10
	 * @param request
	 * @return
	 */
	@RequestMapping(value = {"list", ""})
	public String list(HttpServletRequest request,HttpServletResponse response,Model model,DriveOrder driveOrder) {
		Page<DriveOrder> page = informationFeeService.findInfoFeeList(new Page<DriveOrder>(request, response), driveOrder);
		double subtotal = 0;
		for(DriveOrder u:page.getList()){
			u.setUserSort(DictUtils.getDictLabel(u.getUserSort(),"users_user_sort",u.getUserSort()));
			subtotal+=u.getDeposit();
		}
		model.addAttribute("subtotal", subtotal);
		model.addAttribute("page", page);
		return "modules/finance/informationFeeList";
	}
	
	/**
	 * @description	导出
	 * @author 文帅
	 * @date 2017年8月15日 上午9:20:29
	 * @param users
	 * @param response
	 * @param request
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/export")
	public String export(DriveOrder driveOrder,HttpServletResponse response,HttpServletRequest request, RedirectAttributes redirectAttributes){
		List<DriveOrder> driveOrderList= informationFeeService.findList(driveOrder);
		List<ExportDriveOrder> list=new ArrayList<ExportDriveOrder>();
		double totalMoney=0;
		for(DriveOrder d:driveOrderList){
			ExportDriveOrder exportDriveOrder=new ExportDriveOrder();
			exportDriveOrder.setUsername(d.getUsername());
			exportDriveOrder.setTruename(d.getTruename());
			exportDriveOrder.setPhoneno(d.getPhoneno());
			exportDriveOrder.setUserSort(DictUtils.getDictLabel(d.getUserSort(),"users_user_sort",d.getUserSort()));
			if(null==d.getDeposit()){
				exportDriveOrder.setDeposit("0.00");
			}else{
				totalMoney+=d.getDeposit();
				exportDriveOrder.setDeposit(StringUtils.formatNumberToString(d.getDeposit(),"0.00"));
			}
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
			String DateStr=sdf.format(d.getCreateDate());
			exportDriveOrder.setTime(DateStr);
			exportDriveOrder.setOrderNo(d.getOrderNo());
			list.add(exportDriveOrder);
		}
		try {
			ExportDriveOrder exportDriveOrder=new ExportDriveOrder();
			exportDriveOrder.setTruename("小计");
			exportDriveOrder.setDeposit(StringUtils.formatNumberToString(totalMoney,"0.00"));
			list.add(exportDriveOrder);
			new ExportExcel("信息费管理", ExportDriveOrder.class, 2).setDataList(list).write(response, "信息费管理.xlsx").dispose();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect: ${adminPath}/finance/informationFee/list";
	}
}
