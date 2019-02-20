<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JONG'S BOARD</title>
<style type="text/css">
table{
width: 60%;
height: 300px;
margin: auto;
text-align: center;
border: 1px solid blue;

}
a {
	text-decoration: none;
	color: red;
}
li{
   list-style:none;
   display:inline;  
    padding:0 10px;
}
.paging{
text-align: center;

}
.hdent{
color: pink;
}
.tip{
color :blue;

}
</style>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/index.jsp" flush="false"></jsp:include>
	</header>
	<br>
	<h1>일단 뿌려 막뿌려</h1>
	<br>
	<hr>
	<div style=" text-align: center; font-size:20px;">
		<a href="/board/register_hyun">글쓰기로 이동</a><br><br>	
		<a  class="tip" href="#">글 상세보기 및 수정 - 삭제는 해당 라인을 누르세요.</a>
	</div>
	<br>
	<br>
	<div>
		<table>
			<thead>
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>등록 일시</td>
					
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="hboard" items="${list}">
					<tr>
						<!--  번호  -->
						<td class="warp">${hboard.bno}</td>
						<!-- 제목 -->
						<td>${hboard.title}</td>
						<!-- 작성자 -->
						<td>${hboard.writer}</td>
						<!--등록일시 -->
						<td>${hboard.regdate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div class="paging">
			<c:if test="${paging.prev}">
	    		<li>
	    			<a href="/board/list_hyun${paging.makeUri(paging.staretPage - 1)}">10 개 뒤쪽 이동 </a>
	    		</li>    		
    		</c:if>
    		<c:forEach var="idx" begin="${paging.staretPage}" end="${paging.endPage}">
    			<li>
    				<a href="${paging.makeUri(idx)}">${idx}</a>
    			</li>
    		</c:forEach>
    		<c:if test="${paging.next}">
	    		<li>
	    			<a href="/board/list_hyun${paging.makeUri(paging.endPage + 1)}">10 개 앞으로 이동</a>
	    		</li>    		
    		</c:if>
		</div>
		
	</div>
	<script type="text/javascript">
		$('.warp').parent().on('click', function() {
			
		location.href = "http://localhost/board/get_hyun?bno=" + $(this).children(".warp").text();
	});
	</script>
</body>
</html>