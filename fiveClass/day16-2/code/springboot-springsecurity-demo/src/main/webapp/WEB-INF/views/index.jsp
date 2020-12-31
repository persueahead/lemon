<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/18
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
欢迎${user.username}登录系统!<br>
欢迎<security:authentication property="name"/>登录系统!<br>
欢迎<security:authentication property="principal.username"/>登录系统!<br>
主页!<br>

<%--<security:authorize access="hasAnyRole('ROLE_ADMIN')">
    <a href="${pageContext.request.contextPath}/user/add">用户添加</a>
    <a href="${pageContext.request.contextPath}/user/delete">用户删除</a>
    <a href="${pageContext.request.contextPath}/user/edit">用户修改</a>
    <a href="${pageContext.request.contextPath}/user/findAll">用户查询</a>
</security:authorize>

<security:authorize access="hasAnyRole('ROLE_USER')">
    <a href="${pageContext.request.contextPath}/user/findAll">用户查询</a>
</security:authorize>--%>

<a href="${pageContext.request.contextPath}/user/add">用户添加</a>
<a href="${pageContext.request.contextPath}/user/delete">用户删除</a>
<a href="${pageContext.request.contextPath}/user/update">用户修改</a>
<a href="${pageContext.request.contextPath}/user/findAll">用户查询</a>


<%--<a href="${pageContext.request.contextPath}/logout">退出</a>--%>

<form action="${pageContext.request.contextPath}/logout" method="post">
    <security:csrfInput/>
    <input type="submit" value="注销">
</form>

</body>
</html>
