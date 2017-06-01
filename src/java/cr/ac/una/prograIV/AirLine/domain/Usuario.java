package cr.ac.una.prograIV.AirLine.domain;

import java.util.HashSet;
import java.util.Set;

public class Usuario  implements java.io.Serializable {

    private int pkId;
    private String clave;
    private int tipo;
    private Set<Cliente> clientes = new HashSet<Cliente>(0);

    public Usuario() {
    }
	
    public Usuario(int pkId, String clave, int tipo) {
        this.pkId = pkId;
        this.clave = clave;
        this.tipo = tipo;
    }
    
    public Usuario(int pkId, String clave, int tipo, Set<Cliente> clientes) {
       this.pkId = pkId;
       this.clave = clave;
       this.tipo = tipo;
       this.clientes = clientes;
    }
   
    public int getPkId() {
        return this.pkId;
    }
    
    public void setPkId(int pkId) {
        this.pkId = pkId;
    }
    
    public String getClave() {
        return this.clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public int getTipo() {
        return this.tipo;
    }
    
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public Set<Cliente> getClientes() {
        return this.clientes;
    }
    
    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }
}