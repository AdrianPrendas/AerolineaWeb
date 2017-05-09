//http://www.jquery-az.com/bootstrap-theme/products-carousel/product-carousel.html
var PATH = "pictures/descuentos/";
var imgs = ["0.JPG","1.JPG","2.JPG","3.JPG"];
function pageLoad(event){
	setCarrucel();

}
var setCarrucel = function(){
	var html="";
	//listando los nodos del carrucel
	html += '<li data-target="#carusel" data-slide-to="0" class="active"></li>';
	for(var i=1;i<imgs.length;i++)
		html += '<li data-target="#carusel" data-slide-to="'+i+'"></li>';
	$("#listaCarrucel").html(html);
	//setiando las imagenes de cada nodo en el carrucel
	html="";
	html += '<div class="item active">';
	html += 	'<img class="image" src="'+PATH+imgs[0]+'" alt="main" class="img-responsive">';
	html += '</div>';
	for(var i=1;i<imgs.length;i++){
		html += '<div class="item">';
        html +=		'<img src="'+PATH+imgs[i]+'" class="image" class="img-responsive">';
        html +=	'</div>';
	}
	$("#imagenesCarrucel").html(html);
};

document.addEventListener("DOMContentLoaded",pageLoad);