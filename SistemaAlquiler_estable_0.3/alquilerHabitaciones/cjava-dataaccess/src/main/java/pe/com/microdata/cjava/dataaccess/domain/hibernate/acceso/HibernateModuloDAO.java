package pe.com.microdata.cjava.dataaccess.domain.hibernate.acceso;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import pe.com.microdata.cjava.dataaccess.base.hibernate.HibernateGenericDAO;
import pe.com.microdata.cjava.dataaccess.domain.acceso.AccesoModuloDAO;
import pe.com.microdata.cjava.dataaccess.model.acceso.AccesoModuloVO;

public class HibernateModuloDAO extends HibernateGenericDAO<AccesoModuloVO, Integer>
        implements AccesoModuloDAO {

    public HibernateModuloDAO() {
        super(AccesoModuloVO.class);
    }

    @Override
    public List<AccesoModuloVO> obtenerModulosAccesos() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AccesoModuloVO.class);
        detachedCriteria.createAlias("accesoGrupoVOs", "accesoGrupoVOs", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("accesoGrupoVOs.accesoVOs", "accesoVOs", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);
        return listByCriteria(detachedCriteria);
    }

}
