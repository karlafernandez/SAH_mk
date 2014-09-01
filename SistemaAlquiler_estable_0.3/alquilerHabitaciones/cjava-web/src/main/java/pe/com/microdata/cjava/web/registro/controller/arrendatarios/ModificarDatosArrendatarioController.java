/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.registro.controller.arrendatarios;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.service.gestionar_listas.GestionarListas;
import pe.com.microdata.cjava.service.registro.GestionarArrendatario;
import pe.com.microdata.cjava.service.registro.dto.ArrendatarioDTO;
import pe.com.microdata.cjava.service.registro.validador.ModificarArrendatarioValidador;

import pe.com.microdata.cjava.web.base.BaseController;

/**
 *
 * @author meliMeli
 */
@Controller
@RequestMapping("/modificarArrendatario")
public class ModificarDatosArrendatarioController extends BaseController {

    static final String INSTRUCTOR = "instructores";
    private static final String REDIRECCIONAR = "redirect:/listarInstructores.html";
    private static final String NOREDIRECCIONAR = "modificarInstructores";
    private static final String ID_INSTRUCTOR = "idInstructor";
    private static final String TIPO_DOCUMENTO = "lstTipoDocumento";
    @Autowired
    private GestionarArrendatario gestionarArrendatario;
    @Autowired
    GestionarListas gestionarListas;
  
    @Autowired
    ModificarArrendatarioValidador validator; 

    @ModelAttribute(ID_INSTRUCTOR)
    public ArrendatarioDTO modelo(Model model) {
        return new ArrendatarioDTO();
    }
   
    @ModelAttribute(TIPO_DOCUMENTO)
    public List modelTipoDocumento(Model model) {
        return gestionarListas.obtenerSubTiposPorTipo(1);
    }
 
    @RequestMapping(method = RequestMethod.GET)
    public String vista(ModelMap model, HttpServletRequest request, @RequestParam(ID_INSTRUCTOR) Integer idInstructor) {
        ArrendatarioDTO promotor = gestionarArrendatario.obtenerArrendatarioPorId(idInstructor);
                
              
        model.addAttribute(INSTRUCTOR, promotor);
        return NOREDIRECCIONAR;
    }

    @RequestMapping(params = "guardar", method = RequestMethod.POST)
    public String modificarDatos(@ModelAttribute(INSTRUCTOR) ArrendatarioDTO dto,
            HttpServletRequest request, HttpSession session, ModelMap model, BindingResult result) {
        String view = NOREDIRECCIONAR;
        SIGAMessage m = new SIGAMessage();
        m.setSuccess(false);
        validator.validate(dto, result);
        if (!result.hasErrors()) {
            m = gestionarArrendatario.modificarArrendatario(dto);
                  
                 
            if (m.getSuccess()) {
                m.setMessageType(SIGAMessage.MessageType.SUCCESS);
                m.addMessages(getText("msg.usuario.crear_exito"));
                view = REDIRECCIONAR;
                request.getSession().setAttribute(MENSAJE, m);
            } else {
                m.setMessageType(SIGAMessage.MessageType.ERROR);
                m.setSuccess(false);
                m.addMessages(getText("msg.usuario.crear_error"));
                model.addAttribute(MENSAJE, m);
            }
        }
        return view;
    }
}