<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Freemarker</title>
</head>
<body >
		<#list list as o >
			<#if o=='星期5'>
				${o}
			<#else>
				不是星期五		
			</#if>
		</#list>
</body>
</html>