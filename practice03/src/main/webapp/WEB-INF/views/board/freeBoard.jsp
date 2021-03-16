<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>자유게시판</title>
<link rel="stylesheet" href="/resources/node_modules/tui-grid/dist/tui-grid.css">
<link rel="stylesheet" href="/resources/node_modules/tui-pagination/dist/tui-pagination.css">

<style>
.tui-grid-table tbody tr td:hover{
    cursor: pointer;
}
</style>
			
			<div class="page-header">
				<h1>자유게시판</h1>
			</div>
			<div class="row placeholders">
				<div id="frame">
					<div id="grid"></div><br>
					<button type="button" class="btn btn-primary" id="writing">글쓰기</button>
				</div>
			</div>
	    
<script src="/resources/node_modules/tui-grid/dist/tui-grid.js"></script>
<script src="/resources/node_modules/tui-grid/dist/tui-grid.min.js"></script>
<script src="/resources/node_modules/tui-pagination/dist/tui-pagination.js"></script>
<script src="/resources/js/freeBoard.js"></script>