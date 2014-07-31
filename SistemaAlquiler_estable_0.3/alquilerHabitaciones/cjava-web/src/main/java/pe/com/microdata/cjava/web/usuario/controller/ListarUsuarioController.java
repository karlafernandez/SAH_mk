/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.usuario.controller;

 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.com.microdata.cjava.service.registro.GestionarCliente;
     
import pe.com.microdata.cjava.service.registro.dto.AlumnoDTO;



@Controller
@RequestMapping("/lista-usuario")
public class ListarUsuarioController {

    private static final String REDIRECCIONAR = "redirect:/lista-usuario.html";
    private static final String NOREDIRECCIONAR = "lista-usuario";
    @Autowired
    GestionarCliente gestionarAlumno;

    @RequestMapping( method = RequestMethod.GET)
    public String vista(Model model) { 

     //   List<PacienteDTO> list = gestionarPaciente.obtenerPersonate();
     //   model.addAttribute("lstPacientes", list);
        return NOREDIRECCIONAR;
    }
}
