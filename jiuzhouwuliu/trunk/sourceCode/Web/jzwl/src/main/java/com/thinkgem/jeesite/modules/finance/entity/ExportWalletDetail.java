package com.thinkgem.jeesite.modules.finance.entity;

import com.thinkgem.jeesite.common.persistence.CommonEntity;
import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;

/**
 * @description	用户钱包明细导出模板
 * @author 文帅
 * @date 2017年8月14日 上午11:12:12
 */
public class ExportWalletDetail extends CommonEntity<ExportWalletDetail>{

		/**
		 *   
		 * @author 文帅
		 * 日期 2017年8月14日
		 */
		private static final long serialVersionUID = 629011877204083438L;

		@ExcelField(title="时间", align=2, sort=1)
		private String creatDate;//时间"
		  
		@ExcelField(title="类型", align=2, sort=2)
		private String operateType;//类型
		  
		@ExcelField(title="金额", align=2, sort=3)
		private String operatMoney;//金额
		
		@ExcelField(title="获取积分", align=2, sort=4)
	    private String integralScore;//获取积分
	    
		@ExcelField(title="余额（元）", align=2, sort=5)
	    private String restMoney;//余额（元）
	    
		@ExcelField(title="总积分", align=2, sort=6)
	    private String totalScore;//总积分

		public String getCreatDate() {
			return creatDate;
		}

		public void setCreatDate(String creatDate) {
			this.creatDate = creatDate;
		}

		public String getOperateType() {
			return operateType;
		}

		public void setOperateType(String operateType) {
			this.operateType = operateType;
		}

		public String getOperatMoney() {
			return operatMoney;
		}

		public void setOperatMoney(String operatMoney) {
			this.operatMoney = operatMoney;
		}

		public String getIntegralScore() {
			return integralScore;
		}

		public void setIntegralScore(String integralScore) {
			this.integralScore = integralScore;
		}

		public String getRestMoney() {
			return restMoney;
		}

		public void setRestMoney(String restMoney) {
			this.restMoney = restMoney;
		}

		public String getTotalScore() {
			return totalScore;
		}

		public void setTotalScore(String totalScore) {
			this.totalScore = totalScore;
		}

}
