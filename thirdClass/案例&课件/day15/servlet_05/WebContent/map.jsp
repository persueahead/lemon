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
获取map中的值：
<hr/>
${has.key1 }
<hr/>
${has.key2 }
获取map中的值方式二：
<hr/>
${has["key1"] }
<hr/>
${has["key2"] }
<%-- <% %> --%>

</body>
</html>