package com.thinkgem.jeesite.modules.driver.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.entity.DriveFleet;
import com.thinkgem.jeesite.common.entity.DriveOrder;
import com.thinkgem.jeesite.common.entity.Drivers;
import com.thinkgem.jeesite.common.entity.Users;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.AjaxBeanUtil;
import com.thinkgem.jeesite.common.utils.CacheUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.driver.service.DriversServce;
import com.thinkgem.jeesite.modules.sys.entity.Dict;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;

/**
 * 
 * @author 王涛
 */
@Controller
@RequestMapping(value = "${adminPath}/driver/driverList")
public class DriverController extends BaseController {
	@Autowired
	private DriversServce driversServce;

	@RequestMapping(value = "list")
	public String list(Drivers drivers, HttpServletRequest request, HttpServletResponse response, Model model) {
		// 从缓存里取字典列表 搜索内容
		Map<String, List<Dict>> dictMap = (Map<String, List<Dict>>) CacheUtils.get("dictMap");
		if (dictMap != null) {
			// 审核状态
			model.addAttribute("driverStatus", dictMap.get("driver_master_change_auditing_status"));
			// 等级
			model.addAttribute("carLevel", dictMap.get("car_level"));
		}
		Page<Drivers> page = driversServce.findPage(new Page<Drivers>(request, response), drivers);
		// 页面显示数据 非数据库字段字符串
		for (Drivers d : page.getList()) {
			// 用户状态 0正常 1锁定
			d.setUsersStatus(DictUtils.getDictLabel(d.getUsersStatus(), "users_status", d.getUsersStatus()));
			// 审核状态 0未审核 1已审核 2审核未通过
			d.setDriverMasterChangeAuditingStatus(DictUtils.getDictLabel(d.getDriverMasterChangeAuditingStatus(), "driver_master_change_auditing_status", d.getDriverMasterChangeAuditingStatus()));
			d.setLevel(DictUtils.getDictValue(d.getLevel(), "car_level", d.getLevel()));
		}
		model.addAttribute("page", page);
		return "modules/driver/driverList";
	}

	/**
	 * 王涛 添加车主连接
	 */
	@RequestMapping(value = "add")
	public String add(Drivers drivers, HttpServletRequest request, HttpServletResponse response, Model model) {
		DriveFleet driveFleet = new DriveFleet();
		// 获得车队实体
		List<DriveFleet> DriveFleetList = driversServce.findDriveFleetList(driveFleet);
		model.addAttribute("carLevel", DictUtils.getDictList("car_level"));
		model.addAttribute("status", DictUtils.getDictList("users_status"));
		model.addAttribute("truckType", DictUtils.getDictList("truck_type"));
		model.addAttribute("truckLength", DictUtils.getDictList("truck_length"));
		model.addAttribute("truckWidth", DictUtils.getDictList("truck_width"));
		model.addAttribute("truckMaxwight", DictUtils.getDictList("truck_maxwight"));
		model.addAttribute("DriveFleetList", DriveFleetList);
		return "modules/driver/infoDriver";
	}

	@RequestMapping(value = "saveDriver")
	@ResponseBody
	public AjaxBeanUtil saveDriver(Users users, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		return driversServce.saveDrivers(users, request);
	}

	/**
	 * 根据Id查询车主详情 王涛
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "info")
	public String info(Drivers driver, HttpServletRequest request, HttpServletResponse response, Model model) {
		Drivers drivers = driversServce.findDriveId(driver.getId());
		Users users = driversServce.findUserByUserId(drivers.getUserid());
		DictUtils.getDictLabel(users.getUsersStatus(), "users_status", users.getUsersStatus());
		DictUtils.getDictValue(users.getLevel(), "car_level", users.getLevel());
		DriveFleet driveFleet = driversServce.findDriveFleetId(drivers.getDriveFleetId());
		// 获得车队实体
		List<DriveFleet> DriveFleetList = driversServce.findDriveFleetList(driveFleet);
		List<Dict> usersStatus = DictUtils.getDictList("users_status");
		List<Dict> carLevel = DictUtils.getDictList("car_level");
		List<Dict> truckType = DictUtils.getDictList("truck_type");
		List<Dict> truckLength = DictUtils.getDictList("truck_length");
		List<Dict> truckWidth = DictUtils.getDictList("truck_width");
		List<Dict> truckMaxwight = DictUtils.getDictList("truck_maxwight");
		model.addAttribute("carLevel", carLevel);
		model.addAttribute("usersStatus", usersStatus);
		model.addAttribute("users", users);
		model.addAttribute("truckType", truckType);
		model.addAttribute("drivers", drivers);
		model.addAttribute("truckLength", truckLength);
		model.addAttribute("truckWidth", truckWidth);
		model.addAttribute("truckMaxwight", truckMaxwight);
		model.addAttribute("DriveFleetList", DriveFleetList);
		return "modules/driver/driverDetail";
	}

	/**
	 * 订单明细
	 */
	@RequestMapping(value = "order")
	public String order(DriveOrder driveOrder, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DriveOrder> page = driversServce.findOrderList(new Page<DriveOrder>(request, response), driveOrder);
		for (DriveOrder d : page.getList()) {
			d.setGoodsType(DictUtils.getDictLabel(d.getGoodsType(), "goods_type", d.getGoodsType()));
		}
		model.addAttribute("page", page);
		return "modules/driver/orderDetail";
	}

	/**
	 * 锁定
	 */
	@RequestMapping(value = "lock", method = RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil lock(String id) {
		return driversServce.lock(id);
	}

	/**
	 * 解锁
	 * 
	 */
	@RequestMapping(value = "clear", method = RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil clear(String id) {
		return driversServce.clear(id);
	}

	/**
	 * 王涛 编辑车主链接
	 */
	@RequestMapping(value = "edit")
	public String edit(Drivers driver, HttpServletRequest request, HttpServletResponse response, Model model) {
		Drivers drivers = driversServce.findDriveId(driver.getId());
		Users users = driversServce.findUserByUserId(drivers.getUserid());
		DictUtils.getDictLabel(users.getUsersStatus(), "users_status", users.getUsersStatus());
		DictUtils.getDictValue(users.getLevel(), "car_level", users.getLevel());
		DriveFleet driveFleet = driversServce.findDriveFleetId(drivers.getDriveFleetId());
		// 获得车队实体
		List<DriveFleet> DriveFleetList = driversServce.findDriveFleetList(driveFleet);
		List<Dict> usersStatus = DictUtils.getDictList("users_status");
		List<Dict> carLevel = DictUtils.getDictList("car_level");
		List<Dict> truckType = DictUtils.getDictList("truck_type");
		List<Dict> truckLength = DictUtils.getDictList("truck_length");
		List<Dict> truckWidth = DictUtils.getDictList("truck_width");
		List<Dict> truckMaxwight = DictUtils.getDictList("truck_maxwight");
		model.addAttribute("carLevel", carLevel);
		model.addAttribute("usersStatus", usersStatus);
		model.addAttribute("users", users);
		model.addAttribute("truckType", truckType);
		model.addAttribute("drivers", drivers);
		model.addAttribute("truckLength", truckLength);
		model.addAttribute("truckWidth", truckWidth);
		model.addAttribute("truckMaxwight", truckMaxwight);
		model.addAttribute("DriveFleetList", DriveFleetList);
		return "modules/driver/editDriver";
	}

	@RequestMapping(value = "update")
	@ResponseBody
	public AjaxBeanUtil update(Users us, HttpServletRequest request, HttpServletResponse response, Model model) {
		return driversServce.update(us, request);
	}
}
