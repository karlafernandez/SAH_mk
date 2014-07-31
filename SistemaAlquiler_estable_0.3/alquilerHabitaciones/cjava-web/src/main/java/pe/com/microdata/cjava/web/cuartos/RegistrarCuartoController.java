/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.cuartos;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.service.administracion.curso.cuarto.GestionarCursoEspecifico;
import pe.com.microdata.cjava.service.administracion.curso.cuarto.dto.CuartoDTO;
import pe.com.microdata.cjava.service.administracion.curso.cuarto.validator.CuartoValidator;
import pe.com.microdata.cjava.web.base.BaseController;
 



@Controller
@RequestMapping("/registrar-cuarto")
public class RegistrarCuartoController extends BaseController{
    
    private static final String REDIRECCIONAR = "redirect:/lista-curso-especifico.html";
    private static final String NOREDIRECCIONAR = "registrar-cuarto";
    private static final String CURSO_ESPECIFICO = "curso-especifico";
    
    
    @Autowired
    GestionarCursoEspecifico gestionarCursoEsp;
    
    @Autowired
    CuartoValidator cursoEspValidador;
    
    @ModelAttribute(CURSO_ESPECIFICO)
    public CuartoDTO model(){
        return new CuartoDTO();        
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String vista(Model model){
        return NOREDIRECCIONAR;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String registrar(@Valid @ModelAttribute(CURSO_ESPECIFICO) CuartoDTO cursoDTO,  
            HttpServletRequest request, BindingResult result){
        
        String view = NOREDIRECCIONAR;
        SIGAMessage m = new SIGAMessage();
        
        cursoDTO.setDireccion(cursoDTO.getDireccion().toUpperCase());
        
        cursoEspValidador.validate(cursoDTO, result);
        if(!result.hasErrors()){
            m = gestionarCursoEsp.registrarCursoEspecifico(cursoDTO);
            if(m.getSuccess()){
                m.setMessageType(SIGAMessage.MessageType.SUCCESS);
                m.addMessages(getText("msg.curesp.registrar_exito"));
                view = REDIRECCIONAR;
            }else{
                m.setMessageType(SIGAMessage.MessageType.ERROR);
                m.setSuccess(false);
                m.addMessages(getText("msg.curesp.registrar_error"));
                view = NOREDIRECCIONAR;
            }
        }
        request.getSession().setAttribute(MENSAJE, m);
        return view;
    } 
    
            
    
}
