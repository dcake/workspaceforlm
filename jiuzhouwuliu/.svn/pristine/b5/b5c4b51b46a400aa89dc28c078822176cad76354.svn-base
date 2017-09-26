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
    
    <title>My JSP 'shipperOrderTest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${ctxStatic}/modules/cms/front/themes/weixin/lyb/jquery-1.7.1.min.js"></script>
	<script type="text/javascript">
		//发送ajax请求
		function sendAjax(url,data){
			$.ajax({
                type: "POST",
                url:url,
                data:data,
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                },
                error:function(e){
                	alert("请求失败");
                	console.log(JSON.stringify(e));
                }
            });
		}
	
		//获取货主订单列表
		function shipperOrderList(){
			var data = {userId:"1",type:"0",currentPage:"0"};
			sendAjax("<%=basePath%>/mobileShipperOrder/shipperOrderList",data);
		}
		//获取货主订单详情
		function reviewOrder(){
			var data = {orderId:"1",type:"0"};
			sendAjax("<%=basePath%>/mobileShipperOrder/checkOrder",data);
		}
		//查看委托单详情
		function reviewOrderweituo(){
			var data = {orderId:"1",type:"1"};
			sendAjax("<%=basePath%>/mobileShipperOrder/checkOrder",data);
		}
		//查看物流信息
		function driverLogisticsPosition(){
			var data = {driverOrderId:"1"};
			sendAjax("<%=basePath%>/mobileShipperOrder/driverLogisticsPosition",data);
		}
		//确认送达
		function confirmDelivery(){
			var data = {goodsownerOrderId:"1",userId:"1"};
			sendAjax("<%=basePath%>/mobileShipperOrder/confirmDelivery",data);
		}
		//评价页面货物信息
		function goodsDetail(){
			var data = {orderId:"1"};
			sendAjax("<%=basePath%>/mobileShipperOrder/goodsDetail",data);
		}
		//评价
		function evaluation(){
			var data = {orderId:"1",starCount:"4",content:"订单评价测试！",userId:"1"};
			sendAjax("<%=basePath%>/mobileShipperOrder/evaluation",data);
		}
		//申诉
		function complain(){
			var data = {driveOrderId:"1",userId:"1",complainReason:"未收到货",complainContent:"申诉"};
			sendAjax("<%=basePath%>/mobileShipperOrder/complain",data);
		}
		//提醒装载
		function reminderToLoad(){
			var data = {orderId:"1",userId:"1"};
			sendAjax("<%=basePath%>/mobileShipperOrder/reminderToLoad",data);
		}
	</script>
  </head>
  
  <body>
   <input type="button" value="货主订单列表" onclick="shipperOrderList();">
   <input type="button" value="查看订单--运输中" onclick="reviewOrder();">
   <input type="button" value="查看订单--委托单--带装载" onclick="reviewOrderweituo();">
   <input type="button" value="查看订单--查看物流" onclick="driverLogisticsPosition();">
   <input type="button" value="查看订单--确认送达" onclick="confirmDelivery();">
   <input type="button" value="查看订单--货物详情" onclick="goodsDetail();">
   <input type="button" value="查看订单--评价" onclick="evaluation();">
   <input type="button" value="查看订单--申诉" onclick="complain();">
   <input type="button" value="提醒装载" onclick="reminderToLoad();">
  </body>
</html>
