package com.thinkgem.jeesite.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.common.entity.UsersSuggestion;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
@MyBatisDao
public interface UsersSuggestionMapper {
    int deleteByPrimaryKey(String id);

    int insert(UsersSuggestion record);

    int insertSelective(UsersSuggestion record);

    UsersSuggestion selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UsersSuggestion record);

    int updateByPrimaryKey(UsersSuggestion record);
    
    /**
     * @desc 获取投诉建议列表
     * @author yaotengfei
     * @date 2017年8月17日上午10:13:05
     * @param usersSuggestionMapper
     * @return
     */
    List<UsersSuggestion> findUsersSuggestionListForPage(@Param("usersSuggestion")UsersSuggestion usersSuggestion);
    
    /**
     * @desc 获取投诉建议详情
     * @author yaotengfei
     * @date 2017年8月17日上午10:37:38
     * @param id
     * @return
     */
    UsersSuggestion findDetail(String id);
    
    /**
     * @desc app端获取投诉建议列表（分页）
     * @author yaotengfei
     * @date 2017年8月22日下午5:44:11
     * @return
     */
    List<UsersSuggestion> getSuggestionList(String userId, int currentPage, int pageSize);
}