package cr.ac.una.prograIV.AirLine.dao;

import cr.ac.una.prograIV.AirLine.domain.Avion;
import cr.ac.una.prograIV.AirLine.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

public class AvionDAO extends HibernateUtil implements IBaseDAO<Avion, Integer> {
        
    @Override
    public void save(Avion o) {
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
    public Avion merge(Avion o) {
        try {
            iniciaOperacion();
            o = (Avion) getSession().merge(o);
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
    public void delete(Avion o) {
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
    public Avion findById(Integer id) {
        Avion avion = null;
        try {
            iniciaOperacion();
            avion = (Avion) getSession().get(Avion.class, id);
        } finally {
            getSession().close();
        }
        return avion;
    }

    @Override
    public List<Avion> findAll() {
        List<Avion> listaAviones;
        try {
            iniciaOperacion();
            listaAviones = getSession().createQuery("from Avion").list();
        } finally {
            getSession().close();
        }

        return listaAviones;
    }    
}