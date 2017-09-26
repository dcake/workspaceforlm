/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.dao;

import java.util.List;
import java.util.Map;

import com.thinkgem.jeesite.common.persistence.TreeDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sys.entity.Area;

/**
 * 区域DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
public interface AreaDao extends TreeDao<Area> {
	/**
	 * @description	根据城市类型和ID查询省市县（查询省份不用传ID）
	 * @author 文帅
	 * @date 2017年8月22日 上午10:16:25
	 * @param paramMap
	 * @return
	 */
	List<Area> findGeoInfo(Map<String, Object> paramMap); 
}
