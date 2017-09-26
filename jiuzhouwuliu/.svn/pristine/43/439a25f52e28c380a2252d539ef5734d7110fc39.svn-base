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
    <title>提现审核</title>    
	<meta name="decorator" content="default"/>
	<!-- 引入layer插件 -->
	<link rel="stylesheet" href="${ctxStatic}/layer-v2.0/layer/skin/layer.css">
	<script src="${ctxStatic}/layer-v2.0/layer/layer.js"></script>
	<script src="${ctxStatic}/layer-v2.0/layer/laydate/laydate.js"></script>
	<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.11.1/lib/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.11.1/lib/jquery.form.js"></script> 
    <script type="text/javascript">
    	//同意
    	function doSubmitAgree(){
    		var form = $('#infoForm');
            var options  = {  
                url:'${ctx}/finance/application/checkAgreeOrReturn',  
                type:'post', 
                data:{status:"1"},
                success:function(data){
                	if(data.status){
                		layer.alert(data.msg, {icon: 1, shade: 0}, function(index){
    	        			parent.location.reload(); // 父页面刷新 
    	        		});
                	}else{
                		layer.alert(data.msg, {icon: 2, shade: 0});
                	}
                }  
            };  
            form.ajaxSubmit(options); 
    	}
    	 //驳回
    	function doSubmitReturn(){
    		var remarks=$("#remarks").val();
    		if(remarks==""){
    			layer.alert("请输入审核意见");
    			return;
    		}
    		if(remarks.length>120){
    			layer.alert("审核意见字数过长，120个字符以内！");
    			return;
    		}
    		var form = $('#infoForm');
            var options  = {  
                url:'${ctx}/finance/application/checkAgreeOrReturn',  
                type:'post',  
                data:{status:"2"},
                success:function(data){
                	if(data.status){
                		layer.alert(data.msg, {icon: 1, shade: 0}, function(index){
    	        			parent.location.reload(); // 父页面刷新 
    	        		});
                	}else{
                		layer.alert(data.msg, {icon: 2, shade: 0});
                	}
                }  
            };  
            form.ajaxSubmit(options);
    	}
	</script>
	<style type="text/css">
		/* select, textarea, input[type="text"], input[type="password"], input[type="datetime"], input[type="datetime-local"], input[type="date"], input[type="month"], input[type="time"], input[type="week"], input[type="number"], input[type="email"], input[type="url"], input[type="search"], input[type="tel"], input[type="color"], .uneditable-input{
			height: 30px;
		} */
		.form-search .ul-form li label{width:120px;text-align:right;}
		.form-search .ul-form li{
			line-height: 0;
		}
	</style>
  </head>
  
  <body>
  
  	<div style="text-align: center">
	 
	  <!-- Tab panes -->
	  <div class="tab-content">
	  <div role="tabpanel" class="tab-pane active" id="home">
	  <form id="infoForm" method = 'post' class="breadcrumb form-search" style="background-color: white;" enctype="multipart/form-data">
	  <input type="text" id="id" name="id" value="${userWithdrawCash.id}" style="display:none"/>
	  <input type="text" id="userid" name="userid" value="${userWithdrawCash.userid}" style="display:none"/>
	  	<ul class="ul-form">
	  		<li style="margin-left: 65px;">
		    	<h5>提现人信息</h5>
		   	</li>
		   	<li class="clearfix"></li>
	  		<li>
		    	<label>用户名：</label>
		    	<input type="text" id="username" name="username" value="${user.username}" maxlength="100" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
	    	<li>
		    	<label>身份证号：</label>
	    		<input id="cardno" name="cardno" type="text" value="${user.cardno}" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	<li class="clearfix"></li>
		   	<li>
		   		<label>手机号：</label>
		    	<input id="phoneno" name="phoneno" type="text" value="${user.phoneno}"class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	<li>
		   		<label>等级：</label>
	    		<input id="level" name="level" type="text" value="${user.level}" class="input-medium" style="width:163px" readonly="readonly"/>
	    	</li>
	    	<li class="clearfix"></li>
		   	<li>
			   	<label>姓名：</label>
			   	<input type="text" id="truename" name="truename" value="${user.truename}" class="input-medium" style="width:163px" readonly="readonly"/>
	    	</li>
	    	<li>
	    		<label>用户类型：</label>
	    		<input type="text" id="userSort" name="userSort" value="${user.userSort}" class="input-medium" style="width:163px" readonly="readonly"/>
	    	</li>
	    	<li class="clearfix"></li>
	    	<li>
		   		<label>余额金额：</label>
		    	<input id="accountMoney" name="accountMoney" type="text" value="${user.accountMoney}" class="input-medium" style="width:163px" readonly="readonly"/>元
		   	</li>
		   	<li>
		   		<label style="margin-left: -3px;">申请提现金额：</label>
		    	<input id="appayMoney" name="appayMoney" type="text" value="${userWithdrawCash.appayMoney}" class="input-medium" style="width:163px" readonly="readonly"/>元
		   	</li>
		   	<li class="clearfix"></li>
		   	<li>
		   		<label>申请时间：</label>
		   		<input id="createDate" type="text" readonly="readonly" class="input-medium Wdate input-short"
				value="<fmt:formatDate value='${userWithdrawCash.createDate}' pattern='yyyy-MM-dd HH:mm'/>"/>
		   	</li>
		   	<li class="clearfix"></li>
		   	<li style="height:100px;width:100%">
		   		<label style="float:left">审核意见：</label>
		   		<c:if test="${checkOut == 1 }">
		   			<textarea cols='5'  name="remarks" id="remarks" style="width:480px;height:50px;float:left" readonly>${userWithdrawCash.remarks}</textarea>
		   		</c:if>
		   		<c:if test="${checkOut != 1 }">
				<textarea cols='5'  name="remarks" id="remarks" style="width:480px;height:50px;float:left" ></textarea>
		   		</c:if>
		   	</li>
		</ul>
	  </form>
	</div>
	  
	</div>
	</div>
	
  </body>
</html>
