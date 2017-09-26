package com.thinkgem.jeesite.modules.driver.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sourceforge.pinyin4j.PinyinHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.dao.DriveFleetMapper;
import com.thinkgem.jeesite.common.dao.DriveOrderMapper;
import com.thinkgem.jeesite.common.dao.DriversMapper;
import com.thinkgem.jeesite.common.dao.UsersMapper;
import com.thinkgem.jeesite.common.entity.DriveFleet;
import com.thinkgem.jeesite.common.entity.DriveOrder;
import com.thinkgem.jeesite.common.entity.Drivers;
import com.thinkgem.jeesite.common.entity.Users;
import com.thinkgem.jeesite.common.persistence.FileOperatEntity;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.AjaxBeanUtil;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.common.utils.SpringMvcUploadUtil;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.thinkgem.jeesite.modules.sys.service.SystemService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 
 * 王涛 车主管理
 */
@Service("driversServce")
@Transactional
public class DriversServce {
	@Autowired
	private DriversMapper driversMapper;
	@Autowired
	private UsersMapper usersMapper;
	@Autowired
	private DriveFleetMapper driveFleetMapper;
	@Autowired
	private DriveOrderMapper driveOrderMapper;

	public Page<Drivers> findPage(Page<Drivers> page, Drivers drivers) {
		drivers.setPage(page);
		page.setList(driversMapper.findList(drivers));
		return page;
	}

	/**
	 * @description 通过车主ID查询车主订单明细
	 * @author 文帅
	 * @date 2017年8月19日 上午11:12:53
	 * @param page
	 * @param driveOrder
	 * @return
	 */
	public Page<DriveOrder> findOrderList(Page<DriveOrder> page, DriveOrder driveOrder) {
		driveOrder.setPage(page);
		page.setList(driveOrderMapper.findListByDriversId(driveOrder));
		return page;
	}

	public Drivers findById(String id) {
		return driversMapper.selectByPrimaryKeyId(id);
	}

	public Drivers findByOrderId(String id) {
		return driversMapper.findOrderListId(id);
	}

	public List<DriveFleet> findDriveFleetList(DriveFleet driveFleet) {
		return driveFleetMapper.findDriveFleetList(driveFleet);
	}

	public DriveFleet getDriveFleet(DriveFleet driveFleet) {
		return driveFleetMapper.selectByPrimaryKey(driveFleet.getId());
	}

