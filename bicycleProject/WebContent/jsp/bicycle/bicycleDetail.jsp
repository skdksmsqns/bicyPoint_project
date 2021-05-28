<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- 자바기본문 쓰기 -->
<!DOCTYPE html >
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		
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

	<div class="container" style="border:100px ; padding:50px">		
		<form action="bicycle_update.do" method="post">
			<div class="form-group">
		      <label for="notice_title">bicycleNum：</label>
		       <input  type="text" class="form-control" disabled="disabled" name="id" value="${bicycleinfo.bicycleNum}" /><br /><br />
		    </div>
		    
		    <div class="form-group">
		      <label for="notice_title">bicycleAddr：</label>
		      <input  type="text" class="form-control" disabled="disabled" name="bicycleAddr" value="${bicycleinfo.bicycleAddr}" /><br /><br />
		    </div>
		    
		   	<div class="form-group">
		      <label for="notice_title">bicycleTel：</label>
		      <input  type="text" class="form-control" disabled="disabled" name="bicycleTel" value="${bicycleinfo.bicycleTel}" /><br /><br />
		    </div>	
		    
		    <a href="bicycle_delete.do?bicycleNum=${bicycleinfo.bicycleNum}" class="genric-btn primary circle">삭제</a>
			<a href="bicycle_list.do" class="genric-btn primary circle">자전거 대여소  리스트 이동</a></h1></li>
		</form>
	</div>			
	</body>
</html>