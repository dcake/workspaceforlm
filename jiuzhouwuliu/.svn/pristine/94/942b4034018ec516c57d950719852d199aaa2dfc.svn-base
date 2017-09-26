<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>结算</title>
<meta name="decorator" content="default" />
<!-- 引入layer插件 -->
<link rel="stylesheet" href="${ctxStatic}/layer-v2.0/layer/skin/layer.css">
<script src="${ctxStatic}/layer-v2.0/layer/layer.js"></script>
<script src="${ctxStatic}/layer-v2.0/layer/laydate/laydate.js"></script>
<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.11.1/lib/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.11.1/lib/jquery.form.js"></script>
<script type="text/javascript">
	//确定
	function doSubmit() {
		var form = $('#infoForm');
		//车队长id 
		var id = $("#id").val();
		if(id==""){
			layer.alert('车队长不能为空，请添加车队长！', {
				icon : 2,
				shade : 0
			});
			return;
		}
		//车队员id
		var ids=[];
		$("#memberInfo tr").each(function(){
			ids.push($(this).attr("id"));
		});
		var options = {
			url : '${ctx}/driver/driveFleetList/saveFleet',
			type : 'post',
			traditional: true, 
			data : {ids:ids.join(",")},
			success : function(data) {
				if (data.status) {
					layer.alert(data.msg, {
						icon : 1,
						shade : 0
					}, function(index) {
						parent.location.reload(); // 父页面刷新 
					});
				} else {
					layer.alert(data.msg, {
						icon : 2,
						shade : 0
					});
				}
			}
		};
		form.ajaxSubmit(options);
	}
	
	//根据车主id获取车队长信息
	function getDriverMaster(){
		var driverId=$("#masterId").val();
		if(isNaN(driverId)){
			layer.alert("请输入有效的车队长ID", {
				icon : 2,
				shade : 0
			});
			$("#masterId").val('');
			$("#masterId").focus();
			return;
		}else if(driverId==$("#userno").val()){
			layer.alert("该车队长已经添加。", {
				icon : 2,
				shade : 0
			});
			$("#masterId").val('');
			return;
		}else if($("#memberInfo tr[userno='"+driverId+"']").length>0){
			layer.alert("要添加的车队长不能为车队员。", {
				icon : 2,
				shade : 0
			});
			$("#masterId").val('');
			return;
		}
		var url='${ctx}/driver/driveFleetList/findDriverById';
		$.post(url,{userno:driverId},function(data){
			if(data){
				var obj=data.data;
				if(data.status){
					$("#id").val(obj.id);
					$("#userno").val(obj.userno);
					$("#username").val(obj.username);
					$("#phoneno").val(obj.phoneno);
					$("#truename").val(obj.truename);
					$("#cardno").val(obj.cardno);
					$("#isOrgDriver").val(obj.isOrgDriver);
					$("#masterId").val('');
				}else{
					layer.alert(data.msg, {
						icon : 2,
						shade : 0
					});
				}
			}
		});
	}
	//根据车主id获取车队员信息
	function getDriverMember(){
		var driverId=$("#memberId").val();
		if(isNaN(driverId)){
			layer.alert("请输入有效的车队员ID", {
				icon : 2,
				shade : 0
			});
			$("#memberId").val('');
			$("#memberId").focus();
			return;
		}else{
			if(driverId==$("#masterId").val()||driverId==$("#userno").val()){
				layer.alert("输入的ID不能为车队长ID", {
					icon : 2,
					shade : 0
				});
				$("#memberId").val('');
				return;
			}
			if($("#memberInfo tr[userno='"+driverId+"']").length>0){
				layer.alert("要添加的队员已经在队员列表中。", {
					icon : 2,
					shade : 0
				});
				$("#memberId").val('');
				return;
			}
		}
		var url='${ctx}/driver/driveFleetList/findDriverById';
		$.post(url,{userno:driverId},function(data){
			if(data){
				var obj=data.data;
				if(data.status){
					if($("#memberInfo tr[userno='"+obj.userno+"']").length>0){
						layer.alert("要添加的队员已经在队员列表中。", {
							icon : 2,
							shade : 0
						});
						$("#memberId").val('');
						return;
					}
					var strHtml="<tr id='"+obj.id+"' userno='"+obj.userno+"'>";
					strHtml+='<td class="tdLeft">队员：</td>';
					strHtml+='<td class="tdRight">'+obj.username+'</td>';
					strHtml+='<td class="tdLeft">姓名：</td>';
					strHtml+='<td class="tdRight">'+obj.truename+'</td>';
					strHtml+='<td class="tdLeft">手机号：</td>';
					strHtml+='<td class="tdRight">'+obj.phoneno+'</td>';
					strHtml+='<td class="tdLeft">等级：</td>';
					strHtml+='<td class="tdRight">'+obj.isOrgDriver+'</td>';
					strHtml+='<td><a href="javascript:removeTr(\''+obj.id+'\')">删除</a></td>';
					strHtml+="</tr>";
					$("#memberInfo").append(strHtml);
					$("#memberId").val('');
				}else{
					layer.alert(data.msg, {
						icon : 2,
						shade : 0
					});
				}
			}
		});
	}
	//删除表格中的车队员
	
	function removeTr(id){
		layer.confirm('确认删除吗？', function (index) {
			$("#memberInfo tr[id='"+id+"']").remove();
			layer.close(index);
        });
	}
