/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.accesos.controller;

import java.util.logging.Logger;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.service.acceso.dto.UsuarioSeguridadDTO;
import pe.com.microdata.cjava.service.acceso.validador.BloquearAlumnoValidador;
import pe.com.microdata.cjava.service.registro.GestionarPersona;
import pe.com.microdata.cjava.web.base.BaseController;


@Controller
@RequestMapping("bloquear-alumno")
public class BloquearAlumnoController extends BaseController {
    
    private static final String REDIRECCIONAR = "redirect:/bloasdquear-alumno.html";
    private static final String NOREDIRECCIONAR = "bloquear-alumno";
    private static final String DIRECCIONARLISTA = "redirect:/listar_adm_alumno.html";
    private static final String ID_PERSONA = "idPersona";
    private static final String MODEL_ALUMNO = "alumno";

    @Autowired
    GestionarPersona gestionarPersona;
    
    @Autowired
    BloquearAlumnoValidador bloquearAlumnoValidador;
      
    @RequestMapping(method = RequestMethod.GET)
    public String vistaUsuarioSeguridad(Model model, HttpSession session, HttpServletRequest request){
        initMensaje(request);    
        return NOREDIRECCIONAR;        
    }
              
    @RequestMapping(method = RequestMethod.POST)
    public String modificarCursoEspecifico(@ModelAttribute(MODEL_ALUMNO) UsuarioSeguridadDTO userSegDTO,
        BindingResult result, SessionStatus status, HttpServletRequest request,
        ModelMap model, HttpSession session){
        String retorno = NOREDIRECCIONAR;
        SIGAMessage m = new SIGAMessage();
        m.setSuccess(false);
        
        bloquearAlumnoValidador.validate(userSegDTO, result);
        if(!result.hasErrors()){
            m = gestionarPersona.cambiarBloqueadoDesbloquead(userSegDTO);
            if(m.getSuccess()){
               m.setMessageType(SIGAMessage.MessageType.SUCCESS);
               m.addMessages(getText("msg.segu.alum_modificar_exito"));
               retorno = DIRECCIONARLISTA;
            }else{
               m.setMessageType(SIGAMessage.MessageType.ERROR);
               m.setSuccess(false);
               m.addMessages(getText("msg.segu.alum_modificar_error"));
               retorno = REDIRECCIONAR;
            }                
        }else{
            model.addAttribute(MENSAJE_VAL, getText("msg.segu.alum_modificar_error"));
        } 
        request.getSession().setAttribute(MENSAJE, m);
        return retorno;
    }

    @ModelAttribute(MODEL_ALUMNO)
    public UsuarioSeguridadDTO modelObtenerCursoEspecifico(Model model, 
        @RequestParam(value = ID_PERSONA) Integer idPersona){        
        UsuarioSeguridadDTO dto = gestionarPersona.obtenerUsuarioPorId(idPersona);        
        return  gestionarPersona.obtenerUsuarioPorId(idPersona);                
    }
    
}
    