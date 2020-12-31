<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/5
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  successsuccesssuccesssuccesssuccesssuccess
  <HR>
  ${requestScope.msg}<%--request 域--%>
  ${name}
  ${age}
  <HR>
  map  ${map}
  <HR>
  KEY ${KEY}
  mapkey ${mapkey}
  <HR>
  sessionScope.mapkey : ${sessionScope.mapkey}
  sessionScope.mapkey1: ${sessionScope.mapkey1}
  <HR>
  <fmt:message key="i18n.usersname"></fmt:message>
  <br>
  <fmt:message key="i18n.password"></fmt:message>

  </body>
</html>
