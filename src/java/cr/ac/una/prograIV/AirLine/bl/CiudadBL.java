/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.AirLine.bl;

import cr.ac.una.prograIV.AirLine.domain.Ciudad;
import java.util.List;

/**
 *
 * @author chgari
 */
public class CiudadBL extends BaseBL implements IBaseBL<Ciudad, String>{
     public CiudadBL() {
        super();
    }
    
    @Override
    public void save(Ciudad o) {
        this.getDao(o.getClass().getName()).save(o);
    }

    @Override
    public Ciudad merge(Ciudad o) {
        return (Ciudad) this.getDao(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Ciudad o) {
        this.getDao(o.getClass().getName()).delete(o);
    }

    @Override
    public Ciudad findById(String o) {
        return (Ciudad) this.getDao(o.getClass().getName()).findById(o);
    }

    @Override
    public List<Ciudad> findAll(String className) {
        return this.getDao(className).findAll();
    }
    
}
