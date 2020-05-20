<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>売り上げ情報</title>
</head>

<style>
td,th{
	border:1px solid black;
	padding:0.2em 0.5em;
}
table{
	border-collapse:collapse;
}
</style>

<body>

<h1>売り上げ情報</h1>

<table>
<tr>
	<th>商品名</th>
	<th>日付</th>
	<th>個数</th>
</tr>
<c:forEach var="uriage" items="${ list }">
<tr>
	<td>${ shouhin.sname }</td>
	<td>${ uriage.hi }</td>
	<td>${ uriage.kosu }</td>
</tr>
</c:forEach>
</table>


<form action = "uriage" method = "post">
<input type = "hidden" name = "sidStr" value = "${ uriage.sid }">
個数：<input type = "text" name = "kosuStr" required="required"><br>
<input type = "submit" value = "追加">
</form>

</body>
</html>