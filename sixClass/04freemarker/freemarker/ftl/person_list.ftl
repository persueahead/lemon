<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	person:<hr/>
	<#list plist as person>
		id:${person.id}  name:${person.name}  sex:${person.sex}<br/>
	</#list>
</body>
</html>