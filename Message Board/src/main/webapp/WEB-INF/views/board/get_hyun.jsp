<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<style>
a{
text-decoration: none;
	color: black;
}

</style>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/index.jsp" flush="false"></jsp:include>
	</header>

	<hr>
	<div>
		<a href="/board/register_hyun">글쓰기로 이동</a>
	</div>
	<br>
	<br>


	<table>
		<thead>
			<tr>
				<td>우리집 에 왜왔니 왜왓니?</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>번호</td>
				<td>${read.bno}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${read.title}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${read.content}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${read.writer}</td>
			</tr>
			<tr>
				<td>작성 일시</td>
				<td>${read.regdate}</td>
			</tr>
		</tbody>
	</table>
	<button>  <a href="http://localhost/board/modify_hyun?bno=${read.bno}">수정</a></button>
    <button id="delete">	삭제   </button>
    
    <script type="text/javascript">
    		var msgNum = ${read.bno};
    		
    		$("#delete").on("click", function() {
    			if(confirm("삭제해도 괜찮나요 ? ")) {
    				$.ajax({
                		url : '/board/remove',
                		type : 'POST',
                		data : {bno : msgNum},
                		error : function() {
                			alert("낚낚~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                		},
                		success : function(data) {
                			alert("아~휴 당연히 형(누나) 오는거 기다렸죠 ~~~ ");
                			location.href = "http://localhost/board/list_hyun";
                		}
    				});
    			};
    		});
    	</script>
    
    
    
    
    
</body>
</html>