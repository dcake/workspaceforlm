package com.thinkgem.jeesite.common.entity;

import com.thinkgem.jeesite.common.persistence.CommonEntity;

public class GoodsBilling extends CommonEntity<GoodsBilling>{
    //
	private static final long serialVersionUID = 1L;

	private String id;

    private String goodsid;

    private Double billingMoney;

    private String billingNo;
    //非数据库字段
	private String companyName;//公司名称
    private String orderNo;//订单编号
    private String payMoney;//支付金额
    private String truename;//真实姓名
    private String goodsType;//货物类型
    private String isHasBill;//是否开票
    private String beginDate;//开始时间
    private String endDate;//结束时间
    private String phoneno;//手机号
    private String level;//货主等级
    private String isSettleAccounts;//是否已结算
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid == null ? null : goodsid.trim();
    }

    public Double getBillingMoney() {
        return billingMoney;
    }

    public void setBillingMoney(Double billingMoney) {
        this.billingMoney = billingMoney;
    }

    public String getBillingNo() {
        return billingNo;
    }

    public void setBillingNo(String billingNo) {
        this.billingNo = billingNo == null ? null : billingNo.trim();
    }

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getIsHasBill() {
		return isHasBill;
	}

	public void setIsHasBill(String isHasBill) {
		this.isHasBill = isHasBill;
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

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getIsSettleAccounts() {
		return isSettleAccounts;
	}

	public void setIsSettleAccounts(String isSettleAccounts) {
		this.isSettleAccounts = isSettleAccounts;
	}
    
}