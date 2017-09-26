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
    <title>信息费管理</title>    
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
    //导出
    function infoFeeExport(){
    	var truename=$("#truename").val();
    	var beginDate=$("#beginDate").val();
    	var endDate=$("#endDate").val();
    	window.location.href = "${ctx}/finance/informationFee/export?truename="+truename+"&&beginDate="+beginDate+"&&endDate="+endDate;
    }
    
  //重置
  	function resetContent(){
  		$("#username").val("");
  		$("#truename").val("");
  		$("#beginDate").val("");
  		$("#endDate").val("");
  	}
  //点击审核
	function check(id) {
		var url = "${ctx}/users/orderManager/orderManagerDetail?id=" + id;
		openDialogForm('详情', url, '800px', '500px');
	}
  
	//打开弹出框
	function openDialogForm(title, url, width, height) {
		layer.open({
			type : 2,
			area : [ width, height ],
			title : title,
			maxmin : false, //开启最大化最小化按钮
			content : url,
			btn : ['取消'],
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
	/* 	select, textarea, input[type="text"], input[type="password"], input[type="datetime"], input[type="datetime-local"], input[type="date"], input[type="month"], input[type="time"], input[type="week"], input[type="number"], input[type="email"], input[type="url"], input[type="search"], input[type="tel"], input[type="color"], .uneditable-input{
				height: 30px;
			} */
				li.clearfix {
    float: none;
}
	</style>
  </head>
  
  <body>
       <form:form id="searchForm" modelAttribute="hotEvent" action="${ctx}/finance/informationFee/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		   	<%-- <li><label>用户名：</label><input id="username" name="username" type="text" maxlength="100" value="${driveOrder.username}" class="input-medium input-short"/></li> --%>
		   	<li><label>姓名：</label><input id="truename" name="truename" type="text" maxlength="100" value="${driveOrder.truename}" class="input-medium input-short"/></li>	
	   		<li><label>日期范围：&nbsp;</label>
				<input id="beginDate" name="beginDate" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate"
					value="${driveOrder.beginDate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
				&nbsp;至&nbsp;
				<input id="endDate" name="endDate" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate"
					value="${driveOrder.endDate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</li>
		   	<li style="margin-left:60px;">
				<input id="btnSubmit" style="margin-left:10px;" class="btn btn-primary" type="submit" value="搜索" onclick=""/>&nbsp;&nbsp;
				<input id="btnSubmit" class="btn btn-primary" type="button" value="重置" onclick="resetContent();"/>&nbsp;&nbsp;
				<input id="btnSubmit" class="btn btn-primary" type="button" value="导出" onclick="infoFeeExport();"/>
			</li>    	  
		</ul>
	</form:form>
	<div>
	<table id="contentTable"  class=" table table-striped table-bordered table-condensed " style="TABLE-LAYOUT:fixed;WORD-WRAP:nowrap;table-layout: fixed;">		
		<thead class="fixed-thead" >
		  <tr>
		   <!--  <th width="100px">用户名</th> -->
		    <th width="100px">姓名</th>
		    <th width="100px">手机号</th>
		    <th width="100px">用户类型</th>
		    <th width="100px">信息费</th>
		    <th width="100px">时间</th>
		    <th width="100px">订单编号</th>
		    <th width="100px">操作</th>
		  </tr>
		</thead>
		<tbody class="scroll-tbody">
			<c:if test="${not empty page.list }">
				<c:forEach items="${page.list}" var="s">		     
					<tr>
						<%-- <td width="100px">${s.username}</td> --%>
						<td>${s.truename}</td>
						<td>${s.phoneno}</td>
						<td>${s.userSort}</td>
						<td>${fns:formatNumberToString(s.deposit,'0.00')}</td>
						<td><fmt:formatDate value="${s.payDepositTime}" pattern="yyyy-MM-dd"/></td>
						<td>${s.orderNo}</td>
						<td><a href="javascript:check('${s.goodsId }');">详情</a></td>
				     </tr>			
				</c:forEach>
			</c:if>
			<tr>
		     	<td>小计</td>
				<!-- <td></td> -->
				<td></td>
				<td></td>
				<td>${fns:formatNumberToString(subtotal,'0.00')}</td>
				<td></td>
				<td></td>
				<td></td>
		     </tr>
		</tbody>
		
		</table>
		<%-- <span>小计：<label style="margin-left: 588px;">${subtotal}</label></span> --%>
	<div class="pagination">${page}</div>
	
	</div>
  </body>
</html>
