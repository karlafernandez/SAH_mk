/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.operacion.operacion_cliente.validador;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pe.com.microdata.cjava.common.validador.Validador;
import pe.com.microdata.cjava.service.operacion.operacion_cliente.dto.AsignarAlumnoOperacionDTO;

/**
 *
 * @author César Bragagnini
 */
@Service("asignarAlumnoValidador")
public class AsignarAlumnoValidador implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return AsignarAlumnoValidador.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AsignarAlumnoOperacionDTO dto = (AsignarAlumnoOperacionDTO) target;
        if(!Validador.esMayorCero(dto.getIdAlumno()) || !Validador.esMayorCero(dto.getIdOperacion()) || !Validador.esMayorIgualCero(dto.getCantFotos()))
            errors.rejectValue("hayUnError", "hayUnError");        
    }
           
}
