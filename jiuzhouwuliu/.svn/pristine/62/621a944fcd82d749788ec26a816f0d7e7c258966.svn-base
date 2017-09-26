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
    <title>钱包详情</title>    
	<meta name="decorator" content="default"/>
	<script type="text/javascript" src="${ctxStatic}/modules/cms/front/themes/weixin/lyb/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="${ctxStatic}/uploadfile/ajaxfileupload.js"></script>
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
	    //导出
	    function walletDetailExport(id){
	    	var operateType=$("#operateType").val();
	    	var beginDate=$("#beginDate").val();
	    	var endDate=$("#endDate").val();
	    	window.location.href = "${ctx}/finance/wallet/walletDetailExport?userid="+id+"&&beginDate="+beginDate+"&&endDate="+endDate+"&&operateType="+operateType;
	    }
	    //重置
	    function resetContent(){
	    	$("#operateType").val("");
	  		$("#beginDate").val("");
	  		$("#endDate").val("");
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
		.breadcrumb{
		    padding: 0 0;
		}
		.title {
		   width:100%; 
		   height:auto;
		   background-color:#fff; 
		   z-index:9999;
		}
		.contents{
			overflow-x:hidden;
			display:inline-block;
		}
		.pagination {
		   position:fixed; 
		   left:0px; 
		   bottom:-30px; 
		   width:100%; 
		   height:50px; 
		   background-color:#FFFFFF; 
		   z-index:9999;
		}
	</style>
  </head>
  
  <body>
	<div id="all">
	<div class="title">
		<form:form id="searchForm" modelAttribute="hotEvent" action="${ctx}/finance/wallet/goWalletDetail" method="post" class="breadcrumb form-search">
			<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
			<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
			<input id="userid" name="userid" type="hidden" value="${user.id}"/>
			<ul class="ul-form">
			   	<li style="margin-left:-50px;"><label>姓名：</label>${user.truename}</li>
			   	<li class="clearfix"></li>
			   	<li style="margin-left:-60px"><label>类型：</label>
			   		<select id="operateType" name="operateType" class="input-medium">
			   			<option value="">不限</option>
			   			<c:forEach items="${operateTypeList}" var="s">
			   			<option value="${s.value}"<c:if test="${s.value==usersAccountOperate.operateType}">selected</c:if>>${s.label}</option>
			   			</c:forEach>
			   		</select>
			   	</li>
			   	<li><label>日期范围：&nbsp;</label>
					<input id="beginDate" name="beginDate" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate input-short"
						value="${usersAccountOperate.beginDate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
					&nbsp;至&nbsp;
					<input id="endDate" name="endDate" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate input-short"
						value="${usersAccountOperate.endDate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
				</li>
			   	<li>
					<input id="btnSubmit" style="margin-left:10px;" class="btn btn-primary" type="submit" value="搜索" onclick=""/>&nbsp;&nbsp;
					<input id="btnSubmit" class="btn btn-primary" type="button" value="重置" onclick="resetContent();"/>&nbsp;&nbsp;
					<input id="btnSubmit" class="btn btn-primary" type="button" value="导出" onclick="walletDetailExport('${user.id}');"/>
				</li>    	  
			</ul>
		</form:form>
		</div>
		<div class="contents">
		<table id="contentTable"  class=" table table-bordered table-condensed " style="TABLE-LAYOUT:fixed;WORD-WRAP:nowrap;table-layout: fixed;">		
			<thead class="fixed-thead" >
			 <tr>
			    <th width="120px">时间</th>
			    <th width="80px">类型</th>
			    <th width="80px">金额</th>
			    <th width="80px">获取积分</th>
			    <th width="80px">余额</th>
			    <th width="80px">总积分</th>
			  </tr>
			</thead>
			<tbody class="scroll-tbody">
				<c:if test="${not empty page.list }">
					<c:forEach items="${page.list}" var="s">		     
						<tr>
							<td width="120px"><fmt:formatDate value="${s.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td width="80px">${s.operateType}</td>
							<td width="80px">${fns:formatNumberToString(s.operatMoney,'0.00')}</td>
							<td width="80px">${fns:formatNumberToString(s.integralScore,'0')}</td>
							<td width="80px">${fns:formatNumberToString(s.restMoney,'0.00')}</td> 
							<td width="80px">${fns:formatNumberToString(s.totalScore,'0')}</td>
					     </tr>			
					</c:forEach>
				</c:if> 
			</tbody>
		</table>
	</div>
		<c:if test="${not empty page.list }">
			<div class="pagination" id="paginDiv">${page}</div>
		</c:if>	 
	</div>
  </body>
  <script>
 	var wheight=$(window).height()-$(".title").height()-$("#header").height()-$(".pagination").height()-$("#footer").height()-40;
 	$(".contents").css("height",wheight);
</script>
</html>
