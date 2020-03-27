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
	<a href="account/create.do">create do</a> <br>
	<a href="game/users/madvirus/characters/1">@Pathvariable</a> <br>
	<a href="login/login.do">로그인</a> <br>
	<a href="report/submission.do">파일업로드</a> <br>
	<a href="log/query.do">date 포맷</a> <br>
	<a href="event/list.do">인터셉터</a><br>
	S::예외 <br>
	<a href="math/add.do">예외발생</a> <br>
	<a href="math/divide.do?op1=100&op2=0">arithmeticException</a> <br>
	<a href="search/game.do">null발생</a> <br>
	E::예외 <br>
	
	<a href="test/simpleTest.do">simpleTest.do</a><br>
	<a href="test/simpleTest1.do">simpleTest1.do</a><br>
	<a href="test/simpleTest2.do">simpleTest2.do</a><br>
	
	<a href="emp/empInfo.do">ajax활용</a><br>
	
	<a href="book/bookInfo.do">책검색</a><br>
	
	<a href="download/file">다운로드</a><br>
	<a href="download/pageRanks">엑셀 다운로드</a><br>
	<a href="download/pageReport">pdf 다운로드</a><br>
	<a href="download/pageXmlReport">xml view</a><br>
	<a href="download/pageJsonReport">json view</a><br>
	
</body>
</html>
