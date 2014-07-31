/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.administracion.curso.cuarto.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pe.com.microdata.cjava.common.validador.Validador;
import pe.com.microdata.cjava.dataaccess.domain.administracion.curso.CuartoDAO;
import pe.com.microdata.cjava.service.administracion.curso.cuarto.dto.CuartoDTO;


@Service("cuartoValidator")
public class CuartoValidator implements Validator{
    
    @Override
    public boolean supports(Class<?> type) {
        return CuartoDTO.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CuartoDTO dto = (CuartoDTO) o;
        
        int tamStrSesion = dto.getNumAmbientes() == null ? 99999 : (dto.getNumAmbientes().intValue()+"").length();
       // int tamStrHora = dto.getNumHora()== null ? 99999 : (dto.getNumHora().intValue()+"").length();
        int tamStrNomen = dto.getNomenCuarto() == null ? 99999 : dto.getNomenCuarto().length();
                                      
        if(!Validador.noNuloNoVacio(dto.getDireccion())){
            errors.rejectValue("nomCurso", "val.curesp.nombreCurso");            
        }
                             
//        if(!Validador.noNuloNoVacio(dto.getNomenCurso()) || !Validador.esAlfanumerico(dto.getNomenCurso(), tamStrNomen) || tamStrNomen > 15){
//            errors.rejectValue("nomenCurso", "val.curesp.nomenCurso");
//        }
//                
        if(!Validador.esMayorCero(dto.getNumAmbientes()) || !Validador.contieneSoloNumeros(dto.getNumAmbientes()+"")  || tamStrSesion > 4){
            errors.rejectValue("numSesion", "val.curesp.numeroHora");
        }   
        
//        if(!Validador.esMayorCero(dto.getNumSesion()) || !Validador.contieneSoloNumeros(dto.getNumSesion()+"") || tamStrHora > 4){
//            errors.rejectValue("numHora", "val.curesp.numeroSesion");
//        }
        
    }
             
}
