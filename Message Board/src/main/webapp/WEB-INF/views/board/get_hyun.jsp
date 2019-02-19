<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/index.jsp" flush="false"></jsp:include>
	</header>
	<table>
		<thead>
			<tr>
				<td> ${read.bno}</h3></td>
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
</body>
</html>