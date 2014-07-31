/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.registro.controller.arrendatarios;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.service.gestionar_listas.GestionarListas;
import pe.com.microdata.cjava.service.registro.GestionarInstructor;
import pe.com.microdata.cjava.service.registro.dto.InstructorDTO;
import pe.com.microdata.cjava.service.registro.validador.RegistrarInstructorValidador;
import pe.com.microdata.cjava.web.base.BaseController;

/**
 *
 * @author meliMeli
 */
@Controller
@RequestMapping("/registrarArrendatarios")
public class RegistrarArrendatariosController extends BaseController {

    static final String REGISTRO_DATOS = "datosBasicos";
    private static final String NOREDIRECCIONAR = "registrarInstructores";
    private static final String REDIRECCIONAR = "redirect:/listarInstructores.html";
    private static final String REDIRECCIONAR_LISTADO = "redirect:/listarInstructores.html";
    private static final String INSTRUCTOR = "representante";

    private static final String TIPO_DOCUMENTO = "lstTipoDocumento";
    private static final String TIPO_TELEF = "lstTipoTelefono";
    @Autowired
    GestionarInstructor gestionarInstructor;
    @Autowired
    RegistrarInstructorValidador instructorValidador;
    @Autowired
    GestionarListas gestionarListas;
    
    @ModelAttribute(REGISTRO_DATOS)
    public InstructorDTO modelo(Model model) {
        return new InstructorDTO();
    }
    
     @ModelAttribute(TIPO_DOCUMENTO)
    public List modelTipoDocumento(Model model) {
     //   return gestionarListas.obtenerSubTiposPorTipo(Constants.TIPO_DOCUMENTO);
        return gestionarListas.obtenerSubTiposPorTipo(1);
    }
    @ModelAttribute(TIPO_TELEF)
    public List modelTipoTelefono(Model model) {
        return gestionarListas.obtenerSubTiposPorTipo(4);
    }

    /*   @ModelAttribute(LST_DEPARTAMENTOS)
     public List modelDepartamentos(Model model) {
     return gestionarUbigeo.obtenerDepartamentos();
     }
     */
    @RequestMapping(method = RequestMethod.GET)
    public String vista(Model model, HttpServletRequest request) {
        return NOREDIRECCIONAR;
    }

    @RequestMapping(params = "guardar", method = RequestMethod.POST)
    public String registrarInstructor(@Valid @ModelAttribute(REGISTRO_DATOS) InstructorDTO instructorDTO,
            BindingResult result, HttpServletRequest request, Model model) {

        String view = NOREDIRECCIONAR;
        SIGAMessage m = new SIGAMessage();
        m.setSuccess(Boolean.FALSE);
         instructorValidador.validate(instructorDTO, result);
        if (!result.hasErrors()) {
                m = gestionarInstructor.registrarInstructor(instructorDTO);
               
            if (m.getSuccess()) {
                m.setMessageType(SIGAMessage.MessageType.SUCCESS);
                m.addMessages("Registro exitoso.Correo enviado a instructor");
                view = REDIRECCIONAR_LISTADO;
            } else {
                m.setMessageType(SIGAMessage.MessageType.ERROR);
                m.setSuccess(false);
                m.addMessages("Error al registrar");
                view = REDIRECCIONAR_LISTADO;
            }
        }

         request.getSession().setAttribute(MENSAJE, m);
        return view;
    }
}
    
