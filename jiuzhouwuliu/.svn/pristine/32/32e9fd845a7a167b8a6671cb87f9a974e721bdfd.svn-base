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
    <title>车队长转让审核</title>    
	<meta name="decorator" content="default"/>
	<!-- 引入layer插件 -->
	<link rel="stylesheet" href="${ctxStatic}/layer-v2.0/layer/skin/layer.css">
	<script src="${ctxStatic}/layer-v2.0/layer/layer.js"></script>
	<script src="${ctxStatic}/layer-v2.0/layer/laydate/laydate.js"></script>
	<script type="text/javascript" src="${ctxStatic}/jquery/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${ctxStatic}/jquery/jquery.form.js"></script>
    <script type="text/javascript">
	  	//回调函数，在编辑和保存动作时，供openDialog调用提交表单
	  	var htmlstatus = false;
		function doSubmit(status){
			if(htmlstatus == true || htmlstatus == "true"){
				return false;
			}
			var auditingRemark =  $("#auditingRemark").val();
	  		if(status == '2'){
	  			//auditingRemark = $("#auditingRemark").val();
				if(auditingRemark == null || auditingRemark.trim() == ""){
					layer.alert('请输入审核意见', {icon: 3}); 
					return;
				}
				if(auditingRemark.length>=100){
					layer.alert('您输入的审核意见太长，审核意见不能超过100个字符。', {icon: 3}); 
					return;
				}
	  		}
		    $.ajax({
			  type: 'POST',
			  url: "${ctx}/users/captainTransfer/captainTransferCheck",
			  data: {
				  id:$("#id").val(),
				  auditingStatus:status,
				  auditingRemark:auditingRemark
			  },
			  dataType: "json",
			  success: function(data){
				  htmlstatus = data.status;
				  layer.alert(data.msg, {icon: 1, shade: 0}, function(index){
	      			  parent.location.reload(); // 父页面刷新  
	      		  });
			  },
			  error:function(e){
				  layer.alert("操作失败", {icon: 1, shade: 0})
	      			
			  }
			})
	  	}
	</script>
	<style type="text/css">
		/* select, textarea, input[type="text"], input[type="password"], input[type="datetime"], input[type="datetime-local"], input[type="date"], input[type="month"], input[type="time"], input[type="week"], input[type="number"], input[type="email"], input[type="url"], input[type="search"], input[type="tel"], input[type="color"], .uneditable-input{
			height: 30px;
		} */
		.form-search .ul-form li label{width:120px;text-align:right;}
	</style>
  </head>
  
  <body>
  
  	<div style="text-align: center">
	 
	  <!-- Tab panes -->
	  <div class="tab-content">
	  <div role="tabpanel" class="tab-pane active" id="home">
	  <form id="infoForm" method = 'post' class="breadcrumb form-search" style="background-color: white;" enctype="multipart/form-data">
	  <input type="text" id="id" name="id" value="${driverMasterChange.id}" style="display:none"/>
	  	<ul class="ul-form">
	  		<li style="margin-left: 65px;">
		    	<h5>车队长信息</h5>
		   	</li>
		   		<li class="clearfix"></li>
	  		<li>
		    	<label>用户名：</label>
		    	<input type="text" id="shipperName" name="shipperName" value="${driverMasterChange.shipperName}" maxlength="100" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   		<li class="clearfix"></li>
	    	<li>
		    	<label>手机：</label>
	    		<input id="shipperTel" name="shipperTel" type="text" value="${driverMasterChange.shipperTel}" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	<li class="clearfix"></li>
		   	<li>
		   		<label>姓名：</label>
		    	<input id="goodsType" name="goodsType" type="text" value="${driverMasterChange.goodsType}"class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   		<li class="clearfix"></li>
		   	<li>
		   		<label>身份证号：</label>
	    		<input id="shipperAreaDetail" name="shipperAreaDetail" type="text" value="${driverMasterChange.shipperAreaDetail}" class="input-medium" style="width:163px" readonly="readonly"/>
	    	</li>
	    	<li class="clearfix"></li>
		   	<li>
			   	<label>等级：</label>
			   	<input type="text" id="reciverAreaDetail" name="reciverAreaDetail" value="${driverMasterChange.reciverAreaDetail}" class="input-medium" style="width:163px" readonly="readonly"/>
	    	</li>
	    		<li class="clearfix"></li>
	    	<li style="margin-left: 65px;">
		    	<h5>转让人信息</h5>
		   	</li>
		   		<li class="clearfix"></li>
	    	<li>
	    		<label>用户名：</label>
	    		<input type="text" id="reciverTel" name="reciverTel" value="${driverMasterChange.reciverTel}" class="input-medium" style="width:163px" readonly="readonly"/>
	    	</li>
	    	<li class="clearfix"></li>
	    	<li>
		   		<label>手机：</label>
		    	<input id="insuranceType" name="insuranceType" type="text" value="${driverMasterChange.insuranceType}" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   		<li class="clearfix"></li>
		   	<li>
		   		<label>姓名：</label>
		    	<input id="goodsUnit" name="goodsUnit" type="text" value="${driverMasterChange.goodsUnit}" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	<li class="clearfix"></li>
		   	<li>
		   		<label>身份证号：</label>
		   		<input type="text" id="goodsNum" name="goodsNum" value="${driverMasterChange.goodsNum}" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   		<li class="clearfix"></li>
		   	<li>
		   		<label>等级：</label>
	    		<input type="text" id="needTruckType" name="needTruckType" value="${driverMasterChange.needTruckType}" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	<li class="clearfix"></li>
		   	<li style="height:100px;width:100%;margin-top:5px;">
		   		<label style="float:left">审核意见：</label>
	    		<c:if test="${checkOut == 1 }">
	   			<textarea cols='5'  name="auditingRemark" id="auditingRemark" style="width:480px;height:50px;float:left" readonly>${driverMasterChange.auditingRemark}</textarea>
		   		</c:if>
		   		<c:if test="${checkOut != 1 }">
				<textarea cols='5'  name="auditingRemark" id="auditingRemark" style="width:480px;height:50px;float:left" ></textarea>
				</c:if>
		   	</li>
		</ul>
	  </form>
	</div>
	  
	</div>
	</div>
	
  </body>
</html>
