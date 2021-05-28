<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- 자바기본문 쓰기 -->

<!DOCTYPE html>
<html>
<head>
<title>회원가입 폼</title>

<style type="text/css">
table, td{
border:1pxsolid red
}
table{
width:60%;
height:100px;
margin:auto;
text-align:center;
}
</style>
	<meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- <link rel="manifest" href="site.webmanifest"> -->
    <!-- Place favicon.ico in the root directory -->

    <!-- CSS here -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <link rel="stylesheet" href="css/nice-select.css">
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/gijgo.css">
    <link rel="stylesheet" href="css/animate.min.css">
    <link rel="stylesheet" href="css/slick.css">
    <link rel="stylesheet" href="css/slicknav.css">
    <link rel="stylesheet" href="css/style.css">
    <!-- <link rel="stylesheet" href="css/responsive.css"> -->
</head>
<body>
      	<div id="page">
		<header>
		<div id="main">
			<aside>
				<jsp:include page="/jsp/includ/nav.jsp" />
			</aside>
		</div>
		</header>
	</div>
	<table>
		<tr>
			<td>
				<div class="container">
					<h1>
						<span class="bg-primary text-white">대여소 등록</span>
					</h1>

					<form method="post" action="bicycle_insert">
						대여소 주소<input type="text" class="form-control"placeholder="자전거 대여소 주소를 입력하세요" name="bicycleAddr" /><br />
						대여소 전화번호<input type="text" class="form-control"placeholder="자전거 대여소 전화번호를 입력하세요" name="bicycleTel" /><br /> 
						<input type="reset" value="초기화" /> <input type="submit" value="등록" />
					</form>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>