<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
	function bookSearch() {
		var type = $("#searchType option:selected").val()
		var value = $("#value").val();
		var url = "bookSearch/" + type + "/" + value;

		$.ajax({
			type : "get",
			url : url,
			dataType : "json"
		}).done(function(args) {
			$("#booksInfo li").remove();
			for (book in args) {
				var li = "<li>" + args[book].bookid + "/" + args[book].bookname + "/" + args[book].publisher + "/" + args[book].price + "</li>";
				$("#booksInfo").append(li);
			}
			console.log(args);
		}).fail(function(e) {
			alert(e.responseText);
		});
	}
</script>
</head>
<body>
	<select id="searchType">
		<option value="bname" id="bname">책이름</option>
		<option value="cname" id="cname">고객명</option>
	</select>
	검색어 : <input type="text" name="value" id="value">
	<input type="button" id="searchBook" onclick="bookSearch()" value="검색">
	<br>
	<ul id="booksInfo">
	</ul>
</body>
</html>