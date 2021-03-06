package com.thinkgem.jeesite.mobile.shipper.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.dao.UsersBankCardMapper;
import com.thinkgem.jeesite.common.dao.UsersMapper;
import com.thinkgem.jeesite.common.entity.Goods;
import com.thinkgem.jeesite.common.entity.InseranceCompany;
import com.thinkgem.jeesite.common.entity.Users;
import com.thinkgem.jeesite.common.entity.UsersBankCard;
import com.thinkgem.jeesite.common.utils.AjaxBeanUtil;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.common.utils.StringUtils;

/**
 * @description	我的-银行卡
 * @author 王瀚
 */
@Service
@Transactional
public class MobileUsersBankCardService {
	@Autowired
	private UsersBankCardMapper usersBankCardMapper;
	@Autowired
	private UsersMapper usersMapper;
	/**
	 * @description	添加银行卡
	 * @author 王瀚
	 * @param usersBankCard
	 * @return
	 * @throws IOException 
	 * @throws  
	 */
	public AjaxBeanUtil addUsersBankCard(UsersBankCard usersBankCard,HttpServletRequest request){
		//判断持卡人信息
		if(StringUtils.isEmpty(usersBankCard.getBankCardPerson())){
			return new AjaxBeanUtil("请输入持卡人姓名",false);
		}
		if(usersBankCard.getBankCardPerson().length()>10){
			return new AjaxBeanUtil("持卡人名字字数过长，10个字符以内",false);
		}
		//判断卡号信息
		if(StringUtils.isEmpty(usersBankCard.getBankCardNo())){
			return new AjaxBeanUtil("请输入银行卡卡号",false);
		}
		if(usersBankCard.getBankCardNo().length()>20){
			return new AjaxBeanUtil("银行卡卡号字数过长，20个字符以内",false);
		}
		//判断银行信息
		
		Users user=usersMapper.selectByPrimaryKey(usersBankCard.getUserId());
		//保存银行卡信息
		usersBankCard.setId(IdGen.uuid());
		usersBankCard.setCreateBy(user.getTruename());
		usersBankCard.setCreateDate(new Date());
		usersBankCard.setUpdateBy(user.getTruename());
		usersBankCard.setUpdateDate(new Date());
		usersBankCardMapper.insertSelective(usersBankCard);
		return new AjaxBeanUtil("添加成功！",true,usersBankCard);
	}
	/**
	 * @description	查询银行列表
	 * @author 王瀚
	 * @return
	 */
	public AjaxBeanUtil findBankList(){
		try {
			List<UsersBankCard> list=usersBankCardMapper.findBankList();
			//银行卡只显示后四位
			for (UsersBankCard usersBankCard: list) {
				if (usersBankCard.getBankCardNo()!=null && !usersBankCard.getBankCardNo().equals("")) {
					int frontnum = usersBankCard.getBankCardNo().toString().length()-4;
					StringBuffer stringBuffer = new StringBuffer();
					for (int i=0 ; i<frontnum ;i++) {
						stringBuffer.append("*");
					}
					usersBankCard.setBankCardNo(stringBuffer.toString()+usersBankCard.getBankCardNo().toString().substring(usersBankCard.getBankCardNo().toString().length()-4, usersBankCard.getBankCardNo().toString().length()));
				}
			}

			return new AjaxBeanUtil("查询成功", true, list);
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxBeanUtil("系统异常", false);
		}
	}
}