	/**
	 * 王涛 保存
	 */
	public AjaxBeanUtil saveDrivers(Users u, HttpServletRequest request) {
		if (StringUtils.isEmpty(u.getId()) || "undefined".equals(u.getId())) {
			// 上传附件，返回上传结果
			List<FileOperatEntity> fileList = null;
			try {
				fileList = SpringMvcUploadUtil.upload(request);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			String truckNo = request.getParameter("truckNo");
			Drivers drivers = new Drivers();
			// 车牌信息
			Drivers licenceInfo = driversMapper.getDriversByTruckNo(truckNo, null);
			if (licenceInfo != null) {
				return new AjaxBeanUtil("该车牌号已存在", false);
			}
			// 保存用户信息
			u.setId(IdGen.uuid());
			u.setPassword(SystemService.entryptPassword(u.getPassword()));
			// u.setStatus("0");//0正常 1锁定
			u.setUserSort("1");// 0货主 1车主 2经纪人
			u.setSpell(getPinYinHeadChar(u.getTruename()));// 拼音简写
			u.setExamineStatus("0");// 待审核状态 默认 0 待审核 1已审核 2审核未通过
			u.preInsert();
			// 将上传结果赋值到对象
			if (null != fileList) {
				SpringMvcUploadUtil.setObjectPropertyAndDelOldFile(fileList, u);
			}
			usersMapper.insertSelective(u);
			// 保存车主信息
			String truckType = request.getParameter("truckType");
			String truckLength = request.getParameter("truckLength");
			String truckMaxwight = request.getParameter("truckMaxwight");
			String driveFleetId = request.getParameter("driveFleetId");
			if("".equals(driveFleetId)){
				driveFleetId=null;
			}
			String truckWidth = request.getParameter("truckWidth");
			drivers.setId(IdGen.uuid());
			drivers.setUserid(u.getId());
			drivers.setDriveFleetId(driveFleetId);
			drivers.setTruckNo(truckNo);
			drivers.setTruckType(truckType);
			drivers.setTruckLength(truckLength);
			drivers.setTruckMaxwight(truckMaxwight);
			drivers.setTruckWidth(truckWidth);
			if(StringUtils.isBlank(driveFleetId)){
				drivers.setDriverType("0");// 0普通车主 1队员 2车队长）
			}else{
				drivers.setDriverType("1");// 0普通车主 1队员 2车队长）
			}
			drivers.setIsOrgDriver(u.getLevel());// 是否为公司内部车主(0否 1是)
			drivers.preInsert();
			// 将上传结果赋值到对象
			if (null != fileList) {
				SpringMvcUploadUtil.setObjectPropertyAndDelOldFile(fileList, drivers);
			}
			driversMapper.insertSelective(drivers);
			return new AjaxBeanUtil("保存成功", true, u);
		}
		return new AjaxBeanUtil("保存失败", false, u);
	}

	/**
	 * @desc 根据字符串获取首字母
	 * @author wangtao
	 * @return
	 */
	public String getPinYinHeadChar(String str) {
		String convert = "";
		for (int j = 0; j < str.length(); j++) {
			char word = str.charAt(j);
			String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
			if (pinyinArray != null) {
				convert += pinyinArray[0].charAt(0);
			} else {
				convert += word;
			}
		}
		return convert;
	}

	public void updateInfo(Users users) {
		if (users != null) {
			usersMapper.updateByPrimaryKeySelective(users);
		}
	}

	public void updateInfo1(Drivers drivers) {
		if (drivers != null) {
			driversMapper.updateByPrimaryKeySelective(drivers);
		}
	}

	public Drivers findByUserId(String userId) {
		return driversMapper.findByUserId(userId);
	}

	/**
	 * 锁定
	 * 
	 * @return
	 */
	public AjaxBeanUtil lock(String id) {
		Principal principal = UserUtils.getPrincipal();
		Users u = usersMapper.selectByPrimaryKey(id);
		try {
			if (u != null) {
				u.setStatus("1");// 1锁定 0正常
				u.setUpdateDate(new Date());
				u.setUpdateBy(principal.getName());
				usersMapper.updateByPrimaryKeySelective(u);
				return new AjaxBeanUtil("锁定成功", true);
			}
			return new AjaxBeanUtil("锁定失败", true);
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxBeanUtil("系统异常", false);
		}
	}

	/**
	 * 解锁
	 */
	public AjaxBeanUtil clear(String id) {
		Principal principal = UserUtils.getPrincipal();
		Users u = usersMapper.selectByPrimaryKey(id);
		try {
			if (u != null) {
				u.setStatus("0");// 1锁定 0正常
				u.setUpdateDate(new Date());
				u.setUpdateBy(principal.getName());
				usersMapper.updateByPrimaryKeySelective(u);
				return new AjaxBeanUtil("解锁成功", true);
			}
			return new AjaxBeanUtil("解锁失败", true);
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxBeanUtil("系统异常", false);
		}
	}

	/**
	 * 王涛 编辑
	 */
	public AjaxBeanUtil update(Users us, HttpServletRequest request) {
		try {
			// 上传附件，返回上传结果
			List<FileOperatEntity> fileList = SpringMvcUploadUtil.upload(request);
			// 修改车主信息
			Drivers drivers = driversMapper.findDriverByUserId(us.getId());
			String truckNo = request.getParameter("truckNo");
			// 车牌信息
			Drivers licenceInfo = driversMapper.getDriversByTruckNo(truckNo, drivers.getId());
			if (licenceInfo != null) {
				return new AjaxBeanUtil("该车牌号已存在", false);
			}
			String truckType = request.getParameter("truckType");
			String truckLength = request.getParameter("truckLength");
			String truckWidth = request.getParameter("truckWidth");
			String truckMaxwight = request.getParameter("truckMaxwight");
			String driveFleetId = request.getParameter("driveFleetId");
			if("".equals(driveFleetId)){
				driveFleetId=null;
			}
			drivers.setTruckNo(truckNo);
			drivers.setTruckType(truckType);
			drivers.setTruckLength(truckLength);
			drivers.setTruckMaxwight(truckMaxwight);
			drivers.setDriveFleetId(driveFleetId);
			drivers.setTruckWidth(truckWidth);
			if(StringUtils.isNotBlank(driveFleetId)){
				if(driveFleetId.equals(drivers.getDriveFleetId())){
				}else{
					drivers.setDriverType("1");// 0普通车主 1队员 2车队长）
				}
			}else{
				drivers.setDriverType("0");// 0普通车主 1队员 2车队长）
			}
			drivers.setIsOrgDriver(us.getLevel());// 是否为公司内部车主(0否 1是)
			drivers.preUpdate();
			// 将上传结果赋值到对象
			SpringMvcUploadUtil.setObjectPropertyAndDelOldFile(fileList, drivers);
			driversMapper.updateByPrimaryKey(drivers);
			// 修改用户信息
			if (StringUtils.isNotBlank(us.getPassword())) {
				us.setPassword(SystemService.entryptPassword(us.getPassword()));
			}
			// 将上传结果赋值到对象
			SpringMvcUploadUtil.setObjectPropertyAndDelOldFile(fileList, us);
			us.preUpdate();
			usersMapper.updateByPrimaryKeySelective(us);
			return new AjaxBeanUtil("修改成功", true);
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxBeanUtil("系统异常", false);
		}
	}

	public Drivers findDriveId(String id) {
		return driversMapper.selectByPrimaryKey(id);
	}

	public Drivers findDriverByUserId(String userId) {
		return driversMapper.findDriverByUserId(userId);
	}

	/**
	 * 通过用户ID查询用户实体
	 * 
	 * @param userId
	 * @return
	 */
	public Users findUserByUserId(String userId) {
		return usersMapper.selectByPrimaryKey(userId);
	}

	public DriveFleet findDriveFleetId(String driveFleetId) {
		return driveFleetMapper.selectByPrimaryKey(driveFleetId);
	}

	/**
	 * @description ：根据用户编号获取车主
	 * @author pangchengxiang
	 * @date 2017年8月23日 下午2:41:28
	 * @return Drivers
	 */
	public Drivers findDriverByUserno(Drivers drivers) {
		// TODO Auto-generated method stub
		return driversMapper.findDriverByUserno(drivers);
	}

	/**
	 * @description ：通过车主id查询该车主所在车队的所以成员
	 * @author pangchengxiang
	 * @date 2017年8月23日 下午6:28:06
	 * @return List<Drivers>
	 */
	public List<Drivers> findFleetMemberListByDriverId(DriveFleet driverFleet) {
		return driveFleetMapper.findFleetMemberListById(driverFleet);
	}

}
