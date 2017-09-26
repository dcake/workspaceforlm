package com.thinkgem.jeesite.common.entity;
import java.util.Date;

import com.thinkgem.jeesite.common.persistence.CommonEntity;

public class DriverMasterChange extends CommonEntity<DriverMasterChange>{
    //
	private static final long serialVersionUID = 1L;

	private String id;

    private String orgDriverMasterId;

    private String memberId;

    private String auditingStatus;

    private String auditingRemark;
    
    private String shipperName;//车队长用户名
    
    private String shipperTel;//车队长手机
    
    private String goodsType;//车队长姓名
    
    private String shipperAreaDetail;//车队长身份证号
    
    private String reciverAreaDetail;//等级
    
    private String reciverTel;//转让人用户名
    
    private String insuranceType;//转让人手机
    
    private String goodsUnit;//转让人姓名
    
    private String goodsNum;//转让人身份证号码
    
    private String needTruckType;//转让人等级

    private String name1;//车队长姓名
    
    private String phone1;//车队长手机号
    
    private String name2;//转让人姓名
    
    private String phone2;//转让人手机号

    private Date updateDate;//更新时间
    
    public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getShipperName() {
		return shipperName;
	}

	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}

	public String getShipperTel() {
		return shipperTel;
	}

	public void setShipperTel(String shipperTel) {
		this.shipperTel = shipperTel;
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

	public String getReciverTel() {
		return reciverTel;
	}

	public void setReciverTel(String reciverTel) {
		this.reciverTel = reciverTel;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getGoodsUnit() {
		return goodsUnit;
	}

	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit;
	}

	public String getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getNeedTruckType() {
		return needTruckType;
	}

	public void setNeedTruckType(String needTruckType) {
		this.needTruckType = needTruckType;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrgDriverMasterId() {
        return orgDriverMasterId;
    }

    public void setOrgDriverMasterId(String orgDriverMasterId) {
        this.orgDriverMasterId = orgDriverMasterId == null ? null : orgDriverMasterId.trim();
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    public String getAuditingStatus() {
        return auditingStatus;
    }

    public void setAuditingStatus(String auditingStatus) {
        this.auditingStatus = auditingStatus == null ? null : auditingStatus.trim();
    }

    public String getAuditingRemark() {
        return auditingRemark;
    }

    public void setAuditingRemark(String auditingRemark) {
        this.auditingRemark = auditingRemark == null ? null : auditingRemark.trim();
    }

}