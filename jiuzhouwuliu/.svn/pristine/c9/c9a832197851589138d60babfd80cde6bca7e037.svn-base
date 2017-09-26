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
	width: 10%;
	text-align: right;
}

table .tdRight {
	width: 13%;
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
					<input type="text" id="id" name="id" value="${drivers.id}" style="display:none" /> <input type="text" id="driveFleetId" name="driveFleetId"
						value="${drivers.driveFleetId}" style="display:none" />
					<ul class="ul-form">
						<li>
							<h5 style="folat:left;padding-top:15px;">车队长信息</h5>
						</li>
						<li class="clearfix" style="margin-bottom:5px;"></li>
						<li><label>车队长：</label> <input type="text" name="username" id="username" value="${drivers.username}" class="input-medium"
							style="width:163px" readonly="readonly" /></li>
						<li><label>手机：</label> <input id="phoneno" type="text" value="${drivers.phoneno}" class="input-medium" style="width:163px"
							readonly="readonly" /></li>
						<li><label>姓名：</label> <input id="truename" type="text" value="${drivers.truename}" class="input-medium" style="width:163px"
							readonly="readonly" /></li>
						<li><label>身份证号：</label> <input id="cardno" type="text" value="${drivers.cardno}" class="input-medium" style="width:163px"
							readonly="readonly" /></li>
						<li class="clearfix"></li>
						<li><label>用户等级：</label> <input id="isOrgDriver" type="text" readonly="readonly" class="input-medium" tyle="width:163px"
							value="${drivers.isOrgDriver}" /></li>
						<li class="clearfix"></li>
						<li class="clearfix"></li>
						<li>
							<h5 style="folat:left;padding-top:15px;">车队员信息</h5>
						</li>
						<li class="clearfix" style="margin-bottom:5px;"></li>
					</ul>
					<table id="memberInfo" style="margin-top:5px;width:100%;">
						<c:forEach items="${ds }" var="d">
							<tr data="${d.id}">
								<td class="tdLeft">队员：</td>
								<td class="tdRight">${d.username}</td>
								<td class="tdLeft">姓名：</td>
								<td class="tdRight">${d.truename}</td>
								<td class="tdLeft">手机号：</td>
								<td class="tdRight">${d.phoneno}</td>
								<td class="tdLeft">等级：</td>
								<td class="tdRight">${d.isOrgDriver}</td>
							</tr>
						</c:forEach>
					</table>
				</form>
			</div>

		</div>
	</div>

</body>
</html>
