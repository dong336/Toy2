<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- <link rel="shortcut icon" type="image/x-icon" href="/favicon.ico"> -->

<!-- Custome CSS -->
<link rel="stylesheet" href="/resources/css/dashboard.css">
<link rel="stylesheet" href="/resources/css/content.css">

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
       <div class="navbar-header">
         <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
           <span class="sr-only">Toggle navigation</span>
           <span class="icon-bar"></span>
           <span class="icon-bar"></span>
           <span class="icon-bar"></span>
         </button>
         <a class="navbar-brand" href="#">
         <c:choose>
         	<c:when test="${isLogOn == true && member!= null}">
         		${member.id}님
         	</c:when>
         	<c:otherwise>
         		Things         
         	</c:otherwise>
         </c:choose>
         </a>
       </div>
       <div id="navbar" class="collapse navbar-collapse">
	       <ul class="nav navbar-nav">
	         <li class="home"><a>Home</a></li>
	         <li class="board dropdown">
	         	<a id="dropBoard" href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" role="button" aria-expanded="true">My board</a>
	         	<ul id="menu1" class="dropdown-menu" role="menu" aria-labelledby="dropBoard">
		          <li role="presentation"><a role="menuitem" href="freeBoard">자유게시판</a></li>
		          <li role="presentation"><a role="menuitem" href="QnABoard">질문게시판</a></li>
		          <li role="presentation"><a role="menuitem" href="#">기타</a></li>
		        </ul>
	         </li>
	         <li class="drive"><a>My drive</a></li>
	         <li class="mp"><a>Music player</a></li>
	         <li class="canvas"><a>Paint canvas</a></li>
	       </ul>
	       <c:choose>
		       <c:when test="${isLogOn == true && member!= null}">
		           <form class="navbar-form navbar-right" method="get" action="/login/logout">
				       <button type="submit" class="btn btn-warning">Logout</button>
		           </form>
		       </c:when>
		       <c:otherwise>
			       <form class="navbar-form navbar-right" method="get" action="/login/form">
				       <button type="submit" class="btn btn-success">Login</button>
		           </form>
		       	   <form class="navbar-form navbar-right" method="get" action="/member/form">
				       <button type="submit" class="btn btn-primary">회원가입</button>
		           </form>
		       </c:otherwise>
	       </c:choose>
       </div><!--/.nav-collapse -->
  	</div>
</nav>

<div class="container-fluid">
	<div class="row placeholder">
		<!-- <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">Item1<span class="sr-only">(current)</span></a></li>
            <li><a href="#">Item2</a></li>
            <li><a href="#">Item3</a></li>
            <li><a href="#">Item4</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Board1</a></li>
            <li><a href="">Board2</a></li>
            <li><a href="">Board3</a></li>
            <li><a href="">Board4</a></li>
            <li><a href="">Board5</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Board1</a></li>
            <li><a href="">Board2</a></li>
            <li><a href="">Board3</a></li>
            <li><a href="">Board4</a></li>
            <li><a href="">Board5</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Board1</a></li>
            <li><a href="">Board2</a></li>
            <li><a href="">Board3</a></li>
            <li><a href="">Board4</a></li>
            <li><a href="">Board5</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Board1</a></li>
            <li><a href="">Board2</a></li>
            <li><a href="">Board3</a></li>
            <li><a href="">Board4</a></li>
            <li><a href="">Board5</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Board1</a></li>
            <li><a href="">Board2</a></li>
            <li><a href="">Board3</a></li>
            <li><a href="">Board4</a></li>
            <li><a href="">Board5</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Board1</a></li>
            <li><a href="">Board2</a></li>
            <li><a href="">Board3</a></li>
            <li><a href="">Board4</a></li>
            <li><a href="">Board5</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Content1</a></li>
            <li><a href="">Content2</a></li>
            <li><a href="">Content3</a></li>
          </ul>
        </div> -->
	
	    <div id="body__container" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	    	<h1 class="page-header">자유게시판</h1>
	    	<!-- main content ajax load -->
	    </div>
	    
	</div>	
	
	<div class="row placeholders">
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2">
			<footer>
				<hr>
				<p>&copy; <a href="http://www.github.com/dong336">www.github.com/dong336</a></p>
			</footer>
		</div>
	</div>
</div>

<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<!-- Custom js -->
<script src="/resources/js/main.js"></script>

</body>
</html>