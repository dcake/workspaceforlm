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
    
    <title>My JSP 'shipperMessgaeTest.jsp' starting page</title>
    
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
	
		//分类列表
		function getMessageInfo(){
			var data = {userId:"1"};
			sendAjax("<%=basePath%>/mobileShipperMessage/messageInfo",data);
		}
		//明细列表
		function getMessageList(){
			var data = {messageType:"1",userId:"1"};
			sendAjax("<%=basePath%>/mobileShipperMessage/messageList",data);
		}
		
	</script>
  </head>
  
  <body>
   <input type="button" value="消息分类列表" onclick="getMessageInfo();">
   <input type="button" value="查看明细列表" onclick="getMessageList();">
  </body>
</html>
