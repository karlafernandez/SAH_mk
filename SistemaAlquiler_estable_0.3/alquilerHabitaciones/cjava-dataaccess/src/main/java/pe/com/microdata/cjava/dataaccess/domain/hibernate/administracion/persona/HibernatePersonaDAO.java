package pe.com.microdata.cjava.dataaccess.domain.hibernate.administracion.persona;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.common.base.CondicionDTO;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.common.base.ReglaDTO;
import pe.com.microdata.cjava.common.validador.Validador;
import pe.com.microdata.cjava.dataaccess.base.hibernate.HibernateGenericDAO;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.PersonaDAO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.PersonaVO;
import pe.com.microdata.cjava.dataaccess.util.GeneradorRestricciones;


/**
 * Implementación de la clase UsuarioDAO.
 *
 * @author meliMeli
 */
public class HibernatePersonaDAO extends HibernateGenericDAO<PersonaVO, Integer>
        implements PersonaDAO {

    
    private HashMap<String, ReglaDTO> eq;    
    private HashMap<String, ReglaDTO> eqNew;
    
    public HibernatePersonaDAO() {
        super(PersonaVO.class);
        eq = new HashMap<String, ReglaDTO>();        
        eqNew = new HashMap<String, ReglaDTO>();        
        //  eq.put("nomRepresentante", new ReglaDTO(Constants.OPE_LIKE, Constants.TYPE_STRING, "nomRepresentante"));
        // eq.put("ubigeo", new ReglaDTO(Constants.OPE_LIKE_INICIO, Constants.TYPE_STRING, "ubigeosAsignados.representanteUbigeoId.ubigeo"));              
        eqNew.put("buscarNombre", new ReglaDTO(Constants.OPE_LIKE, Constants.TYPE_STRING, Constants.LOG_OR, new String[]{"primerApellidoPer", "segundoApellidoPer", "nomPersona"}));
        eqNew.put("buscarUser", new ReglaDTO(Constants.OPE_LIKE, Constants.TYPE_STRING, "usuarioPersona"));
    }

    @Override
    public PersonaVO obtenerUsuarioPorNombreUsuario(String nomUsuario) {
        PersonaVO usuario = null;
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PersonaVO.class);
        detachedCriteria.createAlias("tipoUserVO", "tipoUserVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("accesoVOs", "accesoVOs", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("usuarioPersona", nomUsuario));
        List usuarios = listByCriteria(detachedCriteria);
        if (!usuarios.isEmpty()) {
            usuario = (PersonaVO) usuarios.get(0);
        }
        return usuario;
    }

    @Override
    public PersonaVO obtenerPersonaPorIdPersona(Integer idPersona) {
        PersonaVO usuario = null;
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PersonaVO.class);
        detachedCriteria.createAlias("tipoUserVO", "tipoUserVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idDocumentoVO", "idDocumentoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("ubigeoVO", "ubigeoVO", DetachedCriteria.LEFT_JOIN);        
        detachedCriteria.add(Restrictions.eq("idPersona", idPersona));        
        List usuarios = listByCriteria(detachedCriteria);
        if (!usuarios.isEmpty()) {
            usuario = (PersonaVO) usuarios.get(0);
        }
        return usuario;
    }

    @Override
    public List<PersonaVO> obtenerPersonasPorNombre(String[] arrNombres) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PersonaVO.class);

        for (int i = 0; i < arrNombres.length; i++) {
            String nombre = arrNombres[i];
            detachedCriteria.add(Restrictions.disjunction().add(Restrictions.ilike("nombre", "%" + nombre + "%")).add(Restrictions.ilike("apePaterno", "%" + nombre + "%")).add(Restrictions.ilike("apeMaterno", "%" + nombre + "%")));
        }

        List<PersonaVO> usuarios = listByCriteria(detachedCriteria);
        return usuarios;
    }

    @Override
    public List<PersonaVO> obtenerPersonasPorBusqueda(BusquedaDTO busquedaDTO) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PersonaVO.class);

        detachedCriteria.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);

        //  detachedCriteria.addOrder(Order.desc("primerApellidoPer"));
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
        List<PersonaVO> listadoVOs;
        if (busquedaDTO.getInicio() > 0 && busquedaDTO.getCantidad() > 0) {
            listadoVOs = listByCriteria(detachedCriteria, ((busquedaDTO.getInicio() - 1) * busquedaDTO.getCantidad()), busquedaDTO.getCantidad());
        } else {
            listadoVOs = listByCriteria(detachedCriteria);
        }
        return listadoVOs;
    }

    @Override
    public PersonaVO obtenerPersonaPorId(Integer idUsuario) {
        PersonaVO usuario = null;
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PersonaVO.class);
        detachedCriteria.createAlias("accesoVOs", "accesoVOs", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("idPersona", idUsuario));
        List usuarios = listByCriteria(detachedCriteria);
        if (!usuarios.isEmpty()) {
            usuario = (PersonaVO) usuarios.get(0);
        }
        return usuario;
    }

    @Override
    public List<PersonaVO> obtenerListaUsurioPorBusquedaYTipo(BusquedaDTO busquedaDTO, Integer idTipo) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PersonaVO.class);
        detachedCriteria.createAlias("tipoUserVO", "tipoUserVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("tipoUserVO.idSubTipo", idTipo));
        detachedCriteria.add(Restrictions.eq("estEliminado", Constants.USUARIO_ESTADO_NO_ELIMINADO));
        detachedCriteria.addOrder(Order.asc("primerApellidoPer"));
        detachedCriteria.addOrder(Order.asc("segundoApellidoPer"));
        detachedCriteria.addOrder(Order.asc("nomPersona"));        
        Criterion c;
        ReglaDTO reglaDTO;
        if (busquedaDTO != null && busquedaDTO.getCondiciones() != null) {
            for (CondicionDTO regla : busquedaDTO.getCondiciones()) {
                if (Validador.noNuloNoVacio(regla.getData())) {
                    if (eqNew.containsKey(regla.getField())) {
                        reglaDTO = eqNew.get(regla.getField());
                        reglaDTO.setData(regla.getData());
                        c = GeneradorRestricciones.generar(reglaDTO);                                                       
                        if (c != null) {
                            detachedCriteria.add(c);
                        }
                    }
                }
            }
        }
        List<PersonaVO> listadoVOs;
        if (busquedaDTO.getInicio() > 0 && busquedaDTO.getCantidad() > 0) {
            listadoVOs = listByCriteria(detachedCriteria, ((busquedaDTO.getInicio() - 1) * busquedaDTO.getCantidad()), busquedaDTO.getCantidad());
        } else {
            listadoVOs = listByCriteria(detachedCriteria);
        }
        return listadoVOs;
    }

    @Override
    public Long obtenerTotalUsurioPorBusquedaYTipo(BusquedaDTO busquedaDTO, Integer idTipo) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PersonaVO.class);
        detachedCriteria.createAlias("tipoUserVO", "tipoUserVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("tipoUserVO.idSubTipo", idTipo));
        detachedCriteria.add(Restrictions.eq("estEliminado", Constants.USUARIO_ESTADO_NO_ELIMINADO));
        detachedCriteria.addOrder(Order.asc("primerApellidoPer"));
        detachedCriteria.addOrder(Order.asc("segundoApellidoPer"));
        detachedCriteria.addOrder(Order.asc("nomPersona"));
        detachedCriteria.setProjection(Projections.rowCount());
        Criterion c;
        ReglaDTO reglaDTO;
        if (busquedaDTO != null && busquedaDTO.getCondiciones() != null) {
            for (CondicionDTO regla : busquedaDTO.getCondiciones()) {
                if (Validador.noNuloNoVacio(regla.getData())) {
                    if (eqNew.containsKey(regla.getField())) {
                        reglaDTO = eqNew.get(regla.getField());
                        reglaDTO.setData(regla.getData());
                        c = GeneradorRestricciones.generar(reglaDTO);                                                       
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
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PersonaVO.class);        
        detachedCriteria.add(Restrictions.eq("usuarioPersona", usuario));
        List<PersonaVO> usuarios = listByCriteria(detachedCriteria);
        return !usuarios.isEmpty();
    }

    @Override
    public List<PersonaVO> obtenerListaCumpleanio(Integer month) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PersonaVO.class);
        detachedCriteria.createAlias("tipoUserVO", "tipoUserVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("estEliminado", Constants.USUARIO_ESTADO_NO_ELIMINADO));
        detachedCriteria.add(Restrictions.eq("numeroMes", month));
        detachedCriteria.addOrder(Order.asc("numeroDia"));
        List<PersonaVO> lista = listByCriteria(detachedCriteria);
        return lista;
    }

       
}
