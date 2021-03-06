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
    <title>货主详情</title>    
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
  	//回调函数，在编辑和保存动作时，供openDialog调用提交表单
	</script>
	<style type="text/css">
	.form-search .ul-form li label{width:120px;text-align:right;}
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
	  	   <input type="text" id="id" name="id" value="${users.id}" style="display:none"/>
	 <!-------------------------------------基本信息--------------------------------------------------------------  -->
	  	<ul class="ul-form" style="height:310px;">
	  				<li>
	    	<label>用户名：</label>
	    	<input type="text"  class="input-medium" style="width:163px"value="${users.username}" readonly="readonly"/>
		   	</li>
	    		<li>
	    	<label>手机：</label>
	    	<input type="text"  class="input-medium" style="width:163px"value="${users.phoneno}"  readonly="readonly"/>
		   	</li>
	    	<li class="clearfix"></li>
	    		<li>
	    	<label>姓名：</label>
	    	<input type="text"  class="input-medium" style="width:163px"value="${users.truename}" readonly="readonly"/>
		   	</li>
	    		<li>
	    	<label>身份证号：</label>
	    	<input type="text"  class="input-medium" style="width:163px"value="${users.cardno}" readonly="readonly"/>
		   	</li>
	    	<li class="clearfix"></li>
	 		 			<li>
	    	 	<label>状态：</label>
	 		<select class="input-medium" style="width: 177px;" disabled="disabled">
		   			<c:forEach items="${usersStatus}" var="t">
		   			<option value="${t.value}" ${t.value==users.status? 'selected':''}>${t.label}</option>
		   			</c:forEach>
		   	</select>
	 		</li>
	 			<li>
	    	<label>支付积分：</label>
	    	<input type="text" class="input-medium" value="${users.currentPoint}" readonly="readonly"/>
		   	</li>
	    	<li class="clearfix"></li>
	 		 			<li>
	    	 	<label>等级：</label>
	 		<select class="input-medium" style="width: 177px;" disabled="disabled">
		   			<c:forEach items="${goodsLevel}" var="t">
		   			<option value="${t.value}" ${t.value==users.level? 'selected':''}>${t.label}</option>
		   			</c:forEach>
		   	</select>
	 		</li>
	    	<li>
	    		<label style="margin-right: 400px;margin-top: 35px;">头像：</label>
	    		<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 140px;margin-top: -50px;">
	    			<img id="headImg" style="width:120px;height:120px;cursor: pointer;" src="${users.headImg}" />
	    		</div>
	    	</li>
		</ul>
	 	</form>
	 	<!-- --------------------------------------------------------认证信息----------------------------------------- -->
	  </div>
		<div role="tabpanel" class="tab-pane" id="profile">
				<div style="overflow:-Scroll;overflow-y:hidden;height: 420px;">
					<ul class="ul-form" style="height:600px;">
						<li style="list-style-type:none;">
							<label style="margin-left: -294px;margin-top: 21px;">企业名称：</label>
							<input type="text" maxlength="100" class="input-medium" style="width:163px" value="${goodsowners.companyName}" readonly="readonly"/>
						</li>
					 	 <li style="list-style-type:none;">
					    	 	<label style="margin-left: -266px;">身份：</label>
							 		<select class="input-medium" style="width: 177px;" disabled="disabled">
							   			<c:forEach items="${goodsownersIdentityType}" var="t">
							   			<option value="${t.value}" ${t.value==goodsowners.identityType? 'selected':''}>${t.label}</option>
							   			</c:forEach>
								   	</select>
	 		            </li>
						<li id="imagesCompany" style="list-style-type:none;">
	    						<label style="margin-right: 472px;">营业执照：</label>
			    					<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 85px;margin-top: -1px;">
			    					<img style="width:120px;height:120px;cursor: pointer;" src="${goodsowners.businessLicenseFaceImg}"/>
			    					</div>
			    						<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 215px;margin-top: -122px;">
			    			<img  style="width:120px;height:120px;cursor: pointer;" src="${goodsowners.businessLicenseOtherImg}"/>
			    		</div>
	    				</li>
			    		 <li id="imagesCradNo" style="list-style-type:none; margin-top: 10px;">
	    						<label style="margin-right: 455px;">身份证：</label>
			    				<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 85px;margin-top: -1px;">
			    				<img  style="width:120px;height:120px;cursor: pointer;" src="${users.cardFaceImg}"/>
			    				</div>
			    				<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 215px;margin-top: -122px;">
			    				<img style="width:120px;height:120px;cursor: pointer;" src="${users.cardOtherImg}"/>
			    				</div>
	    				</li>
					</ul>
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
	//企业资质图片放大
	var viewer1 = new Viewer(document.getElementById('imagesCompany'), {
		url : 'src'
	});
	</script>
  </body>
</html>
