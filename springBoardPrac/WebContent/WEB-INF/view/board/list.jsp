<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<title>Board List</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<!-- Links -->
		<a class="navbar-brand" href="javascript:void(0)">Logo</a>
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="#">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="#">휴강</a></li>
			<li class="nav-item"><a class="nav-link" href="#">종강</a></li>
		</ul>
		<form class="form-inline my-2 my-lg-0" action="/action_page.php">
			<input class="form-control mr-sm-2" type="text" placeholder="Search">
			<button class="btn btn-success" type="submit">Search</button>
		</form>
	</nav>

	<div class="container">
		<h2>Board List</h2>
		<table class="table table-hover">
			<thead class="thead-dark">
				<tr>
					<th>no</th>
					<th>title</th>
					<th>writer</th>
					<th>view</th>
					<th>date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="article" items="${articles}">
					<tr onclick="location.href='read?no=${article.board_idx}'">
						<td>${article.board_idx}</td>
						<td>${article.title}</td>
						<td>${article.id}</td>
						<td>${article.view_count}</td>
						<td>${article.reg_date}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<button class="btn btn-danger" onclick="location.href='write'">글쓰기</button>
		</div>
	</div>
</body>
</html>