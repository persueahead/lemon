<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
      <%
	//获取绝对路径路径 
	String path = request.getContextPath();
	//协议://ip:服务端口/web项目代号/
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
//      http://localhost:8080/day03-servlet03/
	System.out.println(basePath);
%>     
<!DOCTYPE html>
<html>
<!-- 地址头 -->
<base href="<%=basePath%>" />
<head>
<meta charset="utf-8">
<title>Document Download</title>
</head>
<body>
<!-- 默认  ,在相同的框架中进行打开URL这个地址 -->
<a href="DocumentDownload?wordDocument=idea快捷键.doc">点击下载文件</a>
</body>
</html>