window.onload = function(){
	
	/* 반응형 nav panel */
	
	$("#menu1 #freeBoard").on("click", function(){
		$("#body__container").empty();
		$("#body__container").load("freeBoard");
	});

	$("#menu1 #QnABoard").on("click", function(){
		$("#body__container").empty();
		$("#body__container").load("QnABoard");
	});

	$(".home").on("click", function(){
		$("#body__container").empty();
		$("#body__container").load("main");
    	pushed(".home");
  });

	$(".board").on("click", function(){
		// $("#body__container").empty();
		// $("#body__container").load("board");
		pushed(".board");
		$("#menu1 li a").css({"color":"black"});
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