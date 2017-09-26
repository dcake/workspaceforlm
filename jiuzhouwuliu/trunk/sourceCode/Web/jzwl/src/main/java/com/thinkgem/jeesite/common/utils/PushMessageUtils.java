package com.thinkgem.jeesite.common.utils;

import java.util.ArrayList;
import java.util.List;







import com.alibaba.fastjson.JSONObject;
import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.base.impl.ListMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.base.payload.APNPayload;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import com.thinkgem.jeesite.common.entity.Users;

/**
 * app消息推送
 *   
 * @author 张彦学
 * 日期 2017年9月4日
 */
public class PushMessageUtils {
	
//	public static String appId = "eTtQzr0gDg9wK575L9H7H7";
//	public static String appkey = "VbwfzqX1wo79deppHWYKN8";
//	public static String master = "JOtW1Tyruh9kdsEyoqBFI4";
	
	//测试信息
	public static String appId = "Kd52bi2eID7TkWQ3RBv421";
	public static String appkey = "Gt6QsxmNNhA5vqPioy7Ue4";
	public static String master = "IFI7FTV6XS76SSZ5Jll6B6";
	
//	public static String appId = "4ERUY0Qb6b6hHTxziwwgp";
//	public static String appkey = "AeHygaThj69NoyoAiqwN26";
//	public static String master = "JuKwjH21t880nGhpjDVfJ6";
	
	public static String host = "http://sdk.open.api.igexin.com/apiex.htm";
	
	public static void main(String[] args) throws Exception {
	
		
	/***************************************************************/
		IGtPush push = new IGtPush(host, appkey, master);
		//透传模板
		TransmissionTemplate template = transmissionTemplateDemo("系统通知请查看！","长城e驾","11");
		AppMessage message = new AppMessage();
		message.setData(template);
		//设置消息离线，并设置离线时间
		message.setOffline(true);
		//离线有效时间，单位为毫秒，可选
		message.setOfflineExpireTime(24*1000*3600);
		//设置推送目标条件过滤
		List<String> appIdList = new ArrayList<String>();
		appIdList.add(appId);
		message.setAppIdList(appIdList);
		IPushResult ret = push.pushMessageToApp(message);
		System.out.println(ret.getResponse().toString());
		
		/******************************多用户推送*********************************/
//		IGtPush push = new IGtPush(host, appkey, master);
//		//透传模板
//		TransmissionTemplate template = transmissionTemplateDemo(2222l);
//		ListMessage message = new ListMessage();
//		message.setData(template);
//		//设置消息离线，并设置离线时间
//		message.setOffline(true);
//		//离线有效时间，单位为毫秒，可选
//		message.setOfflineExpireTime(24*1000*3600);
//		//设置推送目标条件过滤
//		List<Target> appIdList = new ArrayList<Target>();
//		Target target1 = new Target();
//		target1.setAppId(appId);
//		target1.setClientId("fa6624d1ae02180bfed1a83b4b4adbb5");
//		appIdList.add(target1);
//		String taskId = push.getContentId(message);
//		System.out.println(taskId);
//		//使用taskID对目标进行推送
//		IPushResult ret = push.pushMessageToList(taskId, appIdList);
//		System.out.println(ret.getResponse().toString());
//		System.out.println(ret.getResultCode());
//		System.out.println(ret.getTaskId());
//		System.out.println(ret.getMessageId());
		
	}

