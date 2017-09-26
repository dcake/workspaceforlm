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
    
    <title>车辆管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${ctxStatic}/modules/cms/front/themes/weixin/lyb/jquery-1.7.1.min.js"></script>
	<script type="text/javascript">
		
		//新增车辆
			function addCar(){
			$.ajax({
                url:"${ctx}/mobileDriversManager/addCar",
                type: "POST",
                data:{userid:"1",truckNo:"豫P39964",truckType:"7",truckWidth:"3.2",truckHeight:"2.8",truckLength:"18",truckMaxwight:"50t"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    
                    console.log(JSON.stringify(data));
                }
            });
		}
		//车辆列表
			function driversList(userid){
			$.ajax({
                url:"${ctx}/mobileDriversManager/list",
                type: "POST",
                data:{pageNo:"0",userid:userid},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
			//邀请队员列表(根据id查找)
			function invite(id){
			$.ajax({
                url:"${ctx}/mobileDriversManager/invite",
                type: "POST",
                data:{pageNo:"0",userid:id},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    
                    console.log(JSON.stringify(data));
                }
            });
		}
			//退出车队
			function exitDriveFleet(userid){
				$.ajax({
	                url:"${ctx}/mobileDriversManager/exitDriveFleet",
	                type: "POST",
	                data:{userid:userid},
	                dataType:"json",
	                success: function(data) {
	                    alert(JSON.stringify(data));
	                    console.log(JSON.stringify(data));
	                }
	            });
			}
			//收藏或取消
			function collectOrCancel(){
				$.ajax({
	                url:"${ctx}/mobileShip/collectOrCancel",
	                type: "POST",
	                data:{agentId:"3b4252181e3f4772b83b3662dba90e96",userId:"1",type:"1"},
	                dataType:"json",
	                success: function(data) {
	                    alert(JSON.stringify(data));
	                    console.log(JSON.stringify(data));
	                }
	            });
			}
			//转让身份车队人员列表
			function changeBodyList(driveFleetId){
				$.ajax({
	                url:"${ctx}/mobileDriversManager/changeBodyList",
	                type: "POST",
	                data:{pageNo:"0",driveFleetId:driveFleetId},
	                dataType:"json",
	                success: function(data) {
	                    alert(JSON.stringify(data));
	                    console.log(JSON.stringify(data));
	                }
	            });
			}
			//转让身份
			function changeBody(id){
				
				$.ajax({
	                url:"${ctx}/mobileDriversManager/changeBody",
	                type: "POST",
	                data:{id:id},
	                dataType:"json",
	                success: function(data) {
	                    alert(JSON.stringify(data));
	                    console.log(JSON.stringify(data));
	                }
	            });
			}
			//根据车主ID查询车主详情
			function driverDetail(){
				$.ajax({
	                url:"${ctx}/mobileShip/lookDriverDetail",
	                type: "POST",
	                data:{driverUserId:"1",userId:"0bde016310cb44bb8247900bb6cf5056"},
	                dataType:"json",
	                success: function(data) {
	                    alert(JSON.stringify(data));
	                    console.log(JSON.stringify(data));
	                }
	            });
			}
			//车主评价列表
			function findDriverEvaluationList(){
				$.ajax({
	                url:"${ctx}/mobileBid/findDriverEvaluationList",
	                type: "POST",
	                data:{currentPage:"0",driversId:"03884751fcb84849bf3a8e5709240e07"},
	                dataType:"json",
	                success: function(data) {
	                    alert(JSON.stringify(data));
	                    console.log(JSON.stringify(data));
	                }
	            });
			}
			
			//车主历史路线列表
			function findDriveLineList(){
				$.ajax({
	                url:"${ctx}/mobileBid/findDriveLineList",
	                type: "POST",
	                data:{currentPage:"0",driversId:"03884751fcb84849bf3a8e5709240e07"},
	                dataType:"json",
	                success: function(data) {
	                    alert(JSON.stringify(data));
	                    console.log(JSON.stringify(data));
	                }
	            });
			}
			//线路记录
			function driveLine(driverId){
				$.ajax({
	                url:"${ctx}/mobileDriversManager/driveLine",
	                type: "POST",
	                data:{pageNo:"0",driverId:driverId},
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
    <input type="button" value="车辆管理" onclick="driversList('2');">
    <input type="button" value="新增车辆" onclick="addCar();">
    <input type="button" value="邀请列表" onclick="invite('');">
    <input type="button" value="退出车队" onclick="exitDriveFleet('1');">
    <input type="button" value="取消收藏" onclick="backCollect('1');">
    <input type="button" value="车主详情" onclick="driverDetail()"> <!-- 车主详情可调货主端--竞价--查看资料（个人） -->
 	<input type="button" value="车主评价列表" onclick="findDriverEvaluationList();">
    <input type="button" value="车主历史路线" onclick="findDriveLineList();">   
	<input type="button" value="转让身份列表" onclick="changeBodyList('c0bf311a352e45f89f67c1cc63acee43');">
    <input type="button" value="转让身份" onclick="changeBody('1');">
    <input type="button" value="线路记录" onclick="driveLine('1');">
  </body>
</html>
