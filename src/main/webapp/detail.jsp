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
    
     

    .book-info img {
        max-width: 150px;
        height: auto;
        margin-right: 20px;
        float : left;
    }
</style>
<title>도서 목록</title>
</head>

<body>
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-4">도서 정보</h1>
        </div>
    </div>
    <div class="container">
        <%
            @SuppressWarnings("unchecked")
            List<Book> bookDetail = (List<Book>)request.getAttribute("detaildBook");
            for(Book book : bookDetail) {
        %>
        <div class="row">
        	<div class="book-info">
				<img src="<%= book.getImgUrl() %>"
						style="width: 50%; max-width: 150px; height: auto;" >
			</div>
			<div class="col-md-8">
                <h4><b><%= book.getTitle() %></b></h4>
                <p><b>저자</b> : <%=book.getAuthor()%></p>
                <p><b>출판사</b> : <%=book.getCompany()%></p>
                <p><b>출판일</b> : <%=book.getWrittenDate()%></p>
                <p><b>재고수</b> : <%=book.getRemain()%></p>
                <h4><%=book.getPrice()%>원</h4>
            </div>
        </div>
        <%
            }
        %>
    </div>
</body>

</html>