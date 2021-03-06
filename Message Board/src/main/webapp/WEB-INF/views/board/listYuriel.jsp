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
	
	<h1>List of messages : Find yours~! ((whisper) ...if you think you can)</h1>
	
	<div class="list" style="width: 80%; margin: 0px auto;">
		<table>
			<thead>
        		<tr>
        			<td>번호</td>
                    <td>제목</td>
                    <td>작성자</td>
                    <td>등록 일시</td>
				</tr>
            </thead>
        	<tbody class="tableBody">
        		<c:forEach var="item" items="${list}">
	        		<tr>
    	    			<td class="ident">${item.bno}</td>
        				<td class="iTitle">${item.title}</td>
         				<td class="iWriter">${item.writer}</td>
         				<td class="iRegDate">${item.regdate}</td>
        			</tr>
        		</c:forEach>
        	</tbody>
    	</table>
    	
    	<ul class="paging">
    		<c:if test="${paging.prev}">
	    		<li>
	    			<a href="/board/listYuriel${paging.makeUri(paging.firstPage - 1)}">&laquo;</a>
	    		</li>    		
    		</c:if>
    		<c:forEach var="idx" begin="${paging.firstPage}" end="${paging.lastPage}">
    			<li>
    				<a href="${paging.makeUri(idx)}">${idx}</a>
    			</li>
    		</c:forEach>
    		<c:if test="${paging.next}">
	    		<li>
	    			<a href="/board/listYuriel${paging.makeUri(paging.lastPage + 1)}">&raquo;</a>
	    		</li>    		
    		</c:if>
    	</ul>
	</div>
	
	<script type="text/javascript">
		$('.ident').parent().on('click', function() {
			location.href = "http://localhost/board/getYuriel?bno=" + $(this).children(".ident").text();
		});
	</script>
</body>
</html>