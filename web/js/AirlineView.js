var EXT = ".JPG";
var PATH = "pictures/lugares/";
var PLACES = [];
/////////////////////////////////////////////////////////////////////
var elemento = {origen: "", destino: "", img: "", precio: 0, numeroVuelo: ""};
var toString= function(e){
    var html="";
    for(k in e)
        html+=e[k]+" ";
    return html;
};
var revive = function(e){ 
    var arr = e.split(' ');
    var e = elemento;
    var i=0;
    for(k in e){
        e[k]=arr[i++];
    }
    //console.log(e);
    return e;
};
var paginas = [];
var p = 0;//pagina actual, en paginacion
//***************************************************************************
function AirlineView(model) {
    this.AirlineView(model);
}
AirlineView.prototype = {
    AirlineView: function (model) {
        this.model = model;
    },
    showOrigenes: function () {
        //model.ciudades
        //{nombre:"",pais:"",sigla:""}
        //var ciudades = model.ciudades;
    },
    showDestinos: function () {
        //console.log(model.promo);
    },
    showPromos: function () {
        //model.promo
        //{ciudadOrigen:Ciudad,ciudadDestino:ciudad,codigo:0,costo,escalas:[]}
        //sigla,nombre,pais//nombre
        //console.log(model.promo);
        setCarrucel(this.model.promo);//setiar al tamño de la ventana // responsive
        setBusqueda(this.model.promo);
        carruselInit();
    },
    showBuscados: function () {
        //model.buscados
        //console.log("buscados: "+model.buscados);

        setPaginacion(this.model.buscados, 4);//setiar al tamño de la ventana // responsive
    },
    showPopUp: function(e){
        //console.log(e);
        var html="";
        html = itemWithoutAdd(e);
        $("#pop-up-container").html(html);
        document.getElementById("overlay").style.display ="block";
        document.getElementById("pop-up").style.display ="block";
        
    }
};
//***************************************************************************
var setOption = function (param) {
    return '<option value="' + param + '">' + param + '</option>';

}
var setBusqueda = function (arr) {
    //limpiando tags
    $("#origen").html("");
    $("#destino").html("");
    $("#precio").html("");
    //hashTable
    tablaOrigen = {};
    tablaDestino = {};
    tablacosto = {};
    //default
    $("#origen").append(setOption("todos"));
    $("#destino").append(setOption("todos"));
    $("#precio").append(setOption("todos"));

    for (e in arr) {
        var origen = arr[e].ciudadByCiudadOrigen.nombre;
        var destino = arr[e].ciudadByCiudadDestino.nombre;
        var costo = arr[e].costo;

        if (!tablaOrigen[origen])
            tablaOrigen[origen] = origen;
        if (!tablaDestino[destino])
            tablaDestino[destino] = destino;
        if (!tablacosto["" + costo])
            tablacosto["" + costo] = costo;
    }

    for (o in tablaOrigen)
        $("#origen").append(setOption(tablaOrigen[o]));
    for (d in tablaDestino)
        $("#destino").append(setOption(tablaDestino[d]));
    for (c in tablacosto)
        $("#precio").append(setOption(tablacosto[c]));

    $("#salida").val("dd/mm/yyyy");
    $("#llegada").val("dd/mm/yyyy");
}
/////////////////////////////////////////////////////////////////////
var itemWithoutAdd = function (e) {
    //e.origen, e.destino, e.img, e.precio, e.numeroVuelo, e.link
    var html = '<div class="col-xs-12 col-sm-4 col-md-3 ">' +
            '<div class="spe-prods">' +
            '<div class="mainbox"">' +
            '<h3>' + e.destino + '</h3>' + //titulo
            '<img style="width:175px;" class="rotprod" src="' + e.img + '" alt="">' + //img
            '<h3>' + e.origen + '</h3>' + //titulo
            '</div>' +
            '<div class="price-big">' +
            '<div>' +
            '<div class="floatting-price">' +
            '<h3>$' + e.precio + '</h3>' + //precio
            '</div>' +
            '<div class="month">' +
            '<p>' + e.numeroVuelo + '</p>' + //sub_titulo
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>';
    return html;
};
var item = function (e) {
    //console.log(e.destino+" "+e.img+" "+e.origen+" "+e.precio+" "+e.numeroVuelo);
    //console.log(string);
    var html = '<div class="col-xs-12 col-sm-4 col-md-3 ">' +
            '<div class="spe-prods">' +
            '<div class="mainbox"">' +
            '<h3>' + e.destino + '</h3>' + //titulo
            '<img style="width:175px;" class="rotprod" src="' + e.img + '" alt="">' + //img
            '<h3>' + e.origen + '</h3>' + //titulo
            '</div>' +
            '<div class="price-big">' +
            '<div>' +
            '<div class="floatting-price">' +
            '<h3>$' + e.precio + '</h3>' + //precio
            '</div>' +
            '<div class="month">' +
            '<p>' +"numero de vuelo"+ e.numeroVuelo + '</p>' + //sub_titulo
            '</div>' +
            '</div>' +
            '<div class="ordersection" style="height:40px;">' +
            '<a style="margin-top:-15px;" href="#" onclick="controller.agregarACarrito('+"'"+toString(e)+"'"+');" class="buybtn">Order</a>' + //link
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>';
    return html;
};
var setItem = function (html, activo) {
    return '<div class="item ' + ((activo == 0) ? "active" : "") + '">' + html + '</div>';
};
//***************************************************************************
var setCarrucel = function (arr) {//cantidad de elementos por slide
    var html = "";
    var items = [];//c/u de los elementos del slide
    for (var i = 0; i < arr.length; i++) {
        var e = elemento;
        e.origen = arr[i].ciudadByCiudadOrigen.nombre;
        e.destino = arr[i].ciudadByCiudadDestino.nombre;
        e.img = PATH + arr[i].ciudadByCiudadDestino.nombre + EXT;
        e.precio = arr[i].costo;
        e.numeroVuelo = arr[i].pkNumero;
        //console.log(e.origen+" "+e.destino+" "+e.img+" "+e.precio+" "+e.numeroVuelo);
        items.push(item(e));
    }
    for (var i = 0; i < items.length; i++)
        html += setItem(items[i], ((i != 0) ? i : 0));

    $("#carousel-contenido").html(html);
};
/////////////////////////////////////////////////////////////////////
var paginaAnterior = function () {
    if (p > 0)
        p--;
    paginacion(p);
};
var paginaSiguiente = function () {
    if (p < paginas.length - 1)
        p++;
    paginacion(p);
};
var setBotonesPag = function (n, active, activo) {
    return '<li ' + ((active == activo) ? 'class="active"' : '') + '><a href="#" onclick="paginacion(' + n + ');">' + n + '</a></li>';
};
var paginacion = function (n) {
    p = n;

    if (paginas.length != 0)
        $("#busqueda").html(paginas[n]);
    else
        $("#busqueda").html("");

    var html = ' <li ' + ((n == 0) ? 'class="disable' : '') + '"><a href="#" onclick="paginaAnterior();">&laquo;</a></li>';
    for (i = 0; i < paginas.length; i++) {
        html += setBotonesPag(i, i, n);
    }
    html += '<li ' + ((n == paginas.length - 1) ? 'class="disable"' : '') + '><a href="#" onclick="paginaSiguiente();">&raquo;</a></li>';

    $("#paginacion").html(html);
};
var pagina = function (arr) {
    var html = "";
    for (i = 0; i < arr.length; i++) {
        var e = elemento;
        e.origen = arr[i].ciudadByCiudadOrigen.nombre;
        e.destino = arr[i].ciudadByCiudadDestino.nombre;
        e.img = PATH + arr[i].ciudadByCiudadDestino.nombre + EXT;
        e.precio = arr[i].costo;
        e.numeroVuelo = "numero de vuelo: " + arr[i].pkNumero;//
        e.link = "";//

        html += item(e);
        //elementos.push(e);
        //console.log(e);
    }
    return html;
};
//***************************************************************************
var setPaginacion = function (arr, n) {
    //console.log(arr);
    paginas = [];
    p = 0;
    for (var i = 0, j = 1; i < arr.length; j++, i += n) {
        var nArr;
        if (j * n < arr.length)
            nArr = arr.slice(i, j * n);
        else
            nArr = arr.slice(i);

        paginas.push(pagina(nArr));
    }

    paginacion(p);
};
//////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////
function carruselInit() {
    //Initializing WOW aninations
    new WOW().init();

    //Small carosel code set here
    jQuery('.carousel[data-type="multi"] .item').each(function () {
        var next = jQuery(this).next();
        if (!next.length) {
            next = jQuery(this).siblings(':first');
        }
        next.children(':first-child').clone().appendTo(jQuery(this));

        for (var i = 0; i < 2; i++) {
            next = next.next();
            if (!next.length) {
                next = jQuery(this).siblings(':first');
            }
            next.children(':first-child').clone().appendTo($(this));
        }
    });
    //Ending of small carosel


}
//////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////



