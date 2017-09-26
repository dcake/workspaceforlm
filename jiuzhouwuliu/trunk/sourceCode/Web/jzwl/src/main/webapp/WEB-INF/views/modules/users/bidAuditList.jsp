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
    <title>发布竞价审核</title>    
	<meta name="decorator" content="default"/>
	<script type="text/javascript" src="${ctxStatic}/modules/cms/front/themes/weixin/lyb/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="${ctxStatic}/uploadfile/ajaxfileupload.js"></script>
	<!-- 引入layer插件 -->
	<link rel="stylesheet" href="${ctxStatic}/layer-v2.0/layer/skin/layer.css">
	<script src="${ctxStatic}/layer-v2.0/layer/layer.js"></script>
	<script src="${ctxStatic}/layer-v2.0/layer/laydate/laydate.js"></script>
    <script type="text/javascript">
    function page(n,s){
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
    	return false; 
    }
  //重填
  	function resetContent(){			     
		$("#shipperName").val("");
		$("#isCheckPass").val("");
	}
  
  //点击审核
    function check(id,userId){
	  	var userName = $("#userName"+id).val();
	  	var userPhone = $("#userPhone"+id).val();
		var url = "${ctx}/users/bidAudit/check?id="+id+"&userId="+userId;
        openDialogForm('审核', url, '700px', '500px');
    }
  
  //点击详情
    function detail(id,userId){
	  	var userName = $("#userName"+id).val();
	  	var userPhone = $("#userPhone"+id).val();
		var url = "${ctx}/users/bidAudit/detail?id="+id+"&userId="+userId;
		viewDialogForm('详情', url, '700px', '500px');
    }
  //打开弹出框
	function viewDialogForm(title,url,width,height){
		layer.open({
			  type: 2,  
			  area: [width, height],
			  title: title,
		      maxmin: false, //开启最大化最小化按钮
			  content: url ,
			  btn: ['取消'],
			  cancel: function(index){}
		}); 	
	}
  	//打开弹出框
	function openDialogForm(title,url,width,height){
		layer.open({
			  type: 2,  
			  area: [width, height],
			  title: title,
		      maxmin: false, //开启最大化最小化按钮
			  content: url ,
			  btn: ['通过','驳回','取消'],
			  yes: function(index, layero){
			      var body = layer.getChildFrame('body', index);
			      var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
			      iframeWin.contentWindow.doSubmit(1);
			  },
				  btn2:function(index,layero){
			      var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
				  iframeWin.contentWindow.doSubmit(2);
			  	  return false;
			  },
			  cancel: function(index){}
		}); 	
	}
	</script>
	<style>
		ul{
			margin:0;
			padding:0;
		}
		li{
			list-style:none;
		}
		.ul-form{
			overflow:hidden;
			background:#f5f5f5;
			margin-bottom:8px;
			padding:8px 15px;
		}
		.ul-form li{
			float: left;
		}
		.ul-form li label{
			width:100px;
			text-align:right;
		}
		select, textarea, input[type="text"], input[type="password"], input[type="datetime"], input[type="datetime-local"], input[type="date"], input[type="month"], input[type="time"], input[type="week"], input[type="number"], input[type="email"], input[type="url"], input[type="search"], input[type="tel"], input[type="color"], .uneditable-input{
				height: 30px;
			}
				li.clearfix {
    float: none;
}
	</style>
  </head>
  
  <body>
      <form:form id="searchForm" modelAttribute="hotEvent" action="${ctx}/users/bidAudit/bidAuditList" method="post" class="breadcrumb form-search">
			<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
			<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}" />
			<ul class="ul-form">
				<li><label>货主：</label>&nbsp;<input id="shipperName" name="shipperName" type="text" maxlength="100" class="input-medium input-short"
					value="${goods.shipperName }" style="height:20px;" /></li>
				<li><label>状态：</label>
					<select id="isCheckPass" name="isCheckPass" class="input-medium input-short">
		   				<option value="">请选择</option>
		   				<option value="0" ${goods.isCheckPass == '0' ? 'selected' : '' }>未审核</option>
		   				<option value="1" ${goods.isCheckPass == '1' ? 'selected' : '' }>已审核</option>
		   				<option value="2" ${goods.isCheckPass == '2' ? 'selected' : '' }>已驳回</option>
		   			</select>
				</li>
				<li style="">&nbsp;&nbsp; <input id="btnSubmitSearch" style="margin-left:10px;" class="btn btn-primary" type="submit"
					value="搜索" />&nbsp;&nbsp; <input id="btnSubmitReset" class="btn btn-primary" type="button" value="重置" onclick="resetContent()" /></li>
			</ul>
		</form:form>
	<div>
	<table id="contentTable"  class=" table table-striped table-bordered table-condensed " style="TABLE-LAYOUT:fixed;WORD-WRAP:nowrap;table-layout: fixed;">		
		<thead class="fixed-thead" >
		 <tr>                          <!-- <input type="checkbox" name="leftall" onClick="allLeftCb(this);"/>  去掉全部选中 -->
							<th width="80px">货主</th>
							<th width="100px">手机号</th>
							<th width="80px">类型（保险）</th>
							<th width="80px">货物类型</th>
							<th width="50px">是否交保险</th>
							<th width="50px">是否开票</th>
							<th width="80px">状态</th>
							<th width="50px">管理操作</th>
		  </tr>
		</thead>
		<tbody class="scroll-tbody">
		<c:if test="${not empty page.list }">
		<c:forEach items="${page.list}" var="s">		     
			<tr>
				<td >${s.userName}</td>
				<td >${s.userPhone}</td>
				<td >${s.insuranceType}</td>
				<td >${s.goodsType}</td>
				<td >
					<c:if test="${s.isHasInsurance == '0'}">否</c:if>
					<c:if test="${s.isHasInsurance == '1'}">是</c:if>
				</td>
				<td >
					<c:if test="${s.isHasBill == '0'}">否</c:if>
					<c:if test="${s.isHasBill == '1'}">是</c:if>
				</td>
				<td >
					<c:if test="${s.isCheckPass == '0'}">未审核</c:if>
					<c:if test="${s.isCheckPass == '1'}">已审核</c:if>
					<c:if test="${s.isCheckPass == '2'}">已驳回</c:if>
				</td>
				<td >
				<c:if test="${s.isCheckPass == '0'}"><a href="javascript:void(0);" onclick="check('${s.id}','${s.userId }');">审核<input id="userName${s.id}" style="display:none" value = "${s.userName}"><input id="userPhone${s.id}" style="display:none" value = "${s.userPhone}"></a></c:if>
				<a href="javascript:void(0);" onclick="detail('${s.id}','${s.userId }');">详情<input id="userName${s.id}" style="display:none" value = "${s.userName}"><input id="userPhone${s.id}" style="display:none" value = "${s.userPhone}"></a></td>
		     </tr>			
		</c:forEach>
		</c:if>
		</tbody>
		</table>
	<div class="pagination">${page}</div>
	</div>
  </body>
</html>
