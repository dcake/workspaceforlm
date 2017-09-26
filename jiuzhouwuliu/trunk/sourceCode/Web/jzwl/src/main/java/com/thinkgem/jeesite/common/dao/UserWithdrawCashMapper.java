package com.thinkgem.jeesite.common.dao;

import java.util.List;

import com.thinkgem.jeesite.common.entity.UserWithdrawCash;
import com.thinkgem.jeesite.common.entity.Users;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
@MyBatisDao
public interface UserWithdrawCashMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserWithdrawCash record);

    int insertSelective(UserWithdrawCash record);

    UserWithdrawCash selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserWithdrawCash record);

    int updateByPrimaryKey(UserWithdrawCash record);
    /**
     * @description	查询提现申请列表
     * @author 文帅
     * @date 2017年8月8日 下午4:02:15
     * @param userId
     * @return
     */
    public List<UserWithdrawCash> findWithdrawCashList(UserWithdrawCash userWithdrawCash);
    //分类管理列表  
	List<UserWithdrawCash> findList(UserWithdrawCash userWithdrawCash);
}