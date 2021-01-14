<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.SakeRecord" %>

<%
List<SakeRecord> sakeList = (List<SakeRecord>)session.getAttribute("sakeList");
String sBunrui = (String)request.getAttribute("sBunrui");
int sDosu = (int)request.getAttribute("sDosu");
String sAjiwai = (String)request.getAttribute("sAjiwai");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, user-scalable=yes">
	<link rel="stylesheet" href="././css/reset.css" type="text/css" media="screen">
	<link rel="stylesheet" href="././css/CockTails_page3.css" type="text/css" media="screen">
	<link rel="stylesheet" href="././css/particle.css" type="text/css" media="screen">
    <link rel="stylesheet" href="././css/normalize.css" type="text/css" media="screen">
    <link rel="stylesheet" href="././css/demo.css" type="text/css" media="screen">
    <link rel="stylesheet" href="././css/dynamic_jazz.css" type="text/css" media="screen">
	<title>カクテルサーチ</title>
	<!--[if IE]>
  	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
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
				<p id="favorite"><a href="/Sake_Search/FavViewServlet"><img class="star-icon-over" src="./svg/star.svg"></a></p>
				<p id="logout"><a href="/Sake_Search/Logout"><img class="icon-over" src="./svg/logout.svg"></a></p>
				<p id="search"><a href="/Sake_Search/Main"><img class="search-icon-over" src="./svg/search_icon.svg"></a></p>
			</header>
		<div id="wrapper">
		<div class="container">
			<div id="box1" class="box">
			<h1 class="text-motoya h1-letter area area_FFFFFF"><span></span><span>検索</span>結果</h1>
			<div id = result_product class="result_select_primary">
				<ul class="list"><form action="/Sake_Search/FavServlet" method="get">
	<% if(sakeList != null && sakeList.size() != 0) {
						for(SakeRecord sake : sakeList) {
						System.out.println(sake);%>
					<li class="list_under">
							<div class="content">
								<div class="grid">
									<div class="list_under_container">
										<figure class="effect-lexi">
											<img class="cocktail_picture" src = "././<%= sake.getImglocation() %>" alt = "<%= sake.getSakeMei() %>">
											<figcaption>
												<h2 class="area area_FFFFFF"><span></span><span><%= sake.getSakeMei() %></span></h2>
												<p id="okini">お気に入り追加</p><input id="checkbox" type="checkbox" name="fav" value="<%= sake.getSakeId() %>">
												<p>ベース:<%= sake.getSakeBunrui() %><br>度数:<%= sake.getSakeDosu() %><br>あじわい:<%= sake.getSakeAjiwai() %><br></p>
											</figcaption>
										</figure>
									</div>
									<!-- END list_under_container -->
								</div>
								<!-- END grid -->
							</div>
							<!-- END content -->
					</li>
				<% } } else { %>
				<p>検索条件に該当するカクテルがありません。</p>
				<%} %>
				<input id="okini-submit" type="submit" value="★ お気に入りに登録"></input>
					</form>
				</ul>
			</div>
			<!-- END result_product -->
			</div>
			<!-- END box1 -->
			<!-- ここからBGテキスト -->
			<div id="box2" class="box">
			<div id="BG-text-wrapper">
				<p id="BG-number1" class="BG-text text-motoya after-text<%= sBunrui %>"><br></p>
				<p id="BG-number2" class="BG-text text-motoya after-text<%= sDosu %>"></p>
				<p id="BG-number3" class="BG-text text-motoya"><%= sAjiwai %></p>
			</div>
			<!-- END BG-text-wrapper -->
			</div>
			<!-- END <!-- END box2 -->
		</div><!--  END container -->
	</div><!--  END wrapper -->

	<!-- java script -->
	<script src="js/particles.min.js"></script>
	<script src="././js/test2.js"></script>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="././js/parallax1.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.2.6/gsap.min.js"></script><!-- GSAPの読み込み -->
	<script src="js/gsap_test.js"></script> <!-- GSAPスクリプトの読み込み -->
</body>
</html>