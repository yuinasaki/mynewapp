<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
//リクエストスコープに保存されたメッセージを取得
String message = (String)request.getAttribute("message");
%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
	<link rel="stylesheet" href="././css/particle.css" />
	<link rel="stylesheet" href="././css/reset.css" type="text/css" media="screen">
	<link rel="stylesheet" href="././css/UserCreate.css" type="text/css" media="screen">

<title>会員登録</title>
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
				<h1 id="login_title" class="area area_FFD924"><span></span><span>会</span>員<span>登</span>録</h1>
				<% if(message != null) { %>
				<p class="error-msg" style="color:#FFFFFF"><%= message %></p>
				<% } %>
					<div id= "login_system_inner">
						<form action="/Sake_Search/UserCreate" method="post">
							<label class="text-beon yellow-beon area area_FFD924"><span>N</span><span>A</span><span>M</span>E</label>
							<div class="textbox-align">
								<input id="name" type="text" name="name" placeholder="登録名を入力">
							</div>
							<!-- END textbox-align -->

							<label class="text-beon yellow-beon area area_FFD924"><span></span><span>P</span>A<span>S</span><span>S</span>W<span>O</span>R<span>D</span></label>
							<div class="textbox-align">
								<input id="inputID" type="text" name="id" placeholder="登録パスワードを入力">
							</div>
							<!-- END textbox-align -->
							<input class="text-motoya" id="btn-primary"  type="submit" value="登録">
						</form>
						<p id= "sign-up"><a href="/Sake_Search/">戻る</a></p>
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