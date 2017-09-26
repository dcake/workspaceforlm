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
    
    <title>用户的公用功能接口</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${ctxStatic}/modules/cms/front/themes/weixin/lyb/jquery-1.7.1.min.js"></script>
	<script type="text/javascript">
		//根据收藏用户id查询收藏
		//id为用户id
		function updateUserGPSInfo(userid,gpsInfo,areaCode){
			$.ajax({
                url:"MobileCommonUser/setUserGpsInfo",
                type: "POST",
                data:{id:"0655a6ee1b9b4c6ca237b9d54513d79f",gpsInfo:"34.748004,113.700096",areaCode:"河南省,郑州市,中原区"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		function getPositionRefreshTime(){
			$.ajax({
                url:"MobileCommonUser/getPositionRefreshTime",
                type: "POST",
                data:{},
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
	</script>
  </head>
  
  <body>
    <input type="button" value="更新GPS信息" onclick="updateUserGPSInfo();">
    <input type="button" value="用户GPS信息自动更新时间频率（分钟）" onclick="getPositionRefreshTime();">
  </body>
</html>
