
function AirlineModel() {
    this.AirlineModel();
}

AirlineModel.prototype = {
    AirlineModel: function () {
        this.buscados = [];
        this.ciudades = [];
        this.promo = [];
        this.carrito={};//hashTable
    },
    isCarritoEmpty:function(){
        return (this.carrito.length==0)?true:false;
    }
};


