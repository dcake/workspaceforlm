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
    <title>平台垫资表单</title>    
	<meta name="decorator" content="default"/>
		<script type="text/javascript" src="${ctxStatic}/modules/cms/front/themes/weixin/lyb/jquery-1.7.1.min.js"></script>
	<!-- 引入layer插件 -->
	<link rel="stylesheet" href="${ctxStatic}/layer-v2.0/layer/skin/layer.css">
	<script src="${ctxStatic}/layer-v2.0/layer/layer.js"></script>
	<script src="${ctxStatic}/layer-v2.0/layer/laydate/laydate.js"></script>
	<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.11.1/lib/jquery.form.js"></script> 
    <script type="text/javascript">
  	//回调函数，在编辑和保存动作时，供openDialog调用提交表单
  	var type=false;
	function doSubmit(){
	if($("#transportMinFee").val()==""){
		layer.alert("请输入运费起!",{icon: 0});
		return;
	}
	if($("#transportMaxFee").val()==""){
		layer.alert("请输入运费止!",{icon: 0});
		return;
	}
	if($("#transportMinFee").val()<0){
		layer.alert("运费不能为负!",{icon: 0});
		return;
	}
	if($("#transportMaxFee").val()<0){
		layer.alert("运费不能为负!",{icon: 0});
		return;
	}
	var fee=$("#transportMinFee").val()-$("#transportMaxFee").val();
	if(fee>0){
		layer.alert("运费起不能超过运费止!",{icon: 0});
		return;
	}
	if($("#oilCardFee").val()==""){
		layer.alert("请输入油卡金额!",{icon: 0});
		return;
	}
	if($("#oilCardFee").val()<0){
		layer.alert("油卡金额不能为负!",{icon: 0});
		return;
	}
	var transportMinFee=new Array();
	transportMinFee=($("#transportMinFee").val()).split(".");
	if(null!=transportMinFee[1]&&transportMinFee[1].length>2){
		layer.alert("运费最多为两位小数!",{icon: 0});
		return;
	}
	var transportMaxFee=new Array();
	transportMaxFee=($("#transportMaxFee").val()).split(".");
	if(null!=transportMaxFee[1]&&transportMaxFee[1].length>2){
		layer.alert("运费最多为两位小数!",{icon: 0});
		return;
	}
	var oilCardFee=new Array();
	oilCardFee=($("#oilCardFee").val()).split(".");
	if(null!=oilCardFee[1]&&oilCardFee[1].length>2){
		layer.alert("油卡金额最多为两位小数!",{icon: 0});
		return;
	}
	if(type==false){
	type=true;
		  var form = $('#infoForm');
	        var options  = {  
	            url:'${ctx}/rule/platformPayRule/save',  
	            type:'post',  
	            success:function(data){  
	            	if (data=="1"){
	        			layer.alert("保存成功!", {icon: 1, shade: 0}, function(index){
	        			parent.location.reload(); // 父页面刷新  
	        			});
	        		}else{
	        			layer.alert("保存失败!", {icon: 2, shade: 0});
	        		}
	            }  
	        };  
	        form.ajaxSubmit(options);
	        }
  	}
	function setIframeWidth(){
  		$("iframe").each(function(){
  			$(this).width("100%");
  		})
  	}
	
	//限制只能输入数字
	function keyupInput(obj){
		if (event.keyCode==37 || event.keyCode==39){//左 、右键
		   	
   		}else{
   			obj.value=obj.value.replace(/[^0-9]/g,'');
   		}
   	}
	</script>
	<style type="text/css">
	select, input[type="password"], input[type="datetime"], input[type="datetime-local"], input[type="date"], input[type="month"], input[type="time"], input[type="week"],  input[type="email"], input[type="url"], input[type="search"], input[type="tel"], input[type="color"], .uneditable-input{
				height: 30px;
			}
	.form-search .ul-form li label{width:120px;text-align:right;}
	</style>
  </head>
  
  <body>
  
  	<div style="text-align: center">
	 
	  <!-- Tab panes -->
	  <div class="tab-content">
	  <div role="tabpanel" class="tab-pane active" id="home">
	  <form id="infoForm" method = 'post' class="breadcrumb form-search" style="background-color: white;" >
	  <input type="hidden" id="id" name="id" value="${plat.id}"/>
	  <ul class="ul-form">
	  <center>
	  	<li>
	    	<label>运费</label>
		   	</li>
		   	<li>
	    	<label style="margin-left:155px ">油卡金额设置</label>
		   	</li>
		   	<li class="clearfix"></li>
	    	
		   	<li>
		   	<input type="number" id="transportMinFee" name="transportMinFee" value="${plat.transportMinFeeStr}" class="input-small" oninput="if(value.length>32)value=value.slice(0,32)" style="width:80px;margin-left:35px "/> —— 
		   	<input type="number" id="transportMaxFee" name="transportMaxFee" value="${plat.transportMaxFeeStr}" class="input-small" oninput="if(value.length>32)value=value.slice(0,32)" style="width:80px;"/>元
		   	</li>
		   	<li>
	    	<input type="number" id="oilCardFee" name="oilCardFee" value="${plat.oilCardFeeStr}" oninput="if(value.length>32)value=value.slice(0,32)" class="input-small" style="width:80px;margin-left:51px"> 元
		   	</li>
	 	</center>
		</ul>
	 	</form>
	  </div>
	  
	</div>
	</div>
	
  </body>
</html>
