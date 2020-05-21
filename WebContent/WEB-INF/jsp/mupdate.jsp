<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メンバー情報</title>
</head>
<body>

<form action = "mupdate" method = "post">
<input type = "hidden" name = "action" value = "update">
<input type = "hidden" name = "midStr" value = ${ member.mid}>
氏名：<input type = "text" name = "name" value = ${ member.name }><br>
住所：<input type = "text" name = "adr"  value = ${ member.adr }><br>
<input type = "submit" value = "変更">
<br>
</form>

<form action = "mupdate" method = "post">
<input type = "hidden" name = "action" value = "del">
<input type = "hidden" name = "midStr" value = ${ member.mid}>
<input type = "hidden" name = "name" value = ${ member.name }>
<input type = "hidden" name = "adr"  value = ${ member.adr }>
<input type = "submit" value = "削除">
</form>

</body>
</html>