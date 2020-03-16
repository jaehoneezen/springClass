<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${i == 0}">
		회원가입 안됨!
	</c:if>
	<c:if test="${i > 0}">
		${memberDto.id} <br>	
		${memberDto.password} <br>
		${memberDto.name} <br>
		${memberDto.email} <br>
	</c:if>
	
</body>
</html>