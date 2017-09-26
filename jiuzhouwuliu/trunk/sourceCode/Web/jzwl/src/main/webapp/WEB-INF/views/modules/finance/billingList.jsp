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
    <title>开票管理</title>    
	<meta name="decorator" content="default"/>
	<script type="text/javascript" src="${ctxStatic}/modules/cms/front/themes/weixin/lyb/jquery-1.7.1.min.js"></script>
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
    //点击详情
    function openDetail(id){
    	var url = "${ctx}/finance/billing/goBillingDetail?id="+id;
        openDialogForm('详情', url, '750px', '500px');
    }
    
  	//打开弹出框
	function openDialogForm(title,url,width,height){
		layer.open({
			  type: 2,  
			  area: [width, height],
			  title: title,
		      maxmin: false, //开启最大化最小化按钮
			  content: url ,
			  btn: ['确定', '取消'],
			  yes: function(index, layero){
			    var body = layer.getChildFrame('body', index);
			    var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
			    iframeWin.contentWindow.doSubmit();
			},
			   cancel: function(index){}
			}); 	
	}
  	//导出
  	function billingListExport(){
  		var orderNo=$("#orderNo").val();
  		var beginDate=$("#beginDate").val();
  		var endDate=$("#endDate").val();
  		var isHasBill=$("#isHasBill").val();
  		window.location.href = "${ctx}/finance/billing/export?orderNo="+orderNo+"&&beginDate="+beginDate+"&&endDate="+endDate+"&&isHasBill="+isHasBill;
  	}
  	//重置
  	function resetContent(){
  		$("#orderNo").val("");
  		$("#beginDate").val("");
  		$("#endDate").val("");
  		$("#isHasBill").val("");
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
      <form:form id="searchForm" modelAttribute="hotEvent" action="${ctx}/finance/billing/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		   	<li><label>订单编号：</label><input id="orderNo" name="orderNo" style="height:20px;" type="text" maxlength="100" value="${goodsBilling.orderNo}" class="input-medium input-short"/></li>	
		   	<li><label>日期范围起：</label>
				<input id="beginDate" name="beginDate" type="text" style="height:20px;" readonly="readonly" maxlength="20" class="input-mini Wdate"
					value="${goodsBilling.beginDate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</li>
			<li><label>日期范围止：</label>
				<input id="endDate" name="endDate" type="text" style="height:20px;" readonly="readonly" maxlength="20" class="input-mini Wdate"
					value="${goodsBilling.endDate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</li>
			<li><label style=" width: 100px;">是否已开发票：</label>
		   		<select id="isHasBill" name="isHasBill" class="input-medium">
		   			<option value="">不限</option>
		   			<option value="1" <c:if test="${goodsBilling.isHasBill=='1'}">selected</c:if>>是</option>
		   			<option value="0" <c:if test="${goodsBilling.isHasBill=='0'}">selected</c:if>>否</option>
		   		</select>
		   	</li>
		   	<li>
				<input id="btnSubmit" style="margin-left:10px;" class="btn btn-primary" type="submit" value="搜索" onclick=""/>&nbsp;&nbsp;
				<input id="btnSubmit" class="btn btn-primary" type="button" value="重置" onclick="resetContent();"/>&nbsp;&nbsp;
				<input id="btnSubmit" class="btn btn-primary" type="button" value="导出" onclick="billingListExport();"/>
			</li>    	  
		</ul>
	</form:form>
	<div>
	<table id="contentTable"  class=" table table-striped table-bordered table-condensed " style="WORD-WRAP:nowrap;">		
		<thead class="fixed-thead" >
		 <tr>
		    <th width="100px">开票单位</th>
		    <th width="100px">订单编号</th>
		    <th width="100px">金额</th>
		    <th width="80px">货主</th>
		    <th width="80px">货物类型</th>
		    <th width="120px">时间</th>
		    <th width="100px">开票金额</th>
		    <th width="100px">发票编号</th>
		    <th width="100px">是否已结算</th>
		    <th width="100px">是否已开票</th>
		    <th width="100px">操作</th>
		  </tr>
		</thead>
		<tbody class="scroll-tbody">
		<c:if test="${not empty page.list }">
				<c:forEach items="${page.list}" var="s">		     
					<tr>
						<td width="100px">${s.companyName}</td>
						<td width="100px">${s.orderNo}</td>
						<td width="100px">${s.payMoney}</td>
						<td width="100px">${s.truename}</td>
						<td width="100px">${s.goodsType}</td>
						<td width="120px"><fmt:formatDate value="${s.createDate}" pattern="yyyy-MM-dd HH:mm"/></td>
						<td width="100px">${s.billingMoney}</td>
						<td width="100px"><c:out value="${s.billingNo}"/></td>
						<c:if test="${s.isSettleAccounts=='0'}">
							<td width="100px">否</td>
						</c:if>
						<c:if test="${s.isSettleAccounts=='1'}">
							<td width="100px">是</td>
						</c:if>
						<c:if test="${s.isHasBill=='0'}">
							<td width="100px">否</td>
						</c:if>
						<c:if test="${s.isHasBill=='1'}">
							<td width="100px">是</td>
						</c:if>
						<td width="100px"><a href="javascript:void(0);" onclick="openDetail('${s.id}');">详情</a></td>
				     </tr>			
				</c:forEach>
			</c:if>
		</tbody>
		</table>
	<div class="pagination">${page}</div>
	</div>
  </body>
</html>
