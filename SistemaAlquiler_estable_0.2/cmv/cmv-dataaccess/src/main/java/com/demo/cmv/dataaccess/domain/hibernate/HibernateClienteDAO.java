/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.cmv.dataaccess.domain.hibernate;

import com.demo.cmv.dataaccess.base.hibernate.HibernateGenericDAO;
import com.demo.cmv.dataaccess.domain.ClienteDAO;
import com.demo.cmv.dataaccess.model.ClienteVO;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author meliMeli
 */
public class HibernateClienteDAO extends HibernateGenericDAO<ClienteVO, Integer>
        implements ClienteDAO {

    public HibernateClienteDAO() {
        super(ClienteVO.class);
    }

     
    @Override
    //lista de pacientes con DNI
    public List<ClienteVO> obtenerClientesConDNI() {
         DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ClienteVO.class);
//        detachedCriteria.createAlias("tipDocumento", "documento", DetachedCriteria.INNER_JOIN);
//        detachedCriteria.add(Restrictions.eq("documento.idSubTipo", 1));
        
        List<ClienteVO> pacienteVOs = listByCriteria(detachedCriteria); 
//      detachedCriteria.add(Restrictions.or(Restrictions, Restrictions))
//      List<PacienteVO> pacienteVOs = listByCriteria(detachedCriteria,1,10); EL PRIMERO 10 RESULTADO
        return pacienteVOs;
    }
}
