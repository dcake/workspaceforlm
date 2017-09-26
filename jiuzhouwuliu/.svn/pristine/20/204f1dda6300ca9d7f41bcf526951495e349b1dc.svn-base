/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.dao.LogDao;
import com.thinkgem.jeesite.modules.sys.dao.UserDao;
import com.thinkgem.jeesite.modules.sys.entity.Log;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * @ClassName LoginService
 * @description 登录服务层
 * @author pangchengxiang
 * @date 2017年8月31日 上午11:04:16
 */
@Service
@Transactional(readOnly = true)
public class LoginService extends CrudService<LogDao, Log> {

	@Autowired
	private UserDao userDao;

	/**
	 * @description ：根据姓名和登录状态更新连续登录失败次数
	 * @author pangchengxiang
	 * @date 2017年8月31日 上午11:06:47
	 * @return void
	 */
	@Transactional(readOnly = false)
	public void updateLoginFailCount(User user, boolean loginResult) {
		int count = 0;
		if (null != user) {
			if (loginResult == false) {
				if (null == user.getLoginFailCount()) {
					count = 1;
				} else {
					count = user.getLoginFailCount() + 1;
				}
			}
			user.setLoginFailCount(count);
			userDao.updateUserLoginFailCount(user);
		}

	}
	
	/**
	 * @description	：根据用户名获取用户
	 * @author pangchengxiang
	 * @date 2017年9月2日 上午9:48:08
	 * @return User
	 */
	public User findUserByLoginname(String loginName){
		return userDao.getByLoginName(new User(null ,loginName));
	}
}
