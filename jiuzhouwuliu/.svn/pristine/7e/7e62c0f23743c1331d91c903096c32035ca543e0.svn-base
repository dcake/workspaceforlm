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
    <title>开票详情</title>    
	<meta name="decorator" content="default"/>
	<!-- 引入layer插件 -->
	<link rel="stylesheet" href="${ctxStatic}/layer-v2.0/layer/skin/layer.css">
	<script src="${ctxStatic}/layer-v2.0/layer/layer.js"></script>
	<script src="${ctxStatic}/layer-v2.0/layer/laydate/laydate.js"></script>
	<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.11.1/lib/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.11.1/lib/jquery.form.js"></script> 
    <script type="text/javascript">
    //确定
    function doSubmit(){
		var form = $('#infoForm');
        var options  = {  
            url:'${ctx}/finance/billing/saveBilling',  
            type:'post', 
            data:{},
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
	</style>
  </head>
  
  <body>
  
  	<div style="text-align: center">
	 
	  <!-- Tab panes -->
	  <div class="tab-content">
	  <div role="tabpanel" class="tab-pane active" id="home">
	  <form id="infoForm" method = 'post' class="breadcrumb form-search" style="background-color: white;" enctype="multipart/form-data">
	  <input type="text" id="id" name="id" value="${goodsBilling.id}" style="display:none"/>
	    <input type="text" id="goodsid" name="goodsid" value="${goodsBilling.goodsid}" style="display:none"/>
	  	<ul class="ul-form">
	  		<li>
		    	<label>开票单位：</label>
		    	<input type="text" value="${goodsBilling.companyName}" maxlength="100" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
	    	<li>
		    	<label>货物类型：</label>
	    		<input type="text" value="${goodsBilling.goodsType}" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	<li class="clearfix"></li>
		   	<li>
		   		<label>订单编号：</label>
		    	<input type="text" value="${goodsBilling.orderNo}"class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	<li>
		   		<label>时间：</label>
	    		<input type="text"  style="width:163px" readonly="readonly" value="<fmt:formatDate value='${goodsBilling.createDate}' pattern='yyyy-MM-dd HH:mm' />">
	    	</li>
	    	<li class="clearfix"></li>
		   	<li>
			   	<label>订单金额：</label>
			   	<input type="text" value="${goodsBilling.payMoney}" class="input-medium" style="width:163px" readonly="readonly"/>
	    	</li>
	    	<li>
	    		<label>开票金额：</label>
	    		<input type="text" value="${goodsBilling.billingMoney}" class="input-medium" style="width:163px" readonly="readonly"/>
	    	</li>
	    	<li class="clearfix"></li>
	    	<li>
		   		<label>货主姓名：</label>
		    	<input type="text" value="${goodsBilling.truename}" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	<li>
		   		<label>货主等级：</label>
		    	<input type="text" value="${goodsBilling.level}" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	<li class="clearfix"></li>
		   	<li>
		   		<label>电话：</label>
		    	<input type="text" value="${goodsBilling.phoneno}" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	<li>
		   		<label>是否已结算：</label>
		   		<c:if test="${goodsBilling.isSettleAccounts=='0'}">
		   			<input type="text" value="否" class="input-medium" style="width:163px" readonly="readonly"/>
		   		</c:if>
		   		<c:if test="${goodsBilling.isSettleAccounts=='1'}">
		   			<input type="text" value="是" class="input-medium" style="width:163px" readonly="readonly"/>
		   		</c:if>
		   	</li>
		   	<li class="clearfix"></li>
		   	<li>
		   		<label>发票编号：</label>
		    	<input type="text" name="billingNo" value="<c:out value="${goodsBilling.billingNo}"/>" class="input-medium" style="width:163px"/>
		   		<span class="help-inline"><font color="red">*</font> </span>
		   	</li>
		   	<li>
		   		<label style="width:105px;">是否已开票：</label>
		   		<c:if test="${goodsBilling.isHasBill=='0'}">
		   			<input type="text" value="否" class="input-medium" style="width:163px" readonly="readonly"/>
		   		</c:if>
		   		<c:if test="${goodsBilling.isHasBill=='1'}">
		   			<input type="text" value="是" class="input-medium" style="width:163px" readonly="readonly"/>
		   		</c:if>
		   	</li>
		</ul>
	  </form>
	</div>
	  
	</div>
	</div>
	
  </body>
</html>
