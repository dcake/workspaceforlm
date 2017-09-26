package com.thinkgem.jeesite.common.entity;

import com.thinkgem.jeesite.common.persistence.CommonEntity;

public class DriveFleet extends CommonEntity<DriveFleet>{
    //
	private static final long serialVersionUID = 1L;

	private String id;

    private String fleetName;


    private String fleetLevel;
    private String truename;
    private String phoneno;
    private String username;
    private String driversDriverType;//车队类型
    private String driversDriverTypeStr;//车队类型字符串
    private String fleetLevelStr;
    private String driversType;
    private String isOrgDriver;
    

	public String getIsOrgDriver() {
		return isOrgDriver;
	}

	public void setIsOrgDriver(String isOrgDriver) {
		this.isOrgDriver = isOrgDriver;
	}

	public String getFleetLevelStr() {
		return fleetLevelStr;
	}

	public void setFleetLevelStr(String fleetLevelStr) {
		this.fleetLevelStr = fleetLevelStr;
	}

	public String getDriversDriverType() {
		return driversDriverType;
	}

	public void setDriversDriverType(String driversDriverType) {
		this.driversDriverType = driversDriverType;
	}

	public String getDriversDriverTypeStr() {
		return driversDriverTypeStr;
	}

	public void setDriversDriverTypeStr(String driversDriverTypeStr) {
		this.driversDriverTypeStr = driversDriverTypeStr;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFleetName() {
        return fleetName;
    }

    public void setFleetName(String fleetName) {
        this.fleetName = fleetName == null ? null : fleetName.trim();
    }


    public String getFleetLevel() {
        return fleetLevel;
    }

    public void setFleetLevel(String fleetLevel) {
        this.fleetLevel = fleetLevel == null ? null : fleetLevel.trim();
    }

	public String getDriversType() {
		return driversType;
	}

	public void setDriversType(String driversType) {
		this.driversType = driversType;
	}
}