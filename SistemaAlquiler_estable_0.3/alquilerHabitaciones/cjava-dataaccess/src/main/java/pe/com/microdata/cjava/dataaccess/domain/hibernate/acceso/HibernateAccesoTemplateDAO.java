/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.dataaccess.domain.hibernate.acceso;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import pe.com.microdata.cjava.dataaccess.base.hibernate.HibernateGenericDAO;
import pe.com.microdata.cjava.dataaccess.domain.acceso.AccesoTemplateDAO;
import pe.com.microdata.cjava.dataaccess.model.acceso.AccesoTemplateVO;

/**
 *
 * @author Alejandra Gonzales
 */
public class HibernateAccesoTemplateDAO extends HibernateGenericDAO<AccesoTemplateVO, Integer>
        implements AccesoTemplateDAO {

    public HibernateAccesoTemplateDAO() {
        super(AccesoTemplateVO.class);
    }

    @Override
    public AccesoTemplateVO obtenerAccesosPorTemplate(String nomTemplate) {
        AccesoTemplateVO accesoTemplateVO = null;
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AccesoTemplateVO.class);
        detachedCriteria.createAlias("accesoVOs", "accesoVOs", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.like("nombreTemplate", nomTemplate));
        detachedCriteria.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);
        List<AccesoTemplateVO> accesoTemplateVOs = listByCriteria(detachedCriteria);
        if (accesoTemplateVOs != null && !accesoTemplateVOs.isEmpty()) {
            accesoTemplateVO = accesoTemplateVOs.get(0);
        }
        return accesoTemplateVO;
    }
}
