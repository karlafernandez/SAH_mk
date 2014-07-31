/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.registro.controller.arrendatarios;

import java.util.List;
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
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.common.base.Grid;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.web.base.BaseController;
import pe.com.microdata.cjava.service.registro.GestionarInstructor;
import pe.com.microdata.cjava.service.ubigeo.GestionarUbigeo;

/**
 *
 * @author meliMeli
 */
@Controller
@RequestMapping("/listarArrendatarios")
public class ArrendatarioListaController extends BaseController {

    private static final String NOREDIRECCIONAR = "listarInstructores";
    private static final String REDIRECCIONAR = "redirect:/listarInstructores.html";
    private static final String GRILLA = "grilla";
    private static final String MODEL_FILTRO = "busquedaDTO";
    private static final String ID_INSTRUCTOR = "idInstructor";
    
    @Autowired
    GestionarUbigeo gestionarUbigeo;
    
    @Autowired
    GestionarInstructor gestionarInstructor;

 
     @ModelAttribute(MODEL_FILTRO)
    public BusquedaDTO modeloFiltro(Model model) {
        BusquedaDTO busquedaDTO = new BusquedaDTO(1, Constants.CANT_FILAS);
        return busquedaDTO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String vista(ModelMap model) {
        BusquedaDTO dto = (BusquedaDTO) model.get(MODEL_FILTRO);
        model.addAttribute(GRILLA, lanzarBusqueda(dto));
        return NOREDIRECCIONAR;
    }

    @RequestMapping(params = "buscar", method = RequestMethod.POST)
    public String buscar(@Valid @ModelAttribute(MODEL_FILTRO) BusquedaDTO busquedaDTO,
            BindingResult result, SessionStatus status, HttpServletRequest request,
            ModelMap model, HttpSession session) {
        model.addAttribute(MODEL_FILTRO, busquedaDTO);
        model.addAttribute(GRILLA, lanzarBusqueda(busquedaDTO));
        return NOREDIRECCIONAR;

    }

    @RequestMapping(params = "eliminar", method = RequestMethod.GET)
    public String eliminar(@RequestParam(ID_INSTRUCTOR) Integer idInstructor, HttpServletRequest request, HttpSession session) {
        SIGAMessage messageDTO = new SIGAMessage();
        gestionarInstructor.eliminarInstructor(idInstructor);
        messageDTO.setSuccess(Boolean.TRUE);
        messageDTO.setMessageType(SIGAMessage.MessageType.SUCCESS);
        messageDTO.addMessages(getText("msg.usuario.eliminar"));
        session.setAttribute(MENSAJE, messageDTO);
        return REDIRECCIONAR;
    }

    private Grid lanzarBusqueda(BusquedaDTO busquedaDTO) {
        Grid grillaDTO = new Grid();
        List lstInstructor = gestionarInstructor.obtenerInstructorPorBusqueda(busquedaDTO);
            
        Long total = gestionarInstructor.obtenerTotalInstructoresPorBusqueda(busquedaDTO);
            

        grillaDTO.setRows(lstInstructor);
        grillaDTO.setPage(busquedaDTO.getInicio());
        grillaDTO.setTotal(total.intValue());
        grillaDTO.setPagination(Constants.CANT_FILAS);


        return grillaDTO;

    }
}
