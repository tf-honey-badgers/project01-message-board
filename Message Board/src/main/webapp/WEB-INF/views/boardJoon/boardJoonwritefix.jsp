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
	
	bno : #{bno}<br>
	title : <input type="text" id="title" value="#{title}"><br>
	content : <input type="text" id="content" value="#{content}"><br>
	writer : <input type="text" id="writer" value="#{writer}"><br>
	<input type="button" id="fixbtn" value="수정 완료">
		<script>
		$(document).ready(function(){
			
			$('#fixbtn').on('click',function(){
				
				$.ajax({
            		type : "POST", 
            		url : "../../board/listJoon/boardinsert",
            		data : {title : $('#title').val(),
            			content : $('#content').val(),
            			writer : $('#writer').val()
            			},
            		//dataType : "JSON", 
            		error : function(data,status,error){
            			console.log(data);
            			console.log(status);
            			console.log(error);
            		},
            		
            		success : function(data){
            			console.log(data);
            			alert('완료!');
            			location.href="/board/listJoon";

            		} // success
            	});
				
			});

		});
	
	
	</script>

</body>
</html>