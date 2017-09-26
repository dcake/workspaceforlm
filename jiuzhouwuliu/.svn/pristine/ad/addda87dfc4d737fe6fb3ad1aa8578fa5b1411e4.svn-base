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
    <title>投诉建议</title>    
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
    //重置
    function resetForm(){
    	$("[name='userSort']").val('');
    	$("[name='truename']").val('');
    	$("[name='startDateStr']").val('');
    	$("[name='endDateStr']").val('');
    }
    
  	//点击详情
    function openDetail(id){
    	var url = "${ctx}/complaints/complaint/complaintsDetail?id="+id;
        openDialogForm('详情', url, '750px', '500px');
    }
    
	//打开弹出框
	function openDialogForm(title, url, width, height) {
		layer.open({
			type : 2,
			area : [ width, height ],
			title : title,
			maxmin : false, //开启最大化最小化按钮
			content : url,
			btn : [ '确定', '取消' ],
			yes : function(index, layero) {
				var body = layer.getChildFrame('body', index);
				var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
				iframeWin.contentWindow.doSubmit();
			},
			cancel : function(index) {
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
      <form:form id="searchForm" action="${ctx}/complaints/complaint/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		   	
		   	<li><label>用户类型：</label>
		   		<select name="userSort" class="input-medium">
		   			<option value="">不限</option>
		   			<c:forEach items="${userSortList}" var="s">
		   			<option value="${s.value}"<c:if test="${s.value==usersSuggestion.userSort}">selected</c:if>>${s.label}</option>
		   			</c:forEach>
		   		</select>
		   	</li>
		   	<li><label>用户名：</label><input name="truename" style="height:20px;" type="text" maxlength="100" value="${usersSuggestion.truename}" class="input-medium input-short"/></li>
		   	<li><label>开始时间：</label>
				<input id="beginDate" name="startDateStr" value="<fmt:formatDate value="${usersSuggestion.startDate }" pattern="yyyy-MM-dd"/>" type="text" style="height:20px;" readonly="readonly" maxlength="20" class="input-medium Wdate input-short"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});" />
			</li>
			<li><label>结束时间：</label>
				<input id="endDate" name="endDateStr" value="<fmt:formatDate value="${usersSuggestion.endDate }" pattern="yyyy-MM-dd"/>" type="text" style="height:20px;" readonly="readonly" maxlength="20" class="input-medium Wdate input-short" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});" />
			</li>
		   	<li>
				<input id="btnSubmit" style="margin-left:10px;" style="height:20px;" class="btn btn-primary" type="submit" value="搜索" onclick=""/>&nbsp;&nbsp;
				<input  type="button" style="margin-left:10px;" style="height:20px;" class="btn btn-primary" value="重置" onclick="resetForm()"/>&nbsp;&nbsp;
			</li>    	  
		</ul>
	</form:form>
	<div>
	<table id="contentTable"  class=" table table-striped table-bordered table-condensed " style="TABLE-LAYOUT:fixed;WORD-WRAP:nowrap;table-layout: fixed;">		
		<thead class="fixed-thead" >
		<tr>
		 	<th width="100px">用户类型</th>
		    <th width="100px">用户名</th>
		    <th width="100px">手机号</th>
		    <th width="100px">内容</th>
		    <th width="100px">时间</th>
		    <th width="100px">操作</th>
		  </tr>
		</thead>
		<tbody class="scroll-tbody">
			<tr>
				<c:if test="${not empty page.list }">
					<c:forEach items="${page.list}" var="s">	
						<tr>
							<td width="100px">${s.userSortStr}</td>
							<td width="100px">${s.truename}</td>
							<td width="100px">${s.phoneno}</td>
							<td width="100px">${s.suggestionContent}</td>
							<td width="100px"><fmt:formatDate value="${s.createDate }" pattern="yyyy-MM-dd"/></td>
							<td width="100px"><a href="javascript:void(0);" onclick="openDetail('${s.id}')">详情</a></td>
					    </tr>
				    </c:forEach>
				</c:if>
		    </tr>	
		</tbody>
		</table>
	<div class="pagination">${page}</div>
	</div>
  </body>
</html>
