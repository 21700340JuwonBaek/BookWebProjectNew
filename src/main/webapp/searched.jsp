<%@page import="vo.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
<style>
	.jumbotron {
		background-color: #FFF0F5;
		padding: 20px;
		margin-bottom: 30px;
	}
	
	.row {
		background-color: #DCDCDC;
	}
</style>
<title>도서 목록</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">도서 목록</h1>
		</div>
	</div>
	<div class="container">
		<%
			@SuppressWarnings("unchecked")
			List<Book> bookList = (List<Book>)request.getAttribute("searchedBook");
			for(Book book : bookList) {
		%>
		<div class="row">
			<div class="col-md-7">
				<h3>
					제목 : <%=book.getTitle()%>
				</h3>				
				<p><%=book.getAuthor()%> | <%=book.getCompany()%> | <%=book.getPrice()%>원</p>
				<p>재고 : <%=book.getRemain()%>권  |  판매량 : <%=book.getSaledNum()%>권 </p>
			</div>
			<div class="col-md-2" style="padding-top: 10px">
				<a href="updateGetInfo?id=<%=book.getId()%>"
					class="btn btn-secondary" role="button">       수정 &raquo;</a>
				<a href="delete?id=<%=book.getId()%>"
					class="btn btn-secondary" role="button">       삭제 &raquo;</a>
			</div>
		</div>
		<%
			}
		%>
	</div>
</body>
</html>