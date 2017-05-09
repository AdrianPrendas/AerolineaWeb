var EXT = ".JPG";
var PATH = "pictures/lugares/";
var PLACES = [];

function AirlineView(model){
    this.AirlineView(model);
}

AirlineView.prototype = {
  AirlineView: function(model){
      this.model=model;
  },
  showOrigenes:function(){
      //model.ciudades
      //{nombre:"",pais:"",sigla:""}
      //var ciudades = model.ciudades;
  },
  showDestinos:function(){
      //console.log(model.promo);
  },
  showPromos:function(){
      //model.promo
      //{ciudadOrigen:Ciudad,ciudadDestino:ciudad,codigo:0,costo,escalas:[]}
      //sigla,nombre,pais//nombre
      //console.log(model.promo);
      setCarrucel(4,model.promo);
      setBusqueda(model.promo);
  },
  showBuscados:function(){
      //model.buscados
      console.log(model.buscados);
      insertElementosBuscados(model.buscados);
  }
};

var elemento = {origen:"",destino:"",img:"",precio:0,subTitulo:"",link:""};//elemento
//var elementos = [];


var setCarrucel = function (n,arr) {//cantidad de elementos por slide
    var  html = "";
    var arrItems = [];//c/u de los elementos del slide
    //elementos =[];
    for (i = 0; i < arr.length; i++) {
        var e = elemento;
        e.origen = arr[i].ciudadOrigen.nombre;
        e.destino = arr[i].ciudadDestino.nombre;
        e.img = PATH + arr[i].ciudadDestino.nombre + EXT;
        e.precio = arr[i].costo;
        e.subTitulo = arr[i].codigo;//
        e.link = "";//

        arrItems.push(item(e.destino,e.img, e.precio, e.subTitulo, e.link));
        //elementos.push(e);
        //console.log(e);
        
    }
    var items=""; 
    for(i=0,k=1,c=0;i<arrItems.length;i++,k++){
        items+=arrItems[i];
        if(k===n){
            html += setSlide(items,c++);
            items= "";
            k=0;
        }
    }
    if(items!="")
        html += setSlide(items);
    $("#carousel-contenido").html(html);
};

var setSlide = function (html, activo) {
    return '<div class="item ' + ((activo==0) ? "active" : "") + '">' + html + '</div>';
};

var item = function (titulo, img, price, subTitulo, link) {
    var html = '<div class="col-md-3 col-sm-4 col-xs-12">' +
            '<div class="spe-prods">' +
            '<div class="mainbox">' +
            '<h3>' + titulo + '</h3>' + //titulo
            '<img class="rotprod" src="' + img + '" alt="">' + //img
            '</div>' +
            '<div class="price-big">' +
            '<div>' +
            '<div class="floatting-price">' +
            '<h3>$' + price + '</h3>' + //precio
            '</div>' +
            '<div class="month">' +
            '<p>' + subTitulo + '</p>' + //sub_titulo
            '</div>' +
            '</div>' +
            '<div class="ordersection">' +
            '<a href="' + link + '" class="buybtn">Order</a>' + //link
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>';
    return html;
};

var setBusqueda = function(arr){
    $("#origen").html("");
    $("#destino").html("");
    $("#precio").html("");
    tablaOrigen = {};
    tablaDestino = {};
    var arrOrigenHtml=[];
    var arrDestinoHtml =[];
    var arrPrecioHtml =[];
    
    arrOrigenHtml.push(setOption("todos"));
    arrDestinoHtml.push(setOption("todos"));
    arrPrecioHtml.push(setOption("todos"));
    
    for(e in arr){
        var origen = arr[e].ciudadOrigen.nombre;
        var destino = arr[e].ciudadDestino.nombre;
        var precio = arr[e].costo;
        
        if(!tablaOrigen[origen]){
            tablaOrigen[origen] = origen;
            arrOrigenHtml.push(setOption(origen));
        }
        if(!tablaDestino[destino]){
            tablaDestino[destino]=destino;
            arrDestinoHtml.push(setOption(destino));
        }
        
        arrPrecioHtml.push(setOption(precio));
    }
    
    for(o in arrOrigenHtml)
        $("#origen").append(arrOrigenHtml[o]);
    
    for(d in arrDestinoHtml)
        $("#destino").append(arrDestinoHtml[d]);
    
    for(p in arrPrecioHtml)
        $("#precio").append(arrPrecioHtml[p]);
    
    $("#salida").val("dd/mm/yyyy");
    $("#llegada").val("dd/mm/yyyy");
}

var setOption = function(param){
    return '<option value="'+param+'">'+param+'</option>';

}
/////////////////////////////////////////////////////////////////////
var insertElementosBuscados =function(arr){
    var html="";
     for (i = 0; i < arr.length; i++) {
        var e = elemento;
        e.origen = arr[i].ciudadOrigen.nombre;
        e.destino = arr[i].ciudadDestino.nombre;
        e.img = PATH + arr[i].ciudadDestino.nombre + EXT;
        e.precio = arr[i].costo;
        e.subTitulo = arr[i].codigo;//
        e.link = "";//

        html += item(e.destino,e.img, e.precio, e.subTitulo, e.link);
        //elementos.push(e);
        //console.log(e);
    }
    $("#busqueda").html(html);
};
