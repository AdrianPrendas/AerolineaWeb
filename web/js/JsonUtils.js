var JsonUtils = JsonUtils || {};

JsonUtils.revive = function (k,v){
    if(v instanceof Object && v._class == 'Ciudad' )
        return new Ciudad(v.sigla,v.nombre,v.pais);
    if(v instanceof Object && v._class == 'Vuelo')
        return new Vuelo(v.codigo,
    JsonUtils.revive(0,v.ciudadOrigen),JsonUtils.revive(0,v.ciudadDestino),
    v.costo,v.escalas);
    return v;
}

JsonUtils.repalcer = function(k,v){
    if(v instanceof Ciudad)
        v._class = "Ciudad";
    if(v instanceof Vuelo)
        v._class = "Vuelo";
    return v;
}