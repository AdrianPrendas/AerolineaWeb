/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.AirLine.bl;

import cr.ac.una.prograIV.AirLine.dao.*;
import cr.ac.una.prograIV.AirLine.domain.*;

import java.util.LinkedHashMap;

/**
 *
 * @author chgari
 */
public class BaseBL {
    private final LinkedHashMap<String, IBaseDAO> daos;

    public BaseBL() {
        daos = new LinkedHashMap();
        daos.put("cr.ac.una.prograIV.AirLine.domain.Ciudad", new CiudadDAO());
        daos.put("cr.ac.una.prograIV.AirLine.domain.Vuelo", new VueloDAO());
    }
    
    public IBaseDAO getDao(String className){
        return daos.get(className);
    }
}
