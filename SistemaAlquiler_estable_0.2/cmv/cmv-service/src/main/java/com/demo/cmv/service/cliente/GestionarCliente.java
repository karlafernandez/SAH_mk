/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.cmv.service.cliente;

import com.demo.cmv.service.cliente.dto.ClienteDTO;
import java.util.List;

/**
 *
 * @author Alejandra Gonzales
 */
public interface GestionarCliente {

    public List obtenerCliente();
    
    public boolean registrarCliente(ClienteDTO pacienteDTO);
    
    
    
    
    
}
