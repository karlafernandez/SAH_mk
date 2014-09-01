package pe.com.microdata.cjava.web.accesos.controller;

import org.apache.log4j.Logger;
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
import pe.com.microdata.cjava.service.registro.GestionarArrendatario;
import pe.com.microdata.cjava.service.ubigeo.GestionarUbigeo;
import pe.com.microdata.cjava.web.base.BaseController;

@Controller
@RequestMapping("/listar_adm_instructor")
public class ListarInstructoresController extends BaseController {

    private static final String NOREDIRECCIONAR = "listar_adm_instructor";
    private static final String GRILLA = "grilla";
    private static final String MODEL_FILTRO = "busquedaDTO";

    private Logger logger = Logger.getLogger(ListarInstructoresController.class);
    
    @Autowired
    GestionarUbigeo gestionarUbigeo;

    @Autowired
    GestionarArrendatario gestionarInstructor;

    @ModelAttribute(MODEL_FILTRO)
    public BusquedaDTO modeloFiltro(Model model) {
        BusquedaDTO busquedaDTO = new BusquedaDTO(1, Constants.CANT_FILAS);
        return busquedaDTO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String vista(ModelMap model) {     
        BusquedaDTO dto = (BusquedaDTO) model.get(MODEL_FILTRO);
//        model.addAttribute(GRILLA, lanzarBusqueda(dto));        
        return NOREDIRECCIONAR;
    }

    @RequestMapping(params = "buscar", method = RequestMethod.POST)
    public String buscar(@Valid @ModelAttribute(MODEL_FILTRO) BusquedaDTO busquedaDTO,
            BindingResult result, SessionStatus status, HttpServletRequest request,
            ModelMap model, HttpSession session) {
        logger.info("no llega aca buscar");
        
        model.addAttribute(MODEL_FILTRO, busquedaDTO);
  //      model.addAttribute(GRILLA, lanzarBusqueda(busquedaDTO));
        
        return NOREDIRECCIONAR;

    }
/*
    private Grid lanzarBusqueda(BusquedaDTO busquedaDTO) {
        Grid grillaDTO = new Grid();
        List lstInstructor = gestionarInstructor.obtenerInstructorPorBusqueda(busquedaDTO);

        Long total = gestionarInstructor.obtenerTotalInstructoresPorBusqueda(busquedaDTO);

        grillaDTO.setRows(lstInstructor);
        grillaDTO.setPage(busquedaDTO.getInicio());
        grillaDTO.setTotal(total.intValue());
        grillaDTO.setPagination(Constants.CANT_FILAS);

        return grillaDTO;

    }*/
}
