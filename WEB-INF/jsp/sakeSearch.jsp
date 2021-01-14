<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="././css/reset.css" type="text/css" media="screen">
	<link rel="stylesheet" href="././css/CockTails_page2.css" type="text/css" media="screen">
	<link rel="stylesheet" href="././css/particle.css" type="text/css" media="screen">
	<title>検索ページ</title>
</head>
<body id="js-wrapper">
<!-- オブジェクトを増殖させて、ランダムに配置するための画像 -->
	<!-- 増殖用の画像 -->
<div class="original">
  <div class="original__item">
    <img src="././svg/circle.svg">
  </div>
  <div class="original__item">
    <img src="././svg/cross.svg">
  </div>
  <div class="original__item">
    <img src="././svg/triangle.svg">
  </div>
</div>

<!-- 増殖する場所 -->
<div class="wrapper" >
</div>

	<header>
		<h4 id="logo-space"><img id="logo" src="./img/WebImage/neon_logo.png" alt="logo"></h4>
		<p id="logout"><a href="/Sake_Search/Logout"><img class="icon-over" src="./svg/logout.svg"><img class="icon-under" src="./svg/logout.svg">ログアウト</a></p>
	</header>
	<div id="wrapper">
			<div class="container">
				<div id="search-system-ver">
					<form action="/Sake_Search/SakeSearch" method="post">
						<h1 class="white-text kensaku area area_FFFFFF"><span></span><span>検索</span></h1>
						<p class="white-text koumoku area area_FFFFFF"><span>項</span>目<span>を</span>選択<span>して</span>くだ<span>さ</span>い</p>
						<div class="select-box">
							<select name="sakeBunrui">
								<option value="" selected>ベース</option>
								<option value="ジン">ジン</option>
								<option value="ウイスキー">ウイスキー</option>
								<option value="テキーラ">テキーラ</option>
								<option value="ラム">ラム</option>
								<option value="ウォッカ">ウォッカ</option>
								<option value="ブランデー">ブランデー</option>
							</select>
						</div>
						<!-- END select-box -->
						<br>
						<div class="select-box">
							<select class="select-box" name="sakeDosu">
								<option value="4">度数</option>
								<option value="1">1～10</option>
								<option value="2">11～20</option>
								<option value="3">21～</option>
							</select>
						</div>
						<!-- END select-box -->
						<br>
						<div class="select-box">
						<select class="select-box" name="sakeAjiwai">
							<option value="">あじわい</option>
							<option value="甘口">甘口</option>
							<option value="中口">中口</option>
							<option value="辛口">辛口</option>
						</select>
						</div>
						<!-- END select-box -->
						<br>
						<p><input id="btn-primary" type="submit" value="検索"></p>
						<p id="favorite-list"><a href="/Sake_Search/FavViewServlet">★ お気に入りリスト</a></p>
					</form>
				</div>
				<!-- END search-system-ver -->
				<!-- ここからBGテキスト -->
				<div id="BG-text-wrapper">
					<p id="BG-number1" class="BG-text text-motoya">サーチ!</p>
					<p id="BG-number2" class="BG-text text-motoya">サーチ!!</p>
					<p id="BG-number3" class="BG-text text-motoya">サーチ!!!</p>
				</div>
				<!-- END BG-text-wrapper -->
			</div>
			<!-- END container -->
		</div>
		<!-- END wrapper -->

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.2.6/gsap.min.js"></script><!-- GSAPの読み込み -->
	    <script src="././js/gsap_test.js"></script> <!-- GSAPスクリプトの読み込み -->
</body>
</html>