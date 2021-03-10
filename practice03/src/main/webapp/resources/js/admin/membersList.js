$(function(){
	var grid = new tui.Grid({
		el: document.getElementById('grid'),
	    scrollX: false,
	    scrollY: false,
	    columns: [
			{
			header: 'id',
			name: 'id'
			},
			{
			header: 'pwd',
			name: 'pwd'
			},
			{
			header: 'name',
			name: 'name'
			},
			{
			header: 'email',
			name: 'email'
			},
			{
			header: 'joinDate',
			name: 'joinDate'
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