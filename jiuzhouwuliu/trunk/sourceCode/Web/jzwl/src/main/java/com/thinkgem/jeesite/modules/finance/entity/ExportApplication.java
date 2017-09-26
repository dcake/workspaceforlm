package com.thinkgem.jeesite.modules.finance.entity;

import com.thinkgem.jeesite.common.persistence.CommonEntity;
import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;

/**
 * @description	体现申请审核导出模板
 * @author 王瀚
 */
public class ExportApplication extends CommonEntity<ExportApplication>{

	
	private static final long serialVersionUID = 7805971526720658936L;
	/**
	 *   
	 * @author 王瀚
	 */
	@ExcelField(title="用户名", align=2, sort=1)
	private String username;//用户名
	  
	@ExcelField(title="姓名", align=2, sort=2)
	private String truename;//姓名
	  
	@ExcelField(title="手机号", align=2, sort=3)
	private String phoneno;//手机号
	
	@ExcelField(title="用户类型", align=2, sort=4)
    private String userSort;//用户类型
    
	@ExcelField(title="状态", align=2, sort=5)
    private String isPass;//余额（元）

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

	public String getIsPass() {
		return isPass;
	}

	public void setIsPass(String isPass) {
		this.isPass = isPass;
	}
    
	
}
