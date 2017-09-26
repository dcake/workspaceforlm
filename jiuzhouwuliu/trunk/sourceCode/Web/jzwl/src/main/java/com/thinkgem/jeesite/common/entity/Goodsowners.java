package com.thinkgem.jeesite.common.entity;

import com.thinkgem.jeesite.common.persistence.CommonEntity;

public class Goodsowners extends CommonEntity<Goodsowners> {
	//
	private static final long serialVersionUID = 1L;

	private String id;

	private String userId;

	private String identityType;

	private String businessLicenseFaceImg;

	private String businessLicenseOtherImg;

	private String businessLicenseImgs;

	private String legalpersonFaceImg;

	private String legalpersonOtherImg;

	private String isTruecommpany;

	private String companyName;
	// 非数据库字段
	private String goodsId; // 货物id
	private String username;// 用户名 货主
	private Integer userno;	//用户编号
	private String phoneno;// 手机号 货主
	private String status;// 状态
	private String examineStatus;// 审核状态
	private String examineRemark;// 审核意见
	private String level;// 等级
	private String levelStr;// 等级
	private String usersStatus;// 状态 //用户状态 0正常 1锁定
	private String usersStatusStr;
	private String driverMasterChangeAuditingStatus;// 审核状态 0未审核 1已审核 2审核未通过
	private String driverMasterChangeAuditingStatusStr;
	private String truename;// 姓名 货主
	private String cardno;
	private Integer currentPoint;// 积分
	private String beginDate;// 开始时间
	private String endDate;// 结束时间
	private String goodsType;// 货物类型
	private String orderNo;// 订单编号
	private double payMoney;// 交易价格
	private String shipperArea;// 发货地址
	private String reciverArea;// 收货地址
	private String zcSf;// 装车时间
	private String driversTrueName;// 用户名 车主
	private String driversPhoneno;// 手机号 车主
	private String agentsTrueName;// 用户名 经纪人
	private String agentsPhoneno;// 手机号 经纪人
	private String agentsId;// 经纪人ID
	private String driversId;// 经纪人ID
	private String integralScore;// 获取积分
	private String password;
	private String headImg;
	private String cardFaceImg;
	private String cardOtherImg;
	private String identityTypeStr;

	public String getIdentityTypeStr() {
		return identityTypeStr;
	}

