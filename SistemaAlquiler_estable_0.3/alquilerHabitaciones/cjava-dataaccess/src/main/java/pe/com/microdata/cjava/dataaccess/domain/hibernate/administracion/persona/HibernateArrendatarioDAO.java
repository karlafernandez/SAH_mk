package pe.com.microdata.cjava.dataaccess.domain.hibernate.administracion.persona;

import java.util.ArrayList;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import pe.com.microdata.cjava.dataaccess.base.hibernate.HibernateGenericDAO;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.ArrendatarioDAO;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.common.base.CondicionDTO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.ArrendatarioVO;
import pe.com.microdata.cjava.common.base.ReglaDTO;
import pe.com.microdata.cjava.common.validador.Validador;
import java.util.HashMap;
import java.util.List;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import pe.com.microdata.cjava.common.base.Constants;

import pe.com.microdata.cjava.dataaccess.util.GeneradorRestricciones;

/**
 * Implementación de la clase UsuarioDAO.
 *
 * @author meliMeli
 */
public class HibernateArrendatarioDAO extends HibernateGenericDAO<ArrendatarioVO, Integer>
        implements ArrendatarioDAO {
 
    HashMap<String, ReglaDTO> eq;

    public HibernateArrendatarioDAO() {
        super(ArrendatarioVO.class);
        eq = new HashMap<String, ReglaDTO>();
    //    eq.put("buscarNombre", new ReglaDTO(Constants.OPE_LIKE, Constants.TYPE_STRING, Constants.LOG_OR, "instructorPersonaVO.nomPersona", "instructorPersonaVO.primerApellidoPer", "instructorPersonaVO.segundoApellidoPer"));
    //  eq.put("buscarNroDoc", new ReglaDTO(Constants.OPE_LIKE, Constants.TYPE_STRING, "instructorPersonaVO.documentoPer"));

    }

    @Override
    public ArrendatarioVO obtenerArrendatarioPorIdArrendatario(Integer idArrendatario) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ArrendatarioVO.class);
        ArrendatarioVO instructorVO = null;
        detachedCriteria.createAlias("arrendatarioPersonaVO", "arrendatarioPersonaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("arrendatarioPersonaVO.idDocumentoVO", "idDocumentoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("arrendatarioPersonaVO.ubigeoVO", "ubigeoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);

        detachedCriteria.add(Restrictions.eq("idArrendatario", idArrendatario));
        List<ArrendatarioVO> instructorVOs = new ArrayList<ArrendatarioVO>();
        instructorVOs = listByCriteria(detachedCriteria);
        if (!instructorVOs.isEmpty()) {
            instructorVO = instructorVOs.get(0);
        }
        return instructorVO;
    }
    /*
    
    @Override
    public ArrendatarioVO obtenerInstructorPorNombreUsuario(String nomPersona) {
        ArrendatarioVO usuario = null;
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ArrendatarioVO.class);
        detachedCriteria.add(Restrictions.eq("nomPersona", nomPersona));
        List usuarios = listByCriteria(detachedCriteria);
        if (!usuarios.isEmpty()) {
            usuario = (ArrendatarioVO) usuarios.get(0);
        }
        return usuario;
    }

   

    @Override
    public List obtenerInstructorPorIdInstructorLista(Integer idArrendatario) {

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ArrendatarioVO.class);
        detachedCriteria.add(Restrictions.eq("idArrendatario", idArrendatario));
        List<ArrendatarioVO> usuarios = listByCriteria(detachedCriteria);
        return usuarios;
    }

   
    
        @Override
    public Boolean existeUsuario(String usuario) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ArrendatarioVO.class);
        detachedCriteria.createAlias("arrendatarioPersonaVO", "arrendatarioPersonaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("arrendatarioPersonaVO.usuarioPersona", usuario));
        List<ArrendatarioVO> usuarios = listByCriteria(detachedCriteria);
        return !usuarios.isEmpty();
    }
    
        
       
        
     @Override
    public List obtenerNombreDniInstructorPorBusqueda(String strBusqueda) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ArrendatarioVO.class);
        detachedCriteria.createAlias("arrendatarioPersonaVO", "arrendatarioPersonaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.conjunction().add(Restrictions.or(
                Restrictions.ilike("arrendatarioPersonaVO.nomPersona", "%" + strBusqueda + "%"),
                Restrictions.or(Restrictions.ilike("arrendatarioPersonaVO.primerApellidoPer", "%" + strBusqueda + "%"),
                Restrictions.ilike("arrendatarioPersonaVO.segundoApellidoPer", "%" + strBusqueda + "%")))));
                     
        List<ArrendatarioVO> lstInstructor = new ArrayList();
        lstInstructor = listByCriteria(detachedCriteria);
        return lstInstructor;
    }

    @Override
    public ArrendatarioVO obtenerInstructorPorIdPersona(Integer idPersona) {
        ArrendatarioVO vo = new ArrendatarioVO();
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ArrendatarioVO.class);
        detachedCriteria.createAlias("arrendatarioPersonaVO", "arrendatarioPersonaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("arrendatarioPersonaVO.idPersona", idPersona));
        List<ArrendatarioVO> listInstruc = listByCriteria(detachedCriteria);
        if(!listInstruc.isEmpty())
            vo = listInstruc.get(0);
        return vo;
    }
        */ 
    @Override
    public Long obtenerTotalArrendatariosPorBusqueda(BusquedaDTO busquedaDTO) {//////////////CORREGIR///////////////////
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ArrendatarioVO.class);
        detachedCriteria.createAlias("arrendatarioPersonaVO", "arrendatarioPersonaVO", DetachedCriteria.LEFT_JOIN);
     //   detachedCriteria.createAlias("arrendatarioPersonaVO.idDocumentoVO", "idDocumentoVO", DetachedCriteria.LEFT_JOIN);
     //   detachedCriteria.createAlias("arrendatarioPersonaVO.ubigeoVO", "ubigeoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);
        ProjectionList projList = Projections.projectionList();
        projList.add(Projections.countDistinct(("idArrendatario")));
        detachedCriteria.setProjection(projList); // conteo las filas  
        ReglaDTO reglasDTO;
        Criterion c;
        if (busquedaDTO != null && busquedaDTO.getCondiciones() != null) {
            for (CondicionDTO regla : busquedaDTO.getCondiciones()) {
                if (Validador.noNuloNoVacio(regla.getData())) {
                    if (eq.containsKey(regla.getField())) {
                        reglasDTO = eq.get(regla.getField());
                        reglasDTO.setData(regla.getData());
                        c = GeneradorRestricciones.generar(reglasDTO);
                        if (c != null) {
                            detachedCriteria.add(c);
                        }
                    }
                }
            }
        }


        Long total = ((Long) getHibernateTemplate().findByCriteria(detachedCriteria).get(0)).longValue();
        return total;
    }
    
    
    
     @Override
    public List<ArrendatarioVO> obtenerArrendatarioPorBusqueda(BusquedaDTO busquedaDTO) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ArrendatarioVO.class);
        ReglaDTO reglasDTO;
        Criterion c;
        detachedCriteria.createAlias("arrendatarioPersonaVO", "arrendatarioPersonaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("arrendatarioPersonaVO.idDocumentoVO", "idDocumentoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("arrendatarioPersonaVO.ubigeoVO", "ubigeoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);


        // detachedCriteria.addOrder(Order.desc("primerApellidoPer"));


        if (busquedaDTO != null && busquedaDTO.getCondiciones() != null) {
            for (CondicionDTO regla : busquedaDTO.getCondiciones()) {
                if (Validador.noNuloNoVacio(regla.getData())) {
                    if (eq.containsKey(regla.getField())) {
                        reglasDTO = eq.get(regla.getField());
                        reglasDTO.setData(regla.getData());
                        c = GeneradorRestricciones.generar(reglasDTO);
                        if (c != null) {
                            detachedCriteria.add(c);
                        }
                    }
                }
            }
        }
        List<ArrendatarioVO> listadoVOs;
        if (busquedaDTO.getInicio() > 0 && busquedaDTO.getCantidad() > 0) {
            listadoVOs = listByCriteria(detachedCriteria, ((busquedaDTO.getInicio() - 1) * busquedaDTO.getCantidad()), busquedaDTO.getCantidad());
        } else {
            listadoVOs = listByCriteria(detachedCriteria);
        }
        return listadoVOs;
    }

}
