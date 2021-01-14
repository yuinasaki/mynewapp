$(function() {
	var top = $('#box1').offset().top; //初期値を取得
	$(window).scroll(function() {
	    var value = $(this).scrollTop(); //スクロールの値を取得
	    $('#scrollValue').text(value);

	    $('#box1').css('top', top - value / 2);
	    $('#box2').css('top', top - value /	6);
	    $('canvas.background').css('top', top - value /10);
	});
});
