/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.registro.controller.clientes;

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
import pe.com.microdata.cjava.service.registro.GestionarCliente;
import pe.com.microdata.cjava.service.gestionar_listas.GestionarListas;
import pe.com.microdata.cjava.service.registro.dto.AlumnoDTO;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.service.registro.validador.RegistrarClienteValidador;
import pe.com.microdata.cjava.web.base.BaseController;

/**
 *
 * @author meliMeli
 */
@Controller
@RequestMapping("/registrarClientes")
public class RegistrarClientesController extends BaseController {

    static final String REGISTRO_DATOS = "registro";
    private static final String NOREDIRECCIONAR = "registrarClientes";
    private static final String REDIRECCIONAR = "redirect:/listarClientes.html";
    private static final String REDIRECCIONAR_LISTADO = "redirect:/listarClientes.html";
    private static final String TIPO_DOCUMENTO = "lstTipoDocumento";
    private static final String TIPO_CENTRO_ED = "lstTipoCentroEducativo";
    private static final String TIPO_NIVEL_EST = "lstTipoNivelEstudio";
    private static final String TIPO_TELEF = "lstTipoTelefono";
    private static final String OCUPACION = "lstOcupacion";
    private static final String BUSQUEDA = "busqueda";
    //  private static final String LST_DEPARTAMENTOS = "departamentos";
    @Autowired
    GestionarCliente gestionarAlumno;
    @Autowired
    GestionarListas gestionarListas;
    @Autowired
    RegistrarClienteValidador alumnoValidador;

    @ModelAttribute(REGISTRO_DATOS)
    public AlumnoDTO modelo(Model model) {
        return new AlumnoDTO();
    }
    
    @ModelAttribute(BUSQUEDA)
    public BusquedaDTO busqueda(Model model) {
        return new BusquedaDTO();
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
    public String vista(Model model, HttpServletRequest request /*, @RequestParam(BUSQUEDA) BusquedaDTO dto*/) {
        //AlumnoDTO codigo = gestionarAlumno.obtenerCodigoAutogenerado(dto);
        //model.addAttribute(REGISTRO_DATOS, codigo);
        return NOREDIRECCIONAR;
    }
    


    @RequestMapping(params = "guardar", method = RequestMethod.POST)
    public String registrarAlumno(@Valid @ModelAttribute(REGISTRO_DATOS) AlumnoDTO alumnoDTO,
            BindingResult result, HttpServletRequest request, Model model) {

        String view = NOREDIRECCIONAR;
        SIGAMessage m = new SIGAMessage();
        m.setSuccess(Boolean.FALSE);
        alumnoValidador.validate(alumnoDTO, result);
        if (!result.hasErrors()) {
            m = gestionarAlumno.registrarAlumno(alumnoDTO);

            if (m.getSuccess()) {
                m.setMessageType(SIGAMessage.MessageType.SUCCESS);
                m.addMessages("Registro exitoso.Correo enviado a alumno");
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
