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
    <title>车主详情</title>    
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
		.form-search .ul-form li label{width:70px;text-align:right;}
	</style>
  </head>
  
  <body>
  
  	<div style="text-align: center">
	  <div class="tab-content">
	  <div role="tabpanel" class="tab-pane active" id="home">
	  <form id="infoForm" method = 'post' class="breadcrumb form-search" style="background-color: white;" enctype="multipart/form-data">
	  <input type="text" id="id" name="id" value="${drivers.id}" style="display:none"/>
	  	<ul class="ul-form" style="height:281px">
	  		<li>
		    	<label>用户名：</label>
		    	<input type="text" id="title" name="title" value="${drivers.username}" maxlength="100" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
	    	<li>
		    	<label>手机号：</label>
	    		<input id="phoneno" name="phoneno" type="text" value="${drivers.phoneno}" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	<c:if test="${drivers.userSort=='1'}">
		   	<li>
		   		<label>注册时间：</label>
		    	<input id="createDate" name="createDate" type="text" value="<fmt:formatDate value='${drivers.createDate}' pattern='yyyy-MM-dd'/>"class="input-medium Wdate input-short" style="width:163px" readonly="readonly"/>
		   	</li>
		   	</c:if>
		   	<li>
		   		<label>状态：</label>
	    		<input id="status" name="status" type="text" readonly="readonly" class="input-medium" value="<c:if test="${drivers.status=='0'}">正常</c:if><c:if test="${drivers.status=='1'}">锁定</c:if>"/>
	    	</li>
		   	<li>
			   	<label>审核状态：</label>
			   	<input type="text" id="examineStatus" name="examineStatus" value="<c:if test="${drivers.examineStatus=='0'}">待审核</c:if><c:if test="${drivers.examineStatus=='1'}">已通过</c:if><c:if test="${drivers.examineStatus=='2'}">已驳回</c:if>" class="input-medium" style="width:163px" readonly="readonly"/>
	    	</li>
	    	
	    	<li>
		   		<label>等级：</label>
		    	<input id="level" name="level" type="text" value="<c:if test="${drivers.level=='1'}">内部</c:if><c:if test="${drivers.level=='2'}">外部</c:if>" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	<c:if test="${drivers.userSort=='1'}">
		   	<li>
		   		<label>所属车队：</label>
		    	<input id="fleetName" name="fleetName" type="text" value="${drivers.fleetName}" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	</c:if>
		   	<c:if test="${drivers.userSort=='2'}">
		   	<li>
		   		<label>身份证号：</label>
		    	<input type="text" value="${drivers.cardno}" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   		<li>
		   		<label>支付积分：</label>
		    	<input type="text" value="${drivers.currentPoint}" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	</c:if>
		   		<li class="clearfix"></li>
		   	<li>
	    		<label>审核意见：</label>
	    		<textarea style="width:425px" readonly="readonly">${drivers.examineRemark}</textarea> 
	    	</li>
		</ul>
	  </form>
	</div>
	  
	</div>
	</div>
	
  </body>
</html>
