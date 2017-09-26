package com.thinkgem.jeesite.mobile.driver.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.thinkgem.jeesite.common.dao.DriveLineMapper;
import com.thinkgem.jeesite.common.dao.DriveOrderMapper;
import com.thinkgem.jeesite.common.dao.DriversMapper;
import com.thinkgem.jeesite.common.dao.UsersCollectMapper;
import com.thinkgem.jeesite.common.dao.UsersMapper;
import com.thinkgem.jeesite.common.entity.DriveLine;
import com.thinkgem.jeesite.common.entity.Drivers;
import com.thinkgem.jeesite.common.entity.Users;
import com.thinkgem.jeesite.common.entity.UsersCollect;
import com.thinkgem.jeesite.mobile.utils.AjaxBeanUtil;
import com.thinkgem.jeesite.mobile.utils.PageParam;

/**
 * @author 作者:cuiyg
 * @version 创建时间：2017年9月7日 下午4:18:29 类说明: 车辆管理service
 */
@Service
@Transactional
public class MobileDriversManagerService {
	@Autowired
	private DriversMapper driversMapper;
	@Autowired
	private DriveOrderMapper driveOrderMapper;
	@Autowired
	private UsersCollectMapper usersCollectMapper;
	@Autowired
	private DriveLineMapper driveLineMapper;
	@Autowired
	private UsersMapper usersMapper;

	/**
	 * 车辆管理列表 崔亚光 2017-09-06
	 * 
	 * @return
	 */
	public AjaxBeanUtil getList(String pageNo, String userid) {
		Drivers drivers = driversMapper.selectByUserid(userid);
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("drivers", drivers);
		if (StringUtils.isNotBlank(drivers.getDriveFleetId())) {
			int currentPage = Integer.parseInt(pageNo) * PageParam.DEFAULT_PAGESIZE;
			int pageSize = PageParam.DEFAULT_PAGESIZE;
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("userid", userid);
			paramMap.put("currentPage", currentPage);
			paramMap.put("pageSize", pageSize);
			paramMap.put("driveFleetId", drivers.getDriveFleetId());
			List<Drivers> list = driversMapper.findDriversList(paramMap);
			res.put("list", list);
			return new AjaxBeanUtil("查询成功", true, res);
		} else {
			return new AjaxBeanUtil("查询成功", true, res);
		}
	}

