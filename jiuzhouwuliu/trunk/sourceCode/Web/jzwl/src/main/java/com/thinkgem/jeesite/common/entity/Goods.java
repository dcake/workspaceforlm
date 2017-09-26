package com.thinkgem.jeesite.common.entity;

import java.util.Date;

import com.thinkgem.jeesite.common.persistence.CommonEntity;

public class Goods extends CommonEntity<Goods> {
	//
	private static final long serialVersionUID = 1L;

	private String id;

	private String orderNo;

	private String zcYmd;

	private String zcSf;

	private String shipperName;

	private String shipperTel;

	private String shipperArea;

	private String shipperAreaDetail;

	private String reciverName;

	private String reciverTel;

	private String reciverArea;

	private String reciverAreaDetail;

	private String goodsImg1;

	private String goodsImg2;

	private String goodsImg3;

	private String goodsImg4;

	private String goodsImg5;

	private String goodsImg6;

	private String goodsImg7;

	private String goodsImg8;

	private String goodsType;

	private String needTruckWidth;

	private String needTruckLength;

	private String needTruckType;

	private Double goodsNum;

	private String goodsUnit;

	private String isHasInsurance;

	private String insuranceCompanyId;

	private String insuranceType;

	private Double insurancePrice;

	private Double insuranceMoney;

	private String insuranceDescribe;

	private String isExamPass;

	private String examRemark;

	private Date examTime;

	private String isCheckPass;

	private String checkRemark;

	private Date checkTime;

	private String isHasBill;
	
	private String goodsBelongto;
	
	//----数据库无需存储字段----
	private String notCheckPoint;//c类客户无需审核积分标准
	private String orderStatus;

	private String userName;
	
	private String userPhone;
	
	private String userId;
	
	private String goodsownerOrderId;//货主订单Id
	private String competePriceViewCount;//竞价浏览次数
	private String publicCompetePriceTime;//发布竞价时间
	private String goodCurrStatus;//货物当前状态
	private String jingjiaOrWeituo;
	private String goodsTypeStr;
	private String orderStatusStr;
	private String goodCurrStatusStr;
	private String needTruckTypeStr;
	private String isComment; //是否评论（0--否，1--是）
	
	public String getIsComment() {
		return isComment;
	}

	public void setIsComment(String isComment) {
		this.isComment = isComment;
	}

	public String getNeedTruckTypeStr() {
		return needTruckTypeStr;
	}

	public void setNeedTruckTypeStr(String needTruckTypeStr) {
		this.needTruckTypeStr = needTruckTypeStr;
	}

	public String getOrderStatusStr() {
		return orderStatusStr;
	}

	public void setOrderStatusStr(String orderStatusStr) {
		this.orderStatusStr = orderStatusStr;
	}

	public String getGoodCurrStatusStr() {
		return goodCurrStatusStr;
	}

	public void setGoodCurrStatusStr(String goodCurrStatusStr) {
		this.goodCurrStatusStr = goodCurrStatusStr;
	}

	public String getGoodsTypeStr() {
		return goodsTypeStr;
	}

	public void setGoodsTypeStr(String goodsTypeStr) {
		this.goodsTypeStr = goodsTypeStr;
	}

	private Double dealMoney; //货物金额
	
	private String agentsId;//经纪人ID用于判断是经纪人竞价订单还是货主竞价订单（有经纪人订单ID说明是经纪人竞价订单否则为货主竞价订单）
	private String level;//货主类型
	
	private Double priceMin;//竞价区间最小
	private Double priceMax;//竞价区间最大
	private String goodsownerName;//货主姓名
	private String phoneno;//联系方式
	private Integer shipCount;//发货数量
	private String personDescribe;//个人简介
	
	private String orderId;//订单ID
	public String getJingjiaOrWeituo() {
		return jingjiaOrWeituo;
	}

	public void setJingjiaOrWeituo(String jingjiaOrWeituo) {
		this.jingjiaOrWeituo = jingjiaOrWeituo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo == null ? null : orderNo.trim();
	}

	public String getZcYmd() {
		return zcYmd;
	}

	public void setZcYmd(String zcYmd) {
		this.zcYmd = zcYmd == null ? null : zcYmd.trim();
	}

	public String getZcSf() {
		return zcSf;
	}

	public void setZcSf(String zcSf) {
		this.zcSf = zcSf == null ? null : zcSf.trim();
	}

