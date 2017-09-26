package com.thinkgem.jeesite.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.common.entity.Users;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.mobile.entity.RecentPersonInfo;
@MyBatisDao
public interface UsersMapper {
    int deleteByPrimaryKey(String id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(@Param("id")String id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
    //分类管理列表  by崔亚光
    List<Users> findList(Users user);

	List<Users> findUsersListForPage(Users users);
	//更新等级  by崔亚光
	void updateLevel(Users users);
	
	/**
	 * @desc 根据手机号、用户类型查询用户
	 * @author yaotengfei
	 * @date 2017年8月10日上午11:47:01
	 * @param phone
	 * @return
	 */
	Users selectByPhone(String phone,String userSort);
	
	Users getInfo(String id);//获取货主/车主详情 by 崔亚光

	Users getGoods(String id);//获取货主审核信息 by 崔亚光 

	List<Users> findUsersList(Users users);//用户审核列表

	Users getAgents(String id);//获取经纪人审核信息
	
	/**
	 * @description	查询经纪人列表
	 * @author 文帅
	 * @date 2017年8月22日 下午5:35:01
	 * @param paramMap
	 * @return
	 */
	List<Users> findAgentsList(Map<String, Object> paramMap);
	/**
	 * @description	根据经纪人ID查询经纪人信息
	 * @author 文帅
	 * @date 2017年8月23日 下午3:45:59
	 * @param agentId
	 * @return
	 */
	Users findAgentByAgentId(String agentId);

	/**
	 * @description	：查询审核通过的用户列表
	 * @author pangchengxiang
	 * @date 2017年8月26日 上午11:20:23
	 * @return List<Users>
	 */
	List<Users> findPassUsersList(Users users);
	
	/**
	 * @description	根据用户ID查询最近联系人列表
	 * @author 文帅
	 * @date 2017年9月4日 下午5:29:57
	 * @param paramMap
	 * @return
	 */
	List<RecentPersonInfo> findRecentPersonList(Map<String, Object> paramMap);
	/**
	 * @description	通过货主ID查询user
	 * @author 文帅
	 * @date 2017年9月8日 下午2:48:41
	 * @param goodsownersId
	 * @return
	 */
	Users findUserByGoodsownersId(String goodsownersId);
}