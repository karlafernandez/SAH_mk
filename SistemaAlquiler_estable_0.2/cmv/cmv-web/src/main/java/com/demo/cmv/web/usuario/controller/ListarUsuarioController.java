/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.cmv.web.usuario.controller;

import com.demo.cmv.service.cliente.GestionarCliente;
import com.demo.cmv.service.cliente.dto.ClienteDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author meliMeli
 */
@Controller
@RequestMapping("/lista-usuario")
public class ListarUsuarioController {

    private static final String REDIRECCIONAR = "redirect:/lista-usuario.html";
    private static final String NOREDIRECCIONAR = "lista-usuario";
    @Autowired
    GestionarCliente gestionarPaciente;

    @RequestMapping( method = RequestMethod.GET)
    public String vista(Model model) { 

        List<ClienteDTO> list = gestionarPaciente.obtenerCliente();
        model.addAttribute("lstPacientes", list);
        return NOREDIRECCIONAR;
    }
}
