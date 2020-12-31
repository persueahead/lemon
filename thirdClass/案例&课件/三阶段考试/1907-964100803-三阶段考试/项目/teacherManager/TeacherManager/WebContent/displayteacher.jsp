<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>显示教职工信息</title>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery/jquery-1.5.1.js"></script>
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>

<style type="text/css">
input[type="text"] {
	height: auto;
	margin-bottom: 15px;
	padding: 3px 9px;
}
</style>

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
		<form action="Quarypass" method="post">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 工号：<input
				type="text" name="searchId"  placeholder="职工工号...">
			<i class="icon-search"></i>&nbsp;
			<button type="submit" class="btn btn-inverse">查找</button>
		</form>
		<table class="table table-hover table-condensed">
			<tr>
				<td align="center"><strong>教职工编号</strong></td>
				<td align="center"><strong>教职工姓名</strong></td>
				<td align="center"><strong>教职工性别</strong></td>
				<td align="center"><strong>教职工年龄</strong></td>
				<td align="center"><strong>教职工电话</strong></td>
				<td align="center"><strong>教职工系别</strong></td>
				<td align="center"><strong>教职工地址</strong></td>
				<td align="center"><strong>执行操作</strong></td>
			</tr>
			<c:forEach var="tea" items="${teachers}">
			<tr>
				<td>${tea.teacherId}</td>
				<td>${tea.teachername}</td>
				<td>${tea.teacherSex}</td>
				<td>${tea.teacherAge}</td>
				<td>${tea.teacherTel}</td>
				<td>${tea.teacherDept}</td>
				<td>${tea.teacherAddress}</td>
				<td><a href="Delete?delectId=${tea.teacherId}" class="btn btn-danger"
					onclick="del()">删除</a> <a href="teacherUpdate.jsp?delectId=${tea.teacherId}"
					class="btn btn-primary">更新</a></td>
			</tr>
			</c:forEach>
		</table>

		<hr>
		<a href="main.jsp" class="btn btn-success">返回主菜单</a>
		<hr>
	</div>



</body>
</html>
