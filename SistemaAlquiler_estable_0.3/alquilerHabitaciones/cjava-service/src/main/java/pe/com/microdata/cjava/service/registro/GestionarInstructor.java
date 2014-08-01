/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.registro;

import java.util.List;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
 
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.service.registro.dto.ArrendatarioDTO;

/**
 *
 * @author meliMeli
 */
public interface GestionarInstructor {

    public SIGAMessage registrarInstructor(ArrendatarioDTO instructorDTO);

    public ArrendatarioDTO obtenerInstructorPorId(Integer idInstructor);

    public SIGAMessage modificarInstructor(ArrendatarioDTO instructorDTO);

    public void eliminarInstructor(Integer instructor);
    
    public List obtenerInstructorPorBusqueda(BusquedaDTO busquedaDTO);
     
    public Long obtenerTotalInstructoresPorBusqueda(BusquedaDTO busquedaDTO) ;
}
