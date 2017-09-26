package com.thinkgem.jeesite.mobile.shipper.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.thinkgem.jeesite.common.dao.UsersMessageMapper;
import com.thinkgem.jeesite.common.entity.UsersMessage;
import com.thinkgem.jeesite.common.utils.AjaxBeanUtil;
import com.thinkgem.jeesite.modules.sys.entity.Dict;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;

/**
 * app货主端消息--Service
 *   
 * @author 张彦学
 * 日期 2017年9月4日
 */
@Service
public class MobileShipperMessageService {
	
	@Resource
	private UsersMessageMapper usersMessageMapper;
	
    /**
     * 货主端消息分类
     *   
     * @author 张彦学
     * 日期 2017年9月4日
     * @param userId 用户id
     * @return
     */
	public AjaxBeanUtil getMessageInfo(String userId){
		List<Dict> messageTypeList = DictUtils.getDictList("message_type");
		List<UsersMessage> list = new ArrayList<UsersMessage>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		for(Dict dict : messageTypeList){
			paramMap.put("messageType", dict.getValue());
			int notLookNum = usersMessageMapper.findmessageNotLookByMessageType(paramMap);
			List<UsersMessage> messageList = usersMessageMapper.findmessageByMessageType(paramMap);
			UsersMessage usersMessage = new UsersMessage(); 
			usersMessage.setNotLookNum(notLookNum);
			usersMessage.setMessageOneType(dict.getValue());
			usersMessage.setUserid(userId);
			usersMessage.setMessageTitle(dict.getLabel());
			if(messageList.size() > 0){
				usersMessage.setMessageContent(messageList.get(0).getMessageContent());	
			}else{
				usersMessage.setMessageContent("");	
			}
			list.add(usersMessage);
		}
		return new AjaxBeanUtil("查询成功", true, list);
	}

	/**
	 * 货主端消息列表
	 *   
	 * @author 张彦学
	 * 日期 2017年9月4日
	 * @param messageType 消息类型
	 * @param userId 用户id
	 * @return
	 */
	public AjaxBeanUtil getMessageList(String messageType, String userId){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("messageType", messageType);
		paramMap.put("userId", userId);
		List<UsersMessage> messageList = usersMessageMapper.findmessageByMessageType(paramMap);
		for(UsersMessage message : messageList){
			message.setGoodsType(DictUtils.getDictLabel(message.getGoodsType(), "goods_type", message.getGoodsType()));
		}
		return new AjaxBeanUtil("查询成功", true, messageList); 
	}
}
