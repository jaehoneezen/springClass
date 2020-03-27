<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form method="post">
			<div class="form-group">
				<label for="title">제목:</label> <input type="text" class="form-control" id="title" name="title" value="${article.title}">
			</div>
			<div class="form-group">
				<label for="content">내용:</label>
				<textarea class="form-control" id="content"	name="content">
					${article.content}
			  	</textarea>
			</div>
			<div>
				<button type="submit" class="btn btn-success">등록</button>
			</div>
		</form>
	</div>
</body>
</html>