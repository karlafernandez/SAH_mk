/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.registro;

import java.util.List;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
 
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.service.registro.dto.InstructorDTO;

/**
 *
 * @author meliMeli
 */
public interface GestionarInstructor {

    public SIGAMessage registrarInstructor(InstructorDTO instructorDTO);

    public InstructorDTO obtenerInstructorPorId(Integer idInstructor);

    public SIGAMessage modificarInstructor(InstructorDTO instructorDTO);

    public void eliminarInstructor(Integer instructor);
    
    public List obtenerInstructorPorBusqueda(BusquedaDTO busquedaDTO);
     
    public Long obtenerTotalInstructoresPorBusqueda(BusquedaDTO busquedaDTO) ;
}
