/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.common.persistence;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinkgem.jeesite.common.entity.Users;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.users.util.AppUserUtils;

/**
 * 数据Entity类
 * 
 * @author pcx
 * @version 2017-08-07
 */
public abstract class CommonEntity<T> extends BaseEntity<T> {

	private static final long serialVersionUID = 1L;

	protected String remarks; // 备注
	protected String createBy; // 创建者
	protected Date createDate; // 创建日期
	protected String updateBy; // 更新者
	protected Date updateDate; // 更新日期
	protected String delFlag; // 删除标记（0：正常；1：删除；2：审核）

	public CommonEntity() {
		super();
		this.delFlag = DEL_FLAG_NORMAL;
	}

	public CommonEntity(String id) {
		super(id);
	}

	/**
	 * 插入之前执行方法，需要手动调用
	 */
	@Override
	public void preInsert() {
		// 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
		if (!this.isNewRecord) {
			setId(IdGen.uuid());
		}
		User user = UserUtils.getUser();
		if (StringUtils.isNotBlank(user.getId())) {
			this.updateBy = user.getId();
			this.createBy = user.getId();
		}
		this.updateDate = new Date();
		this.createDate = this.updateDate;
	}

	/**
	 * 更新之前执行方法，需要手动调用
	 */
	@Override
	public void preUpdate() {
		User user = UserUtils.getUser();
		if (StringUtils.isNotBlank(user.getId())) {
			this.updateBy = user.getId();
		}
		this.updateDate = new Date();
	}

	/**
	 * APP插入之前执行方法，子类实现
	 */
	public void preAppInsert() {
		// 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
		if (!this.isNewRecord) {
			setId(IdGen.uuid());
		}
		Users users = AppUserUtils.getUser(false);
		if (null!=users&&StringUtils.isNotBlank(users.getId())) {
			this.updateBy = users.getId();
			this.createBy = users.getId();
		}else{
			this.updateBy = "未知用户";
			this.createBy = "未知用户";
		}
		this.updateDate = new Date();
		this.createDate = this.updateDate;
	};

	/**
	 * APP更新之前执行方法，子类实现
	 */
	public void preAppUpdate() {
		Users users = AppUserUtils.getUser(false);
		if (null!=users&&StringUtils.isNotBlank(users.getId())) {
			this.updateBy = users.getId();
		}else{
			this.updateBy = "未知用户";
		}
		this.updateDate = new Date();
	};

	@Length(min = 0, max = 255)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@JsonIgnore
	@Length(min = 1, max = 1)
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

}
