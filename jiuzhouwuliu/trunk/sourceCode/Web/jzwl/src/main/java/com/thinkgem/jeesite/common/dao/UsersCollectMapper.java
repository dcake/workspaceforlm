package com.thinkgem.jeesite.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.common.entity.UsersCollect;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
@MyBatisDao
public interface UsersCollectMapper {
    int deleteByPrimaryKey(String id);

    int insert(UsersCollect record);

    int insertSelective(UsersCollect record);

    UsersCollect selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UsersCollect record);

    int updateByPrimaryKey(UsersCollect record);
    /**
     * @description	通过用户ID和经纪人ID查询该经纪人是否被当前用户收藏
     * @author 文帅
     * @date 2017年8月23日 下午2:48:21
     * @param AgentId
     * @param userId
     * @return
     */
    UsersCollect findCollect(@Param("collectUserid")String collectUserid,@Param("userId")String userId);

	List<UsersCollect> getList(Map<String, Object> paramMap);//我的收藏列表

	void backCollect(String collectUserid);//取消收藏  崔亚光

	UsersCollect getUserCollect(@Param("userid")String userid,@Param("collectUserid")String collectUserid);//收藏查找  崔亚光 

	List<UsersCollect> addCollectList(Map<String, Object> paramMap);//添加收藏列表  崔亚光 

	void deleteByUserId(@Param("userid")String userid, @Param("collectUserid")String collectUserid);//取消收藏  崔亚光
}