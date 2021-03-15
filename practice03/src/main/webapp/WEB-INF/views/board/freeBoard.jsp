<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/node_modules/tui-grid/dist/tui-grid.css">
<link rel="stylesheet" href="/resources/node_modules/tui-pagination/dist/tui-pagination.css">
<style>
.tui-grid-table tbody tr td:hover{
    cursor: pointer;
}
</style>
</head>
<body>

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

<script type="text/javascript">
$(function(){
	// ** definition
	
	$("#writing").on('click', function(){
		$("#frame").empty();
	});
	
	const grid = new tui.Grid({
	  el: document.getElementById('grid'),
	  columns: [
	    {
	      header: '제목',
	      name: 'TITLE',
	      width: 150
	    },
	    {
	      header: '작성자',
	      name: 'ID',
	      width: 150
	    },
	    {
	      header: '내용',
	      name: 'CONTENT'
	    },
	    {
	      header: '작성 날짜',
	      name: 'WRITEDATE',
	      width: 150
	    }
	  ],
	  rowHeaders: ['rowNum'],
/*  	  pageOptions: {
	    perPage: 5
	  } */  
	}); 

	grid.on('mouseover', function(e){
        var td1 = grid.getElement(e.rowKey, 'TITLE');
        var td2 = grid.getElement(e.rowKey, 'ID');
        var td3 = grid.getElement(e.rowKey, 'CONTENT');
        var td4 = grid.getElement(e.rowKey, 'WRITEDATE');
        
        if(td1 != null){
            td1.style.backgroundColor = 'dimgray';
            td2.style.backgroundColor = 'dimgray';
            td3.style.backgroundColor = 'dimgray';
            td4.style.backgroundColor = 'dimgray';
            
            td1.style.color = 'white';
            td2.style.color = 'white';
            td3.style.color = 'white';
            td4.style.color = 'white';
        }
    });
	
    grid.on('mouseout', function(e){
        var td1 = grid.getElement(e.rowKey, 'TITLE');
        var td2 = grid.getElement(e.rowKey, 'ID');
        var td3 = grid.getElement(e.rowKey, 'CONTENT');
        var td4 = grid.getElement(e.rowKey, 'WRITEDATE');
        
        if(td1 != null){
            td1.style.backgroundColor = '#f4f4f4';
            td2.style.backgroundColor = '#f4f4f4';
            td3.style.backgroundColor = '#f4f4f4';
            td4.style.backgroundColor = '#f4f4f4';
            
            td1.style.color = 'black';
            td2.style.color = 'black';
            td3.style.color = 'black';
            td4.style.color = 'black';
        }
    });
	
	grid.on('click', function(e){
		console.log(grid.getRow(e.rowKey));
	});
	
	// ** thread
	$.ajax({
		url : '/freeBoard/getBoardList', 
		method : 'get',
		data : null,
		dataType : 'JSON',
		error : function(){
			alert('error');
		},
		success : function(result){
			//console.dir(result);
			grid.resetData(eval(result));
		}
	});
});

</script>

</body>
</html>