/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.operacion.operacion_cliente.validador;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pe.com.microdata.cjava.common.validador.Validador;
import pe.com.microdata.cjava.service.operacion.operacion_cliente.dto.EntregaFotoDTO;

/**
 *
 * @author César Bragagnini
 */
@Service("entregaFotoValidador")
public class EntregaFotoValidador implements Validator{

    private static final Logger logger = Logger.getLogger(EntregaFotoValidador.class.getName());
    
    @Override
    public boolean supports(Class<?> clazz) {
        return EntregaFotoValidador.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        EntregaFotoDTO dto = (EntregaFotoDTO) target;
        if(!Validador.esMayorCero(dto.getIdOperacion()))
            errors.rejectValue("idOperacion", "val.opealu.entfoto.operacion");
        if(!Validador.esMayorCero(dto.getIdOpeAlum()))
            errors.rejectValue("idOpeAlum", "val.opealu.entfoto.idalum");
        if(!Validador.esMayorIgualCero(dto.getNumFoto())){
            errors.rejectValue("numFoto", "val.opealu.entfoto.foto");        
            logger.info(" numero de fotos ");
        }
    }
                    
}
