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
<title>订单管理</title>
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

	//单击选中行事件
	$(function() {
		function initTableCheckbox() {
			var $thr = $('table thead tr');
			//var $checkAllTh = $('<th><input type="checkbox" id="checkAll" name="checkAll" /></th>');  
			/*将全选/反选复选框添加到表头最前，即增加一列*/
			//$thr.prepend($checkAllTh);  
			/*“全选/反选”复选框*/
			var $checkAll = $thr.find('input');
			$checkAll.click(function(event) {
				/*将所有行的选中状态设成全选框的选中状态*/
				$tbr.find('input').prop('checked', $(this).prop('checked'));
				/*并调整所有选中行的CSS样式*/
				if ($(this).prop('checked')) {
					$tbr.find('input').parent().parent().addClass('warning');
				} else {
					$tbr.find('input').parent().parent().removeClass('warning');
				}
				/*阻止向上冒泡，以防再次触发点击操作*/
				event.stopPropagation();
			});
			/*点击全选框所在单元格时也触发全选框的点击操作*/
			//$checkAllTh.click(function(){  
			//$(this).find('input').click();  
			//});  
			var $tbr = $('table tbody tr');
			//var $checkItemTd = $('<td><input type="checkbox" name="checkItem" /></td>');  
			/*每一行都在最前面插入一个选中复选框的单元格*/
			//$tbr.prepend($checkItemTd);  
			/*点击每一行的选中复选框时*/
			$tbr.find('input').click(function(event) {
				/*调整选中行的CSS样式*/
				$(".warning").removeClass('warning');
				$(this).parent().parent().toggleClass('warning');
				/*如果已经被选中行的行数等于表格的数据行数，将全选框设为选中状态，否则设为未选中状态*/
				$checkAll.prop('checked', $tbr.find('input:checked').length == $tbr.length ? true : false);
				/*阻止向上冒泡，以防再次触发点击操作*/
				event.stopPropagation();
			});
			/*点击每一行时也触发该行的选中操作*/
			$tbr.click(function() {
				$(this).find('input').click();
			});
		}
		initTableCheckbox();
	});
	//重置
	function resetContent() {
		$("#orderNo").val("");
		$("#status").val("");
		$("#startDate").val("");
		$("#endDate").val("");
	}

	//点击审核
	function check(id) {
		var url = "${ctx}/users/orderManager/orderManagerDetail?id=" + id;
		openDialogForm('详情', url, '800px', '500px');
	}

	//打开弹出框
	function openDialogForm(title, url, width, height) {
		layer.open({
			type : 2,
			area : [ width, height ],
			title : title,
			maxmin : false, //开启最大化最小化按钮
			content : url,
			btn : ['取消'],
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
	<form:form id="searchForm" modelAttribute="hotEvent" action="${ctx}/users/orderManager/orderManagerList" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}" />
		<ul class="ul-form">
			<li><label>订单编号：</label>&nbsp;<input id="orderNo" name="orderNo" type="text" maxlength="100" class="input-medium input-short"
				value="${orderManager.orderNo }" style="height:20px;" /></li>
			<li><label>状态：</label> <select id="status" name="status" class="input-medium input-short">
					<option value="">请选择</option>
					<c:forEach items="${fns:getDictList('order_status')}" var="c">
						<option <c:if test="${c.value==orderManager.status }">selected</c:if> value="${c.value }">${c.label }</option>
					</c:forEach>
			</select></li>
			<li><label>时间起：</label> <input id="startDate" name="startDate" type="text" readonly="readonly" class="input-medium Wdate input-short" value="${orderManager.startDate }"
				style="height:20px;" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true});" /></li>
			<li><label>时间止：</label> <input id="endDate" name="endDate" type="text" readonly="readonly" class="input-medium Wdate input-short" value="${orderManager.endDate }"
				style="height:20px;" style="height:20px;" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true});" /></li>
			<li style="margin-left: 50px"><input id="btnSubmitSearch" style="margin-left:10px;" class="btn btn-primary" type="submit" value="搜索" />&nbsp;&nbsp;
				<input id="btnSubmitReset" class="btn btn-primary" type="button" value="重置" onclick="resetContent()" /></li>
		</ul>

	</form:form>
	<div>
		<table id="contentTable" class=" table table-striped table-bordered table-condensed"
			style="WORD-WRAP:nowrap;overflow-x:auto;">
			<thead class="fixed-thead">
				<tr>
					<th width="140px">订单编号</th>
					<th width="80px">金额</th>
					<th width="60px">货主</th>
					<th width="80px">车主</th>
					<th width="45px">经纪人</th>
					<th width="80px">货物类型</th>
					<th width="150px">发货地</th>
					<th width="150px">收货地</th>
					<th width="80px">时间</th>
					<th width="60px">状态</th>
					<th width="70px">是否交保险</th>
					<th width="60px">是否开票</th>
					<th width="50px">管理操作</th>
				</tr>
			</thead>
			<tbody class="scroll-tbody">
				<c:if test="${not empty page.list }">
					<c:forEach items="${page.list}" var="s">
						<tr>
							<td>${s.orderNo}</td>
							<td>${fns:formatNumberToString(s.money,'0.00')}</td>
							<td>${s.goodsowner}</td>
							<td>${s.driver}</td>
							<td>${s.agent}</td>
							<td>${s.goodsType }</td>
							<td>${s.shippeArea}</td>
							<td>${s.reciverArea}</td>
							<td><fmt:formatDate value='${s.createDate}' pattern='yyyy-MM-dd' /></td>
							<td>${s.status}</td>
							<td>${s.isHasInsurance}</td>
							<td>${s.isBill}</td>
							<td><a href="javascript:check('${s.id}')">详情</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<div class="pagination">${page}</div>
	</div>
</body>
</html>
