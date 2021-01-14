<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
  <head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/gsap_test.css" />
    <link rel="stylesheet" href="css/normalize.css" />
    <link rel="stylesheet" href="css/demo.css" />
    <link rel="stylesheet" href="css/dynamic_jazz.css" />
    <title>gsapのテスト</title>
    <!--[if IE]>
  		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
  </head>
  <body id="js-wrapper">
  <h5><img src="svg/CS_logo.svg" width="230px" height="163px"/></h5>

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
<div id="glow">
<p><a href="http://localhost:8080/Sake_Search/gsap_test.jsp">テスト</a></p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p><p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p><p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p>
<p>テスト</p>
</div>
	  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.2.6/gsap.min.js"></script><!-- GSAPの読み込み -->
	    <script src="js/gsap_test.js"></script> <!-- GSAPスクリプトの読み込み -->
  </body>
</html>