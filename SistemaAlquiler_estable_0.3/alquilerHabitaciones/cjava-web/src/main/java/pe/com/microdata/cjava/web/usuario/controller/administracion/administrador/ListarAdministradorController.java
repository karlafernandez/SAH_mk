/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.usuario.controller.administracion.administrador;

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
import pe.com.microdata.cjava.service.administracion.administrador.GestionarAdministrador;
import pe.com.microdata.cjava.service.administracion.administrador.dto.AdministradorDTO;
import pe.com.microdata.cjava.web.base.BaseController;


@Controller
@RequestMapping("listar-administrador")
public class ListarAdministradorController extends BaseController{
    
    private static final String NO_REDIRECCIONAR = "listar-administrador";
    private static final String REDIRECCIONAR = "redirect:/listar-administrador.html";
    private static final String MODEL_GRILLA = "grilla";
    private static final String MODEL_FILTRO = "busquedaDTO";
    private static final String MODEL_ADMINISTRADOR = "empresa";
    
    @Autowired
    GestionarAdministrador gestionarAdministrador;
    
    @RequestMapping(method = RequestMethod.GET)
    public String vista(ModelMap model, HttpServletRequest request, HttpSession session){
        initMensaje(request);
        BusquedaDTO dto = (BusquedaDTO) model.get(MODEL_FILTRO);
        model.addAttribute(MODEL_GRILLA, lanzarBusqueda(dto));        
        return NO_REDIRECCIONAR;
    }
    
    @RequestMapping(params = "buscar", method = RequestMethod.POST)
    public String buscar(@Valid @ModelAttribute(MODEL_FILTRO) BusquedaDTO dto,
            BindingResult result, SessionStatus status, HttpServletRequest request, 
            ModelMap model, HttpSession session){
        model.addAttribute(MODEL_FILTRO, dto);
        model.addAttribute(MODEL_GRILLA, lanzarBusqueda(dto));
        return NO_REDIRECCIONAR;
    }
    
    @RequestMapping(params = "eliminar", method = RequestMethod.POST)
    public String eliminar(@Valid @ModelAttribute(MODEL_ADMINISTRADOR) AdministradorDTO dto,
            BindingResult result, SessionStatus status, HttpServletRequest request, 
            ModelMap model, HttpSession session){
        SIGAMessage m = new SIGAMessage();
        m.setSuccess(true);
        m = gestionarAdministrador.eliminarAdministrador(dto.getIdAdmin());
        if(m.getSuccess()){
            m.setMessageType(SIGAMessage.MessageType.SUCCESS);
            m.addMessages(getText("msg.admin.eliminar_exito"));            
        }else{
            m.setMessageType(SIGAMessage.MessageType.ERROR);
            m.addMessages(getText("msg.admin.eliminar_error"));
        }    
        return REDIRECCIONAR;               
    }    
    
    @ModelAttribute(MODEL_FILTRO)
    public BusquedaDTO modeloFiltro(Model model){
        return new BusquedaDTO(1, Constants.CANT_FILAS);
    }
    
    private Grid lanzarBusqueda(BusquedaDTO dto){
        Grid grillaDTO = new Grid();
        List list = gestionarAdministrador.obtenerAdministradorPorBusqueda(dto);
        Long total = gestionarAdministrador.obtenerTotalAdministradoresPorBusqueda(dto);
        
        grillaDTO.setRows(list);
        grillaDTO.setPage(dto.getInicio());
        grillaDTO.setTotal(total.intValue());
        grillaDTO.setPagination(Constants.CANT_FILAS);
        
        return grillaDTO;
    }
}
