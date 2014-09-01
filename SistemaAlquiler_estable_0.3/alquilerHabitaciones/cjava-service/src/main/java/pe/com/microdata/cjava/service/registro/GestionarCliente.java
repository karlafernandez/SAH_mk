/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.registro;

import java.util.List;

import pe.com.microdata.cjava.service.registro.dto.ClienteDTO;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.service.registro.dto.HistorialCursoDTO;


public interface GestionarCliente {

    public SIGAMessage registrarCliente(ClienteDTO alumnoDTO);

    public SIGAMessage modificarCliente(ClienteDTO alumnoDTO);

    public void eliminarCliente(Integer alumno);

    public ClienteDTO obtenerClientePorId(Integer idPersona);

    public ClienteDTO obtenerCodigoAutogenerado(BusquedaDTO busquedaDTO);

   // public HistorialCursoDTO obtenerHistorialCursoPorIdAlumno(Integer idAlum);

    public List obtenerTotalClientes();

    public List obtenerClientePorBusqueda(BusquedaDTO busquedaDTO);

    public Long obtenerTotalClientesPorBusqueda(BusquedaDTO busquedaDTO);
    
}
