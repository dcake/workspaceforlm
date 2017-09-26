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
    <title>车队详情</title>    
	<meta name="decorator" content="default"/>
	<!-- 引入layer插件 -->
	<link rel="stylesheet" href="${ctxStatic}/layer-v2.0/layer/skin/layer.css">
	<script src="${ctxStatic}/layer-v2.0/layer/layer.js"></script>
	<script src="${ctxStatic}/layer-v2.0/layer/laydate/laydate.js"></script>
	<script type="text/javascript" src="${ctxStatic}/jquery/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${ctxStatic}/jquery/jquery.form.js"></script>
    <script type="text/javascript">
    
	</script>
	<style type="text/css">
		.form-search .ul-form li label{width:120px;text-align:right;}
	</style>
  </head>
  
  <body>
  
  	<div style="text-align: center">
	  <div class="tab-content">
	  <div role="tabpanel" class="tab-pane active" id="home">
	  <form id="infoForm" method = 'post' class="breadcrumb form-search" style="background-color: white;" enctype="multipart/form-data">
	  <input type="text" id="id" name="id" value="${driveFleet.id}" style="display:none"/>
	  	<ul class="ul-form">
	  	<li>
		    	<label>车队长：</label>
		    	<input type="text" id="title" name="title" value="" maxlength="100" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
	  		<li>
		    	<label>队员用户名：</label>
		    	<input type="text" id="username" name="username"  value="${driveFleet.username}"  maxlength="100" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   		<li>
		    	<label>姓名：</label>
		    	<input type="text" id="truename" name="truename"  value="${driveFleet.truename}"  maxlength="100" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
	    	<li>
		    	<label>手机号：</label>
	    		<input id="phoneno" name="phoneno" type="text" value="${driveFleet.phoneno}" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	 	<li>
		  		<label>等级：</label>
		   		<c:if test="${driveFleet.fleetLevel=='1'}">
		   			<input type="text" value="一级" class="input-medium" style="width:163px" readonly="readonly"/>
		   		</c:if>
		   		<c:if test="${driveFleet.fleetLevel=='2'}">
		   			<input type="text" value="二级" class="input-medium" style="width:163px" readonly="readonly"/>
		   		</c:if>
		   		<c:if test="${driveFleet.fleetLevel=='3'}">
		   			<input type="text" value="三级" class="input-medium" style="width:163px" readonly="readonly"/>
		   		</c:if>
		   		<c:if test="${driveFleet.fleetLevel=='4'}">
		   			<input type="text" value="四级" class="input-medium" style="width:163px" readonly="readonly"/>
		   		</c:if>
		   	</li>
		 
		</ul>
	  </form>
	</div>
	  
	</div>
	</div>
	
  </body>
</html>
