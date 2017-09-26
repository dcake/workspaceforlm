package com.thinkgem.jeesite.mobile.entity;

import com.thinkgem.jeesite.common.persistence.CommonEntity;

public class RecentPersonInfo extends CommonEntity<RecentPersonInfo>{
    //
	private static final long serialVersionUID = 1L;

	private String id;//车主订单或经纪人订单ID
	private String goodsownerOrderId;//货主订单ID
	private String truename;//车主或经纪人姓名
	private String headImg;//车主或经纪人头像
	private String userSort;//用户分类(0货主、1车主、2经纪人)
	private String userId;//用户ID（经纪人或车主的userId）
	private String currentUserId;//当前登录用户ID
	
	private String truckType;//车型
	private String truckHeight;//车高
	private String truckMaxwight;//承重
	private Integer transportCount;//运输次数
	private String companyName;//公司名称
	private String IsCollect;//是否收藏（0-否，1-是）
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGoodsownerOrderId() {
		return goodsownerOrderId;
	}
	public void setGoodsownerOrderId(String goodsownerOrderId) {
		this.goodsownerOrderId = goodsownerOrderId;
	}
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getUserSort() {
		return userSort;
	}
	public void setUserSort(String userSort) {
		this.userSort = userSort;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCurrentUserId() {
		return currentUserId;
	}
	public void setCurrentUserId(String currentUserId) {
		this.currentUserId = currentUserId;
	}
	public String getTruckType() {
		return truckType;
	}
	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}
	public String getTruckHeight() {
		return truckHeight;
	}
	public void setTruckHeight(String truckHeight) {
		this.truckHeight = truckHeight;
	}
	public String getTruckMaxwight() {
		return truckMaxwight;
	}
	public void setTruckMaxwight(String truckMaxwight) {
		this.truckMaxwight = truckMaxwight;
	}
	public Integer getTransportCount() {
		return transportCount;
	}
	public void setTransportCount(Integer transportCount) {
		this.transportCount = transportCount;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getIsCollect() {
		return IsCollect;
	}
	public void setIsCollect(String isCollect) {
		IsCollect = isCollect;
	}
	
}