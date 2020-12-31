<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/5
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="TestConteoller06/test002" method="post">
    <input type="text" name="locale" value="zh_CN">

    <INPUT TYPE="submit" VALUE="TestConteoller06/test002">
  </form>
  <form action="TestConteoller05/test001" method="post">
    <input type="text" name="locale" value="zh_CN">

  <INPUT TYPE="submit" VALUE="zh_CN">
  </form>
  <form action="TestConteoller05/test001" method="post">
    <input type="text" name="locale" value="en_US">

    <INPUT TYPE="submit" VALUE="en_US">
  </form>

  <A HREF="TestConteoller05/test001?locale=zh_CN" >zh_CN</A>
  <A HREF="TestConteoller05/test001?locale=en_US" >en_US</A>
  </body>
</html>
