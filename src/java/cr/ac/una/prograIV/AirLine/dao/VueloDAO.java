/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.AirLine.dao;

import cr.ac.una.prograIV.AirLine.domain.Vuelo;
import cr.ac.una.prograIV.AirLine.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author chgari
 */
public class VueloDAO extends HibernateUtil implements IBaseDAO<Vuelo, Integer>{

    @Override
    public void save(Vuelo o) {
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
    public Vuelo merge(Vuelo o) {
        try {
            iniciaOperacion();
            o = (Vuelo) getSession().merge(o);
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
    public void delete(Vuelo o) {
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
    public Vuelo findById(Integer id) {
        Vuelo vuelo = null;

        try {
            iniciaOperacion();
            vuelo = (Vuelo) getSession().get(Vuelo.class, id);
        } finally {
            getSession().close();
        }
        return vuelo;
    }

    @Override
    public List<Vuelo> findAll() {
        List<Vuelo> listaVuelos;
        try {
            iniciaOperacion();
            listaVuelos = getSession().createQuery("from Vuelo").list();
        } finally {
            getSession().close();
        }

        return listaVuelos;
    }
    
}
