package pe.com.microdata.cjava.dataaccess.domain.administracion.persona;

import java.util.List;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.dataaccess.base.GenericDAO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.ClienteVO;

public interface ClienteDAO extends GenericDAO<ClienteVO, Integer> {

    public ClienteVO obtenerAlumnoPorNombreUsuario(String nomPersona);

    public ClienteVO obtenerAlumnoPorIdAlumno(Integer idAlumno);

    public List<ClienteVO> obtenerAlumnosPorBusqueda(BusquedaDTO busquedaDTO);

    public Long obtenerTotalAlumnosPorBusqueda(BusquedaDTO busquedaDTO);

    public List obtenerAlumnoPorIdAlumnoLista(Integer idAlumno);

    public Boolean existeUsuario(String usuario);

    public List obtenerTotalAlumnos();

    public List obtenerNombreDNIAlumnosPorBusqueda(String strBusqueda);

    public List obtenerAlumnosConCursoPorBusqueda(BusquedaDTO busquedaDTO);

    public Long obtenerTotalAlumnosConCursoPorBusqueda(BusquedaDTO busquedaDTO);
}