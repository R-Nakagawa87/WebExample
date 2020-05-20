<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>売上情報</title>
</head>
<body>

<h1>売上情報</h1>

<p>売上ID：${uriage.uid }</p>
<p>商品ID：${shouhin.sid }</p>
<p>商品名：${ shouhin.sname }</p>
<p>単価：${ shouhin.tanka }</p>
<p>個数：${ uriage.kosu }</p>
<p>金額：${uriage.kosu * shouhin.tanka}</p>
<p>日付：${ uriage.hi }</p>


</body>
</html>