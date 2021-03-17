<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/resources/node_modules/tui-grid/dist/tui-grid.css">
<link rel="stylesheet" href="/resources/node_modules/tui-pagination/dist/tui-pagination.css">
<style>
.tui-grid-table tbody tr td:hover{
    cursor: pointer;
}
</style>

<script src="/resources/node_modules/tui-grid/dist/tui-grid.js"></script>
<script src="/resources/node_modules/tui-grid/dist/tui-grid.min.js"></script>
<script src="/resources/node_modules/tui-pagination/dist/tui-pagination.js"></script>
<script src="/resources/js/freeBoard.js"></script>
<script>
function articleForm(isLogOn, member){
 	if(isLogOn){
		console.log(isLogOn);
		console.dir(member);
		location.href = "/freeBoard/addArticle";
	}
	else {
		console.log(isLogOn);
		alert("로그인 후 글쓰기가 가능합니다");
		location.href = "/login/form";
	}
}
</script>
			
<div class="page-header">
	<h1>자유게시판</h1>
</div>
<div id="frame">
	<div id="grid"></div><br>
	<a href="javascript:articleForm('${isLogOn}', '${member}')">
		<button type="button" class="btn btn-primary" id="writing">글쓰기</button>
	</a>
</div>