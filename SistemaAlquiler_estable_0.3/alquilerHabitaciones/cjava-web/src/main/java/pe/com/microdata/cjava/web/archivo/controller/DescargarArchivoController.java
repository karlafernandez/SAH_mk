/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.archivo.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import pe.com.microdata.cjava.service.archivo.GestionarArchivo;
import pe.com.microdata.cjava.service.archivo.dto.ArchivoDTO;
import pe.com.microdata.cjava.web.base.BaseController;
 

@Controller
@SessionAttributes("idArchivo")
@RequestMapping("/descargar_archivo")
public class DescargarArchivoController extends BaseController {

    private static final String ARCHIVO = "archivo";
    private static final String ID_ARCHIVO = "idArchivo";
    @Autowired
    GestionarArchivo gestionarArchivo;

    @ModelAttribute(ARCHIVO)
    public ArchivoDTO model(@RequestParam(value = ID_ARCHIVO, required = false) Integer idArchivo, Model model, HttpServletRequest request) {
        request.getSession().setAttribute(ID_ARCHIVO, idArchivo);
        return new ArchivoDTO();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView downloadRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        
        Integer idArchivo = (Integer) request.getSession().getAttribute(ID_ARCHIVO);
        String ruta = request.getServletContext().getRealPath("") + "/";
        ArchivoDTO archivoDTO = gestionarArchivo.obtenerArchivoEnRutaPorId(idArchivo, ruta);
        ByteArrayOutputStream baos = archivoDTO.getArchivoOutput();
        try {
            response.setContentType("application/" + archivoDTO.getExtension() + "");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + archivoDTO.getNomArchivo() + "." + archivoDTO.getExtension() + "\"");
            response.getOutputStream().write(baos.toByteArray());
            response.flushBuffer();
        } catch (IOException ex) {
            // Sacar log de error.
            throw ex;
        }
        return null;
    }
}
