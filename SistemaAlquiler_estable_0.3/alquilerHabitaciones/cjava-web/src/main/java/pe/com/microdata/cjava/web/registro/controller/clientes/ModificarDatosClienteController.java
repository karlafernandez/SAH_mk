/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.registro.controller.clientes;

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
import pe.com.microdata.cjava.service.registro.GestionarCliente;
import pe.com.microdata.cjava.service.registro.dto.ClienteDTO;
import pe.com.microdata.cjava.service.registro.validador.ModificarClienteValidador;
import pe.com.microdata.cjava.web.base.BaseController;

/**
 *
 * @author meliMeli
 */
@Controller
@RequestMapping("/modificarAlumno")
public class ModificarDatosClienteController extends BaseController {

    static final String ALUMNO = "alumno";
    private static final String REDIRECCIONAR = "redirect:/listarAlumnos.html";
    private static final String NOREDIRECCIONAR = "modificarAlumno";
    private static final String ID_ALUMNO = "idAlumno";
    private static final String TIPO_DOCUMENTO = "lstTipoDocumento";
    private static final String TIPO_CENTRO_ED = "lstTipoCentroEducativo";
    private static final String TIPO_NIVEL_EST = "lstTipoNivelEstudio";
    private static final String TIPO_TELEF = "lstTipoTelefono";
    private static final String OCUPACION = "lstOcupacion";
    @Autowired
    GestionarCliente gestionarAlumno;
    @Autowired
    GestionarListas gestionarListas;
    @Autowired
    ModificarClienteValidador validator;
    

    @ModelAttribute(ID_ALUMNO)
    public ClienteDTO modelo(Model model) {
        return new ClienteDTO();
    }

    @ModelAttribute(TIPO_DOCUMENTO)
    public List modelTipoDocumento(Model model) {
        //   return gestionarListas.obtenerSubTiposPorTipo(Constants.TIPO_DOCUMENTO);
        return gestionarListas.obtenerSubTiposPorTipo(1);
    }

    @ModelAttribute(TIPO_CENTRO_ED)
    public List modelTipoCentroEducativo(Model model) {
        return gestionarListas.obtenerSubTiposPorTipo(2);
    }

    @ModelAttribute(TIPO_NIVEL_EST)
    public List modelNivelEstudio(Model model) {
        return gestionarListas.obtenerSubTiposPorTipo(3);
    }

    @ModelAttribute(TIPO_TELEF)
    public List modelTipoTelefono(Model model) {
        return gestionarListas.obtenerSubTiposPorTipo(4);
    }
    
    @ModelAttribute(OCUPACION)
    public List modelTipoOcupacion(Model model) {
        return gestionarListas.obtenerSubTiposPorTipo(11);
    }


    @RequestMapping(method = RequestMethod.GET)
    public String vista(ModelMap model, HttpServletRequest request, @RequestParam(ID_ALUMNO) Integer idAlumno) {
        ClienteDTO promotor = gestionarAlumno.obtenerClientePorId(idAlumno);
              

        model.addAttribute(ALUMNO, promotor);
        return NOREDIRECCIONAR;
    }
   
    @RequestMapping(params = "guardar", method = RequestMethod.POST)
    public String modificarDatos(@ModelAttribute(ALUMNO) ClienteDTO dto,
            HttpServletRequest request, HttpSession session, ModelMap model, BindingResult result) {
        String view = NOREDIRECCIONAR;
        SIGAMessage m = new SIGAMessage();
        m.setSuccess(false);
        validator.validate(dto, result);
        if (!result.hasErrors()) {
            m = gestionarAlumno.modificarCliente(dto);
                    
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