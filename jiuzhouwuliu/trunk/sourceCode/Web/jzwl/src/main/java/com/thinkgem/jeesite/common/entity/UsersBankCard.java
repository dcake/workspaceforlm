package com.thinkgem.jeesite.common.entity;


import com.thinkgem.jeesite.common.persistence.CommonEntity;

public class UsersBankCard extends CommonEntity<UsersBankCard>{
    //
	private static final long serialVersionUID = 1L;

	private String id;

    private String bankName;

    private String bankCardNo;

    private String bankCardPerson;

    private String bankAdress;
    
    private String userId;

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo == null ? null : bankCardNo.trim();
    }

    public String getBankCardPerson() {
        return bankCardPerson;
    }

    public void setBankCardPerson(String bankCardPerson) {
        this.bankCardPerson = bankCardPerson == null ? null : bankCardPerson.trim();
    }

    public String getBankAdress() {
        return bankAdress;
    }

    public void setBankAdress(String bankAdress) {
        this.bankAdress = bankAdress == null ? null : bankAdress.trim();
    }
}