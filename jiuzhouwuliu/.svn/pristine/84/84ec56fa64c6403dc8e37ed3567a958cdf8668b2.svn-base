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
    
    <title>My JSP 'userCollectTest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${ctxStatic}/modules/cms/front/themes/weixin/lyb/jquery-1.7.1.min.js"></script>
	<script type="text/javascript">
		
		//新增线路
			function addLine(){
			$.ajax({
                url:"${ctx}/mobileDriveLine/addLine",
                type: "POST",
                data:{driverId:"1",fromArea:"武汉",toArea:"郑州",goTime:new Date(),publicStatus:"0",aviableDays:"30"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    
                    console.log(JSON.stringify(data));
                }
            });
		}
		//线路列表
			function driveLineList(){
			$.ajax({
                url:"${ctx}/mobileDriveLine/list",
                type: "POST",
                data:{pageNo:"0",driverId:"1"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
			//删除线路
			function deleteLine(id){
			$.ajax({
                url:"${ctx}/mobileDriveLine/deleteLine",
                type: "POST",
                data:{id:id},
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
    <input type="button" value="删除线路" onclick="deleteLine('1');">
    <input type="button" value="线路列表" onclick="driveLineList();">
    <input type="button" value="新增线路" onclick="addLine();">
  </body>
</html>
