<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	//获取绝对路径路径 
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>     
<!DOCTYPE html>
<html>
<base href="<%=basePath%>" />
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
<h1>${message}</h1>
</body>
</html>