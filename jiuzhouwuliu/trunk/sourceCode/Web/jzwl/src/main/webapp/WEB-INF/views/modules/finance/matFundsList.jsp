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
    <title>垫资管理</title>    
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
	  	//全选
		function allSelect(obj){
			if (obj.checked){
				//全选
				$("input[name='checkItem']").attr("checked", true);
			}else{
				//全不选
				$("input[name='checkItem']").attr("checked", false);
			}
		}
	  	//点击详情
	  	function openDetail(id){
	  		var url = "${ctx}/finance/matFunds/goSettlementDetail?id="+id;
	  		openDetailDialogForm('详情', url, '750px', '500px');
	  	}
	   //点击结算
	  	function oneSettle(id){
	  		var url = "${ctx}/finance/matFunds/goSettlementDetail?id="+id;
	  		openSettleDialogForm('结算', url, '750px', '500px');
	  	}
	  //打开结算弹出框
		function openSettleDialogForm(title,url,width,height){
			layer.open({
			    type: 2,  
			    area: [width, height],
			    title: title,
		        maxmin: false, //开启最大化最小化按钮
			    content: url ,
			    btn: ['结算', '取消'],
			    yes: function(index, layero){
				    var body = layer.getChildFrame('body', index);
				    var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
				    iframeWin.contentWindow.doSubmit();
			    },
			    cancel: function(index){}
			}); 	
		}
		//打开详情弹出框
		function openDetailDialogForm(title,url,width,height){
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
	  //点击结算
	  function settlement(){
		  var ck=$("input[name='checkItem']:checked");
		  if(ck.length==0){
			  layer.alert('请选择一行数据进行操作', {icon: 3}); 
			  return;
		  }else{
			  var checkId = new Array();
	      	  for(var i = 0;i<ck.length;i++){
	      		  checkId.push($(ck[i]).val());
	      	  }
	      	  $.ajax({
	             url:"${ctx}/finance/matFunds/jiesuan",
	             type:"post",
	             data:{ids:checkId.join(",")},
	             success:function(data){
	               if(data.status){
	            	   layer.alert(data.msg, {icon: 1, shade: 0}, function(index){
	   	        			location.reload(); // 父页面刷新 
	   	        	   }); 
	               }else{
                	   layer.alert(data.msg,{icon: 3});
                   }
	             }
	         });
		 }
	  }
	  //导出
	  function matFundsExport(){
		  var truename=$("#truename").val();
		  var beginDate=$("#beginDate").val();
		  var endDate=$("#endDate").val();
		  var isSettleAccounts=$("#isSettleAccounts").val();
		  window.location.href = "${ctx}/finance/matFunds/export?truename="+truename+"&&beginDate="+beginDate+"&&endDate="+endDate+"&&isSettleAccounts="+isSettleAccounts;
	  }
	  
	//重置
  	function resetContent(){
  		$("#username").val("");
  		$("#truename").val("");
  		$("#beginDate").val("");
  		$("#endDate").val("");
  		$("#isSettleAccounts").val("");
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
     <form:form id="searchForm" modelAttribute="hotEvent" action="${ctx}/finance/matFunds/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		   <%-- 	<li><label>用户名：</label><input id="username" name="username" style="height:20px;" type="text" maxlength="100" value="${driverReciveMoney.username}" class="input-medium input-short"/></li> --%>
		   	<li><label>姓名：</label><input id="truename" name="truename" type="text" style="height:20px;" maxlength="100" value="${driverReciveMoney.truename}" class="input-medium input-short"/></li>	
		   	<li><label>日期范围：&nbsp;</label>
				<input id="beginDate" name="beginDate" type="text" readonly="readonly" style="height:20px;" maxlength="20" class="input-mini Wdate"
					value="${driverReciveMoney.beginDate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
				&nbsp;至&nbsp;
				<input id="endDate" name="endDate" type="text" readonly="readonly" style="height:20px;" maxlength="20" class="input-mini Wdate"
					value="${driverReciveMoney.endDate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</li>
		   	<li style="margin-left:-4px;"><label>状&nbsp;&nbsp;&nbsp;&nbsp;态：</label>
		   		<select id="isSettleAccounts" name="isSettleAccounts" class="input-medium" style="width:177px;">
		   			<option value="">请选择</option>
		   			<option value="1" <c:if test="${driverReciveMoney.isSettleAccounts=='1'}">selected</c:if>>已结算</option>
		   			<option value="0" <c:if test="${driverReciveMoney.isSettleAccounts=='0'}">selected</c:if>>未结算</option>
		   		</select>
		   	</li>
		   	<li style="margin-left:60px;">
				<input id="btnSubmit" style="margin-left:10px;" class="btn btn-primary" type="submit" value="搜索" onclick=""/>&nbsp;&nbsp;
				<input id="btnSubmit" class="btn btn-primary" type="button" value="重置" onclick="resetContent();"/>&nbsp;&nbsp;
				<input id="btnSubmit" class="btn btn-primary" type="button" value="导出" onclick="matFundsExport();"/>
			</li>    	  
		</ul>
	</form:form>
	<div class="" style="background-color: #fff; margin-left:20px;margin-bottom:8px; "> 
<button class="btn btn-primary btn-xs" onclick="settlement()" >结算</button>
</div>
	<div>
	<table id="contentTable"  class=" table table-striped table-bordered" style="WORD-WRAP:nowrap">		
		<thead class="fixed-thead" >
		 <tr>
		 	<th style="width:30px;"><input type="checkbox" name="seletall" style="width:20px"  onClick="allSelect(this);"/></th>
		   <!--  <th width="60px">用户名</th> -->
		    <th width="70px">姓名</th>
		    <th width="80px">手机号</th>
		    <th width="50px">用户等级</th>
		    <th width="60px">运费</th>
		    <th width="60px">税费</th>
		    <th width="100px">第一次垫资金额</th>
		    <th width="60px">油卡支付</th>
		    <th width="100px">第二次垫资金额</th>
		    <th width="60px">油卡支付</th>
		    <th width="100px">垫资总额</th>
		    <th width="90px">订单编号</th>
		    <th width="110px">时间</th>
		    <th width="60px">状态</th>
		    <th width="130px">操作</th>
		  </tr>
		</thead>
		<tbody class="scroll-tbody">
			<c:if test="${not empty page.list }">
				<c:forEach items="${page.list}" var="s">		     
					<tr>
				     	<td ><input type="checkbox" name="checkItem" style="width:20px" value="${s.goodsownerDealId}"/></td>
						<%-- <td >${s.username}</td> --%>
						<td >${s.truename}</td>
						<td >${s.phoneno}</td>
						<td >${s.level}</td>
						<td >${fns:formatNumberToString(s.carryFee,'0.00')}</td>
						<td >${fns:formatNumberToString(s.taxFee,'0.00')}</td>
						<td>${fns:formatNumberToString(s.firstReciveMoney,'0.00')}</td>
						<td>${fns:formatNumberToString(s.firstReciveOil,'0.00')}</td>
						<td>${fns:formatNumberToString(s.secondReciveMoney,'0.00')}</td>
						<td>${fns:formatNumberToString(s.secondReciveOil,'0.00')}</td>
						<td>${fns:formatNumberToString(s.totalMoney,'0.00')}</td>
						<td>${s.orderNo}</td>
						<td><fmt:formatDate value="${s.createDate}" pattern="yyyy-MM-dd"/></td>
						<c:if test="${s.isSettleAccounts=='0'}">
							<td>未结算</td>
							<td>
								<a href="javascript:void(0);" onclick="oneSettle('${s.id}');">结算</a>
								<a href="javascript:void(0);" onclick="openDetail('${s.id}');">详情</a>
							</td>
						</c:if>
						<c:if test="${s.isSettleAccounts=='1'}">
							<td>已结算</td>
							<td>
								<span style="color:gray">已结算</span>
								<a href="javascript:void(0);" onclick="openDetail('${s.id}');">详情</a>
							</td>
						</c:if>
				     </tr>			
				</c:forEach>
			</c:if>
			<tr>
		     	<td style="width:30px;">小计</td>
		     	<!-- <td></td> -->
		     	<td></td>
		     	<td></td>
		     	<td></td>
				<td>${fns:formatNumberToString(xjyf,'0.00')}</td>
				<td>${fns:formatNumberToString(xjsf,'0.00')}</td>
				<td>${fns:formatNumberToString(xjFirstDz,'0.00')}</td>
				<td>${fns:formatNumberToString(xjFirstYk,'0.00')}</td>
				<td>${fns:formatNumberToString(xjSecondDz,'0.00')}</td>
				<td>${fns:formatNumberToString(xjSecondYk,'0.00')}</td>
				<td>${fns:formatNumberToString(xjTotal,'0.00')}</td>
				<td></td>
		     	<td></td>
		     	<td></td>
		     	<td></td>
		     </tr>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
	</div>
  </body>
</html>
