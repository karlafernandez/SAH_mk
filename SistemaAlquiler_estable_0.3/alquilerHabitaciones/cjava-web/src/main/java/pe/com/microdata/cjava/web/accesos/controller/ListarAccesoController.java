package pe.com.microdata.cjava.web.accesos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.com.microdata.cjava.service.acceso.GestionarAcceso;
import pe.com.microdata.cjava.web.base.BaseController;

 

@Controller
@RequestMapping("/listar_accesos")
public class ListarAccesoController extends BaseController{

    @Autowired
    private GestionarAcceso gestionarAcceso;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    List obtenerUsuariosPorNombre(
            @RequestParam(value = "idUsuario", required = true) Integer idUsuario) {
        return this.gestionarAcceso.obtenerAccesosPorIdUsuario(idUsuario);
    }
}