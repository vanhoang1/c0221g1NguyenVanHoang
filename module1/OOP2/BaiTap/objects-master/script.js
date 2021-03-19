

function Hero(image, top, left,  size,speedX,speedY){
  this.image = image;
  this.top = top;
  this.left = left;
  this.size = size;
  this.speedX=speedX;
  this.speedY=speedY;

  this.getHeroElement = function(){
    return '<img width="'+ this.size + '"' +
      ' height="'+ this.size + '"' +
      ' src="' + this.image +'"' +
      ' style="top: '+this.top+'px; left:'+this.left+'px;position:absolute;" />';
  };
  this.moveX=function () {
    this.left+=this.speedX;
  };
  this.moveY=function () {
     this.top-=this.speedY
  };
  this.move=function () {
    //
    if( this.left<30||this.left>500+this.size){
      this.speedX = -this.speedX;
    }
    if( this.top<20||this.top>400+this.size){
      this.speedY=-this.speedY
    }
    this.moveY();
    this.moveX();
  }
}

var hero = new Hero('pngegg.png', 20, 30, 200,30,30);

function start(){
  hero.move();

  document.getElementById('game').innerHTML = hero.getHeroElement();
  setTimeout(start, 50)
}

start();