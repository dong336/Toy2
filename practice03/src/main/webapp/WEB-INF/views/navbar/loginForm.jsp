<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>로그인 화면</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="/resources/css/loginForm.css">
  </head>

  <body>

    <div class="container">

      <form class="form-signin" action="/member" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="id" class="sr-only">Id</label>
        <input type="text" name="id" id="id" class="form-control" placeholder="Id" required autofocus>
        <label for="pwd" class="sr-only">Password</label>
        <input type="password" name="pwd" id="pwd" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->
  </body>
</html>