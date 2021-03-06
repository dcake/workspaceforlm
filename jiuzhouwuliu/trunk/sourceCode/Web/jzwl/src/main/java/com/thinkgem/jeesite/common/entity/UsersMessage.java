package com.thinkgem.jeesite.common.entity;

import com.thinkgem.jeesite.common.persistence.CommonEntity;

public class UsersMessage extends CommonEntity<UsersMessage> {
	//
	private static final long serialVersionUID = 1L;

	private String id;

	private String userid;
	
	private String messageOneType;

	private String messageTwoType;

	private String params;

	private String messageTitle;

	private String messageContent;

	private String goodsType;

	private String orderNo;

	private String islook;
    
    private int notLookNum;//未读数量

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getMessageOneType() {
		return messageOneType;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid == null ? null : userid.trim();
	}

	public void setMessageOneType(String messageOneType) {
		this.messageOneType = messageOneType == null ? null : messageOneType.trim();
	}

	public String getMessageTwoType() {
		return messageTwoType;
	}

	public void setMessageTwoType(String messageTwoType) {
		this.messageTwoType = messageTwoType == null ? null : messageTwoType.trim();
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params == null ? null : params.trim();
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle == null ? null : messageTitle.trim();
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent == null ? null : messageContent.trim();
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType == null ? null : goodsType.trim();
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo == null ? null : orderNo.trim();
	}

	public String getIslook() {
		return islook;
	}

	public int getNotLookNum() {
		return notLookNum;
	}

	public void setNotLookNum(int notLookNum) {
		this.notLookNum = notLookNum;
	}

	public void setIslook(String islook) {
		this.islook = islook == null ? null : islook.trim();
	}

}