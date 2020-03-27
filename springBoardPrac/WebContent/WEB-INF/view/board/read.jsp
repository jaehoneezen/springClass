<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<title>게시판 - 읽기</title>
</head>
<body>
	<div class="container">
		<table class="table table-hover" style="border:solid 1px">
			<thead class="thead-dark">
				<tr>
					<th>제목</th>
					<td colspan="3">${article.title}</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${article.id}</td>
					<th>작성일</th>
					<td>${article.reg_date}</td>
				</tr>
			
				<tr style="height:200px">
					<th style="vertical-align:middle">내용</th>
					<td colspan="3" style="vertical-align:middle">${article.content}</td>				
				</tr>
			</thead>
		</table>
		<div style="text-align:right">
			<button onclick="location.href='update?np=${article.board_idx}'" class="btn btn-warning">수정</button>
			<button onclick="location.href='delete?no=${article.board_idx}'" class="btn btn-danger">삭제</button>
			<button class="btn btn-success" onclick="location.href='list'">목록</button>
		</div>
	</div>
</body>
</html>