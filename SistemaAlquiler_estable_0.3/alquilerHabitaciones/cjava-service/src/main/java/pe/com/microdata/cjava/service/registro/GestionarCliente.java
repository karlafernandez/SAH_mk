/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.registro;

import java.util.List;

import pe.com.microdata.cjava.service.registro.dto.AlumnoDTO;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.service.registro.dto.HistorialCursoDTO;

/**
 *
 * @author meliMeli
 * @author maparicio
 */
public interface GestionarCliente {

    public SIGAMessage registrarAlumno(AlumnoDTO alumnoDTO);

    public SIGAMessage modificarAlumno(AlumnoDTO alumnoDTO);

    public void eliminarAlumno(Integer alumno);

    public AlumnoDTO obtenerAlumnoPorId(Integer idPersona);

    public AlumnoDTO obtenerCodigoAutogenerado(BusquedaDTO busquedaDTO);

   // public HistorialCursoDTO obtenerHistorialCursoPorIdAlumno(Integer idAlum);

    public List obtenerTotalAlumnos();

    public List obtenerAlumnoPorBusqueda(BusquedaDTO busquedaDTO);

    public Long obtenerTotalAlumnosPorBusqueda(BusquedaDTO busquedaDTO);
}
