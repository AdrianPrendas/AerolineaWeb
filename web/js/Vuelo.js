
function Vuelo(codigo, ciudadOrigen, ciudadDestino, costo, escalas) {
    this.Vuelo(codigo, ciudadOrigen, ciudadDestino, costo, escalas);
}

Vuelo.prototype = {
    Vuelo: function (codigo, ciudadOrigen, ciudadDestino, costo, escalas){
        this.codigo = codigo;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.costo=costo;
        this.escalas = escalas;
    },
    toString: function () {
        return "";
    }
};