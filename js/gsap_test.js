TweenMax.to($('.circle'), 20, { y:50});
//丸（class=".circle"）をx軸へ150px移動

TweenMax.to($('.square'), 3,{ y:-150, rotation: 720});
//四角（class=".square"）をx軸y軸へ150px移動と

TweenMax.to($('.batsu'), 3,{ x:-80, y:-150, rotation: 720 });
//四角（class=".square"）をx軸y軸へ80、150px移動

//増殖アニメーション

// 増殖する場所
var $wrapper = document.querySelector('#js-wrapper');

// 増殖用の画像
var $originalItem = document.querySelectorAll('.original__item');


// 増殖アニメーション用のイージング
// https://greensock.com/ease-visualizer
var easingName = [
  'Back.easeInOut.config(1.7)',
];

       //ここに処理を書く
$(function(){
    setInterval(function(){

  // ランダムで１つ、要素が選ばれて複製する
  const randNum = Math.floor(Math.random() * $originalItem.length);
  const $clone = $originalItem[ randNum ].cloneNode(true);

  // 要素を挿入する
  $wrapper.appendChild($clone);

  // 要素を拡散する
  // ---------------------------------------------------------------
  var expandAnime = {
    x: Math.floor(Math.random() * window.innerWidth - window.innerWidth / 2),
    y: Math.floor(Math.random() * window.innerHeight - window.innerHeight / 2),
    rotation: Math.floor(Math.random() * 1440),
    scale: Math.random(),
    duration: 0.5 + Math.random() * 2.0,
    ease : easingName[Math.floor(Math.random() * easingName.length)]
  };

	TweenMax.set($clone,{
	x: Math.floor(Math.random() * window.innerWidth),
	y: Math.floor(window.innerHeight),

	});

  TweenMax.to($clone,10,{
    y: expandAnime.y,
    rotation: expandAnime.rotation,
    ease: expandAnime.easeOut,
    scale: expandAnime.scale
  });

  TweenMax.to($clone, 10, {y: Math.floor(Math.random() * window.innerHeight - window.innerHeight / 2), rotation: expandAnime.rotation, delay: 1, ease:Back.easeOut });

 TweenMax.to($clone , 25 , {autoAlpha:0});

  TweenMax.to($clone , 20 , {height:"300px" , width:"150px" , ease:Power1.easeOut , clearProps:"width"});
    },1000);
});