package com.thinkgem.jeesite.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.common.entity.UsersAccountOperate;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
@MyBatisDao
public interface UsersAccountOperateMapper {
    int deleteByPrimaryKey(String id);

    int insert(UsersAccountOperate record);

    int insertSelective(UsersAccountOperate record);

    UsersAccountOperate selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UsersAccountOperate record);

    int updateByPrimaryKey(UsersAccountOperate record);
    
    List<UsersAccountOperate> findListByUserId(UsersAccountOperate  usersAccountOperate);
    
    /**
     * 查询详情
     * @author liusiyu
     * @date 2017-9-5
     * @param userId
     * @return
     */
    List<UsersAccountOperate> findInfoListByUserId(@Param("userId")String userId);
    /**
     * 查询提现&充值最新信息
     * @author liusiyu
     * @date 2017-9-5
     * @param userId
     * @return
     */
    UsersAccountOperate findLateWithdrawCashInfo(@Param("userId")String userId);
    UsersAccountOperate findLateRechargeInfo(@Param("userId")String userId);

}