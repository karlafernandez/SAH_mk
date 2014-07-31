/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.cuartos;

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
import pe.com.microdata.cjava.service.administracion.curso.cuarto.GestionarCursoEspecifico;
import pe.com.microdata.cjava.service.administracion.curso.cuarto.dto.CuartoDTO;
import pe.com.microdata.cjava.service.administracion.curso.cuarto.validator.CuartoValidator;
import pe.com.microdata.cjava.web.base.BaseController;
 

@Controller
@RequestMapping("modificar-cuarto")
public class ModificarCuartoController extends BaseController {
    
    private static final String REDIRECCIONAR = "redirect:/modificar-cuarto.html";
    private static final String NOREDIRECCIONAR = "modificar-cuarto";
    private static final String DIRECCIONARLISTA = "redirect:/lista-curso-especifico.html";
    private static final String ID_CURSO_ESP = "idCursoEspecifico";
    private static final String MODEL_CURSO_ESP = "cursoEspecifico";
    
    @Autowired
    GestionarCursoEspecifico gestionarCursoEspecifico;
    
    @Autowired
    CuartoValidator cursoEspecificoValidador;
    
    @RequestMapping(method = RequestMethod.GET)
    public String vistaCursoEspecifico(Model model, HttpSession session, HttpServletRequest request){
        initMensaje(request);
        return NOREDIRECCIONAR;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String modificarCursoEspecifico(@ModelAttribute(MODEL_CURSO_ESP) CuartoDTO curEspDTO,
        BindingResult result, SessionStatus status, HttpServletRequest request,
        ModelMap model, HttpSession session){
//        String retorno = REDIRECCIONAR + "?" + ID_CURSO_ESP + "=" + curEspDTO.getIdCursoEspecifico();
        String retorno = NOREDIRECCIONAR;
        SIGAMessage m = new SIGAMessage();
        m.setSuccess(false);
        
        cursoEspecificoValidador.validate(curEspDTO, result);
        if(!result.hasErrors()){
            m = gestionarCursoEspecifico.modificarCursoEspecifico(curEspDTO);
            if(m.getSuccess()){
               m.setMessageType(SIGAMessage.MessageType.SUCCESS);
               m.addMessages(getText("msg.curesp.modificar_exito"));
               retorno = DIRECCIONARLISTA;
            }else{
               m.setMessageType(SIGAMessage.MessageType.ERROR);
               m.setSuccess(false);
               m.addMessages(getText("msg.curesp.modificar_error"));
               retorno = REDIRECCIONAR;
            }                
        }else{
            model.addAttribute(MENSAJE_VAL, getText("msg.curesp.modificar_error"));
        } 
        request.getSession().setAttribute(MENSAJE, m);
        return retorno;
    }
    
    @ModelAttribute(MODEL_CURSO_ESP)
    public CuartoDTO modelObtenerCursoEspecifico(Model model, 
        @RequestParam(value = ID_CURSO_ESP) Integer idCurEsp){
        return gestionarCursoEspecifico.obtenerCursoEspecificoPorId(idCurEsp);
    }
                         
}
