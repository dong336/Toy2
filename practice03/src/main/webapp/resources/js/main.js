window.onload = function(){
	
	/* 반응형 nav panel */
	$(".home").on("click", function(){
		$("#body__container").empty();
		location.href = "/";
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
		$(".home, .board, .drive, .mp, .canvas").css({"background-color":"#101010"});
		$(".home a, .board a, .drive a, .mp a, .canvas a").css({"color":"#9d9d9d"});
		$(panel + " a").css({"color":"white"});
	};
};