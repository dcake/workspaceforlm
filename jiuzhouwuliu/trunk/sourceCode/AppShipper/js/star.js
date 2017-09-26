$(function(){

	starChange();
	
});
function starChange(){
	for (var j=1; j<=5; j++) {
	for (var i=1; i<=5; i++) {
		//为每个星星 绑定点击 事件
		$(".list"+j+" .star"+ i).bind("click",function(){
				var index = $(this).attr("class").substr(4,1);
				var p = $(this).parent().attr("class");
				//var box = $(this).parent().parent().attr("class");
				if($(this).hasClass("icon-xing1")){
				  for (var k= index; k>0; k--)
				  $("."+p+" .star"+ k).removeClass("icon-xing1").addClass("icon-xingjihui");
				  
				}
				else if($(this).hasClass("icon-xingjihui")){
					for (var k= 5; k>=index; k--)
				  $("."+p+" .star"+ k).removeClass("icon-xingjihui").addClass("icon-xing1");
				 
	 		    }
				//}
				//改变评价样式 及 内容
//				switch(index){
//					case "1":
//						$("."+box+" .remark").text("非常不满意");
//						break;
//					case "2":
//						$("."+box+" .remark").text("不满意");
//						break;
//					case "3":
//						$("."+box+" .remark").text("一般");
//						break;
//					case "4":
//						$("."+box+" .remark").text("满意");
//						break;
//					case "5":
//						$("."+box+" .remark").text("非常满意");
//						break;
//				}
		});
	}
	}
}
