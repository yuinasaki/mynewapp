<%@page import="java.util.List"%>
<%@page import="model.SakeRecord"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ page import="servlet.FavServlet"  %>
    <%@ page import="model.FavBeans" %>
    <%@ page import="dao.FavDAO" %>

    <%
    List<FavBeans> resultDatas=(List<FavBeans>) session.getAttribute("resultDatas");
    %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, user-scalable=yes">
	<link rel="stylesheet" href="././css/particle.css" />
	<link rel="stylesheet" href="././css/reset.css" type="text/css" media="screen">
	<link rel="stylesheet" href="././css/favorite.css" type="text/css" media="screen">
	<link rel="stylesheet" href="././css/Favorite.css" type="text/css" media="screen">
	 <link rel="stylesheet" href="././css/normalize.css" type="text/css" media="screen">
<title>CocktailsSearch</title>
	<!--[if IE]>
  	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

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
<header>
  <h4 id="logo-space"><img id="logo" src="./img/WebImage/neon_logo.png" alt="logo"></h4>
    <p id="logout"><a href="/Sake_Search/Logout"><img class="icon-over" src="./svg/logout.svg"></a></p>
	<p id="search"><a href="/Sake_Search/Main"><img class="search-icon-over" src="./svg/search_icon.svg"></a></p>
</header>

<div class="container">
<h1 id="login_title" class="text-motoya h1-letter area area_FFFFFF"><span>お</span><span>気に</span>入り<span>リスト</span></h1>
<div class="tableF">
<table border="1">
<tr>
<th  bgcolor="#000000" width="200" height="100">&nbsp;</th>
<th  bgcolor="#000000"  width="200" height="40"><font color="#FFFFFF">酒名</font></th>
<th  bgcolor="#000000"  width="150" height="40"><font color="#FFFFFF">ベース</font></th>
<th  bgcolor="#000000"  width="150" height="40"><font color="#FFFFFF">度数</font></th>
<th  bgcolor="#000000"  width="150" height="40"><font color="#FFFFFF">味わい</font></th>
</tr>
<%if(resultDatas != null){
    for(FavBeans r : resultDatas){
%>
<tr>
<td><img src = "./.<%= r.getImglocation() %>" alt = "<%= r.getSakeMei() %>" class="img_80"></td>
<td bgcolor="#000000" width="200"><font color="#FFFFFF"><%= r.getSakeMei() %></font></td>
<td bgcolor="#000000"><font color="#FFFFFF"><%= r.getSakeBunrui() %></font></td>
<td bgcolor="#000000"><font color="#FFFFFF"><%= r.getSakeDosu() %></font></td>
<td bgcolor="#000000"><font color="#FFFFFF"><%= r.getSakeAjiwai() %></font></td>
</tr>
<% } } %>
</table>
</div>


</div>
	<!-- END container -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.2.6/gsap.min.js"></script><!-- GSAPの読み込み -->
	    <script src="js/gsap_test.js"></script> <!-- GSAPスクリプトの読み込み -->

</body>
</html>