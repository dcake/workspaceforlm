package com.thinkgem.jeesite.common.entity;


import com.thinkgem.jeesite.common.persistence.CommonEntity;

public class OrderRemark extends CommonEntity<OrderRemark>{
    //
	private static final long serialVersionUID = 1L;

	private String id;

    private String orderId;

    private String starCount;

    private String content;
    //非数据库字段
    private String username;//用户名
    private String headImg;//头像
    private Integer totalCount;//评价总数量
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getStarCount() {
        return starCount;
    }

    public void setStarCount(String starCount) {
        this.starCount = starCount == null ? null : starCount.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
    
}