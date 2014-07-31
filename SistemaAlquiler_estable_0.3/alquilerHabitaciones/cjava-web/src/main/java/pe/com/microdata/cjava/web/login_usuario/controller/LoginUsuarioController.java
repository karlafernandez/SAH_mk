package pe.com.microdata.cjava.web.login_usuario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.com.microdata.cjava.web.base.BaseController;

@Controller
public class LoginUsuarioController extends BaseController {

    private static final String PRINCIPAL = "redirect:/principal.html";
    private static final String LOGIN = "login";

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String mostrarVistaLogin(@RequestParam(value = "error", required = false) String error, ModelMap model) {
        String view = LOGIN;

        if ("usuario_password_incorrectos".equals(error)) {
            model.put("error", "Ha ingresado un usuario y/o contraseña incorrecta.");
        } else {
            model.put("error", "");
        }

        if (getUsuario() != null) {
            view= PRINCIPAL;
        }
        return view;

    }
}