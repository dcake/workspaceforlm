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
    <title>保险管理</title>    
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
      <form:form id="searchForm" modelAttribute="hotEvent" action="${ctx}/school/schoolManager/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		   	<li><label>订单编号：</label><input id="name" name="name" type="text" style="height:20px;" maxlength="100" value="${name}" class="input-medium input-short"/></li>	
		   	<li><label>投保公司：</label>
		   		<select id="schoolType" name="schoolType" class="input-medium input-short">
		   			<option value="">平安保险</option>
		   			<option value="">人寿保险</option>
		   		</select>
		   	</li>
		   	<li><label>日期范围：&nbsp;</label>
				<input id="beginDate" name="beginDate" type="text" style="height:20px;" readonly="readonly" maxlength="20" class="input-mini Wdate input-short"
					value="<fmt:formatDate value="${log.beginDate}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
				&nbsp;至&nbsp;
				<input id="endDate" style="height:20px;" name="endDate" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate input-short"
					value="<fmt:formatDate value="${log.endDate}"  pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</li>
		   	<li>
				<input id="btnSubmit" style="margin-left:10px;" class="btn btn-primary" type="submit" value="搜索" onclick=""/>&nbsp;&nbsp;
				<input id="btnSubmit" class="btn btn-primary" type="button" value="导出" onclick="resetContent();"/>
			</li>    	  
		</ul>
	</form:form>
	<div>
	<table id="contentTable"  class=" table table-striped table-bordered table-condensed " style="TABLE-LAYOUT:fixed;WORD-WRAP:nowrap;table-layout: fixed;">		
		<thead class="fixed-thead" >
		 <tr>
		    <th width="100px">订单编号</th>
		    <th width="100px">金额</th>
		    <th width="100px">货主</th>
		    <th width="100px">货物类型</th>
		    <th width="100px">时间</th>
		    <th width="100px">投保公司</th>
		    <th width="100px">估值</th>
		    <th width="100px">保险金额</th>
		  </tr>
		</thead>
		<tbody class="scroll-tbody">
		<tr>
				<td width="100px">20170704001</td>
				<td width="100px">200</td>
				<td width="100px">赵六</td>
				<td width="100px">配件</td>
				<td width="100px">2017-07-06 12:45</td>
				<td width="100px">人寿保险</td>
				<td width="100px">3000</td>
				<td width="100px">20</td>
		     </tr>
		     <tr>
				<td width="100px">20170704002</td>
				<td width="100px">100</td>
				<td width="100px">赵五</td>
				<td width="100px">配件</td>
				<td width="100px">2017-07-06 12:45</td>
				<td width="100px">人寿保险</td>
				<td width="100px">3000</td>
				<td width="100px">20</td>
		     </tr>	
		<%-- <c:if test="${not empty page.list }">
		<c:forEach items="${page.list}" var="s">		     
			<tr>
				<td width="100px">20170704001</td>
				<td width="150px">200</td>
				<td width="80px">赵六</td>
				<td width="60px">配件</td>
				<td width="80px">配件</td>
				<td width="60px">2017-07-06 12:45</td>
				<td width="60px">人寿保险</td>
				<td width="60px">3000</td>
				<td width="60px">20</td>
		     </tr>			
		</c:forEach>
		</c:if> --%>
		</tbody>
		</table>
	<div class="pagination">${page}</div>
	</div>
  </body>
</html>
