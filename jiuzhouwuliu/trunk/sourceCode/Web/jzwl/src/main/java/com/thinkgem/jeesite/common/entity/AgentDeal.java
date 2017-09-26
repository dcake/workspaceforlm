package com.thinkgem.jeesite.common.entity;

import com.thinkgem.jeesite.common.persistence.CommonEntity;

public class AgentDeal extends CommonEntity<AgentDeal>{
    //
	private static final long serialVersionUID = 1L;

	private String id;

    private String agentOrderId;

    private String payStyle;

    private String payOrder;

    private Double suggestPrice;

    private Double restMoney;

    private Double oilCardMoney;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAgentOrderId() {
        return agentOrderId;
    }

    public void setAgentOrderId(String agentOrderId) {
        this.agentOrderId = agentOrderId == null ? null : agentOrderId.trim();
    }

    public String getPayStyle() {
        return payStyle;
    }

    public void setPayStyle(String payStyle) {
        this.payStyle = payStyle == null ? null : payStyle.trim();
    }

    public String getPayOrder() {
        return payOrder;
    }

    public void setPayOrder(String payOrder) {
        this.payOrder = payOrder == null ? null : payOrder.trim();
    }

    public Double getSuggestPrice() {
        return suggestPrice;
    }

    public void setSuggestPrice(Double suggestPrice) {
        this.suggestPrice = suggestPrice;
    }

    public Double getRestMoney() {
        return restMoney;
    }

    public void setRestMoney(Double restMoney) {
        this.restMoney = restMoney;
    }

    public Double getOilCardMoney() {
        return oilCardMoney;
    }

    public void setOilCardMoney(Double oilCardMoney) {
        this.oilCardMoney = oilCardMoney;
    }

}