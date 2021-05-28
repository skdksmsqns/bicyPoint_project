<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>


<style type="text/css">
table, td {
	border: 1pxsolid red
}

table {
	width: 60%;
	height: 100px;
	margin: auto;
	text-align: center;
}

input[type="text"] {
	width: 500px;
	height: 50px;
	border: 1px solid #ddd;
	margin-bottom: 20px;
}
</style>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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
				<c:if test="${admin == null}">
					<h1><span class="table-info fix">공지사항 수정</span></h1>

					<form method="post" action="bicyclent_update">
						<input type="hidden" disabled="disabled" name="nt_num" value="${bicyclent.nt_num}"><br />
						<input type="text" disabled="disabled" name="nt_sj" value="${bicyclent.nt_sj}" /><br />
						<textarea cols="50"  rows="10" name="nt_cn" disabled="disabled" >${bicyclent.nt_cn}</textarea><br /> 
						<input type="text" disabled="disabled" name="admin_id" value="${bicyclent.admin_id}" /><br />
					</form>
					<a href="bicyclent_list" class="genric-btn primary circle">목록보기</a>
				</c:if> 
				
				<c:if test="${admin != null}">
				<div class="container">
					<h1><span class="table-info fix">공지사항 수정</span></h1>

					<form method="post" action="bicyclent_update">
						<input type="hidden" name="nt_num" value="${bicyclent.nt_num}"><br />
						<input type="text" name="nt_sj" value="${bicyclent.nt_sj}" /><br />
						<textarea cols="50" rows="10" name="nt_cn">${bicyclent.nt_cn}</textarea><br /> 
						<input type="text" name="admin_id" value="${bicyclent.admin_id}" /><br />
						
						<input type="submit" class="btn btn-primary" value="수정"> &nbsp;
						<a class="btn btn-danger" href="bicyclent_delete?nt_num=${bicyclent.nt_num}">삭제</a><br />
					</form>
					<br /><a href="bicyclent_list" class="genric-btn primary circle">목록보기</a>
				</div>
				</c:if>
				
			</td>
		</tr>
	</table>


	<footer class="footer">
		<div class="copy-right_text">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-xl-7 col-md-8">
						<p class="copy_right ">
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							Copyright &copy;
							<script>
								document.write(new Date().getFullYear());
							</script>
							All rights reserved | This template is made with <i
								class="fa fa-heart-o" aria-hidden="true"></i> by <a
								href="https://colorlib.com" target="_blank">Colorlib</a>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						</p>
					</div>
					<div class="col-xl-5 col-md-4">
						<div class="socail_links">
							<ul>
								<li><a href="#"> <i class="ti-facebook"></i>
								</a></li>
								<li><a href="#"> <i class="ti-twitter-alt"></i>
								</a></li>
								<li><a href="#"> <i class="fa fa-instagram"></i>
								</a></li>
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