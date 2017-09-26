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
<title>订单详情</title>
<meta name="decorator" content="default" />
<!-- 引入layer插件 -->
<link rel="stylesheet" href="${ctxStatic}/layer-v2.0/layer/skin/layer.css">
<link rel="stylesheet" href="${ctxStatic}/image-viewer/css/viewer.min.css">
<script src="${ctxStatic}/layer-v2.0/layer/layer.js"></script>
<script src="${ctxStatic}/layer-v2.0/layer/laydate/laydate.js"></script>
<script type="text/javascript" src="${ctxStatic}/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctxStatic}/jquery/jquery.form.js"></script>
<script type="text/javascript">
	//回调函数，在编辑和保存动作时，供openDialog调用提交表单
	var htmlstatus = false;
	function doSubmit(status) {
		if (htmlstatus == true || htmlstatus == "true") {
			return false;
		}
		var examRemark = "";
		if (status == '2') {
			examRemark = $("#examRemark").val();
			if (examRemark == null || examRemark.trim() == "") {
				layer.alert('请输入审核意见', {
					icon : 3
				});
				return;
			}
		}
		$.ajax({
			type : 'POST',
			url : "${ctx}/users/highValuationOfGoods/highValuationOfGoodsCheck",
			data : {
				id : $("#id").val(),
				isExamPass : status,
				examRemark : examRemark
			},
			dataType : "json",
			success : function(data) {
				htmlstatus = data.status;
				layer.alert(data.msg, {
					icon : 1,
					shade : 0
				}, function(index) {
					parent.location.reload(); // 父页面刷新  
				});
			},
			error : function(e) {
				layer.alert("操作失败", {
					icon : 1,
					shade : 0
				})

			}
		})
	}
</script>
<style type="text/css">
/* select, textarea, input[type="text"], input[type="password"], input[type="datetime"], input[type="datetime-local"], input[type="date"], input[type="month"], input[type="time"], input[type="week"], input[type="number"], input[type="email"], input[type="url"], input[type="search"], input[type="tel"], input[type="color"], .uneditable-input{
			height: 30px;
		} */
.form-search .ul-form li label {
	width: 140px;
	text-align: right;
}

.lispan {
	height:auto;
	word-break:break-all;
	word-wrap : break-word ;
	width: 170px;
	float: right;
	text-align: left;
	margin-left: 3px
}

.detailspan {
	height:auto; 
	word-break:break-all;
	word-wrap : break-word ;
	width: 60px;
	float: right;
	text-align: left;
	margin-left: 3px
}
li.clearfix {
	float: none;
}
</style>
</head>

