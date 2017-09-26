<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shipperTest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${ctxStatic}/modules/cms/front/themes/weixin/lyb/jquery-1.7.1.min.js"></script>
	<script type="text/javascript">
		//竞价列表（根据agentId判断是经纪人还是货主订单）
		function findDriverBidList(){
			$.ajax({
                type: "POST",
                url:"${ctx}/mobileDriverBid/findDriverBidList",
                data:{currentPage:"0",userId:"ef95c0806b81488c9d6984dfe4129728"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//我参与的竞价列表
		function myBidList(){
			$.ajax({
                type: "POST",
                url:"${ctx}/mobileDriverBid/myBidList",
                data:{currentPage:"0",userId:"1"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//查看竞价
		//type  用于判断是竞价的经纪人发布的货物还是货主发布的货物（0-货主，1-经纪人）
		function lookBidDetail(){
			$.ajax({
                type: "POST",
                url:"${ctx}/mobileDriverBid/lookBidDetail",
                data:{goodsId:"1",type:"0"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//车队员列表
		function findTeamMembersList(){
			$.ajax({
                type: "POST",
                url:"${ctx}/mobileDriverBid/findTeamMembers",
                data:{currentPage:"0",userId:"1"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//出价
		//type 用于判断是经纪人/货主发起的竞价（0货主 1经纪人）
		//teamMemberId 如果指派的车队员就传车队员ID，否则不需要传
		function offerPrice(){
			$.ajax({
                type: "POST",
                url:"${ctx}/mobileDriverBid/offerPrice",
                data:{orderId:"1",userId:"1",type:"0",jingjiaPrice:"1000",teamMemberId:""},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		
		//订单列表
		//type 用于判断订单状态（当前订单-0,历史订单-1,全部订单-不传）
		function findDriverOrderList(){
			$.ajax({
                type: "POST",
                url:"${ctx}/mobileDriverOrder/findDriverOrderList",
                data:{currentPage:"0",driverId:"1"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//支付信息费
		//driverOrderId-车主订单ID； payMethod-支付方式；deposit-信息费；userId-当前登录用户ID
		function payInfoFee(){
			$.ajax({
                type: "POST",
                url:"${ctx}/mobileDriverOrder/payInfoFee",
                data:{driverOrderId:"0",payMethod:"1",deposit:"",userId:""},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//接货单
		//driverOrderId-车主订单ID
		function pickUpBill(){
			$.ajax({
                type: "POST",
                url:"${ctx}/mobileDriverOrder/pickUpBill",
                data:{driverOrderId:"2"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//确认接货
		//传图片
		function confirmPickUp(){
			$.ajax({
                type: "POST",
                url:"${ctx}/mobileDriverOrder/confirmPickUp",
                data:{driverOrderId:"2"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//确认送达
		function confirmService(){
			$.ajax({
                type: "POST",
                url:"${ctx}/mobileDriverOrder/confirmService",
                data:{driverOrderId:"2",expressNo:"",reciveGoodsName:"",sendDriveName:""},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		
		//物流信息
		function logisticsInfoList(){
			$.ajax({
                type: "POST",
                url:"${ctx}/mobileDriverOrder/logisticsInfoList",
                data:{driverOrderId:"2"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
	</script>
  </head>
  
  <body>
   <input type="button" value="竞价列表" onclick="findDriverBidList();">
   <input type="button" value="我的竞价" onclick="myBidList();">
   <input type="button" value="查看竞价" onclick="lookBidDetail();">
   <input type="button" value="车队员列表" onclick="findTeamMembersList();">
   <input type="button" value="出价" onclick="offerPrice();">
   <input type="button" value="订单列表" onclick="findDriverOrderList();">
   <input type="button" value="支付信息费" onclick="payInfoFee();">
   <input type="button" value="接货单" onclick="pickUpBill();">
   <input type="button" value="确认接货" onclick="confirmPickUp();">
   <input type="button" value="确认送达" onclick="confirmService();">
   <input type="button" value="物流信息" onclick="logisticsInfoList();">
   <!--<input type="button" value="收藏或取消" onclick="collectOrCancel();">
   <input type="button" value="经纪人评价列表" onclick="findEvaluationList();">
   <input type="button" value="确认委托" onclick="confirmConsign();"><br>
   <input type="button" value="竞价列表" onclick="bidList();">
   <input type="button" value="查看竞价或查看经纪人" onclick="lookBidOrAgent();">
   <input type="button" value="查看竞价或查看经纪人中的货物信息" onclick="lookGoodsDetail();">
   <input type="button" value="车主评价列表" onclick="findDriverEvaluationList();">
   <input type="button" value="车主历史路线" onclick="findDriveLineList();">
   <input type="button" value="取消委托" onclick="cancleWeiTuo();">
   <input type="button" value="取消竞价" onclick="cancleJingJia();"> 
   <input type="button" value="确认或取消竞价人" onclick="chooseOrCancleJingJiaRen();">
   <input type="button" value="确认交易" onclick="confrimTransaction();"><br/>
   <input type="button" value="积分列表" onclick="findInseranceList();">
   <input type="button" value="添加积分" onclick="insertIntegral();">
   <input type="button" value="路线记录列表" onclick="findLineList();">
   <input type="button" value="最近联系人列表" onclick="findRecentPersonList();"> -->
  </body>
</html>
