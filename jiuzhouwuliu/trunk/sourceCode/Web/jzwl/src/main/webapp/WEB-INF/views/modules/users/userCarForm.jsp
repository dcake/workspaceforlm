<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>车主审核</title>
<meta name="decorator" content="default" />
<link rel="stylesheet" href="${ctxStatic}/image-viewer/css/viewer.min.css">
<!-- 引入layer插件 -->
<link rel="stylesheet"
	href="${ctxStatic}/layer-v2.0/layer/skin/layer.css">
<script src="${ctxStatic}/layer-v2.0/layer/layer.js"></script>
<script src="${ctxStatic}/layer-v2.0/layer/laydate/laydate.js"></script>
<script type="text/javascript"
	src="${ctxStatic}/jquery-validation/1.11.1/lib/jquery-1.8.3.js"></script>
<script type="text/javascript"
	src="${ctxStatic}/jquery-validation/1.11.1/lib/jquery.form.js"></script>
<script type="text/javascript"
	src="${ctxStatic}/pinyin/pinyin.js?v=<%=System.currentTimeMillis()%>"></script>
<script type="text/javascript"
	src="${ctxStatic}/jquery/uploadFile.js?v=<%=System.currentTimeMillis()%>"></script>
<script type="text/javascript">
	//同意
	var t = false;
	function doSubmit() {
			if (t) {
				layer.alert("该用户已审核！");
				return;
			}
			var remarks = $("#examineRemark").val();
			if (remarks.length > 120) {
				layer.alert("审核意见字数过长，120个字符以内！");
				return;
			}
			var form = $('#infoForm');
			var options = {
				url : '${ctx}/users/check',
				type : 'post',
				data : {
					examineStatus : "1",isTruename:$("#isTruename").val(),isTrueDrive:$("#isTrueDrive").val(),isTrueMove:$("#isTrueMove").val(),examineRemark:$("#examineRemark").val()
				},
				success : function(data) {
					t = true;
					if (data == "1") {
						layer.alert("已通过", {
							icon : 1,
							shade : 0
						}, function(index) {
							parent.location.reload(); // 父页面刷新 
						});
					} else {
						layer.alert("操作失败", {icon : 2,shade : 0});
					}
				}
			};
			form.ajaxSubmit(options);
	}
	//驳回
	function doSubmitReturn() {
			if (t) {
				layer.alert("该用户已审核！");
				return;
			}
			var remarks = $("#examineRemark").val();
			if($.trim(remarks) == ""){
				layer.alert("驳回审核意见不能为空！");
				return;
			}
			if (remarks.length > 120) {
				layer.alert("审核意见字数过长，120个字符以内！");
				return;
			}
			var form = $('#infoForm');
			var options = {
				url : '${ctx}/users/check',
				type : 'post',
				data : {
					examineStatus : "2",isTruename:$("#isTruename").val(),isTrueDrive:$("#isTrueDrive").val(),isTrueMove:$("#isTrueMove").val()
				},
				success : function(data) {
					t = true;
					if (data == "1") {
						layer.alert("已驳回", {
							icon : 1,
							shade : 0
						}, function(index) {
							parent.location.reload(); // 父页面刷新 
						});
					} else {
						layer.alert("操作失败", {
							icon : 2,
							shade : 0
						});
					}
				}
			};
			form.ajaxSubmit(options);
	}
</script>
<style type="text/css">
.form-search .ul-form li label {
	width: 70px;
	text-align: right;
}

.gun {
	overflow-x: hidden;
	overflow-y: auto;
}
</style>
</head>

