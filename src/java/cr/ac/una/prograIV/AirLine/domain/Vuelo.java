package cr.ac.una.prograIV.AirLine.domain;

import java.util.ArrayList;

/**
 *
 * @author Josue
 */
public class Vuelo implements Jsonable {
    String codigo;
    Ciudad ciudadOrigen;
    Ciudad ciudadDestino;
    int costo;
    ArrayList<Ciudad> escalas = new ArrayList();
    
    public Vuelo(String codigo, Ciudad origen, Ciudad destino, int costo){
        this.codigo=codigo;
        this.ciudadOrigen=origen;
        this.ciudadDestino=destino;
        this.costo=costo;
    }
    
    public void addEscala(Ciudad c){
        escalas.add(c);
    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Ciudad getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(Ciudad origen) {
        this.ciudadOrigen = origen;
    }

    public Ciudad getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(Ciudad destino) {
        this.ciudadDestino = destino;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public ArrayList<Ciudad> getEscalas() {
        return escalas;
    }

    public void setEscalas(ArrayList<Ciudad> escalas) {
        this.escalas = escalas;
    }
    public String toString(){
        return codigo+" "+ciudadOrigen+" "+ciudadDestino+" "+costo;
    }
}
