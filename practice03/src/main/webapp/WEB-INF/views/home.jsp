<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
         <a class="navbar-brand" href="#">Things</a>
       </div>
       <div id="navbar" class="collapse navbar-collapse">
	       <ul class="nav navbar-nav">
	         <li class="home"><a>Home</a></li>
	         <li class="board"><a>My board</a></li>
	         <li class="drive"><a>My drive</a></li>
	         <li class="mp"><a>Music player</a></li>
	         <li class="canvas"><a>Paint canvas</a></li>
	       </ul>
	       <form class="navbar-form navbar-right" method="get" action="/login/form">
		       <button type="submit" class="btn btn-primary">Login</button>
           </form>
       </div><!--/.nav-collapse -->
  	</div>
</nav>

<div class="container-fluid">
	<div class="row placeholder">
		<div class="col-sm-3 col-md-2 sidebar">
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
        </div>
	
	    <div id="body__container" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
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