<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="page-header"><h1>글쓰기</h1></div>

<form action="/freeBoard/submitForm" method="post">
	<input name="title" type="text" class="form-control" placeholder="Title">
	<br>
	<textarea name="content" class="form-control" rows="20" placeholder="Content"></textarea>
	<br>
	<button type="submit" class="btn btn-default">등록</button>
	<button id="cancel" type="button" class="btn btn-default">취소</button>
</form>

<script>
$(function(){
	$("#cancel").on('click', function(){
		location.href="/freeBoard";
	});
});
</script>