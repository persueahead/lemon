<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/3
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <FORM ACTION="TestController03/Test04DELETE/admin" method="post">
      <input type="hidden" name="_method" VALUE="DELETE">
      <input type="submit" value="Test04DELETE">
  </FORM>

<HR>

  <FORM ACTION="TestController03/Test03PUT/admin" method="post">
      <input type="hidden" name="_method" VALUE="PUT">
      <input type="submit" value="Test03PUT">
  </FORM>
  <HR>

  <FORM ACTION="TestController03/Test02POST/admin" method="post">
      <input type="submit" value="post">
  </FORM>
  <HR>

  <FORM ACTION="TestController03/Test01GET/admin" method="get">
      <input type="submit" value="post">
  </FORM>
  </body>
</html>
