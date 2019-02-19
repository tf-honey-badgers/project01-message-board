<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
width: 60%;
height: 300px;
margin: auto;
text-align: center;
border: 1px solid blue;

}

</style>
</head>
<body>
<!-- 수정할곳  -->


	<header>
		<jsp:include page="/WEB-INF/views/index.jsp" flush="false"></jsp:include>
	</header>

	<hr>
메롱 메롱 	
<div class="list" style="width: 80%; margin: 0px auto;">
		<form method="post">	
			<table>
				<thead>
					<tr><td colspan="2"><h1>이곳은 수정의 방입니다. 크리스탈 </h1> </td></tr>
				</thead>
				<tbody>
					<tr>
					
						<td>번호(이건 수정 못해요 ...)</td>
						<td>${read.bno}</td>
					</tr>
					<tr>
						<td>제목(이건 수정 당 근 빠따죠 )</td>
						<td><input type="text" name="title" id="title" required value="${read.title}"></td>
					</tr>
					<tr>
						<td>내용(이것도 바꿀수 잇죠 참쉽죠! )</td>
						<td><input type="text" name="content" id="content" required value="${read.content}"></td>
					</tr>
					<tr>
					
						<td>작성자(이것두 수정 못해요 ...)</td>
						<td>${read.writer}</td>
					</tr>
					<tr>
					
						<td>작성 일시(역시나  수정 못해요 ...)</td>
						<td>${read.regdate}</td>
					</tr>
					<tr>
				
						<td colspan="3"><input type="submit" style="size:30px;"></td>
					</tr>
				</tbody>
    		</table>
		</form>
	</div>
</body>
</html>
	