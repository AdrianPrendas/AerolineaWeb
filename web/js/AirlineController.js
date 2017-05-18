
function AirlineController(model,view){
    this.AirlineController(model,view);
};

AirlineController.prototype={
    AirlineController:function(model,vew){
        this.model = model;
        this.view = view;
        Proxy.getCiudades(function(result){
            //console.log("Ciudades:"+result);
            model.ciudades = result;
            view.showOrigenes();
            view.showDestinos();
        });
        Proxy.getPromo(function(result){
            //console.log("Promos:"+result);
            model.promo=result;
            view.showPromos();
        });
        model.buscados = [];
    },
    buscar:function(){
        var origen = $("#origen").val();
        var destino = $("#destino").val();
        var model = this.model;
        var view = this.view;
        Proxy.vuelosSearch(origen,destino,function(result){
            model.buscados = result;
            view.showBuscados();
        });
    },
    agregarACarrito:function(e){    
        var objeto = revive(e);
          if(!model.carrito[e])//no se repetiran viajes
            model.carrito[e] = objeto;
        else{
            alert("El viaje ya fue agregado con anterioridad");
            return;
        }
            
        this.view.showPopUp(objeto);
    }
};
