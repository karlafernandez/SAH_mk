/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.registro.controller.clientes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.com.microdata.cjava.service.registro.GestionarCliente;
import pe.com.microdata.cjava.service.registro.dto.HistorialCursoDTO;
import pe.com.microdata.cjava.web.base.BaseController;


@Controller
@RequestMapping("historial-cursos")
public class HistorialCuartosController extends BaseController{
    
    private static final String NO_REDIRECCIONAR = "historial-cursos";        
    private static final String MODEL_HISTORIAL = "historial";
    private static final String PARAM_ID_ALUMNO = "idAlum";
    private static final String PARAM_NOM_ALUMNO = "nomAlum";
    
    @Autowired
    GestionarCliente gestionarCliente;
    
    @RequestMapping(method = RequestMethod.GET)
    public String vista(Model model, HttpSession session, HttpServletRequest request){
        initMensaje(request);
        return NO_REDIRECCIONAR;
    }
    /*
    @ModelAttribute(MODEL_HISTORIAL)
    public HistorialCursoDTO obtenerHistorial(Model model, 
        @RequestParam(value = PARAM_ID_ALUMNO) Integer idAlum,
        @RequestParam(value = PARAM_NOM_ALUMNO) String nomAlum){
        HistorialCursoDTO historial = gestionarCliente.obtenerHistorialCursoPorIdAlumno(idAlum);
        historial.setNomAlumno(nomAlum);
        return  historial;
    }*/
    
}