	/**
	 * 添加车辆 崔亚光 2017-09-08
	 */
	public AjaxBeanUtil addCar(Drivers record, HttpServletRequest request) {
		if (StringUtils.isEmpty(record.getTruckNo())) {
			return new AjaxBeanUtil("请输入车牌号！", false);
		}
		if (StringUtils.isEmpty(record.getTruckType())) {
			return new AjaxBeanUtil("请选择车型！", false);
		}
		if (StringUtils.isEmpty(record.getTruckLength())) {
			return new AjaxBeanUtil("请输入车长！", false);
		}
		if (StringUtils.isEmpty(record.getTruckMaxwight())) {
			return new AjaxBeanUtil("请输入承重！", false);
		}
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			// 图片存放路径
			String tempURL = "/upload/APPDriversImg/";
			// 获取在Web服务器上的 绝对路径
			String path = request.getSession().getServletContext().getRealPath("/") + tempURL;
			// 创建文件夹
			File folders = new File(path);
			if (!folders.exists() && !folders.isDirectory()) {
				folders.mkdirs();
			}
			int i = 1;
			while (iter.hasNext()) {
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					// 取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {
						// 获取文件扩展名
						String tail = "";
						String[] tmps = file.getOriginalFilename().split("\\.");
						if (tmps.length > 1) {
							tail = "." + tmps[tmps.length - 1];
						}
						// 生成随机文件名
						SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmmss");
						String fileName = df.format(new Date()) + "_" + new Random().nextInt(1000);
						// 合并文件名和扩展名
						fileName = fileName + tail;
						// 定义上传路径
						String imgPath = path + fileName;
						System.out.println("11111==" + imgPath);
						File localFile = new File(imgPath);
						try {
							file.transferTo(localFile);
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						if (i == 1) {
							record.setDriveLicenceImg1(tempURL + fileName);
						}
						if (i == 2) {
							record.setMoveLicenceImg1(tempURL + fileName);
						}
						i++;
					}
				}
			}
		}
		record.setIsHasCar("1");
		record.preUpdate();
		driversMapper.addCar(record);
		return new AjaxBeanUtil("添加成功", true);
	}

	/**
	 * 邀请队员 崔亚光 2017-09-09
	 * 
	 * @return
	 */
	public AjaxBeanUtil invite(String pageNo, String userid) {
		int currentPage = Integer.parseInt(pageNo) * PageParam.DEFAULT_PAGESIZE;
		int pageSize = PageParam.DEFAULT_PAGESIZE;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userid);
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		List<Drivers> list = driversMapper.findInviteList(paramMap);
		for (Drivers d : list) {
			d.setCount(driveOrderMapper.findCountByDriverId(d.getId()));
		}
		return new AjaxBeanUtil("查询成功", true, list);
	}

	/**
	 * 退出车队 崔亚光 2017-09-11
	 */
	public AjaxBeanUtil exitDriveFleet(Drivers record) {
		record.setDriveFleetId(null);
		driversMapper.exitDriveFleet(record);
		return new AjaxBeanUtil("退出成功", true);
	}

	/**
	 * 取消收藏 崔亚光 2017-09-11
	 */
	public AjaxBeanUtil backCollect(String collectUserid) {
		usersCollectMapper.backCollect(collectUserid);
		return new AjaxBeanUtil("取消收藏成功", true);
	}

	/**
	 * 转让身份车队人员列表 崔亚光 2017-09-11
	 * 
	 * @return
	 */
	public AjaxBeanUtil changeBodyList(String pageNo, String driveFleetId) {
		int currentPage = Integer.parseInt(pageNo) * PageParam.DEFAULT_PAGESIZE;
		int pageSize = PageParam.DEFAULT_PAGESIZE;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("driveFleetId", driveFleetId);
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		List<Drivers> list = driversMapper.changeBodyList(paramMap);
		return new AjaxBeanUtil("查询成功", true, list);
	}

	/**
	 * 转让身份 崔亚光 2017-09-11
	 */
	public AjaxBeanUtil changeBody(String id) {
		Drivers d = driversMapper.selectByPrimaryKey(id);
		if (d.getIsHasCar().equals("1")) {
			driversMapper.changeBody(id);
			return new AjaxBeanUtil("转让成功", true);
		} else {
			return new AjaxBeanUtil("请先进行车辆认证", true);
		}

	}

	/**
	 * 线路记录 崔亚光 2017-09-12
	 */
	public AjaxBeanUtil driveLine(String pageNo, String driverId) {
		int currentPage = Integer.parseInt(pageNo) * PageParam.DEFAULT_PAGESIZE;
		int pageSize = PageParam.DEFAULT_PAGESIZE;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("driverId", driverId);
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		List<DriveLine> list = driveLineMapper.findLineList(paramMap);
		return new AjaxBeanUtil("查询成功", true, list);
	}

	/**
	 * 根据车主ID查询车主详情
	 * 
	 * @author 崔亚光 2017-09-19
	 * @param userid
	 * @return
	 */
	public AjaxBeanUtil driverDetail(String driverUserId, String userid) {
		Drivers drivers = driversMapper.findDriverByUserId(driverUserId);
		Users user = usersMapper.selectByPrimaryKey(driverUserId);
		if (drivers == null) {
			return new AjaxBeanUtil("车主不存在", false);
		}
		drivers.setHeadImg(user.getHeadImg());
		drivers.setTruename(user.getTruename());
		drivers.setIsTrueName(user.getIsTruename());
		drivers.setPersonDescribe(user.getPersonDescribe());
		drivers.setPhoneno(user.getPhoneno());
		Integer transportCount = driveOrderMapper.findCountByDriverId(drivers.getId());// 运输次数
		drivers.setTransportCount(transportCount);
		UsersCollect usersCollect = usersCollectMapper.findCollect(driverUserId, userid);
		// 判断该经纪人是否被当前用户收藏（0-否，1-是）
		if (usersCollect != null) {
			drivers.setIsCollect("1");
		} else {
			drivers.setIsCollect("0");
		}
		return new AjaxBeanUtil("查询成功", true, drivers);
	}

}
