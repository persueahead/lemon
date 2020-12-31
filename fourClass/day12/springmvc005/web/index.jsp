<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/12
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="TestController001/test"  method="get">
    <input  type="submit" value="提交">
  </form>
  <hr/>
  <form action="TestController001/test001"  method="get">
      <input type="text" name="id"> <br/>
      <input  type="submit" value="提交">
  </form>
  <hr/>
  <form action="TestController001/test002"  method="get">
      <input type="text" name="id"> <br/>
      <input  type="submit" value="提交test002">
  </form>
  <hr/>
  <form action="TestController002/test"  method="get">
      <input type="text" name="id"> <br/>
      <input  type="submit" value="提交test">
  </form>
  </body>
</html>
