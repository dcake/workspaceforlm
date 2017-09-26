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
    <title>信息费设置</title>    
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
  //新增
	function add(){
		var url = "${ctx}/rule/infoFeeRule/form";
		openDialogForm('新建规则', url, '400px', '280px');
	}
	//修改规则
	function edit(id){
		var url = "${ctx}/rule/infoFeeRule/form?id="+id;
		openDialogForm('修改规则', url, '400px', '280px');
	}
	//删除
	function deleteInfo(id){
		if(id!=""){
			layer.confirm('确认删除吗？', function (index) {
              window.location.href="${ctx}/rule/infoFeeRule/delete?id="+id;
            
          });
		}
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
     <div class="" style="background-color: #fff; margin-left:20px;margin-bottom:20px; "> 
     <form:form id="searchForm" action="${ctx}/rule/infoFeeRule/list" method="post">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		</form:form>
<!-- <button class="btn btn-primary" style="margin: 0px 0px 0px 5px" onclick="add()">新建规则</button>	 -->
</div>
	<sys:message content="${message}"/>
	<div>
	<table id="contentTable"  class=" table table-striped table-bordered table-condensed " style="TABLE-LAYOUT:fixed;WORD-WRAP:nowrap;table-layout: fixed;">		
		<thead class="fixed-thead" >
		<tr>
					<th width="20%">货物类型</th>
					<th width="20%">信息费</th>
					<th width="20%">操作</th>
					</tr>
		</thead>
		<tbody class="scroll-tbody">
		<c:if test="${not empty page.list }">
		<c:forEach items="${page.list}" var="p">
			<tr>
				<td width="20%">${p.dictlabel}</td>
				<td width="20%">${p.infoFeeStr}元/车</td>
				<td width="20%"><a href="javascript:void(0)" onclick="edit('${p.id}')">编辑</a>  <%-- <a href="javascript:void(0)" onclick="deleteInfo('${p.id}')">删除</a> --%></td>
			</tr>
		</c:forEach>
		</c:if>
		</tbody>
		</table>
		
	<div class="pagination">${page}</div>
	</div>
	<%-- <div style="position:fixed;width:300px;height:500px;margin-left: 65%;margin-top: 20%">
		<c:if test="${not empty goods_type}">
			<c:forEach items="${goods_type}" var="g">
				<button type="button" class="btn btn-big" style="margin-top:3px；;background-color: white;" disabled="disabled">${g.label }</button>
			</c:forEach>
		</c:if>
		</div> --%>
  </body>
</html>
