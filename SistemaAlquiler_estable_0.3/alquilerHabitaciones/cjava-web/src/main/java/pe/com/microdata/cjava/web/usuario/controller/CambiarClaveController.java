/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.usuario.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.service.usuario.GestionarUsuario;
import pe.com.microdata.cjava.service.usuario.dto.CambiarClaveUsuarioDTO;
import pe.com.microdata.cjava.service.usuario.validador.CambiarClaveUsuarioValidador;
import pe.com.microdata.cjava.web.base.BaseController;


@Controller
@RequestMapping("cambiar-clave")
public class CambiarClaveController extends BaseController{
    
    private static final String NO_REDIRECCIONAR = "cambiar-clave";
    private static final String DIRECCIONAR = "redirect:/principal.html";
    private static final String MODEL_CAMBIAR_CLAVE_USUARIO = "modCamCont";
    
    @Autowired
    private GestionarUsuario gestionarUsuario;
    @Autowired
    private CambiarClaveUsuarioValidador cambiarClaveUsuarioValidador;
    
    @RequestMapping(method = RequestMethod.GET)
    public String vista(ModelMap model, HttpServletRequest request, HttpSession session){
        initMensaje(request);
        model.addAttribute(MODEL_CAMBIAR_CLAVE_USUARIO, new CambiarClaveUsuarioDTO());
        return NO_REDIRECCIONAR;
    }
    
     @RequestMapping(method = RequestMethod.POST)
    public String cambiarClaveUsuario(@Valid @ModelAttribute(MODEL_CAMBIAR_CLAVE_USUARIO) CambiarClaveUsuarioDTO usuarioDTO,
            HttpServletRequest request, BindingResult result) {
        
        String retorno = NO_REDIRECCIONAR;
        SIGAMessage m = new SIGAMessage();
        usuarioDTO.setIdPersona(this.getIdUsuario());
        usuarioDTO.setTipoUser(this.getDatosUsuario().getTipoUser());
                
        cambiarClaveUsuarioValidador.validate(usuarioDTO, result);
        if (!result.hasErrors()) {
            m = gestionarUsuario.cambiarClaveUsuario(usuarioDTO);
            if(m.getSuccess()){
                m.setMessageType(SIGAMessage.MessageType.SUCCESS);
                m.addMessages(getText("msg.cam.contra.cambiar_exito"));
                retorno = DIRECCIONAR;
            }else{
                m.setMessageType(SIGAMessage.MessageType.ERROR);
                m.addMessages(getText("msg.cam.contra.cambiar_error"));
            }
        } else {
            m.setMessageType(SIGAMessage.MessageType.ERROR);
            m.setSuccess(Boolean.FALSE);
            m.addMessages(getText("msg.cam.contra.cambiar_error"));
        }
        request.getSession().setAttribute(MENSAJE, m);
        return retorno;
    }
    
}
