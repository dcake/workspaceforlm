package com.thinkgem.jeesite.common.config;
/**
 * @description：订单状态全局类
 * @author pangchengxiang
 * @date 2017年9月20日 下午3:42:35
 */
public class OrderStatus {
	
	//未发布
	public static final String NOT_PUBLIC="0";
	//竞价中
	public static final String BIDING_IN_COMPETITION="1";
	//已取消
	public static final String HAS_CANCEL="2";
	//待装载
	public static final String WAIT_LOAD="3";
	//运输中
	public static final String IN_TRANSIT="4";
	//已完成
	public static final String HAS_COMPELETE="5";
	//审核中
	public static final String AUDITING="6";
	//已驳回
	public static final String HAS_REJECT="7";
	//待确认
	public static final String WAIT_CONFIRM="8";
	//已委托
	public static final String HAS_ENTRUST="9";
	//已拒绝
	public static final String HAS_REFUSE="10";
	//已送达
	public static final String HAS_ARRIVE="11";
	//信息费未缴纳
	public static final String NOT_PAY_INFO_FEE="12";
	//待货主确认
	public static final String WAIT_GOODSOWNER_CONFIRM="13";
	//尾款待收
	public static final String 	WAIT_RECIVE_FINALPAYMENT="14";
	
}
