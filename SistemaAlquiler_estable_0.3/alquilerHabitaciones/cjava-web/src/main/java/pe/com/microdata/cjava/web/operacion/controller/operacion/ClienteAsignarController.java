/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.operacion.controller.operacion;

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
import org.springframework.web.bind.annotation.ResponseBody;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.service.gestionar_listas.GestionarListas;
import pe.com.microdata.cjava.service.operacion.operacion.GestionarOpeAlumEInstruc;
import pe.com.microdata.cjava.service.operacion.operacion.GestionarOperacion;
import pe.com.microdata.cjava.service.operacion.operacion.dto.AsignarClienteDTO;
import pe.com.microdata.cjava.service.operacion.operacion.dto.OperacionAlumnoDTO;
import pe.com.microdata.cjava.service.operacion.operacion.dto.OperacionDTO;
import pe.com.microdata.cjava.service.operacion.operacion_cliente.dto.AsignarAlumnoOperacionDTO;
import pe.com.microdata.cjava.service.operacion.operacion_cliente.validador.AsignarAlumnoValidador;
import pe.com.microdata.cjava.service.registro.GestionarCliente;
import pe.com.microdata.cjava.web.base.BaseController;

/**
 *
 * @author meliMeli
 */
@Controller
@RequestMapping("/asignar-cliente")
public class ClienteAsignarController extends BaseController {


    private static final String NOREDIRECCIONAR = "asignar-cliente";
    private static final String REDIRECCIONAR = "redirect:/asignar-alumno.html?idOperacion=";
    private static final String ASIGNAR_ALUMNO = "activarAlumno";
   
    private static final String ID_ALUMNO = "idAlumno";
    private static final String ID_ALUMNO_OPER = "idOperacionAlumno";
    private static final String ID_OPERACION = "idOperacion";
    private static final String CANT_FOTOS = "cantFotos";

    private static final String MODEL_FILTRO = "busquedaDTO";
    private static final String MODEL_ASIGNAR_ALUMNO = "asignarAlumno";

    @Autowired
    GestionarOperacion gestionarOperacion;
    @Autowired
    GestionarListas gestionarListas;
    @Autowired
    GestionarCliente gestionarCliente;
    @Autowired
    GestionarOpeAlumEInstruc gestionarOpeAlumEInstructor;
    @Autowired
    AsignarAlumnoValidador asignarAlumnoValidador;
    
    private Logger logger = Logger.getLogger(ClienteAsignarController.class.getSimpleName());
            
    @ModelAttribute(ASIGNAR_ALUMNO) // interfaz
    public OperacionAlumnoDTO model(@RequestParam(value = ID_OPERACION, required = false) Integer idOperacion, 
                                Model model, HttpServletRequest request) {
         OperacionAlumnoDTO adto = new OperacionAlumnoDTO();
         adto.setIdOperacion(idOperacion);
        return adto;
    }
        
    @ModelAttribute(ID_OPERACION)
    public OperacionDTO modelOperacion(@RequestParam(value = ID_OPERACION, required = false) Integer idOperacion, 
                                Model model, HttpServletRequest request) {
         OperacionDTO adto = new OperacionDTO();
         adto.setIdOperacion(idOperacion);
        return adto;
    }
  
    @ModelAttribute(MODEL_FILTRO)
    public BusquedaDTO modeloFiltro(Model model) {
        BusquedaDTO busquedaDTO = new BusquedaDTO(1, Constants.CANT_FILAS);
        return busquedaDTO;
    }
    
    /*
     @RequestMapping(method = RequestMethod.GET)
    public String vista(ModelMap model, HttpServletRequest request, @RequestParam(ID_OPERACION) Integer idOperacion) {
       AsignarClienteDTO dto = gestionarOpeAlumEInstructor.obtenerAlumnosPorIdOperacion(idOperacion);
       model.addAttribute(MODEL_ASIGNAR_ALUMNO, dto);
       initMensaje(request);
       return NOREDIRECCIONAR;
    }*/
            
         @RequestMapping(params = "activarAlumno", method = RequestMethod.POST)
    public @ResponseBody
   String obtenerAlumnos(@RequestParam(ID_OPERACION) Integer idOperacion,
                 @RequestParam(ID_ALUMNO) Integer idAlumno, @RequestParam(CANT_FOTOS) Integer cantFotos, 
        HttpServletRequest request, Model model) {
          model.addAttribute(ID_ALUMNO, idAlumno);
          model.addAttribute(ID_OPERACION, idOperacion);
          
          AsignarAlumnoOperacionDTO dto = new AsignarAlumnoOperacionDTO();
          dto.setIdAlumno(idAlumno);
          dto.setIdOperacion(idOperacion);
          dto.setCantFotos(cantFotos);
          
          SIGAMessage m = new SIGAMessage();
          m.setMessageType(SIGAMessage.MessageType.ERROR);
          m.addMessages(getText("msg.asig.alumno.registro_error"));          
                        
          if(validarAsignarAlumno(dto)){
          //    m = gestionarOpeAlumEInstructor.activarAlumno(dto);
              if(m.getSuccess()){
                m.setMessageType(SIGAMessage.MessageType.SUCCESS);
                m.addMessages(getText("msg.asig.alumno.registro_exito"));
              }
          }
          
          request.getSession().setAttribute(MENSAJE, m);
          return REDIRECCIONAR +idOperacion;
      }
  
    @RequestMapping(params = "eliminar", method = RequestMethod.POST)
    public
            String eliminar(
            @RequestParam(ID_OPERACION) Integer idOperacion, 
            @RequestParam(ID_ALUMNO_OPER) Integer idOperacionAlumno, 
            HttpServletRequest request, HttpSession session, Model model) {
        
        SIGAMessage messageDTO = new SIGAMessage();
  
        //gestionarOpeAlumEInstructor.eliminarOperacionAlumno(idOperacion, idOperacionAlumno);
        messageDTO.setSuccess(Boolean.TRUE);
        messageDTO.setMessageType(SIGAMessage.MessageType.SUCCESS);
        messageDTO.addMessages(getText("msg.usuario.eliminar"));
        session.setAttribute(MENSAJE, messageDTO);
        return REDIRECCIONAR + idOperacion;
    }  
 
    private boolean validarAsignarAlumno(AsignarAlumnoOperacionDTO dto){
        boolean result = true;
        result &= dto.getIdOperacion() != null && dto.getIdOperacion() > 0;
        result &= dto.getIdAlumno() != null && dto.getIdAlumno() > 0;
        result &= dto.getCantFotos() != null && dto.getCantFotos() >= 0;
        return result;
    }
    
}
