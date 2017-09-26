package com.thinkgem.jeesite.common.entity;

import com.thinkgem.jeesite.common.persistence.CommonEntity;

public class UsersCollect extends CommonEntity<UsersCollect>{
    //
	private static final long serialVersionUID = 1L;

	private String id;

    private String userid;

    private String collectUserid;
    
    private String truename;//姓名
    private String headImg;//头像
    private String userSort;//用户分类
    private String gpsInfo;//gps位置信息
    private String areaCode;//区域编码
    private String sex;//性别
    private Integer count;//交易数
    private String companyName;//企业名称
    private String isCollect;


    public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getUserSort() {
		return userSort;
	}

	public void setUserSort(String userSort) {
		this.userSort = userSort;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

    public String getCollectUserid() {
        return collectUserid;
    }

    public void setCollectUserid(String collectUserid) {
        this.collectUserid = collectUserid == null ? null : collectUserid.trim();
    }

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getGpsInfo() {
		return gpsInfo;
	}

	public void setGpsInfo(String gpsInfo) {
		this.gpsInfo = gpsInfo;
	}

	public String getIsCollect() {
		return isCollect;
	}

	public void setIsCollect(String isCollect) {
		this.isCollect = isCollect;
	}
}