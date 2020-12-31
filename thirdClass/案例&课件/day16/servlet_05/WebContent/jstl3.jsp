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
<hr>
<h4>remove标签</h4>
<c:set value="${2345 * 6 }"  scope="session" var="lastSal"></c:set>
<h6>没有进行删除之前的数据:<c:out value="${lastSal}"></c:out></h6>
<hr />
删除数据......
<c:remove var="lastSal"/>
<hr />
<h6>删除之后的数据:<c:out value="${lastSal}"></c:out></h6>
<hr />
<h4>param  和url 标签</h4>
<c:url var="myURL" value="index.jsp">
     <c:param name="name" value="admin" />
  	<c:param name="url" value="www.baidu.com" />
</c:url>
<hr>
<a href="/<c:out value="${myURL}"/>">点击指定发送参数</a>

<a href="www.baidu.com?name=121"></a>

<h4>redirect标签</h4>
<%-- <c:redirect url="https://www.baidu.com/"></c:redirect>
 --%>
<c:import url="index.jsp"></c:import>

</body>
</html>