	/**
	 * 信息模板
	 *   
	 * @author 张彦学
	 * 日期 2017年9月4日
	 * @param msgContent 推送内容
	 * @param title 推送标题
	 * @param payload 自定义参数
	 * @return
	 */
	public static TransmissionTemplate transmissionTemplateDemo(String msgContent,String title, Object payload) {
		TransmissionTemplate template = new TransmissionTemplate();
		template.setAppId(appId);
		template.setAppkey(appkey);
		JSONObject jsonData = new JSONObject();
		jsonData.put("title", title);
		jsonData.put("content", msgContent);
//		jsonData.put("payload", payload);
		jsonData.put("id", payload);
		String jsonStr = jsonData.toJSONString();
		// 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动。
		template.setTransmissionType(2);
		template.setTransmissionContent(jsonStr);
//		Payload payload2 = new Payload();
		APNPayload payload1 = new APNPayload();
	    //在已有数字基础上加1显示，设置为-1时，在已有数字上减1显示，设置为数字时，显示指定数字
	    payload1.setBadge(0);
	    payload1.setContentAvailable(1);
//	    payload1.setSound("default");
//	    payload1.setCategory("$由客户端定义");
	   
	    //简单模式APNPayload.SimpleMsg
	   
	    //字典模式使用APNPayload.DictionaryAlertMsg
//	    payload1.setAlertMsg(getDictionaryAlertMsg());
	    // 添加多媒体资源
//	    payload.addMultiMedia(new MultiMedia().setResType(MultiMedia.MediaType.video)
//	                .setResUrl("http://ol5mrj259.bkt.clouddn.com/test2.mp4")
//	                .setOnlyWifi(true));
		/**
		 * friendly reminder
		 * 1.ios监听receive事件会无限触发，直到app挂掉。需自己加逻辑进行处理
		 * 2.个推一天推送上线100次。每分钟五次。
		 */
		
		//ios离线发送自定义参数
	    payload1.addCustomMsg("id", payload);
	    payload1.setAlertMsg(new APNPayload.SimpleAlertMsg(msgContent));
	    //ios离线推送必须设置APN
	    template.setAPNInfo(payload1);

		return template;
	}
	
	/**
	 * 指定用户推送消息
	 *   
	 * @author 张彦学
	 * 日期 2017年7月14日
	 * @param msgContent 内容
	 * @param title 标题
	 * @param payload 自定义参数
	 * @param userList 推送用户
	 */
	public static void PushToSomeUser(String msgContent,String title,String payload, List<Users> userList){
		IGtPush push = new IGtPush(host, appkey, master);
		//通知透传模板
		TransmissionTemplate template = transmissionTemplateDemo(msgContent,title,payload);
		ListMessage message = new ListMessage();
		message.setData(template);
		//设置消息离线，并设置离线时间
		message.setOffline(true);
		//离线有效时间，单位为毫秒，可选
		message.setOfflineExpireTime(24*1000*3600);
		//配置推送目标
		List<Target> targets = new ArrayList<Target>();
		//遍历用户列表获取clientId
		for(int i = 0;i<userList.size();i++){
			String clientId = userList.get(i).getAppId();
			if(clientId == null || "null".equals(clientId) || "".equals(clientId)){
				continue;
			}
			Target target1 = new Target();
			target1.setAppId(appId);
			target1.setClientId(clientId);
			targets.add(target1);
		}
		//获取taskID
		String taskId = push.getContentId(message);
		//使用taskID对目标进行推送
		IPushResult ret = push.pushMessageToList(taskId, targets);
		//打印服务器返回信息
		System.out.println(ret.getResponse().toString());
	}
	
	/**
	 * 全部推送
	 *   
	 * @author 张彦学
	 * 日期 2017年7月14日
	 * @param msgContent 内容
	 * @param title 标题
	 * @param payload 自定义参数
	 */
	public static String pushtoAllUser(String msgContent,String title,Object payload){
		IGtPush push = new IGtPush(host, appkey, master);
		//透传模板
		TransmissionTemplate template = transmissionTemplateDemo(msgContent,title,payload);
		AppMessage message = new AppMessage();
		message.setData(template);
		//设置消息离线，并设置离线时间
		message.setOffline(true);
		//离线有效时间，单位为毫秒，可选
		message.setOfflineExpireTime(24*1000*3600);
		//设置推送目标条件过滤
		List<String> appIdList = new ArrayList<String>();
		appIdList.add(appId);
		message.setAppIdList(appIdList);
		IPushResult ret = push.pushMessageToApp(message);
		String pushStatus = ret.getResponse().get("result").toString();
		System.out.println(ret.getResponse().toString());
		System.out.println(pushStatus);
		return pushStatus;
	}
}
