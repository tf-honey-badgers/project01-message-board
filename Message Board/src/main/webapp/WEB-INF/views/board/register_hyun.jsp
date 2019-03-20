<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 등록하기</title>
<style type="text/css"></style>
<style>
h1{
text-align: center;
}
.registdiv {
	width: 300px;
	border: 1px solid silver;
	text-align:center;
	position:absolute; 
	top:50%;

	left:50%;
	 width:300px; 
	 height:200px;
	  overflow:hidden; 
	  background-color:#ffccf0 ;
	   margin-top:-150px; 
	   margin-left:-100px;

}
</style>
</head>

<body>

	<header>
		<jsp:include page="/WEB-INF/views/index.jsp" flush="false"></jsp:include>
	</header>
<h1>글쓰기</h1>
	<div class="registdiv">
	
		<form method="post">
			<label for="title">제목 : </label> 
			
			<input type="text" name="title"id="title" required> <br> 
			
			<label for="content">내용: </label> 
			
			<input type="text" name="content" id="content" required><br>
			
			 <label for="writer">글쓴이 : </label> 
			 
			 <input type="text"name="writer" id="writer" required> <br> 
			 
			 <input type="submit" value="글쓰기">
		</form>
	</div>

</body>
</html>
