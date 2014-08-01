/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.microdata.cjava.service.registro.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.PersonaDAO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.PersonaVO;
import pe.com.microdata.cjava.service.acceso.dto.UsuarioSeguridadDTO;
import pe.com.microdata.cjava.service.base.dto.UserDetailsDTO;
import pe.com.microdata.cjava.service.registro.GestionarPersona;



@Service("gestionarPersona")
public class GestionarPersonaImpl implements GestionarPersona {

    private SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.FORMATO_FECHA);
    
    @Autowired
    PersonaDAO personaDAO;
    
    private String[] arrayMes = new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
            "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre"};
        
    @Override
    public UserDetailsDTO obtenerPersonaPorId(Integer idUsuario) {
    
        PersonaVO personaVO= personaDAO.get(idUsuario);
        UserDetailsDTO detailsDTO = new UserDetailsDTO();
        detailsDTO.setIdUsuario(idUsuario);
        detailsDTO.setNomNombre(personaVO.getNomPersona());
        detailsDTO.setNomApePaterno(personaVO.getPrimerApellidoPer());
        detailsDTO.setNomApeMaterno(personaVO.getSegundoApellidoPer());
        detailsDTO.setNomUsuario(personaVO.getUsuarioPersona());
        return detailsDTO;
        
    }

    @Override
    public List<UsuarioSeguridadDTO> obtenerSeguridadListaPersonaPorBusquedaYTipoUsuario(BusquedaDTO busquedaDTO, Integer tipoUser) {
        List<UsuarioSeguridadDTO> listaDTO = new ArrayList<UsuarioSeguridadDTO>();
        List<PersonaVO> listaVO = personaDAO.obtenerListaUsurioPorBusquedaYTipo(busquedaDTO, tipoUser);
        for(PersonaVO vo : listaVO ){
            UsuarioSeguridadDTO dto = new UsuarioSeguridadDTO();
            dto.setIdPersona(vo.getIdPersona());
            dto.setNombreCompleto(vo.getPrimerApellidoPer() + " " + vo.getSegundoApellidoPer() + " " + vo.getNomPersona());
            dto.setUsuario(vo.getUsuarioPersona());
            dto.setEstadoBloqueado(vo.getEstBloqueado());
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @Override
    public Long obtenerTotalSeguridadListaPersonaPorBusquedaYTipoUsuario(BusquedaDTO busquedaDTO, Integer tipoUser) {
        return personaDAO.obtenerTotalUsurioPorBusquedaYTipo(busquedaDTO, tipoUser);
    }

    @Override
    public SIGAMessage cambiarBloqueadoDesbloquead(UsuarioSeguridadDTO userDTO) {
        SIGAMessage message = new SIGAMessage();
        message.setSuccess(Boolean.FALSE);        
        try{
            PersonaVO vo = personaDAO.get(userDTO.getIdPersona());
            if(vo != null){
                vo.setEstBloqueado(userDTO.getEstadoBloqueado());
                personaDAO.saveOrUpdate(vo);
                message.setSuccess(Boolean.TRUE);                        
            }            
            message.setSuccess(Boolean.TRUE);
        }catch(Exception e){
            e.printStackTrace();
            message.setSuccess(Boolean.FALSE);
        }
        return message;  
    }

    @Override
    public UsuarioSeguridadDTO obtenerUsuarioPorId(Integer idPersona) {
        PersonaVO vo = personaDAO.obtenerPersonaPorId(idPersona);
        UsuarioSeguridadDTO dto = new UsuarioSeguridadDTO();
        dto.setIdPersona(vo.getIdPersona());
        dto.setNombreCompleto(vo.getPrimerApellidoPer() + " " + vo.getSegundoApellidoPer() + " " + vo.getNomPersona());
        dto.setUsuario(vo.getUsuarioPersona());
        dto.setEstadoBloqueado(vo.getEstBloqueado());
        return dto;                                
    }

   
                      
}
