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
<title>查看申述详情</title>
<meta name="decorator" content="default" />
<link rel="stylesheet" href="${ctxStatic}/image-viewer/css/viewer.min.css">
<link rel="icon" href="${ctxStatic}/images/bttx.ico" type="image/x-icon" />
<!-- 引入layer插件 -->
<link rel="stylesheet" href="${ctxStatic}/layer-v2.0/layer/skin/layer.css">
<script src="${ctxStatic}/layer-v2.0/layer/layer.js"></script>
<script src="${ctxStatic}/layer-v2.0/layer/laydate/laydate.js"></script>
<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.11.1/lib/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.11.1/lib/jquery.form.js"></script>
<script type="text/javascript">
	function doSubmit() {
		var form = $('#infoForm');
		var revertContent = $('#revert').val().trim();
		if (!revertContent) {
			layer.alert("请输入回复内容");
			return;
		}
		if (revertContent.length > 50) {
			layer.alert("回复内容长度不能大于50字");
			return;
		}
		var options = {
			url : '${ctx}/complaints/appeal/reply',
			type : 'post',
			success : function(data) {
				console.log(data)
				if (data.status) {
					layer.alert("保存成功!", {
						icon : 1,
						shade : 0
					}, function(index) {
						parent.location.reload(); // 父页面刷新  
					});
				} else {
					layer.alert("保存失败!", {
						icon : 2,
						shade : 0
					});
				}
			}
		};
		form.ajaxSubmit(options);
	}

	function setIframeWidth() {
		$("iframe").each(function() {
			$(this).width("100%");
		});
	}
</script>
<style type="text/css">
.img {
	width: 100px;
	height: 100px;
	float: left;
	margin-right: 5px;;
	cursor: pointer;
}

input,textarea {
	disabled: disabled
}
</style>
</head>

<body>
	<div style="text-align: center">
		<form id="infoForm" method='post' class="breadcrumb form-search" style="background-color: white;margin-top:20px;" enctype="multipart/form-data">
			<input type="text" id="id" name="id" value="${complainRecord.id}" style="display:none" />
			<ul id="dataShowUl" class="ul-form">
				<li><label>用户类型：</label> <input type="text" id="title" value="${complainRecord.userSortStr}" maxlength="100" class="input-medium"
					style="width:163px" readonly="readonly" /></li>
				<li><label>用户名：</label> <input type="text" id="title" value="${complainRecord.truename}" maxlength="100" class="input-medium"
					style="width:163px" readonly="readonly" /></li>
				<li><label>订单编号：</label> <input type="text" value="${complainRecord.driveOrderId}" class="input-medium" style="width:163px"
					readonly="readonly" /></li>

				<li><label>申述时间：</label> <input type="text" value="<fmt:formatDate value="${complainRecord.complainTime}" pattern="yyyy-MM-dd"/>"
					class="input-medium" style="width:163px" readonly="readonly" /></li>
				<li class="clearfix"></li>
				<li style="height:60px;padding-top:8px;"><label>申述原因：</label> <textarea cols='8' name="complainReason" id="complainReason" readonly
						style="width:500px;height:50px;">${complainRecord.complainReason}</textarea></li>
				<li class="clearfix"></li>
				<li style="height:60px;padding-top:8px;"><label>备注：</label> <textarea cols='8' name="remarks" id="remarks" readonly
						style="width:500px;height:50px;">${complainRecord.remarks}</textarea></li>
				<li class="clearfix"></li>
				<c:if
					test="${not empty complainRecord.img1||not empty complainRecord.img2||not empty complainRecord.img3||not empty complainRecord.img4||not empty complainRecord.img5}">
					<li style="width:100%; margin-top:10px;overflow:hidden;height:100px;"><label style="float:left">图片：</label> <c:if
							test="${not empty complainRecord.img1}">
							<img alt="" class="img" data-original="<%=basePath%>${complainRecord.img1}" src="<%=basePath%>${complainRecord.img1}" />
						</c:if> <c:if test="${not empty complainRecord.img2}">
							<img alt="" class="img" data-original="<%=basePath%>${complainRecord.img2}" src="<%=basePath%>${complainRecord.img2}" />
						</c:if> <c:if test="${not empty complainRecord.img3}">
							<img alt="" class="img" data-original="<%=basePath%>${complainRecord.img3}" src="<%=basePath%>${complainRecord.img3}" />
						</c:if> <c:if test="${not empty complainRecord.img4}">
							<img alt="" class="img" data-original="<%=basePath%>${complainRecord.img4}" src="<%=basePath%>${complainRecord.img4}" />
						</c:if> <c:if test="${not empty complainRecord.img5}">
							<img alt="" class="img" data-original="<%=basePath%>${complainRecord.img4}" src="<%=basePath%>${complainRecord.img5}" />
						</c:if></li>
				</c:if>
				<li class="clearfix"></li>
				<li style="height:100px;width:100%; margin-top:10px;"><label style="float:left">回复：</label> <textarea cols='8' name="replyContent"
						id="revert" style="width:505px;height:50px;float:left" placeholder="长度不大于50字">${complainRecord.replyContent}</textarea></li>
			</ul>
		</form>
	</div>
	<script type="text/javascript" src="${ctxStatic}/image-viewer/js/viewer.min.js"></script>
	<script>
		var viewer = new Viewer(document.getElementById('dataShowUl'), {
			url : 'data-original'
		});
	</script>
</body>
</html>
