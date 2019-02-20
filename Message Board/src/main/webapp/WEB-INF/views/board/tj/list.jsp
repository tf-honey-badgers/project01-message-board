<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TJ board</title>
		<style>
		        table, thead, tbody, tr, th, td{
		            border: 1px solid black;
		        }
	    </style>
</head>
<body>
	<jsp:include page="../../include/header.jsp" flush="false"></jsp:include>
		<h1>안녕하세요 여기는 TJ Board 입니다</h1>
	    <h1>공포영화, 떡볶이, 마라탕에 대한 내용만 올려주세요</h1>
	    
	    <a href="./register">공포영화 글쓰기</a>
	    <a href="./register">떡볶이 글쓰기</a>
	    <a href="./register">마라탕 글쓰기</a>
	    
	    <table>
	       <thead>
	         <th>bno</th>
	         <th>title</th>
	         <th>writer</th>
	         <th>regdate</th>
	       </thead>
	       <tbody>
	       <c:forEach var="list" items="${list}">
	       		<tr>
	            <td>${list.bno}</td>
	            <td><a href="/board/tj/get?bno=${list.bno}">${list.title}</a></td>
	            <td>${list.writer}</td>
	            <td>${list.regdate}</td>
	        </tr>
	       </c:forEach>
	       </tbody>
	    </table>
	    
	    <a href="/board/tj/list?page=${pageMaker.startPage-1}&perPageNum=${cri.perPageNum}">이전</a>
	    <c:forEach var="idx" begin="${pageMaker.startPage}" end="${pageMaker.endPage}" step="1" >
	    	<a href="/board/tj/list?page=${idx}&perPageNum=${cri.perPageNum}">${idx}</a>
	    </c:forEach>
	    <a href="/board/tj/list?page=${pageMaker.endPage+1}&perPageNum=${cri.perPageNum}">다음</a>
</body>
</html>