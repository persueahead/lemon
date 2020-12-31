<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	//获取绝对路径路径 
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>     
<!-- html文件中不能写java代码，所以建的是jsp文件 -->
<!DOCTYPE html>
<html>
<base href="<%=basePath%>" />
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 用户提交数据 -->
<form action="TestServlet_04" method="post">
	<input  type="text"  name="name" value="小张" ><br/> 
	<input  type="text"  name="pwd"  value="123123"><br/> 
	<input  type="text"  name="phone" value="12312312312"><br/> 
	<input  type="text"  name="age" value="12" ><br/> 
	<input  type="submit" value="提交"><br/> 
</form>
<hr/>
<form action="TestServlet04" method="get">
	<input  type="submit" value="提交"><br/> 
</form>
<hr/>
<form action="TestServlet9" method="get">
	<input  type="submit" value="提交2"><br/> 
</form>
<hr/>
<a href="">点击文件下载</a>

</body>
</html>