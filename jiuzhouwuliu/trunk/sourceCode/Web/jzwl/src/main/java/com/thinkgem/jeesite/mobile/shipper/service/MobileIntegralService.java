package com.thinkgem.jeesite.mobile.shipper.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.dao.IntegralRuleMapper;
import com.thinkgem.jeesite.common.dao.UsersIntegralRecordMapper;
import com.thinkgem.jeesite.common.dao.UsersMapper;
import com.thinkgem.jeesite.common.entity.IntegralRule;
import com.thinkgem.jeesite.common.entity.Users;
import com.thinkgem.jeesite.common.entity.UsersIntegralRecord;
import com.thinkgem.jeesite.common.utils.AjaxBeanUtil;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.mobile.utils.PageParam;

/**
 * @description 我的积分
 * @author 文帅
 * @date 2017年9月4日 上午10:32:12
 */
@Service
@Transactional
public class MobileIntegralService {
	@Autowired
	private UsersIntegralRecordMapper usersIntegralRecordMapper;
	@Autowired
	private UsersMapper usersMapper;
	@Autowired
	private IntegralRuleMapper integralRuleMapper;

	/**
	 * @description 查询我的积分列表
	 * @author 文帅
	 * @date 2017年9月4日 上午10:45:23
	 * @param currentPage
	 * @param userId
	 * @return
	 */
	public AjaxBeanUtil findInseranceList(String pageNo, String userId) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		Users user = usersMapper.selectByPrimaryKey(userId);
		int currentPage = Integer.parseInt(pageNo) * PageParam.DEFAULT_PAGESIZE;
		int pageSize = PageParam.DEFAULT_PAGESIZE;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		List<UsersIntegralRecord> list = usersIntegralRecordMapper.findInseranceList(paramMap);
		if (list.size() == 0) {
			return new AjaxBeanUtil("暂无数据", false);
		}
		jsonMap.put("currentPoint", user.getCurrentPoint());
		jsonMap.put("pageSize", pageSize);
		jsonMap.put("list", list);
		return new AjaxBeanUtil("查询成功", true, jsonMap);
	}

	/**
	 * @description 添加积分
	 * @author 文帅
	 * @date 2017年9月4日 上午11:28:42
	 * @param type
	 *            用于判断添加积分的时机（0-货主注册，1-车主注册，2-经纪人注册，3-每天登录，4-完善用户信息，5-评价订单，6-
	 *            完成一次交易）
	 * @param userId
	 *            当前用户ID
	 * @return
	 */
	public AjaxBeanUtil insertIntegral(String type, String userId) {
		Users user = usersMapper.selectByPrimaryKey(userId);
		IntegralRule integralRule = integralRuleMapper.findEntity();
		if (integralRule == null) {
			return new AjaxBeanUtil("暂无制定积分规则", false);
		} else {
			UsersIntegralRecord usersIntegralRecord = new UsersIntegralRecord();
			usersIntegralRecord.setId(IdGen.uuid());
			usersIntegralRecord.setUserid(userId);
			if ("0".equals(type)) {
				usersIntegralRecord.setIntegralDescribe("货主注册");
				usersIntegralRecord.setIntegralScore(integralRule.getGoodsownerRegister());
			} else if ("1".equals(type)) {
				usersIntegralRecord.setIntegralDescribe("车主注册");
				usersIntegralRecord.setIntegralScore(integralRule.getDriverRegister());
			} else if ("2".equals(type)) {
				usersIntegralRecord.setIntegralDescribe("经纪人注册");
				usersIntegralRecord.setIntegralScore(integralRule.getAgentRegister());
			} else if ("3".equals(type)) {
				usersIntegralRecord.setIntegralDescribe("每天登录");
				usersIntegralRecord.setIntegralScore(integralRule.getUserLogin());
			} else if ("4".equals(type)) {
				usersIntegralRecord.setIntegralDescribe("完善用户信息");
				usersIntegralRecord.setIntegralScore(integralRule.getImproveUserInfo());
			} else if ("5".equals(type)) {
				usersIntegralRecord.setIntegralDescribe("评价订单");
				usersIntegralRecord.setIntegralScore(integralRule.getRemarkOrder());
			} else if ("6".equals(type)) {
				usersIntegralRecord.setIntegralDescribe("完成交易");
				usersIntegralRecord.setIntegralScore(integralRule.getCompleteOrder());
			}
			usersIntegralRecord.setCreateBy(user.getTruename());
			usersIntegralRecord.setCreateDate(new Date());
			usersIntegralRecord.setUpdateBy(user.getTruename());
			usersIntegralRecord.setUpdateDate(new Date());
			usersIntegralRecordMapper.insertSelective(usersIntegralRecord);
			// 修改用户当前积分
			user.setCurrentPoint(user.getCurrentPoint() + usersIntegralRecord.getIntegralScore());
			user.setUpdateBy(user.getTruename());
			user.setUpdateDate(new Date());
			usersMapper.updateByPrimaryKeySelective(user);
		}
		return new AjaxBeanUtil("保存成功", true);
	}
}
