package cr.ac.una.prograIV.AirLine.domain;

import java.util.HashSet;
import java.util.Set;

public class Tiquete  implements java.io.Serializable {


    private Integer pkNumero;
    private Cliente cliente;
    private Vuelo vuelo;
    private Set<Asiento> asientos = new HashSet<Asiento>(0);
    private Set<Compra> compras = new HashSet<Compra>(0);

    public Tiquete() {
    }
	
    public Tiquete(Cliente cliente, Vuelo vuelo) {
        this.cliente = cliente;
        this.vuelo = vuelo;
    }
    
    public Tiquete(Cliente cliente, Vuelo vuelo, Set<Asiento> asientos, Set<Compra> compras) {
       this.cliente = cliente;
       this.vuelo = vuelo;
       this.asientos = asientos;
       this.compras = compras;
    }
   
    public Integer getPkNumero() {
        return this.pkNumero;
    }
    
    public void setPkNumero(Integer pkNumero) {
        this.pkNumero = pkNumero;
    }
    
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Vuelo getVuelo() {
        return this.vuelo;
    }
    
    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }
    
    public Set<Asiento> getAsientos() {
        return this.asientos;
    }
    
    public void setAsientos(Set<Asiento> asientos) {
        this.asientos = asientos;
    }
    
    public Set<Compra> getCompras() {
        return this.compras;
    }
    
    public void setCompras(Set<Compra> compras) {
        this.compras = compras;
    }
}