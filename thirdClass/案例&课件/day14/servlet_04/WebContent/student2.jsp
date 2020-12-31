<%@ page language="java"   isELIgnored="false"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<hr/>
<%-- 	nameRequest:<%=request.getAttribute("nameRequest") %><br/>
	nameRequest:<%=session.getAttribute("nameSession") %><br/>
	nameSession:<%=application.getAttribute("contextName") %><br/> --%>
	
	Request:${nameRequest4}<br/>
	Session:${nameSession4}<br/>
	application:${contextName4}<br/>
	
</body>
</html>