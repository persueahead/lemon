<%@ page language="java"   contentType="text/html; charset=UTF-8"
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
<%!
public  void getTest(){
	
}
%>
<%
	pageContext.setAttribute("name", "隔壁老陈");
	request.setAttribute("lasetName", "隔壁老张");
	session.setAttribute("age",123123);
	/* if(){
		
		
	} */
	
%>
<hr/>
	<%=pageContext.getAttribute("name") %>
	<%=request.getAttribute("lasetName") %>
	<%=session.getAttribute("age") %>
</body>
</html>