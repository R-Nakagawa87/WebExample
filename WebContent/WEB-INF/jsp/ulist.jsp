<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>売上一覧</title>

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
<h1>売上リスト</h1>

<p>ようこそ、${ user.uname }さん( ${ user.mail } )</p>

<p><a href="logout">ログアウト</a></p>
<p><a href="uinsert">追加</a></p>

<table>
<tr>
<th>売上ID</th> <th>商品ID</th> <th>販売個数</th> <th>販売日</th></tr>
<c:forEach var="uriage" items="${ list }">
<tr>	<td>${ uriage.uid}</td>
		<td>${ uriage.sid}</td>
		 <td>${ uriage.kosu }</td>
		 <td>${ uriage.hi }</td>
		 <td><a href="uinfo?uidStr=${ uriage.uid}">売上情報</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>