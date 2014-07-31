package pe.com.microdata.cjava.web.login_usuario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.com.microdata.cjava.web.base.BaseController;

/**
 *
 * @author meliMeli
 */
@Controller
@RequestMapping("/mantenimiento")
public class MantenimientoController extends BaseController {

    private static final String NOREDIRECCIONAR = "mantenimiento";
    private static final String REDIRECCIONAR = "redirect:/listarAlumnos.html";

    @RequestMapping(method = RequestMethod.GET)
    public String vista(ModelMap model) {
        
        return NOREDIRECCIONAR;
    }

   /* @RequestMapping(params = "buscar", method = RequestMethod.POST)
    public String buscar(@Valid @ModelAttribute(MODEL_FILTRO) BusquedaDTO busquedaDTO,
            BindingResult result, SessionStatus status, HttpServletRequest request,
            ModelMap model, HttpSession session) {
      
        return NOREDIRECCIONAR;

    }*/


 
}
