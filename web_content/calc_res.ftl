<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h3>Calc Page</h3>
result: ${result}

<p>person: ${p.id} : ${p.name}</p>
<p>person: ${p.getId()} : ${p.getName()}</p>
<p>person: ${p.getId()} : ${p.getNameUpper()}</p>

<table border="1">
    <#list people as person>
    <tr><td>${person.id}</td><td>${person.name}</td></tr>
    </#list>
</table>

<a href="/home">go home</a>
<a href="/hello">go hello</a>
</body>
</html>