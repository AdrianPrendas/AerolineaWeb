package cr.ac.una.prograIV.AirLine.domain;

/**
 *
 * @author Josue
 */
public class Ciudad implements Jsonable{
    String sigla;
    String nombre;
    String pais;
    
    public Ciudad(String sigla, String nombre, String pais){
        this.sigla=sigla;
        this.nombre=nombre;
        this.pais=pais;
    }
    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    public String toString(){
        return this.sigla+" "+this.nombre+" "+this.pais;
    }
}
