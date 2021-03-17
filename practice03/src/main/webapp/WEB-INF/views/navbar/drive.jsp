<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/resources/css/drive.css">
<link rel="stylesheet" href="/resources/node_modules/tui-grid/dist/tui-grid.css">

<h1 class="page-header">My drive</h1>
<button id="modalBtn__1" type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">File upload</button>

<div id="modal__1" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div id="myLargeModalLabel" class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">x</span>
                </button>
                <h4 class="modal-title">File upload</h4>
            </div> 
            <div class="modal-body">Drag and drop here.</div>
        </div>
    </div>
</div>

<br><br>
<div id="grid">
</div>
	
<script src="/resources/node_modules/tui-grid/dist/tui-grid.js"></script>
<script src="/resources/node_modules/tui-grid/dist/tui-grid.min.js"></script>

<script src="/resources/js/drive.js"></script>