package com.thinkgem.jeesite.common.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.common.persistence.CommonEntity;

public class GoodsownerOrder extends CommonEntity<GoodsownerOrder> {
	//
	private static final long serialVersionUID = 1L;

	private String id;

	private String goodsId;

	private String goodsownersId;

	private String goodCurrStatus;

	private String jingjiaOrWeituo;

	private String publicSel;

	private Double priceMin;

	private Double priceMax;

	private Integer competePriceViewCount;

	private Date publicCompetePriceTime;

	private String userId;// 非数据库字段（用户ID）

	private String insuranceDescribe;// 备注

	private String isTrueDrive;// 是否驾驶证认证（0否 1是）

	private String isTrueMove;// 是否行驶证认证(0否 1是)

	private String isTruename;// 是否实名认证（0-否，1-是）

	private String driverName;// 车主姓名

	private String driverPhone;// 车主手机号

	private String truckNo;// 车牌号

	private String goodsownersName;// 货主姓名

	private String goodsownersPhone;// 货主手机

	private String goodsType;// 货物类型

	private String shipperAreaDetail;// 发货地址

	private String reciverAreaDetail;// 收货地址

	private Double dealMoney;// 交易金额
	private Date dealDate;// 交易时间
	private String orderNo;// 订单编号
	private Double goodsNum;// 数量
	private String goodsUnit;// 单位
	private String needTruckType;// 需求车型
	private Date settleAccountsDate;
	private String goodsImg1;// 货物图片
	private String zcYmd;// 装车日期

	public Date getSettleAccountsDate() {
		return settleAccountsDate;
	}

	public void setSettleAccountsDate(Date settleAccountsDate) {
		this.settleAccountsDate = settleAccountsDate;
	}

	public String getInsuranceDescribe() {
		return insuranceDescribe;
	}

	public void setInsuranceDescribe(String insuranceDescribe) {
		this.insuranceDescribe = insuranceDescribe;
	}

	public String getIsTrueDrive() {
		return isTrueDrive;
	}

	public void setIsTrueDrive(String isTrueDrive) {
		this.isTrueDrive = isTrueDrive;
	}

	public String getIsTrueMove() {
		return isTrueMove;
	}

	public void setIsTrueMove(String isTrueMove) {
		this.isTrueMove = isTrueMove;
	}

	public String getIsTruename() {
		return isTruename;
	}

	public void setIsTruename(String isTruename) {
		this.isTruename = isTruename;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverPhone() {
		return driverPhone;
	}

	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}

	public String getTruckNo() {
		return truckNo;
	}

	public void setTruckNo(String truckNo) {
		this.truckNo = truckNo;
	}

	public String getGoodsownersName() {
		return goodsownersName;
	}

	public void setGoodsownersName(String goodsownersName) {
		this.goodsownersName = goodsownersName;
	}

	public String getGoodsownersPhone() {
		return goodsownersPhone;
	}

	public void setGoodsownersPhone(String goodsownersPhone) {
		this.goodsownersPhone = goodsownersPhone;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getShipperAreaDetail() {
		return shipperAreaDetail;
	}

	public void setShipperAreaDetail(String shipperAreaDetail) {
		this.shipperAreaDetail = shipperAreaDetail;
	}

	public String getReciverAreaDetail() {
		return reciverAreaDetail;
	}

	public void setReciverAreaDetail(String reciverAreaDetail) {
		this.reciverAreaDetail = reciverAreaDetail;
	}

	public Double getDealMoney() {
		return dealMoney;
	}

	public void setDealMoney(Double dealMoney) {
		this.dealMoney = dealMoney;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId == null ? null : goodsId.trim();
	}

	public String getGoodsownersId() {
		return goodsownersId;
	}

	public void setGoodsownersId(String goodsownersId) {
		this.goodsownersId = goodsownersId == null ? null : goodsownersId.trim();
	}

	public String getGoodCurrStatus() {
		return goodCurrStatus;
	}

	public void setGoodCurrStatus(String goodCurrStatus) {
		this.goodCurrStatus = goodCurrStatus == null ? null : goodCurrStatus.trim();
	}

	public String getJingjiaOrWeituo() {
		return jingjiaOrWeituo;
	}

	public void setJingjiaOrWeituo(String jingjiaOrWeituo) {
		this.jingjiaOrWeituo = jingjiaOrWeituo == null ? null : jingjiaOrWeituo.trim();
	}

	public String getPublicSel() {
		return publicSel;
	}

	public void setPublicSel(String publicSel) {
		this.publicSel = publicSel == null ? null : publicSel.trim();
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

	public Integer getCompetePriceViewCount() {
		return competePriceViewCount;
	}

	public void setCompetePriceViewCount(Integer competePriceViewCount) {
		this.competePriceViewCount = competePriceViewCount;
	}

	public Date getPublicCompetePriceTime() {
		return publicCompetePriceTime;
	}

	public void setPublicCompetePriceTime(Date publicCompetePriceTime) {
		this.publicCompetePriceTime = publicCompetePriceTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
		this.goodsUnit = goodsUnit;
	}

	public String getNeedTruckType() {
		return needTruckType;
	}

	public void setNeedTruckType(String needTruckType) {
		this.needTruckType = needTruckType;
	}

	public String getZcYmd() {
		return zcYmd;
	}

	public void setZcYmd(String zcYmd) {
		this.zcYmd = zcYmd;
	}

	public String getGoodsImg1() {
		return goodsImg1;
	}

	public void setGoodsImg1(String goodsImg1) {
		this.goodsImg1 = goodsImg1;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDealDate() {
		return dealDate;
	}

	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}
}