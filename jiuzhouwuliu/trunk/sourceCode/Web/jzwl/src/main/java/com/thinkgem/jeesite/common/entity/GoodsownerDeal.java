package com.thinkgem.jeesite.common.entity;

import java.util.Date;

import com.thinkgem.jeesite.common.persistence.CommonEntity;

public class GoodsownerDeal extends CommonEntity<GoodsownerDeal> {
	//
	private static final long serialVersionUID = 1L;

	private String id;

	private String goodsownerOrderId;

	private String isBill;

	private String companyName;

	private String taxpayerNo;

	private String adress;

	private String tel;

	private String bankName;

	private String bankCardno;

	private String billToAddress;

	private String payStyle;

	private Double dealMoney;

	private String isDealOk;

	private Double carryFee;

	private Double taxFee;

	private Double payMoney;

	private String isSettleAccounts;

	private Date settleAccountsDate;

	private String userId;// 非数据库字段，用于接收手机端传过来的用户ID
	private String type;// type 用于判断是查看竞价还是查看经纪人（0-查看竞价，1-查看经纪人）
	private String jingJiaRenId;// 竞价人ID(也就是所谓的userID)

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getGoodsownerOrderId() {
		return goodsownerOrderId;
	}

	public void setGoodsownerOrderId(String goodsownerOrderId) {
		this.goodsownerOrderId = goodsownerOrderId == null ? null : goodsownerOrderId.trim();
	}

	public String getIsBill() {
		return isBill;
	}

	public void setIsBill(String isBill) {
		this.isBill = isBill == null ? null : isBill.trim();
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName == null ? null : companyName.trim();
	}

	public String getTaxpayerNo() {
		return taxpayerNo;
	}

	public void setTaxpayerNo(String taxpayerNo) {
		this.taxpayerNo = taxpayerNo == null ? null : taxpayerNo.trim();
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress == null ? null : adress.trim();
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel == null ? null : tel.trim();
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName == null ? null : bankName.trim();
	}

	public String getBankCardno() {
		return bankCardno;
	}

	public void setBankCardno(String bankCardno) {
		this.bankCardno = bankCardno == null ? null : bankCardno.trim();
	}

	public String getBillToAddress() {
		return billToAddress;
	}

	public void setBillToAddress(String billToAddress) {
		this.billToAddress = billToAddress == null ? null : billToAddress.trim();
	}

	public String getPayStyle() {
		return payStyle;
	}

	public void setPayStyle(String payStyle) {
		this.payStyle = payStyle == null ? null : payStyle.trim();
	}

	public Double getDealMoney() {
		return dealMoney;
	}

	public void setDealMoney(Double dealMoney) {
		this.dealMoney = dealMoney;
	}

	public String getIsDealOk() {
		return isDealOk;
	}

	public void setIsDealOk(String isDealOk) {
		this.isDealOk = isDealOk == null ? null : isDealOk.trim();
	}

	public Double getCarryFee() {
		return carryFee;
	}

	public void setCarryFee(Double carryFee) {
		this.carryFee = carryFee;
	}

	public Double getTaxFee() {
		return taxFee;
	}

	public void setTaxFee(Double taxFee) {
		this.taxFee = taxFee;
	}

	public Double getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}

	public String getIsSettleAccounts() {
		return isSettleAccounts;
	}

	public void setIsSettleAccounts(String isSettleAccounts) {
		this.isSettleAccounts = isSettleAccounts == null ? null : isSettleAccounts.trim();
	}

	public Date getSettleAccountsDate() {
		return settleAccountsDate;
	}

	public void setSettleAccountsDate(Date settleAccountsDate) {
		this.settleAccountsDate = settleAccountsDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getJingJiaRenId() {
		return jingJiaRenId;
	}

	public void setJingJiaRenId(String jingJiaRenId) {
		this.jingJiaRenId = jingJiaRenId;
	}

}