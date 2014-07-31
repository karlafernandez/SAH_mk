/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.cuartos;

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
import org.springframework.web.bind.support.SessionStatus;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.common.base.Grid;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.service.administracion.curso.cuarto.GestionarCursoEspecifico;
import pe.com.microdata.cjava.service.administracion.curso.cuarto.dto.CuartoDTO;
import pe.com.microdata.cjava.web.base.BaseController;
 ;



@Controller
@RequestMapping("/lista-cuarto")
public class ListarCuartoController extends BaseController{
    
    private static final String REDIRECCIONAR = "redirect:/lista-cuarto.html";
    private static final String NOREDIRECCIONAR = "lista-cuarto";
    private static final String ID_CURSO_ESP = "idCursoEspecifico";
    private static final String CURSO_ESPECIFICO = "cursoEspecifico";

    private static final String MODEL_GRILLA = "grilla";
    private static final String MODEL_FILTRO = "busquedaDTO";
                   
    @Autowired
    GestionarCursoEspecifico gestionarCursoEsp;
    
    @ModelAttribute(MODEL_FILTRO)
    public BusquedaDTO modeloFiltrol(Model model){
        BusquedaDTO dto = new BusquedaDTO(1, 10);
        return dto;
    }
       

    @RequestMapping(method = RequestMethod.GET)
    public String vista(ModelMap model){
        BusquedaDTO dto = (BusquedaDTO) model.get(MODEL_FILTRO);
        List<CuartoDTO> lista = gestionarCursoEsp.obtenerListaCursoEspecificoPorBusqueda(dto);
        model.addAttribute(MODEL_GRILLA, lanzarBusqueda(dto));
        return NOREDIRECCIONAR;
    }
    
    @RequestMapping(params = "eliminar", method = RequestMethod.POST)
    public String eliminarCuarto(@Valid 
        @ModelAttribute(CURSO_ESPECIFICO) CuartoDTO dto, 
        BindingResult result, SessionStatus status, HttpServletRequest request,
        ModelMap model, HttpSession session){
        
        SIGAMessage m = new SIGAMessage();
        m.setSuccess(true);
        m = gestionarCursoEsp.eliminarCursoEspecifico(dto.getIdCuarto());
        if(m.getSuccess()){
            m.setMessageType(SIGAMessage.MessageType.SUCCESS);
            m.addMessages(getText("msg.curesp.eliminar_exito"));            
        }else{
            m.setMessageType(SIGAMessage.MessageType.ERROR);
            m.addMessages(getText("msg.curesp.eliminar_error"));
        }    
        return REDIRECCIONAR;
    }
    
    @RequestMapping(params = "buscar", method = RequestMethod.POST)
    public String buscar(@Valid @ModelAttribute(MODEL_FILTRO) BusquedaDTO dto, 
            BindingResult result, SessionStatus status, HttpServletRequest request, 
            ModelMap model, HttpSession session){
        model.addAttribute(MODEL_FILTRO, dto);
        model.addAttribute(MODEL_GRILLA, lanzarBusqueda(dto));
        return NOREDIRECCIONAR;        
    }
                                                                                                                                                                       
    private Grid lanzarBusqueda(BusquedaDTO dto){
        Grid grillaDTO = new Grid();
        List list = gestionarCursoEsp.obtenerListaCursoEspecificoPorBusqueda(dto);
        Long total = gestionarCursoEsp.obtenerTotalListaCursoEspecificoPorBusqueda(dto);
        
        grillaDTO.setRows(list);
        grillaDTO.setPage(dto.getInicio()); 
        grillaDTO.setTotal(total.intValue());                  
        grillaDTO.setPagination(Constants.CANT_FILAS);
        
        return grillaDTO;
    }
        
}
