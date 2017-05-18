
function Vuelo(numero, ciudadOrigen, ciudadDestino, costo, escalas) {
    this.Vuelo(numero, ciudadOrigen, ciudadDestino, costo, escalas);
}

Vuelo.prototype = {
    Vuelo: function (numero, ciudadOrigen, ciudadDestino, costo, escalas){
        this.pkNumero = numero;
        this.ciudadByCiudadOrigen = ciudadOrigen;
        this.ciudadByCiudadDestino = ciudadDestino;
        this.costo=costo;
        this.escalas = escalas;
    },
    toString: function () {
        return this.pkNumero+" "+this.ciudadByCiudadOrigen+" "+this.ciudadByCiudadDestino+" "+
                this.costo+" "+this.escalas;
    }
};