	public String getShipperName() {
		return shipperName;
	}

	public void setShipperName(String shipperName) {
		this.shipperName = shipperName == null ? null : shipperName.trim();
	}

	public String getShipperTel() {
		return shipperTel;
	}

	public void setShipperTel(String shipperTel) {
		this.shipperTel = shipperTel == null ? null : shipperTel.trim();
	}

	public String getShipperArea() {
		return shipperArea;
	}

	public void setShipperArea(String shipperArea) {
		this.shipperArea = shipperArea == null ? null : shipperArea.trim();
	}

	public String getShipperAreaDetail() {
		return shipperAreaDetail;
	}

	public void setShipperAreaDetail(String shipperAreaDetail) {
		this.shipperAreaDetail = shipperAreaDetail == null ? null : shipperAreaDetail.trim();
	}

	public String getReciverName() {
		return reciverName;
	}

	public void setReciverName(String reciverName) {
		this.reciverName = reciverName == null ? null : reciverName.trim();
	}

	public String getReciverTel() {
		return reciverTel;
	}

	public void setReciverTel(String reciverTel) {
		this.reciverTel = reciverTel == null ? null : reciverTel.trim();
	}

	public String getReciverArea() {
		return reciverArea;
	}

	public void setReciverArea(String reciverArea) {
		this.reciverArea = reciverArea == null ? null : reciverArea.trim();
	}

	public String getReciverAreaDetail() {
		return reciverAreaDetail;
	}

	public void setReciverAreaDetail(String reciverAreaDetail) {
		this.reciverAreaDetail = reciverAreaDetail == null ? null : reciverAreaDetail.trim();
	}

	public String getGoodsImg1() {
		return goodsImg1;
	}

	public void setGoodsImg1(String goodsImg1) {
		this.goodsImg1 = goodsImg1 == null ? null : goodsImg1.trim();
	}

	public String getGoodsImg2() {
		return goodsImg2;
	}

	public void setGoodsImg2(String goodsImg2) {
		this.goodsImg2 = goodsImg2 == null ? null : goodsImg2.trim();
	}

	public String getGoodsImg3() {
		return goodsImg3;
	}

	public void setGoodsImg3(String goodsImg3) {
		this.goodsImg3 = goodsImg3 == null ? null : goodsImg3.trim();
	}

	public String getGoodsImg4() {
		return goodsImg4;
	}

	public void setGoodsImg4(String goodsImg4) {
		this.goodsImg4 = goodsImg4 == null ? null : goodsImg4.trim();
	}

	public String getGoodsImg5() {
		return goodsImg5;
	}

	public void setGoodsImg5(String goodsImg5) {
		this.goodsImg5 = goodsImg5 == null ? null : goodsImg5.trim();
	}

	public String getGoodsImg6() {
		return goodsImg6;
	}

	public void setGoodsImg6(String goodsImg6) {
		this.goodsImg6 = goodsImg6 == null ? null : goodsImg6.trim();
	}

	public String getGoodsImg7() {
		return goodsImg7;
	}

	public void setGoodsImg7(String goodsImg7) {
		this.goodsImg7 = goodsImg7 == null ? null : goodsImg7.trim();
	}

	public String getGoodsImg8() {
		return goodsImg8;
	}

	public void setGoodsImg8(String goodsImg8) {
		this.goodsImg8 = goodsImg8 == null ? null : goodsImg8.trim();
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType == null ? null : goodsType.trim();
	}

	public String getNeedTruckLength() {
		return needTruckLength;
	}

	public void setNeedTruckLength(String needTruckLength) {
		this.needTruckLength = needTruckLength == null ? null : needTruckLength.trim();
	}

	public String getNeedTruckType() {
		return needTruckType;
	}

	public void setNeedTruckType(String needTruckType) {
		this.needTruckType = needTruckType == null ? null : needTruckType.trim();
	}

	public Double getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(Double goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getGoodsUnit() {
		return goodsUnit;
	}

	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit == null ? null : goodsUnit.trim();
	}

	public String getIsHasInsurance() {
		return isHasInsurance;
	}

	public void setIsHasInsurance(String isHasInsurance) {
		this.isHasInsurance = isHasInsurance == null ? null : isHasInsurance.trim();
	}

	public String getInsuranceCompanyId() {
		return insuranceCompanyId;
	}

