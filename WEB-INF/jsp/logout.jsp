<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String errorMsg= (String)request.getAttribute("errorMsg");%>
<%@page import="java.util.Map" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="././css/particle.css" />
	<link rel="stylesheet" href="././css/reset.css" type="text/css" media="screen">
	<link rel="stylesheet" href="././css/logout.css" type="text/css" media="screen">
<title>CocktailsSearch</title>

</head>
<body id="js-wrapper">
<!-- オブジェクトを増殖させて、ランダムに配置するための画像 -->
	<!-- 増殖用の画像 -->
<div class="original">
  <div class="original__item">
    <img src="svg/circle.svg">
  </div>
  <div class="original__item">
    <img src="svg/cross.svg">
  </div>
  <div class="original__item">
    <img src="svg/triangle.svg">
  </div>
</div>

<!-- 増殖する場所 -->
<div class="wrapper" >
</div>
	<div class="container">
		<div id= "login_system_outer">
			<div id= "login_system">
				<h4 id="logo_space"><img id="logo" src="./img/WebImage/neon_logo.png" alt="logo"></h4>
				<h1 id="login_title" class="area area_00B4FF">ロ<span>グ</span><span>ア</span>ウ<span>ト</span>し<span>ま</span>した</h1>
				<p id="cat-wrapper"><img id="cat" class="area area_FFFFFF" src="./svg/logout_cat.svg" alt="caaaaaaaaaaatt!!!"></p>
					<div id= "login_system_inner">
						<form action="/Sake_Search/Login" method="post">


						</form>

						<br>
						<p id= "sign-up"><a href="/Sake_Search">ログイン画面へ</a></p>
					</div>
					<!-- END login_system_inner -->
			</div>
			<!-- END login_system -->
		</div>
		<!-- END login_system_outer -->
	</div>
	<!-- END container -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.2.6/gsap.min.js"></script><!-- GSAPの読み込み -->
	    <script src="js/gsap_test.js"></script> <!-- GSAPスクリプトの読み込み -->
</body>
</html>