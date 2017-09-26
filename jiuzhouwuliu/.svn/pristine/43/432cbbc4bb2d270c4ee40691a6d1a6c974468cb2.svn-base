/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.users.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.thinkgem.jeesite.common.dao.UsersMapper;
import com.thinkgem.jeesite.common.entity.Users;
import com.thinkgem.jeesite.common.utils.CacheUtils;
import com.thinkgem.jeesite.common.utils.SpringContextHolder;
import com.thinkgem.jeesite.modules.users.security.AppAuthorizingRealm.AppPrincipal;;
/**
 * @ClassName AppUserUtils
 * @description App用户工具类
 * @author pangchengxiang
 * @date 2017年9月13日 上午11:02:36
 */
public class AppUserUtils {

	private static UsersMapper usersMapper = SpringContextHolder.getBean(UsersMapper.class);

	public static final String APP_USER_CACHE = "appUserCache";
	public static final String APP_USER_CACHE_ID_ = "appId_";
	public static final String APP_USER_CACHE_LOGIN_NAME_Sort_ = "appLn_";
	public static final String APP_USER_CACHE_PHONENO_Sort_ = "appPhoneno_";
	
	public static final String APP_CACHE_AUTH_INFO = "appAuthInfo";
	
	/**
	 * 根据ID获取用户
	 * @param id
	 * @param isNewLoad 是否重新加载
	 * @return 取不到返回null
	 */
	public static Users selectByPrimaryKey(String id,boolean isNewLoad){
		Users users = null;
		if(isNewLoad==false){
			users = (Users)CacheUtils.get(APP_USER_CACHE, APP_USER_CACHE_ID_ + id);
			if (users ==  null){
				isNewLoad = true;
			}
		}
		if(isNewLoad){
			users = usersMapper.selectByPrimaryKey(id);
			if (users == null){
				return null;
			}
			CacheUtils.put(APP_USER_CACHE, APP_USER_CACHE_ID_ + users.getId(), users);
			CacheUtils.put(APP_USER_CACHE, APP_USER_CACHE_LOGIN_NAME_Sort_ + users.getUsername()+"_"+users.getUserSort(), users);
			CacheUtils.put(APP_USER_CACHE, APP_USER_CACHE_PHONENO_Sort_ + users.getPhoneno()+"_"+users.getUserSort(), users);
		}
		return users;
	}
	/**
	 * 根据登录名获取用户
	 * @param loginName
	 * @param isNewLoad 是否重新加载
	 * @return 取不到返回null
	 */
	public static Users selectByPhone(String phone,String userSort,boolean isNewLoad){
		Users users =null;
		if(isNewLoad==false){
			users = (Users)CacheUtils.get(APP_USER_CACHE, APP_USER_CACHE_PHONENO_Sort_ + phone+"_"+userSort);
			if (users == null){
				isNewLoad = true;
			}
		}
		if(isNewLoad){
			users = usersMapper.selectByPhone(phone,userSort);
			if (users == null){
				return null;
			}
			CacheUtils.put(APP_USER_CACHE, APP_USER_CACHE_ID_ + users.getId(), users);
			CacheUtils.put(APP_USER_CACHE, APP_USER_CACHE_LOGIN_NAME_Sort_ + users.getUsername()+"_"+users.getUserSort(), users);
			CacheUtils.put(APP_USER_CACHE, APP_USER_CACHE_PHONENO_Sort_ + users.getPhoneno()+"_"+users.getUserSort(), users);
		}
		return users;
	}
	
	
	/**
	 * 清除当前用户缓存
	 */
	public static void clearCache(){
		removeCache(APP_CACHE_AUTH_INFO);
		AppUserUtils.clearCache(getUser(false));
	}
	
	/**
	 * 清除指定用户缓存
	 * @param users
	 */
	public static void clearCache(Users users){
		CacheUtils.remove(APP_USER_CACHE, APP_USER_CACHE_ID_ + users.getId());
		CacheUtils.remove(APP_USER_CACHE,  APP_USER_CACHE_LOGIN_NAME_Sort_ + users.getUsername()+"_"+users.getUserSort());
		CacheUtils.remove(APP_USER_CACHE,APP_USER_CACHE_PHONENO_Sort_ + users.getPhoneno()+"_"+users.getUserSort());
	}
	
	public static void setCache(Users users){
		CacheUtils.put(APP_USER_CACHE, APP_USER_CACHE_ID_ + users.getId(), users);
		CacheUtils.put(APP_USER_CACHE, APP_USER_CACHE_LOGIN_NAME_Sort_ + users.getUsername()+"_"+users.getUserSort(), users);
		CacheUtils.put(APP_USER_CACHE, APP_USER_CACHE_PHONENO_Sort_ + users.getPhoneno()+"_"+users.getUserSort(), users);
	}
	
	/**
	 * 获取当前用户
	 * @return 取不到返回 new User()
	 */
	public static Users getUser(boolean isNewLoad){
		AppPrincipal principal = getPrincipal();
		if (principal!=null){
			Users users = selectByPrimaryKey(principal.getId(),isNewLoad);
			if (users != null){
				return users;
			}
			return new Users();
		}
		// 如果没有登录，则返回实例化空的User对象。
		return new Users();
	}
	
	/**
	 * 获取授权主要对象
	 */
	public static Subject getSubject(){
		return SecurityUtils.getSubject();
	}
	
	/**
	 * 根据ID获取用户
	 * @param id
	 * @return 取不到返回null
	 */
	public static Users get(String id){
		Users users = (Users)CacheUtils.get(APP_USER_CACHE, APP_USER_CACHE_ID_ + id);
		if (users ==  null){
			users = usersMapper.selectByPrimaryKey(id);
			if (users == null){
				return null;
			}
			CacheUtils.put(APP_USER_CACHE, APP_USER_CACHE_ID_ + users.getId(), users);
			CacheUtils.put(APP_USER_CACHE, APP_USER_CACHE_LOGIN_NAME_Sort_ + users.getUsername()+"_"+users.getUserSort(), users);
			CacheUtils.put(APP_USER_CACHE, APP_USER_CACHE_PHONENO_Sort_ + users.getPhoneno()+"_"+users.getUserSort(), users);
		}
		return users;
	}
	
	/**
	 * 获取当前登录者对象
	 */
	public static AppPrincipal getPrincipal(){
		try{
			Subject subject = SecurityUtils.getSubject();
			AppPrincipal principal = (AppPrincipal)subject.getPrincipal();
			if (principal != null){
				return principal;
			}
//			subject.logout();
		}catch (UnavailableSecurityManagerException e) {
			
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
	
	public static Session getSession(){
		try{
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(false);
			if (session == null){
				session = subject.getSession();
			}
			if (session != null){
				return session;
			}
//			subject.logout();
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
	
	// ============== User Cache ==============
	
	public static Object getCache(String key) {
		return getCache(key, null);
	}
	
	public static Object getCache(String key, Object defaultValue) {
//		Object obj = getCacheMap().get(key);
		Object obj = getSession().getAttribute(key);
		return obj==null?defaultValue:obj;
	}

	public static void putCache(String key, Object value) {
//		getCacheMap().put(key, value);
		getSession().setAttribute(key, value);
	}

	public static void removeCache(String key) {
//		getCacheMap().remove(key);
		getSession().removeAttribute(key);
	}
	
//	public static Map<String, Object> getCacheMap(){
//		Principal principal = getPrincipal();
//		if(principal!=null){
//			return principal.getCacheMap();
//		}
//		return new HashMap<String, Object>();
//	}
	
}
