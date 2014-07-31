/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.acceso.validador;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pe.com.microdata.cjava.common.validador.Validador;
import pe.com.microdata.cjava.service.acceso.dto.UsuarioSeguridadDTO;


@Service("bloquearAlumnoValidador")
public class BloquearAlumnoValidador implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return UsuarioSeguridadDTO.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UsuarioSeguridadDTO dto = (UsuarioSeguridadDTO) target;             
        if(!Validador.noNulo(dto.getEstadoBloqueado()))
            errors.rejectValue("estadoBloqueado", "val.segu.estado");
    }
                   
}
