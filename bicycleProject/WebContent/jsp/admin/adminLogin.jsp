<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	
	$(function(){
		var msg = '${message}';		
		if(!msg){			
		}
		else{
			alert(msg);			
		}		
	});
</script>

   <meta name="description" content="">
   <meta name="viewport" content="width=device-width, initial-scale=1">
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
</head>
<body>
	   <!-- header-start -->
    <header>
        <div class="header-area ">
            <div id="sticky-header" class="main-header-area">
                <div class="container-fluid">
                    <div class="row align-items-center">
                        <div class="col-xl-3 col-lg-2">
                            <div class="logo">
                                <a href="index.jsp">
                                    <img src="img/Bicycle-logo(2).png" alt="">
                                </a>
                            </div>
                        </div>
                        <div class="col-xl-6 col-lg-7">
                            <div class="main-menu  d-none d-lg-block">
                                <nav>
                                    <ul id="navigation">
                                       <!--  <li><a class="active" href="index.jsp">home</a></li> -->
                                        <li><a href="#">대여소 정보 <i class="ti-angle-down"></i></a>
                                      	 <ul class="submenu">
                                       			<li><a href="point_req_list.do?reqPage=1">대여소 리스트</a></li>
                                     <!--   			<li><a href="point_list_map.do">포인트리스트지도</a></li>
                                            	<li><a href="pointView.do">포인트지도</a></li> -->
                                       	</ul>
<!--                                         <li><a href="#">자전거 대여소 정보 <i class="ti-angle-down"></i></a>
                                            <ul class="submenu">
                                            	<li><a href="bicycle_req_list.do?reqPage=1">자전거 대여소 리스트</a></li>
                                                <li><a href="bicycle_insert_form.do">자전거 대여소 등록</a></li>
                                            </ul>
                                        </li> -->
                                        <li><a href="#">공지사항 <i class="ti-angle-down"></i></a>
                                            <ul class="submenu">
                                                 <li><a href="bicyclent_list">공지사항</a></li>
                                            </ul>
                                        </li>
                       		            <li><a href="#">관리자페이지 <i class="ti-angle-down"></i></a>
                                            <ul class="submenu">
                                                <c:if test="${admin == null}">
													<li><a href="adminLlogin_from.do">관리자 로그인</a></li>
												</c:if>	
                                                <c:if test="${admin != null}">
													<li><a href="logout.do">로그아웃</a></li>
												</c:if>	
                                            </ul>                                   
                                </nav>
                            </div>
                        </div>
                        <div class="col-12">
                            <div class="mobile_menu d-block d-lg-none"></div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </header>
    <!-- header-end -->
    
     <!-- header-end -->
    
		<!-- bradcam_area  -->
			<div class="bradcam_area breadcam_bg_1 black_overlay">
					<div class="container">
						<div class="row">
							<div class="col-xl-12">
								<div class="bradcam_text text-center">
									<h3>관리자 로그인</h3>
								</div>
							</div>
						</div>
					</div>
				</div>
		<!-- / bradcam_area  -->	    
	
	<div class="container" style="border:100px ; padding:50px">		
		<form action="adminLogin.do" method="post">
			  <div class="form-group">
			 	<h1>관리자 로그인</h1>
				<input type="text" class="form-control" name="adminID" id="adminID" placeholder="관리자 ID 입력해주세요."/><br />
				<input type="password" class="form-control" name="adminPassword" id="adminPassword" placeholder="관리자  비밀번호를 입력해주세요."/><br />
				<input type="submit" class="form-control" value="로그인"/><br />
			   </div>
		</form>${message}
	</div>
</body>
</html>