package com.thinkgem.jeesite.common.entity;

import com.thinkgem.jeesite.common.persistence.CommonEntity;



public class UserWithdrawCash extends CommonEntity<UserWithdrawCash>{
    //
	private static final long serialVersionUID = 1L;

	private String id;

    private String userid;
    private String bankCardId;

    private String isPass;
    
    private Double appayMoney;
    //非数据库字段
    private String username;
    private String truename;
    private String phoneno;
    private String userSort;
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

    public String getIsPass() {
        return isPass;
    }

    public void setIsPass(String isPass) {
        this.isPass = isPass == null ? null : isPass.trim();
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getUserSort() {
		return userSort;
	}

	public void setUserSort(String userSort) {
		this.userSort = userSort;
	}

	public Double getAppayMoney() {
		return appayMoney;
	}

	public void setAppayMoney(Double appayMoney) {
		this.appayMoney = appayMoney;
	}

	public String getBankCardId() {
		return bankCardId;
	}

	public void setBankCardId(String bankCardId) {
		 this.bankCardId = bankCardId == null ? null : bankCardId.trim();
	}
    
}