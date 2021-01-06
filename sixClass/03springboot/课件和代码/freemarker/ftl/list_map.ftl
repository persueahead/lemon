<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Freemarker</title>
</head>
<body >
	
	<#list maplist as map>
		<#list map?keys as key>
				${map[key]}
		</#list>
	</#list>
</body>
</html>