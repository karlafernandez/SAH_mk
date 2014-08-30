/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sah.business.bo;

import com.sah.business.dto.ClienteDTO;
import com.sah.model.dao.ClienteDAOHibernate;

/**
 *
 * @author Meli
 */
public class ClienteBO {
    private ClienteDAOHibernate clienteDAOHibernate=new ClienteDAOHibernate();
    
    public boolean insertHabitacion(ClienteDTO clienteDTO){
        return clienteDAOHibernate.insert(clienteDTO);
    }
    public boolean updatehabitacion(ClienteDTO clienteDTO){
        return clienteDAOHibernate.update(clienteDTO);
    }
    public boolean deleteHabitacion(ClienteDTO clienteDTO){
        return clienteDAOHibernate.delete(clienteDTO);
    }
    
}
