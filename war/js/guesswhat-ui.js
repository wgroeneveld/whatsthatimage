
Guesswhat.UI = (function(domain) {
	
	var isLoading = false;
	
	function disableCanvas() {
		$("#canvas")
		.css('opacity', '0.1')
		.css('background-color', 'black');
	}
	
	function enableCanvas() {
		$('#canvas').css('opacity', '1').css('background-color', 'transparent');		
	}
	
	function loading() {
		isLoading = true;
		disableCanvas();
		$("<img src='img/loading.gif'/>")
			.attr('id', 'loading')
			.appendTo($('body'));
	}
	
	function done() {
		isLoading = false;
		enableCanvas();
		$('#loading').remove();
	}
	
	function dialog(img) {
		disableCanvas();
		$("<img src='img/" + img + "'/>")
			.attr('id', 'dialog')
			.appendTo($('body'))
			.click(function() {
				enableCanvas();
				$(this).remove();
			});
	}
	
	function switchTo(btn) {
		$('.active').removeClass('active');
		$(btn).addClass('active');
	}
	
	function init() {
		$(".btn").click(function() {
			switchTo(this);
			$('.toggled').hide().removeClass('toggled');
			$("#" + $(this).data("toggle")).show().addClass('toggled');
	
			$("input[type=text]").val("");
			domain.clear();
		});
		
		$("#btn_guess").click(randomize);
		
		$("#submitRebus").click(submit);
		$("#answer").click(function() {
			if(domain.getRebus().answer === $("#answerInput").val()) {
				dialog("Ok.png");
			} else {
				dialog("Delete.png");
			}
		});
		randomize();
	}

	function submit() {
		if(!isLoading) {
			domain.submit($("#questionInput").val(), done);
		}
	}

	function randomize() {
		if(!isLoading) {
			loading();
			domain.random(done);
		}
	}
	
	return {
		init: init
	};
	
})(Guesswhat);
