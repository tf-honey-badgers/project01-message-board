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
		<form method="post">	
			<table>
				<thead>
					<tr><td colspan="2"><h3>Modify the No. ${read.bno} Message</h3></td></tr>
				</thead>
				<tbody>
					<tr>
						<td>번호</td>
						<td>${read.bno}</td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name="title" id="title" required value="${read.title}"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><input type="text" name="content" id="content" required value="${read.content}"></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td>${read.writer}</td>
					</tr>
					<tr>
						<td>작성 일시</td>
						<td>${read.regdate}</td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit"></td>
					</tr>
				</tbody>
    		</table>
		</form>
	</div>
</body>
</html>