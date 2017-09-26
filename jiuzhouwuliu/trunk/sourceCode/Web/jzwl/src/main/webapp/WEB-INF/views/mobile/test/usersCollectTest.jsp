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
    
    <title>我的收藏</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${ctxStatic}/modules/cms/front/themes/weixin/lyb/jquery-1.7.1.min.js"></script>
	<script type="text/javascript">
		
		//我的收藏列表
			function userCollectList(userid){
			$.ajax({
                url:"${ctx}/mobileUsersCollect/list",
                type: "POST",
                data:{currentPage:"0",userid:"1"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    
                    console.log(JSON.stringify(data));
                }
            });
		}
			//添加收藏列表
			function addCollectList(userid){
			$.ajax({
                url:"${ctx}/mobileUsersCollect/addCollectList",
                type: "POST",
                data:{currentPage:"0",userid:"1"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    
                    console.log(JSON.stringify(data));
                }
            });
		}
		//添加收藏/取消收藏
			function addCollect(){
			$.ajax({
                url:"${ctx}/mobileUsersCollect/addCollect",
                type: "POST",
                data:{userid:"1",collectUserid:"1",isCollect:"0"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
			//根据收藏用户id查询收藏
			function getUserCollect(userid,collectUserid){
			$.ajax({
                url:"${ctx}/mobileUsersCollect/getUserCollect",
                type: "POST",
                data:{userid:"1",collectUserid:"2"},
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
    <input type="button" value="查找" onclick="getUserCollect();">
    <input type="button" value="我的收藏列表" onclick="userCollectList();">
    <input type="button" value="添加收藏列表" onclick="addCollectList();">
    <input type="button" value="收藏" onclick="addCollect();">
  </body>
</html>
