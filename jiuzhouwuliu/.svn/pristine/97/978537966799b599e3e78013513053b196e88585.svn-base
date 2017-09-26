<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>积分管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript" src="${ctxStatic}/modules/cms/front/themes/weixin/lyb/jquery-1.7.1.min.js"></script>
	<link rel="stylesheet" href="${ctxStatic}/layer-v2.0/layer/skin/layer.css">
	<script src="${ctxStatic}/layer-v2.0/layer/layer.js"></script>
	<script src="${ctxStatic}/layer-v2.0/layer/laydate/laydate.js"></script>
	<script type="text/javascript">

		function save(){
			if($("#ruleName").val()==""){
				layer.alert("请输入名称！");
				return;
			}
			if($("#integralToMoney").val()==""){
				layer.alert("请输入价格！");
				return;
			}
			if($("#goodsownerRegister").val()==""){
				layer.alert("请输入货主注册！");
				return;
			}
			if($("#driverRegister").val()==""){
				layer.alert("请输入车主注册！");
				return;
			}
			if($("#agentRegister").val()==""){
				layer.alert("请输入经纪人注册！");
				return;
			}
			if($("#userLogin").val()==""){
				layer.alert("请输入每天登录！");
				return;
			}
			if($("#improveUserInfo").val()==""){
				layer.alert("请输入完善用户信息！");
				return;
			}
			if($("#remarkOrder").val()==""){
				layer.alert("请输入评价订单！");
				return;
			}
			if($("#completeOrder").val()==""){
				layer.alert("请输入完成一次交易！");
				return;
			}
			if($("#integralToMoney").val()>2147483647){
				layer.alert("价格超出范围！");
				return;
			}
			if($("#goodsownerRegister").val()>2147483647){
				layer.alert("货主注册超出范围！");
				return;
			}
			if($("#driverRegister").val()>2147483647){
				layer.alert("车主注册超出范围！");
				return;
			}
			if($("#agentRegister").val()>2147483647){
				layer.alert("经纪人注册超出范围！");
				return;
			}
			if($("#userLogin").val()>2147483647){
				layer.alert("每天登录超出范围！");
				return;
			}
			if($("#improveUserInfo").val()>2147483647){
				layer.alert("完善用户信息超出范围！");
				return;
			}
			if($("#remarkOrder").val()>2147483647){
				layer.alert("评价订单超出范围！");
				return;
			}
			
			if($("#completeOrder").val()>2147483647){
				layer.alert("完成一次交易超出范围！");
				return;
			}
			$.ajax({
				type: 'POST',
				data:$('#saveForm').serialize(),
				url: '${ctx}/rule/integral/save',
				dataType: "json",
				success: function(result) {
					if(result=="1"){
						layer.alert("保存成功!", {icon: 1, shade: 0}, function(index){
							window.location.reload(); // 父页面刷新  
							});
						}else{
							layer.alert("保存失败!", {icon: 2, shade: 0});
					}
				}
			});
		}
	

        //限制只能输入数字
		function keyupInput(obj){
			if (event.keyCode==37 || event.keyCode==39){//左 、右键
						   	
			}else{
				obj.value=obj.value.replace(/[^0-9]/g,'');
				}
			}
		
				
	</script>
</head>
<style type="text/css">
	 .form-search .ul-form li label {
	 	
	 	text-align:right;
	 }
</style>
<body>

	<form:form id="saveForm" modelAttribute="integralRule" action="${ctx}/rule/integral/list" method="post" class=" form-search" style="background-color: white;">
	<%-- <input type="hidden" name="id" value="${integralRule.id}"/> --%>
	<form:hidden path="id"/>
	<ul class="ul-form">
	<li>
		<label style="width:400px;text-align: center">支付积分</label>
	</li>
		<li class="clearfix"></li>
	<li>
		<label style="width:120px;text-align: right">名称：</label><form:input path="ruleName" id="ruleName" value="${integralRule.ruleName}" maxlength="50"/><br/>
	</li>
		<li class="clearfix"></li>
	<li>
		<label style="width:120px;text-align: right">价格：</label><form:input path="integralToMoney" id="integralToMoney" value="${integralRule.integralToMoney}" onkeyup="keyupInput(this);" maxlength="9"/>每100个积分折合成多少元
	</li>
		<li class="clearfix"></li>
	<li>
		<label style="width:120px;text-align: right">货主注册：</label><form:input path="goodsownerRegister" id="goodsownerRegister" value="${integralRule.goodsownerRegister}" onkeyup="keyupInput(this);" maxlength="9"/>
	</li>
		<li class="clearfix"></li>
	<li>
		<label style="width:120px;text-align: right">车主注册：</label><form:input path="driverRegister" id="driverRegister" value="${integralRule.driverRegister}" onkeyup="keyupInput(this);" maxlength="9"/>
	</li>
		<li class="clearfix"></li>
	<li>
		<label style="width:120px;text-align: right">经纪人注册：</label><form:input path="agentRegister" id="agentRegister" value="${integralRule.agentRegister}" onkeyup="keyupInput(this);" maxlength="9"/>
	</li>
		<li class="clearfix"></li>
	<li>
		<label style="width:120px;text-align: right">每天登录：</label><form:input path="userLogin" value="${integralRule.userLogin}" id="userLogin" onkeyup="keyupInput(this);" maxlength="9"/>
	</li>
		<li class="clearfix"></li>
	<li>
		<label style="width:120px;text-align: right">完善用户信息：</label><form:input path="improveUserInfo" id="improveUserInfo" value="${integralRule.improveUserInfo}" onkeyup="keyupInput(this);" maxlength="9"/>
	</li>
		<li class="clearfix"></li>
	<li>
		<label style="width:120px;text-align: right">评价订单：</label><form:input path="remarkOrder" value="${integralRule.remarkOrder}" id="remarkOrder" onkeyup="keyupInput(this);" maxlength="9"/>
	</li>
		<li class="clearfix"></li>
	<li>
		<label style="width:120px;text-align: right">完成一次交易：</label><form:input path="completeOrder" id="completeOrder" value="${integralRule.completeOrder}" onkeyup="keyupInput(this);" maxlength="9"/>
	</li> 
	</ul>
	</form:form>
	<button class="btn btn-primary" onclick="save()" style="margin-left: 190px">保存</button>

</body>
</html>