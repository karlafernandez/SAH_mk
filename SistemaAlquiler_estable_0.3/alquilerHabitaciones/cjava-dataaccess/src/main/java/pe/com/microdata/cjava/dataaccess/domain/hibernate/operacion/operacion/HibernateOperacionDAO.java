package pe.com.microdata.cjava.dataaccess.domain.hibernate.operacion.operacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import pe.com.microdata.cjava.common.base.ReglaDTO;
import pe.com.microdata.cjava.dataaccess.base.hibernate.HibernateGenericDAO;
import pe.com.microdata.cjava.dataaccess.domain.operacion.operacion.OperacionDAO;
import pe.com.microdata.cjava.dataaccess.model.operacion.alquilado.AlquilarVO;

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
        detachedCriteria.createAlias("idCuartoVO", "idCuartoVO", DetachedCriteria.LEFT_JOIN);
                
       
        detachedCriteria.add(Restrictions.eq("idAlquilar", idOperacion));
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
        detachedCriteria.createAlias("idCuartoVO", "idCuartoVO", DetachedCriteria.LEFT_JOIN);
        //detachedCriteria.createAlias("calificacionVO", "calificacionVO", DetachedCriteria.LEFT_JOIN);
       

        detachedCriteria.add(Restrictions.eq("idAlquilar", idOperacion));
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
        detachedCriteria.add(Restrictions.eq("idAlquilar", idOperacion));
        listaOperacion = listByCriteria(detachedCriteria);
        if (!listaOperacion.isEmpty()) {
            operacionVO = listaOperacion.get(0);
        }
        return operacionVO;
    }
    
    /*

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
        detachedCriteria.createAlias("idCuartoVO", "idCuartoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("listaClienteVO", "listaClienteVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("listaClienteVO.clienteVO", "clienteVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("clienteVO.clientePersonaVO", "clientePersonaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idEstadoVO", "idEstadoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("idOperacion", idOpe));
        detachedCriteria.addOrder(Order.asc("clientePersonaVO.primerApellidoPer"));
        detachedCriteria.addOrder(Order.asc("clientePersonaVO.segundoApellidoPer"));
        detachedCriteria.addOrder(Order.asc("clientePersonaVO.nomPersona"));
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
        detachedCriteria.createAlias("listaClienteVO", "listaClienteVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("listaClienteVO.clienteVO", "clienteVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("clienteVO.alumnoPersonaVO", "alumnoPersonaVO", DetachedCriteria.LEFT_JOIN);
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
        detachedCriteria.createAlias("idEstadoVO", "idEstadoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("idOperacion", idOpe));
  
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





   */
}