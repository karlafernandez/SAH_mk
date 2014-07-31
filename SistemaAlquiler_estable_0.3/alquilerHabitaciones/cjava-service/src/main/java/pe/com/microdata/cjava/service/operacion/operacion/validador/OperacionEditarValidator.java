/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.operacion.operacion.validador;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.service.operacion.operacion.dto.AperturaDTO;

/**
 *
 * @author César Bragagnini
 */
@Service("operacionEditarValidator")
public class OperacionEditarValidator implements Validator{

    private SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.FORMATO_FECHA);
    
    @Override
    public boolean supports(Class<?> clazz) {
        return OperacionEditarValidator.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AperturaDTO dto = (AperturaDTO) target;
        Date actual = null;
        Date fecInicio = null;
        Date fecFin = null;
        try{
            String fechaHoy = dateFormat.format(Calendar.getInstance().getTime());
            actual = dateFormat.parse(fechaHoy);            
            fecInicio = dateFormat.parse(dto.getFechaInicio()!= null ? dto.getFechaInicio() : "16/05/1991");
            fecFin = dateFormat.parse(dto.getFechaFin() != null ? dto.getFechaFin() : "16/05/1991");
        }catch(Exception e){
            e.printStackTrace();
        }
        
        if(fecInicio.compareTo(actual) < 0){           
            errors.rejectValue("fechaInicio", "val.operacion.curso_activar.fec_ini");
        }
        if(fecFin.compareTo(actual) < 0 || fecFin.compareTo(fecInicio) < 0){            
            errors.rejectValue("fechaFin", "val.operacion.curso_activar.fec_fin");
        }
    }
                 
}
