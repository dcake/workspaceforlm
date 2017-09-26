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
<title>车队管理</title>
<meta name="decorator" content="default" />
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
		$("#truename").val("");
		$("#phoneno").val("");
	}
	
	//1.车队详情
	function viewInfo(id){
		var url = "${ctx}/driver/driveFleetList/info?id="+id;
		openDialogViewForm('编辑车队', url, '700px', '500px');
	}
	//1.车主详情对话框
	function openDialogViewForm(title,url,width,height){
		layer.open({
			  type: 2,  
			  area: [width, height],
			  title: title,
		      maxmin: true, //开启最大化最小化按钮
			  content: url ,
		  	  btn: ['关闭'],
			  cancel: function(index){}
			}); 	
	}
	//新建编辑对话框
	function openApproveInfoForm(title,url,width,height){
		layer.open({
			  type: 2,  
			  area: [width, height],
			  title: title,
		      maxmin: true, //开启最大化最小化按钮
			  content: url ,
			  btn: ['确定','取消'],
			   yes: function(index, layero){
			    var body = layer.getChildFrame('body', index);
			    var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
			    iframeWin.contentWindow.doSubmit();
			},
			   cancel: function(index){}
			}); 	
	}
	//2、添加
	function add(){
		  var url = "${ctx}/driver/driveFleetList/add";
          openApproveInfoForm('添加车队', url, '700px', '500px');
	}
	//3、编辑
	function edit(id){
		var url = "${ctx}/driver/driveFleetList/edit?id="+id;
        openApproveInfoForm('编辑车队', url, '700px', '500px');
	}
	//4.删除车队
	function deleteFleet(id){
		if(id!=""){
			 layer.confirm('删除车队将同时删除该车队下所有成员，确认要删除吗？', function (index) {
	              var url="${ctx}/driver/driveFleetList/deleteFleet";
	              $.post(url,{driveFleetId:id},function(d){
	            	  if(d.status){
	            		  $("#btnSubmit").click();
	            	  }
	              });
	          });
		}
	}
	//4.删除队员
	function deleteMember(id){
		if(id!=""){
			 layer.confirm('确认要删除吗？', function (index) {
	              var url="${ctx}/driver/driveFleetList/deleteMember";
	              $.post(url,{id:id},function(d){
	            	  if(d.status){
	            		  $("#btnSubmit").click();
	            	  }
	              });
	         });
		}

	}
	function keyupInput(obj){
		if (event.keyCode==37 || event.keyCode==39){//左 、右键
		   	
   		}else{
   			obj.value=obj.value.replace(/[^0-9]/g,'');
   		}
   	}
	
	
	
	</script>
<style>
ul {
	margin: 0;
	padding: 0;
}

li {
	list-style: none;
}

.ul-form {
	overflow: hidden;
	background: #f5f5f5;
	margin-bottom: 8px;
	padding: 8px 15px;
}

.ul-form li {
	float: left;
}

.ul-form li label {
	width: 100px;
	text-align: right;
}

select,textarea,input[type="text"],input[type="password"],input[type="datetime"],input[type="datetime-local"],input[type="date"],input[type="month"],input[type="time"],input[type="week"],input[type="number"],input[type="email"],input[type="url"],input[type="search"],input[type="tel"],input[type="color"],.uneditable-input
	{
	height: 30px;
}

li.clearfix {
	float: none;
}
</style>
</head>

<body>
	<form:form id="searchForm" modelAttribute="hotEvent" action="${ctx}/driver/driveFleetList/list" method="post" 
		class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}" />
		<ul class="ul-form">
			<li><label width="90px;">姓名：</label> <input id="truename" name="truename" style="height:20px;" type="text" maxlength="100"
				class="input-medium input-short" value="${drivers.truename}" /></li>
			<li><label width="90px;">手机号：</label> <input id="phoneno" name="phoneno" style="height:20px;" type="text" maxlength="11"
				class="input-medium input-short" value="${drivers.phoneno}" /></li>
			<li><input id="btnSubmit" class="btn btn-primary" type="submit" value="搜索" onclick="" style="margin-left:50px;">&nbsp;&nbsp; <input
				class="btn btn-primary" type="button" value="重置" onclick="resetContent();" /></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<div class="" style="background-color: #fff; margin-left:20px;margin-bottom:8px; ">
		<input id="btnSubmit" class="btn btn-primary" type="submit" value="添加" onclick="add()" />
	</div>
	<div>
		<table id="contentTable" class=" table table-striped table-bordered table-condensed "
			style="TABLE-LAYOUT:fixed;WORD-WRAP:nowrap;table-layout: fixed;">
			<thead class="fixed-thead">
				<tr>
					<th style="width:80px;">车队长姓名</th>
					<th style="width:90px;">队员姓名</th>
					<th style="width:80px;">手机号</th>
					<th style="width:30px;">等级</th>
					<th style="width:100px;">管理操作</th>
				</tr>
			</thead>
			<tbody class="scroll-tbody">
				<c:if test="${not empty page.list }">
					<c:forEach items="${page.list}" var="s">
						<tr>
							<td style="width:80px;"><c:if test="${s.driverType=='2'}">${s.truename}</c:if>
								<!-- 车队长 --></td>
							<td style="width:90px;"><c:if test="${s.driverType!='2'}">${s.truename}</c:if>
								<!-- 队员 --></td>
							<td style="width:80px;">${s.phoneno}</td>
							<td style="width:30px;">${s.isOrgDriver}</td>
							<td style="width:100px;">
								<c:choose>
									<c:when test="${s.driverType=='2'}">
										<a href="javascript:void(0);" onclick="viewInfo('${s.driveFleetId}');">详情</a>
										<a href="javascript:void(0);" onclick="edit('${s.driveFleetId}');">编辑</a>
										<a href="javascript:void(0);" onclick="deleteFleet('${s.driveFleetId}');">删除</a>
									</c:when>
									<c:otherwise>
										<a href="javascript:void(0);" onclick="deleteMember('${s.id}');">删除</a>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<div class="pagination">${page}</div>
	</div>
</body>
</html>
