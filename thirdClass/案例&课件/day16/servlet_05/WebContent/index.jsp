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
<form action="TestServlet01"  method="get">
<input type="submit" value="提交">
</form>
<hr/>
<form action="TestServlet02"  method="get">
<input type="submit" value="获取对象">
</form>
<hr/>
<form action="TestServlet03"  method="get">
<input type="submit" value="获取集合">
</form>
<hr/>
<form action="TestServlet04"  method="get">
<input type="submit" value="获取集合中存入的对象">
</form>
<hr/>
<form action="TestServlet05"  method="get">
<input type="submit" value="map对象">
</form>

<hr/>
<form action="TestServlet06"  method="get">
<input type="submit" value="JSTL对象">
</form>
</body>
</html>