/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.AirLine.bl;

import cr.ac.una.prograIV.AirLine.domain.Vuelo;
import java.util.List;

/**
 *
 * @author chgari
 */
public class VueloBL extends BaseBL implements IBaseBL<Vuelo, Integer>{
     public VueloBL() {
        super();
    }
    
    @Override
    public void save(Vuelo o) {
        this.getDao(o.getClass().getName()).save(o);
    }

    @Override
    public Vuelo merge(Vuelo o) {
        return (Vuelo) this.getDao(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Vuelo o) {
        this.getDao(o.getClass().getName()).delete(o);
    }

    @Override
    public Vuelo findById(Integer o) {
        return (Vuelo) this.getDao(o.getClass().getName()).findById(o);
    }

    @Override
    public List<Vuelo> findAll(String className) {
        return this.getDao(className).findAll();
    }
    
}
