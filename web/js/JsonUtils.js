var JsonUtils = JsonUtils || {};

JsonUtils.revive = function (k,v){
    if(v instanceof Object && v._class == 'Ciudad' )
        return new Ciudad(v.pkSigla,v.nombre,v.pais);
    if(v instanceof Object && v._class == 'Vuelo')
        return new Vuelo(v.pkNumero,
    JsonUtils.revive(0,v.ciudadByCiudadOrigen),
    JsonUtils.revive(0,v.ciudadByCiudadDestino),
    v.costo);
    return v;
};

JsonUtils.repalcer = function(k,v){
    if(v instanceof Ciudad)
        v._class = "Ciudad";
    if(v instanceof Vuelo)
        v._class = "Vuelo";
    return v;
};