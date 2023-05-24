<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% 
int id = (int)request.getAttribute("id"); 
String title = (String)request.getAttribute("title"); 
String author = (String)request.getAttribute("author"); 
Date writtenDate = (Date)request.getAttribute("writtenDate"); 
String company = (String)request.getAttribute("company"); 
int price = (int)request.getAttribute("price"); 
String category = (String)request.getAttribute("category"); 
int remain = (int)request.getAttribute("remain"); 
int saledNum = (int)request.getAttribute("saledNum"); 
String imgUrl = (String)request.getAttribute("imgUrl"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap')
	;

* {
	font-family: 'Noto Sans KR', sans-serif;
}

body {
	background-color: #1BBC9B;
}

div {
	margin: auto;
	width: 600px;
	border-radius: 5px;
	text-align: center;
	padding: 20px;
}

input {
	width: 100%;
	padding: 10px;
	box-sizing: border-box;
	border-radius: 5px;
	border: none;
}

.in {
	margin-bottom: 10px;
}

#btn {
	background-color: #1BBC9B;
	margin-bottom: 30px;
	color: white;
}

a {
	text-decoration: none;
	color: #9B9B9B;
	font-size: 12px;
}
</style>

<body>
	<div style="width: auto; height: 150px;" class="jumbotron text-center">
		<h1>도서 추가</h1>
	</div>
	<div style="background-color: #EEEFF1;">
		<form method="post" action="update">
			<input type="hidden" name="id" value="${id}" class="in">
			<input type="text" name="title" value="${title}" class="in">
			<input type="text" name="author" value="${author }" class="in">
			<input type="text" name="writtenDate" value="${writtenDate }" class="in">
			<input type="text" name="company" value="${company }" class="in">
			<input type="text" name="price" value="${price }" class="in">
			<input type="text" name="category" value="${category }" class="in">
			<input type="text" name="remain" value="${remain }" class="in">
			<input type="text" name="saledNum" value="${saledNum}" class="in">
			<input type="text" name="imgUrl" value="${imgUrl}" class="in">
			<input onclick="alert('도서 추가 성공');" type="submit" id="btn" value="추가"><br>
		</form>
	</div>
</body>
</html>