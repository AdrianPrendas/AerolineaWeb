package cr.ac.una.prograIV.AirLine.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import cr.ac.una.prograIV.AirLine.bl.CiudadBL;
import cr.ac.una.prograIV.AirLine.bl.VueloBL;
import cr.ac.una.prograIV.AirLine.domain.Ciudad;
import cr.ac.una.prograIV.AirLine.domain.Vuelo;
import cr.ac.una.prograIV.AirLine.model.AirlineModel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josue
 */
public class Test {

    private final int SJ0 = 0, LIB = 1, MIA = 2, CAN = 3, ORL = 4, MAD = 5, SFR = 6, AMS = 7, BER = 8;
    private final Ciudad[] cities = {
        new Ciudad("SJ0", "SanJose", "Costa Rica"),
        new Ciudad("LIB", "Guanacaste", "Costa Rica"),
        new Ciudad("MIA", "Miami", "USA"),
        new Ciudad("CAN", "Cancun", "Mexico"),
        new Ciudad("ORL", "Orlando", "USA"),
        new Ciudad("MAD", "Madrid", "España"),
        new Ciudad("SFR", "SanFrancisco", "USA"),
        new Ciudad("AMS", "Amsterdan", "Holanda"),
        new Ciudad("BER", "Berlin", "Alemania"),};

    public Test()throws Exception {
        CiudadBL cBL = new CiudadBL();
        VueloBL vBL = new VueloBL();
        
        Vuelo[] vuelos = {
            new Vuelo(randomNumVuelo(), getCiudad(SJ0), getCiudad(MIA), randomPrice()),
            new Vuelo(randomNumVuelo(), getCiudad(LIB), getCiudad(CAN), randomPrice()),
            new Vuelo(randomNumVuelo(), getCiudad(SJ0), getCiudad(ORL), randomPrice()),
            new Vuelo(randomNumVuelo(), getCiudad(LIB), getCiudad(MAD), randomPrice()),
            new Vuelo(randomNumVuelo(), getCiudad(SJ0), getCiudad(SFR), randomPrice()),
            new Vuelo(randomNumVuelo(), getCiudad(LIB), getCiudad(AMS), randomPrice()),
            new Vuelo(randomNumVuelo(), getCiudad(LIB), getCiudad(BER), randomPrice()),
        };
        
        for(int i=0;i<cities.length;i++){
            cBL.save(getCiudad(i));
        }
        for(int i=0;i<vuelos.length;i++){
            vBL.save(vuelos[i]);
        }
        

    }

    public Ciudad getCiudad(int n) throws Exception {
        return cities[n];
    }

    public int randomPrice() {
        int rad = (int) Math.floor(Math.random() * 1000);
        return (rad < 150) ? rad + 100 : rad;
    }

    public int randomNumVuelo() {
        int rad = (int) Math.floor(Math.random() * 10000);
        return (rad < 1000) ? rad + 2000 : rad + 1000;
    }

    public static void main(String[] args) {
        
        /*try {
            new Test();
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        CiudadBL cBL = new CiudadBL();
        VueloBL vBL = new VueloBL();
        List<Vuelo> lista = vBL.findAll(Vuelo.class.getName());
        for(Vuelo v :lista){
            System.out.println(v);
        }

    }
}
