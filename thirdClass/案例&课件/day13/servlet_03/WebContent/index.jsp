<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	//获取绝对路径路径 
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
//      http://localhost:8080/day03-servlet03/
	System.out.println(basePath);
%>     
<!DOCTYPE html>
<html>
<base href="<%=basePath%>" />
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 默认  ,在相同的框架中进行打开URL这个地址 -->
<a href="TestServlet01?filename=19年7月24日后Java全栈工程师大纲.xlsx">点击下载文件</a>
</body>
</html>