<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Freemarker</title>
</head>
<body >
		<#list list as o >
			<#if o=='����5'>
				${o}
			<#else>
				����������		
			</#if>
		</#list>
</body>
</html>