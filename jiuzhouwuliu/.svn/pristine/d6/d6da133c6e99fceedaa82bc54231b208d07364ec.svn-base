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
<link rel="stylesheet" href="${ctxStatic}/image-viewer/css/viewer.min.css">
<title>编辑货主</title>
<meta name="decorator" content="default" />
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
			layer.alert('用户名不能为空!', {
				icon : 0
			});
			return;
		}
		if (username.length > 16) {
			layer.alert('用户名过长!', {
				icon : 0
			});
			return;
		}
		var password = $("#password").val();
		/* 	if(password==""){
				layer.alert('密码不能为空!', {icon: 0}); 
			return;
			} */
		if (password.length > 16) {
			layer.alert('密码过长!', {
				icon : 0
			});
			return;
		}

		var password1 = $("#password1").val();
		/* if(password1==""){
			layer.alert('请确认密码!', {icon: 0}); 
		return;
		} */
		if (password1 != password) {
			layer.alert('2次输入密码不同，请重新输入!', {
				icon : 0
			});
			return;
		}

		var phone = document.getElementById('phoneno').value;
		/*   		  if(phone==""||phone==null){
		  		  layer.alert('请输入手机号!', {icon: 0}); 
		  		  return;
		  		  }
		        if(!(/^1(3|4|5|7|8)\d{9}$/.test(phone))){ 
		        layer.alert('手机号码有误!', {icon: 0}); 
		        return false; 
		    }   */

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
		var identityType = $("#identityType").val();
		if (identityType == '1') {
			var companyName = $("#companyName").val();
			if (companyName == "") {
				layer.alert('请输入企业名称!', {
					icon : 0
				});
				return;
			}
		}
		var form = $('#infoForm');
		var options = {
			url : '${ctx}/goodsowner/goodsowner/update',
			type : 'post',
			data : {
				companyName : companyName,
				identityType : identityType
			},
			success : function(data) {
				if (data.status) {
					layer.alert(data.msg, {
						icon : 1,
						shade : 0
					}, function(index) {
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
			Img : "businessLicenseFaceImg",
			Width : 120,
			Height : 120
		});
		$("#upImage2").uploadPreview({
			Img : "businessLicenseOtherImg",
			Width : 120,
			Height : 120
		});
		$("#upImage3").uploadPreview({
			Img : "cardFaceImg",
			Width : 120,
			Height : 120
		});
		$("#upImage4").uploadPreview({
			Img : "cardOtherImg",
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
				$('#businessLicenseFaceImg').show();
				window.clearInterval(st);
			}
		}, 100);
	}
	function addImg2() {
		$("#upImage2").click();
		var st = window.setInterval(function() {
			if ($("#upImage2").val() != "") {
				$('#businessLicenseOtherImg').show();
				window.clearInterval(st);
			}
		}, 100);
	}
	function addImg3() {
		$("#upImage3").click();
		var st = window.setInterval(function() {
			if ($("#upImage3").val() != "") {
				$('#cardFaceImg').show();
				window.clearInterval(st);
			}
		}, 100);
	}
	function addImg4() {
		$("#upImage4").click();
		var st = window.setInterval(function() {
			if ($("#upImage4").val() != "") {
				$('#cardOtherImg').show();
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
</script>
<style type="text/css">
.form-search .ul-form li label {
	width: 120px;
	text-align: right;
}

.gun {
	overflow-x: hidden;
	overflow-y: auto;
}

.imgClass {
	width: 120px;
	height: 120px;
	cursor: pointer;
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
					<input type="text" id="id" name="id" value="${users.id}" style="display:none" />
					<!-------------------------------------基本信息--------------------------------------------------------------  -->
					<ul class="ul-form" style="height:450px;">
						<li><label>用户名：</label> <input type="text" id="username" name="username" maxlength="50" class="input-medium" style="width:163px"
							value="${users.username}" /> <span class="help-inline"><font color="red">*</font> </span></li>
						<li class="clearfix"></li>
						<li><label>密码：</label> <input type="password" id="password" name="password" maxlength="50" class="input-medium" style="width:163px" /> <span
							class="help-inline"><font color="red">*</font> </span> <c:if test="${not empty users.id}">
								<span class="help-inline">若不修改密码，请留空。</span>
							</c:if></li>
						<li class="clearfix"></li>
						<li><label>确认密码：</label> <input type="password" id="password1" name="password1" maxlength="50" class="input-medium" style="width:163px" />
							<span class="help-inline"><font color="red">*</font> </span></li>
						<li class="clearfix"></li>
						<li><label>手机：</label> <input type="text" id="phoneno" name="phoneno" maxlength="50" class="input-medium" style="width:163px"
							value="${users.phoneno}" readonly="readonly" onkeyup="keyupInput(this);" /> <span class="help-inline"><font color="red">*</font> </span></li>
						<li class="clearfix"></li>
						<li><label>姓名：</label> <input type="text" id="truename" name="truename" maxlength="50" class="input-medium" style="width:163px"
							value="${users.truename}" /> <span class="help-inline"><font color="red">*</font> </span></li>
						<li class="clearfix"></li>
						<li><label>身份证号：</label> <input type="text" id="cardno" name="cardno" maxlength="50" class="input-medium" style="width:163px"
							value="${users.cardno}" /> <span class="help-inline"><font color="red">*</font> </span></li>
						<li class="clearfix"></li>
						<li><label>状态：</label> <select id="status" name="status" class="input-medium" style="width: 177px;">
								<c:forEach items="${usersStatus}" var="t">
									<option value="${t.value}" ${t.value==users.status? 'selected':''}>${t.label}</option>
								</c:forEach>
						</select> <span class="help-inline"><font color="red">*</font> </span></li>
						<li class="clearfix"></li>
						<li><label>支付积分：</label> <input type="text" id="currentPoint" name="currentPoint" maxlength="10" class="input-medium"
							onkeyup="keyupInput(this);" readonly="readonly" value="${users.currentPoint}" /> <!-- <span class="help-inline"><font color="red">*</font> </span> -->
						</li>
						<li class="clearfix"></li>
						<li><label>等级：</label> <select id="level" name="level" class="input-medium" style="width: 177px;">
								<c:forEach items="${goodsLevel}" var="t">
									<option value="${t.value}" ${t.value==users.level? 'selected':''}>${t.label}</option>
								</c:forEach>
						</select> <span class="help-inline"><font color="red">*</font> </span></li>
						<li><label style="margin-right: 400px;margin-top: 35px;">头像：</label>
							<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 140px;margin-top: -50px;">
								<img id="headImg" class="imgClass" src="${users.headImg}"/> <input
									class="btn btn-primary" type="button" style="margin-left: 135px;margin-top: -60px;" value="添加图片" onclick="NewFile();" />
							</div></li>
					</ul>
					<!-- 头像图片 -->
					<input id="upImage" type="file" name="headImg_file" style="display:none" />
					<!-- 营业执照片 -->
					<input id="upImage1" type="file" name="businessLicenseFaceImg_file" style="display:none" />
					<input id="upImage2" type="file" name="businessLicenseOtherImg_file" style="display:none" />
					<!-- 身份证 -->
					<input id="upImage3" type="file" name="cardFaceImg_file" style="display:none" />
					<input id="upImage4" type="file" name="cardOtherImg_file" style="display:none" />
					<!-- --------------------------------------------------------认证信息----------------------------------------- -->
				</div>
				<div role="tabpanel" class="tab-pane" id="profile">
					<div style="overflow:-Scroll;overflow-y:hidden;height: 470px;">
						<ul class="ul-form" style="height:470px;">
							<li><label>企业名称：</label> <input type="text" id="companyName" name="companyName" maxlength="50" class="input-medium" style="width:163px"
								value="${goodsowners.companyName}" /> <span class="help-inline"><font color="red">*</font> </span>
							<li class="clearfix"></li>
							<li><label>身份：</label> <select id="identityType" name="identityType" class="input-medium" style="width: 177px;">
									<c:forEach items="${goodsownersIdentityType}" var="t">
										<option value="${t.value}" ${t.value==goodsowners.identityType? 'selected':''}>${t.label}</option>
									</c:forEach>
							</select> <span class="help-inline"><font color="red">*</font> </span></li>
							<li class="clearfix"></li>
							<li id="imagesCompany"><label style="text-align:left;width:100%;padding-left: 50px">营业执照：</label>
								<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 85px;margin-top: -1px;">
									<img id="businessLicenseFaceImg" class="imgClass" src="${goodsowners.businessLicenseFaceImg}" />
									<div style="width: 124px;height: 43px;margin-top: -130px;">
										<input class="btn btn-primary" type="button" style="margin-left: 0px;margin-top: 138px;" value="营业执照正面" onclick="addImg1();" />
									</div>
								</div>
								<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 215px;margin-top: -122px;">
									<img id="businessLicenseOtherImg" class="imgClass" src="${goodsowners.businessLicenseOtherImg}" />
									<div style="width: 124px;height: 43px;margin-top: -130px;">
										<input class="btn btn-primary" type="button" style="margin-left: 0px;margin-top: 138px;" value="营业执照反面" onclick="addImg2();" />
									</div>
								</div>
								<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 346px;margin-top: -122px;">
									<img src="<%=basePath%>static/images/6.jpg" class="imgClass" />
								</div>
								<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 477px;margin-top: -122px;">
									<img src="<%=basePath%>static/images/6.jpg" class="imgClass" />
								</div></li>
							<li id="imagesCradNo" style="margin-top: 155px;"><label style="text-align:left;width:100%;padding-left: 50px">身份证：</label>
								<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 85px;margin-top: -1px;">
									<img id="cardFaceImg" class="imgClass" src="${users.cardFaceImg}" />
									<div style="width: 124px;height: 43px;margin-top: -130px;">
										<input class="btn btn-primary" type="button" style="margin-left: 0px;margin-top: 138px;" value="身份证正面" onclick="addImg3();" />
									</div>
								</div>
								<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 215px;margin-top: -122px;">
									<img id="cardOtherImg" class="imgClass" src="${users.cardOtherImg}" />
									<div style="width: 124px;height: 43px;margin-top: -130px;">
										<input class="btn btn-primary" type="button" style="margin-left: 0px;margin-top: 138px;" value="身份证反面" onclick="addImg4();" />
									</div>
								</div>
								<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 346px;margin-top: -122px;">
									<img src="<%=basePath%>static/images/1.jpg" class="imgClass" />
								</div>
								<div style="border:1px solid #eee;width:120px;height:120px;margin-left: 477px;margin-top: -122px;">
									<img src="<%=basePath%>static/images/2.jpg" class="imgClass" />
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
		//企业资质图片放大
		var viewer1 = new Viewer(document.getElementById('imagesCompany'), {
			url : 'src'
		});
	</script>
</body>
</html>
