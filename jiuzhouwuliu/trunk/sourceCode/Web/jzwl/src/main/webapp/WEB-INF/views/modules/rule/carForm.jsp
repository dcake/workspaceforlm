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
    <title>车主表单</title>    
	<meta name="decorator" content="default"/>
		<script type="text/javascript" src="${ctxStatic}/modules/cms/front/themes/weixin/lyb/jquery-1.7.1.min.js"></script>
	<!-- 引入layer插件 -->
	<link rel="stylesheet" href="${ctxStatic}/layer-v2.0/layer/skin/layer.css">
	<script src="${ctxStatic}/layer-v2.0/layer/layer.js"></script>
	<script src="${ctxStatic}/layer-v2.0/layer/laydate/laydate.js"></script>
	<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.11.1/lib/jquery.form.js"></script> 
    <script type="text/javascript">
  	//回调函数，在编辑和保存动作时，供openDialog调用提交表单
	function doSubmit(){
		  var form = $('#infoForm');
	        var options  = {  
	            url:'${ctx}/rule/gradedManger/save',  
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
	function setIframeWidth(){
  		$("iframe").each(function(){
  			$(this).width("100%");
  		})
  	}
	
	
	</script>
	<style type="text/css">
	select, input[type="text"], input[type="password"], input[type="datetime"], input[type="datetime-local"], input[type="date"], input[type="month"], input[type="time"], input[type="week"], input[type="number"], input[type="email"], input[type="url"], input[type="search"], input[type="tel"], input[type="color"], .uneditable-input{
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
	  <form id="infoForm" method = 'post' class="breadcrumb form-search" style="background-color: white;" enctype="multipart/form-data">
	  <input type="hidden" id="id" name="id" value="${user.id}"/>
	  <ul class="ul-form">
	  <center>
	  	<li>
	    	<label>类别：</label>${type}
		   	</li>
		   	<li class="clearfix"></li>
	    	<%-- <li>
	    	<label>用户名：</label>${user.username}
		   	</li> --%>
		   	<li>
	    	<label>姓名：</label>${user.truename}
		   	</li>
		   		<li class="clearfix"></li>
		   	<li>
	    	<label>手机号：</label>${user.phoneno}
		   	</li>
		   		<li class="clearfix"></li>
		   	<li>
	    	<label>等级：</label>
	    	<select id="level" name="level" class="input-small">
	    		<option value="1" <c:if test="${user.level=='1'}">selected</c:if>>内部</option>
	    		<option value="2" <c:if test="${user.level=='2'}">selected</c:if>>外部</option>
	    	</select>
		   	</li>
	 	</center>
		</ul>
	 	</form>
	  </div>
	  
	</div>
	</div>
	
  </body>
</html>
