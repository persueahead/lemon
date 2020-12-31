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
<script >
   window.onload=function(){
	   document.getElementById("img").onclick=function(){
		   this.src="TestImgServlet?time="+new  Date().getTime();
	   }
   }
</script>

</head>
<body>
<form action="TestLongServlet" method="get">
  <table>
    <tr>
       <td>用户名</td>
       <td>
          <input   type="text" name="userName">
       </td>
    </tr>
      <tr>
       <td>密码</td>
       <td>
          <input   type="text" name="userPwd">
       </td>
    </tr>
        <tr>
       <td>验证码</td>
       <td>
          <input   type="text" name="checkCode">
       </td>
    </tr>
        <tr>
       <td colspan="2">
          <img  id="img" src="TestImgServlet">
       </td>
    </tr>
        <tr>
       <td colspan="2">
          <input   type="submit" value="提交">
       </td>
    </tr>
  </table>


<h1>${message}</h1>

</form>


</body>
</html>