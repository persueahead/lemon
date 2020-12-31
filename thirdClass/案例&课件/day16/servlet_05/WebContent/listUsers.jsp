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
获取集合存入的对象中的值：
<hr/>
id:${arrUser[0].id}
<hr/>
name:${arrUser[0].name}
<hr/>
age:${arrUser[0].age}
<hr/>
id:${arrUser[1].id}
<hr/>
name:${arrUser[1].name}
<hr/>
age:${arrUser[1].age}

</body>
</html>