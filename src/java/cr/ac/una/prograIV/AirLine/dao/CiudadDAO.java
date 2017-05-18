/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.AirLine.dao;

import cr.ac.una.prograIV.AirLine.domain.Ciudad;
import cr.ac.una.prograIV.AirLine.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author chgari
 */
public class CiudadDAO extends HibernateUtil implements IBaseDAO<Ciudad, String>{

    @Override
    public void save(Ciudad o) {
           try {
            iniciaOperacion();
            getSession().save(o);
            getTransac().commit();
        } catch (HibernateException he) {
            manejaException(he);
            throw he;
        } finally {
            getSession().close();
        }
    }

    @Override
    public Ciudad merge(Ciudad o) {
        try {
            iniciaOperacion();
            o = (Ciudad) getSession().merge(o);
            getTransac().commit();
        } catch (HibernateException he) {
            manejaException(he);
            throw he;
        } finally {
            getSession().close();
        }
        return o;
    }

    @Override
    public void delete(Ciudad o) {
        try {
            iniciaOperacion();
            getSession().delete(o);
            getTransac().commit();
        } catch (HibernateException he) {
            manejaException(he);
            throw he;
        } finally {
            getSession().close();
        }
    }

    @Override
    public Ciudad findById(String id) {
        Ciudad ciudad = null;

        try {
            iniciaOperacion();
            ciudad = (Ciudad) getSession().get(Ciudad.class, id);
        } finally {
            getSession().close();
        }
        return ciudad;
    }

    @Override
    public List<Ciudad> findAll() {
        List<Ciudad> listaCiudades;
        try {
            iniciaOperacion();
            listaCiudades = getSession().createQuery("from Ciudad").list();
        } finally {
            getSession().close();
        }

        return listaCiudades;
    }
    
}
