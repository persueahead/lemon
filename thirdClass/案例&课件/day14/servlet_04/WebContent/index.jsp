<%@ page language="java"    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	//获取绝对路径路径 
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<form action="TestServlet01" method="get">
<input  type="submit" value="提交">
</form>
<%--    <%! %>：是用来声明的，声明应用程序的全局变量或者当前页面的方法      --%>
<%!  
	String  lastName="admin"; 
  public  void  getTest(){
	  
  }

%>
<%--         <%= %>：用来插入java表达式的 ,输出到页面上             --%>
<%=lastName %>
<hr/>
<%-- <form action="TestServlet02" method="get">
<input  type="submit" value="获取">
</form> --%>
<!-- <c:if test=""></c:if> -->

</body>
</html>