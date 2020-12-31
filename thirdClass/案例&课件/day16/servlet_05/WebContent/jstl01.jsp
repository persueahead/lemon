<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
<h1>SET标签</h1>
<c:set var="age"  scope="session" value="${ 12345 * 2 }"></c:set>
<HR/>
获取数据:
<c:out value="${age}"></c:out>
<hr>
<h4>if标签</h4>
<c:set  var ="name"  scope="session" value="${234 * 5 }" />
使用if标签记性判断当前name中的数大于1000  输出对应的工资
<hr>
<c:if test="${name > 1000 }">
 <p>我的工资</p>:<c:out value="${name}" />
</c:if>
<hr>
<h4>choose标签</h4>
<c:set  var="sal" scope="session" value="${39980 * 6 }" />

<p>我的工资是：</p>
<c:choose>
  <c:when test="${sal <= 0 }">
 		 我没有工资了
  </c:when>
  <c:when test="${sal >  2000 }">
 		 我的生活还是够吃饭;工资为：<c:out value="${sal}"></c:out>
  </c:when>
  <c:otherwise>
    	哎工资不够吃饭的钱  工资为：<c:out value="${sal}"></c:out>
  </c:otherwise>
</c:choose>
<hr>
<h4>choose标签</h4>
</body>
</html>