package pe.com.microdata.cjava.dataaccess.domain.operacion.operacion;

import java.util.List;
import pe.com.microdata.cjava.dataaccess.base.GenericDAO;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.dataaccess.model.operacion.alquilado.AlquilarVO;

public interface OperacionDAO extends GenericDAO<AlquilarVO, Integer> {

    public AlquilarVO obtenerCursosActivosPorIdOperacion(Integer idOperacion);

    public AlquilarVO obtenerEstadoPorIdOperacion(Integer idOperacion);

    public AlquilarVO obtenerOperacionPorId(Integer idOperacion);
    
    public AlquilarVO obtenerOperacionEInstructorPorIdOp(Integer idOperacion);

    public List obtenerOperacionPorIdOperacionLista(Integer idOperacion);

    public AlquilarVO obtenerOperacionPorIdOperacion(Integer idOperacion);

    public List<AlquilarVO> obtenerCursosActivosPorBusqueda(BusquedaDTO busquedaDTO);

    public Long obtenerTotalOperacionesAlumnosPorBusqueda(BusquedaDTO busquedaDTO);

    public List obtenerAlumnosPorIdOperacion(Integer idOpe);

    public AlquilarVO obtenerOperacionConInstructoresPorIdOperacion(Integer idOpe);

    public AlquilarVO obtenerCalificacionesPorIdOperacion(Integer idOperacion);

    public AlquilarVO obtenerOperacionConAlumnosPorIdOperacion(Integer idOpe);

    public AlquilarVO obtenerCalificacionesyDetalleCalifPorIdOperacion(Integer idOperacion);

    public AlquilarVO obtenerOperacionConTipoPorIdOperacion(Integer idOperacion);

    public AlquilarVO obtenerDatosCabeceraOperacionPorIdOperacion(Integer idOperacion);

    public List<AlquilarVO> obtenerOperacionConInscripcionAlumnoPorBuqueda(BusquedaDTO busquedaDTO);
    
    public Long obtenerTotalOperacionConInscripcionAlumnoPorBuqueda(BusquedaDTO busquedaDTO);
    
    public List obtenerListaCursosPorIdAlumno(Integer idAlummo);
    
    public Long obtenerTotalEncuestadosPorIdOperacion(Integer idOperacion);
}