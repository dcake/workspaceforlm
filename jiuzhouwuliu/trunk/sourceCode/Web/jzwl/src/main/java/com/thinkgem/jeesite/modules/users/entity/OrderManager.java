package com.thinkgem.jeesite.modules.users.entity;

import java.util.Date;

import com.thinkgem.jeesite.common.persistence.CommonEntity;

/**
 * @ClassName OrderManage
 * @description TODO(订单管理)
 * @author pangchengxiang
 * @date 2017年8月11日 上午11:23:45
 */
public class OrderManager extends CommonEntity<OrderManager>{
	private static final long serialVersionUID = 1L;
	private String id;	//货物id
	private String gooderOwnerOrderId;	//货主订单id
	
	private String agentOrderId;		//经纪人订单id
	private String orderNo;	//订单编号
	private Double money;	//金额
	private String goodsowner;	//货主
	private String driver;	//车主
	private String agent;	//经纪人
	private String goodsType;	//货物类型
	private String shippeArea;	//发货地
	private String reciverArea;	//收货地
	private String status;	//状态
	private String isHasInsurance;	//是否交保险
	private String isBill;	//是否开票
	private Date createDate;	//创建日期
	private String goodsBelongto;	//货物归属
	

	private String startDate;	//查询起始日期
	private String endDate;		//查询截止日期
	private String agentStatus;	//经纪人状态
	private String goodsownerStatus;	//货主状态
	private Double agentMoney;	//经纪人交易价格
	private Double goodsMoney;	//货主交易价格
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGooderOwnerOrderId() {
		return gooderOwnerOrderId;
	}
	public void setGooderOwnerOrderId(String gooderOwnerOrderId) {
		this.gooderOwnerOrderId = gooderOwnerOrderId;
	}
	public String getAgentOrderId() {
		return agentOrderId;
	}
	public void setAgentOrderId(String agentOrderId) {
		this.agentOrderId = agentOrderId;
	}
	public Double getAgentMoney() {
		return agentMoney;
	}
	public void setAgentMoney(Double agentMoney) {
		this.agentMoney = agentMoney;
	}
	public Double getGoodsMoney() {
		return goodsMoney;
	}
	public void setGoodsMoney(Double goodsMoney) {
		this.goodsMoney = goodsMoney;
	}
	public String getGoodsBelongto() {
		return goodsBelongto;
	}
	public void setGoodsBelongto(String goodsBelongto) {
		this.goodsBelongto = goodsBelongto;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getGoodsowner() {
		return goodsowner;
	}
	public void setGoodsowner(String goodsowner) {
		this.goodsowner = goodsowner;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public String getShippeArea() {
		return shippeArea;
	}
	public void setShippeArea(String shippeArea) {
		this.shippeArea = shippeArea;
	}
	public String getReciverArea() {
		return reciverArea;
	}
	public void setReciverArea(String reciverArea) {
		this.reciverArea = reciverArea;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIsHasInsurance() {
		return isHasInsurance;
	}
	public void setIsHasInsurance(String isHasInsurance) {
		this.isHasInsurance = isHasInsurance;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public String getAgentStatus() {
		return agentStatus;
	}
	public void setAgentStatus(String agentStatus) {
		this.agentStatus = agentStatus;
	}
	public String getGoodsownerStatus() {
		return goodsownerStatus;
	}
	public void setGoodsownerStatus(String goodsownerStatus) {
		this.goodsownerStatus = goodsownerStatus;
	}
	public String getIsBill() {
		return isBill;
	}
	public void setIsBill(String isBill) {
		this.isBill = isBill;
	}
}
