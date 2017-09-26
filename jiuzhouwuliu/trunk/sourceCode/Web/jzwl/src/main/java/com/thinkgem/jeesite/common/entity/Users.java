package com.thinkgem.jeesite.common.entity;

import java.util.Date;

import com.thinkgem.jeesite.common.persistence.CommonEntity;

public class Users extends CommonEntity<Users>{
    //
	private static final long serialVersionUID = 1L;

	private String id;
	
	private Integer userno;
	
    private String phoneno;

    private String username;

    private String password;

    private String truename;

    private String spell;

    private String cardno;

    private String cardFaceImg;

    private String cardOtherImg;

    private String sex;

    private String headImg;

    private String level;

    private String examineStatus;

    private String examineRemark;

    private String status;

    private Integer currentPoint;

    private String personDescribe;

    private Double accountMoney;

    private String userSort;

    private String isTruename;

    private String gpsInfo;

    private String areaCode;
    
    private String appId;
    

    private Date lastLoginTime;
    private String userSortStr;
    private String fleetName;//车队名
    private String truckNo;//车牌号
    private String truckType;//车型
    private String truckHeight;//高度
    private String truckLength;//车长
    private String truckMaxwight;
    private String driveLicenceImg1;
    private String driveLicenceImg2;
    private String moveLicenceImg1;
    private String moveLicenceImg2;
    private String isTrueDrive;
    private String isTrueMove;
    private String companyName;

    private String identityType;

    private String businessLicenseFaceImg;

    private String businessLicenseOtherImg;

    private String businessLicenseImgs;

    private String legalpersonFaceImg;

    private String legalpersonOtherImg;

    private String isTruecommpany;
    private String usersStatus;
    
    private String agentId;//经纪人ID
    private Integer dealTotalCount;//交易总次数
    private Integer dealCount;//曾与我交易次数
    private String isCollect;//是否收藏（0-否，1-是）
    
    private Integer transportCount;//运输次数
    private Integer ShipCount;//发货次数
    private String truckWidth;
    
    public String getTruckWidth() {
		return truckWidth;
	}

	public void setTruckWidth(String truckWidth) {
		this.truckWidth = truckWidth;
	}

	public String getUsersStatus() {
		return usersStatus;
	}

