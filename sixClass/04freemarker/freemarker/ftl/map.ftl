<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Freemarker</title>
</head>
<body >
	id:${map.id} name:${map.name} age:${map.age}<hr/>
	<#list map?keys as key>
		${map[key]}
	</#list>
</body>
</html>