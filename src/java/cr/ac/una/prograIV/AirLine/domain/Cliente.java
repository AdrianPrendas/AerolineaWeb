package cr.ac.una.prograIV.AirLine.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Cliente  implements java.io.Serializable {

    private int pkId;
    private Usuario usuario;
    private String nombre;
    private String apellidos;
    private String email;
    private Date fechaNacimiento;
    private int celular;
    private String direccion;
    private Float direccion2;
    private Set<Tiquete> tiquetes = new HashSet<Tiquete>(0);

    public Cliente() {
    }
	
    public Cliente(int pkId, Usuario usuario, String nombre, String apellidos, String email, Date fechaNacimiento, int celular, String direccion) {
        this.pkId = pkId;
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.celular = celular;
        this.direccion = direccion;
    }
    
    public Cliente(int pkId, Usuario usuario, String nombre, String apellidos, String email, Date fechaNacimiento, int celular, String direccion, Float direccion2, Set<Tiquete> tiquetes) {
       this.pkId = pkId;
       this.usuario = usuario;
       this.nombre = nombre;
       this.apellidos = apellidos;
       this.email = email;
       this.fechaNacimiento = fechaNacimiento;
       this.celular = celular;
       this.direccion = direccion;
       this.direccion2 = direccion2;
       this.tiquetes = tiquetes;
    }
   
    public int getPkId() {
        return this.pkId;
    }
    
    public void setPkId(int pkId) {
        this.pkId = pkId;
    }
    
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public int getCelular() {
        return this.celular;
    }
    
    public void setCelular(int celular) {
        this.celular = celular;
    }
    
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public Float getDireccion2() {
        return this.direccion2;
    }
    
    public void setDireccion2(Float direccion2) {
        this.direccion2 = direccion2;
    }
    
    public Set<Tiquete> getTiquetes() {
        return this.tiquetes;
    }
    
    public void setTiquetes(Set<Tiquete> tiquetes) {
        this.tiquetes = tiquetes;
    }
}