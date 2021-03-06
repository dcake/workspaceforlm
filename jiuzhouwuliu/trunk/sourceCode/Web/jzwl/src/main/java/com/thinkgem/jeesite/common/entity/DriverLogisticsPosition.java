package com.thinkgem.jeesite.common.entity;

import com.thinkgem.jeesite.common.persistence.CommonEntity;

public class DriverLogisticsPosition extends CommonEntity<DriverLogisticsPosition>{
    //
	private static final long serialVersionUID = 1L;

	private String id;

    private String dirverOrderId;

    private String curArea;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDirverOrderId() {
        return dirverOrderId;
    }

    public void setDirverOrderId(String dirverOrderId) {
        this.dirverOrderId = dirverOrderId == null ? null : dirverOrderId.trim();
    }

    public String getCurArea() {
        return curArea;
    }

    public void setCurArea(String curArea) {
        this.curArea = curArea == null ? null : curArea.trim();
    }

}