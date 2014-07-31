/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.usuario;

import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.service.usuario.dto.CambiarClaveUsuarioDTO;
import pe.com.microdata.cjava.service.usuario.dto.RestaurarClaveDTO;

/**
 *
 * @author César Bragagnini
 */
public interface GestionarUsuario {
    
    public SIGAMessage cambiarClaveUsuario(CambiarClaveUsuarioDTO dto);
    public SIGAMessage restaurarContraseina(RestaurarClaveDTO dto);
}
