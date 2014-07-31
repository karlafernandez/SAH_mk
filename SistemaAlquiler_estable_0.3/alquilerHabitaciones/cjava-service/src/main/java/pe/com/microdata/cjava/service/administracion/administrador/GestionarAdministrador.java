/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.administracion.administrador;

import java.util.List;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.service.administracion.administrador.dto.AdministradorDTO;


public interface GestionarAdministrador {
    
    public AdministradorDTO obtenerAdministradorPorId(Integer idAdmin);
    public SIGAMessage registrarAdministrador(AdministradorDTO adminDTO);
    public SIGAMessage modificarAdministrador(AdministradorDTO adminDTO);
    public SIGAMessage eliminarAdministrador(Integer idAdmin);    
    public List obtenerAdministradorPorBusqueda(BusquedaDTO busquedaDTO);
    public Long obtenerTotalAdministradoresPorBusqueda(BusquedaDTO busquedaDTO) ;
    
}
