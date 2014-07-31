/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.archivo.controller;

import java.io.File;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.service.archivo.GestionarArchivo;
import pe.com.microdata.cjava.service.archivo.dto.ArchivoDTO;
import pe.com.microdata.cjava.web.base.BaseController;


@Controller
@RequestMapping("/gestionar_archivo")
public class GuardarArchivoController extends BaseController {

    private static final String NOREDIRECCIONAR = "gestionar_archivo";
    private static final String REDIRECCIONAR = "redirect:/gestionar_archivo.html";
    private static final String ARCHIVO = "archivo";
    private static final String ID_ARCHIVO = "idArchivo";
    private static final String LST_ARCHIVO = "archivos";
    @Autowired
    GestionarArchivo gestionarArchivo;

    @ModelAttribute(ARCHIVO)
    public ArchivoDTO model(Model model) {
        return new ArchivoDTO();
    }

    @ModelAttribute(LST_ARCHIVO)
    public List modelList(Model model) {
        return gestionarArchivo.obtenerArchivos();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String vista(Model model) {
        return NOREDIRECCIONAR;
    }
 
    @RequestMapping(method = RequestMethod.POST)
    public String guardarArchivo(@ModelAttribute(ARCHIVO) ArchivoDTO archivoDTO, Model model, HttpServletRequest request) {
        String ruta = request.getServletContext().getRealPath("") + "/";
        SIGAMessage message = new SIGAMessage();
        message.setSuccess(Boolean.FALSE);
        message.setMessageType(SIGAMessage.MessageType.ERROR);
        String view = NOREDIRECCIONAR;
        try {
            if (archivoDTO.getArchivo() != null) {
                archivoDTO.setRutaServidor(ruta);
                String fileName = "images/" + archivoDTO.getArchivo().getOriginalFilename();
                try {
                    File f = new File(ruta + fileName);
                    if (!f.exists()) {
                        f.createNewFile();
                    }
                    archivoDTO.getArchivo().transferTo(f);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                message = gestionarArchivo.cargarArchivo(archivoDTO);

            }
            view = REDIRECCIONAR;

        } catch (Exception e) {

            view = NOREDIRECCIONAR;
        }
        request.getSession().setAttribute(MENSAJE, message);
        return view;

    }

}
