/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.dataaccess.domain.hibernate.operacion.operacion;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import pe.com.microdata.cjava.dataaccess.base.hibernate.HibernateGenericDAO;
import pe.com.microdata.cjava.dataaccess.domain.operacion.operacion.FrecuenciaDiaDAO;
import pe.com.microdata.cjava.dataaccess.model.operacion.alquilado.FrecuenciaDiaVO;


public class HibernateFrecuenciaDiaDAO extends HibernateGenericDAO<FrecuenciaDiaVO, Integer> implements FrecuenciaDiaDAO{

    public HibernateFrecuenciaDiaDAO() {
        super(FrecuenciaDiaVO.class);
    }
       
    @Override
    public FrecuenciaDiaVO obtenerFrecuenciaPorIdOperacion(Integer idOperacion) {
        FrecuenciaDiaVO vo = null;
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(FrecuenciaDiaVO.class);
        detachedCriteria.add(Restrictions.eq("idOperacion", idOperacion));
        List<FrecuenciaDiaVO> listVO = listByCriteria(detachedCriteria);
        if(!listVO.isEmpty())
            vo = listVO.get(0);
        return vo;        
    }
    
    
}
