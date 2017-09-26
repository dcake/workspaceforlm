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
<title>查看投诉建议详情</title>
<meta name="decorator" content="default" />
<link rel="icon" href="${ctxStatic}/images/bttx.ico" type="image/x-icon" />
<link rel="stylesheet" href="${ctxStatic}/image-viewer/css/viewer.min.css">
<!-- 引入layer插件 -->
<link rel="stylesheet" href="${ctxStatic}/layer-v2.0/layer/skin/layer.css">
<script src="${ctxStatic}/layer-v2.0/layer/layer.js"></script>
<script src="${ctxStatic}/layer-v2.0/layer/laydate/laydate.js"></script>
<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.11.1/lib/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.11.1/lib/jquery.form.js"></script>
<script type="text/javascript">
	function doSubmit(){
		var form = $('#infoForm');
		var revertContent = $('#revert').val().trim();
	  	if(!revertContent){
			layer.alert("请输入回复内容");
		  	return;
	  	} 
	  	if(revertContent.length >50){
			layer.alert("回复内容长度不能大于50字");
			return;
		}
	    var options  = {  
	        url:'${ctx}/complaints/complaint/reply',  
	        type:'post',  
	        success:function(data){  
	      	  console.log(data)
	        	if (data.status){
	    			layer.alert("保存成功!", {icon: 1, shade: 0}, function(index){
	    			parent.location.reload(); // 父页面刷新  
	    			});
	    		}else{
	    			layer.alert("保存失败!", {icon: 2, shade: 0});
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
	float:left;
	margin-right:5px;
	cursor: pointer;
}

input,textarea {
	disabled: disabled
}
</style>
</head>

<body>
	<div style="text-align: center">
		<form id="infoForm" method='post' class="breadcrumb form-search" style="background-color: white;margin-top:20px;">
			<input type="text"name="id" value="${usersSuggestion.id}" style="display:none" />
			<ul  id="dataShowUl" class="ul-form">
				<li>
		    	<label>用户类型：</label>
		    	<input type="text" value="${usersSuggestion.userSortStr}" maxlength="100" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
	  		<li>
		    	<label>用户名：</label>
		    	<input type="text" value="${usersSuggestion.truename}" maxlength="100" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	
		   	<li>
		   		<label>时间：</label>
		    	<input type="text" value="<fmt:formatDate value="${usersSuggestion.createDate}" pattern="yyyy-MM-dd"/>"class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	<li class="clearfix"></li>
		   	<li style="height:60px;padding-top:8px;">
		   		<label>内容：</label>
	    		<textarea cols='8' name="suggestionContent" id="suggestionContent" readonly style="width:500px;height:50px;">${usersSuggestion.suggestionContent}</textarea>
	    	</li>
	    	
			<li class="clearfix"></li>
			<c:if 
				test="${not empty usersSuggestion.img1||not empty usersSuggestion.img2||not empty usersSuggestion.img3||not empty usersSuggestion.img4||not empty usersSuggestion.img5}">
				<li style="width:100%; margin-top:10px;overflow:hidden;height:100px;">
				<label style="float:left">图片：</label>
					<c:if test="${not empty usersSuggestion.img1}">
					  <img alt="" class="img" data-original="<%=basePath%>${usersSuggestion.img1}" src="<%=basePath%>${usersSuggestion.img1}" />
					</c:if>
					<c:if test="${not empty usersSuggestion.img2}">
					  <img alt="" class="img" data-original="<%=basePath%>${usersSuggestion.img1}" src="<%=basePath%>${usersSuggestion.img2}" />
					</c:if>
					<c:if test="${not empty usersSuggestion.img3}">
					  <img alt="" class="img" data-original="<%=basePath%>${usersSuggestion.img1}" src="<%=basePath%>${usersSuggestion.img3}" />
					</c:if>
					<c:if test="${not empty usersSuggestion.img4}">
					  <img alt="" class="img" data-original="<%=basePath%>${usersSuggestion.img1}" src="<%=basePath%>${usersSuggestion.img4}" />
					</c:if>
					<c:if test="${not empty usersSuggestion.img5}">
					  <img alt="" class="img" data-original="<%=basePath%>${usersSuggestion.img1}" src="<%=basePath%>${usersSuggestion.img5}" />
					</c:if>
				</li>
	    	</c:if>
		   	<li class="clearfix"></li>
		   	<li style="height:100px;width:100%; margin-top:10px;">
		   		<label style="float:left">回复：</label>
		    	<textarea cols='5' id="revert" name="replyContent" style="width:505px;height:50px;float:left" placeholder="回复长度不大于50字">${usersSuggestion.replyContent}</textarea>
		   	</li>
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
