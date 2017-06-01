package cr.ac.una.prograIV.AirLine.domain;

import java.util.HashSet;
import java.util.Set;

public class Vuelo implements java.io.Serializable, Jsonable {

    private int pkNumero;
    private Avion avion;
    private Ciudad ciudadByCiudadDestino;
    private Ciudad ciudadByCiudadOrigen;
    private Horario horario;
    private Set<Tiquete> tiquetes = new HashSet<Tiquete>(0);

    public Vuelo() {
    }
    
    public Vuelo(Vuelo v) {
       this.pkNumero = v.pkNumero;
       this.avion = v.avion;
       this.ciudadByCiudadDestino = new Ciudad(v.getCiudadByCiudadDestino());
       this.ciudadByCiudadOrigen = new Ciudad(v.getCiudadByCiudadOrigen());
       this.horario = v.horario;
       this.tiquetes = v.tiquetes;
    }
	
    public Vuelo(int pkNumero, Avion avion, Ciudad ciudadByCiudadDestino, Ciudad ciudadByCiudadOrigen, Horario horario) {
        this.pkNumero = pkNumero;
        this.avion = avion;
        this.ciudadByCiudadDestino = ciudadByCiudadDestino;
        this.ciudadByCiudadOrigen = ciudadByCiudadOrigen;
        this.horario = horario;
    }
    
    public Vuelo(int pkNumero, Avion avion, Ciudad ciudadByCiudadDestino, Ciudad ciudadByCiudadOrigen, Horario horario, Set<Tiquete> tiquetes) {
       this.pkNumero = pkNumero;
       this.avion = avion;
       this.ciudadByCiudadDestino = ciudadByCiudadDestino;
       this.ciudadByCiudadOrigen = ciudadByCiudadOrigen;
       this.horario = horario;
       this.tiquetes = tiquetes;
    }
   
    public int getPkNumero() {
        return this.pkNumero;
    }
    
    public void setPkNumero(int pkNumero) {
        this.pkNumero = pkNumero;
    }
    
    public Avion getAvion() {
        return this.avion;
    }
    
    public void setAvion(Avion avion) {
        this.avion = avion;
    }
    
    public Ciudad getCiudadByCiudadDestino() {
        return this.ciudadByCiudadDestino;
    }
    
    public void setCiudadByCiudadDestino(Ciudad ciudadByCiudadDestino) {
        this.ciudadByCiudadDestino = ciudadByCiudadDestino;
    }
    
    public Ciudad getCiudadByCiudadOrigen() {
        return this.ciudadByCiudadOrigen;
    }
    
    public void setCiudadByCiudadOrigen(Ciudad ciudadByCiudadOrigen) {
        this.ciudadByCiudadOrigen = ciudadByCiudadOrigen;
    }
    
    public Horario getHorario() {
        return this.horario;
    }
    
    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    
    public Set<Tiquete> getTiquetes() {
        return this.tiquetes;
    }
    
    public void setTiquetes(Set<Tiquete> tiquetes) {
        this.tiquetes = tiquetes;
    }
}