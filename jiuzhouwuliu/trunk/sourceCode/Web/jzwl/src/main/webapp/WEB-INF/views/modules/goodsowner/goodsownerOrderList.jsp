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
<title>货主-订单明细</title>
<meta name="decorator" content="default" />
<script type="text/javascript" src="${ctxStatic}/modules/cms/front/themes/weixin/lyb/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${ctxStatic}/uploadfile/ajaxfileupload.js"></script>
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
		$("#driversTrueName").val("");
		$("#driversPhoneno").val("");
		$("#beginDate").val("");
		$("#endDate").val("");
	}
	//查询验证
	function checkForm() {
		if ($("#beginDate") != "" && ("#endDate") != "") {
			var startTime = $("#beginDate").val();
			var start = new Date(startTime.replace("-", "/").replace("-", "/"));
			var endTime = $("#endDate").val();
			var end = new Date(endTime.replace("-", "/").replace("-", "/"));
			if (end < start) {
				layer.alert("开始日期不能超过截止日期！", {
					shade : 0
				});
				return false;
			}
		} else {
			return true;
		}
	}
	//1.订单详情对话框
	function openDetailOrderForm(title, url, width, height) {
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

	function goodsownerDetailOrder(id) {
		var url = "${ctx}/users/orderManager/orderManagerDetail?id=" + id;
		openDetailOrderForm('订单详情', url, '800px', '500px');
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

.breadcrumb {
	padding: 0 0;
}

.title {
	width: 100%;
	height: auto;
	background-color: #fff;
	z-index: 9999;
}

.pagination {
	position: fixed;
	left: 0px;
	bottom: -30px;
	width: 100%;
	height: 50px;
	background-color: #FFFFFF;
	z-index: 9999;
}
#contentTable tr td{
	word-wrap:break-word;
	word-break:break-all;
}
</style>
</head>

<body>
	<div id="all">
		<div class="title">
			<form:form id="searchForm" modelAttribute="hotEvent" action="${ctx}/goodsowner/goodsowner/order" method="post" class="breadcrumb form-search">
				<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
				<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}" />
				<input type="text" id="id" name="id" value="${goodsowners.id}" style="display:none" />
				<ul class="ul-form">
					<li><label width="90px;">车主名称：</label> <input id="driversTrueName" name="driversTrueName" type="text" maxlength="100"
						class="input-medium input-short" value="${goodsowners.driversTrueName}" /></li>
					<li><label width="90px;">车主手机号：</label> <input id="driversPhoneno" name="driversPhoneno" type="text" maxlength="11"
						class="input-medium input-short" value="${goodsowners.driversPhoneno}" /></li>
					<li><label>日期范围起：</label> <input id="beginDate" name="beginDate" type="text" style="height:20px;" readonly="readonly" maxlength="20"
						class="input-mini Wdate" value="${goodsowners.beginDate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});" /></li>
					<li><label>日期范围止：</label> <input id="endDate" name="endDate" type="text" style="height:20px;" readonly="readonly" maxlength="20"
						class="input-mini Wdate" value="${goodsowners.endDate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});" /></li>
					<li><input id="btnSubmit" style="margin-left:10px;" class="btn btn-primary" type="submit" value="搜索" onclick="" />&nbsp;&nbsp; <input
						class="btn btn-primary" type="button" value="重置" onclick="resetContent();" /></li>
				</ul>
			</form:form>
		</div>
		<div class="contents">
			<table id="contentTable" class=" table table-bordered table-condensed " style="TABLE-LAYOUT:fixed;WORD-WRAP:nowrap;table-layout: fixed;">
				<thead class="fixed-thead">
					<tr>
						<th style="width:100px;">订单编号</th>
						<th style="width:80px;">金额</th>
						<th style="width:60px;">获取积分</th>
						<th style="width:80px;">经纪人名称</th>
						<th style="width:80px;">经纪人手机号</th>
						<th style="width:80px;">车主名称</th>
						<th style="width:80px;">车主手机号</th>
						<th style="width:60px;">货物类型</th>
						<th style="width:110px;">发货地</th>
						<th style="width:110px;">收货地</th>
						<th style="width:60px;">时间</th>
						<th style="width:80px;">订单详情</th>
					</tr>
				</thead>
				<tbody class="scroll-tbody">
					<c:if test="${not empty page.list }">
						<c:forEach items="${page.list}" var="s">
							<tr>
								<td>${s.orderNo}</td>
								<td>${fns:formatNumberToString(s.payMoney,'0.00')}</td>
								<td>${fns:formatNumberToString(s.integralScore,'0')}</td>
								<td>${s.agentsTrueName}</td>
								<td>${s.agentsPhoneno}</td>
								<td>${s.driversTrueName}</td>
								<td>${s.driversPhoneno}</td>
								<td>${s.goodsType}</td>
								<td>${s.shipperArea}</td>
								<td>${s.reciverArea}</td>
								<td><fmt:formatDate value="${s.createDate }" pattern="yyyy-MM-dd" /></td>
								<td><a href="javascript:void(0);" onclick="goodsownerDetailOrder('${s.goodsId}');">详情</a></td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
		<c:if test="${not empty page.list }">
			<div class="pagination" id="paginDiv">${page}</div>
		</c:if>
	</div>
</body>
<script>
	var wheight = $(window).height() - $(".title").height() - $("#header").height() - $(".pagination").height() - $("#footer").height() - 40;
	$(".contents").css("height", wheight);
</script>
</html>
