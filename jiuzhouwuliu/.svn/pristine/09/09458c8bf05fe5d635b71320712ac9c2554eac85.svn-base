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
    <title>结算</title>    
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
    	layer.confirm('确认要结算吗？', function (index) {
    		var form = $('#infoForm');
            var options  = {  
                url:'${ctx}/finance/matFunds/detailJieSuan',  
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
        });
		 
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
	  <input type="text" id="id" name="id" value="${driverReciveMoney.id}" style="display:none"/>
	  <input type="text" id="goodsownerDealId" name="goodsownerDealId" value="${driverReciveMoney.goodsownerDealId}" style="display:none"/>
	  	<ul class="ul-form">
	  		<li>
	  			<h5>客户信息</h5>
	  		</li>
	  		<li class="clearfix"></li>
	  		<%-- <li>
		    	<label>用户名：</label>
		    	<input type="text" value="${driverReciveMoney.username}" maxlength="100" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li> --%>
	    	<li>
		    	<label>姓名：</label>
	    		<input type="text" value="${driverReciveMoney.truename}" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   
		   	<li>
		   		<label>手机号：</label>
		    	<input type="text" value="${driverReciveMoney.phoneno}"class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   		<li class="clearfix"></li>
		   	<li>
		   		<label>用户等级：</label>
	    		<input type="text" readonly="readonly" class="input-medium input-short" value="${driverReciveMoney.level}"/>
	    	</li>
	    	<li class="clearfix"></li>
		   	<li>
		   		<h5>垫资信息</h5>
		   	</li>
		   	<li class="clearfix"></li>
		   	<li>
			   	<label>垫资总金额：</label>
			   	<input type="text" value="${driverReciveMoney.totalMoney}" class="input-medium" style="width:163px" readonly="readonly"/>
	    	</li>
	    	<li>
	    		<label>垫资时间范围：</label>
	    		<input type="text" readonly="readonly" class="input-medium Wdate input-short" value="${driverReciveMoney.beginDate}"/>
	    		——
	    		<input type="text" readonly="readonly" class="input-medium Wdate input-short" value="${driverReciveMoney.endDate}"/>
	    	</li>
	    	<li class="clearfix"></li>
		   	<%-- <li>
		   		<label>是否已结算：</label>
		   		<select id="isSettleAccounts" name="isSettleAccounts" class="input-medium" style="width:177px" readonly="readonly">
		   			<option value="0" <c:if test="${driverReciveMoney.isSettleAccounts=='0'}">selected</c:if>>否</option>
		   			<option value="1" <c:if test="${driverReciveMoney.isSettleAccounts=='1'}">selected</c:if>>是</option>
		   		</select>
		   	</li> --%>
		   	<li>
		   		<label>是否已结算：</label>
		   		<c:if test="${driverReciveMoney.isSettleAccounts=='0'}">
		   			<input type="text" value="否" class="input-medium" style="width:163px" readonly="readonly"/>
		   		</c:if>
		   		<c:if test="${driverReciveMoney.isSettleAccounts=='1'}">
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
