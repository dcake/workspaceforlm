package com.thinkgem.jeesite.mobile.shipper.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.dao.DriversMapper;
import com.thinkgem.jeesite.common.entity.Drivers;
import com.thinkgem.jeesite.common.utils.AjaxBeanUtil;
import com.thinkgem.jeesite.mobile.utils.PageParam;
import com.thinkgem.jeesite.modules.sys.entity.Dict;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;

/**
 * @desc 货主app--找车service
 * @author yaotengfei
 * @date 2017年9月20日上午10:06:52
 */
@Service
@Transactional
public class MobileSearchDriverService {

	@Autowired
	private DriversMapper driversMapper;
	
	/**
	 * @desc 获取搜索条件
	 * @author yaotengfei
	 * @date 2017年9月20日上午10:33:03
	 * @return
	 */
	public AjaxBeanUtil getConditions(){
		//获取车型
		List<Dict> truckType = DictUtils.getDictList("truck_type");
		//获取车长
		List<Dict> truckLength = DictUtils.getDictList("truck_length");
		//获取车宽
		List<Dict> truckWidth = DictUtils.getDictList("truck_width");
		Map<String, Object> resutlMap = new HashMap<String, Object>();
		resutlMap.put("truckType", truckType);
		resutlMap.put("truckLength", truckLength);
		resutlMap.put("truckWidth", truckWidth);
		return new AjaxBeanUtil("success", true, resutlMap);
	}
	
	/**
	 * @desc 根据条件查询司机
	 * @author yaotengfei
	 * @date 2017年9月20日下午3:20:04
	 * @param drivers
	 * @param request
	 * @return
	 */
	public AjaxBeanUtil getDriverByCons(Drivers drivers,HttpServletRequest request){
		String areaCode = request.getParameter("areaCode");
		String current = request.getParameter("currentPage");
		int currentPage = (Integer.parseInt(current)-1)*PageParam.DEFAULT_PAGESIZE;
		PageParam pageParam = new PageParam();
		pageParam.setCurrentPage(currentPage);
		List<Drivers> driversList = driversMapper.getDriverByCons(pageParam, drivers,areaCode);
		if(driversList.size() == 0){
			return new AjaxBeanUtil("暂无数据", false);
		}
		//如果range有值
		/*String userGPS = request.getParameter("userGPS");
		String range = request.getParameter("ranges");
		double userLon = Double.parseDouble(userGPS.split(",")[0]);//用户经度
		double userLat = Double.parseDouble(userGPS.split(",")[1]);//用户维度
		 if(!StringUtils.isEmpty(range)){
			for(int i = 0; i < driversList.size(); i++){
				String drivergps = driversList.get(i).getGpsInfo();
				double driverLon = Double.parseDouble(drivergps.split(",")[0]);
				double driverLat = Double.parseDouble(drivergps.split(",")[1]);
				double distance = GetDistance(userLon,userLat,driverLon,driverLat);
				//获取范围在range内的司机
				if(Double.parseDouble(range)*1000 < distance){
					//如果司机在range之外，删除
					driversList.remove(i);
				}
			}
		}
		if(driversList.size() == 0){
			return new AjaxBeanUtil("暂无数据", false);
		}*/
		return new AjaxBeanUtil("success", true, driversList);
	}
	
	/**
	 * @desc 根据两点经纬度计算距离
	 * @author yaotengfei
	 * @date 2017年9月20日下午4:36:34
	 * @param lon1
	 * @param lat1
	 * @param lon2
	 * @param lat2
	 * @return
	 */
	public double GetDistance(double lon1,double lat1,double lon2, double lat2) {
		double EARTH_RADIUS = 6378137;//赤道半径
	    double radLat1 = rad(lat1);
	    double radLat2 = rad(lat2);
	    double a = radLat1 - radLat2;
	    double b = rad(lon1) - rad(lon2);
	    double s = 2 *Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2)+Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2))); 
	    s = s * EARTH_RADIUS;    
	    return s;//单位米
	}
	
	public double rad(double d){
		return d * Math.PI / 180.0;
	}

}
