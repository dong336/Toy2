<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="/resources/css/canvas.css">  
    <link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
<h1 class="page-header">Canvas</h1>
<div class="row placeholders">
    <canvas id="jsCanvas" class="canvas__canvas"></canvas>
    <div class="controls">
        <div class="controls__range">
            <input type="range" id="jsRange" min="0.1" max="5.0" value="2.5" step="0.1"/>
        </div> 
        <div class="controls__btns">
            <button id="jsMode">Fill</button>
            <button id="jsSave">Save</button>
        </div>
        <div class="controls__colors" id="jsColors">
            <div class="controls__color jsColor" style="background-color:#2c2c2c"></div>
            <div class="controls__color jsColor" style="background-color:white"></div>
            <div class="controls__color jsColor" style="background-color:#ff3b30"></div>
            <div class="controls__color jsColor" style="background-color:#ff9500"></div>
            <div class="controls__color jsColor" style="background-color:#ffcc00"></div>
            <div class="controls__color jsColor" style="background-color:#4CD963"></div>
            <div class="controls__color jsColor" style="background-color:#5ac8fa"></div>
            <div class="controls__color jsColor" style="background-color:#0579ff"></div>
            <div class="controls__color jsColor" style="background-color:#5856d6"></div>
        </div>
    </div>
</div>
    
<script src="/resources/js/canvas.js"></script>
</body>
</html>