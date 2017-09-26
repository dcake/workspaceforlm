package com.thinkgem.jeesite.mobile.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.dao.UsersBankCardMapper;
import com.thinkgem.jeesite.common.entity.UsersBankCard;
import com.thinkgem.jeesite.common.utils.AjaxBeanUtil;
import com.thinkgem.jeesite.common.utils.IdGen;

/**
 * @desc 个人中心--钱包--银行卡Service
 * @author yaotengfei
 * @date 2017年9月2日上午9:27:27
 */
@Service
@Transactional
public class MobileCommonBankCardService {

	@Autowired
	private UsersBankCardMapper usersBankCardMapper;
	
	/**
	 * @desc 获取银行卡列表
	 * @author yaotengfei
	 * @date 2017年9月2日上午9:49:46
	 * @param userId
	 * @return
	 */
	public AjaxBeanUtil getBankCardListByUserId(String userId){
		List<UsersBankCard> usersBankCardList = usersBankCardMapper.getBankCardListByUserId(userId);
		if(usersBankCardList.size() == 0){
			return new AjaxBeanUtil("暂无数据", false);
		}
		return new AjaxBeanUtil("success", true, usersBankCardList);
	}
	
	/**
	 * @desc 添加银行卡
	 * @author yaotengfei
	 * @date 2017年9月2日上午10:55:27
	 * @param usersBankCard
	 * @return
	 */
	public AjaxBeanUtil addBankCard(UsersBankCard usersBankCard){
		//根据卡号判断是否已添加过
		UsersBankCard bankCard = usersBankCardMapper.getByBankCardNoAndUserId(usersBankCard.getUserId(),usersBankCard.getBankCardNo());
		if(bankCard == null){
			usersBankCard.setId(IdGen.uuid());
			usersBankCard.setDelFlag("0");
			usersBankCard.preInsert();
			usersBankCardMapper.insertSelective(usersBankCard);
		}else{
			if(bankCard.getDelFlag().equals("0")){
				return new AjaxBeanUtil("银行卡已存在", false);
			}else{
				bankCard.setDelFlag("0");
				bankCard.preUpdate();
				usersBankCardMapper.updateByPrimaryKeySelective(bankCard);
			}
		}
		return new AjaxBeanUtil("添加成功", true);
	}
	
	/**
	 * @desc 删除银行卡
	 * @author yaotengfei
	 * @date 2017年9月2日上午11:16:45
	 * @param bankCardId
	 * @return
	 */
	public AjaxBeanUtil delBankCard(String bankCardId){
		UsersBankCard usersBankCard = usersBankCardMapper.selectByPrimaryKey(bankCardId);
		if(usersBankCard == null){
			return new AjaxBeanUtil("信息错误", false);
		}
		usersBankCard.setDelFlag("1");
		usersBankCard.preUpdate();
		usersBankCardMapper.updateByPrimaryKeySelective(usersBankCard);
		return new AjaxBeanUtil("已删除", true);
	}
}
