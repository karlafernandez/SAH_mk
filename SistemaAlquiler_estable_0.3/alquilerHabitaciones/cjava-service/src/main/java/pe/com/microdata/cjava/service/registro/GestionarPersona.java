/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.microdata.cjava.service.registro;

import java.util.List;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.service.acceso.dto.UsuarioSeguridadDTO;
import pe.com.microdata.cjava.service.base.dto.UserDetailsDTO;


public interface GestionarPersona { 
    
    public UserDetailsDTO obtenerPersonaPorId(Integer idUsuario);
    public List<UsuarioSeguridadDTO> obtenerSeguridadListaPersonaPorBusquedaYTipoUsuario(BusquedaDTO busquedaDTO, Integer tipoUser );
    public Long obtenerTotalSeguridadListaPersonaPorBusquedaYTipoUsuario(BusquedaDTO busquedaDTO, Integer tipoUser );
    public SIGAMessage cambiarBloqueadoDesbloquead(UsuarioSeguridadDTO userDTO);
    public UsuarioSeguridadDTO obtenerUsuarioPorId(Integer idPersona);
   
}
