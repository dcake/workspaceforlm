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
    <title>高估值货品审核</title>    
	<meta name="decorator" content="default"/>
	<link rel="stylesheet" href="${ctxStatic}/image-viewer/css/viewer.min.css">
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
			var examRemark = examRemark = $("#examRemark").val();
	  		if(status == '2'){
	  			
				if(examRemark == null || examRemark.trim() == ""){
					layer.alert('请输入审核意见', {icon: 3}); 
					return;
				}
	  		}
		    $.ajax({
			  type: 'POST',
			  url: "${ctx}/users/highValuationOfGoods/highValuationOfGoodsCheck",
			  data: {
				  id:$("#id").val(),
				  isExamPass:status,
				  examRemark :$("#examRemark").val()
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
	  <input type="text" id="id" name="id" value="${goods.id}" style="display:none"/>
	  	<ul class="ul-form">
	  		<li style="margin-left: 65px;">
		    	<h5>货物信息</h5>
		   	</li>
		   	<li class="clearfix"></li>
	  		<li>
		    	<label>货主名称：</label>
		    	<input type="text" id="shipperName" name="shipperName" value="${goods.shipperName }" maxlength="100" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
	    	<li>
		    	<label>货主手机号码：</label>
	    		<input id="shipperTel" name="shipperTel" type="text" value="${goods.shipperTel }" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	<li class="clearfix"></li>
		   	<li>
		   		<label>货物类型：</label>
		    	<input id="goodsType" name="goodsType" type="text" value="${goods.goodsType }"class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	<li>
		   		<label>发货地详细地址：</label>
	    		<input id="shipperAreaDetail" name="shipperAreaDetail" type="text" value="${goods.shipperAreaDetail }" class="input-medium" style="width:163px" readonly="readonly"/>
	    	</li>
	    	<li class="clearfix"></li>
		   	<li>
			   	<label>收货地详细地址：</label>
			   	<input type="text" id="reciverAreaDetail" name="reciverAreaDetail" value="${goods.reciverAreaDetail }" class="input-medium" style="width:163px" readonly="readonly"/>
	    	</li>
	    	<li>
	    		<label>收货手机号码：</label>
	    		<input type="text" id="reciverTel" name="reciverTel" value="${goods.reciverTel }" class="input-medium" style="width:163px" readonly="readonly"/>
	    	</li>
	    	<li class="clearfix"></li>
	    	<li>
		   		<label>类型（保险）：</label>
		    	<input id="insuranceType" name="insuranceType" type="text" value="${goods.insuranceType }" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	<li>
		   		<label>重量：</label>
		    	<input id="goodsUnit" name="goodsUnit" type="text" value="${goods.goodsUnit }" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	<li class="clearfix"></li>
		   	<li>
		   		<label>数量：</label>
		   		<input type="text" id="goodsNum" name="goodsNum" value="${goods.goodsNum }" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	<li>
		   		<label>需求车型：</label>
	    		<input type="text" id="needTruckType" name="needTruckType" value="${goods.needTruckType }" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	<li class="clearfix"></li>
		   	<li>
		   		<label>估值：</label>
		   		<input type="text" id="insurancePrice" name="insurancePrice" value="${goods.insurancePrice }" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	<li>
		   		<label>保费：</label>
	    		<input type="text" id="insuranceMoney" name="insuranceMoney" value="${goods.insuranceMoney }" class="input-medium" style="width:163px" readonly="readonly"/>
		   	</li>
		   	<li class="clearfix"></li>
		   	<li id="headImg" style="margin-top:5px;">
		   		<label>货物图片：</label>
	    		<img src="${ctxStatic}/${goods.goodsImg1}" style="width:120px; height:100px;cursor: pointer;" alt="${goods.goodsImg1 == null || goods.goodsImg1 == '' ? '暂无图片' : ''}">
	    		<img src="${ctxStatic}/${goods.goodsImg2}" style="width:120px; height:100px;cursor: pointer;" alt="${goods.goodsImg2 == null || goods.goodsImg2 == '' ? '暂无图片' : ''}">
	    		<img src="${ctxStatic}/${goods.goodsImg3}" style="width:120px; height:100px;cursor: pointer;" alt="${goods.goodsImg3 == null || goods.goodsImg3 == '' ? '暂无图片' : ''}">
	    		<img src="${ctxStatic}/${goods.goodsImg4}" style="width:120px; height:100px;cursor: pointer;" alt="${goods.goodsImg4 == null || goods.goodsImg4 == '' ? '暂无图片' : ''}">
		   	</li>
		   	<li class="clearfix"></li>
		   	<li id="imagesCradNo" style="margin-top:70px;">
		   		<label></label>
	    		<img src="${ctxStatic}/${goods.goodsImg5}" style="width:120px; height:100px;cursor: pointer;" alt="${goods.goodsImg5 == null || goods.goodsImg5 == '' ? '暂无图片' : ''}">
	    		<img src="${ctxStatic}/${goods.goodsImg6}" style="width:120px; height:100px;cursor: pointer;" alt="${goods.goodsImg6 == null || goods.goodsImg6 == '' ? '暂无图片' : ''}">
	    		<img src="${ctxStatic}/${goods.goodsImg7}" style="width:120px; height:100px;cursor: pointer;" alt="${goods.goodsImg7 == null || goods.goodsImg7 == '' ? '暂无图片' : ''}">
	    		<img src="${ctxStatic}/${goods.goodsImg8}" style="width:120px; height:100px; cursor: pointer;" alt="${goods.goodsImg8 == null || goods.goodsImg8 == '' ? '暂无图片' : ''}">
		   	</li>
		   	<li class="clearfix"></li>
		   	<li style="height:100px;width:100%; margin-top:80px;">
		   		<label style="float:left">审核意见：</label>
		   		<c:if test="${checkOut == 1 }">
		   			<textarea cols='5'  name="examRemark" id="examRemark" style="width:480px;height:50px;float:left" readonly>${goods.examRemark}</textarea>
		   		</c:if>
		   		<c:if test="${checkOut != 1 }">
				<textarea cols='5'  name="examRemark" id="examRemark" style="width:480px;height:50px;float:left" ></textarea>
		   		</c:if>
		   	</li>
		</ul>
	  </form>
	</div>
	  
	</div>
	</div>
	<script type="text/javascript" src="${ctxStatic}/image-viewer/js/viewer.min.js"></script>
	<script>
		//货物图片放大
		var viewerPhoto = new Viewer(document.getElementById('headImg'), {
			url : 'src'
		});
		//身份证图片放大
		var viewer = new Viewer(document.getElementById('imagesCradNo'), {
			url : 'src'
		});
	
		
	</script>
  </body>
</html>
