<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="/resources/css/main.css">
<link rel="stylesheet" href="/resources/css/drive.css">
<link rel="stylesheet" href="/resources/node_modules/tui-grid/dist/tui-grid.css">

</head>
<body>
<h1 class="page-header">My drive</h1>
<div class="row placeholders">
	<!-- modal -->
    <button id="modalBtn__1" type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">File upload</button>

    <div id="modal__1" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">x</span>
                    </button>
                    <h4 class="modal-title" id="myLargeModalLabel">Drag & Drop only file here</h4>
                    <!-- <div class="modal-body">
                    </div> -->
                </div>    
            </div>
        </div>
    </div>
</div>
<div class="row placeholders">
	<div id="downloadzone"></div>
</div>
<div class="row placeholders">
	<div id="grid">
		<!-- ajax load data -->
	</div>
	<hr>	
<!-- 	<div>
	    <button id="btnClear">clear</button>
	    <button id="btnSearch">view</button>
	</div> -->
</div>

<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script src="/resources/node_modules/tui-grid/dist/tui-grid.js"></script>
<script src="/resources/node_modules/tui-grid/dist/tui-grid.min.js"></script>
<!-- tui grid -->

<script src="/resources/js/drive.js"></script>
<!-- custom js -->

</body>
</html>