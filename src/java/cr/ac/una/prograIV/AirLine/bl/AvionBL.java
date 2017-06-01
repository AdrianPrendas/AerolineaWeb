package cr.ac.una.prograIV.AirLine.bl;

import cr.ac.una.prograIV.AirLine.domain.Avion;
import java.util.List;

public class AvionBL extends BaseBL implements IBaseBL<Avion, String> {
    public AvionBL() {
        super();
    }
    
    @Override
    public void save(Avion o) {
        this.getDao(o.getClass().getName()).save(o);
    }

    @Override
    public Avion merge(Avion o) {
        return (Avion) this.getDao(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Avion o) {
        this.getDao(o.getClass().getName()).delete(o);
    }

    @Override
    public Avion findById(String o) {
        return (Avion) this.getDao(o.getClass().getName()).findById(o);
    }

    @Override
    public List<Avion> findAll(String className) {
        return this.getDao(className).findAll();
    }    
}
