window.onload = function(){
	
	/* 반응형 nav panel */
	$("#body__container").load("main");
	$(".home").css({"background-color":"darkorchid"});
	$(".home a").css({"color":"white"});
	
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
		$(".home a, .drive a, .mp a, .canvas a").css({"color":"#9d9d9d"});
		$(panel).css({"background-color":"darkorchid"});
		$(panel + " a").css({"color":"white"});
	};
};