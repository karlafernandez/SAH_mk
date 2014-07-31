package pe.com.microdata.cjava.dataaccess.domain.hibernate.acceso;

import pe.com.microdata.cjava.dataaccess.base.hibernate.HibernateGenericDAO;
import pe.com.microdata.cjava.dataaccess.domain.acceso.AccesoDAO;
import pe.com.microdata.cjava.dataaccess.model.acceso.AccesoVO;
 

public class HibernateAccesoDAO extends HibernateGenericDAO<AccesoVO, Integer>
        implements AccesoDAO {

    public HibernateAccesoDAO() {
        super(AccesoVO.class);
    }
 

}
