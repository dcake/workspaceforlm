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
<title>车主管理</title>
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
	//重填
	function resetContent() {
		$("#truename").val("");
		$("#phoneno").val("");
		$("#examineStatus").val("");
		$("#level").val("");
	}
	//监听回车事件
	document.onkeydown = function(e) {
		if (!e) {
			e = window.event;
		}
		if ((e.keyCode || e.which) == 13) {
			doSelect();
		}
	}
	//1.车主详情对话框
	function openDialogViewForm(title, url, width, height) {
		layer.open({
			type : 2,
			area : [ width, height ],
			title : title,
			maxmin : false, //开启最大化最小化按钮
			content : url,
			/* 	  btn: ['确定','取消'],
				   yes: function(index, layero){
				    var body = layer.getChildFrame('body', index);
				    var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
				    iframeWin.contentWindow.doSubmit();
				},
				   cancel: function(index){}
				}); 	
			} */
			btn : [ '关闭' ],
			cancel : function(index) {
			}
		});
	}
	//1.车主详情
	function viewInfo(id) {
		var url = "${ctx}/driver/driverList/info?id=" + id;
		openDialogViewForm('车主详情', url, '700px', '500px');
	}
	//2.打开认证信息对话框-----添加信息
	function openApproveInfoForm(title, url, width, height) {
		layer.open({
			type : 2,
			area : [ width, height ],
			title : title,
			maxmin : true, //开启最大化最小化按钮
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
	//2.认证信息------添加信息
	function add() {
		var url = "${ctx}/driver/driverList/add";
		openApproveInfoForm('添加车主', url, '700px', '500px');
	}
	//3.订单明细
	function order(id) {
		window.location.href = "${ctx}/driver/driverList/order?driversId=" + id;
	}

	function keyupInput(obj) {
		if (event.keyCode == 37 || event.keyCode == 39) {//左 、右键

		} else {
			obj.value = obj.value.replace(/[^0-9]/g, '');
		}
	}

	//锁定
	function lock(id) {
		layer.confirm('确定要锁定？', {
			btn : [ '确定', '取消' ]
		//按钮
		}, function() {
			$.ajax({
				url : "${ctx}/driver/driverList/lock",
				type : "post",
				data : {
					id : id
				},
				success : function(data) {
					if (data.status) {
						layer.alert("锁定成功");
						window.location.reload();
					}
					//parent.location.reload(); // 父页面刷新 
				}
			});
		});
	}

	//锁定
	function lock1(id) {
		layer.confirm('确定要解锁？', {
			btn : [ '确定', '取消' ]
		//按钮
		}, function() {
			$.ajax({
				url : "${ctx}/driver/driverList/clear",
				type : "post",
				data : {
					id : id
				},
				success : function(data) {
					if (data.status) {
						layer.alert("解锁成功");
						window.location.reload();
					}
					//parent.location.reload(); // 父页面刷新 
				}
			});
		});
	}

	//4.打开认证信息对话框-----添加信息
	function openInfoForm(title, url, width, height) {
		layer.open({
			type : 2,
			area : [ width, height ],
			title : title,
			maxmin : true, //开启最大化最小化按钮
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
	//4.认证信息------编辑信息
	function edit(id) {
		var url = "${ctx}/driver/driverList/edit?id=" + id;
		openInfoForm('修改车主', url, '700px', '500px');
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

select,textarea,input[type="text"],input[type="password"],input[type="datetime"],input[type="datetime-local"],input[type="date"],input[type="month"],input[type="time"],input[type="week"],input[type="number"],input[type="email"],input[type="url"],input[type="search"],input[type="tel"],input[type="color"],.uneditable-input
	{
	height: 30px;
}

li.clearfix {
	float: none;
}
td {
	word-wrap: break-word;
	word-break: break-all;
}
</style>
</head>

<body>
	<form:form id="searchForm" modelAttribute="hotEvent" action="${ctx}/driver/driverList/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}" />
		<ul class="ul-form">
			<li><label width="90px;">姓名：</label> <input id=truename name="truename" type="text" maxlength="100" style="height:20px;"
				class="input-medium input-short" value="${drivers.truename}" /></li>
			<li><label width="90px;">手机号：</label> <input id="phoneno" name="phoneno" type="text" maxlength="11" style="height:20px;"
				class="input-medium input-short" value="${drivers.phoneno}" /></li>
			<li>
			<li><label>审核状态：</label> <select id="examineStatus" name="examineStatus" class="input-medium" style="width: 177px;">
					<option value="">不限</option>
					<c:forEach items="${driverStatus}" var="t">
						<option value="${t.value}" <c:if test="${t.value==drivers.examineStatus}">selected</c:if>>${t.label}</option>
					</c:forEach>
			</select></li>
			<li><label>等级：</label> <select id="level" name="level" class="input-medium" style="width: 177px;">
					<option value="">不限</option>
					<c:forEach items="${carLevel}" var="t">
						<option value="${t.value}" <c:if test="${t.value==drivers.level}">selected</c:if>>${t.label}</option>
					</c:forEach>
			</select></li>
			<li><input id="btnSubmit" class="btn btn-primary" type="submit" value="搜索" onclick="" style="margin-left:50px;">&nbsp;&nbsp; <input
				class="btn btn-primary" type="button" value="重置" onclick="resetContent();" /></li>
			<li class="clearfix"></li>
		</ul>

	</form:form>
	<div class="" style="background-color: #fff; margin-left:20px;margin-bottom:8px; ">
		<input id="btnSubmit" class="btn btn-primary" type="submit" value="添加" onclick="add()" />
	</div>
	<div>
		<table id="contentTable" class=" table table-striped table-bordered table-condensed "
			style="TABLE-LAYOUT:fixed;WORD-WRAP:nowrap;table-layout: fixed;">
			<thead class="fixed-thead">
				<tr>
					<th style="width:60px;">姓名</th>
					<th style="width:70px;">手机号</th>
					<th style="width:60px;">昵称</th>
					<th style="width:60px;">ID</th>
					<th style="width:70px;">注册时间</th>
					<th style="width:30px;">状态</th>
					<th style="width:80px;">审核状态</th>
					<th style="width:70px;">审核意见</th>
					<th style="width:50px;">等级</th>
					<th style="width:50px;">所属车队</th>
					<th style="width:100px;">管理操作</th>
				</tr>
			</thead>
			<tbody class="scroll-tbody">
				<c:if test="${not empty page.list }">
					<c:forEach items="${page.list}" var="s">
						<tr>
							<td>${s.truename}</td>
							<td>${s.phoneno}</td>
							<td>${s.username}</td>
							<td>${s.userno}</td>
							<td><fmt:formatDate value='${s.createDate}' pattern='yyyy-MM-dd' /></td>
							<td><c:if test="${s.status=='0'}">正常</c:if> <c:if test="${s.status=='1'}">锁定</c:if></td>
							<td><c:if test="${s.examineStatus=='0'}">未审核 </c:if> <c:if test="${s.examineStatus=='1'}">已审核</c:if> <c:if test="${s.examineStatus=='2'}">审核未通过</c:if>
							</td>
							<td>${s.examineRemark}</td>
							<td>
								${ fns:getDictLabel (s.level, "car_level", s.level)}
							</td>
							<td>${s.fleetName}</td>
							<td><a href="javascript:void(0);" onclick="viewInfo('${s.id}');">详情</a> <a href="javascript:void(0);" onclick="edit('${s.id}');">编辑</a>
								<c:if test="${s.status=='0'}">
									<a href="javascript:void(0);" onclick="lock('${s.userid}');">锁定</a>
								</c:if> <c:if test="${s.status=='1'}">
									<a href="javascript:void(0);" onclick="lock1('${s.userid}');">解锁</a>
								</c:if> <a href="javascript:void(0);" onclick="order('${s.id}');">订单明细</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<div class="pagination">${page}</div>
	</div>
</body>
</html>
