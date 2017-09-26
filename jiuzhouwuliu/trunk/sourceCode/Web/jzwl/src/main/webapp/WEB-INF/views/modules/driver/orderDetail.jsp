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
    <title>订单明细</title>    
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
		//重填
	  	function resetContent(){			     
			$("#goodsownersName").val("");
			$("#goodsownersPhoneno").val("");
			$("#beginDate").val("");
			$("#endDate").val("");
		}
	  //查询验证
		function checkForm(){
			if($("#beginDate")!=""&&("#endDate")!=""){
				var startTime=$("#beginDate").val(); 
				var start=new Date(startTime.replace("-", "/").replace("-", "/"));
			    var endTime=$("#endDate").val();  
			    var end=new Date(endTime.replace("-", "/").replace("-", "/")); 
			    if(end<start){  
			    	layer.alert("开始日期不能超过截止日期！", {shade: 0});
			        return false;  
			    }
			    }else{
				    	return true;
				    }
			}
				//1.订单详情对话框
		function openDetailOrderForm(title,url,width,height){
			layer.open({
				  type: 2,  
				  area: [width, height],
				  title: title,
			      maxmin: true, //开启最大化最小化按钮
				  content: url ,
			/* 	  btn: ['确定','取消'],
				   yes: function(index, layero){
				    var body = layer.getChildFrame('body', index);
				    var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
				    iframeWin.contentWindow.doSubmit();
				},
				   cancel: function(index){}
				}); 	
		} */
			  btn: ['关闭'],
				  cancel: function(index){}
				}); 	
		}
		//1.车主详情
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
		/* select, textarea, input[type="text"], input[type="password"], input[type="datetime"], input[type="datetime-local"], input[type="date"], input[type="month"], input[type="time"], input[type="week"], input[type="number"], input[type="email"], input[type="url"], input[type="search"], input[type="tel"], input[type="color"], .uneditable-input{
				height: 30px;
			} */
				li.clearfix {
    float: none;
}
	</style>
  </head>
  
  <body>
	<div id="all">
	<div class="title">
		<form:form id="searchForm" modelAttribute="hotEvent" action="${ctx}/driver/driverList/order" method="post" class="breadcrumb form-search">
			<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
			<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
			<input type="hidden" id="driversId" name="driversId" value="${driveOrder.driversId}" />
			<ul class="ul-form">
			   	<li>
		   	<label width="90px;">货主名称：</label>
		   <input id="goodsownersName" name="goodsownersName" type="text" maxlength="100" class="input-medium input-short" value="${driveOrder.goodsownersName }" />
		   </li>
		   	<li>
		   	<label width="90px;">手机号：</label>
		   	<input id="goodsownersPhoneno" name="goodsownersPhoneno" type="text" maxlength="11" class="input-medium input-short"  value="${driveOrder.goodsownersPhoneno }"/>
		   	</li>
				<li><label>时间：&nbsp;</label>
				<input id="beginDate" name="beginDate" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate"
					value="${driveOrder.beginDate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
				&nbsp;至&nbsp;
				<input id="endDate" name="endDate" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate"
					value="${driveOrder.endDate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</li>
			   	<li>
					<input id="btnSubmit" style="margin-left:10px;" class="btn btn-primary" type="submit" value="搜索" onclick=""/>&nbsp;&nbsp;
					<input  class="btn btn-primary" type="button" value="重置"  onclick="resetContent()"/>
				</li>    	  
			</ul>
		</form:form>
		</div>
		<div class="contents">
		<table id="contentTable"  class=" table table-bordered table-condensed " style="TABLE-LAYOUT:fixed;WORD-WRAP:nowrap;table-layout: fixed;">		
			<thead class="fixed-thead" >
			 <tr>
				<th style="width:80px;">订单编号</th>
			    <th style="width:80px;">金额</th>
			    <th style="width:60px;">获取积分</th>
			    <th style="width:70px;">货主名称</th>
			    <th style="width:70px;">手机号</th>
			    <th style="width:70px;">货物类型</th>
			    <th style="width:120px;">发货地</th>
			    <th style="width:120px;">收获地</th>
			    <th style="width:80px;">时间</th>
			    <th style="width:80px;">订单详情</th>
			  </tr>
			</thead>
			<tbody class="scroll-tbody">
				<c:if test="${not empty page.list }">
					<c:forEach items="${page.list}" var="s">		     
						<tr>
							<td>${s.orderNo}</td>
							<td>${fns:formatNumberToString(s.totalMoney,'0.00')}</td>
							<td>${fns:formatNumberToString(s.integralScore,'0')}</td>
							<td>${s.goodsownersName}</td>
							<td>${s.goodsownersPhoneno}</td>
							<td>${s.goodsType}</td> 
							<td>${s.shipperArea}</td>
							<td>${s.reciverArea}</td>
							<td><fmt:formatDate value="${s.createDate}" pattern="yyyy-MM-dd"/></td>
							<td>
							<a href="javascript:void(0);" onclick="check('${s.goodsId}');">详情</a>
							</td>
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
