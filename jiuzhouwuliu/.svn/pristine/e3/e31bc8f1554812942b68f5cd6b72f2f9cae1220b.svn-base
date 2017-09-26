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
    <title>车队长身份转让审核</title>    
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
		$("#auditingStatus").val("");
	}


	//点击审核
    function check(id){
		var url = "${ctx}/users/captainTransfer/captainTransferDetail?id="+id;
        openDialogForm('审核', url, '700px', '500px');
    }
  //点击详情
    function detail(id){
		var url = "${ctx}/users/captainTransfer/captainTransferDetail?id="+id+"&checkOut="+1;
        openDetailForm('详情', url, '700px', '500px');
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
	//打开详情弹出框
	function openDetailForm(title,url,width,height){
		layer.open({
			  type: 2,  
			  area: [width, height],
			  title: title,
		      maxmin: false, //开启最大化最小化按钮
			  content: url ,
			  btn: ['取消'],
			  yes: function(index, layero){
			    layer.close(index);
			  }
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
      <form:form id="searchForm" modelAttribute="hotEvent" action="${ctx}/users/captainTransfer/captainTransferList" method="post" class="breadcrumb form-search">
			<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
			<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}" />
			<ul class="ul-form">
				<li><label>状态：</label>
					<select id="auditingStatus" name="auditingStatus" class="input-medium input-short">
		   				<option value="">请选择</option>
		   				<option value="0" ${driverMasterChange.auditingStatus == '0' ? 'selected' : '' }>未审核</option>
		   				<option value="1" ${driverMasterChange.auditingStatus == '1' ? 'selected' : '' }>已审核</option>
		   				<option value="2" ${driverMasterChange.auditingStatus == '2' ? 'selected' : '' }>已驳回</option>
		   			</select>
				</li>

				<li style="margin-left: 50px"><input id="btnSubmitSearch" style="margin-left:10px;" class="btn btn-primary" type="submit"
					value="搜索" />&nbsp;&nbsp; <input id="btnSubmitReset" class="btn btn-primary" type="button" value="重置" onclick="resetContent()" /></li>
			</ul>

		</form:form>
	<div>
	<table id="contentTable"  class=" table table-striped table-bordered table-condensed " style="TABLE-LAYOUT:fixed;WORD-WRAP:nowrap;table-layout: fixed;">		
		<thead class="fixed-thead" >
		<tr>
							<th width="15%">车队长</th>
							<th width="25%">手机号</th>
							<th width="15%">转让人</th>
							<th width="15%">手机号</th>
							<th width="15%">状态</th>
							<th width="10%">管理操作</th>
						</tr>
		</thead>
		<tbody class="scroll-tbody">
		<c:if test="${not empty page.list }">
						<c:forEach items="${page.list}" var="s">
							<tr>
								<td width="15%">${s.name1}</td>
								<td width="25%">${s.phone1}</td>
								<td width="15%">${s.name2}</td>
								<td width="15%">${s.phone2 }</td>
								<td width="15%">${s.auditingStatus}</td>
							<c:choose>
						   <c:when test="${s.auditingStatus=='未审核'}">  
								 <td width="100px">
								 	<a href="javascript:void(0);" onclick="check('${s.id}');">审核</a>
								 	<a href="javascript:void(0);" onclick="detail('${s.id}');">详情</a>
								 </td>
						   </c:when>
						   <c:when test="${s.auditingStatus=='已审核'}">  
									<td width="100px"><a href="javascript:void(0);" onclick="detail('${s.id}');">详情</a></td>
						   </c:when>
						    <c:when test="${s.auditingStatus=='已驳回'}">  
									<td width="100px"><a href="javascript:void(0);" onclick="detail('${s.id}');">详情</a></td>
						   </c:when>
						</c:choose>
							</tr>
						</c:forEach>
						
					</c:if>
		</tbody>
		</table>
	<div class="pagination">${page}</div>
	</div>
  </body>
</html>
