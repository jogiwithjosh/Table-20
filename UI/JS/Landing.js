$(document).ready(function(){
	
	$("#createQueuButton").click(function(){
		$(".createQueueForm").css("display","block")
	});
	
	$("#addQueueElementButton").click(function(){
		$(".addQueueElementForm").css("display","block")
	});
	
	$("#removeQueueElementButton").click(function(){
		$(".removeQueueElementForm").css("display","block")
	});
	
	$("#createQueueAnchor").click(function(){ 
		$(".createQueueForm").css("display","none")
	});
	
	$("#addQueueAnchor").click(function(){ 
		$(".addQueueElementForm").css("display","none")
	});
	
	$("#removeQueueAnchor").click(function(){ 
		$(".removeQueueElementForm").css("display","none")
	});
	
	
	
})