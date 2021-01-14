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
	<link rel="stylesheet" href="././css/CockTails_	LoginResult.css" type="text/css" media="screen">
<title>CocktailsSearch</title>
</head>
<body id="js-wrapper">


	<div class="container">
		<div id= "login_system_outer">
			<div id= "login_system">
				<h4 id="logo_space"><img id="logo" src="./img/WebImage/neon_logo.png" alt="logo"></h4>
				<h1 id="login_title" class="area">ログイン失敗</h1>
				<p style="color:#FFFFFF">入力したNAME、PASSWORDでアカウントが見つかりませんでした</p>
						<p id= "sign-up"><a href="/Sake_Search">ログイン画面へ戻る</a></p>
					</div>
					<!-- END login_system_inner -->
			</div>
			<!-- END login_system -->
		</div>
		<!-- END login_system_outer -->
	<!-- END container -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.2.6/gsap.min.js"></script><!-- GSAPの読み込み -->
	    <script src="js/gsap_test.js"></script> <!-- GSAPスクリプトの読み込み -->
</body>
</html>