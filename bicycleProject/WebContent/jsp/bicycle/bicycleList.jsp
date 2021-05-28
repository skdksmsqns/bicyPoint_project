<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- 자바기본문 쓰기 -->
<!doctype html>
<html class="no-js" lang="zxx">

<head>
	<meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
	    <div class="container" style="border:100px ; padding:50px">	
		  <table class="table table-bordered">
		    <thead>
		      <tr>
				<td>자전거 대여소 no</td>
				<td>대여소 주소</td>
				<td>대여소 전화번호</td>
		      </tr>
		    </thead>
		    	<c:forEach var="bicycles" items="${bicycles}">
		      <tr>
		        <td>${bicycles.bicycleNum}</td>
				<td><a href="bicycle_detail.do?bicycleNum=${bicycles.bicycleNum}">${bicycles.bicycleAddr}</a></td>
				<td>${bicycles.bicycleTel}</td>
		      </tr>      
		   		</c:forEach>
		    </tbody>
		  </table>
		</div>
	
	
<!-- 페이지 처리부분 -->
		<div class="container">
		<ul class="pagination" style="position: relative; left: 450px">
			<c:if test="${pageGroupResult.beforePage}">
				 <li class="page-item"><a class="page-link" href="bicycle_req_list.do?reqPage=${pageGroupResult.groupStartNumber-1}">◁</a></li>
			</c:if>
				
			<c:forEach var ="index" begin="${pageGroupResult.groupStartNumber}" end="${pageGroupResult.groupEndNumber}">
				<c:choose>
				
					<c:when test="${pageGroupResult.selectPageNumber==index}"> 
						 <li class="page-item active"><span id="sel"><a class="page-link" href="bicycle_req_list.do?reqPage=${index}">${index}</a></span></li>
					</c:when>
					
					<c:otherwise>
						 <li class="page-item"><a class="page-link" href="bicycle_req_list.do?reqPage=${index}">${index}</a></li>
					</c:otherwise>
					
				</c:choose>	
			</c:forEach>
			
			<c:if test="${pageGroupResult.afterPage}">
				<li class="page-item"><a class="page-link" href="bicycle_req_list.do?reqPage=${pageGroupResult.groupEndNumber+1}">▷</a></li>
			</c:if>
		</ul>
	</div>	
	    
						
		
    <!-- footer start -->
    <footer class="footer">
			<div class="copy-right_text">
				<div class="container">
					<div class="row align-items-center">
						<div class="col-xl-7 col-md-8">
							<p class="copy_right ">
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							</p>
						</div>
						<div class="col-xl-5 col-md-4">
							<div class="socail_links">
								<ul>
									<li>
										<a href="#">
											<i class="ti-facebook"></i>
										</a>
									</li>
									<li>
										<a href="#">
											<i class="ti-twitter-alt"></i>
										</a>
									</li>
									<li>
										<a href="#">
											<i class="fa fa-instagram"></i>
										</a>
									</li>
								</ul>
							</div>
						</div>
						
					</div>
				</div>
			</div>
		</footer>
		<!--/ footer end  -->

	<!-- JS here -->
	<script src="js/vendor/modernizr-3.5.0.min.js"></script>
	<script src="js/vendor/jquery-1.12.4.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/isotope.pkgd.min.js"></script>
	<script src="js/ajax-form.js"></script>
	<script src="js/waypoints.min.js"></script>
	<script src="js/jquery.counterup.min.js"></script>
	<script src="js/imagesloaded.pkgd.min.js"></script>
	<script src="js/scrollIt.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/wow.min.js"></script>
	<script src="js/nice-select.min.js"></script>
	<script src="js/jquery.slicknav.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/gijgo.min.js"></script>

	<!--contact js-->
	<script src="js/contact.js"></script>
	<script src="js/jquery.ajaxchimp.min.js"></script>
	<script src="js/jquery.form.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/mail-script.js"></script>

	<script src="js/main.js"></script>
</body>
</html>