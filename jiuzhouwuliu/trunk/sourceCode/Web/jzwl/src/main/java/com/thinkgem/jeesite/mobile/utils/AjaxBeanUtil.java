package com.thinkgem.jeesite.mobile.utils;

/**
 * @desc 返回统一的json对象工具类
 * @author yaotengfei
 * @date 2017年3月22日下午5:30:24
 */
public class AjaxBeanUtil {
	/**
	 * json的提示信息
	 */
	private String msg;
	/**
	 * json的处理结果是否正确
	 * false 失败，true 成功
	 */
	private boolean status;
	/**
	 * json返回的对象
	 */
	private Object data;

	/**
	 * 无参构造
	 */
	public AjaxBeanUtil() {
	}

	/**
	 * 返回单一的消息
	 * 
	 * @param msg
	 */
	public AjaxBeanUtil(String msg) {
		this.msg = msg;
	}

	/**
	 * @param msg 消息
	 * @param status 状态
	 */
	public AjaxBeanUtil(String msg, Boolean status) {
		this.msg = msg;
		this.status = status;
	}
	/**
	 * 
	 * @param msg 消息
	 * @param status 状态
	 * @param object 对象
	 */
	public AjaxBeanUtil(String msg, Boolean status, Object data) {
		this.msg = msg;
		this.status = status;
		this.data = data;
	}


	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
