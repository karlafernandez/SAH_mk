/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.registro;

import java.util.List;
import pe.com.microdata.cjava.common.base.BusquedaDTO;

import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.ArrendatarioVO;
import pe.com.microdata.cjava.service.registro.dto.ArrendatarioDTO;

/**
 *
 * @author meliMeli
 */
public interface GestionarArrendatario {
    
     public SIGAMessage registrarArrendatario(ArrendatarioDTO instructorDTO);

     public ArrendatarioDTO obtenerArrendatarioPorId(Integer idInstructor);

     public SIGAMessage modificarArrendatario(ArrendatarioDTO instructorDTO);

   
    
   

     

    //public ArrendatarioVO obtenerArrendatarioPorIdArrendatario(Integer idArrendatario);
    
    public Long obtenerTotalArrendatariosPorBusqueda(BusquedaDTO busquedaDTO);
    
     public List obtenerArrendatarioPorBusqueda(BusquedaDTO busquedaDTO);
    public void eliminarArrendatario(Integer arrendatario);

    
   

   
}
