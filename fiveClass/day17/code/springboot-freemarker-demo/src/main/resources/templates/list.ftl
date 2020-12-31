<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<table border="1" cellspacing="0" cellpadding="0">
    <thead>
    <tr>
        <td>用户编号</td>
        <td>用户名称</td>
        <td>用户密码</td>
        <td>用户薪资</td>
        <td>用户生日</td>
    </tr>
    </thead>

    <tbody>
    <#list userList as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td>${user.salary}</td>
            <td>${user.birthday?string("yyyy-MM-dd")}</td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>