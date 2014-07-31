package pe.com.microdata.cjava.web.operacion.controller.operacion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package pe.com.microdata.cjava.web.operacion.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.batch.core.JobParametersBuilder;
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
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.service.operacion.operacion.GestionarOperacion;
import pe.com.microdata.cjava.service.operacion.operacion.dto.AperturaDTO;
import pe.com.microdata.cjava.web.base.BaseController;
import pe.com.microdata.cjava.service.operacion.operacion.dto.EstadosDTO;
import pe.com.microdata.cjava.service.operacion.operacion.dto.OperacionDTO;

/**
 *
 * @author meliMeli
 */
@Controller
@RequestMapping("/detalle-cuarto-apertura")
public class CursoAperturaController extends BaseController {

    private static final String NOREDIRECCIONAR = "detalle-cuarto-apertura";
    private static final String REDIRECCIONAR = "redirect:/lista-curso-operacion.html";
    private static final String MENSAJE = "mensaje";
    private static final String APERTURA = "apertura";
    private static final String ESTADOS = "estados";
    private static final String DETALLE = "detalle";
    private static final String DETALLE_NOM = "detallenom";
    private static final String ID_OPERACION = "idOperacion";
    private static final String MODEL_ESTADO = "estOpe";
    public static final String METODO_INICAR_CURSO = "guardar";
    public static final String METODO_FINALIZAR_CURSO = "guardar";
    public static final String DESACTIVAR_BOTON = "disable=\"true\"";
    public static final String ACTIVAR_BOTON = "";
    @Autowired
    GestionarOperacion gestionarOperacion;
    private Logger logger = Logger.getLogger(CursoAperturaController.class.getName());

    @ModelAttribute(ESTADOS)
    public EstadosDTO modelEstados(Model model) {
        EstadosDTO estadoDTO = new EstadosDTO();
        return estadoDTO;
    }

//    
//        @ModelAttribute(DETALLE_NOM)
//    public OperacionDTO model(@RequestParam(value = ID_OPERACION, required = false) Integer idOperacion, 
//                                Model model, HttpServletRequest request) {
//      
//        // OperacionDTO asisDTO = gestionarOperacionExt.obtenerOperacionActivaPorId(idOperacion);
//            
//         return asisDTO;
//        
//    }
    @ModelAttribute(DETALLE)
    public AperturaDTO modelApertura(Model model) {
        return new AperturaDTO();
    }

    /*
    @ModelAttribute(APERTURA)
    public AperturaDTO model(@RequestParam(value = ID_OPERACION, required = false) Integer idOperacion,
            Model model, HttpServletRequest request) {

        OperacionDTO oper = gestionarOperacion.obtenerOperacionActivaPorId(idOperacion);
        AperturaDTO adto = new AperturaDTO();
        try {
            adto.setIdOperacion(idOperacion);
            adto.setNombreCurso(oper.getNombreCurso());
            adto.setCodOperacion(oper.getCodigoOpe());
            adto.setFechaInicio(oper.getFechaInicio());
            adto.setFechaFin(oper.getFechaFin());
            adto.setEditarFecha(oper.getEditarFecha());
            adto.setNumHora(oper.getNumHora());
            adto.setNumSesion(oper.getNumSesion());
            adto.setNomSalon(oper.getNomSalon());
            adto.setEstadoCurso(oper.getTipoCurso());
            adto.setTerminoUltimaClase(oper.getTerminoUltimaClase());
            adto.setPoderModificar(oper.getPoderModificar());
            adto.setDiasCierre(oper.getDiasCierre());
            adto.setTerminoUltimaClase(oper.getTerminoUltimaClase());
            adto.setPaso21DiasYActivo(oper.getPaso21DiasYActivo());
            adto.setPoderCerrar(oper.getPoderCerrar());
            adto.setCursoFinalizado(oper.getCursoFinalizado());
            adto.setPaso7Dias(oper.getPaso7Dias());
            EstadosDTO estadosDTO = gestionarOperacion.obtenerEstados(idOperacion);
            adto.setActivarCurso(estadosDTO.getEstAlumnos() && estadosDTO.getEstInstructores() && estadosDTO.getEstCalificaciones() && estadosDTO.getEstSesiones());
            model.addAttribute(MODEL_ESTADO, estadosDTO);
        } catch (Exception e) {
        }
        return adto;
    }*/

    @RequestMapping(method = RequestMethod.GET)
    public String vista(Model model, HttpServletRequest request) {
        return NOREDIRECCIONAR;
    }


    @RequestMapping(params = "guardar", method = RequestMethod.POST)
    public String generarApertura(@ModelAttribute(APERTURA) AperturaDTO aperturaDTO,
            HttpServletRequest request, HttpSession session, ModelMap model, BindingResult result) {

        String view = NOREDIRECCIONAR;
        SIGAMessage m = new SIGAMessage();
        m.setSuccess(false);

    //    m = gestionarOperacion.cambiarDeAperturaAactivo(aperturaDTO);
        if (m.getSuccess()) {
            m.setMessageType(SIGAMessage.MessageType.SUCCESS);
            m.addMessages(getText("msg.curso.de.apertura.a.activo"));
            view = REDIRECCIONAR;
            request.getSession().setAttribute(MENSAJE, m);
        } else {
            m.setMessageType(SIGAMessage.MessageType.ERROR);
            m.setSuccess(false);
            m.addMessages(getText("msg.curso.de.apertura.a.activo.error"));
            model.addAttribute(MENSAJE, m);
        }
        request.getSession().setAttribute(MENSAJE, m);

//                m.setMessageType(SIGAMessage.MessageType.SUCCESS);
//                m.addMessages("El curso se activo correctamente");
//                session.setAttribute(MENSAJE, m);
        return view;
    }

    @RequestMapping(params = "cerrarOpe", method = RequestMethod.POST)
    public String cerrarCurso(@ModelAttribute(APERTURA) AperturaDTO aperturaDTO,
            HttpServletRequest request, HttpSession session, ModelMap model, BindingResult result) {

        String view = NOREDIRECCIONAR;
        SIGAMessage m = new SIGAMessage();
        m.setSuccess(false);

   //     m = gestionarOperacion.cerrarOperacionPorIdOperacion(aperturaDTO.getIdOperacion());
        if (m.getSuccess()) {
            m.setMessageType(SIGAMessage.MessageType.SUCCESS);
            m.addMessages(getText("msg.curso.de.activo.a.cierre"));
            view = REDIRECCIONAR;
            request.getSession().setAttribute(MENSAJE, m);
        } else {
            m.setMessageType(SIGAMessage.MessageType.ERROR);
            m.setSuccess(false);
            m.addMessages(getText("msg.curso.de.activo.a.cierre.error"));
            model.addAttribute(MENSAJE, m);
        }
        request.getSession().setAttribute(MENSAJE, m);
        return view;
    }
}
