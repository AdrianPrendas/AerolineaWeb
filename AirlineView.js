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
      setCarrucel(model.promo,4);//setiar al tamño de la ventana // responsive
      setBusqueda(model.promo);
  },
  showBuscados:function(){
      //model.buscados
      //console.log("buscados: "+model.buscados);
      
      setPaginacion(model.buscados,4);//setiar al tamño de la ventana // responsive
  }
};

var elemento = {origen:"",destino:"",img:"",precio:0,subTitulo:"",link:""};//elemento
//var elementos = [];


var setCarrucel = function (arr,n) {//cantidad de elementos por slide
    var  html = "";
    var arrItems = [];//c/u de los elementos del slide
    //elementos =[];
    for (i = 0; i < arr.length; i++) {
        var e = elemento;
        e.origen = arr[i].ciudadByCiudadOrigen.nombre;
        e.destino = arr[i].ciudadByCiudadDestino.nombre;
        e.img = PATH + arr[i].ciudadByCiudadDestino.nombre + EXT;
        e.precio = arr[i].costo;
        e.subTitulo = "numero de vuelo: " + arr[i].pkNumero;//
        e.link = "";//

        arrItems.push(item(e.origen,e.destino,e.img, e.precio, e.subTitulo, e.link));
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

var item = function (origen, destino, img, price, subTitulo, link) {
    var html = '<div class="col-md-3 col-sm-4 col-xs-12">' +
            '<div class="spe-prods">' +
            '<div class="mainbox"">' +
            '<h3>' + origen + '</h3>' + //titulo
            '<img style="width:175px;" class="rotprod" src="' + img + '" alt="">' + //img
            '<h3>' + destino + '</h3>' + //titulo
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
            '<div class="ordersection" style="height:40px;">' +
            '<a style="margin-top:-15px;" href="' + link + '" class="buybtn">Order</a>' + //link
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
        var origen = arr[e].ciudadByCiudadOrigen.nombre;
        var destino = arr[e].ciudadByCiudadDestino.nombre;
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
var pagina =function(arr){
    var html="";
     for (i = 0; i < arr.length; i++) {
        var e = elemento;
        e.origen = arr[i].ciudadByCiudadOrigen.nombre;
        e.destino = arr[i].ciudadByCiudadDestino.nombre;
        e.img = PATH + arr[i].ciudadByCiudadDestino.nombre + EXT;
        e.precio = arr[i].costo;
        e.subTitulo = "numero de vuelo: " + arr[i].pkNumero;//
        e.link = "";//

        html += item(e.origen,e.destino,e.img, e.precio, e.subTitulo, e.link);
        //elementos.push(e);
        //console.log(e);
    }
    return html;
};
//***************************************************************************
var paginas = [];
var p=0;
var setPaginacion = function(arr,n){
    paginas = [];
    p=0;
    for(var i=0,j=1;i<arr.length;j++,i+=n){
        var nArr;
        if(j*n<arr.length)
            nArr = arr.slice(i,j*n);
        else
            nArr = arr.slice(i);
        
        paginas.push(pagina(nArr));
    }
    
    paginacion(p);
};

var setBotonesPag = function(n,active,activo){
    return '<li '+((active==activo)?'class="active"':'')+'><a href="#" onclick="paginacion('+n+');">'+n+'</a></li>';
};

var paginacion = function(n){
    console.log("n:"+n);
    p=n;
    
    if(paginas.length!=0)
        $("#busqueda").html(paginas[n]);
    else
        $("#busqueda").html("");
    
    var html =' <li '+((n==0)?'class="disable':'')+'"><a href="#" onclick="paginaAnterior();">&laquo;</a></li>';
    for(i=0;i<paginas.length;i++){
        html += setBotonesPag(i,i,n);
    }
    html+='<li '+((n==paginas.length-1)?'class="disable"':'')+'><a href="#" onclick="paginaSiguiente();">&raquo;</a></li>';
    
    $("#paginacion").html(html);
};
var paginaSiguiente = function(){if(p<paginas.length-1)p++;paginacion(p);};
var paginaAnterior = function(){if(p>0)p--;paginacion(p);};
//////////////////////////////////////////////////////////////////////
