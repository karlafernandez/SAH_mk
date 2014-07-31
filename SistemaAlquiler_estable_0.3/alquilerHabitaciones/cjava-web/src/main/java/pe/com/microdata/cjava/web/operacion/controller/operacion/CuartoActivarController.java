/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.operacion.controller.operacion;

import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.service.administracion.curso.cuarto.GestionarCursoEspecifico;
import pe.com.microdata.cjava.service.gestionar_listas.GestionarListas;
import pe.com.microdata.cjava.service.operacion.operacion.GestionarOperacion;
import pe.com.microdata.cjava.service.operacion.operacion.dto.ItemOperacionDTO;
import pe.com.microdata.cjava.service.operacion.operacion.dto.OperacionActivoDTO;
import pe.com.microdata.cjava.service.operacion.operacion.validador.OperacionActivoValidator;
import pe.com.microdata.cjava.web.base.BaseController;

@Controller
@RequestMapping("/activar-cuarto")
public class CuartoActivarController extends BaseController {

    private static final String NOREDIRECCIONAR = "activar-cuarto";
    private static final String REDIRECCIONAR = "redirect:/lista-curso-operacion.html";
    
    private static final String MODEL_TIPO_TURNO = "lstTurno";
    private static final String MODEL_LISTA_EMPRESA = "lstEmpresa";    
    private static final String MODEL_OPERACION_ACTIVAR = "opeAct";
       
    @Autowired
    GestionarOperacion gestionarOperacion;
    @Autowired
    GestionarListas gestionarListas;   
    @Autowired
    GestionarCursoEspecifico gestionarCursoEspecifico;
    @Autowired
    OperacionActivoValidator operacionActivoValidator;
        
    private static Logger logger = Logger.getLogger(CuartoActivarController.class.getName());
    
    @ModelAttribute(MODEL_OPERACION_ACTIVAR)
    public OperacionActivoDTO model(Model model) {
        return new OperacionActivoDTO();
    }
    
    @ModelAttribute(MODEL_TIPO_TURNO)
    public List modelTipoTurno(Model model) {        
        return gestionarListas.obtenerSubTiposPorTipo(Constants.TIPO_TURNO);
    }
        
  
        
    @RequestMapping(method = RequestMethod.GET)
    public String vista(Model model, HttpSession session, HttpServletRequest request) {
        initMensaje(request);        
        return NOREDIRECCIONAR;
    }
  
    @RequestMapping(method = RequestMethod.POST)
    public String registrarOperacion(@Valid @ModelAttribute(MODEL_OPERACION_ACTIVAR) OperacionActivoDTO opeActDTO, 
        BindingResult result, SessionStatus status, HttpServletRequest request,
            ModelMap model, HttpSession session){
        String view = NOREDIRECCIONAR;
        SIGAMessage m = new SIGAMessage();
        m.setSuccess(Boolean.FALSE);
        
        operacionActivoValidator.validate(opeActDTO, result);
        if(!result.hasErrors()){
//            m = gestionarOperacion.activarCurso(opeActDTO);
            if (m.getSuccess()) {
                m.setMessageType(SIGAMessage.MessageType.SUCCESS);
                m.addMessages(getText("msg.curso_activar.registro_exito"));
                view =REDIRECCIONAR ;
            } else {
                m.setMessageType(SIGAMessage.MessageType.ERROR);
                m.setSuccess(false);
                m.addMessages(getText("msg.curso_activar.registro_error"));
                view = NOREDIRECCIONAR;
            }
        }else{
            model.addAttribute(MENSAJE_VAL, getText("msg.curso_activar.registro_error"));
        }
        request.getSession().setAttribute(MENSAJE, m);        
        return view;
    }
}
