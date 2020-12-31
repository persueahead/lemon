<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询结果页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="${pageContext.request.contextPath}/bootstrap/js/jQuery.js"></script>
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
	
	<script type="text/javascript">
		function del() {
			 if (!confirm("确认要删除？")) {
		            window.event.returnValue = false;
		        }
		}
				
	</script>
			
  </head>
  
  <body>
  <div class="container">
	  <jsp:include page="common/head.jsp"></jsp:include>
	  <table  class="table table-hover table-condensed">
		  <tr>
			  <td align="center">
				  <strong>工号</strong>
			  </td>
			  <td align="center">
				  <strong>姓名</strong>
			  </td>
			  <td align="center">
				  <strong>性别</strong>
			  </td>
			  <td align="center">
				  <strong>年龄</strong>
			  </td>
			  <td align="center">
				  <strong>电话</strong>
			  </td>
			  <td align="center">
				  <strong>系别</strong>
			  </td>
			  <td align="center">
				  <strong>地址</strong>
			  </td>
			  <td align="center" >
				  <strong>执行操作</strong>
			  </td>
		  </tr>
		  <tr>
			  <td>${selecTeachertById.teacherId }</td>
			  <td>${selecTeachertById.teachername }</td>
			  <td>${selecTeachertById.teacherSex }</td>
			  <td>${selecTeachertById.teacherAge }</td>
			  <td>${selecTeachertById.teacherTel }</td>
			  <td>${selecTeachertById.teacherDept }</td>
			  <td>${selecTeachertById.teacherAddress}</td>
			  <td>
				  <a href="javascript:;" class="btn btn-danger" onclick="del()">删除</a>
				  <a href="teacherUpdate.jsp" class="btn btn-primary">更新</a>
			  </td>
		  </tr>
	  </table>		
	<c:if test="${selectid<0}">
	<center>
		<font color="red" size="+1" >查不到哦，亲</font>
	</center>
	</c:if>	
	<c:if test="${selectid>listLength}">
	<center>
		<font color="red" size="+1" >查不到哦，亲</font>
	</center>
	</c:if>	
	  <hr>
	  <a href="main.jsp" class="btn btn-success">返回主菜单</a>
	  <hr>
  </div>

  </body>
</html>
