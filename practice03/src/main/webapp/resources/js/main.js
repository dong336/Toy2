window.onload = function(){
	$("#body__container").load("main");
	$(".home").css({"background-color":"#9b59b6"});
	
	$(".home").on("click", function(){
		$("#body__container").empty();
		$("#body__container").load("main");
    	pushed(".home");
  });
	
	$(".drive").on("click", function(){
		$("#body__container").empty();
		$("#body__container").load("drive");
    	pushed(".drive");
  });
	
	$(".mp").on("click", function(){
		$("#body__container").empty();
		$("#body__container").load("mp");
    	pushed(".mp");
  });
	
	$(".canvas").on("click", function(){
		$("#body__container").empty();
		$("#body__container").load("canvas");
    	pushed(".canvas");
  });

  function pushed(panel){
    $(".home, .drive, .mp, .canvas").css({"background-color":"#101010"});
    $(panel).css({"background-color":"#9b59b6"});
  };
};