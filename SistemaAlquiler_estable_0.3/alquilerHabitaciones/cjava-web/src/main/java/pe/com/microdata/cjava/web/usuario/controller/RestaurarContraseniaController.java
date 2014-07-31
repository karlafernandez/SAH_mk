/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.usuario.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.common.validador.Validador;
import pe.com.microdata.cjava.service.usuario.GestionarUsuario;
import pe.com.microdata.cjava.service.usuario.dto.RestaurarClaveDTO;
import pe.com.microdata.cjava.web.base.BaseController;

/**
 *
 * @author 
 */
@Controller
@RequestMapping("restaurar-contrasenia")
public class RestaurarContraseniaController extends BaseController {

    private static final String NO_REDIRECCIONAR = "restaurar-contrasenia";
    
    @Autowired
    GestionarUsuario gestionarUsuario;

    @ModelAttribute("persona")
    public RestaurarClaveDTO model() {
        return new RestaurarClaveDTO();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String initForm(ModelMap model, HttpServletRequest request) {
        initMensaje(request);
        return NO_REDIRECCIONAR;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String enviar(ModelMap model, @ModelAttribute("persona") RestaurarClaveDTO persona) {
        SIGAMessage m = new SIGAMessage();        
        m.setMessageType(SIGAMessage.MessageType.ERROR);
        m.addMessages("User y/o correo inválido");
        m.setSuccess(Boolean.FALSE);
        
        if (esUsuarioValido(persona)) {
            m = gestionarUsuario.restaurarContraseina(persona);
        } 
        model.addAttribute(MENSAJE, m);
        return NO_REDIRECCIONAR;
    }

    private boolean esUsuarioValido(RestaurarClaveDTO usuarioDTO) {
        boolean valid = false;
        if (Validador.noNuloNoVacio(usuarioDTO.getNomUsuario()) && Validador.esEmail(usuarioDTO.getCorreo())) {
            valid = true;
        }
        return valid;
    }
}
