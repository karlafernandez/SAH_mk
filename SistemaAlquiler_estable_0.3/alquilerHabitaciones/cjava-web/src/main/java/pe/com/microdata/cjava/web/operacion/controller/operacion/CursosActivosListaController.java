/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.operacion.controller.operacion;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.common.base.CondicionDTO;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.common.base.Grid;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.service.gestionar_listas.GestionarListas;
import pe.com.microdata.cjava.service.operacion.operacion.GestionarOperacion;
import pe.com.microdata.cjava.web.base.BaseController;
import pe.com.microdata.cjava.service.ubigeo.GestionarUbigeo;

/**
 *
 * @author meliMeli
 */
@Controller
@RequestMapping("/lista-cuarto-operacion")
public class CursosActivosListaController extends BaseController {

    private static final String NOREDIRECCIONAR = "lista-curso-operacion";
    private static final String REDIRECCIONAR = "redirect:/lista-curso-operacion.html";
    private static final String MODEL_GRILLA = "grilla";
    private static final String MODEL_FILTRO = "busquedaDTO";
    private static final String MODEL_ESTADO_CURSO = "lstEstadoOp";
    private static final String ID_ALUMNO = "idAlumno";
    @Autowired
    GestionarUbigeo gestionarUbigeo;
    @Autowired
    GestionarOperacion gestionarOperacion;
    @Autowired
    GestionarListas gestionarListas;

    @ModelAttribute(MODEL_FILTRO)
    public BusquedaDTO modeloFiltro(Model model) {
        BusquedaDTO busquedaDTO = new BusquedaDTO(1, Constants.CANT_FILAS);
        List<CondicionDTO> lstCondicionDTOs = new ArrayList<CondicionDTO>();
        CondicionDTO cdto = new CondicionDTO();
        cdto.setField("estadoOperacion");
        cdto.setData(" ");
        lstCondicionDTOs.add(cdto);
        busquedaDTO.setCondiciones(lstCondicionDTOs);
        return busquedaDTO;
    }

    @ModelAttribute(MODEL_ESTADO_CURSO)
    public List modeloEstados(Model model){
        return gestionarListas.obtenerSubTiposPorTipo(Constants.TIPO_ESTADO_OPERACION);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String vista(ModelMap model) {
        BusquedaDTO dto = (BusquedaDTO) model.get(MODEL_FILTRO);
      //  model.addAttribute(MODEL_GRILLA, lanzarBusqueda(dto));
        return NOREDIRECCIONAR;
    }

    @RequestMapping(params = "buscar", method = RequestMethod.POST)
    public String buscar(@Valid @ModelAttribute(MODEL_FILTRO) BusquedaDTO busquedaDTO,
            BindingResult result, SessionStatus status, HttpServletRequest request,
            ModelMap model, HttpSession session) {
        model.addAttribute(MODEL_FILTRO, busquedaDTO);
       // model.addAttribute(MODEL_GRILLA, lanzarBusqueda(busquedaDTO));
        return NOREDIRECCIONAR;

    }

    @RequestMapping(params = "eliminar", method = RequestMethod.GET)
    public String eliminar(@RequestParam(ID_ALUMNO) Integer idOperacion, HttpServletRequest request, HttpSession session) {
        SIGAMessage messageDTO = new SIGAMessage();
        //gestionarOperacion.eliminarOperacion(idOperacion);

        messageDTO.setSuccess(Boolean.TRUE);
        messageDTO.setMessageType(SIGAMessage.MessageType.SUCCESS);
        messageDTO.addMessages(getText("msg.usuario.eliminar"));
        session.setAttribute(MENSAJE, messageDTO);
        return REDIRECCIONAR;
    }
/*
    private Grid lanzarBusqueda(BusquedaDTO busquedaDTO) {
        Grid grillaDTO = new Grid();
        List lstCursosActivos = gestionarOperacion.obtenerOperacionPorBusqueda(busquedaDTO);
        Long total = gestionarOperacion.obtenerTotalOperacionesPorBusqueda(busquedaDTO);

        grillaDTO.setRows(lstCursosActivos);
        grillaDTO.setPage(busquedaDTO.getCantidad());
        grillaDTO.setTotal(total.intValue());
        grillaDTO.setPagination(Constants.CANT_FILAS);


        return grillaDTO;

    }*/
}
