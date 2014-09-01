package pe.com.microdata.cjava.dataaccess.domain.hibernate.administracion.persona;

import java.util.ArrayList;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import pe.com.microdata.cjava.dataaccess.base.hibernate.HibernateGenericDAO;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.ClienteDAO;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.common.base.CondicionDTO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.ClienteVO;
import pe.com.microdata.cjava.common.base.ReglaDTO;
import pe.com.microdata.cjava.common.validador.Validador;

import java.util.HashMap;
import java.util.List;
import org.hibernate.criterion.Projections;
import pe.com.microdata.cjava.common.base.Constants;

import pe.com.microdata.cjava.dataaccess.util.GeneradorRestricciones;

public class HibernateClienteDAO extends HibernateGenericDAO<ClienteVO, Integer>
        implements ClienteDAO {

    HashMap<String, ReglaDTO> eq;

    public HibernateClienteDAO() {
        super(ClienteVO.class);
        eq = new HashMap<String, ReglaDTO>();
//        eq.put("numDocumento", new ReglaDTO(Constants.OPE_LIKE, Constants.TYPE_STRING, "alumnoPersonaVO.documentoPer"));
//        eq.put("nomAlumno", new ReglaDTO(Constants.OPE_LIKE, Constants.TYPE_STRING, "alumnoPersonaVO.nomPersona"));
//        eq.put("primerApe", new ReglaDTO(Constants.OPE_LIKE, Constants.TYPE_STRING, "alumnoPersonaVO.primerApellidoPer"));
//        eq.put("segundoApe", new ReglaDTO(Constants.OPE_LIKE, Constants.TYPE_STRING, "alumnoPersonaVO.segundoApellidoPer"));
//        eq.put("buscarNombre", new ReglaDTO(Constants.OPE_LIKE, Constants.TYPE_STRING, Constants.LOG_OR, new String[]{"alumnoPersonaVO.primerApellidoPer", "alumnoPersonaVO.segundoApellidoPer", "alumnoPersonaVO.nomPersona"}));
//        eq.put("buscarNroDoc", new ReglaDTO(Constants.OPE_LIKE, Constants.TYPE_STRING, "alumnoPersonaVO.documentoPer"));

    }

    @Override
    public ClienteVO obtenerClientePorNombreUsuario(String nomPersona) {
        ClienteVO usuario = null;
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ClienteVO.class);
        detachedCriteria.add(Restrictions.eq("nomPersona", nomPersona));
        List usuarios = listByCriteria(detachedCriteria);
        if (!usuarios.isEmpty()) {
            usuario = (ClienteVO) usuarios.get(0);
        }
        return usuario;
    }

    @Override
    public ClienteVO obtenerClientePorIdCliente(Integer idAlumno) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ClienteVO.class);
        ClienteVO alumnoVO = null;
        detachedCriteria.createAlias("alumnoPersonaVO", "alumnoPersonaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("centroEducativo", "centroEducativo", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("nivelEstudio", "nivelEstudio", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("ocupacion", "ocupacion", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("alumnoPersonaVO.idDocumentoVO", "idDocumentoVO", DetachedCriteria.INNER_JOIN);
        detachedCriteria.createAlias("alumnoPersonaVO.ubigeoVO", "ubigeoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);
        detachedCriteria.add(Restrictions.eq("idAlumno", idAlumno));
        List<ClienteVO> alumnoVOs = new ArrayList<ClienteVO>();
        alumnoVOs = listByCriteria(detachedCriteria);
        if (!alumnoVOs.isEmpty()) {
            alumnoVO = alumnoVOs.get(0);
        }
        return alumnoVO;
    }

    @Override
    public List obtenerClientePorIdClienteLista(Integer idAlumno) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ClienteVO.class);
        detachedCriteria.add(Restrictions.eq("idAlumno", idAlumno));
        List<ClienteVO> usuarios = listByCriteria(detachedCriteria);
        return usuarios;
    }

    @Override
    public List<ClienteVO> obtenerClientesPorBusqueda(BusquedaDTO busquedaDTO) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ClienteVO.class);
        detachedCriteria.createAlias("alumnoPersonaVO", "alumnoPersonaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("alumnoPersonaVO.idDocumentoVO", "idDocumentoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("centroEducativo", "centroEducativo", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("nivelEstudio", "nivelEstudio", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("ocupacion", "ocupacion", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("alumnoPersonaVO.ubigeoVO", "ubigeoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);
        List<ClienteVO> list = new ArrayList<ClienteVO>();
        Criterion c;
        ReglaDTO reglasDTO;
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
        if (busquedaDTO.getInicio() > 0 && busquedaDTO.getCantidad() > 0) {
            list = listByCriteria(detachedCriteria, ((busquedaDTO.getInicio() - 1) * busquedaDTO.getCantidad()), busquedaDTO.getCantidad());
        } else {
            list = listByCriteria(detachedCriteria);
        }
        return list;
    }

    @Override
    public Long obtenerTotalClientesPorBusqueda(BusquedaDTO busquedaDTO) {//////////////CORREGIR///////////////////
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ClienteVO.class);
        detachedCriteria.createAlias("alumnoPersonaVO", "alumnoPersonaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("alumnoPersonaVO.idDocumentoVO", "idDocumentoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("centroEducativo", "centroEducativo", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("nivelEstudio", "nivelEstudio", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("ocupacion", "ocupacion", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("alumnoPersonaVO.ubigeoVO", "ubigeoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);
        detachedCriteria.setProjection(Projections.rowCount());
        Criterion c;
        ReglaDTO reglasDTO;
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
    public Boolean existeUsuario(String usuario) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ClienteVO.class);
        detachedCriteria.createAlias("alumnoPersonaVO", "alumnoPersonaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("alumnoPersonaVO.usuarioPersona", usuario));
        List<ClienteVO> usuarios = listByCriteria(detachedCriteria);
        return !usuarios.isEmpty();
    }

    @Override
    public List obtenerTotalClientes() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ClienteVO.class);
        detachedCriteria.createAlias("alumnoPersonaVO", "alumnoPersonaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);
        List<ClienteVO> usuarios = listByCriteria(detachedCriteria);
        return usuarios;
    }

    @Override
    public List obtenerNombreDNIClientesPorBusqueda(String strBusqueda) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ClienteVO.class);
        detachedCriteria.createAlias("alumnoPersonaVO", "alumnoPersonaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.conjunction().add(Restrictions.or(
                Restrictions.ilike("alumnoPersonaVO.nomPersona", "%" + strBusqueda + "%"),
                Restrictions.or(Restrictions.ilike("alumnoPersonaVO.primerApellidoPer", "%" + strBusqueda + "%"),
                Restrictions.ilike("alumnoPersonaVO.segundoApellidoPer", "%" + strBusqueda + "%")))));
        List<ClienteVO> lstAlumno = listByCriteria(detachedCriteria);
        return lstAlumno;
    }

    @Override
    public List obtenerClientesConCursoPorBusqueda(BusquedaDTO busquedaDTO) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ClienteVO.class);
        detachedCriteria.createAlias("alumnoPersonaVO", "personaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("personaVO.idDocumentoVO", "documentoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("lstOperacionAlumnoDevVOs", "operacionAlumnoDevVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("operacionAlumnoDevVO.operacionAlumnoVO", "operacionDevVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("operacionDevVO.curEspVO", "curEspVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("operacionDevVO.estadoVO", "estadoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);
        Criterion c;
        ReglaDTO reglasDTO;
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
        List<ClienteVO> list = listByCriteria(detachedCriteria);
        return list;
    }

    @Override
    public Long obtenerTotalClientesConCursoPorBusqueda(BusquedaDTO busquedaDTO) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ClienteVO.class);
        detachedCriteria.createAlias("lstOperacionAlumnoDevVOs", "operacionAlumnoDevVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("operacionAlumnoDevVO.operacionAlumnoVO", "operacionDevVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("alumnoPersonaVO", "personaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("operacionDevVO.curEspVO", "curEspVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("operacionDevVO.estadoVO", "estadoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);
        detachedCriteria.setProjection(Projections.rowCount());
        Criterion c;
        ReglaDTO reglasDTO;
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
    
}
