/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.usuario.controller;

 
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import pe.com.microdata.cjava.service.paciente.GestionarPaciente;
//import pe.com.microdata.cjava.service.paciente.dto.PacienteDTO;
//import pe.com.microdata.cjava.service.paciente.validator.PacienteValidador;


@Controller
@RequestMapping("/registrar-usuario")
public class RegistrarUsuarioController {/*

    private static final String NOREDIRECCIONAR = "registrar-usuario";

    private static final String REDIRECCIONAR_LISTADO = "redirect:/lista-usuario.html";

    @Autowired
    GestionarPaciente gestionarPaciente;
    
    @Autowired
    PacienteValidador pacienteValidador;

    @ModelAttribute("paciente")
    public PacienteDTO model() {
        return new PacienteDTO();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String vista(Model model) {
        return NOREDIRECCIONAR;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registrar(@Valid @ModelAttribute("paciente") PacienteDTO pacienteDTO,
            HttpServletRequest request, ModelMap model, BindingResult result) {
        String view = NOREDIRECCIONAR;
        boolean m = false;
        pacienteValidador.validate(pacienteDTO, result);
        if (!result.hasErrors()) { 
     //       m = gestionarPaciente.registrarPaciente(pacienteDTO); 
            if (m) { 
                //se registra
                view = REDIRECCIONAR_LISTADO;
            } else { 
                //no registra
                view = REDIRECCIONAR_LISTADO;
            }
        } else {
            //error la validacion 
        } 

        return view;
    }*/
}
