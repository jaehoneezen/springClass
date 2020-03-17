<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>로그인</title>
</head>
<body>
	<!-- form 태그는 기본값이 post  -->
	<form:form commandName="loginCommand">
		<!-- global error form -->
		<form:errors element="div" />
		<!-- loginCommand 랑 binding ex) loginCommand.userId -->
		아이디: <form:input path="userId" />
		<form:errors path="userId" />
		<br />
		암호: <form:password path="password" showPassword="false" />
		<form:errors path="password" />
		<br />
		<input type="submit" />
	</form:form>
</body>
</html>
