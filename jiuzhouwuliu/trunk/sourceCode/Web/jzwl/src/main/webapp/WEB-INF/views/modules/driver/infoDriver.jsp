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
<title>基本信息---添加</title>
<meta name="decorator" content="default" />
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
	var status = false;
	function doSubmit() {
		if (status == true || status == "true") {
			return false;
		}
		var username = $("#username").val();
		if (username == "") {
			layer.alert('昵称不能为空!', {
				icon : 0
			});
			return;
		}
		if (username.length > 16) {
			layer.alert('昵称过长!', {
				icon : 0
			});
			return;
		}
		var password = $("#password").val();
		if (password == "") {
			layer.alert('密码不能为空!', {
				icon : 0
			});
			return;
		}
		if (password.length > 16) {
			layer.alert('密码过长!', {
				icon : 0
			});
			return;
		}

		var password1 = $("#password1").val();
		if (password1 == "") {
			layer.alert('请确认密码!', {
				icon : 0
			});
			return;
		}
		if (password1 != password) {
			layer.alert('2次输入密码不同，请重新输入!', {
				icon : 0
			});
			return;
		}

		var phone = document.getElementById('phoneno').value;
		if (phone == "" || phone == null) {
			layer.alert('请输入手机号!', {
				icon : 0
			});
			return;
		}
		if (!(/^1(3|4|5|7|8)\d{9}$/.test(phone))) {
			layer.alert('手机号码有误!', {
				icon : 0
			});
			return false;
		}

		var truename = $("#truename").val();
		if (truename == "") {
			layer.alert('姓名不能为空!', {
				icon : 0
			});
			return;
		}
		if (truename.length > 16) {
			layer.alert('姓名过长!', {
				icon : 0
			});
			return;
		}
		var cardn = document.getElementById('cardno').value;
		if (cardn == "" || cardn == null) {
			layer.alert('请输入身份证号!', {
				icon : 0
			});
			return;
		}
		if (!(/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/.test(cardn))) {
			layer.alert("身份证号有误!");
			return false;
		}
		var status = $("#status").val();
		if (status == "") {
			layer.alert('请选择状态!', {
				icon : 0
			});
			return;
		}
		/* 	  var fleetName=$("#driveFleetId").val();
			if(fleetName==null || fleetName=="" ){
				layer.alert('请选择所属车队!', {icon: 0}); 
			return;
			} */

		var level = $("#level").val();
		if (level == "") {
			layer.alert('请选择等级!', {
				icon : 0
			});
			return;
		}
		var truckN = /^[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}$/;
		if (window.document.getElementById("truckNo").value.search(truckN) == -1) {
			layer.alert('请输入有效的车牌号!', {
				icon : 0
			});
			return false;
		}
		var truckType = $("#truckType").val();
		if (truckType == "") {
			layer.alert('请输入车型!', {
				icon : 0
			});
			return;
		}

		/* 	var truckHeight=$("#truckHeight").val();
			if(truckHeight==""){
			layer.alert('请输入车高!', {icon: 0}); 
		return;
			} */
		var truckLength = $("#truckLength").val();
		/* 	if(truckLength==""){
			layer.alert('请输入车长!', {icon: 0}); 
		return;
			} */
		var truckMaxwight = $("#truckMaxwight").val();
		/* 	if(truckMaxwight==""){
			layer.alert('请输入承重!', {icon: 0}); 
		return;
			} */
		var truckWidth = $("#truckWidth").val();
		/* 	if(truckWidth==""){
			layer.alert('请输入车宽!', {icon: 0}); 
		return;
			} */
		var form = $('#infoForm');
		var options = {
			url : '${ctx}/driver/driverList/saveDriver',
			type : 'post',
			data : {},
			success : function(data) {
				//alert(JSON.stringify(data));
				if (data.status) {
					layer.alert(data.msg, {
						icon : 1,
						shade : 0
					}, function(index) {
						//$("#id").val(data.data.id);
						//$('#newFileForm2').submit();
						parent.location.reload(); // 父页面刷新 
					});
				} else {
					layer.alert(data.msg, {
						icon : 2,
						shade : 0
					});
				}
			}
		};
		form.ajaxSubmit(options);
	}
	function setIframeWidth() {
		$("iframe").each(function() {
			$(this).width("100%");
		})
	}
	/*-----------------上传头像图片开始--------------*/
	$(function() {
		$("#upImage").uploadPreview({
			Img : "headImg",
			Width : 120,
			Height : 120
		});
		$("#upImage1").uploadPreview({
			Img : "cardFaceImg",
			Width : 120,
			Height : 120
		});
		$("#upImage2").uploadPreview({
			Img : "cardOtherImg",
			Width : 120,
			Height : 120
		});
		$("#upImage3").uploadPreview({
			Img : "driveLicenceImg1",
			Width : 120,
			Height : 120
		});
		$("#upImage4").uploadPreview({
			Img : "driveLicenceImg2",
			Width : 120,
			Height : 120
		});
		$("#upImage5").uploadPreview({
			Img : "moveLicenceImg1",
			Width : 120,
			Height : 120
		});
		$("#upImage6").uploadPreview({
			Img : "moveLicenceImg2",
			Width : 120,
			Height : 120
		});
	});
	function NewFile() {
		$("#upImage").click();
		var st = window.setInterval(function() {
			if ($("#upImage").val() != "") {
				$('#headImg').show();
				window.clearInterval(st);
			}
		}, 100);
	}
	function addImg1() {
		$("#upImage1").click();
		var st = window.setInterval(function() {
			if ($("#upImage1").val() != "") {
				$('#cardFaceImg').show();
				window.clearInterval(st);
			}
		}, 100);
	}
	function addImg2() {
		$("#upImage2").click();
		var st = window.setInterval(function() {
			if ($("#upImage2").val() != "") {
				$('#cardOtherImg').show();
				window.clearInterval(st);
			}
		}, 100);
	}
	function addImg3() {
		$("#upImage3").click();
		var st = window.setInterval(function() {
			if ($("#upImage3").val() != "") {
				$('#driveLicenceImg1').show();
				window.clearInterval(st);
			}
		}, 100);
	}
	function addImg4() {
		$("#upImage4").click();
		var st = window.setInterval(function() {
			if ($("#upImage4").val() != "") {
				$('#driveLicenceImg2').show();
				window.clearInterval(st);
			}
		}, 100);
	}
	function addImg5() {
		$("#upImage5").click();
		var st = window.setInterval(function() {
			if ($("#upImage5").val() != "") {
				$('#moveLicenceImg1').show();
				window.clearInterval(st);
			}
		}, 100);
	}
	function addImg6() {
		$("#upImage6").click();
		var st = window.setInterval(function() {
			if ($("#upImage6").val() != "") {
				$('#moveLicenceImg2').show();
				window.clearInterval(st);
			}
		}, 100);
	}
	/*---------------头像图片上传结束-------------*/
	//限制只能输入数字
	function keyupInput(obj) {
		if (event.keyCode == 37 || event.keyCode == 39) {//左 、右键

		} else {
			obj.value = obj.value.replace(/[^0-9]/g, '');
		}
	}
	//限制只能输入正数小数
	function keyupInput1(obj) {
		if (event.keyCode == 37 || event.keyCode == 39) {//左 、右键

		} else {
			obj.value = obj.value.replace(/[^\d.]/g, '');
		}
	}
