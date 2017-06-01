package cr.ac.una.prograIV.AirLine.domain;

import java.util.Date;

public class Compra  implements java.io.Serializable {


     private Integer pkNumero;
     private Tiquete tiquete;
     private Date fecha;
     private String tarjeta;
     private Date vencimiento;
     private int total;

    public Compra() {
    }

    public Compra(Tiquete tiquete, Date fecha, String tarjeta, Date vencimiento, int total) {
       this.tiquete = tiquete;
       this.fecha = fecha;
       this.tarjeta = tarjeta;
       this.vencimiento = vencimiento;
       this.total = total;
    }
   
    public Integer getPkNumero() {
        return this.pkNumero;
    }
    
    public void setPkNumero(Integer pkNumero) {
        this.pkNumero = pkNumero;
    }
    public Tiquete getTiquete() {
        return this.tiquete;
    }
    
    public void setTiquete(Tiquete tiquete) {
        this.tiquete = tiquete;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getTarjeta() {
        return this.tarjeta;
    }
    
    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }
    public Date getVencimiento() {
        return this.vencimiento;
    }
    
    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }
    public int getTotal() {
        return this.total;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }
}