	public void setIdentityTypeStr(String identityTypeStr) {
		this.identityTypeStr = identityTypeStr;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getCardFaceImg() {
		return cardFaceImg;
	}

	public void setCardFaceImg(String cardFaceImg) {
		this.cardFaceImg = cardFaceImg;
	}

	public String getCardOtherImg() {
		return cardOtherImg;
	}

	public void setCardOtherImg(String cardOtherImg) {
		this.cardOtherImg = cardOtherImg;
	}

	public String getIntegralScore() {
		return integralScore;
	}

	public void setIntegralScore(String integralScore) {
		this.integralScore = integralScore;
	}

	public String getDriversId() {
		return driversId;
	}

	public void setDriversId(String driversId) {
		this.driversId = driversId;
	}

	public String getDriversTrueName() {
		return driversTrueName;
	}

	public void setDriversTrueName(String driversTrueName) {
		this.driversTrueName = driversTrueName;
	}

	public String getAgentsTrueName() {
		return agentsTrueName;
	}

	public void setAgentsTrueName(String agentsTrueName) {
		this.agentsTrueName = agentsTrueName;
	}

	public String getAgentsId() {
		return agentsId;
	}

	public void setAgentsId(String agentsId) {
		this.agentsId = agentsId;
	}

	public String getDriversPhoneno() {
		return driversPhoneno;
	}

	public void setDriversPhoneno(String driversPhoneno) {
		this.driversPhoneno = driversPhoneno;
	}

	public String getAgentsPhoneno() {
		return agentsPhoneno;
	}

	public void setAgentsPhoneno(String agentsPhoneno) {
		this.agentsPhoneno = agentsPhoneno;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getUserno() {
		return userno;
	}

	public void setUserno(Integer userno) {
		this.userno = userno;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getExamineStatus() {
		return examineStatus;
	}

	public void setExamineStatus(String examineStatus) {
		this.examineStatus = examineStatus;
	}

	public String getExamineRemark() {
		return examineRemark;
	}

	public void setExamineRemark(String examineRemark) {
		this.examineRemark = examineRemark;
	}

	public String getLevelStr() {
		return levelStr;
	}

	public void setLevelStr(String levelStr) {
		this.levelStr = levelStr;
	}

	public String getUsersStatus() {
		return usersStatus;
	}

	public void setUsersStatus(String usersStatus) {
		this.usersStatus = usersStatus;
	}

	public String getUsersStatusStr() {
		return usersStatusStr;
	}

	public void setUsersStatusStr(String usersStatusStr) {
		this.usersStatusStr = usersStatusStr;
	}

	public String getDriverMasterChangeAuditingStatus() {
		return driverMasterChangeAuditingStatus;
	}

	public void setDriverMasterChangeAuditingStatus(String driverMasterChangeAuditingStatus) {
		this.driverMasterChangeAuditingStatus = driverMasterChangeAuditingStatus;
	}

	public String getDriverMasterChangeAuditingStatusStr() {
		return driverMasterChangeAuditingStatusStr;
	}

	public void setDriverMasterChangeAuditingStatusStr(String driverMasterChangeAuditingStatusStr) {
		this.driverMasterChangeAuditingStatusStr = driverMasterChangeAuditingStatusStr;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public Integer getCurrentPoint() {
		return currentPoint;
	}

	public void setCurrentPoint(Integer currentPoint) {
		this.currentPoint = currentPoint;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public double getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(double payMoney) {
		this.payMoney = payMoney;
	}

	public String getShipperArea() {
		return shipperArea;
	}

	public void setShipperArea(String shipperArea) {
		this.shipperArea = shipperArea;
	}

	public String getReciverArea() {
		return reciverArea;
	}

	public void setReciverArea(String reciverArea) {
		this.reciverArea = reciverArea;
	}

	public String getZcSf() {
		return zcSf;
	}

	public void setZcSf(String zcSf) {
		this.zcSf = zcSf;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getIdentityType() {
		return identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType == null ? null : identityType.trim();
	}

	public String getBusinessLicenseFaceImg() {
		return businessLicenseFaceImg;
	}

	public void setBusinessLicenseFaceImg(String businessLicenseFaceImg) {
		this.businessLicenseFaceImg = businessLicenseFaceImg == null ? null : businessLicenseFaceImg.trim();
	}

	public String getBusinessLicenseOtherImg() {
		return businessLicenseOtherImg;
	}

	public void setBusinessLicenseOtherImg(String businessLicenseOtherImg) {
		this.businessLicenseOtherImg = businessLicenseOtherImg == null ? null : businessLicenseOtherImg.trim();
	}

	public String getBusinessLicenseImgs() {
		return businessLicenseImgs;
	}

	public void setBusinessLicenseImgs(String businessLicenseImgs) {
		this.businessLicenseImgs = businessLicenseImgs == null ? null : businessLicenseImgs.trim();
	}

	public String getLegalpersonFaceImg() {
		return legalpersonFaceImg;
	}

	public void setLegalpersonFaceImg(String legalpersonFaceImg) {
		this.legalpersonFaceImg = legalpersonFaceImg == null ? null : legalpersonFaceImg.trim();
	}

	public String getLegalpersonOtherImg() {
		return legalpersonOtherImg;
	}

	public void setLegalpersonOtherImg(String legalpersonOtherImg) {
		this.legalpersonOtherImg = legalpersonOtherImg == null ? null : legalpersonOtherImg.trim();
	}

	public String getIsTruecommpany() {
		return isTruecommpany;
	}

	public void setIsTruecommpany(String isTruecommpany) {
		this.isTruecommpany = isTruecommpany == null ? null : isTruecommpany.trim();
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName == null ? null : companyName.trim();
	}

}