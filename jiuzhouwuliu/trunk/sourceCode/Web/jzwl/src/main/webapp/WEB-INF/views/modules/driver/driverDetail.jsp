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
    <title>详情</title>    
	<meta name="decorator" content="default"/>
	<link rel="stylesheet" href="${ctxStatic}/image-viewer/css/viewer.min.css">
	<!-- 引入layer插件 -->
	<link rel="stylesheet" href="${ctxStatic}/layer-v2.0/layer/skin/layer.css">
	<script src="${ctxStatic}/layer-v2.0/layer/layer.js"></script>
	<script src="${ctxStatic}/layer-v2.0/layer/laydate/laydate.js"></script>
	<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.11.1/lib/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.11.1/lib/jquery.form.js"></script> 
	<script type="text/javascript" src="${ctxStatic}/pinyin/pinyin.js?v=<%=System.currentTimeMillis()%>"></script>
	<script type="text/javascript" src="${ctxStatic}/jquery/uploadFile.js?v=<%=System.currentTimeMillis()%>"></script>
    <script type="text/javascript">
	</script>
	<style type="text/css">
	.form-search .ul-form li label{width:70px;text-align:right;}
	.gun { overflow-x: hidden; overflow-y: auto; }
	</style>
  </head>
  
  <body>
  
  	<div style="text-align: center">
	  <ul class="nav nav-tabs" role="tablist" style="margin:10px 10px 10px 10px">
	    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab" onClick="setIframeWidth();">基本信息</a></li>
	    <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab" onClick="setIframeWidth();">认证信息</a></li>
	  </ul>
	  <!-- Tab panes -->
	  <div class="tab-content">
	  <div role="tabpanel" class="tab-pane active" id="home">
	  <form id="infoForm" method = 'post' class="breadcrumb form-search" style="background-color: white;" enctype="multipart/form-data">
	  <input type="text" id="id" name="id" value="${drivers.id}" style="display:none"/>
	 <!-------------------------------------基本信息--------------------------------------------------------------  -->
	  <ul class="ul-form" style="height:300px;">
	  		<li>
	    	<label>用户名：</label>
	    	<input type="text" readonly="readonly" class="input-medium" style="width:163px"value="${users.username}"/>
		   	</li>
	    	<li>
	    	<label>手机：</label>
	    	<input type="text" readonly="readonly" class="input-medium" style="width:163px"value="${users.phoneno}"/>
		   	</li>
	    	<li class="clearfix"></li>
	    		<li>
	    	<label>姓名：</label>
	    	<input type="text" readonly="readonly" class="input-medium" style="width:163px"value="${users.truename}"/>
		   	</li>
	    		<li>
	    	<label>身份证号：</label>
	    	<input type="text" readonly="readonly" class="input-medium" style="width:163px"value="${users.cardno}"/>
		   	</li>
	    	<li class="clearfix"></li>
	 		 			<li>
	    	 	<label>状态：</label>
	 		<select disabled="disabled" class="input-medium" style="width: 177px;">
		   			<c:forEach items="${usersStatus}" var="t">
		   			<option value="${t.value}" ${t.value==users.status? 'selected':''}>${t.label}</option>
		   			</c:forEach>
		   	</select>
	 		</li>
	 			<li>
	    	<label>所属车队：</label>
	 		<select disabled="disabled" class="input-medium" style="width: 177px;">
		   				<c:forEach items="${DriveFleetList}" var="t">
		   			<option value="${t.id}" ${t.id==drivers.driveFleetId? 'selected':''}>${t.fleetName}</option>
		   			</c:forEach>
		   	</select>
	 		</li>
	 		<li class="clearfix"></li>
	 			<li>
	    	<label>支付积分：</label>
	    	<input type="text" readonly="readonly" maxlength="10" class="input-medium"  value="${users.currentPoint}"/>
		   	</li>
	 		 			<li>
	    	 	<label>等级：</label>
	 		<select disabled="disabled" class="input-medium" style="width: 177px;">
		   			<c:forEach items="${carLevel}" var="t">
		   			<option value="${t.value}" ${t.value==users.level? 'selected':''}>${t.label}</option>
		   			</c:forEach>
		   	</select>
	 		</li>
	    		<li>
	    		<label style="margin-right: 100px;margin-top: 35px;">头像：</label>
	    		<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 140px;margin-top: -50px;cursor: pointer;">
	    			<img id="headImg"  style="width:120; height:120px;" src="${users.headImg}"/>
	    		</div>
	    	</li>
		</ul>
	 	</form>
	  </div>
 	<div role="tabpanel" class="tab-pane" id="profile">
	  		<div style="margin-top:50px;margin-top: -33px;" >
	  		    	<!--   <form id="infoForm1"  class="breadcrumb form-search" style="background-color: white;" > -->
	  		    	<div style="overflow:-Scroll;overflow-y:hidden;height: 600px;">
	   <form id="infoForm" method = 'post' class="breadcrumb form-search" style="background-color: white;" enctype="multipart/form-data">
	  <ul class="ul-form" style="height:145px">
	    	<li class="clearfix"></li>
	  		<li>
	    	<label >车牌号：</label>
	    	<input type="text" readonly="readonly" class="input-medium" style="width:163px" value="${drivers.truckNo}"/>
		   	</li>
		   	  <li>
		   	  	<label>车型：</label>
		   		<select class="input-medium"  style="width: 177px;" disabled="disabled" >
		   			<option value="">不限</option>
		   			<c:forEach items="${truckType}" var="t">
		   			<option value="${t.value}" <c:if test="${t.value==drivers.truckType}">selected</c:if>>${t.label}</option>
		   			</c:forEach>
		   		</select>
		   	</li>
	    	<li class="clearfix" ></li>
	    	 <li  style="list-style-type:none;">
		   	  	<label style="margin-left: 9px;">车长：</label>
		   		<select class="input-medium"  style="width: 177px;" disabled="disabled">
		   			<c:forEach items="${truckLength}" var="t">
		   			<option value="${t.value}" <c:if test="${t.value==drivers.truckLength}">selected</c:if>>${t.label}</option>
		   			</c:forEach>
		   		</select>&nbsp;&nbsp;米
		   	</li>
	    	 	  <li  style="list-style-type:none;">
		   	  	<label style="margin-left: -10px;">车宽：</label>
		   		<select  class="input-medium"  style="width: 177px;" disabled="disabled">
		   			<c:forEach items="${truckWidth}" var="t">
		   			<option value="${t.value}" <c:if test="${t.value==drivers.truckWidth}">selected</c:if>>${t.label}</option>
		   			</c:forEach>
		   		</select>&nbsp;&nbsp;米
		   	</li>
		   	<li class="clearfix"  style="list-style-type:none;"></li>
	    	 	<%--   <li  style="list-style-type:none;">
		   	  	<label style="margin-left: 9px;">承重：</label>
		   		<select  class="input-medium"  style="width: 177px;" disabled="disabled">
		   			<c:forEach items="${truckMaxwight}" var="t">
		   			<option value="${t.value}" <c:if test="${t.value==drivers.truckMaxwight}">selected</c:if>>${t.label}</option>
		   			</c:forEach>
		   		</select>&nbsp;&nbsp;吨
		   	</li> --%>
		   	 	<li >
	    	<label style="margin-left: 9px;margin-top: 10px;">承重：</label>
	    	<input type="text" maxlength="100" class="input-medium"  style="width:163px"  readonly="readonly"value="${drivers.truckMaxwight}"/>&nbsp;&nbsp;吨
		   	</li>
	    	<li class="clearfix"></li>
	    	</ul>
	    	</form>
	    	 <ul class="ul-form" style="">
	     <!-- 添加身份证图片 -->
	     <li  style="list-style-type:none;">
	    		<label style="margin-right: 369px;width:80px">身份证照片：</label>
	  		
					<div id="imagesCradNo" style="">
					  	<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 185px;margin-top: -1px;float: left">
					  	<img id="cardFaceImg" width="120" height="120" style="cursor: pointer;" src="${users.cardFaceImg}" />
					  	</div>
					  	<div style="border:1px solid #eee;width:120px;height:120px;margin-top: -1px;float: left;margin-left:8px;">
					  	<img id="cardOtherImg"  width="120" height="120"  style="cursor: pointer;" src="${users.cardOtherImg}"/>
						</div>
					</div>
			
			</li>
	    	<!-- 添加驾驶证图片 -->
			      <li  style="list-style-type:none;">
	    		<label style="margin-right: 369px;width:80px">驾驶证：</label>
	  		<div id="imagesDriveLicence" style="">
		    	<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 185px;margin-top: -1px;float: left">
					  <img id="driveLicenceImg1" width="120" height="120" style="cursor: pointer;" src="${drivers.driveLicenceImg1}"/>
				</div>
				<div style="border:1px solid #eee;width:120px;height:120px;margin-top: -1px;float: left;margin-left:8px;">
					  <img id="driveLicenceImg2"  width="120" height="120"  style="cursor: pointer;" src="${drivers.driveLicenceImg2}" />
				</div>
			</div>
			</li>
	    		<!-- 行驶证图片 -->
			 <li  style="list-style-type:none;">
	    		<label style="margin-right: 369px;width:80px">行驶证：</label>
					<div id="imagesDriverCard" style="">
					<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 185px;margin-top: -1px;float: left">
					  	<img id="moveLicenceImg1" width="120" height="120" style="cursor: pointer;" src="${drivers.moveLicenceImg1}" />
					</div>
					<div style="border:1px solid #eee;width:120px;height:120px;margin-top: -1px;float: left;margin-left:8px;">
					  	<img id="moveLicenceImg2"  width="120" height="120"  style="cursor: pointer;"src="${drivers.moveLicenceImg2}" />
					</div>
			</div>
			</li>
		</ul>
		
	 </div>
				</div>
			</div>
	  </div>
	</div>
	<script type="text/javascript" src="${ctxStatic}/image-viewer/js/viewer.min.js"></script>
	<script>
		//头像
		var viewerPhoto = new Viewer(document.getElementById('headImg'), {
			url : 'src'
		});
		//身份证图片放大
		var viewer = new Viewer(document.getElementById('imagesCradNo'), {
			url : 'src'
		});
		//驾驶证图片放大
		var viewer1 = new Viewer(document.getElementById('imagesDriveLicence'), {
			url : 'src'
		});
		//行驶证图片放大
		var viewer2 = new Viewer(document.getElementById('imagesDriverCard'), {
			url : 'src'
		});
	</script>
  </body>
</html>
