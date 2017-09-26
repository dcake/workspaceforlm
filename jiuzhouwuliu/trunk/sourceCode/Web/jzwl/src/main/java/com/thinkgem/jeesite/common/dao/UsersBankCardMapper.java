package com.thinkgem.jeesite.common.dao;

import java.util.List;

import com.thinkgem.jeesite.common.entity.UsersBankCard;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
@MyBatisDao
public interface UsersBankCardMapper {
    int deleteByPrimaryKey(String id);

    int insert(UsersBankCard record);

    int insertSelective(UsersBankCard record);

    UsersBankCard selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UsersBankCard record);

    int updateByPrimaryKey(UsersBankCard record);
    /**
     * @description	查询银行卡列表
     * @author 王瀚
     * @return
     */
    List<UsersBankCard> findBankList();
    
    /**
     * @desc 获取银行卡列表
     * @author yaotengfei
     * @date 2017年9月2日上午10:49:07
     * @param userId
     * @return
     */
    List<UsersBankCard> getBankCardListByUserId(String userId);
    
    /**
     * @desc 根据卡号和userId查询
     * @author yaotengfei
     * @date 2017年9月2日上午10:58:32
     * @param bankCardNo
     * @return
     */
    UsersBankCard getByBankCardNoAndUserId(String userId,String bankCardNo);
}