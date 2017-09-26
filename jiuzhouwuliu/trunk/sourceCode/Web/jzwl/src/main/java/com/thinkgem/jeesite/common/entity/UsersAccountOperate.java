package com.thinkgem.jeesite.common.entity;

import com.thinkgem.jeesite.common.persistence.CommonEntity;

public class UsersAccountOperate extends CommonEntity<UsersAccountOperate> {
	//
	private static final long serialVersionUID = 1L;

	private String id;

	private String userid;

	private String operateType;

	private Double operatMoney;

	private String payStyle;

	private String orderNo;

	private String bankCardNo;

	private String isDealOk;

	private Double integralScore;
	private Double restMoney;// 余额
	private Double totalScore;// 总积分
	private String beginDate;// 开始时间
	private String endDate;// 结束时间
	private String payStyleStr;
	private String operateTypeStr;

	public String getPayStyleStr() {
		return payStyleStr;
	}

	public void setPayStyleStr(String payStyleStr) {
		this.payStyleStr = payStyleStr;
	}

	public String getOperateTypeStr() {
		return operateTypeStr;
	}

	public void setOperateTypeStr(String operateTypeStr) {
		this.operateTypeStr = operateTypeStr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid == null ? null : userid.trim();
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType == null ? null : operateType.trim();
	}

	public Double getOperatMoney() {
		return operatMoney;
	}

	public void setOperatMoney(Double operatMoney) {
		this.operatMoney = operatMoney;
	}

	public String getPayStyle() {
		return payStyle;
	}

	public void setPayStyle(String payStyle) {
		this.payStyle = payStyle == null ? null : payStyle.trim();
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo == null ? null : orderNo.trim();
	}

	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo == null ? null : bankCardNo.trim();
	}

	public Double getIntegralScore() {
		return integralScore;
	}

	public void setIntegralScore(Double integralScore) {
		this.integralScore = integralScore;
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

	public String getIsDealOk() {
		return isDealOk;
	}

	public void setIsDealOk(String isDealOk) {
		this.isDealOk = isDealOk == null ? null : isDealOk.trim();
	}

	public Double getRestMoney() {
		return restMoney;
	}

	public void setRestMoney(Double restMoney) {
		this.restMoney = restMoney;
	}

	public Double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Double totalScore) {
		this.totalScore = totalScore;
	}

}