<body>

	<div style="text-align: center">
		<div class="tab-content">
			<div role="tabpanel" class="tab-pane active" id="home">
				<form id="infoForm" method='post' class="breadcrumb form-search" style="background-color: white;" enctype="multipart/form-data">
					<div style="border:1px solid #ccc;position:relative;">
						<div class="title"
							style="width:100px;height:25px;position:absolute;top:-12px;left:40px;background-color:#ffffff;line-height:25px;text-align:center;">基本信息</div>
						<ul class="ul-form" style="margin-top: 20px;margin-bottom: 10px;">
							<li><label>订单编号：</label> ${goods.orderNo }</li>
							<li><label>下单时间：</label> <fmt:formatDate value='${goods.createDate}' pattern='yyyy-MM-dd HH:mm:ss' /></li>
							<li><label>订单状态：</label> ${goods.orderStatus }</li>
						</ul>
					</div>
					<div style="border:1px solid #ccc;position:relative;margin-top:20px;">
						<div class="title"
							style="width:100px;height:25px;position:absolute;top:-12px;left:40px;background-color:#ffffff;line-height:25px;text-align:center;">货物信息</div>
						<ul id="dataShowUl" class="ul-form" style="margin-top: 20px;margin-bottom: 10px;">
							<li><label>货物类型：</label> <span class="lispan">${goods.goodsType }</span></li>
							<li><label>发货地详细地址：</label> <span class="lispan">${goods.shipperAreaDetail }</span></li>
							<li><label>收货地详细地址：</label> <span class="lispan">${goods.reciverAreaDetail }</span></li>
							<li><label>收货手机号码：</label> <span class="lispan">${goods.reciverTel }</span></li>
							<li><label>类型（保险）：</label> <span class="lispan">${goods.insuranceType }</span></li>
							<li><label>货物单位：</label> <span class="lispan">${goods.goodsNum } ${goods.goodsUnit }</span></li>
							<li><label>需求车型：</label> <span class="lispan">${goods.needTruckType }</span></li>
							<c:choose>
								<c:when test="${fn:length(imgList)==0}">
								</c:when>
								<c:when test="${fn:length(imgList)<4}">
									<li style="height:110px;width:99%;text-align:left"><label>货物图片：</label>
									<c:forEach items="${imgList}" var="i">
										<img src="${ctxStatic}/${i}"  data-original="${ctxStatic}/${i}" style="width:120px; height:100px;cursor:pointer" alt="${i == null || i == '' ? '暂无图片' : ''}">
									</c:forEach>
									</li>
								</c:when>
								<c:otherwise>
									<li style="height:110px;"><label>货物图片：</label>
									<c:forEach items="${imgList}" var="i" end="3">
										<img src="${ctxStatic}/${i}"  data-original="${ctxStatic}/${i}" style="width:120px; height:100px;cursor:pointer" alt="${i == null || i == '' ? '暂无图片' : ''}">
									</c:forEach>
									</li>
									<li style="height:110px;"><label></label>
									<c:forEach items="${imgList}" var="i" begin="4">
										<img src="${ctxStatic}/${i}"  data-original="${ctxStatic}/${i}" style="width:120px; height:100px;cursor:pointer" alt="${i == null || i == '' ? '暂无图片' : ''}">
									</c:forEach>
									</li>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
					<div style="border:1px solid #ccc;position:relative;margin-top:20px;">
						<div class="title"
							style="width:100px;height:25px;position:absolute;top:-12px;left:40px;background-color:#ffffff;line-height:25px;text-align:center;">货主信息</div>
						<ul class="ul-form" style="margin-top: 20px;margin-bottom: 10px;">
							<li><label>用户名：</label> <span class="lispan">${u.username }</span></li>
							<li><label>姓名：</label> <span class="lispan">${u.truename }</span></li>
							<li><label>手机号：</label> <span class="lispan">${u.phoneno }</span></li>
							<li><label>历史发货：</label> <span class="lispan">${u.sendCount }</span></li>
						</ul>
					</div>
					<div style="border:1px solid #ccc;position:relative;margin-top:20px;">
						<div class="title"
							style="width:100px;height:25px;position:absolute;top:-12px;left:40px;background-color:#ffffff;line-height:25px;text-align:center;">竞价车主信息</div>
						<ul class="ul-form" style="margin-top: 20px;margin-bottom: 10px;">
							<c:choose>
								<c:when test="${fn:length(completePriceDriverInfo)==0}">
									<li style="width:100%;text-align:center">暂无车主竞价信息。</li>
								</c:when>
								<c:otherwise>
									<c:forEach items="${completePriceDriverInfo}" var="c">
										<li><label style="width:100px;">用户名：</label> <span class="detailspan">${c.username }</span></li>
										<li><label style="width:100px;">姓名：</label> <span class="detailspan">${c.truename }</span></li>
										<li><label style="width:100px;">手机号：</label> <span class="detailspan">${c.phoneno }</span></li>
										<li><label style="width:100px;">历史接单：</label> <span class="detailspan">${c.reciveCont }</span></li>
									</c:forEach>
								</c:otherwise>
							</c:choose>

						</ul>
					</div>
					<div style="border:1px solid #ccc;position:relative;margin-top:20px;">
						<div class="title"
							style="width:100px;height:25px;position:absolute;top:-12px;left:40px;background-color:#ffffff;line-height:25px;text-align:center;">竞价经纪人信息</div>
						<ul class="ul-form" style="margin-top: 20px;margin-bottom: 10px;">
							<c:choose>
								<c:when test="${fn:length(completePriceAgentInfo)==0}">
									<li style="width:100%;text-align:center">暂无经纪人竞价信息。</li>
								</c:when>
								<c:otherwise>
									<c:forEach items="${completePriceAgentInfo}" var="c">
										<li><label style="width:60px;">用户名：</label> <span class="detailspan">${c.username }</span></li>
										<li><label style="width:60px;">姓名：</label> <span class="detailspan">${c.truename }</span></li>
										<li><label style="width:60px;">手机号：</label> <span class="detailspan">${c.phoneno }</span></li>
										<li><label style="width:90px;">历史发货：</label> <span class="detailspan">${c.sendCount }</span></li>
										<li><label style="width:80px;">历史接单：</label> <span class="detailspan">${c.reciveCont }</span></li>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
					<div style="border:1px solid #ccc;position:relative;margin-top:20px;">
						<div class="title"
							style="width:100px;height:25px;position:absolute;top:-12px;left:40px;background-color:#ffffff;line-height:25px;text-align:center;">运货车主信息</div>
						<ul class="ul-form" style="margin-top: 20px;margin-bottom: 10px;">
							<c:choose>
								<c:when test="${fn:length(orderDriverInfoList)==0}">
									<li style="width:100%;text-align:center">暂无运货车主信息。</li>
								</c:when>
								<c:otherwise>
									<c:forEach items="${orderDriverInfoList}" var="c">
										<li><label style="width:100px;">用户名：</label> <span class="detailspan">${c.username }</span></li>
										<li><label style="width:100px;">姓名：</label> <span class="detailspan">${c.truename }</span></li>
										<li><label style="width:100px;">手机号：</label> <span class="detailspan">${c.phoneno }</span></li>
										<li><label style="width:100px;">历史接单：</label> <span class="detailspan">${c.reciveCont }</span></li>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
					<div style="border:1px solid #ccc;position:relative;margin-top:20px;">
						<div class="title"
							style="width:100px;height:25px;position:absolute;top:-12px;left:40px;background-color:#ffffff;line-height:25px;text-align:center;">货主支付信息</div>
						<ul class="ul-form" style="margin-top: 20px;margin-bottom: 10px;">
							<li><label>支付方式：</label> <span class="lispan">${u.payStyle }</span></li>
							<li><label>支付单号：</label> <span class="lispan">${u.payId }</span></li>
							<li><label>支付时间：</label> <span class="lispan"><fmt:formatDate value="${u.payTime }" pattern="yyyy-MM-dd" /></span></li>
							<li><label>订单金额：</label> <span class="lispan">${u.dealMoney }</span></li>
							<li><label>支付金额：</label> <span class="lispan">${u.payMoney }</span></li>
						</ul>
					</div>
					<div style="border:1px solid #ccc;position:relative;margin-top:20px;">
						<div class="title"
							style="width:100px;height:25px;position:absolute;top:-12px;left:40px;background-color:#ffffff;line-height:25px;text-align:center;">车主收款信息</div>
						<ul class="ul-form" style="margin-top: 20px;margin-bottom: 10px;">
							<c:choose>
								<c:when test="${fn:length(orderDriverInfoList)==0}">
									<li style="width:100%;text-align:center">暂无车主收款信息。</li>
								</c:when>
								<c:otherwise>
									<c:forEach items="${orderDriverInfoList}" var="c">
										<li><label style="width:100px;">车主：</label> <span class="detailspan">${c.truename }</span></li>
										<li><label style="width:100px;">收款金额：</label> <span class="detailspan">${c.reciveMoney }</span></li>
										<li><label style="width:100px;">油卡金额：</label> <span class="detailspan">${c.oilMoney }</span></li>
										<li><label style="width:100px;">收款时间：</label> <span class="detailspan" style="width:80px"><fmt:formatDate
													value="${c.reciveTime }" pattern="yyyy-MM-dd" /></span></li>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
					<div style="border:1px solid #ccc;position:relative;margin-top:20px;">
						<div class="title"
							style="width:100px;height:25px;position:absolute;top:-12px;left:40px;background-color:#ffffff;line-height:25px;text-align:center;">保险信息</div>
						<ul class="ul-form" style="margin-top: 20px;margin-bottom: 10px;">
							<li><label>保险公司：</label> <span class="lispan">${goods.insuranceCompanyId }</span></li>
							<li><label>类型（保险）：</label> <span class="lispan">${goods.insuranceType }</span></li>
							<li><label>保额：</label> <span class="lispan">${goods.insurancePrice }</span></li>
							<li><label>保费：</label> <span class="lispan">${goods.insuranceMoney }</span></li>
						</ul>
					</div>
					<div style="border:1px solid #ccc;position:relative;margin-top:20px;">
						<div class="title"
							style="width:100px;height:25px;position:absolute;top:-12px;left:40px;background-color:#ffffff;line-height:25px;text-align:center;">开票信息</div>
						<ul class="ul-form" style="margin-top: 20px;margin-bottom: 10px;">
							<c:if test="${!empty goodsBilling}">
								<li><label>开票企业名称：</label> <span class="lispan">${u.companyName }</span></li>
								<li><label>开票金额：</label> <span class="lispan">${goodsBilling.billingMoney }</span></li>
								<li><label>开票税号：</label> <span class="lispan">${goodsBilling.billingNo }</span></li>
								<li><label>开票状态：</label> <span class="lispan">${goods.isHasBill }</span></li>
							</c:if>
						</ul>
					</div>
					<div style="border:1px solid #ccc;position:relative;margin-top:20px;">
						<div class="title"
							style="width:100px;height:25px;position:absolute;top:-12px;left:40px;background-color:#ffffff;line-height:25px;text-align:center;">车主信息费信息</div>
						<ul class="ul-form" style="margin-top: 20px;margin-bottom: 10px;">
							<c:choose>
								<c:when test="${fn:length(orderDriverInfoList)==0}">
									<li style="width:100%;text-align:center">暂无信息费数据。</li>
								</c:when>
								<c:otherwise>
									<c:forEach items="${orderDriverInfoList}" var="c">
										<li><label style="width:120px;">车主姓名：</label> <span class="detailspan" style="width:100px;">${c.truename }</span></li>
										<li><label style="width:120px;">信息费：</label> <span class="detailspan" style="width:100px;">${c.deposit }</span></li>
										<li><label style="width:120px;">交费时间：</label> <span class="detailspan" style="width:100px;"><fmt:formatDate
													value="${c.payDepositTime }" pattern="yyyy-MM-dd" /></span></li>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
					<div style="border:1px solid #ccc;position:relative;margin-top:20px;padding-top:10px;">
						<div class="title"
							style="width:100px;height:25px;position:absolute;top:-12px;left:40px;background-color:#ffffff;line-height:25px;text-align:center;">运输状态</div>
						<c:choose>
							<c:when test="${fn:length(orderDriverInfoList)==0}">
								<div style="padding-bottom:10px;">暂无物流信息！</div>
							</c:when>
							<c:otherwise>
								<c:forEach items="${orderDriverInfoList }" var="c">
									<c:choose>
										<c:when test="${fn:length(c.driverLogisticsPosition)==0}">
											<div style="width:700px;font-weight:bold;margin-top:10px;padding-left:20px;text-align:left">车主：${c.truename }</div>
											<ul style="list-style-type:none">
													<li><label style="width:700px;text-align:left">物流信息为空。</label></li>
											</ul>
										</c:when>
										<c:otherwise>
											<div style="width:700px;font-weight:bold;margin-top:10px;padding-left:20px;text-align:left">车主：${c.truename }</div>
											<ul style="list-style-type:none">
											<c:forEach items="${c.driverLogisticsPosition}" var="d">
												<li><label style="width:700px;text-align:left"><fmt:formatDate value="${d.createDate }" pattern="yyyy-MM-dd hh:mm" /> &nbsp;&nbsp;&nbsp;${d.curArea }&nbsp;${d.remarks }</label></li>
											</c:forEach>
											</ul>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</c:otherwise>
						</c:choose>

					</div>
				</form>
			</div>
		</div>
	</div>
<script type="text/javascript" src="${ctxStatic}/image-viewer/js/viewer.min.js"></script>
<script>
var viewer = new Viewer(document.getElementById('dataShowUl'), {
	url: 'data-original'
});
</script>
</body>
</html>
