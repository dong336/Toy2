$(function () {
    /* main */
    getDataForGrid();

    /* function & value */ 
	$('#modalBtn__1').on('click', function () {
        $('#modal__1').focus()
    });
	
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
	
 	// $("#btnClear").click(function(){
	//     grid.clear();
	// });

	// $("#btnSearch").click(getDataForGrid);  
	
    function getDataForGrid(){
	    $.ajax({
		    url : '/grid/data', 
		    method : 'get',
	        data : null,
		    dataType : 'JSON',
		    error : function(){
		        alert('error');
		    },
		    success : function(result){
	    		grid.resetData(eval(result.dataList));
			} 
	    });
	};

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


    grid.on('mouseover', function(e){
        var td1 = grid.getElement(e.rowKey, 'fileName');
        var td2 = grid.getElement(e.rowKey, 'modifyDate');
        var td3 = grid.getElement(e.rowKey, 'type');
        var td4 = grid.getElement(e.rowKey, 'capacity');
        
        if(td1 != null){
            td1.style.backgroundColor = 'darkorchid';
            td2.style.backgroundColor = 'darkorchid';
            td3.style.backgroundColor = 'darkorchid';
            td4.style.backgroundColor = 'darkorchid';
            
            td1.style.color = 'white';
            td2.style.color = 'white';
            td3.style.color = 'white';
            td4.style.color = 'white';
        }
    });
	
    grid.on('mouseout', function(e){
        var td1 = grid.getElement(e.rowKey, 'fileName');
        var td2 = grid.getElement(e.rowKey, 'modifyDate');
        var td3 = grid.getElement(e.rowKey, 'type');
        var td4 = grid.getElement(e.rowKey, 'capacity');
        
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

    var obj = $("#myLargeModalLabel");
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
        // var size = files[0].size;

        // console.dir(files);
        F_FileMultiUpload(files, obj);

        //upload(e, obj);
    });

    //파일 멀티 업로드
    function F_FileMultiUpload(files, obj) {
        if(confirm(files.length + "개의 파일을 업로드 하시겠습니까?") ) {
            console.dir(files);
            
            var data = new FormData();
            var url = '/drive/dndUpload';
            
            for (var i = 0; i < files.length; i++) {
                var size = files[i].size;
                data.append('files', files[i]);
                
                if(size == 0 || size == 4096){
                    alert("폴더는 업로드할 수 없습니다..");
                    return;
                }
            }
               
            var list = data.getAll('files');
            console.log("** 데이터 리스트");
            console.dir(list);

            $.ajax({
                url: url,
                method: 'POST',
                enctype: 'multipart/form-data',
                data: data,
                dataType: 'json',
                processData: false,
                contentType: false,
                success: function(res) {
                    alert("업로드가 완료되었습니다.");
                    
                    // F_FileMultiUpload_Callback(res.files);
                    // console.log(res);
                    grid.appendRows(res);
                },
                error: function(res) {
                    alert("업로드 중에 에러가 발생했습니다. 파일은 1M를 넘을 수 없습니다.");
                    // console.dir(res);
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