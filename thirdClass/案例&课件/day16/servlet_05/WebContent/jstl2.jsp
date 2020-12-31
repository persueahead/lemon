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
<h4>foeeach标签</h4>
<c:forEach var="i"  begin="1"  end="6">
   的到的结果:<c:out value="${i}"></c:out><br/>
</c:forEach>
<h4>foeeach标签循环后台的集合对象</h4>
<table>
<thead>
  <tr>
     <th>
      	  编号
     </th>
      <th>
      	  考生
     </th>
     <th>
      	  年龄
     </th>
  </tr>
</thead>
<tbody>
	<c:forEach var="users" items="${arr}">
	   <h6>这样写获取的对象\${users }:${users }</h6>
	  <tr>
	    <td>\${users.id } ${users.id }</td>
	    <td>\${users.id }  ${users.name }</td>
	    <td>\${users.id } ${users.lastAge }</td>
	  </tr>
	</c:forEach>
</tbody>
</table>






</body>
</html>