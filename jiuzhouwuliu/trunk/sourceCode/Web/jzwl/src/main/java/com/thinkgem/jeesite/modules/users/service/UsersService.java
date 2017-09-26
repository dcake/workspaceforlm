package com.thinkgem.jeesite.modules.users.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.jmx.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.dao.AgentsMapper;
import com.thinkgem.jeesite.common.dao.DriversMapper;
import com.thinkgem.jeesite.common.dao.GoodsownersMapper;
import com.thinkgem.jeesite.common.dao.UsersMapper;
import com.thinkgem.jeesite.common.entity.Agents;
import com.thinkgem.jeesite.common.entity.Drivers;
import com.thinkgem.jeesite.common.entity.Goodsowners;
import com.thinkgem.jeesite.common.entity.Users;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.cms.entity.Article;

/**
 * @ClassName UserService
 * @description TODO(用户service)
 * @author pangchengxiang
 * @date 2017年8月7日 下午4:33:49
 */
@Service
@Transactional
public class UsersService {
	
	@Autowired
	private UsersMapper usersMapper;
	@Autowired
	private DriversMapper driversMapper;
	@Autowired
	private GoodsownersMapper goodsownersMapper;
	@Autowired
	private AgentsMapper agentsMapper;
	/**
	 * 获取用户 分页数据
	 * @param page:分页对象
	 * @param users：用户对象参数
	 * @return
	 */
	public Page<Users> findUsersListForPage(Page<Users> page, Users  users) {
		users.setPage(page);
		page.setList(usersMapper.findUsersList(users));
		return page;	
	}
	
	
	/**
	 * @description	：分页获取审核通过的用户
	 * @author pangchengxiang
	 * @date 2017年8月26日 上午10:45:01
	 * @return Page<Users>
	 */
	public Page<Users> findPassUsersListForPage(Page<Users> page, Users  users) {
		users.setPage(page);
		page.setList(usersMapper.findPassUsersList(users));
		return page;	
	}
	/**
	 * @description	：获取审核通过的用户
	 * @author pangchengxiang
	 * @date 2017年8月26日 上午10:45:01
	 * @return List<Users>
	 */
	public List<Users> findPassUsersList(Users  users) {
		return usersMapper.findPassUsersList(users);
	}
	
	/**
	 * @description	根据用户ID查询用户
	 * @author 文帅
	 * @date 2017年8月9日 上午10:49:28
	 * @param id
	 * @return
	 */
	public  Users findUserById(String id){
		return usersMapper.selectByPrimaryKey(id);
	}
	/**
	 * @description 查询用户列表	
	 * @author 文帅
	 * @date 2017年8月14日 下午4:57:44
	 * @param users
	 * @return
	 */
	public List<Users> findList(Users users){
		return usersMapper.findList(users);
	}
	/**
	 * 获取货主审核信息
	 * 崔亚光
	 * 2017-08-15
	 * @param id
	 * @return
	 */
	public Users getGoods(String id) {
		return usersMapper.getGoods(id);
	}
	/**
	 * 保存审核信息
	 * 崔亚光
	 * 2017-08-15
	 * @param users
	 */
	public void check(Users users) {
		if(StringUtils.isNotBlank(users.getIsTrueDrive())){//更新车主认证
			Drivers d=new Drivers();
			d.setUserid(users.getId());
			d.setIsTrueDrive(users.getIsTrueDrive());
			d.setIsTrueMove(users.getIsTrueMove());
			driversMapper.update(d);
		}
		if(StringUtils.isNotBlank(users.getIsTruecommpany())){//更新货主/经纪人认证
			if(users.getUserSort().equals("2")){
				Agents a=new Agents();
				a.setUserid(users.getId());
				a.setIsTruecommpany(users.getIsTruecommpany());
				agentsMapper.update(a);
			}
			if(users.getUserSort().equals("0")){
			Goodsowners g=new Goodsowners();
			g.setUserId(users.getId());
			g.setIsTruecommpany(users.getIsTruecommpany());
			goodsownersMapper.update(g);
			}
		}
		
		usersMapper.updateByPrimaryKeySelective(users);
	}
	/**
	 * 获取经纪人审核信息
	 * 崔亚光
	 * 2017-08-17
	 * @param id
	 * @return
	 */
	public Users getAgents(String id) {
		return usersMapper.getAgents(id);
	}
}
