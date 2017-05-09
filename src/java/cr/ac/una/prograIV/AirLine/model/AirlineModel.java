/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.AirLine.model;

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
    private final int SJ0=0,LIB=1,MIA=2,CAN=3,ORL=4,MAD=5,SFR=6,AMS=7,BER=8;
    private final Ciudad [] cities={
            new Ciudad("SJ0","SanJose","Costa Rica"),
            new Ciudad("LIB","Guanacaste","Costa Rica"),
            new Ciudad("MIA","Miami","USA"),
            new Ciudad("CAN","Cancun","Mexico"),
            new Ciudad("ORL","Orlando","USA"),
            new Ciudad("MAD","Madrid","España"),
            new Ciudad("SFR","SanFrancisco","USA"),
            new Ciudad("AMS","Amsterdan","Holanda"),
            new Ciudad("BER","Berlin","Alemania"),
        };
    public Ciudad getCiudad(int n)throws Exception{
        return cities[n];
    }
    public int randomPrice(){
        int rad = (int)Math.floor(Math.random() * 1000);
        return (rad < 150) ? rad+100 : rad;
    }
    public String randomNumVuelo(){
        int rad = (int)Math.floor(Math.random() * 10000);
        return String.valueOf((rad < 1000) ? rad+2000 : rad+1000);   
    }
    public AirlineModel()throws Exception{
        
        Vuelo[] vuelos={
            new Vuelo(randomNumVuelo(),getCiudad(SJ0),getCiudad(MIA),randomPrice()),
            new Vuelo(new String(randomNumVuelo()),getCiudad(LIB),getCiudad(CAN),randomPrice()),
            new Vuelo(new String(randomNumVuelo()),getCiudad(SJ0),getCiudad(ORL),randomPrice()),
            new Vuelo(new String(randomNumVuelo()),getCiudad(LIB),getCiudad(MAD),randomPrice()),
            new Vuelo(new String(randomNumVuelo()),getCiudad(SJ0),getCiudad(SFR),randomPrice()),
            new Vuelo(new String(randomNumVuelo()),getCiudad(LIB),getCiudad(AMS),randomPrice()),
            new Vuelo(new String(randomNumVuelo()),getCiudad(LIB),getCiudad(BER),randomPrice()),
        };
        promo = new ArrayList(Arrays.asList(vuelos));
        ciudades =  new ArrayList(Arrays.asList(cities));
    }
    public List<Ciudad> getCiudades(){
        return this.ciudades;
    }
    
    public List<Vuelo> getPromo(){
        return this.promo;
    }
    
    public List<Vuelo> getVuelos(){return getPromo();}//hacer otros vuelos distintos de la promo
    
    public List<Vuelo> getVuelos(String origen, String destino){
        ArrayList<Vuelo> result = new ArrayList();
        for(Vuelo v : this.getVuelos()){
            if(origen.equals("todos")&&destino.equals("todos")){
                return this.getVuelos();
            }
            else if(origen.equals("todos")&&!destino.equals("todos")){
               if(v.getCiudadDestino().getNombre().equals(destino))
                    result.add(v);
            }
            else if(!origen.equals("todos")&&destino.equals("todos")){
                   if(v.getCiudadOrigen().getNombre().equals(origen))
                    result.add(v);
            }
            else if(!origen.equals("todos")&&!destino.equals("todos")){
                if(v.getCiudadOrigen().getNombre().equals(origen) &&v.getCiudadDestino().getNombre().equals(destino))
                    result.add(v);
            }
        }
        
        return result;
    }
}
