package com.thinkgem.jeesite.modules.users.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName OrderUserInfo
 * @description TODO(订单详情中货主信息)
 * @author pangchengxiang
 * @date 2017年8月15日 下午3:33:21
 */
public class OrderGoodsownerInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String  orderId;	//货主订单id
	private String  username;	//用户名
	private String  truename;	//姓名
	private String  phoneno;	//手机号
	private String  orderStatus;	//订单状态
	private int  sendCount;		//历史发货数量
	private String payStyle;	//支付方式
	private String payId;			//支付单号
	private Date payTime;		//支付时间
	private double dealMoney;	//订单金额
	private double payMoney;	//支付金额
	private String companyName;	//公司名称
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	private String jingjiaOrWeituo;	//竞价或委托
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getPayStyle() {
		return payStyle;
	}
	public void setPayStyle(String payStyle) {
		this.payStyle = payStyle;
	}
	public String getPayId() {
		return payId;
	}
	public void setPayId(String payId) {
		this.payId = payId;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public double getDealMoney() {
		return dealMoney;
	}
	public void setDealMoney(double dealMoney) {
		this.dealMoney = dealMoney;
	}
	public double getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(double payMoney) {
		this.payMoney = payMoney;
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
	public int getSendCount() {
		return sendCount;
	}
	public void setSendCount(int sendCount) {
		this.sendCount = sendCount;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getJingjiaOrWeituo() {
		return jingjiaOrWeituo;
	}
	public void setJingjiaOrWeituo(String jingjiaOrWeituo) {
		this.jingjiaOrWeituo = jingjiaOrWeituo;
	}
}
