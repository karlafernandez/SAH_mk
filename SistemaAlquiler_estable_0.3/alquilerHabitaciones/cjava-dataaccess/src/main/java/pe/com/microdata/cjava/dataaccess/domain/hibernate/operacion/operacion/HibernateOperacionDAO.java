package pe.com.microdata.cjava.dataaccess.domain.hibernate.operacion.operacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.common.base.CondicionDTO;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.common.base.ReglaDTO;
import pe.com.microdata.cjava.common.validador.Validador;
import pe.com.microdata.cjava.dataaccess.base.hibernate.HibernateGenericDAO;
import pe.com.microdata.cjava.dataaccess.domain.operacion.operacion.OperacionDAO;
import pe.com.microdata.cjava.dataaccess.model.operacion.alquilado.AlquilarVO;
import pe.com.microdata.cjava.dataaccess.util.GeneradorRestricciones;

/**
 * Implementación de la clase UsuarioDAO.
 *
 * @author meliMeli
 */
public class HibernateOperacionDAO extends HibernateGenericDAO<AlquilarVO, Integer>
        implements OperacionDAO {

    HashMap<String, ReglaDTO> eq;

    private Logger logger = Logger.getLogger(HibernateOperacionDAO.class);
    
    public HibernateOperacionDAO() {
        super(AlquilarVO.class);
        eq = new HashMap<String, ReglaDTO>();
    //    eq.put("buscarNomCurAct", new ReglaDTO(Constants.OPE_LIKE, Constants.TYPE_STRING, "idCursoEspVO.nomCursoEspecifico"));
      //  eq.put("buscarNomenCurAct", new ReglaDTO(Constants.OPE_LIKE_INICIO, Constants.TYPE_STRING, "idCursoEspVO.nomenCursoEspecifico"));
     //   eq.put("estadoOperacion", new ReglaDTO(Constants.OPE_EQ, Constants.TYPE_INTEGER, "idEstadoVO.idSubTipo"));
    }

    @Override
    public AlquilarVO obtenerCursosActivosPorIdOperacion(Integer idOperacion) {
        List<AlquilarVO> listaOperacion = new ArrayList<AlquilarVO>();
        AlquilarVO operacionVO = new AlquilarVO();
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AlquilarVO.class);
        detachedCriteria.createAlias("idCursoEspVO", "idCursoEspVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("calificacionVO", "calificacionVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idEmpresaVO", "idEmpresaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idCursoGralPlantillaVO", "idCursoGralPlantillaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idTurnoVO", "idTurnoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idEstadoVO", "idEstadoVO", DetachedCriteria.LEFT_JOIN);

        detachedCriteria.add(Restrictions.eq("idOperacion", idOperacion));
        listaOperacion = listByCriteria(detachedCriteria);
        if (!listaOperacion.isEmpty()) {
            operacionVO = listaOperacion.get(0);
        }
        return operacionVO;
    }

    @Override
    public AlquilarVO obtenerEstadoPorIdOperacion(Integer idOperacion) {
        List<AlquilarVO> listaOperacion = new ArrayList<AlquilarVO>();
        AlquilarVO operacionVO = new AlquilarVO();
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AlquilarVO.class);
        detachedCriteria.createAlias("idCursoEspVO", "idCursoEspVO", DetachedCriteria.LEFT_JOIN);
        //detachedCriteria.createAlias("calificacionVO", "calificacionVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idEstadoVO", "idEstadoVO", DetachedCriteria.LEFT_JOIN);

        detachedCriteria.add(Restrictions.eq("idOperacion", idOperacion));
        listaOperacion = listByCriteria(detachedCriteria);
        if (!listaOperacion.isEmpty()) {
            operacionVO = listaOperacion.get(0);
        }
        return operacionVO;
    }

    @Override
    public List obtenerOperacionPorIdOperacionLista(Integer idOperacion) {

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AlquilarVO.class);
        detachedCriteria.add(Restrictions.eq("idOperacion", idOperacion));
        List<AlquilarVO> usuarios = listByCriteria(detachedCriteria);
        return usuarios;
    }

    @Override
    public AlquilarVO obtenerOperacionPorIdOperacion(Integer idOperacion) {
        List<AlquilarVO> listaOperacion = new ArrayList<AlquilarVO>();
        AlquilarVO operacionVO = new AlquilarVO();
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AlquilarVO.class);
        detachedCriteria.add(Restrictions.eq("idOperacion", idOperacion));
        listaOperacion = listByCriteria(detachedCriteria);
        if (!listaOperacion.isEmpty()) {
            operacionVO = listaOperacion.get(0);
        }
        return operacionVO;
    }

    @Override
    public List<AlquilarVO> obtenerCursosActivosPorBusqueda(BusquedaDTO busquedaDTO) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AlquilarVO.class);
        detachedCriteria.createAlias("idCursoEspVO", "idCursoEspVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("calificacionVO", "calificacionVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idEmpresaVO", "idEmpresaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idCursoGralPlantillaVO", "idCursoGralPlantillaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idTurnoVO", "idTurnoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idEstadoVO", "idEstadoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("activaOperacion", Constants.OPERACION_NO_BORRADA));

        detachedCriteria.addOrder(Order.desc("fechaInicioOp"));

        List<AlquilarVO> list = new ArrayList<AlquilarVO>();
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
    public Long obtenerTotalOperacionesAlumnosPorBusqueda(BusquedaDTO busquedaDTO) {//////////////CORREGIR///////////////////
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AlquilarVO.class);
        detachedCriteria.createAlias("idCursoEspVO", "idCursoEspVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("calificacionVO", "calificacionVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idEmpresaVO", "idEmpresaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idCursoGralPlantillaVO", "idCursoGralPlantillaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idTurnoVO", "idTurnoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idEstadoVO", "idEstadoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("activaOperacion", Constants.OPERACION_NO_BORRADA));

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
    public AlquilarVO obtenerOperacionConAlumnosPorIdOperacion(Integer idOpe) {
        List<AlquilarVO> listaOperacion = new ArrayList<AlquilarVO>();
        AlquilarVO operacionDevVO = new AlquilarVO();
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AlquilarVO.class);
        detachedCriteria.createAlias("idCursoEspVO", "idCursoEspVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("listaAlumnoVO", "listaAlumnoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("listaAlumnoVO.alumnoVO", "alumnoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("alumnoVO.alumnoPersonaVO", "alumnoPersonaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idEstadoVO", "idEstadoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("idOperacion", idOpe));
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.primerApellidoPer"));
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.segundoApellidoPer"));
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.nomPersona"));
        detachedCriteria.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);
        listaOperacion = listByCriteria(detachedCriteria);
        if (!listaOperacion.isEmpty()) {
            operacionDevVO = listaOperacion.get(0);
        }
        return operacionDevVO;
    }

    @Override
    public List obtenerAlumnosPorIdOperacion(Integer idOpe) {
        List<AlquilarVO> listaOperacion = new ArrayList<AlquilarVO>();
        AlquilarVO operacionDevVO = new AlquilarVO();
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AlquilarVO.class);
        detachedCriteria.createAlias("listaAlumnoVO", "listaAlumnoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("listaAlumnoVO.alumnoVO", "alumnoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("alumnoVO.alumnoPersonaVO", "alumnoPersonaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("idOperacion", idOpe));
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.primerApellidoPer"));
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.segundoApellidoPer"));
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.nomPersona"));
        listaOperacion = listByCriteria(detachedCriteria);
        if (!listaOperacion.isEmpty()) {
            operacionDevVO = listaOperacion.get(0);
        }
        return listaOperacion;
    }

    @Override
    public AlquilarVO obtenerOperacionConInstructoresPorIdOperacion(Integer idOpe) {
        List<AlquilarVO> listaOperacion = new ArrayList<AlquilarVO>();
        AlquilarVO operacionVO = new AlquilarVO();
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AlquilarVO.class);
        logger.info(" id === > " + idOpe);
        detachedCriteria.createAlias("listaInstructorVO", "listaInstructorVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("listaInstructorVO.instructorVO", "instructorVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("instructorVO.instructorPersonaVO", "instructorPersonaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idEstadoVO", "idEstadoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("idOperacion", idOpe));
        detachedCriteria.addOrder(Order.asc("instructorPersonaVO.primerApellidoPer"));
        detachedCriteria.addOrder(Order.asc("instructorPersonaVO.segundoApellidoPer"));
        detachedCriteria.addOrder(Order.asc("instructorPersonaVO.nomPersona"));
        listaOperacion = listByCriteria(detachedCriteria);
        if (!listaOperacion.isEmpty()) {
            operacionVO = listaOperacion.get(0);
        }
        return operacionVO;
    }

    @Override
    public AlquilarVO obtenerCalificacionesPorIdOperacion(Integer idOperacion) {
        List<AlquilarVO> listaOperacion = new ArrayList<AlquilarVO>();
        AlquilarVO operacionVO = new AlquilarVO();
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AlquilarVO.class);
        detachedCriteria.createAlias("calificacionVO", "calificacionVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("calificacionVO.listaDetCalifVO", "listaDetCalifVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("idOperacion", idOperacion));
        listaOperacion = listByCriteria(detachedCriteria);
        if (!listaOperacion.isEmpty()) {
            operacionVO = listaOperacion.get(0);
        }
        return operacionVO;
    }

    @Override
    public AlquilarVO obtenerCalificacionesyDetalleCalifPorIdOperacion(Integer idOperacion) {
        List<AlquilarVO> listaOperacion = new ArrayList<AlquilarVO>();
        AlquilarVO operacionVO = new AlquilarVO();
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AlquilarVO.class);
        detachedCriteria.createAlias("calificacionVO", "calificacionVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("calificacionVO.listaDetCalifVO", "listaDetCalifVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("idOperacion", idOperacion));
        listaOperacion = listByCriteria(detachedCriteria);
        if (!listaOperacion.isEmpty()) {
            operacionVO = listaOperacion.get(0);
        }
        return operacionVO;
    }

    @Override
    public AlquilarVO obtenerOperacionConTipoPorIdOperacion(Integer idOperacion) {
        AlquilarVO operacionVO = null;
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AlquilarVO.class);
        detachedCriteria.createAlias("idEstadoVO", "idEstadoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("idOperacion", idOperacion));
        List<AlquilarVO> listaOperacion = listByCriteria(detachedCriteria);
        if (!listaOperacion.isEmpty()) {
            operacionVO = listaOperacion.get(0);
        }
        return operacionVO;
    }

    @Override
    public AlquilarVO obtenerDatosCabeceraOperacionPorIdOperacion(Integer idOperacion) {
        List<AlquilarVO> listaOperacion = new ArrayList<AlquilarVO>();
        AlquilarVO operacionVO = new AlquilarVO();
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AlquilarVO.class);
        detachedCriteria.createAlias("idCursoEspVO", "idCursoEspVO", DetachedCriteria.LEFT_JOIN);

        detachedCriteria.add(Restrictions.eq("idOperacion", idOperacion));
        listaOperacion = listByCriteria(detachedCriteria);
        if (!listaOperacion.isEmpty()) {
            operacionVO = listaOperacion.get(0);
        }
        return operacionVO;
    }

    @Override
    public AlquilarVO obtenerOperacionPorId(Integer idOperacion) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AlquilarVO.class);
        detachedCriteria.createAlias("idCursoEspVO", "idCursoEspVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("idOperacion", idOperacion));
        List<AlquilarVO> listOperacion = listByCriteria(detachedCriteria);
        if (!listOperacion.isEmpty()) {
            return listOperacion.get(0);
        }
        return null;
    }

    @Override
    public List<AlquilarVO> obtenerOperacionConInscripcionAlumnoPorBuqueda(BusquedaDTO busquedaDTO) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AlquilarVO.class);
        detachedCriteria.createAlias("idEstadoVO", "idEstadoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idCursoEspVO", "idCursoEspVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.addOrder(Order.asc("idOperacion"));
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
        List<AlquilarVO> list = new ArrayList<AlquilarVO>();
        if (busquedaDTO.getInicio() > 0 && busquedaDTO.getCantidad() > 0) {
            list = listByCriteria(detachedCriteria, ((busquedaDTO.getInicio() - 1) * busquedaDTO.getCantidad()), busquedaDTO.getCantidad());
        } else {
            list = listByCriteria(detachedCriteria);
        }
        return list;
    }

    @Override
    public Long obtenerTotalOperacionConInscripcionAlumnoPorBuqueda(BusquedaDTO busquedaDTO) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AlquilarVO.class);
        detachedCriteria.createAlias("idEstadoVO", "idEstadoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idCursoEspVO", "idCursoEspVO", DetachedCriteria.LEFT_JOIN);
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

    ////////////PARA REPORTE/////////////
    @Override
    public List obtenerListaCursosPorIdAlumno(Integer idAlummo) {
        List<AlquilarVO> listaOperacion = new ArrayList<AlquilarVO>();
        AlquilarVO operacionDevVO = new AlquilarVO();
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AlquilarVO.class);
        detachedCriteria.createAlias("listaAlumnoVO", "listaAlumnoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("listaAlumnoVO.alumnoVO", "alumnoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idEstadoVO", "idEstadoVO", DetachedCriteria.LEFT_JOIN);
        //  detachedCriteria.createAlias("alumnoVO.idAlumno", "idAlumno", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idCursoEspVO", "idCursoEspVO", DetachedCriteria.LEFT_JOIN);

        detachedCriteria.add(Restrictions.eq("alumnoVO.idAlumno", idAlummo));

        listaOperacion = listByCriteria(detachedCriteria);
        if (!listaOperacion.isEmpty()) {
            operacionDevVO = listaOperacion.get(0);
        }
        return listaOperacion;
    }

    @Override
    public AlquilarVO obtenerOperacionEInstructorPorIdOp(Integer idOperacion) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AlquilarVO.class);
        detachedCriteria.createAlias("idCursoEspVO", "idCursoEspVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("listaInstructorVO", "opInstructorVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("opInstructorVO.instructorVO", "instructorVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("instructorVO.instructorPersonaVO", "personaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("idOperacion", idOperacion));
        detachedCriteria.add(Restrictions.isNotNull("opInstructorVO.idOpeInstructor"));
        detachedCriteria.add(Restrictions.isNotNull("instructorVO.idInstructor"));
        List<AlquilarVO> listaOperacion = listByCriteria(detachedCriteria);
        AlquilarVO operacionVO = new AlquilarVO();
        if (!listaOperacion.isEmpty()) {
            operacionVO = listaOperacion.get(0);
        }
        return operacionVO;
    }

    @Override
    public Long obtenerTotalEncuestadosPorIdOperacion(Integer idOperacion) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AlquilarVO.class);
        detachedCriteria.createAlias("listaAlumnoVO", "operacionAlumnoDevVO", DetachedCriteria.INNER_JOIN);
        detachedCriteria.createAlias("operacionAlumnoDevVO.lstRespuestaVO", "respuestaVO", DetachedCriteria.INNER_JOIN);
        ProjectionList list = Projections.projectionList();
        list.add(Projections.groupProperty("operacionAlumnoDevVO.idOperacionAlumno"));
        list.add(Projections.count("operacionAlumnoDevVO.idOperacionAlumno"));
        detachedCriteria.setProjection(list);
        detachedCriteria.add(Restrictions.eq("idOperacion", idOperacion));
        detachedCriteria.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);
        Long total = ((Long) getHibernateTemplate().findByCriteria(detachedCriteria).get(0)).longValue();
        return total;
    }
}