package com.thinkgem.jeesite.modules.finance.entity;

import com.thinkgem.jeesite.common.persistence.CommonEntity;
import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;

/**
 * @description	信息费导出模板
 * @author 文帅
 * @date 2017年8月14日 上午11:12:12
 */
public class ExportDriverReciveMoney extends CommonEntity<ExportDriverReciveMoney>{

		/**
		 *   
		 * @author 文帅
		 * 日期 2017年8月14日
		 */
		private static final long serialVersionUID = 629011877204083438L;

		@ExcelField(title="用户名", align=2, sort=1)
		private String username;//用户名
		  
		@ExcelField(title="姓名", align=2, sort=2)
		private String truename;//姓名
		  
		@ExcelField(title="手机号", align=2, sort=3)
		private String phoneno;//手机号
		
		@ExcelField(title="用户等级", align=2, sort=4)
	    private String level;//用户等级
	    
		@ExcelField(title="运费", align=2, sort=5)
	    private String carryFee;//运费
	    
		@ExcelField(title="税费", align=2, sort=6)
	    private String taxFee;//税费
		
		@ExcelField(title="第一次垫资金额", align=2, sort=7)
	    private String firstReciveMoney;//第一次垫资金额
		
		@ExcelField(title="油卡支付", align=2, sort=8)
	    private String firstReciveOil;//油卡支付
		
		@ExcelField(title="第二次垫资金额", align=2, sort=9)
	    private String secondReciveMoney;//第二次垫资金额
		
		@ExcelField(title="油卡支付", align=2, sort=10)
	    private String secondReciveOil;//油卡支付
		
		@ExcelField(title="垫资总额", align=2, sort=11)
	    private String totalMoney;//垫资总额
		
		@ExcelField(title="订单编号", align=2, sort=12)
	    private String orderNo;//订单编号
		
		@ExcelField(title="时间", align=2, sort=13)
	    private String time;//时间
		
		@ExcelField(title="状态", align=2, sort=14)
	    private String isSettleAccounts;//状态

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

		public String getLevel() {
			return level;
		}

		public void setLevel(String level) {
			this.level = level;
		}
		
		public String getCarryFee() {
			return carryFee;
		}

		public void setCarryFee(String carryFee) {
			this.carryFee = carryFee;
		}

		public String getTaxFee() {
			return taxFee;
		}

		public void setTaxFee(String taxFee) {
			this.taxFee = taxFee;
		}

		public String getFirstReciveMoney() {
			return firstReciveMoney;
		}

		public void setFirstReciveMoney(String firstReciveMoney) {
			this.firstReciveMoney = firstReciveMoney;
		}

		public String getFirstReciveOil() {
			return firstReciveOil;
		}

		public void setFirstReciveOil(String firstReciveOil) {
			this.firstReciveOil = firstReciveOil;
		}

		public String getSecondReciveMoney() {
			return secondReciveMoney;
		}

		public void setSecondReciveMoney(String secondReciveMoney) {
			this.secondReciveMoney = secondReciveMoney;
		}

		public String getSecondReciveOil() {
			return secondReciveOil;
		}

		public void setSecondReciveOil(String secondReciveOil) {
			this.secondReciveOil = secondReciveOil;
		}

		public String getTotalMoney() {
			return totalMoney;
		}

		public void setTotalMoney(String totalMoney) {
			this.totalMoney = totalMoney;
		}

		public String getOrderNo() {
			return orderNo;
		}

		public void setOrderNo(String orderNo) {
			this.orderNo = orderNo;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public String getIsSettleAccounts() {
			return isSettleAccounts;
		}

		public void setIsSettleAccounts(String isSettleAccounts) {
			this.isSettleAccounts = isSettleAccounts;
		}
		
}
