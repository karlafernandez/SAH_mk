/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.usuario.controller.administracion.administrador;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.service.administracion.administrador.GestionarAdministrador;
import pe.com.microdata.cjava.service.administracion.administrador.dto.AdministradorDTO;
import pe.com.microdata.cjava.service.administracion.administrador.validador.RegistrarAdministradorValidador;
import pe.com.microdata.cjava.service.gestionar_listas.GestionarListas;
import pe.com.microdata.cjava.web.base.BaseController;


@Controller
@RequestMapping("registrar-administrador")
public class RegistrarAdministradorController extends BaseController{
    
    private static final String NO_REDIRECCIONAR = "registrar-administrador";    
    private static final String DIRECCIONAR_LISTA = "redirect:/listar-administrador.html";    
    private static final String MODEL_ADMIN = "modAdmin";
    private static final String MODEL_LISTA_TIPO_DOCUMENTO = "lstTipoDocumento";
    
    @Autowired
    GestionarAdministrador gestionarAdministrador;
    @Autowired
    RegistrarAdministradorValidador registrarAdministradorValidador;
    @Autowired
    GestionarListas gestionarListas;
           
    @RequestMapping(method = RequestMethod.GET)
    public String vista(Model model, HttpServletRequest request, HttpSession session ){
        initMensaje(request);
        model.addAttribute(MODEL_ADMIN, new AdministradorDTO());
        return NO_REDIRECCIONAR;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String registrarAdministrador(@ModelAttribute(MODEL_ADMIN) AdministradorDTO adminDTO,
        BindingResult result, SessionStatus status, HttpServletRequest request,
        ModelMap model, HttpSession session){
        
        String retorno = NO_REDIRECCIONAR;
        SIGAMessage m = new SIGAMessage();
        m.setSuccess(Boolean.FALSE);
        registrarAdministradorValidador.validate(adminDTO, result);
        
        if(!result.hasErrors()){
            m = gestionarAdministrador.registrarAdministrador(adminDTO);
            if(m.getSuccess()){
                m.setMessageType(SIGAMessage.MessageType.SUCCESS);
                m.addMessages(getText("msg.admin.registrar_exito"));
                retorno = DIRECCIONAR_LISTA;                
            }else{
                m.setMessageType(SIGAMessage.MessageType.ERROR);
                m.setSuccess(false);
                m.addMessages(getText("msg.admin.registrar_error"));
                retorno = NO_REDIRECCIONAR;                
            }
        }else
            model.addAttribute(MENSAJE_VAL, getText("msg.admin.registrar_error"));
        request.getSession().setAttribute(MENSAJE, m);
        
        return retorno;
    }
    
    @ModelAttribute(MODEL_LISTA_TIPO_DOCUMENTO)
    public List modelTipoDocumento(Model model) {    
        return gestionarListas.obtenerSubTiposPorTipo(1);
    }
    
}
