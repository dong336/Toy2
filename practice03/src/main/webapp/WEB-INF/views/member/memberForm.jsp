<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

</head>
<style>
/* .form-horizontal{
	max-width: 800px;
    padding: 15px;
    margin: 0 auto;
} */
.form-group{
	display: flex;
	justify-content: center;
}
.hidden{
	display:none;
}
</style>
<body>

<div class="container">
	
	<form class="form-horizontal" action="/member/addMember" method="post">
		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-3">
				<h2>회원가입</h2>
			</div>
		</div>
		<div class="form-group">
			<label for="id" class="col-sm-1 control-label">Id</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" name="id" id="id" placeholder="Id">
			</div>
		</div>
		<div class="form-group">
			<label for="pwd" class="col-sm-1 control-label">Password</label>
			<div class="col-sm-3">
				<input type="password" class="form-control" name="pwd" id="pwd" placeholder="Password">
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-1 control-label">Name</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" name="name" id="name" placeholder="Name">
			</div>
		</div>
		<div class="form-group">
			<label for="email" class="col-sm-1 control-label">Email</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" name="email" id="email" placeholder="Email">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-3">
				<button type="submit" class="btn btn-primary">가입하기</button>
				<button type="reset" class="btn btn-default">비우기</button>
			</div>
		</div>
	</form>
	
</div>

</body>
</html>