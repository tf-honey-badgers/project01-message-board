<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JONG'S BOARD</title>
<style type="text/css">
a{
text-decoration: none;
	color: red;
}


</style>
</head>
<body>
<header>
<jsp:include page="/WEB-INF/views/index.jsp" flush="false"></jsp:include>
</header>
<br>
<h1>일단 뿌려 막뿌려 </h1>
<br>
<hr>
<div>
<a href="/board/register_hyun">글쓰기로 이동</a>
</div>
<br><br>
	<div>
		<table>
			<thead>
        		<tr>
        			<td>번호</td>
                    <td>제목</td>
                    <td>작성자</td>
                    <td>등록 일시</td>
                    <td>관리</td>
				</tr>
            </thead>
        	<tbody class="tBody">
        		<c:forEach var="hboard" items="${list}">
	        		<tr>
    	    			<td class="hdent">${hboard.bno}</td>
        				<td class="hTitle">${hboard.title}</td>
         				<td class="hWriter">${hboard.writer}</td>
         				<td class="hRegDate">${hboard.regdate}</td>
    	    			<td>
        					<a href="#" class="modify" id="modBtn">수정</a>&nbsp;<a href="#" class="delete" id="delBtn">삭제</a>
        				</td>
        			</tr>
        		</c:forEach>
        	</tbody>
    	</table>
	</div>
<script type="text/javascript">
	// content 넣고 수정 넣고 del 넣으면 댐 
		
	</script>
</body>
</html>