	public void setUsersStatus(String usersStatus) {
		this.usersStatus = usersStatus;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getIdentityType() {
		return identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	public String getBusinessLicenseFaceImg() {
		return businessLicenseFaceImg;
	}

	public void setBusinessLicenseFaceImg(String businessLicenseFaceImg) {
		this.businessLicenseFaceImg = businessLicenseFaceImg;
	}

	public String getBusinessLicenseOtherImg() {
		return businessLicenseOtherImg;
	}

	public void setBusinessLicenseOtherImg(String businessLicenseOtherImg) {
		this.businessLicenseOtherImg = businessLicenseOtherImg;
	}

	public String getBusinessLicenseImgs() {
		return businessLicenseImgs;
	}

	public void setBusinessLicenseImgs(String businessLicenseImgs) {
		this.businessLicenseImgs = businessLicenseImgs;
	}

	public String getLegalpersonFaceImg() {
		return legalpersonFaceImg;
	}

	public void setLegalpersonFaceImg(String legalpersonFaceImg) {
		this.legalpersonFaceImg = legalpersonFaceImg;
	}

	public String getLegalpersonOtherImg() {
		return legalpersonOtherImg;
	}

	public void setLegalpersonOtherImg(String legalpersonOtherImg) {
		this.legalpersonOtherImg = legalpersonOtherImg;
	}

	public String getIsTruecommpany() {
		return isTruecommpany;
	}

	public void setIsTruecommpany(String isTruecommpany) {
		this.isTruecommpany = isTruecommpany;
	}

	public String getTruckNo() {
		return truckNo;
	}

	public void setTruckNo(String truckNo) {
		this.truckNo = truckNo;
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

	public String getTruckLength() {
		return truckLength;
	}

	public void setTruckLength(String truckLength) {
		this.truckLength = truckLength;
	}

	public String getTruckMaxwight() {
		return truckMaxwight;
	}

	public void setTruckMaxwight(String truckMaxwight) {
		this.truckMaxwight = truckMaxwight;
	}

	public String getDriveLicenceImg1() {
		return driveLicenceImg1;
	}

	public void setDriveLicenceImg1(String driveLicenceImg1) {
		this.driveLicenceImg1 = driveLicenceImg1;
	}

	public String getDriveLicenceImg2() {
		return driveLicenceImg2;
	}

	public void setDriveLicenceImg2(String driveLicenceImg2) {
		this.driveLicenceImg2 = driveLicenceImg2;
	}

	public String getMoveLicenceImg1() {
		return moveLicenceImg1;
	}

	public void setMoveLicenceImg1(String moveLicenceImg1) {
		this.moveLicenceImg1 = moveLicenceImg1;
	}

	public String getMoveLicenceImg2() {
		return moveLicenceImg2;
	}

	public void setMoveLicenceImg2(String moveLicenceImg2) {
		this.moveLicenceImg2 = moveLicenceImg2;
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

	public String getFleetName() {
		return fleetName;
	}

	public void setFleetName(String fleetName) {
		this.fleetName = fleetName;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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
        this.phoneno = phoneno == null ? null : phoneno.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename == null ? null : truename.trim();
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell == null ? null : spell.trim();
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public String getCardFaceImg() {
        return cardFaceImg;
    }

    public void setCardFaceImg(String cardFaceImg) {
        this.cardFaceImg = cardFaceImg == null ? null : cardFaceImg.trim();
    }

    public String getCardOtherImg() {
        return cardOtherImg;
    }

    public void setCardOtherImg(String cardOtherImg) {
        this.cardOtherImg = cardOtherImg == null ? null : cardOtherImg.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getExamineStatus() {
        return examineStatus;
    }

    public void setExamineStatus(String examineStatus) {
        this.examineStatus = examineStatus == null ? null : examineStatus.trim();
    }

    public String getExamineRemark() {
        return examineRemark;
    }

    public void setExamineRemark(String examineRemark) {
        this.examineRemark = examineRemark == null ? null : examineRemark.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getCurrentPoint() {
    	return null==currentPoint?0:currentPoint;
    }

    public void setCurrentPoint(Integer currentPoint) {
        this.currentPoint = currentPoint;
    }

    public String getPersonDescribe() {
        return personDescribe;
    }

    public void setPersonDescribe(String personDescribe) {
        this.personDescribe = personDescribe == null ? null : personDescribe.trim();
    }

    public Double getAccountMoney() {
    	return null==accountMoney?0.00:accountMoney;
    }

    public void setAccountMoney(Double accountMoney) {
        this.accountMoney = accountMoney;
    }

    public String getUserSort() {
        return userSort;
    }

    public void setUserSort(String userSort) {
        this.userSort = userSort == null ? null : userSort.trim();
    }

    public String getIsTruename() {
        return isTruename;
    }

    public void setIsTruename(String isTruename) {
        this.isTruename = isTruename == null ? null : isTruename.trim();
    }

    public String getGpsInfo() {
        return gpsInfo;
    }

    public void setGpsInfo(String gpsInfo) {
        this.gpsInfo = gpsInfo == null ? null : gpsInfo.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }
    
    public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId == null ? null : appId.trim();
	}

	public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

	public String getUserSortStr() {
		return userSortStr;
	}

	public void setUserSortStr(String userSortStr) {
		this.userSortStr = userSortStr;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public Integer getDealTotalCount() {
		return dealTotalCount;
	}

	public void setDealTotalCount(Integer dealTotalCount) {
		this.dealTotalCount = dealTotalCount;
	}

	public Integer getDealCount() {
		return dealCount;
	}

	public void setDealCount(Integer dealCount) {
		this.dealCount = dealCount;
	}

	public String getIsCollect() {
		return isCollect;
	}

	public void setIsCollect(String isCollect) {
		this.isCollect = isCollect;
	}

	public Integer getTransportCount() {
		return transportCount;
	}

	public void setTransportCount(Integer transportCount) {
		this.transportCount = transportCount;
	}

	public Integer getShipCount() {
		return ShipCount;
	}

	public void setShipCount(Integer shipCount) {
		ShipCount = shipCount;
	}
	private String driveFleetId;
	public String getDriveFleetId() {
		return driveFleetId;
	}

	public void setDriveFleetId(String driveFleetId) {
		this.driveFleetId = driveFleetId;
	}
	
}