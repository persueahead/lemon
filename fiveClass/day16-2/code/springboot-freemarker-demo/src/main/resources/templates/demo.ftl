<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    ${info}

    <br>

    <#list inters as inter>
        <#if inter?length gte 10>
            ${inter}
        </#if>
    </#list>
</body>
</html>