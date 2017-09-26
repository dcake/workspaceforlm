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
    <title>用户审核</title>    
	<meta name="decorator" content="default"/>
	<script type="text/javascript" src="${ctxStatic}/modules/cms/front/themes/weixin/lyb/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="${ctxStatic}/uploadfile/ajaxfileupload.js"></script>
	<!-- 引入layer插件 -->
	<link rel="stylesheet" href="${ctxStatic}/layer-v2.0/layer/skin/layer.css">
	<script src="${ctxStatic}/layer-v2.0/layer/layer.js"></script>
	<script src="${ctxStatic}/layer-v2.0/layer/laydate/laydate.js"></script>
    <script type="text/javascript">
    function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		return false;
	}
  
	
	//重置
	function resetContent() {
		$("#username").val("");
		$("#userSort").val("");
		$("#phoneno").val("");
	}

	//打开弹出框
	function openDialogForm(title, url, width, height) {
		layer.open({
			type : 2,
			area : [ width, height ],
			title : title,
			maxmin : false, //开启最大化最小化按钮
			content : url,
			btn : [ '通过','驳回','取消' ],
			yes : function(index, layero) {
				var body = layer.getChildFrame('body', index);
				var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
				iframeWin.contentWindow.doSubmit();
			},
			btn2:function(index,layero){
				 	var body = layer.getChildFrame('body', index);
				    var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
				    iframeWin.contentWindow.doSubmitReturn(); 
				    return false;
				  },
			cancel : function(index) {
			}

		});
	}


	//审核
	function review(id,userSort){
		var url = "${ctx}/users/form?id=" + id+"&userSort="+userSort;
		openDialogForm('审核', url, '600px', '500px');
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
      <form:form id="searchForm" modelAttribute="hotEvent" action="${ctx}/users/queryList" method="post" class="breadcrumb form-search">
			<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
			<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}" />
			<ul class="ul-form" >
				<li><label>用户名：</label>&nbsp;<input id="username" name="username" type="text"  class="input-medium input-short"
					value="${user.username }" style="height:20px;" /></li>
				<li><label>用户类型：</label> <select id="userSort" name="userSort" class="input-medium ">
						<option value="">不限</option>
						<c:forEach items="${fns:getDictList('users_user_sort')}" var="t">
							<option value='${t.value}' ${t.value==user.userSort?'selected':''}>${t.label}</option>
						</c:forEach>
				</select></li>
				<li>
				<li><label>手机号：</label>&nbsp;<input id="phoneno" name="phoneno" type="text" class="input-medium input-short"
					value="${user.phoneno }" style="height:20px;" /></li>

				<li style="margin-left: 50px"><input id="btnSubmitSearch" style="margin-left:10px;" class="btn btn-primary" type="submit" value="搜索" />&nbsp;&nbsp; 
					<input id="btnSubmitReset" class="btn btn-primary" type="button" value="重置" onclick="resetContent()" /></li>
			</ul>

		</form:form>
	<div>
	<table id="contentTable"  class=" table table-striped table-bordered table-condensed " style="TABLE-LAYOUT:fixed;WORD-WRAP:nowrap;table-layout: fixed;">		
		<thead class="fixed-thead" >
		<tr>
							<!-- <th width="5%"><input type="checkbox" name="seletall" onClick="allSelect(this);" /></th> -->
							<th width="15%">用户名</th>
							<th width="25%">手机号</th>
							<th width="15%">用户类型</th>
							<th width="15%">注册时间</th>
							<th width="15%">状态</th>
							<th width="10%">管理操作</th>
						</tr>
		</thead>
		<tbody class="scroll-tbody">
		<c:if test="${not empty page.list }">
						<c:forEach items="${page.list}" var="s">
							<tr>
								<%-- <td width="5%"><input type="checkbox" name="checkItem" value="${s.id}" /></td> --%>
								<td width="15%">${s.username}</td>
								<td width="25%">${s.phoneno}</td>
								<td width="15%">${s.userSortStr}</td>
								<td width="15%"><fmt:formatDate value='${s.createDate}' pattern='yyyy-MM-dd' /></td>
								<td width="15%">
								<c:if test="${s.examineStatus=='0'}">待审核</c:if>
								</td>
								<td width="10%"><a href="javascript:void(0)" onclick="review('${s.id}','${s.userSort}')">审核</a></td>
							</tr>
							
						</c:forEach>
					</c:if>	
		</tbody>
		</table>
	<div class="pagination">${page}</div>
	</div>
  </body>
</html>
