$(function(){
	/* definition */
	var grid = new tui.Grid({
		el: document.getElementById('grid'),
		rowHeaders: ['checkbox'],
	    scrollX: false,
	    scrollY: true,
	    columns: [
			{
			header: 'id',
			name: 'ID'
			},
			{
			header: 'pwd',
			name: 'PWD'
			},
			{
			header: 'name',
			name: 'NAME'
			},
			{
			header: 'email',
			name: 'EMAIL'
			},
			{
			header: 'joinDate',
			name: 'JOINDATE'
			}
	    ]
	});

	function getDataGrid(){
		$.ajax({
			url : '/admin/allMembersList', 
			method : 'post',
			data : null,
			dataType : 'JSON',
			error : function(){
				alert('error');
			},
			success : function(result){
				grid.resetData(eval(result));
			}
    	}); 
	}

	$("#removeRow").on('click', function(e){
		var arr = grid.getCheckedRows();
		var list = new Array();
		
		for(i in arr){
			list.push(arr[i].ID);
		}

		console.log(list);

		$.ajax({
			url : '/admin/removeMember', 
			method : 'post',
			contentType: 'application/json',
			data : JSON.stringify(list),
			error : function(){
				alert('error');
			},
			success : function(result){
				alert("맴버 " + result + "명이 삭제 되었습니다.");
			}
    	}); 
		
		grid.removeCheckedRows(true);
	});

	/* thread */
	getDataGrid();
});