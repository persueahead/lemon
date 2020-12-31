<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
      <%
	//获取绝对路径路径 
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>     
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>sing in</title>
	</head>
	<body>
		<form action="TestSing" method="post">
		会员账号<input type="text" border="1px" id="a"  /><span>*</span><br />
		<em id="f"></em><br />
		邮箱地址<input type="text" border="1px" id="b" /><span>*</span><br />
		<em id="g"></em><br />
		登陆密码<input type="password" border="1px" id="c" /><span>*</span><br />
		<em id="h"></em><br />
		确认密码<input type="password" border="1px" id="d" /><span>*</span><br />
		<em id="i"></em><br />
		<button id="e" type="submit">注册</button>	
		</form>
		<script src="jquery-1.9.1.min.js"></script>
		
			<script>
				
			$(function(){
			/* 	WebContent一级目录不用写 */
				$("body").css("background-image","url(img/1.png)");
					$("body").css("width","400px");
						$("body").css("height","400px");
							$("body").css("margin","0 auto");
								$("body").css("margin-top","200px");
			});
			$(function(){
				$("span").css("color","red");
				$("#a").blur(function(){
					if($("#a").val().length<9&&$("#a").val().length>0){
						$("#f").text("账号不能少于9位");
					}else if($("#a").val()==""||$("#a").val()==null){
						$("#f").text("账号不能为空");
					}
					else{
							$("#f").text("输入正确");
					}
				});
				$("#b").blur(function(){
					if($("#b").val().indexOf("@")==-1){
						$("#g").text("邮箱必须存在@");
					}else{
						$("#g").text("输入正确");
					}
				});
				$("#c").blur(function(){
					if($("#c").val()==""||$("#c").val()==null){
						$("#h").text("密码不能为空");
					}else if($("#c").val().length<6&&$("#c").val().length>0){
						$("#h").text("密码不能小于6位");
					}
					else{
						$("#h").text("输入正确");
					}
				});
					$("#d").blur(function(){
					if($("#d").val()!=$("#c").val()){
						$("#i").css("margin-left","50px");
						$("#i").text("两次输入密码不一致");
					}else if($("#d").val()==""||$("#d").val()==null){
						$("#i").text("密码不能为空");
					}
					else{
						$("#i").text("输入正确");
					}
				});
			});
			$(function(){
				$("em").css("color","red");
			});
			$(function(){
				$("#e").css("background-color","aquamarine");
				$("#e").css("margin-left","180px");
				$("button").click(function(){
	     		if($("#f").text()=="输入正确"){
	     				if($("#g").text()== $("#f").text()&&$("#h").text()==$("#g").text())
	     						if($("#h").text()==$("#i").text()){
     					alert("注册成功")
	     				return true;
	     				 	}
	     			}else{
	     				alert("输入有误重新输入");
	     				return false;
	     			}
	    
	     		});
			});
		
			</script>		
	</body>
</html>