</script>
<style type="text/css">
/* select, textarea, input[type="text"], input[type="password"], input[type="datetime"], input[type="datetime-local"], input[type="date"], input[type="month"], input[type="time"], input[type="week"], input[type="number"], input[type="email"], input[type="url"], input[type="search"], input[type="tel"], input[type="color"], .uneditable-input{
			height: 30px;
		} */
.form-search .ul-form li label {
	width: 120px;
	text-align: right;
}

table .tdLeft {
	width:10%;
	text-align: right;
}
table .tdRight {
	width:13%;
	text-align: left;
}
</style>
</head>

<body>

	<div style="text-align: center">

		<!-- Tab panes -->
		<div class="tab-content">
			<div class="tab-pane active" id="home">
				<form id="infoForm" method='post' class="breadcrumb form-search" style="background-color: white;" enctype="multipart/form-data">
					<input type="text" id="userno" name="userno" value="${user.userno}" style="display:none" />
					<input type="text" id="id" name="id" value="${user.id}" style="display:none" />
					<ul class="ul-form">
						<li>
							<h5 style="folat:left;padding-top:15px;">车队长信息</h5>
						</li>
						<li class="clearfix" style="margin-bottom:5px;">
							<div style="folat:right;text-align:right;">
								<input id="masterId" type="text" value="" placeHolder="请输入车队长ID" maxlength="100" class="input-medium" style="width:145px"/>&nbsp;&nbsp;
								<input  class="btn btn-primary" type="button" value="搜索" onclick="getDriverMaster();"/>
							</div>
						</li>
						<li >
							<label>车队长：</label> <input type="text" name="username" id="username" value="${user.username}" class="input-medium" style="width:163px" readonly="readonly" /></li>
						<li><label>手机：</label> <input id="phoneno" type="text" value="${user.phoneno}" class="input-medium" style="width:163px" readonly="readonly" /></li>
						<li><label>姓名：</label> <input id="truename"  type="text" value="${user.truename}" class="input-medium" style="width:163px" readonly="readonly" /></li>
						<li><label>身份证号：</label> <input id="cardno"  type="text" value="${user.cardno}" class="input-medium" style="width:163px" readonly="readonly" /></li>
						<li class="clearfix"></li>
						<li><label>用户等级：</label> <input id="isOrgDriver" type="text" readonly="readonly" class="input-medium" tyle="width:163px" value="${user.isOrgDriver}" /></li>
						<li class="clearfix"></li>
						<li class="clearfix"></li>
						<li>
							<h5 style="folat:left;padding-top:15px;">车队员信息</h5>
						</li>
						<li class="clearfix" style="margin-bottom:5px;">
							<div style="folat:right;text-align:right;">
								<input type="text" id="memberId" value="" placeHolder="请输入车队员ID" maxlength="100" class="input-medium" style="width:145px"/>&nbsp;&nbsp;
								<input  class="btn btn-primary" id="searchMember" type="button" value="搜索" onclick="getDriverMember();"/>
							</div>
						</li>
					</ul>
					<table id="memberInfo" style="margin-top:5px;width:100%;">
						
							<%--
							<tr>
								<td class="tdLeft">队员1：</td>
								<td class="tdRight">啊啊啊</td>
								<td class="tdLeft">姓名：</td>
								<td class="tdRight">啊啊啊</td>
								<td class="tdLeft">队员1：</td>
								<td class="tdRight">啊啊啊</td>
								<td class="tdLeft">姓名：</td>
								<td class="tdRight">啊啊啊</td>
								<td><a>删除</a></td>
							</tr>
							 --%>							
							
						
					</table>
				</form>
			</div>

		</div>
	</div>

</body>
</html>
