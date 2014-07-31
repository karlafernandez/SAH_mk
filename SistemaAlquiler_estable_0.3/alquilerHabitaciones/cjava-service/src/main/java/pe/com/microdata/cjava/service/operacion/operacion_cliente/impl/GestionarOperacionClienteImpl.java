/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.operacion.operacion_cliente.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.dataaccess.domain.operacion.operacion.OperacionClienteDAO;
import pe.com.microdata.cjava.dataaccess.domain.operacion.operacion.OperacionDAO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.PersonaVO;
import pe.com.microdata.cjava.dataaccess.model.operacion.alquilado.OperacionClienteVO;
import pe.com.microdata.cjava.dataaccess.model.operacion.alquilado.AlquilarVO;
import pe.com.microdata.cjava.service.operacion.operacion_cliente.GestionarOperacionCliente;
import pe.com.microdata.cjava.service.operacion.operacion_cliente.dto.EntregaFotoDTO;


@Service("gestionarOperacionAlumno")
public class GestionarOperacionClienteImpl implements GestionarOperacionCliente{

    private Map<Integer, Integer> mapActua = new HashMap<Integer, Integer>();
    
    @Autowired
    OperacionClienteDAO operacionAlumnoDAO;
    
    @Autowired
    OperacionDAO operacionDAO;
    
    /*
    @Override
    public void actualizarPorcentajeAsistenciaConJustificacion(Integer idOpeAlu, Integer totalSesiones, int cntJusti){
        
        OperacionClienteVO vo = operacionAlumnoDAO.get(idOpeAlu);        
        vo.setCantJustificacion(vo.getCantJustificacion() + cntJusti);
        vo.setCantFaltas(vo.getCantFaltas() - cntJusti);
        double cant = vo.getCantAsistencia() + vo.getCantJustificacion();
        vo.setPorFinAsisOpeAlu(100 * cant / (double) totalSesiones);                              
        operacionAlumnoDAO.saveOrUpdate(vo);
    }

    @Override
    public void modificarCantidadJustificaciones(Integer idOpeAlu, Integer cant, Integer totalSesiones) {
        OperacionClienteVO vo = operacionAlumnoDAO.get(idOpeAlu);
        float cantAsis = vo.getCantAsistencia() + vo.getCantJustificacion() + cant;
        vo.setCantJustificacion(vo.getCantJustificacion() + cant);
        vo.setPorFinAsisOpeAlu(cantAsis / (double) totalSesiones);
        operacionAlumnoDAO.saveOrUpdate(vo);
    }

    @Override
    public SIGAMessage entregaFoto(EntregaFotoDTO dto) {
        SIGAMessage m = new SIGAMessage();
        m.setSuccess(Boolean.FALSE);
        try{
            OperacionClienteVO vo = operacionAlumnoDAO.get(dto.getIdOpeAlum());
            vo.setCantFoto(dto.getNumFoto());
            operacionAlumnoDAO.saveOrUpdate(vo);                    
            m.setSuccess(Boolean.TRUE);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return m;
    }

    @Override
    public EntregaFotoDTO obtenerEntregaFoto(Integer idOpeAlu) {
        OperacionClienteVO vo = operacionAlumnoDAO.obtenerOpeAlumnoPorIdOpeAlumno(idOpeAlu);
        AlquilarVO opeVO = operacionDAO.obtenerOperacionPorId(vo.getIdOperacionVO().getIdOperacion());
        PersonaVO perVO = vo.getIdAlumnoVO().getAlumnoPersonaVO();
        EntregaFotoDTO dto = new EntregaFotoDTO();
        dto.setIdOpeAlum(idOpeAlu);
        dto.setIdOperacion(vo.getIdOperacionVO().getIdOperacion());
        dto.setCodOperacion(vo.getIdOperacionVO().getCodigoOperacion());
        dto.setNumFoto(vo.getCantFoto());
        dto.setNombreCurso(opeVO.getIdCursoEspVO().getNomCursoEspecifico());
        dto.setDocumento(perVO.getDocumentoPer());
        dto.setNombreAlum(perVO.getPrimerApellidoPer() + " " + perVO.getSegundoApellidoPer() + " " + perVO.getNomPersona());        
        return dto;
    }        

    @Override
    public void actualizarPorcentajeAsistencia(Integer idOpeAlu, Integer totalSesiones, Integer tipoAsisPrev, Integer tipoAsisNue) {
        actualizarMapaAsisten(tipoAsisPrev, tipoAsisNue);
        OperacionClienteVO vo = operacionAlumnoDAO.get(idOpeAlu);
        vo.setCantAsistencia(vo.getCantAsistencia() + mapActua.get(Constants.SUBTIPO_ASISTENCIA_ASISTIO));
        vo.setCantFaltas(vo.getCantFaltas() + mapActua.get(Constants.SUBTIPO_ASISTENCIA_FALTO));
        vo.setCantJustificacion(vo.getCantJustificacion() + mapActua.get(Constants.SUBTIPO_ASISTENCIA_JUSTIFICO));
        double cantAsis = vo.getCantAsistencia() + vo.getCantJustificacion();        
        vo.setPorFinAsisOpeAlu(100 * cantAsis / (double) totalSesiones);
        operacionAlumnoDAO.saveOrUpdate(vo);        
    }
          
    private void actualizarMapaAsisten(Integer tipoPrev, Integer tipoNuevo){
        mapActua.put(Constants.SUBTIPO_ASISTENCIA_ASISTIO, 0);
        mapActua.put(Constants.SUBTIPO_ASISTENCIA_FALTO, 0);
        mapActua.put(Constants.SUBTIPO_ASISTENCIA_JUSTIFICO, 0);
        mapActua.remove(tipoPrev);
        mapActua.put(tipoPrev, -1);
        mapActua.remove(tipoNuevo);
        mapActua.put(tipoNuevo, 1);        
    }
    */
}
