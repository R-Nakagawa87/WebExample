<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
</head>
<body>

<h1>入力の確認</h1>
<p>以下の内容で削除します。よろしいですか？</p>
<br>
<p>商品ID：${ shouhin.sid }</p>
<p>商品名：${ shouhin.sname }</p>
<p>単価：${ shouhin.tanka }</p>
<br>
<br>

<form action = "del" method = "post">
<input type = "hidden" name = "sidStr" value = "${ shouhin.sid }"><br>
<input type = "submit" value = "削除">
</form>

</body>
</html>