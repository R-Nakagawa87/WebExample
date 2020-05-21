<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メモ一覧</title>
</head>
<body>

<h1>Memo</h1>

<ul>
<c:forEach var="memolist" items="${ list }">
	<li><a href="memo?midStr=${ memolist.mid}">${ memolist.title }</a></li>
</c:forEach>
</ul>


</body>
</html>