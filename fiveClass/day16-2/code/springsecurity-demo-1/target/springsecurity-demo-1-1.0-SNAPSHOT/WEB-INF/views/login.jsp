<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/24
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    用户名称:<input type="text" name="username"><br>
    用户名称:<input type="password" name="password"><br>
    <input type="submit" value="登录"><br>
</form>
</body>
</html>
