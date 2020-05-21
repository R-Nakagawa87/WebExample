<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>

<h1>ログイン</h1>

<p>${ mes }</p>

<form action = "login" method = "post">
ユーザー名：<input type = "text" name = "name"><br>
パスワード：<input type = "text" name = "pass"><br>
<input type = "submit" value = "ログイン">
<br>
</form>

</body>
</html>