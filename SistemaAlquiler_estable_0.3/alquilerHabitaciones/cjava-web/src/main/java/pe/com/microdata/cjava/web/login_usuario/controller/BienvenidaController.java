package pe.com.microdata.cjava.web.login_usuario.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.service.base.dto.UserDetailsDTO;
import pe.com.microdata.cjava.web.base.BaseController;

@SessionAttributes({"userDetails"})
@Controller
public class BienvenidaController extends BaseController {

    private static final String USER_DETAILS = "userDetails";
    private static final String FECHA = "fecha";
    SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.FORMATO_FECHA);
    
    private static final Logger logger = Logger.getLogger(BienvenidaController.class.getName());

    @RequestMapping(value = "/principal", method = RequestMethod.GET)
    public String mostrarBievenida(Model model) {
        UserDetailsDTO userDetailsDTO = this.getDatosUsuario();
        userDetailsDTO.setFecha(dateFormat.format(new Date()));        
        model.addAttribute(USER_DETAILS, userDetailsDTO);
        return "principal";
    }
}