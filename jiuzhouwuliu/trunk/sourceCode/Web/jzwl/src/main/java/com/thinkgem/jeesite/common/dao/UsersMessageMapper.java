package com.thinkgem.jeesite.common.dao;

import java.util.List;
import java.util.Map;

import com.thinkgem.jeesite.common.entity.UsersMessage;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
@MyBatisDao
public interface UsersMessageMapper {
    int deleteByPrimaryKey(String id);

    int insert(UsersMessage record);

    int insertSelective(UsersMessage record);

    UsersMessage selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UsersMessage record);

    int updateByPrimaryKey(UsersMessage record);
    
    /**
     * 根据消息分类查询消息列表
     *   
     * @author 张彦学
     * 日期 2017年9月4日
     * @param paramMap
     * @return
     */
    List<UsersMessage> findmessageByMessageType(Map<String, Object> paramMap);
    
    /**
     * 根据消息分类查询未读消息数
     *   
     * @author 张彦学
     * 日期 2017年9月4日
     * @param paramMap
     * @return
     */
    int findmessageNotLookByMessageType(Map<String, Object> paramMap);
}