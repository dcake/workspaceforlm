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
    
    <title>My JSP 'bankCardTest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${ctxStatic}/modules/cms/front/themes/weixin/lyb/jquery-1.7.1.min.js"></script>
	<script type="text/javascript">
		//添加银行卡
		function addUsersBankCard(){
			var obj = new Object();  
				obj.bankCardPerson = "测试1";  
				obj.bankCardNo = "123456789123456789";
				obj.bankName="交通银行";
				obj.userId = "e07a34e723ec4333babf6db66dbc3ebc"; 
			$.ajax({
                type: "POST",
                url:"${ctx}/mobileUsersBankCard/addUsersBankCard",
                data:obj,
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//银行卡信息列表
			function findBankList(){
			$.ajax({
                url:"${ctx}/mobileUsersBankCard/findBankList",
                type: "POST",
                data:{userId:"89558e00243546508d94e1e7420bf015",bankName:"交通银行",bankCardNo:"123456789123456789"},
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
    <input type="button" value="添加银行卡" onclick="addUsersBankCard();">
    <input type="button" value="银行卡列表" onclick="findBankList();">
  </body>
</html>
