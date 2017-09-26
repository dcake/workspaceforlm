/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.users.security;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.entity.Users;
import com.thinkgem.jeesite.common.utils.Encodes;
import com.thinkgem.jeesite.common.utils.SpringContextHolder;
import com.thinkgem.jeesite.common.web.Servlets;
import com.thinkgem.jeesite.modules.sys.service.SystemService;
import com.thinkgem.jeesite.modules.sys.utils.LogUtils;
import com.thinkgem.jeesite.modules.users.service.AppUserService;
import com.thinkgem.jeesite.modules.users.util.AppUserUtils;

/**
 * 系统安全认证实现类
 * @author ThinkGem
 * @version 2014-7-5
 */
@Service
//@DependsOn({"userDao","roleDao","menuDao"})
public class AppAuthorizingRealm extends AuthorizingRealm {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private AppUserService appUserService;
	
	public AppAuthorizingRealm() {
		this.setCachingEnabled(false);
	}

	/**
	 * 认证回调函数, 登录时调用
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) {
		AppUsernamePasswordToken token = (AppUsernamePasswordToken) authcToken;
		
		int activeSessionSize = getAppUserService().getSessionDao().getActiveSessions(false).size();
		if (logger.isDebugEnabled()){
			logger.debug("app login submit, active session size: {}, username: {}", activeSessionSize, token.getUsername());
		}
		Users users = getAppUserService().getUserByPhone(token.getUsername(), token.getUserSort(), false);
		if(users!=null){
			if (Global.YES.equals(users.getStatus())){
				throw new AuthenticationException("msg:该已帐号禁止登录.");
			}
			System.out.println(users.getPassword()+"---"+users.getPhoneno()+"---"+token.getUserSort());
			byte[] salt = Encodes.decodeHex(users.getPassword().substring(0,16));
			return new SimpleAuthenticationInfo(new AppPrincipal(users,token.getUserSort()), 
					users.getPassword().substring(16), ByteSource.Util.bytes(salt), getName());
		}
		return null;
	}
	
	/**
	 * 获取权限授权信息，如果缓存中存在，则直接从缓存中获取，否则就重新获取， 登录成功后调用
	 */
	@Override
	protected AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
		if (principals == null) {
            return null;
        }
		
        AuthorizationInfo info = null;

        info = (AuthorizationInfo)AppUserUtils.getCache(AppUserUtils.APP_CACHE_AUTH_INFO);

        if (info == null) {
            info = doGetAuthorizationInfo(principals);
            if (info != null) {
            	AppUserUtils.putCache(AppUserUtils.APP_CACHE_AUTH_INFO, info);
            }
        }

        return info;
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		AppPrincipal principal = (AppPrincipal) getAvailablePrincipal(principals);
		// 获取当前已登录的用户
		if (!Global.TRUE.equals(Global.getConfig("user.multiAccountLogin"))){
			Collection<Session> sessions = getAppUserService().getSessionDao().getActiveSessions(true, principal, AppUserUtils.getSession());
			if (sessions.size() > 0){
				// 如果是登录进来的，则踢出已在线用户
				if (AppUserUtils.getSubject().isAuthenticated()){
					for (Session session : sessions){
						getAppUserService().getSessionDao().delete(session);
					}
				}
				// 记住我进来的，并且当前用户已登录，则退出当前用户提示信息。
				else{
					AppUserUtils.getSubject().logout();
					throw new AuthenticationException("msg:账号已在其它地方登录，请重新登录。");
				}
			}
		}
		Users users = getAppUserService().getUserByPhone(principal.getLoginName(),principal.getUserSort(),false);
		if (users != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			// 添加用户权限
			info.addStringPermission("user");
			// 更新登录IP和时间
			//getAppUserService().updateUserLoginInfo(users);
			// 记录登录日志
			LogUtils.saveLog(Servlets.getRequest(), "APP用户登录");
			return info;
		} else {
			return null;
		}
	}
	
	@Override
	protected void checkPermission(Permission permission, AuthorizationInfo info) {
		authorizationValidate(permission);
		super.checkPermission(permission, info);
	}
	
	@Override
	protected boolean[] isPermitted(List<Permission> permissions, AuthorizationInfo info) {
		if (permissions != null && !permissions.isEmpty()) {
            for (Permission permission : permissions) {
        		authorizationValidate(permission);
            }
        }
		return super.isPermitted(permissions, info);
	}
	
	@Override
	public boolean isPermitted(PrincipalCollection principals, Permission permission) {
		authorizationValidate(permission);
		return super.isPermitted(principals, permission);
	}
	
	@Override
	protected boolean isPermittedAll(Collection<Permission> permissions, AuthorizationInfo info) {
		if (permissions != null && !permissions.isEmpty()) {
            for (Permission permission : permissions) {
            	authorizationValidate(permission);
            }
        }
		return super.isPermittedAll(permissions, info);
	}
	
	/**
	 * 授权验证方法
	 * @param permission
	 */
	private void authorizationValidate(Permission permission){
		// 模块授权预留接口
	}
	
	/**
	 * 设定密码校验的Hash算法与迭代次数
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(SystemService.HASH_ALGORITHM);
		matcher.setHashIterations(SystemService.HASH_INTERATIONS);
		setCredentialsMatcher(matcher);
	}
	
//	/**
//	 * 清空用户关联权限认证，待下次使用时重新加载
//	 */
//	public void clearCachedAuthorizationInfo(Principal principal) {
//		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
//		clearCachedAuthorizationInfo(principals);
//	}

	/**
	 * 清空所有关联认证
	 * @Deprecated 不需要清空，授权缓存保存到session中
	 */
	@Deprecated
	public void clearAllCachedAuthorizationInfo() {
//		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
//		if (cache != null) {
//			for (Object key : cache.keys()) {
//				cache.remove(key);
//			}
//		}
	}

	/**
	 * 获取系统业务对象
	 */
	public AppUserService getAppUserService() {
		if (appUserService == null){
			appUserService = SpringContextHolder.getBean(AppUserService.class);
		}
		return appUserService;
	}
	
	
	/**
	 * 授权用户信息
	 */
	public static class AppPrincipal implements Serializable {

		private static final long serialVersionUID = 1L;
		
		private String id; // 编号
		private String loginName; // 登录名
		private String name; // 姓名
		private String userSort; // 用户分类
		
//		private Map<String, Object> cacheMap;

		public AppPrincipal(Users users, String userSort) {
			this.id = users.getId();
			this.loginName = users.getPhoneno();
			this.name = users.getUsername();
			this.userSort = userSort;
		}

		public String getId() {
			return id;
		}

		public String getLoginName() {
			return loginName;
		}

		public String getName() {
			return name;
		}
		
		

//		@JsonIgnore
//		public Map<String, Object> getCacheMap() {
//			if (cacheMap==null){
//				cacheMap = new HashMap<String, Object>();
//			}
//			return cacheMap;
//		}

		public String getUserSort() {
			return userSort;
		}


		/**
		 * 获取SESSIONID
		 */
		public String getSessionid() {
			try{
				return (String) AppUserUtils.getSession().getId();
			}catch (Exception e) {
				return "";
			}
		}
		
		@Override
		public String toString() {
			return id;
		}

	}
}
