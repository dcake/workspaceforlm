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
    <title>提现管理</title>    
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
    
  	//点击审核
    function check(id){
		var url = "${ctx}/finance/application/goApplicationCheck?id="+id;
        openDialogForm('审核', url, '750px', '500px');
    }
    //点击详情
     function detail(id){
		var url = "${ctx}/finance/application/goApplicationCheck?id="+id+"&checkOut="+1;
        openDetailForm('详情', url, '750px', '500px');
    }
    	//导出
  	function userExport(){
    	var truename=$("#truename").val();
    	var phoneno=$("#phoneno").val();
    	var userSort=$("#userSort").val();
  		window.location.href = "${ctx}/finance/application/export?truename="+truename+"&&phoneno="+phoneno+"&&userSort="+userSort;
  	}
    
    function resetContent(){
  		$("#truename").val("");
  		$("#phoneno").val("");
  		$("#userSort").val("");
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
			    iframeWin.contentWindow.doSubmitAgree();
			  },
			  btn2:function(index,layero){
			 	var body = layer.getChildFrame('body', index);
			    var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
			    iframeWin.contentWindow.doSubmitReturn(); 
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
  <form:form id="searchForm" modelAttribute="hotEvent" action="${ctx}/finance/application/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		   	<li><label>姓名：</label><input id="truename" name="truename"  style="height:20px;" type="text" maxlength="100" value="${userWithdrawCash.truename}" class="input-medium input-short"/></li>
		   	<li><label>手机号：</label><input id="phoneno" name="phoneno"  style="height:20px;" type="text" maxlength="100" value="${userWithdrawCash.phoneno}" class="input-medium input-short"/></li>	
	   		  	<li style="margin-left:-4px;"><label>用户类型：</label>
		   		<select id="userSort" name="userSort" class="input-medium" style="width:177px;">
		   			<option value="">不限</option>
		   			<c:forEach items="${userSortList}" var="s">
		   			<option value="${s.value}"<c:if test="${s.value==userWithdrawCash.userSort}">selected</c:if>>${s.label}</option>
		   			</c:forEach>
		   		</select>
		   	</li>
		   	<li style="margin-left:60px;">
				<input id="btnSubmit" style="margin-left:10px;" class="btn btn-primary" type="submit" value="搜索" onclick=""/>&nbsp;&nbsp;
				<input id="btnSubmit" class="btn btn-primary" type="button" value="重置" onclick="resetContent();"/>&nbsp;&nbsp;
				<input id="btnSubmit" class="btn btn-primary" type="button" value="导出" onclick="userExport();"/>
			</li>    	  
		</ul>
	</form:form>
	<div>
	<table id="contentTable"  class=" table table-striped table-bordered table-condensed " style="TABLE-LAYOUT:fixed;WORD-WRAP:nowrap;table-layout: fixed;">		
		<thead class="fixed-thead" >
		 <tr>
		    <th width="100px">用户名</th>
		    <th width="100px">姓名</th>
		    <th width="100px">手机号</th>
		    <th width="100px">用户类型</th>
		    <th width="100px">状态</th>
		    <th width="100px">操作</th>
		  </tr>
		</thead>
		<tbody class="scroll-tbody">
		<c:if test="${not empty page.list }">
				<c:forEach items="${page.list}" var="s">		     
					<tr>
						<td width="100px">${s.username}</td>
						<td width="100px">${s.truename}</td>
						<td width="100px">${s.phoneno}</td>
						<td width="100px">${s.userSort}</td>
						<td width="100px">${s.isPass}</td>
						<c:choose>
						   <c:when test="${s.isPass=='待审核'}">  
								 <td width="100px"><a href="javascript:void(0);" onclick="check('${s.id}');">审核</a></td> 
						   </c:when>
						   <c:when test="${s.isPass=='待审核'}">  
									<td width="100px"><a href="javascript:void(0);" ></a></td>
						   </c:when>
						   <c:when test="${s.isPass=='已通过'}">  
									<td width="100px"><a href="javascript:void(0);" onclick="detail('${s.id}');">详情</a></td>
						   </c:when>
						  <c:when test="${s.isPass=='已通过'}">  
									<td width="100px"><a href="javascript:void(0);" ></a></td>
						   </c:when>
						     <c:when test="${s.isPass=='已驳回'}">  
									<td width="100px"><a href="javascript:void(0);" onclick="detail('${s.id}');">详情</a></td>
						   </c:when>
						  <c:when test="${s.isPass=='已驳回'}">  
									<td width="100px"><a href="javascript:void(0);" ></a></td>
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
