package com.thinkgem.jeesite.modules.finance.entity;

import com.thinkgem.jeesite.common.persistence.CommonEntity;
import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;

/**
 * @description	用户钱包导出模板
 * @author 文帅
 * @date 2017年8月14日 上午11:12:12
 */
public class ExportUsersWallet extends CommonEntity<ExportUsersWallet>{

		/**
		 *   
		 * @author 文帅
		 * 日期 2017年8月14日
		 */
		private static final long serialVersionUID = 1567438225403036061L;

		@ExcelField(title="用户名", align=2, sort=1)
		private String username;//用户名
		  
		@ExcelField(title="姓名", align=2, sort=2)
		private String truename;//姓名
		  
		@ExcelField(title="手机号", align=2, sort=3)
		private String phoneno;//手机号
		
		@ExcelField(title="用户类型", align=2, sort=4)
	    private String userSort;//用户类型
	    
		@ExcelField(title="余额（元）", align=2, sort=5)
	    private String accountMoney;//余额（元）
	    
		@ExcelField(title="积分", align=2, sort=6)
	    private String currentPoint;//积分

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

		public String getAccountMoney() {
			return accountMoney;
		}

		public void setAccountMoney(String string) {
			this.accountMoney = string;
		}

		public String getCurrentPoint() {
			return currentPoint;
		}

		public void setCurrentPoint(String currentPoint) {
			this.currentPoint = currentPoint;
		}
		
}
