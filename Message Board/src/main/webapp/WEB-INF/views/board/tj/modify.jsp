<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<form action="/board/tj//modify" method="post">
		<input type="hidden" id="bno" name="bno">${vo.bno}
		<input type="text" id ="title" name="title">${vo.title}
		<input type="text" id ="writer" name="writer">${vo.writer}
		<input type="text" id ="content" name="content">${vo.content}
		<button>제출</button>
	</form>
	
	<script type="text/javascript">
		window.onload=function(){
			$('#bno').val('${vo.bno}');
	        $('#title').val('${vo.title}');
	        $('#writer').val('${vo.writer}');
	        $('#content').val('${vo.content}');
	    }
		
	
	</script>
</body>
</html>