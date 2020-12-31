<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    //获取绝对路径路径
    String path = request.getContextPath();

    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ taglib prefix="d" uri="http://displaytag.sf.net" %>
<%--用户管理初始页面jsp   查询后跳转的结果页--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath %>"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>用户管理-用户查询</title>
    <link href="resource/css/bootstrap.min.css" rel="stylesheet"/>
    <script type="text/javascript" src="resource/js/jquery.min.js"></script>
    <script type="text/javascript"
            src="resource/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function () {
            //绑定全选按钮选中事件
            $("#all").click(function () {
                //获取所有多选框的checked属性
                var allChecked = this.checked;
                //获取所有name属性为ids的input标签
                $("input[name=ids]").each(function () {
                    this.checked = allChecked;
                });
            });

            //绑定点击删除按钮事件
            $("#del").click(function () {
                //获取所有已经选中的name属性为ids的input标签
                var cks = $("input[name=ids]:checked");

                if (cks.length < 1) {
                    alert("请选择要删除的用户");
                    return;
                }
                //confirm(arg) 点击确定时返回true,点击取消返回false
                if (confirm("确认要删除吗？")) {
                    //修改form表单的action属性
                    $("#f1").prop("action", "system/deleteUsersServlet");
                    //jquery提交form表单  删除之后提交剩余信息
                    $("#f1").submit();
                }


            });

        })

    </script>
</head>
<body>
<div>
    <ul class="breadcrumb" style="margin: 0px;">
        <li>系统管理</li>
        <li>用户管理</li>
        <li>用户查询</li>
    </ul>
</div>
<div class="alert alert-warning alert-dismissible fade in" role="alert"
     style="display:${tip==null?'none':'block' };margin-bottom: 0px;">
    <h4 align="center" style="color: red">${tip }</h4>
</div>
<form action="system/usersListQueryServlet" id="f1" class="form-inline" method="post">
    <div class="row alert alert-info" style="margin: 0px; padding: 5px;">
        <div class="form-group">
            <label>用户编号:</label>

            <input type="text" class="form-control" name="usersId" value="${users.usersId==0?'':users.usersId }"
                   placeholder="请输入用户编号"/>
            <label>用户姓名:</label>
            <input type="text" class="form-control" name="usersName" value="${users.usersName }" placeholder="请输入用户姓名"/>
        </div>
<%--		查询直接提交表单信息 通过编号和姓名查询--%>
        <input type="submit" class="btn btn-danger" value="查询">
<%--		跳转添加servlet--%>
		<a   href="system/usersAddServlet" class="btn btn-success">添加用户</a>
        <input type="button" class="btn btn-warning" id="del" value="删除用户">
    </div>
    <div class="row" style="padding: 15px;">
<%--        接收List集合，设置分页--%>
        <d:table class="table table-hover table-condensed" name="usersList" pagesize="2"
                 requestURI="/system/usersListQueryServlet">
            <d:column property="ck" title="<input type='checkbox'  id='all'  />"></d:column><%--头一列全是复选框 id=all添加了事件，全选--%>
            <d:column property="usersId" title="用户编号"></d:column><%--ck用的name ids 在get方法里面进行的拼接--%>
            <d:column property="usersName" title="用户姓名"></d:column>
            <d:column property="usersSex" title="用户性别"></d:column>
            <d:column property="usersAge" title="用户年龄"></d:column>
            <d:column property="usersPhone" title="用户电话"></d:column>
            <d:column property="roleName" title="用户角色"></d:column>
            <d:column property="usersAccount" title="用户账户"></d:column>
            <d:column property="usersPwd" title="用户密码"></d:column>
            <d:column property="usersSalary" title="用户薪资"></d:column>
            <d:column value="修改" href="system/UpdateUserServlet" paramId="usersId" paramProperty="usersId"></d:column><%--get方式跳转--%>
		</d:table>>
    </div
</form>
</body>
</html>