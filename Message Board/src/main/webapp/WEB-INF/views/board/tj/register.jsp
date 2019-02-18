<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<h1>안녕하세요 여기는 TJ Board 입니다</h1>
	    <h1>공포영화, 떡볶이, 마라탕에 대한 내용만 올려주세요</h1>
	    <form action="/board/tj/register" method="post">
		        제목<input type="text" name="title">
		        타이틀<input type="text" name="content">
		        작성자<input type="text" name="writer">
		        <input type="submit">
    	</form>
</body>
</html>