<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//获取绝对路径路径 
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>用户管理-用户添加</title>
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<!-- <link href="resource/css/main.css" rel="stylesheet" /> -->
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="resource/validation/jquery.validate.js"></script>
<script type="text/javascript">

	$(function(){
		
		//保存未提交
		$("#but").click(function(){
			$("#expenseState").val("0");
			$("#f1").submit();
		});
		
		//选择费用明细
		$("#selected").click(function(){
			//获取第一个表格
			var tab1 = $("#tab1");
			//获取选中的复选框  数组
			var costIds = $("input[id=costId]:checked");
			//总金额
			var expenseTotal = $("#expenseTotal");
			//each 遍历数组
			costIds.each(function(){
				//$(this) 当前复选框 
				//$(this).parent().parent() 找到tr
				//.find("td"); 找到tr下面td
				//数组  id[] 该行的所有id
				var td = $(this).parent().parent().find("td");
				// 属性 costIds 多个
				//name='detailDescs' name='detailMoneys' name='costIds' td[1]费用编号 td[2]费用名字
				//给明细表追加数据 追加的数据在页面的form表单里面 信息一起向servlet提交
				tab1.append("<tr>"+
								"<td>"+td[1].innerHTML+"<input type='hidden' name='costIds' value='"+td[1].innerHTML+"' ></td>"+
								//费用的通过编号就可以查所有信息，所以费用名称没用属性上传
								"<td>"+td[2].innerHTML+"</td>"+
								"<td><input type='text' value='0' id='money' name='detailMoneys' class='form-control' style='width:100px'></td>"+
								"<td><input type='text' name='detailDescs' class='form-control'></td>"+
								"<td><a href='javascript:void(0)' class='btn btn-danger' onclick='del(this)' >删除</a></td>"+
							" </tr>");
				
				//给文本框绑定 聚焦事件 只能定义在这个地方 明细表中的信息添加完成后 计算总金额,在基本信息 报销总金额中显示
				$("input[id=money]").blur(function(){
					var sum = 0;
					$("input[id=money]").each(function(){
						// 遍历明细表中的金额,转换为long型,累加求和
						sum+=parseFloat($(this).val());
					});
					// 更改基本信息中的报销总金额
					expenseTotal.val(sum);
					
				});
				
			});
			
			//隐藏
			$("#myModal").modal("hide");
		});
		
	})
	// 和之前的删除不同，之前是修改状态码这个是直接移除tr包括里面的td
	function del(obj){
		if(confirm("确定要删除该费用")){
			//获取tr
			var tr = $(obj).parent().parent();
			//删除tr包括tr里面td
			tr.remove();
		}
	}


</script>	

</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>报销管理</li>
			<li>报销单</li>
		</ul>
	</div>
	<div class="alert alert-warning alert-dismissible fade in" role="alert"
		style="display:${tip==null?'none':'block' };margin-bottom: 0px;">
		<h4 align="center" style="color: red">${tip }</h4>
	</div>
<%--	表单-----userId---expenseState--expenseName----expenseTotal---expenseDesc-----costIds---detailMoneys--detailDescs-------------------------------------------------%>
	<form action="expense/ExpenseAddServlet" id="f1" method="post"
		class="form-horizontal">
<%--		隐藏属性  userId  状态吗：expenseState--%>
		<input type="hidden" name="usersId" id="userId" value="${users.usersId }"/>
		<input type="hidden" name="expenseState" id="expenseState" value="1"/>
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
		<!-- 上半部----------------------------------------------------- -->
		<div class="row">
			<div class="col-xs-7">
				<div class="form-group ">
					<label class="col-xs-3 control-label">报销原因</label>
					<div class="col-xs-9 ">
<%--						属性 报销项目（原因） name="expenseName"--%>
						<input type="text" class="form-control" required name="expenseName"
							value="${expense.expenseName }" placeholder="请输入报销原因" /> <%--属性域要存入expense--%>
					</div>
				</div>
			</div>
			<div class="col-xs-7">
				<div class="form-group ">
					<label class="col-xs-3 control-label">报销总金额</label>
					<div class="col-xs-5 ">
<%--						属性 报销总金额 name="expenseTotal"--%>
						<input type="text" class="form-control" readonly="readonly" id="expenseTotal" name="expenseTotal"
							value="${expense.expenseTotal==null?'0':expense.expenseTotal }" placeholder="请输入报销总金额" />
					</div>
				</div>
			</div>
			<div class="col-xs-7">
				<div class="form-group ">
					<label class="col-xs-3 control-label">报销详情</label>
					<div class="col-xs-9 ">
<%--						属性 报销描述 name="expenseDesc"--%>
						<textarea rows="10" class="form-control" name="expenseDesc" cols=""
							placeholder="请输入报销详情">${expense.expenseDesc }</textarea>
					</div>
				</div>
			</div>
		</div>
		<!--上半部   ------------------------------------------------------------------ -->

<%--	 下半部  明细表--------------------------------------------------------------------%>
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">
			报销单明细
			<button type="button" class="btn btn-primary btn-xs"
				data-toggle="modal" data-target="#myModal">选择费用明细</button><%--data-target="#myModal : bootStrap样式 模糊弹窗--%>
		</h5>
<%--	明细表     费用信息展示  带有删除键                            --%>
		<table class="table" id="tab1" >
<%--			明细表详情 --%>
			<tr>
				<th>费用编号</th>
				<th>费用名称</th>
				<th>具体金额</th>
				<th>费用说明</th>
				<th>删除</th>
			</tr>
		
		</table>
				<div class="row">
			<div class="col-xs-3 col-xs-offset-4">
<%--				都是提交表单 并向数据库添加数据 只是一个state=0 一个state=1--%>
				<input type="button" id="but" class="btn btn-primary" value="保存未提交" /> <%--0--%>
				<input type="submit" class="btn btn-success" value="保存并提交" /><%--1--%>
			</div>

		</div>

	</form>
<%--	明细表结束------form结束------------------------------------------------------%>

	<!-- 明细表弹出框 --------------------------------------------------------------->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">费用明细</h4>
      </div>
      <div class="modal-body">
        	<table class="table" id="tab2">
        		<tr>
        			<th></th>
        			<th>费用编号</th>
        			<th>费用名称</th>
        			<th>费用描述</th>
        		</tr>
<%--                取costs属性 循环遍历--%>
        		<c:forEach items="${costs }" var="cost">
<%--					tr 表示行 th 表示标题 td 表示列--%>
        			<tr>
        				<td> <input type="checkbox" id="costId" value="${cost.costId }"/> </td>
        				<td>${cost.costId }</td>
        				<td>${cost.costName }</td>
        				<td>${cost.costDesc }</td>
        			</tr>
        		</c:forEach>
        		
        	</table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" id="selected">选择</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>