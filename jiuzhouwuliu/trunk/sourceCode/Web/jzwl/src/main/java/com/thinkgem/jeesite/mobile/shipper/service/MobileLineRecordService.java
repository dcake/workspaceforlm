package com.thinkgem.jeesite.mobile.shipper.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.dao.GoodsMapper;
import com.thinkgem.jeesite.common.dao.UsersMapper;
import com.thinkgem.jeesite.common.entity.Goods;
import com.thinkgem.jeesite.common.utils.AjaxBeanUtil;
import com.thinkgem.jeesite.mobile.utils.PageParam;

/**
 * @description 线路记录
 * @author 文帅
 * @date 2017年9月4日 下午3:17:36
 */
@Service
@Transactional
public class MobileLineRecordService {
	@Autowired
	private UsersMapper usersMapper;
	@Autowired
	private GoodsMapper goodsMapper;

	/**
	 * @description 根据用户ID查询路线记录列表
	 * @author 文帅
	 * @date 2017年9月4日 下午3:57:45
	 * @param pageNo
	 * @param userId
	 * @return
	 */
	public AjaxBeanUtil findLineList(String pageNo, String userId) {
		int currentPage = Integer.parseInt(pageNo) * PageParam.DEFAULT_PAGESIZE;
		int pageSize = PageParam.DEFAULT_PAGESIZE;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		List<Goods> list = goodsMapper.findLineList(paramMap);
		if (list.size() == 0) {
			return new AjaxBeanUtil("暂无数据", false);
		}
		return new AjaxBeanUtil("查询成功", true, list);
	}
}
