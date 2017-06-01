package cr.ac.una.prograIV.AirLine.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Avion  implements java.io.Serializable {

    private int pkId;
    private Date anno;
    private String modelo;
    private String marca;
    private byte cantPasajeros;
    private byte cantFilas;
    private byte asientosFila;
    private Set<Vuelo> vuelos = new HashSet<Vuelo>(0);
    private Set<Asiento> asientos = new HashSet<Asiento>(0);

    public Avion() {
    }
	
    public Avion(int pkId, String modelo, String marca, byte cantPasajeros, byte cantFilas, byte asientosFila) {
        this.pkId = pkId;
        this.modelo = modelo;
        this.marca = marca;
        this.cantPasajeros = cantPasajeros;
        this.cantFilas = cantFilas;
        this.asientosFila = asientosFila;
    }
    
    public Avion(int pkId, Date anno, String modelo, String marca, byte cantPasajeros, byte cantFilas, byte asientosFila, Set<Vuelo> vuelos, Set<Asiento> asientos) {
       this.pkId = pkId;
       this.anno = anno;
       this.modelo = modelo;
       this.marca = marca;
       this.cantPasajeros = cantPasajeros;
       this.cantFilas = cantFilas;
       this.asientosFila = asientosFila;
       this.vuelos = vuelos;
       this.asientos = asientos;
    }
   
    public int getPkId() {
        return this.pkId;
    }
    
    public void setPkId(int pkId) {
        this.pkId = pkId;
    }
    
    public Date getAnno() {
        return this.anno;
    }
    
    public void setAnno(Date anno) {
        this.anno = anno;
    }
    
    public String getModelo() {
        return this.modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String getMarca() {
        return this.marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public byte getCantPasajeros() {
        return this.cantPasajeros;
    }
    
    public void setCantPasajeros(byte cantPasajeros) {
        this.cantPasajeros = cantPasajeros;
    }
    public byte getCantFilas() {
        return this.cantFilas;
    }
    
    public void setCantFilas(byte cantFilas) {
        this.cantFilas = cantFilas;
    }
    public byte getAsientosFila() {
        return this.asientosFila;
    }
    
    public void setAsientosFila(byte asientosFila) {
        this.asientosFila = asientosFila;
    }
    public Set<Vuelo> getVuelos() {
        return this.vuelos;
    }
    
    public void setVuelos(Set<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }
    public Set<Asiento> getAsientos() {
        return this.asientos;
    }
    
    public void setAsientos(Set<Asiento> asientos) {
        this.asientos = asientos;
    }
}