</script>
<style type="text/css">
.form-search .ul-form li label {
	width: 95px;
	text-align: right;
}

.gun {
	overflow-x: hidden;
	overflow-y: auto;
}
</style>
</head>

<body>

	<div style="text-align: center">
		<ul class="nav nav-tabs" role="tablist" style="margin:10px 10px 10px 10px">
			<li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab" onClick="setIframeWidth();">基本信息</a></li>
			<li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab" onClick="setIframeWidth();">认证信息</a></li>
		</ul>
		<!-- Tab panes -->
		<form id="infoForm" method='post' class="breadcrumb form-search" style="background-color: white;" enctype="multipart/form-data">
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="home">
					<input type="text" id="id" name="id" value="" style="display:none" />
					<!-------------------------------------基本信息--------------------------------------------------------------  -->
					<ul class="ul-form" style="height:370px;">
						<li><label>昵称：</label> <input type="text" id="username" name="username" maxlength="100" class="input-medium" style="width:163px" /> <span
							class="help-inline"><font color="red">*</font> </span></li>
						<li><label>姓名：</label> <input type="text" id="truename" name="truename" maxlength="100" class="input-medium" style="width:163px" /> <span
							class="help-inline"><font color="red">*</font> </span></li>
						<li class="clearfix"></li>
						<li><label>密码：</label> <input type="password" id="password" name="password" maxlength="100" class="input-medium" style="width:163px" /> <span
							class="help-inline"><font color="red">*</font> </span></li>
						<li><label>确认密码：</label> <input type="password" id="password1" name="password1" maxlength="100" class="input-medium" style="width:163px" />
							<span class="help-inline"><font color="red">*</font> </span></li>
						<li class="clearfix"></li>
						<li><label>手机：</label> <input type="text" id="phoneno" name="phoneno" maxlength="100" class="input-medium" style="width:163px" /> <span
							class="help-inline"><font color="red">*</font> </span></li>
						<li><label>身份证号：</label> <input type="text" id="cardno" name="cardno" maxlength="100" class="input-medium" style="width:163px" /> <span
							class="help-inline"><font color="red">*</font> </span></li>
						<li class="clearfix"></li>
						<li><label>状态：</label> <select id="status" name="status" class="input-medium" style="width: 177px;">
								<option value="0">正常</option>
								<option value="1">锁定</option>
						</select> <span class="help-inline"><font color="red">*</font> </span></li>
						<li><label>所属车队：</label> <select id="driveFleetId" name="driveFleetId" class="input-medium" style="width: 177px;">
								<option value="">不限</option>
								<c:forEach items="${DriveFleetList}" var="t">
									<option value="${t.id}">${t.fleetName}</option>
								</c:forEach>
						</select></li>
						<li class="clearfix"></li>
						<li><label>支付积分：</label> <input type="text" id="currentPoint" name="currentPoint" value="0" maxlength="10" class="input-medium" style="width:163px"
							onkeyup="keyupInput(this);" /></li>
						<li><label style="margin-left: 24px;">等级：</label> <select id="level" name="level" class="input-medium" style="width: 177px;">
								<option value="0">外部</option>
								<option value="1">内部</option>
						</select> <span class="help-inline"><font color="red">*</font> </span></li>
						<li><label style="margin-right: 400px;margin-top: 35px;">头像：</label>
							<div style="border:1px solid #eee;width:120px;height:120px;cursor: pointer;margin-left: 140px;margin-top: -50px;">
								<img id="headImg" style="width:120; height:120px;"
									src=""/> <input class="btn btn-primary"
									type="button" style="margin-left: 135px;margin-top: -60px;" value="添加图片" onclick="NewFile();" /> 
									<span class="label label-info" style=" margin-left: 0px;">仅限上传jpg,jpeg,bmp,png格式(图片大小小于1M)，推荐图片大小120*120</span>
							</div></li>
					</ul>
					<!-- 头像图片 -->
					<input id="upImage" type="file" name="headImg_file" style="display:none" />
					<!-- 身份证图片 -->
					<input id="upImage1" type="file" name="cardFaceImg_file" style="display:none" /> <input id="upImage2" type="file" name="cardOtherImg_file"
						style="display:none" />
					<!-- 驾驶证图片 -->
					<input id="upImage3" type="file" name="driveLicenceImg1_file" style="display:none" /> <input id="upImage4" type="file"
						name="driveLicenceImg2_file" style="display:none" />
					<!-- 行驶证图片 -->
					<input id="upImage5" type="file" name="moveLicenceImg1_file" style="display:none" /> <input id="upImage6" type="file"
						name="moveLicenceImg2_file" style="display:none" />
					<!-- --------------------------------------------------------认证信息----------------------------------------- -->
				</div>
				<div role="tabpanel" class="tab-pane" id="profile">
					<div style="overflow:-Scroll;overflow-y:hidden;height: 800px;">
						<ul class="ul-form" style="height:750px;">
							<li><label>车牌号：</label> <input type="text" id="truckNo" name="truckNo" maxlength="100" placeholder="如:京A88888" class="input-medium" style="width:163px"
								value="" /> <span class="help-inline"><font color="red">*</font> </span></li>
							<li><label>车型：</label> <select id="truckType" name="truckType" class="input-medium" style="width: 177px;">
									<option value="">不限</option>
									<c:forEach items="${truckType}" var="t">
										<option value="${t.value}" >${t.label}</option>
									</c:forEach>
							</select></li>
							<li class="clearfix"></li>
							<li><label>车长：</label> <select id="truckLength" name="truckLength" class="input-medium" style="width: 177px;">
									<c:forEach items="${truckLength}" var="t">
										<option value="${t.value}" >${t.label}</option>
									</c:forEach>
							</select></li>
							<li><label style="margin-left: 24px">车宽：</label> <select id="truckWidth" name="truckWidth" class="input-medium" style="width: 177px;">
									<c:forEach items="${truckWidth}" var="t">
										<option value="${t.value}">${t.label}</option>
									</c:forEach>
							</select></li>
							<li class="clearfix"></li>
							<%--  <li  >
		   	  	<label style="margin-left: -126px;">承重：</label>
		   		<select id="truckMaxwight" name="truckMaxwight"  class="input-medium"  style="width: 177px;">
		   			<c:forEach items="${truckMaxwight}" var="t">
		   			<option value="${t.value}" <c:if test="${t.value==drivers.truckMaxwight}">selected</c:if>>${t.label}</option>
		   			</c:forEach>
		   		</select>&nbsp;&nbsp;吨
		   	</li> --%>
							<li><label style="margin-top: 10px;">承重：</label> <input type="text" id="truckMaxwight" name="truckMaxwight" maxlength="50"
								class="input-medium" value="0" onkeyup="keyupInput1(this);" style="width:163px" value="" />&nbsp;&nbsp;吨</li>

							<!-- 添加身份证图片 -->
							<li id="imagesCradNo"><label style="text-align:left;width:100%;padding-left:50px">身份证照片：</label>
								<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 85px;margin-top: -1px;">
									<img id="cardFaceImg" style="width:120px;height:120px;cursor: pointer;" src="" />
									<div style="width: 124px;height: 43px;margin-top: -130px;">
										<input class="btn btn-primary" type="button" style="margin-left: 0px;margin-top: 138px;" value="身份证正面" onclick="addImg1();" />
									</div>
								</div>
								<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 215px;margin-top: -122px;">
									<img id="cardOtherImg" style="width:120px;height:120px;cursor: pointer;" src="" />
									<div style="width: 124px;height: 43px;margin-top: -130px;">
										<input class="btn btn-primary" type="button" style="margin-left: 0px;margin-top: 138px;" value="身份证反面" onclick="addImg2();" />
									</div>
								</div>
								<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 346px;margin-top: -122px;">
									<img src="<%=basePath%>static/images/1.jpg" style="width:120px;height:120px;cursor: pointer;" />
								</div>
								<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 477px;margin-top: -122px;">
									<img src="<%=basePath%>static/images/2.jpg" style="width:120px;height:120px;cursor: pointer;" />
								</div></li>
							<li id="imagesDriveLicence" style="margin-top: 155px;"><label style="text-align:left;width:100%;padding-left:50px">驾驶证：</label>
								<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 85px;margin-top: -1px;">
									<img id="driveLicenceImg1" style="width:120px;height:120px;cursor: pointer;" src="" />
									<div style="width: 124px;height: 43px;margin-top: -130px;">
										<input class="btn btn-primary" type="button" style="margin-left: 0px;margin-top: 138px;" value="驾驶证正面" onclick="addImg3();" />
									</div>
								</div>
								<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 215px;margin-top: -122px;">
									<img id="driveLicenceImg2" style="width:120px;height:120px;cursor: pointer;" src="" />
									<div style="width: 124px;height: 43px;margin-top: -130px;">
										<input class="btn btn-primary" type="button" style="margin-left: 0px;margin-top: 138px;" value="驾驶证反面" onclick="addImg4();" />
									</div>
								</div>
								<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 346px;margin-top: -122px;">
									<img src="<%=basePath%>static/images/3.jpg" style="width:120px;height:120px;cursor: pointer;" />
								</div></li>
							<li id="imagesDriverCard" style="margin-top: 155px;"><label style="text-align:left;width:100%;padding-left:50px">行驶证：</label>
								<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 85px;margin-top: -1px;">
									<img id="moveLicenceImg1" style="width:120px;height:120px;cursor: pointer;" src="" />
									<div style="width: 124px;height: 43px;margin-top: -130px;">
										<input class="btn btn-primary" type="button" style="margin-left: 0px;margin-top: 138px;" value="行驶证正面" onclick="addImg5();" />
									</div>
								</div>
								<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 215px;margin-top: -122px;">
									<img id="moveLicenceImg2" style="width:120px;height:120px;cursor: pointer;" src="" />
									<div style="width: 124px;height: 43px;margin-top: -130px;">
										<input class="btn btn-primary" type="button" style="margin-left: 0px;margin-top: 138px;" value="行驶证反面" onclick="addImg6();" />
									</div>
								</div>
								<div style="border:1px solid #eee2;width:120px;height:120px;margin-left: 346px;margin-top: -122px;">
									<img src="<%=basePath%>static/images/4.jpg" style="width:120px;height:120px;cursor: pointer;" />
								</div></li>
						</ul>
					</div>
				</div>
			</div>
		</form>
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
