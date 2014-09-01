/*  
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.operacion.operacion.impl;

import pe.com.microdata.cjava.service.registro.impl.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.dataaccess.domain.administracion.cuarto.CuartoDAO;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.SubtipoDAO;
import pe.com.microdata.cjava.dataaccess.domain.operacion.operacion.OperacionClienteDAO;
import pe.com.microdata.cjava.dataaccess.domain.operacion.operacion.OperacionDAO;
import pe.com.microdata.cjava.dataaccess.model.administracion.curso.CuartoVO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.SubTipoVO;
import pe.com.microdata.cjava.dataaccess.model.operacion.alquilado.AlquilarVO;

import pe.com.microdata.cjava.service.operacion.operacion.GestionarOperacion;
import pe.com.microdata.cjava.service.operacion.operacion.dto.AperturaDTO;
import pe.com.microdata.cjava.service.operacion.operacion.dto.EstadosDTO;
import pe.com.microdata.cjava.service.operacion.operacion.dto.ItemOperacionDTO;
import pe.com.microdata.cjava.service.operacion.operacion.dto.OperacionActivoDTO;
import pe.com.microdata.cjava.service.operacion.operacion.dto.OperacionDTO;

/**
 *
 * @author meliMELI
 */
@Service("gestionarOperacion")
public class GestionarOperacionImpl implements GestionarOperacion {
    
    @Autowired
    OperacionDAO operacionDAO;
    @Autowired
    OperacionClienteDAO operacionAlumnoDAO;
 
    @Autowired
    CuartoDAO cuartoDAO;
    @Autowired
    SubtipoDAO subTipoDAO;
  
    SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.FORMATO_FECHA);
    Calendar calendar = Calendar.getInstance();
    private static Logger logger = Logger.getLogger(GestionarOperacionImpl.class);
    
    
    /*
    @Override
    public SIGAMessage activarCurso(OperacionActivoDTO cursoActivoDTO) {
        SIGAMessage msg = new SIGAMessage();
        msg.setSuccess(Boolean.FALSE);
      
        
        return msg;
    }
    
    @Override
    public OperacionDTO obtenerOperacionActivaPorId(Integer idOperacion) {
        
        OperacionDTO operacionDTO = new OperacionDTO();
        AlquilarVO operacionVO = operacionDAO.obtenerCursosActivosPorIdOperacion(idOperacion);
        try {
            
            operacionDTO.setIdOperacion(operacionVO.getIdOperacion());
            operacionDTO.setNombreCurso(operacionVO.getIdCursoEspVO().getNomCursoEspecifico());
            operacionDTO.setCodigoOpe(operacionVO.getCodigoOperacion());
            operacionDTO.setFechaInicio(operacionVO.getFechaInicioOp() != null ? dateFormat.format(operacionVO.getFechaInicioOp()) : "");
            operacionDTO.setFechaFin(operacionVO.getFechaFinOp() != null ? dateFormat.format(operacionVO.getFechaFinOp()) : "");
            operacionDTO.setFechaRegistro(operacionVO.getFechaRegistroOpe() != null ? dateFormat.format(operacionVO.getFechaRegistroOpe()) : "");
            operacionDTO.setIdEstado(operacionVO.getIdEstadoVO() != null ? operacionVO.getIdEstadoVO().getIdSubTipo() : 0);
            operacionDTO.setIdTurno(operacionVO.getIdTurnoVO() != null ? operacionVO.getIdTurnoVO().getIdSubTipo() : 0);
            operacionDTO.setNombreCurso(operacionVO.getIdCursoEspVO() != null ? operacionVO.getIdCursoEspVO().getNomCursoEspecifico() : " ");
            operacionDTO.setNumHora(operacionVO.getCantHoras());
            operacionDTO.setNumSesion(operacionVO.getCantSesiones());
                       
            operacionDTO.setPaso21DiasYActivo(Boolean.FALSE);
            operacionDTO.setPoderCerrar(Boolean.FALSE);
            operacionDTO.setTerminoUltimaClase(Boolean.FALSE);
            operacionDTO.setPoderModificar(Boolean.FALSE);
            operacionDTO.setCuartoFinalizado(Boolean.FALSE);
            
            String estadoCurso = "";
            SubTipoVO estadoVO = operacionVO.getIdEstadoVO();
            long cantDiasEntreUltimaYActualFecha = diferenciaEntreLaFechaActualYXDate(operacionVO.getFechaFinOp());
            if (estadoVO.getIdSubTipo() == Constants.SUBTIPO_ESTADO_OPE_ALU_APERTURA) {
                estadoCurso = "Curso en apertura";
                operacionDTO.setPoderModificar(Boolean.TRUE);
            } else if (estadoVO.getIdSubTipo() == Constants.SUBTIPO_ESTADO_OPE_ALU_ACTIVO) {
                estadoCurso = "Curso iniciado";
                operacionDTO.setPoderCerrar(Boolean.TRUE);
                operacionDTO.setTerminoUltimaClase(Boolean.TRUE);
                if (cantDiasEntreUltimaYActualFecha > 21) {
                    operacionDTO.setPaso21DiasYActivo(Boolean.TRUE);
                }
            } else if (estadoVO.getIdSubTipo() == Constants.SUBTIPO_ESTADO_OPE_ALU_FINALIZADO) {
                estadoCurso = "Curso finalizado";
                operacionDTO.setCuartoFinalizado(Boolean.TRUE);
            }
            
            operacionDTO.setTipoCurso(estadoCurso);
            Boolean flag = Boolean.TRUE;
            if (operacionVO.getIdEstadoVO().getIdSubTipo() == Constants.SUBTIPO_ESTADO_OPE_ALU_ACTIVO || operacionVO.getIdEstadoVO().getIdSubTipo() == Constants.SUBTIPO_ESTADO_OPE_ALU_FINALIZADO) {
                flag = Boolean.FALSE;
            }
            operacionDTO.setEditarFecha(flag);
            
            
            operacionDTO.setTerminoUltimaClase(cantDiasEntreUltimaYActualFecha > 0);
            operacionDTO.setPaso7Dias(cantDiasEntreUltimaYActualFecha > 7);
            operacionDTO.setDiasCierre((21 - cantDiasEntreUltimaYActualFecha) >= 0 ? (21 - cantDiasEntreUltimaYActualFecha) + " días " : Constants.OPERACION_MSG_DEBE_CERRAR_CURSO);
        } catch (Exception e) {
            logger.error("Error en obtenerOperacionActivaPorId ", e);
        }
        return operacionDTO;
    }
   
    
    @Override
    public SIGAMessage modificarDatosOperacion(OperacionDTO cursoActivoDTO)  {
        SIGAMessage msg = new SIGAMessage();
        msg.setSuccess(Boolean.FALSE);
        AlquilarVO operacionVO = operacionDAO.obtenerCursosActivosPorIdOperacion(cursoActivoDTO.getIdOperacion());
        Calendar c = new GregorianCalendar();
        String annio = Integer.toString(c.get(Calendar.YEAR));
        //////////////////////////////PERSONAVO//////////////////////////////
        //operacionVO.setIdOperacion(Integer.MIN_VALUE);
        operacionVO.setCodigoOperacion(cursoActivoDTO.getCodigoOpe());
        //  operacionVO.setCursoCorporacionOpe(cursoActivoDTO.getCursoEmpresa() ? 1 : 0);
        try {
            operacionVO.setFechaInicioOp(dateFormat.parse(cursoActivoDTO.getFechaInicio()));
        } catch (ParseException ex) {
            logger.error(GestionarClienteImpl.class.getName(), ex);
        }
        try {
            operacionVO.setFechaFinOp(dateFormat.parse(cursoActivoDTO.getFechaFin()));
        } catch (ParseException ex) {
            logger.error(GestionarClienteImpl.class.getName(), ex);
        }
        operacionVO.setIdEstadoVO(new SubTipoVO(cursoActivoDTO.getIdEstado()));
        operacionVO.setIdTurnoVO(new SubTipoVO(cursoActivoDTO.getIdTurno()));
        operacionDAO.saveOrUpdate(operacionVO);
        msg.setSuccess(Boolean.TRUE);
        return msg;
    }
    
    @Override
    public void eliminarOperacion(Integer operacion) {
        AlquilarVO operacionVO = operacionDAO.obtenerCursosActivosPorIdOperacion(operacion);
        operacionVO.setActivaOperacion(Constants.OPERACION_BORRADA);
        operacionDAO.saveOrUpdate(operacionVO);
    }
    
    @Override
    public List obtenerOperacionPorBusqueda(BusquedaDTO busquedaDTO) {
        List<OperacionDTO> operacionDTOs = new ArrayList<OperacionDTO>();
        List<AlquilarVO> operacionVOs = operacionDAO.obtenerCursosActivosPorBusqueda(busquedaDTO);
        try {
            for (AlquilarVO operacionVO : operacionVOs) {
                long difDias = -1;
                try {
                    Date fechaVO = operacionVO.getFechaFinOp();
                    difDias = diferenciaEntreLaFechaActualYXDate(fechaVO);
                } catch (Exception e) {
                    
                    logger.error("Error en obtenerOperacionPorBusqueda ", e);
                }
                String str = "";
                if (operacionVO.getIdEstadoVO().getIdSubTipo() == Constants.SUBTIPO_ESTADO_OPE_ALU_ACTIVO) {
                    if (difDias > 0) {
                        long cant = Constants.OPERACION_DIAS_MAXIMO_LLENAR - difDias + 1;
                        if (difDias <= 21) {
                            str = (" (" + cant + " " + (cant == 1 ? "dia" : "dias") + " editable )");
                        } else {
                            str = " (debe cerrar la operación)";
                        }
                    } else {
                        DetalleAlquilerVO detOpeVO = detalleOperacionDAO.obtenerDetalleOperacionPorIdOperacion(operacionVO.getIdOperacion());
                        str = detOpeVO.getExistEncuAsig() ? "" : " (falta activar encuesta)";
                    }
                }
                OperacionDTO operacionDTO = new OperacionDTO();
                //////////////////////////////ALUMNO VO//////////////////////
                operacionDTO.setIdOperacion(operacionVO.getIdOperacion());
                //EJEMPLOOO O O   operacionDTO.setIdCentroEdu(operacionVO.getCentroEducativo() != null ? operacionVO.getCentroEducativo().getIdSubTipo() : 0);
                operacionDTO.setCodigoOpe(operacionVO.getCodigoOperacion());
                operacionDTO.setDireccion(operacionVO.getIdCursoEspVO().getDireccion()+ str);
                
                operacionDTO.setFechaInicio(dateFormat.format(operacionVO.getFechaInicioOp()));
                operacionDTO.setFechaFin(dateFormat.format(operacionVO.getFechaFinOp()));
                operacionDTO.setFechaRegistro(dateFormat.format(operacionVO.getFechaRegistroOpe()));
                operacionDTO.setIdEstado(operacionVO.getIdEstadoVO() != null ? operacionVO.getIdEstadoVO().getIdSubTipo() : 0);
                operacionDTO.setDescripcionEstado(operacionVO.getIdEstadoVO().getNomSubtipo());
                /////////////////////////////
                operacionDTO.setIdTurno(operacionVO.getIdTurnoVO() != null ? operacionVO.getIdTurnoVO().getIdSubTipo() : 0);
                operacionDTOs.add(operacionDTO);
            }
        } catch (Exception e) {
            logger.error("Error general en obtenerOperacionPorBusqueda", e);
        }
        return operacionDTOs;
    }
    
    @Override
    public Long obtenerTotalOperacionesPorBusqueda(BusquedaDTO busquedaDTO) {
        return operacionDAO.obtenerTotalOperacionesAlumnosPorBusqueda(busquedaDTO);
    }
    
    @Override
    public EstadosDTO obtenerEstados(Integer idOperacion) {
        EstadosDTO estadosDTO = new EstadosDTO();
        DetalleAlquilerVO vo = detalleOperacionDAO.obtenerDetalleOperacionPorIdOperacion(idOperacion);
        try {
            if (vo != null) {
                estadosDTO.setCantAlumnos(vo.getCantAlum());
                estadosDTO.setCantInstructore(vo.getCantInstr());
                estadosDTO.setCantAbandono(vo.getCantAbandono());
                estadosDTO.setCantCertificados(vo.getCantCertiEntre());
                estadosDTO.setCantEncuResp(vo.getCantEncuResp());
                estadosDTO.setEstAlumnos(vo.getCantAlum() >= Constants.OPERACION_CANTIDAD_MINIMA_ALUMNO ? Boolean.TRUE : Boolean.FALSE);
                estadosDTO.setEstInstructores(vo.getCantInstr() >= Constants.OPERACION_CANTIDAD_MINIMA_INSTRUCTOR ? Boolean.TRUE : Boolean.FALSE);
                estadosDTO.setEstSesiones(vo.getExistSesion());
                estadosDTO.setEstEncuesta(vo.getExistEncuAsig());
                estadosDTO.setEstCalificaciones(vo.getExistCriteCali());
                estadosDTO.setIdOperacion(idOperacion);
            }
        } catch (Exception e) {
            logger.error("Error en obtenerEstados ", e);
        }
        return estadosDTO;
    }
    
 
    
    @Override
    public List<ItemOperacionDTO> obtenerListaEmpresa() {
        List<EmpresaVO> listaEmpresaVO = empresaDAO.obtenerListaEmpresaPorBusqueda(new BusquedaDTO(0, 0));
        List<ItemOperacionDTO> listaCursoDTO = new ArrayList<ItemOperacionDTO>();
        try {
            for (EmpresaVO vo : listaEmpresaVO) {
                ItemOperacionDTO dto = new ItemOperacionDTO();
                dto.setId(vo.getIdEmpresa());
                dto.setNombre(vo.getNomEmpresa());
                listaCursoDTO.add(dto);
            }
        } catch (Exception e) {
            logger.error("error en obtenerListaEmpresa ", e);
        }
        return listaCursoDTO;
    }
    
    private String generarNombreUnico(String nom) {
        String nombreUnique = nom;
        Random rn = new Random();
        nombreUnique += dateFormat.format(Calendar.getInstance().getTime()) + (rn.nextInt(1000) + 10);
        if (nombreUnique.length() > 19) {
            nombreUnique = nombreUnique.substring(nombreUnique.length() - 20, nombreUnique.length());
        }
        return nombreUnique;
    }
    
    @Override
    public SIGAMessage cambiarDeAperturaAactivo(AperturaDTO aperturaDTO) {
        SIGAMessage msg = new SIGAMessage();
        msg.setSuccess(Boolean.FALSE);
        AlquilarVO operacionVO = operacionDAO.obtenerOperacionPorIdOperacion(aperturaDTO.getIdOperacion());
        try {
            operacionVO.setIdOperacion(aperturaDTO.getIdOperacion());
            operacionVO.setIdEstadoVO(new SubTipoVO(Constants.SUBTIPO_ESTADO_OPE_ALU_ACTIVO));
            operacionDAO.saveOrUpdate(operacionVO);
            msg.setSuccess(Boolean.TRUE);
            msg.setMessageType(SIGAMessage.MessageType.SUCCESS);
        } catch (Exception ex) {
            logger.error("Error en cambiarDeAperturaAactivo ", ex);
            ex.printStackTrace();
            msg.setSuccess(Boolean.FALSE);
        }
        return msg;
    }
    
    @Override
    public OperacionDTO obtenerDatosCabeceraOperacionActivaPorId(Integer idOperacion) {
        OperacionDTO operacionDTO = new OperacionDTO();
        AlquilarVO operacionVO = operacionDAO.obtenerDatosCabeceraOperacionPorIdOperacion(idOperacion);
        operacionDTO.setIdOperacion(operacionVO.getIdAlquilar());
        operacionDTO.setCodigoOpe(operacionVO.getCodigoOperacion());
        operacionDTO.setDireccion(operacionVO.getIdCuartoVO().getDireccion());
        //operacionDTO.setIdCurso(operacionVO.getIdCursoEspVO()!= null ? operacionVO.getIdCursoEspVO().getIdCursoEspecifico():0);
        //  operacionDTO.setNombreCurso(operacionVO.getIdCursoEspVO().getNomCursoEspecifico());
        return operacionDTO;
    }
    
    @Override
    public OperacionDTO obtenerOperacionPorId(Integer idOperacion) {
        OperacionDTO operacionDTO = new OperacionDTO();
        AlquilarVO vo = operacionDAO.obtenerOperacionPorId(idOperacion);
        try {
            operacionDTO.setIdOperacion(vo.getIdAlquilar());
            operacionDTO.setCodigoOpe(vo.getCodigoOperacion());
            operacionDTO.setDireccion(vo.getIdCuartoVO() != null ? vo.getIdCuartoVO().getDireccion() : " ");
        } catch (Exception e) {
            logger.error("Error en obtenerOperacionPorId", e);
        }
        return operacionDTO;
    }
    
    @Override
    public List obtenerOperacionConInscripcionAlumnoPorBusqueda(BusquedaDTO busquedaDTO) {
        Map<Integer, OperacionDTO> lstOperacionDTOs = new HashMap<Integer, OperacionDTO>();
        List<AlquilarVO> operacionVOs = operacionDAO.obtenerOperacionConInscripcionAlumnoPorBuqueda(busquedaDTO);
        try {
            
            for (AlquilarVO operacionVO : operacionVOs) {
                OperacionDTO operacionDTO = new OperacionDTO();
                operacionDTO.setCodigoOpe(operacionVO.getCodigoOperacion());
                operacionDTO.setIdEstado(operacionVO.getIdEstadoVO() != null ? operacionVO.getIdEstadoVO().getIdSubTipo() : 0);
                operacionDTO.setDireccion(operacionVO.getIdCursoEspVO() != null ? operacionVO.getIdCursoEspVO().getDireccion(): "");
                operacionDTO.setDescripcionEstado(operacionVO.getIdEstadoVO() != null ? operacionVO.getIdEstadoVO().getNomSubtipo() : "");
                operacionDTO.setFechaInicio(dateFormat.format(operacionVO.getFechaInicioOp()));
                operacionDTO.setFechaFin(dateFormat.format(operacionVO.getFechaFinOp()));
                lstOperacionDTOs.put(operacionVO.getIdOperacion(), operacionDTO);
            }
            // Conteo Sesiones
       
            //Conteo Alumnos
            BusquedaDTO bdto = new BusquedaDTO();
            bdto.setCondiciones(busquedaDTO.getCondiciones());
            if (!lstOperacionDTOs.isEmpty()) {
                List objs = operacionAlumnoDAO.obtenerTotalAlumnosPorIdsOperaciones(lstOperacionDTOs.keySet(), bdto); // idOpe , conteo 
                if (!objs.isEmpty()) {
                    Iterator it = objs.iterator();
                    while (it.hasNext()) {
                        Object[] p = (Object[]) it.next();
                        lstOperacionDTOs.get((Integer) p[0]).setCantAlumnos((Long) p[1]); // viene Long

                    }
                }
            }
        } catch (Exception e) {
            logger.error("Error en obtenerOperacionConInscripcionAlumnoPorBusqueda", e);
        }
        return new ArrayList(lstOperacionDTOs.values());
    }
    
    @Override
    public Long obtenerTotalOperacionConInscripcionAlumnoPorBusqueda(BusquedaDTO busquedaDTO) {
        return operacionDAO.obtenerTotalOperacionConInscripcionAlumnoPorBuqueda(busquedaDTO);
    }
    
    @Override
    public SIGAMessage modificarFechaOperacion(AperturaDTO dto) {
        SIGAMessage m = new SIGAMessage();
        m.setSuccess(Boolean.FALSE);
        try {
            OperacionDevVO vo = operacionDevDAO.obtenerOperacionPorIdOperacion(dto.getIdOperacion());
            vo.setFecIniOperacion(dateFormat.parse(dto.getFechaInicio()));
            vo.setFecFinOperacion(dateFormat.parse(dto.getFechaFin()));
            operacionDevDAO.saveOrUpdate(vo);
            m.setSuccess(Boolean.TRUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }
    
    @Override
    public SIGAMessage cerrarOperacionPorIdOperacion(Integer idOperacion) {
        SIGAMessage m = new SIGAMessage();
        m.setSuccess(Boolean.FALSE);
        try {
            AlquilarVO vo = operacionDAO.get(idOperacion);
            vo.setIdEstadoVO(new SubTipoVO(Constants.SUBTIPO_ESTADO_OPE_ALU_FINALIZADO));
            operacionDAO.saveOrUpdate(vo);
            m.setSuccess(Boolean.TRUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }
    
    private long diferenciaEntreLaFechaActualYXDate(Date x) {
        long result = 0;
        try {
            Date fechaActual = dateFormat.parse(dateFormat.format(Calendar.getInstance().getTime()));
            result = fechaActual.getTime() - x.getTime();
            result = TimeUnit.DAYS.convert(result, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }*/
}
