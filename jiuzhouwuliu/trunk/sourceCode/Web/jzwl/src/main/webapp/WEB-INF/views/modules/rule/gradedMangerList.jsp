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
<title>分级管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript" src="${ctxStatic}/modules/cms/front/themes/weixin/lyb/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${ctxStatic}/uploadfile/ajaxfileupload.js"></script>
<!-- 引入layer插件 -->
<link rel="stylesheet" href="${ctxStatic}/layer-v2.0/layer/skin/layer.css">
<script src="${ctxStatic}/layer-v2.0/layer/layer.js"></script>
<script src="${ctxStatic}/layer-v2.0/layer/laydate/laydate.js"></script>
<script type="text/javascript">
	function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		return false;
	}
	//清除表单
	function clearForm() {
		$("#userSort").val("");
		$("#truename").val("");
		$("#level").val("");
		getLevel();
	}
	//类型关联等级
	function getLevel() {
		var type = "";
		type = $("#userSort").val();
		if (type == "") {
			var options = "<option value=''>请选择</option><option value='A'>A</option><option value='B'>B</option><option value='C'>C</option></option><option value='1'>内部</option><option value='2'>外部</option>";
			$("#level").html(options);
		}
		if (type == "0") {//货主
			var options = "<option value=''>请选择</option><option value='A'>A</option><option value='B'>B</option><option value='C'>C</option>";
			$("#level").html(options);
		}
		if (type == "1") {//车主
			var options = "<option value=''>请选择</option><option value='1'>内部</option><option value='2'>外部</option>";
			$("#level").html(options);
		}
	}

	//打开弹出框
	function openDialogForm(title, url, width, height) {
		layer.open({
			type : 2,
			area : [ width, height ],
			title : title,
			maxmin : false, //开启最大化最小化按钮
			content : url,
			btn : [ '确定', '取消' ],
			yes : function(index, layero) {
				var body = layer.getChildFrame('body', index);
				var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
				iframeWin.contentWindow.doSubmit();
			},
			cancel : function(index) {
			}
		});
	}
	//详情
	function showInfo(id, userSort) {
		if (userSort == "0") {//货主
			var url = "${ctx}/rule/gradedManger/goodsInfo?id=" + id;
			openDialogViewForm('详情', url, '600px', '400px');
		}
		if (userSort == "1" || userSort == "2") {//车主
			var url = "${ctx}/rule/gradedManger/carInfo?id=" + id;
			openDialogViewForm('详情', url, '600px', '400px');

		}
	}
	//编辑
	function edit(id, userSort) {
		if (userSort == "0") {//货主
			var url = "${ctx}/rule/gradedManger/goodsForm?id=" + id;
			openDialogForm('编辑页面', url, '500px', '300px');
		}
		if (userSort == "1" || userSort == "2") {//车主
			var url = "${ctx}/rule/gradedManger/carForm?id=" + id;
			openDialogForm('编辑页面', url, '500px', '300px');
		}
	}
	function openDialogViewForm(title, url, width, height) {
		layer.open({
			type : 2,
			area : [ width, height ],
			title : title,
			maxmin : true, //开启最大化最小化按钮
			content : url,
			btn : [ '关闭' ],
			cancel : function(index) {
			}
		});
	}
</script>
<style>
ul {
	margin: 0;
	padding: 0;
}

li {
	list-style: none;
}

.ul-form {
	overflow: hidden;
	background: #f5f5f5;
	margin-bottom: 8px;
	padding: 8px 15px;
}

.ul-form li {
	float: left;
}

.ul-form li label {
	width: 100px;
	text-align: right;
}

select,textarea,input[type="password"],input[type="datetime"],input[type="datetime-local"],input[type="date"],input[type="month"],input[type="time"],input[type="week"],input[type="number"],input[type="email"],input[type="url"],input[type="search"],input[type="tel"],input[type="color"],.uneditable-input
	{
	height: 30px;
}

li.clearfix {
	float: none;
}
</style>
</head>

<body>
	<form:form id="searchForm" modelAttribute="user" action="${ctx}/rule/gradedManger/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}" />
		
		<label style="margin-left:50px">类型：</label>
		<select id="userSort" name="userSort" style="width: 177px" onchange="getLevel()">
			<option value="">请选择</option>
			<c:forEach items="${users_user_sort}" var="d">
				<c:if test="${d.value!='2'}">
					<option value="${d.value}" <c:if test="${d.value==user.userSort}">selected</c:if>>${d.label}</option>
				</c:if>
			</c:forEach>
		</select>
		<label>姓名 ：</label>
		<input type="text" id="truename" name="truename" htmlEscape="false" maxlength="64" style="width: 177px" value="${user.truename}" />
		<label>等级：</label>
		<select id="level" name="level" style="width: 177px">
			<option value="">请选择</option>
			<c:if test="${user.userSort!='1'}">
				<option value="A" <c:if test="${user.level=='A'}">selected</c:if>>A</option>
				<option value="B" <c:if test="${user.level=='B'}">selected</c:if>>B</option>
				<option value="C" <c:if test="${user.level=='C'}">selected</c:if>>C</option>
			</c:if>
			<c:if test="${user.userSort!='0'}">
				<option value="1" <c:if test="${user.level=='1'}">selected</c:if>>内部</option>
				<option value="2" <c:if test="${user.level=='2'}">selected</c:if>>外部</option>
			</c:if>
		</select>
		&nbsp;&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="搜索" />&nbsp;&nbsp;
		<input id="btnSubmit" class="btn btn-primary" type="button" onclick="clearForm()" value="重置" />

	</form:form>
	<div>
		<table id="contentTable" class=" table table-striped table-bordered table-condensed "
			style="TABLE-LAYOUT:fixed;WORD-WRAP:nowrap;table-layout: fixed;">
			<thead class="fixed-thead">
				<tr>
					<th width="15%">类型</th>
					<th width="15%">姓名</th>
					<th width="15%">手机号</th>
					<th width="15%">等级</th>
					<th width="15%">管理操作</th>
				</tr>
			</thead>
			<tbody class="scroll-tbody">
				<c:if test="${not empty page.list }">
					<c:forEach items="${page.list}" var="p">
						<tr>
							<td width="15%">${p.userSortStr}</td>
							<td width="15%">${p.truename}</td>
							<td width="15%">${p.phoneno}</td>
							<td width="15%"><c:if test="${p.level=='1'}">内部</c:if> <c:if test="${p.level=='2'}">外部</c:if> <c:if test="${p.level!='1'&&p.level!='2'}">${p.level}</c:if>
							</td>
							<td width="15%"><a href="javascript:void(0)" onclick="showInfo('${p.id}','${p.userSort}')">详情</a> <a href="javascript:void(0)"
								onclick="edit('${p.id}','${p.userSort}')">编辑</a></td>

						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<div class="pagination">${page}</div>
	</div>
</body>
</html>
