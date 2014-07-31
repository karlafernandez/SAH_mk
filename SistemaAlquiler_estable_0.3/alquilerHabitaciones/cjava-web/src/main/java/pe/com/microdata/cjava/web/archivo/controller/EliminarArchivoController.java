/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.archivo.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.service.archivo.GestionarArchivo;
import pe.com.microdata.cjava.web.base.BaseController;


@Controller
@RequestMapping("/eliminar_archivo")
public class EliminarArchivoController extends BaseController {

    private static final String NOREDIRECCIONAR = "gestionar_archivo";
    private static final String REDIRECCIONAR = "redirect:/gestionar_archivo.html";
    private static final String ID_ARCHIVO = "idArchivo";
    @Autowired
    GestionarArchivo gestionarArchivo;

    @RequestMapping(method = RequestMethod.GET)
    public String eliminarArchivo(@ModelAttribute(ID_ARCHIVO) Integer idArchivo, Model model, HttpServletRequest request) {
        SIGAMessage message = new SIGAMessage();
        message.setSuccess(Boolean.FALSE);
        message.setMessageType(SIGAMessage.MessageType.ERROR);
        String view = REDIRECCIONAR;
        try {
            message = gestionarArchivo.eliminarArchivo(idArchivo);

        } catch (Exception e) {
            e.printStackTrace();

        }
        request.getSession().setAttribute(MENSAJE, message);

        return view;

    }

}
