/*  
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.operacion.operacion.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.ClienteDAO;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.ArrendatarioDAO;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.SubtipoDAO;
import pe.com.microdata.cjava.dataaccess.domain.operacion.operacion.OperacionClienteDAO;
import pe.com.microdata.cjava.dataaccess.domain.operacion.operacion.OperacionDAO;

import pe.com.microdata.cjava.dataaccess.model.administracion.persona.ClienteVO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.PersonaVO;
import pe.com.microdata.cjava.dataaccess.model.operacion.alquilado.OperacionClienteVO;
import pe.com.microdata.cjava.service.gestionar_listas.GestionarListas;
import pe.com.microdata.cjava.service.operacion.acciones_operacion.ObtenerAccionesPorOperacion;

import pe.com.microdata.cjava.service.operacion.operacion.GestionarOpeAlumEInstruc;
import pe.com.microdata.cjava.service.operacion.operacion.dto.AsignarClienteDTO;
import pe.com.microdata.cjava.service.operacion.operacion.dto.OperacionAlumnoDTO;

/**
 *
 * @author meliMeli
 */
@Service("gestionarOpeAlumEInstruc")
public class GestionarOpeAlumEInstrucImpl implements GestionarOpeAlumEInstruc {

    @Autowired
    OperacionDAO operacionDAO;
    @Autowired
    OperacionClienteDAO operacionAlumnoDAO;
    @Autowired
    GestionarListas gestionarListas;
    @Autowired
   ClienteDAO alumnoDAO;
    @Autowired
    ArrendatarioDAO instructorDAO;
   
    @Autowired
    SubtipoDAO subtipoDAO;
   
    
    SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.FORMATO_FECHA);
    Calendar calendar = Calendar.getInstance();
    private Logger logger = Logger.getLogger(GestionarOpeAlumEInstrucImpl.class);

  


