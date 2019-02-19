<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- JSTL core 라이브러리 도입 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Honey Badgers</title>
	<!-- CSS 설정을 외부 파일로 분리 -->
	<link rel="stylesheet" href="/resources/css/board.css">
	<!-- jQuery를 사용하기 위한 라이브러리 도입 -->
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<!-- "header.jsp" -> 모든 페이지에서 공통적으로 사용해야하기에 외부파일로 분리 -->
	<jsp:include page="../include/header.jsp" flush="false"></jsp:include>
	
	<!-- 속성 중 "message" 속성이 존재할 경우, 페이지 로딩 후 팝업창으로 보여준다. -->
	<c:if test="${not empty message}">
    	<script>
    		$(document).ready(function() { alert("${message}"); });
    	</script>
	</c:if>
	
	<div class="list" style="width: 80%; margin: 0px auto;">
		<table>
			<thead>
				<tr><td colspan="2"><h3>The No. ${read.bno} Message</h3></td></tr>
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
    	
    	<a href="http://localhost/board/modifyYuriel?bno=${read.bno}" class="modify" id="modBtn">수정</a>
    	<a href="#" class="delete" id="delBtn">삭제</a>
    	
    	<script type="text/javascript">
    		var msgNum = ${read.bno};
    		
    		$("#delBtn").on("click", function() {
    			if(confirm("정말로 삭제하시겠습니까?")) {
    				$.ajax({
                		url : '/board/removeYuriel',
                		type : 'POST',
                		data : {bno : msgNum},
                		error : function() {
                			alert("삭제하는데 에러가 발생했습니다.");
                		},
                		success : function(data) {
                			alert("성공적으로 삭제했습니다.");
                			location.href = "http://localhost/board/listYuriel";
                		}
    				});
    			};
    		});
    	</script>
	</div>
</body>
</html>