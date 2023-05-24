<%@page import="vo.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
List<Book> randomBook = (List<Book>)request.getAttribute("randomBooks");

List<Book> bestSeller = (List<Book>)request.getAttribute("bestSeller");
for(Book book: randomBook) System.out.println(book.getImgUrl() + "Main Random");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<style>
    .carousel-inner {
      top: 0;
      left: 0;
      width: 300px;
      height: 600px;
    } 
   
  img {
  object-fit: cover;
}
</style>

<body>
<div class="jumbotron text-center">
  <h1>책 관리 페이지</h1> 

</div>
<nav class="navbar navbar-light bg-light">

<ul class="nav justify-content-center">
  <li class="nav-item">
    <a class="nav-link active" href="addBook.html">도서추가</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="getAllBooks">전체 조회</a>
  </li>
</ul>
    <form class="form-inline" method="post" name="search" action="search">
    <input class="form-control mr-sm-2"name="searchText" type="search" placeholder="Search" aria-label="Search" >
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
  </form>
  </nav>
  
  <div style="margin:40px;float: left;">
  <h1>베스트셀러 Top 5</h1>
  <div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel" style="float: left">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100" src="${bestSeller.get(0).getImgUrl()}" alt="First slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="${bestSeller.get(1).getImgUrl()}" alt="Second slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="${bestSeller.get(2).getImgUrl()}" alt="Third slide">
    </div>
  </div>
  </div>
    </div>
    <div style="float:left;margin:40px">
    <h1>관리자의 랜덤추천</h1>
<%
  List<Book> bookList = (List<Book>) request.getAttribute("randomBooks");
  for (Book book : bookList) {%>
<div class="card" style="width: 12rem;float:left;margin:13px;">
  <img class="card-img-top" src="<%=book.getImgUrl() %>" alt="Card image cap">
  <div class="card-body">
    <p class="card-text"><%=book.getTitle() %></p>
  </div>
</div>
<%};
%>

</div>

</body>
</html>