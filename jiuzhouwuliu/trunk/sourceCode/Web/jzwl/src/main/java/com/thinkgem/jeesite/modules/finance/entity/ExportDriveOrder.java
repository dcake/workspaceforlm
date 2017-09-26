package com.thinkgem.jeesite.modules.finance.entity;

import com.thinkgem.jeesite.common.persistence.CommonEntity;
import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;

/**
 * @description	信息费导出模板
 * @author 文帅
 * @date 2017年8月14日 上午11:12:12
 */
public class ExportDriveOrder extends CommonEntity<ExportDriveOrder>{

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
		
		@ExcelField(title="用户类型", align=2, sort=4)
	    private String userSort;//用户类型
	    
		@ExcelField(title="信息费", align=2, sort=5)
	    private String deposit;//信息费
	    
		@ExcelField(title="时间", align=2, sort=6)
	    private String time;//时间
		@ExcelField(title="订单编号", align=2, sort=7)
	    private String orderNo;//订单编号
		public String getDeposit() {
			return deposit;
		}
		public void setDeposit(String deposit) {
			this.deposit = deposit;
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
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public String getOrderNo() {
			return orderNo;
		}
		public void setOrderNo(String orderNo) {
			this.orderNo = orderNo;
		}
		
}
