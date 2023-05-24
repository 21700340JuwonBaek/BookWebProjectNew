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
		margin-bottom: 50px;
	}
	
	.row {
		background-color: #DCDCDC;
		margin-bottom: 20px;
	}
	
	.col-md-9 img {
        max-width: 200px;
        height: auto;
        display: flex;
    	align-items: center;
        
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
			List<Book> bookList = (List<Book>)request.getAttribute("bookList");
			for(Book book : bookList) {
		%>
		<div class="row">
			<div class="col-md-9">
				<a href="detail?author=<%=book.getAuthor()%>">
					<img src="<%= book.getImgUrl() %>"
						style="width: 50%; max-width: 150px; height: auto;">
				 	 <h3>
				 	 	제목 :<%=book.getTitle()%> 
				 	 </h3>
				</a>
				<p><%=book.getAuthor()%> | <%=book.getCompany()%> | <%=book.getPrice()%>원</p>
				<p>재고 : <%=book.getRemain()%>권  |  판매량 : <%=book.getSaledNum()%>권</p>
			</div>
			<div class="col-md-2" style="padding-top: 10px">
				<a href="updateGetInfo?id=<%=book.getId()%>"
					class="btn btn-secondary" role="button">       수정 &raquo;</a>
				<a href="delete?id=<%=book.getId()%>"
					class="btn btn-secondary" role="button">       삭제 &raquo;</a>

				<a href="buy?id=<%=book.getId()%>&remainNum=<%=book.getRemain()%>&saledNum=<%=book.getSaledNum()%>"
                class="btn btn-secondary" role="button">구매 &raquo;</a>
			</div>
		</div>
		<%
			}
		%>
	</div>
</body>
</html>