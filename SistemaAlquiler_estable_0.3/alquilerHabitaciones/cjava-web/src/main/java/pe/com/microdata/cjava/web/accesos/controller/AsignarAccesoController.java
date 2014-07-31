package pe.com.microdata.cjava.web.accesos.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.service.acceso.GestionarAcceso;
import pe.com.microdata.cjava.service.acceso.dto.AsignarAccesoDTO;
import pe.com.microdata.cjava.service.base.dto.UserDetailsDTO;
import pe.com.microdata.cjava.service.registro.GestionarPersona;
import pe.com.microdata.cjava.web.base.BaseController;

@Controller
@SessionAttributes({"idUsuario", "direccion"})
@RequestMapping("/asignar_acceso")
public class AsignarAccesoController extends BaseController {

    @Autowired
    private GestionarAcceso gestionarAcceso;
    @Autowired
    private GestionarPersona gestionarPersona;

    private static final String MENSAJE = "mensaje";
    private static final String NOREDIRECCIONAR = "asignar_acceso";
    private static final String REDIRECCIONAR = "redirect:/asignar_acceso.html";
    private static final String ASIGNAR_ACCESO = "asignarAcceso";
    private static final String LISTADO_PERMISOS = "modulos";
    private static final String ID_USUARIO = "idUsuario";
    private static final String DIRECCION = "direccion";

    @ModelAttribute(ASIGNAR_ACCESO)
    public AsignarAccesoDTO initAsignarAccesoDTO(
            @RequestParam(value = ID_USUARIO, required = false) Integer idUsuario,
            @RequestParam(value = DIRECCION, required = false) String direccion,
            HttpServletRequest request) {
        if (idUsuario == null) {
            idUsuario = (Integer) request.getSession().getAttribute(ID_USUARIO);
        } else {
            request.getSession().setAttribute(ID_USUARIO, idUsuario);
        }
        if (direccion == null) {
            direccion = (String) request.getSession().getAttribute(DIRECCION);
        } else {
            request.getSession().setAttribute(DIRECCION, direccion);
        }
        AsignarAccesoDTO asignarAccesoDTO = new AsignarAccesoDTO();
        UserDetailsDTO u = gestionarPersona.obtenerPersonaPorId(idUsuario);
        asignarAccesoDTO.setUsuarioDTO(u);
        asignarAccesoDTO.setIdUsuario(idUsuario);
        asignarAccesoDTO.setDireccionRetorno(direccion);
        return asignarAccesoDTO;
    }

    @ModelAttribute(LISTADO_PERMISOS)
    public List initListadoAsignarAccesoDTO() {
        return gestionarAcceso.obtenerAccesos();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String vista() {
        return NOREDIRECCIONAR;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String asignarAcceso(@Valid @ModelAttribute(ASIGNAR_ACCESO) AsignarAccesoDTO asignarAccesoDTO,
            ModelMap model, HttpServletRequest request, BindingResult result) {
        SIGAMessage m = this.gestionarAcceso.asignarAccesosPorUsuario(asignarAccesoDTO);

        if (m.getSuccess()) {
            m.setMessageType(SIGAMessage.MessageType.SUCCESS);
            request.getSession().setAttribute(MENSAJE, m);
        } else {
            m.setMessageType(SIGAMessage.MessageType.ERROR);
            m.setSuccess(false);
            m.addMessages("error al asignar roles");
            model.addAttribute(MENSAJE, m);
        }
        return REDIRECCIONAR;
    }
}
