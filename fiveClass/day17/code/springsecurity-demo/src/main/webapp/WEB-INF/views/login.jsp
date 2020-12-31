<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/18
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    用户名称:<input type="text" name="username"><br>
    用户密码:<input type="password" name="password"><br>
    <input type="submit" value="登录"><br>
</form>
</body>
</html>
