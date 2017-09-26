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
		//发货列表
		function findShipList(){
			$.ajax({
                type: "POST",
                url:"${ctx}/mobileShip/findShipList",
                data:{currentPage:"0",userId:"1"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//删除发货列表
		function delGoodsownerOrder(){
			$.ajax({
                type: "POST",
                url:"${ctx}/mobileShip/delGoodsownerOrder",
                data:{goodsownerOrderId:"3"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//根据货物订单ID查询货物详情
		function findGoodsByOrderId(){
			$.ajax({
                type: "POST",
                url:"${ctx}/mobileShip/findGoodsByOrderId",
                data:{goodsownerOrderId:"1"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//添加或修改货物（注意：修改时参数多传一个id(代表goodsId)）
		function addGoods(){
			var obj = new Object();  
				obj.shipperName = "测试1";  
				obj.shipperTel = "18790751103";
				obj.shipperArea = "河南省安阳市安阳县"; 
				obj.userId = "e07a34e723ec4333babf6db66dbc3ebc"; 
			$.ajax({
                type: "POST",
                url:"${ctx}/mobileShip/addGoods",
                data:obj,
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//发货人列表
		function shipperList(){
			$.ajax({
                url:"${ctx}/mobileShip/findShipperList",
                type: "POST",
                data:{userId:"e07a34e723ec4333babf6db66dbc3ebc",shipperName:"测试1"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//根据类型查询字典列表
		function dictList(){
			$.ajax({
                url:"${ctx}/mobileShip/findDictList",
                type: "POST",
                data:{type:"truck_width"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//省市县列表查询
		//type(省-2，市-3，区-4)
		function areaList(){
			$.ajax({
                url:"${ctx}/mobileShip/findGeoInfoList",
                type: "POST",
                data:{type:"2"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//保险公司列表
		function companyList(){
			$.ajax({
                url:"${ctx}/mobileShip/findInsCompanyList",
                type: "POST",
                data:{},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//发布竞价
		function publishBid(){
			var obj = new Object();  
			obj.id = "b8d9e750c211413da171ea66bd7cb637";
			obj.priceMin = "1000";
			obj.priceMax = "2000";
			obj.userId="";//当前用户ID
			$.ajax({
                url:"${ctx}/mobileShip/publishBid",
                type: "POST",
                data:obj,
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//经纪人列表
		function agentsList(){
			$.ajax({
                url:"${ctx}/mobileShip/findAgentsList",
                type: "POST",
                data:{currentPage:"0",userId:"1"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//根据经纪人ID查询经纪人详情
		function agentsDetail(){
			$.ajax({
                url:"${ctx}/mobileShip/lookAgentDetail",
                type: "POST",
                data:{agentId:"3b4252181e3f4772b83b3662dba90e96",userId:"1"},
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
                data:{jingJiaRenId:"1",userId:"0bde016310cb44bb8247900bb6cf5056"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		
		//收藏或取消 type用于判断是车主还是经纪人（1车主、2经纪人）
		function collectOrCancel(){
			$.ajax({
                url:"${ctx}/mobileShip/collectOrCancel",
                type: "POST",
                data:{agentId:"3b4252181e3f4772b83b3662dba90e96",userId:"1",type:"2"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//经纪人评价列表
		function findEvaluationList(){
			$.ajax({
                url:"${ctx}/mobileShip/findEvaluationList",
                type: "POST",
                data:{currentPage:"0",agentId:"3b4252181e3f4772b83b3662dba90e96"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//确认委托
		function confirmConsign(){
			$.ajax({
                url:"${ctx}/mobileShip/confirmConsign",
                type: "POST",
                data:{agentId:"3b4252181e3f4772b83b3662dba90e96",goodsId:"5a5f9dc0b2a4483f9d9b61694299e052",goodsownerOrderid:"b8d9e750c211413da171ea66bd7cb637",userId:"1"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//竞价列表
		function bidList(){
			$.ajax({
                url:"${ctx}/mobileBid/findBidList",
                type: "POST",
                data:{currentPage:"0",userId:"e07a34e723ec4333babf6db66dbc3ebc"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//查看竞价或查看经纪人
		//type 用于判断是查看竞价还是查看经纪人（0-查看竞价，1-查看经纪人）
		//userId 当前用户ID
		function lookBidOrAgent(){
			$.ajax({
                url:"${ctx}/mobileBid/lookBidOrAgent",
                type: "POST",
                data:{goodsownerOrderId:"b8d9e750c211413da171ea66bd7cb637",userId:"e07a34e723ec4333babf6db66dbc3ebc",type:"0"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//查看竞价或查看经纪人中的货物详情
		function lookGoodsDetail(){
			$.ajax({
                url:"${ctx}/mobileBid/lookGoodsDetail",
                type: "POST",
                data:{goodsownerOrderId:"b8d9e750c211413da171ea66bd7cb637"},
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
		//取消委托
		function cancleWeiTuo(){
			$.ajax({
                url:"${ctx}/mobileBid/cancleWeiTuo",
                type: "POST",
                data:{goodsownerOrderId:"b8d9e750c211413da171ea66bd7cb637",userId:"1"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//取消竞价
		function cancleJingJia(){
			$.ajax({
                url:"${ctx}/mobileBid/cancleJingJia",
                type: "POST",
                data:{goodsownerOrderId:"b8d9e750c211413da171ea66bd7cb637",userId:"1"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//确认或取消竞价人（type 用于判断是确认还是取消（1-确认，0-取消））
		function chooseOrCancleJingJiaRen(){
			$.ajax({
                url:"${ctx}/mobileBid/chooseOrCancleJingJiaRen",
                type: "POST",
                data:{goodsownerOrderId:"1",jingJiaRenId:"6e6a18ba9c984153b00347a1a3376a0d",type:"1"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//确认交易
		function confrimTransaction(){
			var obj = new Object();  
			obj.userId = "e07a34e723ec4333babf6db66dbc3ebc";//当前用户ID
			obj.type="1";//type 用于判断是查看竞价还是查看经纪人（0-查看竞价，1-查看经纪人）
			obj.jingJiaRenId="";//竞价人ID
			$.ajax({
                url:"${ctx}/mobileBid/confrimTransaction",
                type: "POST",
                data:obj,
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//积分列表
		function findInseranceList(){
			$.ajax({
                url:"${ctx}/mobileIntegral/findInseranceList",
                type: "POST",
                data:{currentPage:"0",userId:"1"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//添加积分
		//type 用于判断添加积分的时机（0-货主注册，1-车主注册，2-经纪人注册，3-每天登录，4-完善用户信息，5-评价订单，6-完成一次交易）
		function insertIntegral(){
			$.ajax({
                url:"${ctx}/mobileIntegral/insertIntegral",
                type: "POST",
                data:{type:"0",userId:"1"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		
		//路线记录列表
		function findLineList(){
			$.ajax({
                url:"${ctx}/moblieLineRecord/findLineList",
                type: "POST",
                data:{currentPage:"0",userId:"e07a34e723ec4333babf6db66dbc3ebc"},
                dataType:"json",
                success: function(data) {
                    alert(JSON.stringify(data));
                    console.log(JSON.stringify(data));
                }
            });
		}
		//最近联系人列表
		function findRecentPersonList(){
			$.ajax({
                url:"${ctx}/mobileRecentPerson/findRecentPersonList",
                type: "POST",
                data:{currentPage:"0",userId:"1"},
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
   <input type="button" value="发货列表" onclick="findShipList();">
   <input type="button" value="删除发货货物" onclick="delGoodsownerOrder();">
   <input type="button" value="根据货物订单ID查看货物详情" onclick="findGoodsByOrderId();">
   <input type="button" value="添加货物" onclick="addGoods();">
   <input type="button" value="发货人列表" onclick="shipperList();">
   <input type="button" value="字典列表" onclick="dictList();">
   <input type="button" value="省市县列表" onclick="areaList();">
   <input type="button" value="保险公司列表" onclick="companyList();">
   <input type="button" value="发布竞价" onclick="publishBid();">
   <input type="button" value="经纪人列表" onclick="agentsList();">
   <input type="button" value="经纪人详情" onclick="agentsDetail();">
   <input type="button" value="车主详情" onclick="driverDetail();">
   <input type="button" value="收藏或取消" onclick="collectOrCancel();">
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
   <input type="button" value="最近联系人列表" onclick="findRecentPersonList();">
  </body>
</html>
