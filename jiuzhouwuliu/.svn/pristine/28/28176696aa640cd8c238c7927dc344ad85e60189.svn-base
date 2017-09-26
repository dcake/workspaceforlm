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
    
    <title>My JSP 'balanceTest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${ctxStatic}/modules/cms/front/themes/weixin/lyb/jquery-1.7.1.min.js"></script>
	<script type="text/javascript">
		//获取最新提现&充值记录
		function getLateBalance(){
			var obj = new Object();  
				obj.userId = "d7baff4648744657a9e59357bf479ad7"; 
			$.ajax({
                type: "POST",
                url:"<%=basePath%>/MobileCommonBalance/getLateBalance",
                data:obj,
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//获取用户消费/充值操作记录
			function findAccountOperateList(){
			$.ajax({
                url:"<%=basePath%>/MobileCommonBalance/getAccountOperate",
                type: "POST",
                data:{userId:"d7baff4648744657a9e59357bf479ad7"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    
                    console.log(JSON.stringify(data));
                }
            });
		}
		//用户充值
			function userRecharged(){
			var param = new Object();
				param.userId = "d7baff4648744657a9e59357bf479ad7";
				param.operatMoney = "2000";
				param.bankId = "0";
				param.payStyle = "01";
			$.ajax({
                url:"<%=basePath%>/MobileCommonBalance/userRecharged",
                type: "POST",
                data:param,
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    
                    console.log(JSON.stringify(data));
                }
            });
		}
		
			//用户提现
			function userWithdrawCash(){
			var param = new Object();
				param.userId = "d7baff4648744657a9e59357bf479ad7";
				param.appayMoney = "100";
				param.bankCardId = "0";
			$.ajax({
                url:"<%=basePath%>/MobileCommonBalance/userWithdrawCash",
                type: "POST",
                data:param,
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
    <input type="button" value="最新提现&充值记录" onclick="getLateBalance();">
    <input type="button" value="消费/充值操作记录" onclick="findAccountOperateList();">
    <input type="button" value="用户充值" onclick="userRecharged();">
    <input type="button" value="用户提现" onclick="userWithdrawCash();">
  </body>
</html>
