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
    <title>订单详情</title>    
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
	<%--   <input type="text" id="id" name="id" value="${doodsowners.id}" style="display:none"/> --%>
	  	<ul class="ul-form">
	  	<li>
		    	<label>订单编号：</label>
		    	<input type="text" id="orderNo" name="orderNo" value=" ${doodsowners.orderNo}"maxlength="100" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	<li>
		    	<label>金额：</label>
		    	<input type="text" id="payMoney" name="payMoney" value=" ${doodsowners.payMoney}"maxlength="100" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	<li>
		    	<label>获得积分：</label>
		    	<input type="text" id="currentPoint" name="currentPoint" value=" ${doodsowners.currentPoint}"maxlength="100" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
	  		<li>
		    	<label>经纪人名称：</label>
		    	<input type="text" id="agentsTrueName" name="agentsTrueName" value=" ${doodsowners.agentsTrueName}"maxlength="100" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
	    	<li>
		    	<label>经纪人手机号：</label>
	    		<input id="agentsPhoneno" name="agentsPhoneno" type="text" value="${doodsowners.agentsPhoneno}" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   		<li>
		    	<label>车主名称：</label>
		    	<input type="text" id="driversTrueName" name="driversTrueName" value=" ${doodsowners.driversTrueName}"maxlength="100" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
	    	<li>
		    	<label>车主手机号：</label>
	    		<input id="driversPhoneno" name="driversPhoneno" type="text" value="${doodsowners.driversPhoneno}" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		 	<li>
		    	<label>货物类型：</label>
	    		<input id="goodsType" name="goodsType" type="text" value="${doodsowners.goodsType}" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
	    	<li>
	    		<label>发货地：</label>
	    		<input type="text" id="shipperArea" name="shipperArea" value="${doodsowners.shipperArea}"class="input-medium" style="width:163px" readonly="readonly"/>
	    	</li>
	    		<li>
	    		<label>收货地：</label>
	    		<input type="text" id="reciverArea" name="reciverArea" value="${doodsowners.reciverArea}"class="input-medium" style="width:163px" readonly="readonly"/>
	    	</li>
		   	   	<li>
		   		  	<label>装车时间：</label>
	    		<input type="text"  style="width:163px" readonly="readonly" value="${doodsowners.zcSf}">
	    	</li>
	    	
		</ul>
	  </form>
	</div>
	</div>
	</div>
  </body>
</html>
