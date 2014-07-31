/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.accesos.controller;

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
import pe.com.microdata.cjava.service.acceso.dto.UsuarioSeguridadDTO;
import pe.com.microdata.cjava.service.registro.GestionarPersona;
import pe.com.microdata.cjava.web.base.BaseController;



@Controller
@RequestMapping("/listar_adm_alumno")
public class ListarAlumnosController extends BaseController{
        
    private static final String NO_REDIRECCIONAR = "listar_adm_alumno";
    private static final String MODEL_GRILLA = "grilla";
    private static final String MODEL_FILTRO = "busquedaDTO";
    
    @Autowired
    GestionarPersona gestionarPersona;
    
    @RequestMapping(method = RequestMethod.GET)
    public String vista(ModelMap model){
        BusquedaDTO dto = (BusquedaDTO) model.get(MODEL_FILTRO);
        model.addAttribute(MODEL_GRILLA, lanzarBusqueda(dto));
        return NO_REDIRECCIONAR;
    }
    
   @ModelAttribute(MODEL_FILTRO)
    public BusquedaDTO modeloFiltrol(Model model){
        BusquedaDTO dto = new BusquedaDTO(1, 10);
        return dto;
    }
       
    @RequestMapping(params = "buscar", method = RequestMethod.POST)
    public String buscar(@Valid @ModelAttribute(MODEL_FILTRO) BusquedaDTO dto, 
            BindingResult result, SessionStatus status, HttpServletRequest request, 
            ModelMap model, HttpSession session){
        model.addAttribute(MODEL_FILTRO, dto);
        model.addAttribute(MODEL_GRILLA, lanzarBusqueda(dto));
        return NO_REDIRECCIONAR;        
    }
      
    private Grid lanzarBusqueda(BusquedaDTO dto){
        Grid grillaDTO = new Grid();
        List<UsuarioSeguridadDTO> list = gestionarPersona.obtenerSeguridadListaPersonaPorBusquedaYTipoUsuario(dto, Constants.SUBTIPO_USER_ALUMNO);
        Long total = gestionarPersona.obtenerTotalSeguridadListaPersonaPorBusquedaYTipoUsuario(dto, Constants.SUBTIPO_USER_ALUMNO);
        
        grillaDTO.setRows(list);
        grillaDTO.setPage(dto.getInicio());
        grillaDTO.setTotal(total.intValue());
        grillaDTO.setPage(Constants.CANT_FILAS);
        
        return grillaDTO;
    }
}
