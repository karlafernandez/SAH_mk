/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sah.model.dao;

import com.sah.business.dto.ClienteDTO;
import com.sah.business.dto.HabitacionDTO;
import com.sah.model.entities.Arrendatario;
import com.sah.model.entities.Cliente;
import com.sah.model.entities.Cuarto;
import java.util.logging.Logger;

/**
 *
 * @author Meli
 */
public class ClienteDAOHibernate extends DAOGenerico{

    public ClienteDAOHibernate() {
        logger=Logger.getLogger(ClienteDAOHibernate.class.getName());
    }
    
    @Override
    public ClienteDTO convertPojo_DTO(Object object) {
        Cliente cliente=(Cliente)object;
        ClienteDTO clienteDTO=new ClienteDTO();
       // habitacionDTO.setArrendatario(cuarto.getArrendatario().getIdArrendatario());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setApellido(cliente.getApellido());
        clienteDTO.setCorreo(cliente.getCorreo());
        return clienteDTO;
    }

    @Override
    public Cliente convertDTO_Pojo(Object object) {
        Cliente cliente=new Cliente();
        ClienteDTO clienteDTO=(ClienteDTO)object;
        
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellido(clienteDTO.getApellido());   
        cliente.setCorreo(clienteDTO.getCorreo());
        return cliente;
    } 
    }
