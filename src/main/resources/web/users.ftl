<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FirstTitle</title>
</head>
<body>
    <ul>
    <#list users as user>
        <li>${user.name}</li>
    </#list>
    </ul>
</body>
</html>