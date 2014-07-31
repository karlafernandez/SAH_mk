/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.operacion.controller.operacion;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.service.operacion.operacion.GestionarOperacion;
import pe.com.microdata.cjava.service.operacion.operacion.dto.AperturaDTO;
import pe.com.microdata.cjava.service.operacion.operacion.dto.OperacionDTO;
import pe.com.microdata.cjava.service.operacion.operacion.validador.OperacionEditarValidator;
import pe.com.microdata.cjava.web.base.BaseController;


@Controller
@RequestMapping("editar-fecha-operacion")
public class EditarOperacionController extends BaseController{
    
    private static final String NO_REDIRECIONAR = "editar-fecha-operacion";
    private static final String REDIRECCIONAR = "redirect:/detalle-curso-apertura.html?idOperacion=";
    private static final String PARAM_ID_OPERACION = "idOperacion";
    private static final String MODEL_POSIBLE_CAMBIAR = "esPosibleCambiar";
    private static final String MODEL_OPERACION = "operacion";
    
    @Autowired
    GestionarOperacion gestionarOperacion;
    @Autowired
    OperacionEditarValidator operacionEditarValidator;
    
    @RequestMapping(method = RequestMethod.GET)
    public String vista(Model model, HttpServletRequest request, HttpSession session){
        initMensaje(request);
        return NO_REDIRECIONAR;                
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String modificarFechaOperacion(@Valid @ModelAttribute(MODEL_OPERACION) AperturaDTO dto, 
        BindingResult result, SessionStatus status, HttpServletRequest request,
        ModelMap model, HttpSession session){        
        String retorno = NO_REDIRECIONAR;
        SIGAMessage m = new SIGAMessage();
        operacionEditarValidator.validate(dto, result);
        if(!result.hasErrors()){
   //         m = gestionarOperacion.modificarFechaOperacion(dto);
            if(m.getSuccess()){
                m.setMessageType(SIGAMessage.MessageType.SUCCESS);
                m.addMessages(getText("msg.opecion.fecha.editar_exito"));
                retorno = REDIRECCIONAR + dto.getIdOperacion() ;
            }else{
                m.setMessageType(SIGAMessage.MessageType.SUCCESS);
                m.addMessages(getText("msg.operacion.fecha.editar_error"));
                retorno = NO_REDIRECIONAR ;
            }
        }else{
            model.addAttribute(MENSAJE_VAL, getText("msg.operacion.fecha.editar_error"));
        }
        request.getSession().setAttribute(MENSAJE, m);                
        return retorno;        
    }
    /*
    @ModelAttribute(MODEL_OPERACION)
    public AperturaDTO obtenerOperacion(@RequestParam(value = PARAM_ID_OPERACION) Integer idOperacion,
        Model model){
        OperacionDTO operacionDTO = gestionarOperacion.obtenerOperacionActivaPorId(idOperacion);
        AperturaDTO dto = new AperturaDTO();
        dto.setIdOperacion(operacionDTO.getIdOperacion());
        dto.setCodOperacion(operacionDTO.getCodigoOpe());
        dto.setNombreCurso(operacionDTO.getNombreCurso());
        dto.setFechaInicio(operacionDTO.getFechaInicio());
        dto.setFechaFin(operacionDTO.getFechaFin());
        dto.setFueraPermisoVista(operacionDTO.getIdEstado() != Constants.SUBTIPO_ESTADO_OPE_ALU_APERTURA ? Boolean.TRUE : Boolean.FALSE);
        dto.setMotivoVista(dto.getFueraPermisoVista() ? " Solo se puede editar la fecha de inicio y fin cuando el curso esta aperturado " : "");
        model.addAttribute(MODEL_POSIBLE_CAMBIAR, gestionarOperacion.obtenerEstados(idOperacion).getEstSesiones());
        return dto;
    }
    */
}
