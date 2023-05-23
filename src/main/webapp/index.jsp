<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
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
	<div style="width:auto; height: 150px;"  class="jumbotron text-center">
		<h1>도서 관리 프로그램</h1>
	</div>
	<div style="background-color: #EEEFF1;">
		<form method="post" action="login">
			<input type="text" name="id" placeholder="아이디" class="in"> <input
				type="password" name="pw" placeholder="비밀번호" class="in"> <input
				 type="submit" id="btn" value="로그인"><br>
		</form>
		<a href="#none">비밀번호를 잊어버리셨나요?</a>
	</div>
</body>
</html>