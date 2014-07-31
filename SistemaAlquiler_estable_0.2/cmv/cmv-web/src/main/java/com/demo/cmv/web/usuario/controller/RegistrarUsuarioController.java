/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.cmv.web.usuario.controller;

import com.demo.cmv.service.cliente.GestionarCliente;
import com.demo.cmv.service.cliente.dto.ClienteDTO;
import com.demo.cmv.service.cliente.validator.ClienteValidador;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Alejandra Gonzales
 */
@Controller
@RequestMapping("/registrar-usuario")
public class RegistrarUsuarioController {

    private static final String NOREDIRECCIONAR = "registrar-usuario";

    private static final String REDIRECCIONAR_LISTADO = "redirect:/lista-usuario.html";

    @Autowired
    GestionarCliente gestionarPaciente;
    
    @Autowired
    ClienteValidador clienteValidador;

    @ModelAttribute("cliente")
    public ClienteDTO model() {
        return new ClienteDTO();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String vista(Model model) {
        return NOREDIRECCIONAR;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registrar(@Valid @ModelAttribute("paciente") ClienteDTO pacienteDTO,
            HttpServletRequest request, ModelMap model, BindingResult result) {
        String view = NOREDIRECCIONAR;
        boolean m = false;
        clienteValidador.validate(pacienteDTO, result);
        if (!result.hasErrors()) { 
            m = gestionarPaciente.registrarCliente(pacienteDTO); 
            if (m) { 
                //se registra
                view = REDIRECCIONAR_LISTADO;
            } else { 
                //no registra
                view = REDIRECCIONAR_LISTADO;
            }
        } else {
            //error la validacion 
        } 

        return view;
    }
}