	public void setInsuranceCompanyId(String insuranceCompanyId) {
		this.insuranceCompanyId = insuranceCompanyId == null ? null : insuranceCompanyId.trim();
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType == null ? null : insuranceType.trim();
	}

	public Double getInsurancePrice() {
		return insurancePrice;
	}

	public void setInsurancePrice(Double insurancePrice) {
		this.insurancePrice = insurancePrice;
	}

	public Double getInsuranceMoney() {
		return insuranceMoney;
	}

	public void setInsuranceMoney(Double insuranceMoney) {
		this.insuranceMoney = insuranceMoney;
	}

	public String getInsuranceDescribe() {
		return insuranceDescribe;
	}

	public void setInsuranceDescribe(String insuranceDescribe) {
		this.insuranceDescribe = insuranceDescribe == null ? null : insuranceDescribe.trim();
	}

	public String getExamRemark() {
		return examRemark;
	}

	public void setExamRemark(String examRemark) {
		this.examRemark = examRemark == null ? null : examRemark.trim();
	}

	public String getIsExamPass() {
		return isExamPass;
	}

	public void setIsExamPass(String isExamPass) {
		this.isExamPass = isExamPass == null ? null : isExamPass.trim();
	}

	public Date getExamTime() {
		return examTime;
	}

	public void setExamTime(Date examTime) {
		this.examTime = examTime;
	}

	public String getIsCheckPass() {
		return isCheckPass;
	}

	public void setIsCheckPass(String isCheckPass) {
		this.isCheckPass = isCheckPass == null ? null : isCheckPass.trim();
	}

	public String getCheckRemark() {
		return checkRemark;
	}

	public void setCheckRemark(String checkRemark) {
		this.checkRemark = checkRemark == null ? null : checkRemark.trim();
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getIsHasBill() {
		return isHasBill;
	}

	public void setIsHasBill(String isHasBill) {
		this.isHasBill = isHasBill == null ? null : isHasBill.trim();
	}

	public String getNeedTruckWidth() {
		return needTruckWidth;
	}

	public void setNeedTruckWidth(String needTruckWidth) {
		this.needTruckWidth = needTruckWidth;
	}

	public String getGoodsBelongto() {
		return goodsBelongto;
	}

	public void setGoodsBelongto(String goodsBelongto) {
		this.goodsBelongto = goodsBelongto == null ? null : goodsBelongto.trim();
	}

	public String getNotCheckPoint() {
		return notCheckPoint;
	}

	public void setNotCheckPoint(String notCheckPoint) {
		this.notCheckPoint = notCheckPoint;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGoodsownerOrderId() {
		return goodsownerOrderId;
	}

	public void setGoodsownerOrderId(String goodsownerOrderId) {
		this.goodsownerOrderId = goodsownerOrderId;
	}

	public String getCompetePriceViewCount() {
		return competePriceViewCount;
	}

	public void setCompetePriceViewCount(String competePriceViewCount) {
		this.competePriceViewCount = competePriceViewCount;
	}

	public String getPublicCompetePriceTime() {
		return publicCompetePriceTime;
	}

	public void setPublicCompetePriceTime(String publicCompetePriceTime) {
		this.publicCompetePriceTime = publicCompetePriceTime;
	}

	public String getGoodCurrStatus() {
		return goodCurrStatus;
	}

	public void setGoodCurrStatus(String goodCurrStatus) {
		this.goodCurrStatus = goodCurrStatus;
	}

	public Double getDealMoney() {
		return dealMoney;
	}

	public void setDealMoney(Double dealMoney) {
		this.dealMoney = dealMoney;
	}

	public String getAgentsId() {
		return agentsId;
	}

	public void setAgentsId(String agentsId) {
		this.agentsId = agentsId;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Double getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(Double priceMin) {
		this.priceMin = priceMin;
	}

	public Double getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(Double priceMax) {
		this.priceMax = priceMax;
	}

	public String getGoodsownerName() {
		return goodsownerName;
	}

	public void setGoodsownerName(String goodsownerName) {
		this.goodsownerName = goodsownerName;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public Integer getShipCount() {
		return shipCount;
	}

	public void setShipCount(Integer shipCount) {
		this.shipCount = shipCount;
	}

	public String getPersonDescribe() {
		return personDescribe;
	}

	public void setPersonDescribe(String personDescribe) {
		this.personDescribe = personDescribe;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
}