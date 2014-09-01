/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.administracion.curso.cuarto.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.dataaccess.domain.administracion.cuarto.CuartoDAO;
import pe.com.microdata.cjava.dataaccess.model.administracion.curso.CuartoVO;
import pe.com.microdata.cjava.service.administracion.curso.cuarto.GestionarCursoEspecifico;
import pe.com.microdata.cjava.service.administracion.curso.cuarto.dto.CuartoDTO;



@Service("gestionarCursoEspecifico")
public class GestionarCuartoImpl implements GestionarCursoEspecifico{

    private SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.FORMATO_FECHA_HORA);        
    
    @Autowired
    CuartoDAO cuartoDAO;

    @Override
    public List obtenerListaCursoEspecifico() {       
        List<CuartoDTO> listaCursoEspDTO = new ArrayList<CuartoDTO>();
        List<CuartoVO> objs = cuartoDAO.getAll();
        for(CuartoVO cursoEspVO : objs){
            listaCursoEspDTO.add(convertirVOToDTO(cursoEspVO));                        
        }                
        return listaCursoEspDTO;
    }
/*
    @Override
    public List obtenerListaCursoEspecificoPorBusqueda(BusquedaDTO busquedaDTO) {
        List<CuartoDTO> listaCursoEspDTO = new ArrayList<CuartoDTO>();
        List<CuartoVO> objs = cuartoDAO.obtenerListaCuartoPorBusqueda(busquedaDTO);
        for(CuartoVO cursoEspVO : objs){
            listaCursoEspDTO.add(convertirVOToDTO(cursoEspVO));                        
        }          
        return listaCursoEspDTO;
    }            */                  
    
    @Override
    public SIGAMessage registrarCursoEspecifico(CuartoDTO dto) {
        SIGAMessage message = new SIGAMessage();
        message.setSuccess(Boolean.FALSE);
        try{            
            CuartoVO vo = new CuartoVO();
            
             vo.setNomenclaturaCuarto(dto.getNomenCuarto());
             vo.setNumAmbientes(dto.getNumAmbientes());
             vo.setDireccion(dto.getDireccion());
             vo.setDetalleUbicacion(dto.getDetalle());
             vo.setRestricciones(dto.getRestricciones());
             vo.setActCurEsp(Boolean.TRUE);  
             vo.setFecRegCur(Calendar.getInstance());
            
            cuartoDAO.insert(vo);
            
            message.setSuccess(Boolean.TRUE);
        }catch(Exception e){
            e.printStackTrace();
            message.setSuccess(Boolean.FALSE);
        }
        return message;
    }

    @Override
    public SIGAMessage eliminarCursoEspecifico(Integer idCursoEspecifico) {
        SIGAMessage message = new SIGAMessage();
        message.setSuccess(Boolean.FALSE);
        
        try{
            CuartoVO vo = cuartoDAO.get(idCursoEspecifico);
            vo.setActCurEsp(Boolean.FALSE);
            cuartoDAO.saveOrUpdate(vo); ;
            message.setSuccess(Boolean.TRUE);
        }catch(Exception e){
            e.printStackTrace();
            message.setSuccess(Boolean.FALSE);
        }
        return message;        
    }

    @Override
    public SIGAMessage modificarCursoEspecifico(CuartoDTO dto) {
        SIGAMessage message = new SIGAMessage();
        message.setSuccess(Boolean.FALSE);
        
        try{
            CuartoVO vo = cuartoDAO.get(dto.getIdCuarto());
            if(vo != null){
                vo.setNomenclaturaCuarto(dto.getNomenCuarto());
                vo.setNumAmbientes(dto.getNumAmbientes());
                vo.setDireccion(dto.getDireccion());
                vo.setDetalleUbicacion(dto.getDetalle());
                vo.setRestricciones(dto.getRestricciones());
                       
               
                cuartoDAO.saveOrUpdate(vo);
                message.setSuccess(Boolean.TRUE);                        
            }            
            message.setSuccess(Boolean.TRUE);
        }catch(Exception e){
            e.printStackTrace();
            message.setSuccess(Boolean.FALSE);
        }
        return message;  
    }

   /*
    @Override
    public CuartoDTO obtenerCursoEspecificoPorId(Integer idCursoEsp) {
        CuartoVO vo = cuartoDAO.obtenerCuartoPorId(idCursoEsp);
        return convertirVOToDTO(vo);
    }
    
    @Override
    public Long obtenerTotalListaCursoEspecificoPorBusqueda(BusquedaDTO busquedaDTO) {
        Long total = cuartoDAO.obtenerTotalCuartoPorBusqueda(busquedaDTO);
        return total;
    }
    */
    
    private CuartoDTO convertirVOToDTO(CuartoVO vo){
        CuartoDTO dto = new CuartoDTO();        
        dto.setIdCuarto(vo.getIdCuarto());
        dto.setDireccion(vo.getDireccion());
        dto.setNomenCuarto(vo.getNomenclaturaCuarto());
        dto.setDetalle(vo.getDetalleUbicacion());
        dto.setRestricciones(vo.getRestricciones());
        dto.setNumAmbientes(vo.getNumAmbientes());
   //     dto.setUbigeo(vo.getUbigeoCuartoVO());
        
                    
        return dto;
    }
                
}