/*
    @Override
    public OperacionAlumnoDTO obtenerClienteActivoPorId(Integer idOperacionAlumno) {
        OperacionAlumnoDTO operacionAlumDTO = new OperacionAlumnoDTO();
        OperacionClienteVO operacionAlumVO = operacionAlumnoDAO.obtenerOpeAlumnoPorIdOpeAlumno(idOperacionAlumno);
        operacionAlumDTO.setIdOperacionAlumno(operacionAlumVO.getIdOpeAlumno());
        //  operacionAlumDTO.setAbandonoAlumno((operacionAlumVO.getAbandonoAlu()));
        //  operacionAlumDTO.setCertificadoAlumno(operacionAlumVO.getCertificadoAlu());
        operacionAlumDTO.setFechaAbandono(dateFormat.format(operacionAlumVO.getFechaAbandonoAlu()));
        operacionAlumDTO.setFechaInscripcion(dateFormat.format(operacionAlumVO.getFechaInscripcionAlu()));
        operacionAlumDTO.setMotivoAbandono(operacionAlumVO.getMotivoAbandonoAlu());
        operacionAlumDTO.setNotaFinal(operacionAlumVO.getNotaFinalAlu());
        operacionAlumDTO.setIdAlumno(operacionAlumVO.getIdAlumnoVO() != null ? operacionAlumVO.getIdAlumnoVO().getIdAlumno() : 0);
        operacionAlumDTO.setIdEstado(operacionAlumVO.getIdSubTipoEstadoVO() != null ? operacionAlumVO.getIdSubTipoEstadoVO().getIdSubTipo() : 0);
        operacionAlumDTO.setIdOperacion(operacionAlumVO.getIdOperacionVO() != null ? operacionAlumVO.getIdOpeAlumno() : 0);
        operacionAlumDTO.setIdRegistro(operacionAlumVO.getIdSubTipoRegVO() != null ? operacionAlumVO.getIdSubTipoRegVO().getIdSubTipo() : 0);
        return operacionAlumDTO;
    }

    @Override
    public List<OperacionAlumnoDTO> obtenerAlumnosPorIdOperacion(Integer idOperacion) {
        List<OperacionAlumnoDTO> opeAlumnoDTO = new ArrayList<OperacionAlumnoDTO>();
        //List<OperacionVO> lstAl = operacionDAO.obtenerAlumnosPorIdOperacion(idOperacion);
        OperacionDevVO listaAlumnoActivos = operacionDevDAO.obtenerOperacionConAlumnosPorIdOperacion(idOperacion);
        List<OperacionAlumnoDevVO> listaOpeAlu = listaAlumnoActivos.getListaAlumnoVO();
        for (OperacionAlumnoDevVO aluVO : listaOpeAlu) {
            OperacionAlumnoDTO asisDTO = new OperacionAlumnoDTO();
            PersonaVO perVO = aluVO.getAlumnoVO().getAlumnoPersonaVO();
            asisDTO.setIdOperacionAlumno(aluVO.getIdOperacionAlumno());
            asisDTO.setIdOperacion(aluVO.getOperacionAlumnoVO().getIdOperacion());
            asisDTO.setNombreCompleto(perVO.getPrimerApellidoPer() + " " + perVO.getSegundoApellidoPer() + " " + perVO.getNomPersona());
            asisDTO.setDocumento(perVO.getDocumentoPer());
            //  asisDTO.setIdOperacionAlumno(aluVO.getIdOperacionAlumno());
            opeAlumnoDTO.add(asisDTO);
        }
        return opeAlumnoDTO;
    }

    @Override
    public AsignarClienteDTO obtenerClientePorIdOperacion(Integer idOperacion) {        
        AsignarClienteDTO dto = new AsignarClienteDTO();
        List<OperacionAlumnoDTO> opeAlumnoDTO = new ArrayList<OperacionAlumnoDTO>();        
        OperacionVO listaClienteActivos = operacionDevDAO.obtenerOperacionConAlumnosPorIdOperacion(idOperacion);
        
        ObtenerAccionesPorOperacion accOper = new ObtenerAccionesPorOperacion();
        accOper.obtenerAccionesSegunEstadoPorOperacion(listaClienteActivos, ObtenerAccionesPorOperacion.INTERFACE_ASIGNACION_ALUMNOS, dto);
        
        List<OperacionClienteDevVO> listaOpeAlu = listaClienteActivos.getListaAlumnoVO();
        for (OperacionClienteDevVO aluVO : listaOpeAlu) {
            OperacionAlumnoDTO asisDTO = new OperacionAlumnoDTO();
            PersonaVO perVO = aluVO.getAlumnoVO().getAlumnoPersonaVO();
            asisDTO.setIdOperacionAlumno(aluVO.getIdOperacionAlumno());
            asisDTO.setIdOperacion(aluVO.getOperacionAlumnoVO().getIdOperacion());
            asisDTO.setNombreCompleto(perVO.getPrimerApellidoPer() + " " + perVO.getSegundoApellidoPer() + " " + perVO.getNomPersona());
            asisDTO.setDocumento(perVO.getDocumentoPer());
            asisDTO.setCantFotos(aluVO.getCantFoto());
            opeAlumnoDTO.add(asisDTO);
        }
        dto.setLstAlumnos(opeAlumnoDTO);
        return dto;
    }
        
 
    
    
    @Override
    public List<OperacionAlumnoDTO> obtenerAlumnosOperacionPorBusqueda(BusquedaDTO busquedaDTO) {
        List<OperacionAlumnoDTO> opeAlumnoDTO = new ArrayList<OperacionAlumnoDTO>();
        List<OperacionClienteVO> lstAl = operacionAlumnoDAO.obtenerOpeAlumnoPorBusqueda(busquedaDTO);
        ClienteVO alumnosVO;
        for (OperacionClienteVO alumnoOperacVO : lstAl) {
            OperacionAlumnoDTO alumnoOpeDTO = new OperacionAlumnoDTO();
            
            alumnoOpeDTO.setNombreCompleto(alumnoOperacVO.getIdAlumnoVO().getAlumnoPersonaVO().getNomPersona() + "" + alumnoOperacVO.getIdAlumnoVO().getAlumnoPersonaVO().getPrimerApellidoPer() + "" + alumnoOperacVO.getIdAlumnoVO().getAlumnoPersonaVO().getSegundoApellidoPer());
            alumnoOpeDTO.setDocumento(alumnoOperacVO.getIdAlumnoVO().getAlumnoPersonaVO().getDocumentoPer());
            opeAlumnoDTO.add(alumnoOpeDTO);
        }
        return opeAlumnoDTO;
    }

    @Override
    public Long obtenerTotalAlumnosOpePorBusqueda(BusquedaDTO busquedaDTO) {
        Long total = operacionAlumnoDAO.obtenerTotalOpeAlumnosPorBusqueda(busquedaDTO);
        return total;
    }

    @Override
    public SIGAMessage eliminarOperacionAlumno(Integer idOper, Integer idOpeAlum) {
        SIGAMessage msg = new SIGAMessage();
        msg.setSuccess(Boolean.FALSE);
        try {
            OperacionAlumnoVO operacionAlumVO = operacionAlumnoDAO.obtenerOpeAlumnoPorIdOpeAlumno(idOpeAlum);
            OperacionVO oper = operacionDAO.obtenerOperacionConTipoPorIdOperacion(idOper);
            if (oper.getIdEstadoVO().getNomSubtipo().equals(Constants.SUBTIPO_NOM_ESTADO_OPE_ALU_ACTIVO)) {
                List<AsistenciaDevVO> listAsis = asistenciaDevDAO.obtenerListaAsistenciaPorIdOpeAlum(idOpeAlum);
                for (int i = 0; i < listAsis.size(); i++) {
                    AsistenciaDevVO asisVO = listAsis.get(i);
                    asistenciaDevDAO.delete(asisVO);
                }
            }
            if (operacionAlumVO.getIdOperacionVO().getIdOperacion().intValue() == idOper) {
                operacionAlumnoDAO.delete(operacionAlumVO);
                gestionarDetalleOperacion.disminuirCantidadAlumnoEn1PorIdOperacion(idOper);
            }
            msg.setSuccess(Boolean.TRUE);
        } catch (Exception ex) {
            ex.printStackTrace();
            msg.setSuccess(Boolean.FALSE);
            //Logger.getLogger(GestionarAlumnoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }

    
*/
}
