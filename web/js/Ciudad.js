

function Ciudad(sigla, nombre, pais) {
    this.Ciudad(sigla, nombre, pais);
}

Ciudad.prototype = {
    Ciudad: function (s, n, p) {
        this.pkSigla = s;
        this.nombre = n;
        this.pais = p;
    },
    toString: function () {
        return this.pkSigla + " " + this.nombre + " " + this.pais;
    }
}