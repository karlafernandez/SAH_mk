/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.log.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.com.microdata.cjava.service.log.GestionarLog;
import pe.com.microdata.cjava.service.log.dto.LogDTO;
import pe.com.microdata.cjava.web.base.BaseController;


@Controller
@RequestMapping("/ver-detalle-log")
public class VerLogController extends BaseController {

    private static final String NOREDIRECCIONAR = "ver-detalle-log";
    private static final String MODEL = "log";
    private static final String ID_LOG = "idLog";

    @Autowired
    GestionarLog gestionarLog;

    @ModelAttribute(MODEL)
    public LogDTO modeloFiltro(Model model) {
        LogDTO logDTO = new LogDTO();
        return logDTO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String vista(ModelMap model, HttpServletRequest request, @RequestParam(ID_LOG) Integer idLog) {
        LogDTO logDTO = gestionarLog.obtenerLogPorId(idLog);

        model.addAttribute(MODEL, logDTO);
        return NOREDIRECCIONAR;
    }
}
