package pe.com.microdata.cjava.dataaccess.domain.operacion.operacion;

import java.util.List;
import java.util.Set;
import pe.com.microdata.cjava.dataaccess.base.GenericDAO;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.dataaccess.model.operacion.alquilado.OperacionClienteVO;

public interface OperacionClienteDAO extends GenericDAO<OperacionClienteVO, Integer> {

    public OperacionClienteVO obtenerOpeAlumnoPorIdOpeAlumno(Integer idOpeAlumno);

    public List obtenerOpeAlumnoPorIdOpeAlumnoLista(Integer idOpeAlumno);

    public List obtenerOpeAlumnoConAsistenciaPorBusqueda(BusquedaDTO busquedaDTO);

    public OperacionClienteVO obtenerDetalleAlumnoPorIdOpeAlumno(Integer idOpeAlumno);

    public List<OperacionClienteVO> obtenerOpeAlumnoPorBusqueda(BusquedaDTO busquedaDTO);

    public Long obtenerTotalOpeAlumnosPorBusqueda(BusquedaDTO busquedaDTO);

    public Boolean existeAlumnosParaCursoActivo(Integer idOpeAlumno);

    public Boolean existeSesionesParaCursoActivo(Integer idSesiones);

    public List obtenerOpeAlumnoPorIdOperacion(Integer idOperacion);

    public List obtenerListaOpeAlumnoPorIdOperacion(Integer idOperacion);

    public List<OperacionClienteVO> obtenerListaOperacionPorIdAlum(Integer idAlum);

    public List obtenerTotalAlumnosPorIdsOperaciones(Set<Integer> keySet, BusquedaDTO busquedaDTO);

    public List obtenerAbandonosOpAlumnoPorBusqueda(BusquedaDTO busquedaDTO);

    public List obtenerListaOpeAluConDatosAlumPorIdOperacion(Integer idOperacion);

    public List<OperacionClienteVO> obtenerListaOperacionPorIdAlumnoYListaIdCursoEspecifico(Integer idAlumno, Set<Integer> keyIdCurEsp);

    public OperacionClienteVO obtenerOpeAlumnoPorIdOperacionyIdAlumno(Integer idOperacion, Integer idAlumno);
    
    /*Record de Estudiantes*/
    
    public  List<OperacionClienteVO> obtenerOpeAlumnosRecordPorBusqueda(BusquedaDTO busquedaDTO);
    
    public  Boolean existeOpeAlumnosRecordPorBusqueda(BusquedaDTO busquedaDTO);
}
