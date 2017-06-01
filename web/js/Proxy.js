var Proxy = Proxy || {};

Proxy.getCiudades = function (callBack) {
    var AJAX_req = new XMLHttpRequest();
    url = "/AirLine/AirlineService?action=ciudadListAll";
    AJAX_req.open("GET", url, true);
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    AJAX_req.onreadystatechange = function () {
        if (AJAX_req.readyState === 4 && AJAX_req.status === 200) {
            var object = JSON.parse(AJAX_req.responseText, JsonUtils.revive);
            callBack(object);
        }
    };
    AJAX_req.send();
};

Proxy.getPromo = function (callBack) {
    var AJAX_req = new XMLHttpRequest();
    url = "/AirLine/AirlineService?action=vueloListPromo";
    AJAX_req.open("GET", url, true);
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    AJAX_req.onreadystatechange = function () {
        if (AJAX_req.readyState === 4 && AJAX_req.status === 200) {
            var object = JSON.parse(AJAX_req.responseText, JsonUtils.revive);
            callBack(object);
        }
    };
    AJAX_req.send();
};


Proxy.vuelosSearch = function (origen,destino,callBack) {
    //console.log("origen:"+origen+"     destino:"+destino);
    var AJAX_req = new XMLHttpRequest();
    url = "/AirLine/AirlineService?action=vueloListSearch";
    AJAX_req.open("POST", url, true);
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    AJAX_req.onreadystatechange = function () {
        if (AJAX_req.readyState === 4 && AJAX_req.status === 200) {
            var object = JSON.parse(AJAX_req.responseText, JsonUtils.revive);
            callBack(object);
        }
    };
    AJAX_req.send("origen="+origen+"&destino="+destino);
};

Proxy.avionAdd = function(avion,callBack){
    var jsonProducto = JSON.stringify(avion,JsonUtils.replacer);
    var AJAX_req = new XMLHttpRequest();
      
    url="/33-CarritoCompra/ProductosService?action=ProductAdd";
    AJAX_req.open( "POST", url, true );
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");      
    AJAX_req.onreadystatechange = function(){
        if( AJAX_req.readyState === 4 && AJAX_req.status === 200 ){
            if (parseInt(AJAX_req.responseText)==0){
                Proxy.productAddImagen(producto.codigo, imagen, callBack);
            }
            else{
                callBack(1);
            }
        }
        
    };
    AJAX_req.send("product="+jsonProducto); 
};

