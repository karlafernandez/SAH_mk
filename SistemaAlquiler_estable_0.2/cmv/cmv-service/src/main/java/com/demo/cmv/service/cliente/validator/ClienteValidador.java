/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.cmv.service.cliente.validator;

import com.demo.cmv.service.cliente.dto.ClienteDTO;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
 
   

/**
 *
 * @author MELImeli
 */


@Service("registrarValidador")
public class ClienteValidador implements Validator {

    @SuppressWarnings("unchecked")
     
    @Override
    public boolean supports(Class<?> clazz) {
        return ClienteDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ClienteDTO pacienteDTO = (ClienteDTO) target;
        if(pacienteDTO.getNombre()==null ){
            errors.rejectValue("nombre", "val.nombre"); 
        }
         

    }
}
