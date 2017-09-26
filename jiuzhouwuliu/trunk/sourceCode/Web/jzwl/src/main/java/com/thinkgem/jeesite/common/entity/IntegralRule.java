package com.thinkgem.jeesite.common.entity;


import com.thinkgem.jeesite.common.persistence.CommonEntity;

public class IntegralRule extends CommonEntity<IntegralRule>{
    //
	private static final long serialVersionUID = 1L;

	private String id;

    private String ruleName;

    private Integer integralToMoney;

    private Integer goodsownerRegister;

    private Integer driverRegister;

    private Integer agentRegister;

    private Integer userLogin;

    private Integer improveUserInfo;

    private Integer remarkOrder;

    private Integer completeOrder;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Integer getIntegralToMoney() {
        return integralToMoney;
    }

    public void setIntegralToMoney(Integer integralToMoney) {
        this.integralToMoney = integralToMoney;
    }

    public Integer getGoodsownerRegister() {
        return goodsownerRegister;
    }

    public void setGoodsownerRegister(Integer goodsownerRegister) {
        this.goodsownerRegister = goodsownerRegister;
    }

    public Integer getDriverRegister() {
        return driverRegister;
    }

    public void setDriverRegister(Integer driverRegister) {
        this.driverRegister = driverRegister;
    }

    public Integer getAgentRegister() {
        return agentRegister;
    }

    public void setAgentRegister(Integer agentRegister) {
        this.agentRegister = agentRegister;
    }

    public Integer getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(Integer userLogin) {
        this.userLogin = userLogin;
    }

    public Integer getImproveUserInfo() {
        return improveUserInfo;
    }

    public void setImproveUserInfo(Integer improveUserInfo) {
        this.improveUserInfo = improveUserInfo;
    }

    public Integer getRemarkOrder() {
        return remarkOrder;
    }

    public void setRemarkOrder(Integer remarkOrder) {
        this.remarkOrder = remarkOrder;
    }

    public Integer getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(Integer completeOrder) {
        this.completeOrder = completeOrder;
    }

}