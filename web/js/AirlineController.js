
function AirlineController(model,view){
    this.AirlineController(model,view);
};

AirlineController.prototype={
    AirlineController:function(model,vew){
        this.model = model;
        this.view = view;
        Proxy.getCiudades(function(result){
            model.ciudades = result;
            view.showOrigenes();
            view.showDestinos();
        });
        Proxy.getPromo(function(result){
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
    }
};
