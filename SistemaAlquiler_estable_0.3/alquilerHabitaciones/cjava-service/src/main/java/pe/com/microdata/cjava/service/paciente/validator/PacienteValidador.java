/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.paciente.validator;

import pe.com.microdata.cjava.service.paciente.dto.PacienteDTO;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
 
   

/**
 *
 * @author MELImeli
 */


@Service("registrarValidador")
public class PacienteValidador implements Validator {

    @SuppressWarnings("unchecked")
     
    @Override
    public boolean supports(Class<?> clazz) {
        return PacienteDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        PacienteDTO pacienteDTO = (PacienteDTO) target;
        if(pacienteDTO.getNombre()==null ){
            errors.rejectValue("nombre", "val.nombre"); 
        }
         

    }
}
