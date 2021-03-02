<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="/resources/css/main.css">
<link rel="stylesheet" href="/resources/node_modules/tui-grid/dist/tui-grid.css">

</head>
<body>
<h1 class="page-header">My drive</h1>
<div class="row placeholders">
    <div id="dropzone" class="box__1">
        <h1>Drag & Drop Files Here</h1>
    </div>
    <div id="downloadzone"></div>
</div> 

<div class="row placeholders">
	<div id="grid">
		<!-- ajax load data -->
	</div>
	<hr>	
	<div>
	    <button id="btnClear">clear</button>
	    <button id="btnSearch">view</button>
	</div>
</div>

<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script src="/resources/node_modules/tui-grid/dist/tui-grid.js"></script>
<script src="/resources/node_modules/tui-grid/dist/tui-grid.min.js"></script>
<!-- tui grid -->

<script>
$(function () {
	var gridData = [];
	var grid = new tui.Grid({
		el: document.getElementById('grid'),
	    scrollX: false,
	    scrollY: false,
	    columns: [
	      {
	        header: '파일명',
	        name: 'fileName'
	      },
	      {
	        header: '수정일자',
	        name: 'modifyDate',
		    width: 200,
		    align: 'center'
	      },
	      {
		    header: '유형',
		    name: 'type',
		    width: 150,
		    align: 'center'
		  },
	      {
	        header: '파일크기',
	        name: 'capacity',
		    width: 150,
			align: 'right'
	      }	        
	    ]
	});
	
 	$("#btnClear").click(function(){
	    grid.clear();
	});
	
	$("#btnSearch").click(function(){
	    $.ajax({
		    url : '/grid/data', 
		    method : 'get',
	        data : null,
		    dataType : 'JSON',
		    error : function(){
		        alert('error');
		    },
		    success : function(result){
	    		console.dir(result.dataList);
	    		grid.resetData(eval(result.dataList));
			} 
	    });
	});  
	
	grid.on('click', function(e) {
	    console.log('click!', e);
	    var size = grid.getRow(e.rowKey).capacity;
	    if(size == null)
	    	alert('디렉토리입니다.');
	    else {
	    	alert('파일입니다.');
 	    	location.href = "/drive/getFileDownload?fileName=" + grid.getRow(e.rowKey).fileName;   
	    }
	});
	
    var obj = $("#dropzone");
    obj.on('dragenter', function (e) {
         e.stopPropagation();  //상위 노드로 가는 이벤트를 멈춘다.
         e.preventDefault();  //현재 객체에 있는 모든 실행요소를 멈춘다.
    });
    obj.on('dragleave', function (e) {
         e.stopPropagation();
         e.preventDefault();
    });
    obj.on('dragover', function (e) {
         e.stopPropagation();
         e.preventDefault();
    });
    obj.on('drop', function (e) {
        e.preventDefault();
        var files = e.originalEvent.dataTransfer.files;
        if(files.length < 1)
            return;
                  
        for(var i = 0; i < files.length; i++) {
            var file = files[i];
        }
        F_FileMultiUpload(files, obj);
    });
    //파일 멀티 업로드
    function F_FileMultiUpload(files, obj) {
         if(confirm(files.length + "개의 파일을 업로드 하시겠습니까?") ) {
             var data = new FormData();
             for (var i = 0; i < files.length; i++) {
                data.append('files', files[i]);
             }
             var url = '/drive/upload';
             $.ajax({
                url: url,
                method: 'POST',
                data: data,
                dataType: 'json',
                processData: false,
                contentType: false,
                success: function(res) {
                    alert("업로드가 완료되었습니다.");
                    console.log(res.files);
/*                     grid.resetData(eval(res.files)); */
                    F_FileMultiUpload_Callback(res.files); 
                },
                error: function(res) {
                    alert("업로드 중에 에러가 발생했습니다. 파일은 10M를 넘을 수 없습니다.");
                    console.dir(res);
                }
             });
         }
    }
     // 파일 멀티 업로드 Callback
    function F_FileMultiUpload_Callback(files) {
        for(var i=0; i < files.length; i++) {
            var file = files[i];

            $("#downloadzone").append("<a class='box__1' href='/drive/getFileDownload?filename=" + files[i] + "' >"+ files[i] +"</a><br>");
        }
    } 
    function fnAlert(e, msg) {
        e.stopPropagation();
        alert(msg);
    } 
});
</script>

</body>
</html>