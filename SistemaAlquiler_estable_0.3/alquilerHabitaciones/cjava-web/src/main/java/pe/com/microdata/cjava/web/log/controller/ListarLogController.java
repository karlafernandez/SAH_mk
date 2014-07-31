/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.log.controller;

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
import pe.com.microdata.cjava.service.log.GestionarLog;
import pe.com.microdata.cjava.web.base.BaseController;


@Controller
@RequestMapping("/listar-log")
public class ListarLogController extends BaseController {

    private static final String NOREDIRECCIONAR = "listar-log";
    private static final String REDIRECCIONAR = "redirect:/listar-log.html";
    private static final String MODEL_GRILLA = "grilla";
    private static final String MODEL_FILTRO = "busquedaDTO";

    @Autowired
    GestionarLog gestionarLog;

    @ModelAttribute(MODEL_FILTRO)
    public BusquedaDTO modeloFiltro(Model model) {
        BusquedaDTO busquedaDTO = new BusquedaDTO(1, Constants.CANT_FILAS);
        return busquedaDTO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String vista(ModelMap model) {
        BusquedaDTO dto = (BusquedaDTO) model.get(MODEL_FILTRO);
        model.addAttribute(MODEL_GRILLA, lanzarBusqueda(dto));
        return NOREDIRECCIONAR;
    }

    @RequestMapping(params = "buscar", method = RequestMethod.GET)
    public String buscar(@Valid @ModelAttribute(MODEL_FILTRO) BusquedaDTO busquedaDTO,
            BindingResult result, SessionStatus status, HttpServletRequest request,
            ModelMap model, HttpSession session) {
        model.addAttribute(MODEL_FILTRO, busquedaDTO);
        model.addAttribute(MODEL_GRILLA, lanzarBusqueda(busquedaDTO));
        return NOREDIRECCIONAR;

    }

    private Grid lanzarBusqueda(BusquedaDTO busquedaDTO) {
        Grid grillaDTO = new Grid();
        List lstAlumnos = gestionarLog.obtenerLogsPorBusqueda(busquedaDTO);
        Long total = gestionarLog.obtenerTotalLogsPorBusqueda(busquedaDTO);

        grillaDTO.setRows(lstAlumnos);
        grillaDTO.setPage(busquedaDTO.getCantidad());
        grillaDTO.setTotal(total.intValue());
        grillaDTO.setPagination(Constants.CANT_FILAS);

        return grillaDTO;

    }
}
