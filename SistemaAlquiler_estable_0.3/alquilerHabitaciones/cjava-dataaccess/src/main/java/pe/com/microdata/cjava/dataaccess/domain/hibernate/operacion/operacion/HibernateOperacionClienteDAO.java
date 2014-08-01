package pe.com.microdata.cjava.dataaccess.domain.hibernate.operacion.operacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
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
import pe.com.microdata.cjava.dataaccess.domain.operacion.operacion.OperacionClienteDAO;
import pe.com.microdata.cjava.dataaccess.model.operacion.alquilado.OperacionClienteVO;
import pe.com.microdata.cjava.dataaccess.util.GeneradorRestricciones;

/**
 * Implementación de la clase UsuarioDAO.
 *
 * @author meliMeli
 */
public class HibernateOperacionClienteDAO extends HibernateGenericDAO<OperacionClienteVO, Integer>
        implements OperacionClienteDAO {

    HashMap<String, ReglaDTO> eq;

    public HibernateOperacionClienteDAO() {
        super(OperacionClienteVO.class);
        eq = new HashMap<String, ReglaDTO>();
        eq.put("idAlquilar", new ReglaDTO(Constants.OPE_EQ, Constants.TYPE_INTEGER, "operacionVO.idAlquilar"));
        eq.put("nomAlumno", new ReglaDTO(Constants.OPE_LIKE, Constants.TYPE_STRING, "clientePersonaVO.nomPersona"));
        eq.put("primerApe", new ReglaDTO(Constants.OPE_LIKE, Constants.TYPE_STRING, "clientePersonaVO.primerApellidoPer"));
        eq.put("segundoApe", new ReglaDTO(Constants.OPE_LIKE, Constants.TYPE_STRING, "clientePersonaVO.segundoApellidoPer"));
        eq.put("ubigeo", new ReglaDTO(Constants.OPE_LIKE_INICIO, Constants.TYPE_STRING, "ubigeosAsignados.representanteUbigeoId.ubigeo"));
        eq.put("fechaInicioOp", new ReglaDTO(Constants.OPE_GE, Constants.TYPE_DATE, "fechaInscripcionAlu"));
        eq.put("fechaFinOp", new ReglaDTO(Constants.OPE_LE, Constants.TYPE_DATE, "fechaInscripcionAlu"));
        eq.put("idCliente", new ReglaDTO(Constants.OPE_EQ, Constants.TYPE_INTEGER, "clienteVO.idCliente"));
        eq.put("nomOperacion", new ReglaDTO(Constants.OPE_LIKE, Constants.TYPE_STRING, "idCursoEspVO.nomCursoEspecifico"));
        eq.put("codOperacion", new ReglaDTO(Constants.OPE_LIKE, Constants.TYPE_STRING, "idOperacionVO.codigoOperacion"));

    }

    /*
    @Override
    public OperacionClienteVO obtenerOpeAlumnoPorIdOpeAlumno(Integer idOpeCliente) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(OperacionClienteVO.class);
        OperacionClienteVO operacionVO = null;
        detachedCriteria.createAlias("clienteVO", "clienteVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("clienteVO.clientePersonaVO", "clientePersonaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idOperacionVO", "idOperacionVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idOperacionVO.idEstadoVO", "idEstadoVO", DetachedCriteria.LEFT_JOIN);
              

        detachedCriteria.add(Restrictions.eq("idOpeCliente", idOpeCliente));
        List<OperacionClienteVO> alumnoVOs = new ArrayList<OperacionClienteVO>();
        alumnoVOs = listByCriteria(detachedCriteria);
        if (!alumnoVOs.isEmpty()) {
            operacionVO = alumnoVOs.get(0);
        }
        return operacionVO;
    }

    @Override
    public List obtenerOpeAlumnoPorIdOpeAlumnoLista(Integer idOpeAlumno) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(OperacionClienteVO.class);
        detachedCriteria.add(Restrictions.eq("idOpeCliente", idOpeAlumno));
        List<OperacionClienteVO> usuarios = listByCriteria(detachedCriteria);
        return usuarios;
    }

    @Override
    public OperacionClienteVO obtenerDetalleAlumnoPorIdOpeAlumno(Integer idOpeAlumno) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(OperacionClienteVO.class);
        OperacionClienteVO operacionVO = null;
        detachedCriteria.createAlias("idAlumnoVO", "idAlumnoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("idOpeCliente", idOpeAlumno));
        List<OperacionClienteVO> alumnoVOs = new ArrayList<OperacionClienteVO>();
        alumnoVOs = listByCriteria(detachedCriteria);
        if (!alumnoVOs.isEmpty()) {
            operacionVO = alumnoVOs.get(0);
        }
        return operacionVO;
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
    public List<OperacionClienteVO> obtenerOpeAlumnoPorBusqueda(BusquedaDTO busquedaDTO) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(OperacionClienteVO.class);
        detachedCriteria.createAlias("idOperacionVO", "idOperacionVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idAlumnoVO", "idAlumnoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idAlumnoVO.alumnoPersonaVO", "alumnoPersonaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.addOrder(Order.desc("notaFinalAlu"));
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.primerApellidoPer"));
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.segundoApellidoPer"));
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.nomPersona"));
        List<OperacionClienteVO> list = new ArrayList<OperacionClienteVO>();
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
    public Long obtenerTotalOpeAlumnosPorBusqueda(BusquedaDTO busquedaDTO) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(OperacionClienteVO.class);
        detachedCriteria.createAlias("idOperacionVO", "idOperacionVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idAlumnoVO", "idAlumnoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idAlumnoVO.alumnoPersonaVO", "alumnoPersonaVO", DetachedCriteria.LEFT_JOIN);
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
    public Boolean existeAlumnosParaCursoActivo(Integer idOperacion) {
        Boolean estado = Boolean.FALSE;
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(OperacionClienteVO.class);
        detachedCriteria.createAlias("idOperacionVO", "idOperacionVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idAlumnoVO", "idAlumnoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("idOperacionVO.idOperacion", idOperacion));
        List<OperacionClienteVO> fraccVOs = listByCriteria(detachedCriteria);
        if (!fraccVOs.isEmpty() && fraccVOs.get(0) != null) {
            estado = Boolean.TRUE;
        }
        return estado;
    }

    @Override
    public Boolean existeSesionesParaCursoActivo(Integer idSesiones) {
        Boolean estado = Boolean.FALSE;
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(OperacionClienteVO.class);
        detachedCriteria.createAlias("idOperacionVO", "idOperacionVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idAlumnoVO", "idAlumnoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("idOperacionVO.idOperacion", idSesiones));
        List<OperacionClienteVO> fraccVOs = listByCriteria(detachedCriteria);
        if (!fraccVOs.isEmpty() && fraccVOs.get(0) != null) {
            estado = Boolean.TRUE;
        }
        return estado;
    }

    @Override
    public List obtenerOpeAlumnoPorIdOperacion(Integer idOperacion) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(OperacionClienteVO.class);
        detachedCriteria.createAlias("idOperacionVO", "idOperacionVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idAlumnoVO", "idAlumnoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idAlumnoVO.alumnoPersonaVO", "alumnoPersonaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("idOperacionVO.idOperacion", idOperacion));
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.primerApellidoPer"));
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.segundoApellidoPer"));
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.nomPersona"));
        List<OperacionClienteVO> usuarios = listByCriteria(detachedCriteria);
        return usuarios;
    }

    @Override
    public List obtenerOpeAlumnoConAsistenciaPorBusqueda(BusquedaDTO busquedaDTO) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(OperacionClienteVO.class);
        detachedCriteria.createAlias("idOperacionVO", "idOperacionVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idAlumnoVO", "idAlumnoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idAlumnoVO.alumnoPersonaVO", "alumnoPersonaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("lstAsistenciaVO", "lstAsistenciaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("lstAsistenciaVO.cronogramaVO", "cronogramaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("lstAsistenciaVO.tipoAsistenciaVO", "tipoAsistenciaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.primerApellidoPer"));
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.segundoApellidoPer"));
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.nomPersona"));
        detachedCriteria.addOrder(Order.asc("cronogramaVO.fecCro"));
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
        List<OperacionClienteVO> list = new ArrayList<OperacionClienteVO>();
        if (busquedaDTO.getInicio() > 0 && busquedaDTO.getCantidad() > 0) {
            list = listByCriteria(detachedCriteria, ((busquedaDTO.getInicio() - 1) * busquedaDTO.getCantidad()), busquedaDTO.getCantidad());
        } else {
            list = listByCriteria(detachedCriteria);
        }
        return list;
    }

    @Override
    public List<OperacionClienteVO> obtenerListaOperacionPorIdAlum(Integer idAlum) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(OperacionClienteVO.class);
        detachedCriteria.createAlias("idOperacionVO", "idOperacionVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idOperacionVO.idEstadoVO", "idEstadoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idOperacionVO.idCursoEspVO", "idCursoEspVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idAlumnoVO", "idAlumnoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("idAlumnoVO.idAlumno", idAlum));
        List<OperacionClienteVO> listOpeAlu = listByCriteria(detachedCriteria);
        return listOpeAlu;
    }

    @Override
    public List obtenerListaOpeAlumnoPorIdOperacion(Integer idOperacion) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(OperacionClienteVO.class);
        detachedCriteria.createAlias("idOperacionVO", "idOperacionVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idAlumnoVO", "idAlumnoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idAlumnoVO.alumnoPersonaVO", "alumnoPersonaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("idOperacionVO.idOperacion", idOperacion));
        List<OperacionClienteVO> usuarios = listByCriteria(detachedCriteria);
        return usuarios;
    }

    @Override
    public List obtenerListaOpeAluConDatosAlumPorIdOperacion(Integer idOperacion) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(OperacionClienteVO.class);
        detachedCriteria.createAlias("idOperacionVO", "idOperacionVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("idOperacionVO.idOperacion", idOperacion));
        List<OperacionClienteVO> usuarios = listByCriteria(detachedCriteria);
        return usuarios;
    }

    @Override
    public List obtenerTotalAlumnosPorIdsOperaciones(Set<Integer> idsOperacion, BusquedaDTO busquedaDTO) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(OperacionClienteVO.class);
        detachedCriteria.createAlias("idOperacionVO", "idOperacionVO", DetachedCriteria.LEFT_JOIN);
        ProjectionList list = Projections.projectionList();
        list.add(Projections.groupProperty("idOperacionVO.idOperacion"));
        list.add(Projections.count("idOpeAlumno"));
        detachedCriteria.setProjection(list);
        detachedCriteria.add(Restrictions.in("idOperacionVO.idOperacion", idsOperacion));
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
        List objs = listByCriteria(detachedCriteria);
        return objs;
    }

    @Override
    public List obtenerAbandonosOpAlumnoPorBusqueda(BusquedaDTO busquedaDTO) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(OperacionClienteVO.class);
        detachedCriteria.createAlias("idOperacionVO", "idOperacionVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idAlumnoVO", "idAlumnoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idAlumnoVO.alumnoPersonaVO", "alumnoPersonaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("abandonoAlu", Constants.IND_ABANDONO));
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.primerApellidoPer"));
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.segundoApellidoPer"));
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.nomPersona"));
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
        List<OperacionClienteVO> list = new ArrayList<OperacionClienteVO>();
        if (busquedaDTO.getInicio() > 0 && busquedaDTO.getCantidad() > 0) {
            list = listByCriteria(detachedCriteria, ((busquedaDTO.getInicio() - 1) * busquedaDTO.getCantidad()), busquedaDTO.getCantidad());
        } else {
            list = listByCriteria(detachedCriteria);
        }
        return list;
    }

    @Override
    public List<OperacionClienteVO> obtenerListaOperacionPorIdAlumnoYListaIdCursoEspecifico(Integer idAlumno, Set<Integer> keyIdCurEsp) {
        List<OperacionClienteVO> listaOperacion = new ArrayList<OperacionClienteVO>();
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(OperacionClienteVO.class);
        detachedCriteria.createAlias("idOperacionVO", "idOperacionVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idOperacionVO.idEstadoVO", "idEstadoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idOperacionVO.idCursoEspVO", "idCursoEspVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idAlumnoVO", "idAlumnoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("idAlumnoVO.idAlumno", idAlumno));
        detachedCriteria.add(Restrictions.in("idOperacionVO.idCursoEspVO.idCursoEspecifico", keyIdCurEsp));
        listaOperacion = listByCriteria(detachedCriteria);
        return listaOperacion;
    }

    @Override
    public OperacionClienteVO obtenerOpeAlumnoPorIdOperacionyIdAlumno(Integer idOperacion, Integer idAlumno) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(OperacionClienteVO.class);
        detachedCriteria.createAlias("idAlumnoVO", "idAlumnoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idOperacionVO", "idOperacionVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("idAlumnoVO.idAlumno", idAlumno));
        detachedCriteria.add(Restrictions.eq("idOperacionVO.idOperacion", idOperacion));
        OperacionClienteVO operacionVO = null;
        List<OperacionClienteVO> operacionAlumnoVOs = new ArrayList<OperacionClienteVO>();
        operacionAlumnoVOs = listByCriteria(detachedCriteria);
        if (!operacionAlumnoVOs.isEmpty()) {
            operacionVO = operacionAlumnoVOs.get(0);
        }
        return operacionVO;
    }

    @Override
    public List<OperacionClienteVO> obtenerOpeAlumnosRecordPorBusqueda(BusquedaDTO busquedaDTO) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(OperacionClienteVO.class);
        detachedCriteria.createAlias("idOperacionVO", "idOperacionVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idOperacionVO.idCursoEspVO", "idCursoEspVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idOperacionVO.idEstadoVO", "idEstadoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idAlumnoVO", "idAlumnoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idAlumnoVO.alumnoPersonaVO", "alumnoPersonaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.primerApellidoPer"));
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.segundoApellidoPer"));
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.nomPersona"));
        List<OperacionClienteVO> list = new ArrayList<OperacionClienteVO>();
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
    public Boolean existeOpeAlumnosRecordPorBusqueda(BusquedaDTO busquedaDTO) {
        Boolean b = false;
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(OperacionClienteVO.class);
        detachedCriteria.createAlias("idOperacionVO", "idOperacionVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idOperacionVO.idCursoEspVO", "idCursoEspVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idOperacionVO.idEstadoVO", "idEstadoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idAlumnoVO", "idAlumnoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("idAlumnoVO.alumnoPersonaVO", "alumnoPersonaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.primerApellidoPer"));
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.segundoApellidoPer"));
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.nomPersona"));
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
        List<OperacionClienteVO> list = listByCriteria(detachedCriteria, ((busquedaDTO.getInicio() - 1) * busquedaDTO.getCantidad()), busquedaDTO.getCantidad());
        if (!list.isEmpty()) {
            b = true;
        }
        return b;
    }*/
}