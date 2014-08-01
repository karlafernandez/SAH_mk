/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.dataaccess.domain.hibernate.administracion.persona;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import pe.com.microdata.cjava.dataaccess.base.hibernate.HibernateGenericDAO;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.UbigeoDAO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.UbigeoVO;


public class HibernateUbigeoDAO extends HibernateGenericDAO<UbigeoVO, Integer>
        implements UbigeoDAO {

    public HibernateUbigeoDAO() {
        super(UbigeoVO.class);

    }

    @Override
    public List obtenerPaises() {
        DetachedCriteria criteria = DetachedCriteria.forClass(UbigeoVO.class);
        criteria.add(Restrictions.like("idDepartamento", "00"));
        criteria.add(Restrictions.like("idProvincia", "00"));
        criteria.add(Restrictions.like("idDistrito", "00"));
        List resultados = listByCriteria(criteria);
        return resultados;

    }

    @Override
    public List obtenerDepartamentosPorPais(String codPais) {
        DetachedCriteria criteria = DetachedCriteria.forClass(UbigeoVO.class);
        criteria.add(Restrictions.like("idPais", codPais));
        criteria.add(Restrictions.not(Restrictions.like("idDepartamento", "00")));
        criteria.add(Restrictions.like("idProvincia", "00"));
        criteria.add(Restrictions.like("idDistrito", "00"));
        List resultados = listByCriteria(criteria);
        return resultados;
    }

    @Override
    public List obtenerProvinciasPorDepartamento(String codPais, String codDepartamento) {
        DetachedCriteria criteria = DetachedCriteria.forClass(UbigeoVO.class);
        criteria.add(Restrictions.like("idPais", codPais));
        criteria.add(Restrictions.like("idDepartamento", codDepartamento));
        criteria.add(Restrictions.not(Restrictions.like("idProvincia", "00")));
        criteria.add(Restrictions.like("idDistrito", "00"));
        List resultados = listByCriteria(criteria);
        return resultados;
    }

    @Override
    public List obtenerDistritoPorProvincia(String codPais, String codDepartamento, String codProvincia) {
        DetachedCriteria criteria = DetachedCriteria.forClass(UbigeoVO.class);
        criteria.add(Restrictions.like("idPais", codPais));
        criteria.add(Restrictions.like("idDepartamento", codDepartamento));
        criteria.add(Restrictions.like("idProvincia", codProvincia));
        criteria.add(Restrictions.not(Restrictions.like("idDistrito", "00")));
        List resultados = listByCriteria(criteria);
        return resultados;
    }
    
     @Override
    public UbigeoVO obtenerUbigeoPorCodigo(String codPais, String codDepartamento, String codProvincia, String codDistrito) {
        DetachedCriteria criteria = DetachedCriteria.forClass(UbigeoVO.class);
        criteria.add(Restrictions.like("idPais", codPais));
        criteria.add(Restrictions.like("idDepartamento", codDepartamento));
        criteria.add(Restrictions.like("idProvincia", codProvincia));
        criteria.add(Restrictions.like("idDistrito", codDistrito));
        
        List<UbigeoVO> resultados = listByCriteria(criteria);
        return resultados.get(0);
    }
        
   
    
    
    
    
    
    
}
