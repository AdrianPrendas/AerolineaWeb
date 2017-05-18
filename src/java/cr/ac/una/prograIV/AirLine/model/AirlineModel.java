/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.AirLine.model;

import cr.ac.una.prograIV.AirLine.bl.CiudadBL;
import cr.ac.una.prograIV.AirLine.bl.VueloBL;
import cr.ac.una.prograIV.AirLine.domain.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Josue
 */
public class AirlineModel {
    private List<Vuelo> promo;
    private List<Ciudad> ciudades;
  
    public AirlineModel()throws Exception{
      
        
        //promo = new ArrayList(Arrays.asList(vuelos));
        //ciudades =  new ArrayList(Arrays.asList(cities));
    }
  
   
    public List<Ciudad> getCiudades(){
        //return this.ciudades;
        List<Ciudad> lista = new CiudadBL().findAll(Ciudad.class.getName());
        List<Ciudad> result = new ArrayList();
        for(Ciudad c : lista){
            result.add(new Ciudad(c));
        }
        return result;
    }
    
    public List<Vuelo> getPromo(){
        //return this.promo;
        List<Vuelo> lista = new VueloBL().findAll(Vuelo.class.getName());
        List<Vuelo> result = new ArrayList();
        for(Vuelo v : lista){
            result.add(new Vuelo(v));
        }
        return result;
    }
    
    public List<Vuelo> getVuelos(){return getPromo();}//hacer otros vuelos distintos de la promo
    
    public List<Vuelo> getVuelos(String origen, String destino){
        ArrayList<Vuelo> result = new ArrayList();
        for(Vuelo v : this.getVuelos()){
            if(origen.equals("todos")&&destino.equals("todos")){
                return this.getVuelos();
            }
            else if(origen.equals("todos")&&!destino.equals("todos")){
               if(v.getCiudadByCiudadDestino().getNombre().equals(destino))
                    result.add(v);
            }
            else if(!origen.equals("todos")&&destino.equals("todos")){
                   if(v.getCiudadByCiudadOrigen().getNombre().equals(origen))
                    result.add(v);
            }
            else if(!origen.equals("todos")&&!destino.equals("todos")){
                if(v.getCiudadByCiudadOrigen().getNombre().equals(origen) &&
                        v.getCiudadByCiudadDestino().getNombre().equals(destino))
                    result.add(v);
            }
        }
        
        return result;
    }
}
