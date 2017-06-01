package cr.ac.una.prograIV.AirLine.domain;

public class Asiento  implements java.io.Serializable {

    private String pkNumero;
    private Avion avion;
    private Tiquete tiquete;
    private String clase;

    public Asiento() {
    }
	
    public Asiento(String pkNumero, Avion avion, Tiquete tiquete) {
        this.pkNumero = pkNumero;
        this.avion = avion;
        this.tiquete = tiquete;
    }
    
    public Asiento(String pkNumero, Avion avion, Tiquete tiquete, String clase) {
       this.pkNumero = pkNumero;
       this.avion = avion;
       this.tiquete = tiquete;
       this.clase = clase;
    }
   
    public String getPkNumero() {
        return this.pkNumero;
    }
    
    public void setPkNumero(String pkNumero) {
        this.pkNumero = pkNumero;
    }
    
    public Avion getAvion() {
        return this.avion;
    }
    
    public void setAvion(Avion avion) {
        this.avion = avion;
    }
    
    public Tiquete getTiquete() {
        return this.tiquete;
    }
    
    public void setTiquete(Tiquete tiquete) {
        this.tiquete = tiquete;
    }
    
    public String getClase() {
        return this.clase;
    }
    
    public void setClase(String clase) {
        this.clase = clase;
    }
}