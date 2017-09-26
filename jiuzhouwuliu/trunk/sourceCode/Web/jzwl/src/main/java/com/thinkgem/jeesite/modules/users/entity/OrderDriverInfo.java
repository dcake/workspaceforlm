package com.thinkgem.jeesite.modules.users.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.thinkgem.jeesite.common.entity.DriverLogisticsPosition;

/**
 * @ClassName OrderUserInfo
 * @description TODO(订单详情中车主信息)
 * @author pangchengxiang
 * @date 2017年8月15日 下午3:33:21
 */
public class OrderDriverInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String orderId;		//车主订单id 
	private String  username;	//用户名
	private String  truename;	//姓名
	private String  phoneno;	//手机号
	private String  orderStatus;	//订单状态
	
	private int  reciveCont;	//历史接单数据
	
	private double  reciveMoney;//收款金额
	private double  oilMoney;	//油卡金额
	private Date  reciveTime;	//收款时间
	
	private double deposit;	//信息费
	private Date  payDepositTime;	//信息费缴纳时间
	
	List<DriverLogisticsPosition> driverLogisticsPosition;	//车主物流信息
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public List<DriverLogisticsPosition> getDriverLogisticsPosition() {
		return driverLogisticsPosition;
	}
	public void setDriverLogisticsPosition(List<DriverLogisticsPosition> driverLogisticsPosition) {
		this.driverLogisticsPosition = driverLogisticsPosition;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public Date getPayDepositTime() {
		return payDepositTime;
	}
	public void setPayDepositTime(Date payDepositTime) {
		this.payDepositTime = payDepositTime;
	}
	public double getReciveMoney() {
		return reciveMoney;
	}
	public void setReciveMoney(double reciveMoney) {
		this.reciveMoney = reciveMoney;
	}
	public double getOilMoney() {
		return oilMoney;
	}
	public void setOilMoney(double oilMoney) {
		this.oilMoney = oilMoney;
	}
	public Date getReciveTime() {
		return reciveTime;
	}
	public void setReciveTime(Date reciveTime) {
		this.reciveTime = reciveTime;
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
	public int getReciveCont() {
		return reciveCont;
	}
	public void setReciveCont(int reciveCont) {
		this.reciveCont = reciveCont;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
}
