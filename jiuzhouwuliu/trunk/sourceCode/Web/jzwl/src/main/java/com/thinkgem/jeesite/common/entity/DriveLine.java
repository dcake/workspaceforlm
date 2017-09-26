package com.thinkgem.jeesite.common.entity;

import java.util.Date;

import com.thinkgem.jeesite.common.persistence.CommonEntity;

public class DriveLine extends CommonEntity<DriveLine>{
    //
	private static final long serialVersionUID = 1L;

	private String id;

    private String driverId;

    private String fromArea;

    private String toArea;

    private Date goTime;

    private String publicStatus;

    private Integer aviableDays;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId == null ? null : driverId.trim();
    }

    public String getFromArea() {
        return fromArea;
    }

    public void setFromArea(String fromArea) {
        this.fromArea = fromArea == null ? null : fromArea.trim();
    }

    public String getToArea() {
        return toArea;
    }

    public void setToArea(String toArea) {
        this.toArea = toArea == null ? null : toArea.trim();
    }

    public Date getGoTime() {
        return goTime;
    }

    public void setGoTime(Date goTime) {
        this.goTime = goTime;
    }

    public String getPublicStatus() {
        return publicStatus;
    }

    public void setPublicStatus(String publicStatus) {
        this.publicStatus = publicStatus == null ? null : publicStatus.trim();
    }

    public Integer getAviableDays() {
        return aviableDays;
    }

    public void setAviableDays(Integer aviableDays) {
        this.aviableDays = aviableDays;
    }
}