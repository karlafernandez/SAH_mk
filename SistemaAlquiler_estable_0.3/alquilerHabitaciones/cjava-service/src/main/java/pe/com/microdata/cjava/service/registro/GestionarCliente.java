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

/**
 *
 * @author meliMeli
 * @author maparicio
 */
public interface GestionarCliente {

    public SIGAMessage registrarAlumno(ClienteDTO alumnoDTO);

    public SIGAMessage modificarAlumno(ClienteDTO alumnoDTO);

    public void eliminarAlumno(Integer alumno);

    public ClienteDTO obtenerAlumnoPorId(Integer idPersona);

    public ClienteDTO obtenerCodigoAutogenerado(BusquedaDTO busquedaDTO);

   // public HistorialCursoDTO obtenerHistorialCursoPorIdAlumno(Integer idAlum);

    public List obtenerTotalAlumnos();

    public List obtenerAlumnoPorBusqueda(BusquedaDTO busquedaDTO);

    public Long obtenerTotalAlumnosPorBusqueda(BusquedaDTO busquedaDTO);
}
