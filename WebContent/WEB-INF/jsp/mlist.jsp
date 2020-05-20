<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メンバー一覧</title>
<style>
th,td{
	border:1px solid #000000;
	padding:0.2em 0.5em;
}
table{
	border-collapse:collapse;

}

</style>
</head>
<body>

<h1>メンバーリスト</h1>

<form action = "mlist" method = "post">
氏名：<input type = "text" name = "name"><br>
住所：<input type = "text" name = "adr"><br>
<input type = "submit" value = "追加"><br>
<br>
</form>

<table>
<tr>
<th>メンバーID</th> <th>氏名</th> <th>住所</th></tr>
<c:forEach var="member" items="${ list }">
<tr>	<td>${ member.mid }</td>
		 <td><a href="mupdate?midStr=${ member.mid }">${ member.name }</a></td>
		 <td>${member.adr }</td>

</tr>
</c:forEach>
</table>



</body>
</html>