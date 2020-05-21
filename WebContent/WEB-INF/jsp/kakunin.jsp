<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
</head>
<body>

<h1>入力の確認</h1>
<p>以下の内容で追加します。よろしいですか？</p>
<br>
<p>商品名：<c:out value = "${ shouhin.sname }"/></p>
<p>単価：${ shouhin.tanka }</p>
<br>
<br>

<form action = "insert" method = "post">
<input type = "submit" value = "追加">
</form>


</body>
</html>