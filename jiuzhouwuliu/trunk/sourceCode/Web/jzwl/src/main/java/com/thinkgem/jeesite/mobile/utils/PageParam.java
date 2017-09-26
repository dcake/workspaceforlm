package com.thinkgem.jeesite.mobile.utils;
/**
 * @desc app端分页类
 * @author yaotengfei
 * @date 20172017年3月29日上午11:19:38
 */
public class PageParam {
	
	//默认显示10条
	public static final int DEFAULT_PAGESIZE = 10;
	// 当前页
	private int currentPage;
	private int pageSize;
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
}
