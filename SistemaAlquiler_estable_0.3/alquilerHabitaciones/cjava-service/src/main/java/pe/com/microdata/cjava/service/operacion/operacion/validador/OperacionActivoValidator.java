/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.operacion.operacion.validador;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.common.validador.Validador;
import pe.com.microdata.cjava.service.operacion.operacion.dto.OperacionActivoDTO;

/**
 *
 * @author César Bragagnini
 */
@Service("operacionActivoValidator")
public class OperacionActivoValidator implements Validator{

    SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.FORMATO_FECHA);
    
    private static Logger logger = Logger.getLogger(OperacionActivoValidator.class);
    
    @Override
    public boolean supports(Class<?> type) {
        return OperacionActivoDTO.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        OperacionActivoDTO dto = (OperacionActivoDTO) o;
        
        int idCurEsp = dto.getIdCurEsp() != null ? dto.getIdCurEsp() : 0;
        int idTurno = dto.getIdTurno() != null ? dto.getIdTurno() : 0;
        int idEmpresa = dto.getIdEmpresa() != null ? dto.getIdEmpresa() : 0;        
        Date actual = null;
        Date fecInicio = null;
        Date fecFin = null;
        try{
            String fechaHoy = dateFormat.format(Calendar.getInstance().getTime());
            actual = dateFormat.parse(fechaHoy);            
            fecInicio = dateFormat.parse(dto.getFecInicio() != null ? dto.getFecInicio() : "16/05/1991");
            fecFin = dateFormat.parse(dto.getFecFin() != null ? dto.getFecFin() : "16/05/1991");
        }catch(Exception e){
            e.printStackTrace();
        }    
                        
        if(idCurEsp == 0 ){
            logger.info("===> curso especifico\n");
            errors.rejectValue("idCurEsp", "val.operacion.curso_activar.cur_esp");
        }    
        
        if(idTurno == 0){
            logger.info("===> turno \n");
            errors.rejectValue("idTurno", "val.operacion.curso_activar.turno");            
        }    
        if(dto.getTipoCurso() && idEmpresa == 0){
            logger.info("===> empresa \n");
            errors.rejectValue("tipoCurso", "val.operacion.curso_activar.tipo_curso");
        }    
        if(fecInicio.compareTo(actual) < 0){
            logger.info("===> fecInicio \n");
            errors.rejectValue("fecInicio", "val.operacion.curso_activar.fec_ini");
        }
        if(fecFin.compareTo(actual) < 0 || fecFin.compareTo(fecInicio) < 0){
            logger.info("===> fecFin \n");
            errors.rejectValue("fecFin", "val.operacion.curso_activar.fec_fin");
        }
        if(!Validador.noNuloNoVacio(dto.getNomSalon()))
            errors.rejectValue("nomSalon", "val.operacion.curso_activar.nom_salon");
    }
           
}
