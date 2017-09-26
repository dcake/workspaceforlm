package com.thinkgem.jeesite.common.entity;


import com.thinkgem.jeesite.common.persistence.CommonEntity;

public class InseranceCompany extends CommonEntity<InseranceCompany>{
    //
	private static final long serialVersionUID = 1L;

	private String id;

    private String companyName;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }
}