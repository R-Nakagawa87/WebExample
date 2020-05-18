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
<table>
<tr>
<th>売上UID</th> <th>売上SID</th> <th>販売個数</th> <th>販売日</th></tr>
<c:forEach var="uriage" items="${ list }">
<tr>	<td>${ uriage.uid}</td>
		<td>${ uriage.sid}</td>
		 <td>${ uriage.kosu }</td>
		 <td>${ uriage.hi }</td>
</tr>
</c:forEach>
</table>

</body>
</html>