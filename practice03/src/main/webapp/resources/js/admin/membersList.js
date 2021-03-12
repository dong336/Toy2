$(function(){
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
			}
	    ]
	});

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
});