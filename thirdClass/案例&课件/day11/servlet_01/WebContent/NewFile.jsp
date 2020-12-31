<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	//获取绝对路径路径 
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>      
    
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>post</h1>
<form action="servlet_01/dom02" method="post">
<input type="text" name="xioazhang"><br/>
<input type="submit" value="提交"><br/>
</form>
</body>
</html>