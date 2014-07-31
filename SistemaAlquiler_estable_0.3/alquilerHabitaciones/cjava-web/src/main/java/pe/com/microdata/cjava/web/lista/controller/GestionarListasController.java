/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.lista.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.com.microdata.cjava.common.base.ItemUbigeoDTO;
import pe.com.microdata.cjava.service.gestionar_listas.GestionarListas;


@Controller
public class GestionarListasController {

    @Autowired
    GestionarListas gestionarListas;

    @RequestMapping(value = "/obtenerPais", method = RequestMethod.GET)
    public @ResponseBody
    List<ItemUbigeoDTO> obtenerPaises(Model model) {
        return gestionarListas.obtenerPaises();
    }

    @RequestMapping(value = "/obtenerDepartamentos", method = RequestMethod.GET)
    public @ResponseBody
    List<ItemUbigeoDTO> obtenerDepartamentos(@RequestParam("codPais") String codPais,   Model model) {
        return gestionarListas.obtenerDepartamentosPorPais(codPais);
    }

    @RequestMapping(value = "/obtenerProvincias", method = RequestMethod.GET)
    public @ResponseBody
    List<ItemUbigeoDTO> obtenerProvincias(@RequestParam("codPais") String codPais, @RequestParam("codDepartamento") String codDepartamento, Model model) {
        return gestionarListas.obtenerProvinciaPorDepartamento(codPais,codDepartamento);

    }

    @RequestMapping(value = "/obtenerDistritos", method = RequestMethod.GET)
    public @ResponseBody
    List<ItemUbigeoDTO> obtenerDistritos(@RequestParam("codPais") String codPais, @RequestParam("codDepartamento") String codDepartamento, @RequestParam("codProvincia") String codProvincia, Model model) {
        return gestionarListas.obtenerDistritoPorProvincia(codPais,codDepartamento,codProvincia);

    }
}
