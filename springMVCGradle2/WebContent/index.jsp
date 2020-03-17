<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
hello <br>
	<a href="insert.do">insert</a> <br>
	<a href="order/order.do">order</a> <br>
	<a href="search/internal.do?query=abc&p=10">@RequestParam1</a> <br>
	<a href="search/external.do">@RequestParam2</a> <br>
	<a href="cookie/make.do">/cookie/make.do</a> <br>
	<a href="cookie/view.do">/cookie/view.do</a> <br>
	<a href="header/check.do">/header/check.do</a> <br>
	<a href="search/main.do">model데이터 생성</a> <br>
	<a href="account/create.do">create do</a>
	<a href="game/users/madvirus/characters/1">@Pathvariable</a>
	<a href="login/login.do">로그인</a>
</body>
</html>