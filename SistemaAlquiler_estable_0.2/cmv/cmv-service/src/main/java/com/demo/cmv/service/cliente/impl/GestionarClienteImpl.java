/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.cmv.service.cliente.impl;

import com.demo.cmv.dataaccess.domain.ClienteDAO;
import com.demo.cmv.dataaccess.model.ClienteVO;
//import com.demo.cmv.dataaccess.model.SubTipoVO;
import com.demo.cmv.service.cliente.GestionarCliente;
import com.demo.cmv.service.cliente.dto.ClienteDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author meliMeli
 */
@Service("gestionarCliente")
public class GestionarClienteImpl implements GestionarCliente{

    @Autowired
    ClienteDAO pacienteDAO;

    @Override
    public List obtenerCliente() {
        List<ClienteDTO> pacienteDTOs = new ArrayList<ClienteDTO>();
        List<ClienteVO> pacienteVOs = pacienteDAO.getAll();
        ClienteDTO clienteDTO = new ClienteDTO();
        for (ClienteVO pacienteVO : pacienteVOs) {
            clienteDTO = new ClienteDTO();
            clienteDTO.setNombre(pacienteVO.getNombre());
            clienteDTO.setApellido(pacienteVO.getApellido());
           
            pacienteDTOs.add(clienteDTO);

        }
        return pacienteDTOs;


    }

    @Override
    public boolean registrarCliente(ClienteDTO dto) {
        boolean registrado = false;
        ClienteVO vo = new ClienteVO();
        vo.setNombre(dto.getNombre());
        vo.setApellido(dto.getApellido());
       
       // vo.setTipDocumento(new SubTipoVO(dto.getIdTipoDocumento()));
        Integer id = pacienteDAO.insert(vo);
        if (id != 0) {
            registrado = true;
        }
        return registrado; 
    }
}
