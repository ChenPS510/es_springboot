<!DOCTYPE html>
<html lang="en">
<head>
      
    <meta charset="UTF-8">
      <title>FreeMarkerTest</title>
    <style type="text/css">
        em {
            color: red;
            font-size: medium;
        }
    </style>
</head>
<body>
<#--遍历List集合-->
<table border="1">
<#list poetries as poe>
    <tr>
        <td>${poe.id}</td>
        <td>${poe.title}</td>
        <td>${poe.content}</td>
        <td>${poe.poet.id}</td>
        <td>${poe.poet.name}</td>
    </tr>
</#list>
</table>
</body>
</html>