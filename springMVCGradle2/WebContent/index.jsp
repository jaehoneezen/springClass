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
</body>
</html>