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
	<a href="/board/tj/modify?bno=${vo.bno}">modify</a>
	<form action="/board/tj/remove" method="post">
		<input type="hidden" id="bno" name="bno">
	<button>삭제</button>
	</form>
	${vo.bno}
	${vo.title}
	${vo.writer}
	${vo.content}
	${vo.regdate}
		<script type="text/javascript">
		window.onload=function(){
				$('#bno').val('${vo.bno}');
		}
		</script>
	
</body>
</html>