<body>

	<div >
		<ul class="nav nav-tabs" role="tablist"
			style="margin:10px 10px 10px 10px">
			<li role="presentation" class="active"><a href="#home"
				aria-controls="home" role="tab" data-toggle="tab"
				onClick="setIframeWidth();">基本信息</a></li>
			<li role="presentation"><a href="#profile"
				aria-controls="profile" role="tab" data-toggle="tab"
				onClick="setIframeWidth();">认证信息</a></li>
		</ul>
		<!-- Tab panes -->
		<div class="tab-content">
			<div role="tabpanel" class="tab-pane active" id="home">
				<form id="infoForm" method='post' class="breadcrumb form-search"
					style="background-color: white;" enctype="multipart/form-data">
					<input type="hidden" id="id" name="id" value="${users.id }" />
					<!-------------------------------------基本信息--------------------------------------------------------------  -->
					<ul class="ul-form" style="height:275px;">
						<li><label>用户名：</label> <input type="text"
							class="input-medium" value="${users.username}"
							style="width:163px" readonly="readonly" /></li>
						<li><label>手机：</label> <input type="text"
							class="input-medium" value="${users.phoneno}" style="width:163px"
							readonly="readonly" /></li>
						<li class="clearfix"></li>
						<li><label>姓名：</label> <input type="text"
							class="input-medium" value="${users.truename}"
							style="width:163px" readonly="readonly" /></li>
						<li><label>身份证号：</label> <input type="text"
							class="input-medium" value="${users.cardno}" style="width:163px"
							readonly="readonly" /></li>
						<li class="clearfix"></li>
						<li><label>状态：</label> <select id="status" name="status"
							class="input-medium" style="width: 177px;" disabled="disabled">
								<option value="0"
									<c:if test="${users.status=='0'}">selected</c:if>>正常</option>
								<option value="1"
									<c:if test="${users.status=='1'}">selected</c:if>>锁定</option>
						</select></li>
						<li><label>所属车队：</label> <input type="text"
							class="input-medium" value="${users.fleetName}"
							style="width:163px" readonly="readonly" /></li>
						<li class="clearfix"></li>
						<li><label>支付积分：</label> <input type="text"
							class="input-medium" value="${users.currentPoint}"
							readonly="readonly" /> <!-- <span class="help-inline"><font color="red">*</font> </span> -->
						</li>
						<li><label>等级：</label> <select id="level"
							class="input-medium" style="width: 177px;" disabled="disabled">
								<option value="1"
									<c:if test="${users.level=='1'}">selected</c:if>>内部车主</option>
								<option value="2"
									<c:if test="${users.level=='2'}">selected</c:if>>外部车主</option>
						</select></li>
						<li><label style="margin-right: 400px;margin-top: 35px;">头像：</label>
							<div
								style="border:1px solid #eee;width:120px;height:120px;margin-left: 140px;margin-top: -50px;">
								<img id="headImg" style="width:120; height:120px;cursor: pointer;"
									<c:if test="${users.headImg!=null&&users.headImg!=''}">src="<%=basePath%>${users.headImg}"</c:if> />
								<!-- 	<span class="label label-info"style=" margin-top: 0px; margin-left: -7px;">仅限上传jpg,jpeg,bmp,png格式(图片大小小于1M)，推荐图片大小160*90</span> -->
							</div></li>
						<li class="clearfix"></li>
						<li class="clearfix"></li>
						<li class="clearfix"></li>
						<li class="clearfix"></li>
						<li class="clearfix"></li>
						<!-- <li><label>审核意见：</label>  -->
					</ul>
				</form>
				
				<!-- --------------------------------------------------------认证信息----------------------------------------- -->
			</div>
			<div role="tabpanel" class="tab-pane" id="profile" style="height: 300px;">
				<div style="margin-top:50px;margin-top: -33px;">
					<div style="overflow:-Scroll;overflow-y:hidden;height: 180px;">
					<form id="infoForm1"  class="breadcrumb form-search" style="background-color: white;" >
						<ul class="ul-form" style="">
							<li class="clearfix" style="list-style-type:none;"></li>
							<li><label
								style="">车牌号：</label> <input
								type="text" class="input-medium" style="width:163px"
								value="${users.truckNo}" readonly="readonly" /></li>
							<li><label
								style="">车型：</label> <input type="text"
								class="input-medium" style="width:163px"
								value="${users.truckType}" readonly="readonly" /></li>
							<li class="clearfix" style="list-style-type:none;"></li>
							
							<li><label >车长：</label> <input type="text"
								class="input-medium" value="${users.truckLength}"
								style="width:163px" readonly="readonly" />米</li>
							<li><label style="margin-left: -3.5px;">车宽：</label> <input type="text"
								class="input-medium" style="width:163px"
								value="${users.truckWidth}" readonly="readonly" />米</li>
							<li class="clearfix" style="list-style-type:none;"></li>
							<li><label>承重：</label> <input type="text"
								class="input-medium" value="${users.truckMaxwight}"
								style="width:163px" readonly="readonly" />吨</li>
							<li class="clearfix" style="list-style-type:none;"></li>
							</ul>
							
							</form>
							</div>
							<form id="infoForm2"  class="breadcrumb form-search" style="background-color: white;" >
							<ul class="ul-form" style="height:420px">
							<!-- 身份证图片 -->
							<li id="imagesCradNo" style=""><label style="width: 80px;">身份证照片：</label>
								<div id="images" style="height:124px;margin-left: 140px">
								<div style="border:1px solid #eee;width:120px;height:120px;float:left;">
									<img id="cardFaceImg" width="120" height="120" <c:if test="${users.cardFaceImg!=null&&users.cardFaceImg!=''}">src="<%=basePath%>${users.cardFaceImg}"</c:if> />
									</div>
								<div style="border:1px solid #eee;width:120px;height:120px;float: left">
									<img id="cardOtherImg" width="120" height="120" style="cursor: pointer;" <c:if test="${users.cardOtherImg!=null&&users.cardOtherImg!=''}">src="<%=basePath%>${users.cardOtherImg}"</c:if> />
								</div>
								</div>
								</li>
							    <select id="isTruename" name="isTruename" class="input-medium" style="margin-bottom: -280px; margin-left:145px">
										<option value="0" <c:if test="${users.isTruename!='1'}">selected</c:if>>身份证未认证</option>
										<option value="1" <c:if test="${users.isTruename=='1'}">selected</c:if>>身份证认证通过</option>
							    </select> 
								
							<!-- 添加驾驶证图片 -->
							<li id="imagesDriveLicence" style=""><label style="margin-top: 170px">驾驶证：</label>
								
										<div id="images" style="height:124px;margin-left: 140px">
											<div style="border:1px solid #eee;width:120px;height:120px;float:left;">
											<img id="driveLicenceImg1" width="120" height="120" style="cursor: pointer;"
												<c:if test="${users.driveLicenceImg1!=null&&users.driveLicenceImg1!=''}">src="<%=basePath%>${users.driveLicenceImg1}"</c:if> />
											</div>
											<div style="border:1px solid #eee;width:120px;height:120px;float:left;">
											<img id="driveLicenceImg2" width="120" height="120" style="cursor: pointer;"
												<c:if test="${users.driveLicenceImg2!=null&&users.driveLicenceImg2!=''}">src="<%=basePath%>${users.driveLicenceImg2}"</c:if> />
								 			</div>
										</div>
										</li>
										<li style="list-style-type:none;">
										<select id="isTrueDrive" name="isTrueDrive" class="input-medium" style="margin-left: 145px;margin-top: 298px;">
												<option value="0"
													<c:if test="${users.isTrueDrive!='1'}">selected</c:if>>驾驶证未认证</option>
												<option value="1"
													<c:if test="${users.isTrueDrive=='1'}">selected</c:if>>驾驶证认证通过</option>
											</select> 
								</li>
								<li class="clearfix"></li>
								</ul>
							</form>
							<!-- 行驶证图片 -->
							<form id="infoForm3"  class="breadcrumb form-search" style="background-color: white;" >
								<ul class="ul-form" style="height:200px">
								<li id="imagesDriverCard" style=""><label style="">行驶证：</label>
										<div id="images" style="height:124px;margin-left: 140px">
										<div style="border:1px solid #eee;width:120px;height:120px;float:left;">
											<img id="moveLicenceImg1" width="120" height="120" style="cursor: pointer;"
												<c:if test="${users.moveLicenceImg1!=null&&users.moveLicenceImg1!=''}">src="<%=basePath%>${users.moveLicenceImg1}"</c:if> />
										</div>
										<div style="border:1px solid #eee;width:120px;height:120px;float:left;">	
											<img id="moveLicenceImg2" width="120" height="120" style="cursor: pointer;"
												<c:if test="${users.moveLicenceImg2!=null&&users.moveLicenceImg2!=''}">src="<%=basePath%>${users.moveLicenceImg2}"</c:if> />
										</div>
										</div>
								</li>
											 <select id="isTrueMove" name="isTrueMove" class="input-medium" style="margin-left: 145px;margin-bottom: -270px;">
												<option value="0" <c:if test="${users.isTrueMove!='1'}">selected</c:if>>行驶证未认证</option>
												<option value="1" <c:if test="${users.isTrueMove=='1'}">selected</c:if>>行驶证认证通过</option>
											</select> 
						</ul>
						</form>
					</div>
				</div>
			</div>
				<span style="position:fixed; top:86%;left: 5%;">审核意见：<textarea style="width:450px" id="examineRemark" name="examineRemark"></textarea></span>
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
