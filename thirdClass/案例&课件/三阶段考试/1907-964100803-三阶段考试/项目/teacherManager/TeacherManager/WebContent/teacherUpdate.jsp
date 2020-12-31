<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>更新教职工信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	  span{color:red;}
	  .form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}
.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
.form-signin {
	max-width: 550px;
	padding: 19px 29px 29px;
	margin:0 auto;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}
	</style>

	</head>
	<body>
	<div class="container">
		<jsp:include page="common/head.jsp"></jsp:include>
	</div>
		<form class="form-signin" action="Updata">
			工号：
			<input type="text" name="stId"  readonly="readonly"  class="input" value=<%=request.getParameter("delectId") %>>
			<br>
			姓名：
			<input class="input" type="text" name="teachername"  
			onblur="checkstName()" onFocus="clearstName()" >
			<span id="stName1"></span>
			<br>
			
			性别：
			<input type="radio" name="teacherSex" value="男" checked="checked">男
			<input type="radio" name="teacherSex" value="女">女
			<span id="stSex1"></span>
			<br>
			年龄：
			<input class="input" type="text" name="teacherAge" >
			<span id="stAge1"></span>
			<br>
			电话：
			<input class="input" type="text" name="teacherTel" >
			<span id="stTel1"></span>
			<br>
			系别：
			<input class="input" type="text" name="teacherDept" >
			<span id="stDept1"></span>
			<br>
			地址：
			<input class="input" type="text" name="teacherAddress" >
			<span id="stAddress1"></span>
			<br>
			<input type="submit" value="提交" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" class="btn btn-success" onclick="window.location.href='displayteacher.jsp'"  value="返回">
		</form>
	</body>
</html>
