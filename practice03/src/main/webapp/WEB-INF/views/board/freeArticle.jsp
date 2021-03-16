<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="page-header">
	<h1>
		${article.TITLE} &nbsp; 
		<small>${article.ID}</small> &nbsp;
			<small>${article.WRITEDATE}</small>
	</h1>
</div>
<div class="row placeholders">
	<p class="text-left">${article.CONTENT }</p>
</div>