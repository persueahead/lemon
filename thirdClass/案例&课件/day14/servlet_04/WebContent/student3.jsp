<%@page import="java.util.ArrayList"%>
<%@ page language="java"    contentType="text/html; charset=UTF-8"
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
<h1>算术运算符</h1>
\${ 7 + 9 }:${ 7 + 9 }<br/>
\${ 18 / 9 }:${ 18 / 9 }<br/>
\${ 18 div 9 }::${18 div 9}<br/> 
\${ 7 * 9 }:${ 7 * 9 }<br/>
\${ 18 % 9 }:${ 18 % 9 }<br/>
\${ 28 mod  7 }:${ 28 mod 7 }<br/>
<h1>比较运算符</h1>
\${ 3 == 6 }:	${ 3 == 6 }<br/>
\${ 3 != 6 }:	${ 3 != 6 }<br/>

<h1>逻辑运算符</h1>
\${ 3 == 6  &&    3 != 6  }:	${ 3 == 6  &&    3 != 6  }<br/>
\${ 3 < 6  ||  1 < 3 }:	${ 3 < 6  ||  1 < 3 }<br/>
\${ 3 == 6  and    3 != 6  }:	${ 3 == 6  and    3 != 6  }<br/>
\${ 3 < 6  or  1 < 3 }:	${ 3 < 6 or   1 < 3 }<br/>

<h1>空运算符</h1>
<% ArrayList array= new ArrayList();
array.add("小张");
array.add("小王");
array.add("小李");
request.setAttribute("array",array);
%>
${array}<br/>
ArrayList:${empty array}<br/>
ArrayList:${not empty array}<br/>


</body>
</html>