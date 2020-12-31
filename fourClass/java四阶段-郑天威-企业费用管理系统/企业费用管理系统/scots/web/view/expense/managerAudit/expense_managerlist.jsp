<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bjlemon.utiles.ThisCode " %>
	<%
	//获取绝对路径路径 
	String path = request.getContextPath();

			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
	%>   
<%@ taglib prefix="d" uri="http://displaytag.sf.net" %>	   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title></title>
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
<script type="text/javascript"
	src="resource/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="resource/My97DatePicker/WdatePicker.js"></script>	
<script type="text/javascript">
$(function(){
	

	
})

</script>	
</head>
<body>
<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>报销管理</li>
			<li>经理审批</li>
		</ul>
	</div>
	<div class="alert alert-warning alert-dismissible fade in" role="alert" style="display:${info==null?'none':'block' };margin-bottom: 0px;">
     	<h4 align="center" style="color: red">${info }</h4>
    </div>
	<form action="expense/ManagerAuditServlet" id="f1" method="post" class="form-inline">
<%--		获取list expense属性 查询信息是用户输入的，所以后台不用传递expense属性实际上，进行显示的只有list--%>
<%--		提交 usersName startDate endDate expenseName--%>
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
			<label>报销人:</label> <input type="text" class="form-control"     name="usersName" value="${expense.usersName }" placeholder="请输入报销人姓名" />
			<label>开始时间:</label> <input type="text" class="form-control " type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" name="startDate" value='<fmt:formatDate value="${expense.startDate }" pattern="yyyy-MM-dd" type="both"/>' placeholder="请输入开始时间" />
			<label>结束时间:</label> <input type="text" class="form-control" name="endDate" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"   value='<fmt:formatDate value="${expense.endDate }" pattern="yyyy-MM-dd"  type="both"/>' placeholder="请输入结束时间" />	
			<label>报销原因:</label> <input type="text" class="form-control"     name="expenseName" value="${expense.expenseName }" placeholder="请输入报销原因" />
		
			</div>
			<input type="submit" class="btn btn-danger" value="查询"> 
		</div>

		<div class="row" style="padding: 15px;">
		<%--	<d:table class="table table-hover table-condensed" name="list" id="e"  pagesize="5" requestURI="expense/ManagerAuditServlet">
				
				<d:column property="expenseId" title="报销编号"></d:column>
				<d:column property="usersName" title="报销人"></d:column>
				<d:column property="expenseName" title="报销原因"></d:column>
				<d:column property="expenseDate" title="报销时间"></d:column>
				<d:column property="expenseStateHtml" title="报销状态"></d:column>
				<d:column property="expenseTotal" title="报销总金额"></d:column>
				<d:column property="expenseAuditUrl" title="审核"></d:column>
&lt;%&ndash;				<d:column value="审核" title="审核" href="expense/ManagerAuditServlet"  paramId="expenseId" paramProperty="expenseId"></d:column>&ndash;%&gt;

			</d:table>--%>
            <table class="table table-hover table-condensed">
                <thead>
                <tr>
                    <th>
                        报销编号
                    </th>
                    <th>
                        报销人
                    </th>
                       <th>
                        报销原因
                    </th>
                    <th>
                        报销时间
                    </th>
                    <th>
                        报销状态
                    </th>
                    <th>
                        报销总金额
                    </th>
                    <th>
                        审核
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="e" items="${list}">
                    <tr>
                        <td> ${e.expenseId }</td>
                        <td>  ${e.usersName }</td>
                        <td> ${e.expenseName }</td>
                        <td> ${e.expenseDate }</td>
                        <td> ${e.expenseStateHtml }</td>
                        <td> ${e.expenseTotal }</td>
                        <c:if test="${ThisCode.SAVE_OK.equals(e.expenseState)||'-3'.equals(e.expenseState)}"><%--jsp默认导入lang包--%>
                        <td> <a href="expense/DoManagerAudit?expenseId=${e.expenseId}">审核</a></td>
                        </c:if>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
	</form>
</body>
</html>