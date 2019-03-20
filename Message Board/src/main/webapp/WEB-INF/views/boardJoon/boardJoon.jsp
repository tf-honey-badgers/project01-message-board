<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL core 라이브러리 도입 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	여기는 게시판입니다.
	<table>
		<tr>
			<td>bno /</td>
			<td>title /</td>
			<td>content /</td>
			<td>writer /</td>
			<td>regdate</td>
			<td>변경하기</td>
		</tr>

		<c:forEach var="board" items="${boardList}">
			<tr class="boardlist">
				<td>${board.bno}</td>
				<td>${board.title}</td>
				<td>${board.content}</td>
				<td>${board.writer}</td>
				<td>${board.regdate}</td>
				<td><a href="../board/listJoon/boardfix?bno=${board.bno}" class="fix">수정 / </a><a
					href="" class="delete">삭제</a></td>
			</tr>
		</c:forEach>
	</table>

	
	<c:if test="${pageMaker.prev}">
		<a href="/board/listJoon${pageMaker.makeQuery(pageMaker.startPage - 1)}">[이전]</a>
	</c:if>
	
	<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="index">
		<a href="/board/listJoon?page=${index}&perPageNum=10">[${index}]</a>
	</c:forEach>
	
	<c:if test="${pageMaker.next }">
		<!--이전버튼과 마찬가지로 다음버튼을 끝 페이지보다 1개 큰게 현재 페이지가 되도록 makeQuery에 page를 넣어줍시다.-->
		<a href="/board/listJoon${pageMaker.makeQuery(pageMaker.endPage + 1)}">[다음]</a>
	</c:if>


	<input type="button" id="write" value="글쓰기">
	<script>
		$(document).ready(
				function() {

					$('.boardlist').on(
							'click',
							'.delete',
							function(e) {

								console.log(this);

								e.preventDefault();

								var thisBno = $(this).parent().parent()
										.children().eq(0).text();
								var thisCon = $(this).parent().parent();

								$.ajax({
									type : "POST",
									url : "../../board/listJoon/boardelete",
									data : {
										bno : thisBno
									},
									//dataType : "JSON", 
									error : function(data, status, error) {
										console.log(data);
										console.log(status);
										console.log(error);
									},

									success : function(data) {
										console.log(data);
										alert('삭제되었습니다.');
										thisCon.remove();
										location.href = "/board/listJoon?page=1&perPageNum=10";

									} // success
								}); // ajax

							});

					$('#write').on('click', function() {

						location.href = "../board/listJoon/boardJoonwrite";
					});

/* 					$('.fix').on(
							'click',
							function(e) {

								e.preventDefault();

								var thisBno = $(this).parent().parent()
										.children().eq(0).text();

								$.ajax({
									type : "POST",
									url : "../board/listJoon/boardfix",
									data : {
										bno : thisBno
									},
									//dataType : "JSON",
									error : function(data, status, error) {
										console.log(data);
										console.log(status);
										console.log(error);
									},

									success : function(data) {
										console.log(data);
										location.href="../board/listJoon/boardfix";

									} // success
								}); // ajax

							}); */

				});
	</script>

</body>
</html>