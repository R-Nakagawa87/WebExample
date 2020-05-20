<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action = "mupdate" method = "get">
<input type = "hidden" name = "sidStr" value = ${ shouhin.sid}>
氏名：<input type = "text" name = "name" value = ${ shouhin.sname }><br>
住所：<input type = "text" name = "adr"  value = ${ shouhin.tanka }><br>
<input type = "submit" value = "送信">
</form>

</body>
</html>