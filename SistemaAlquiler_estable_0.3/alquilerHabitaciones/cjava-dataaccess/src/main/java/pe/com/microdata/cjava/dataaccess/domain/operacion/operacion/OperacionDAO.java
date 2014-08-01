package pe.com.microdata.cjava.dataaccess.domain.operacion.operacion;

import java.util.List;
import pe.com.microdata.cjava.dataaccess.base.GenericDAO;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.dataaccess.model.operacion.alquilado.AlquilarVO;

public interface OperacionDAO extends GenericDAO<AlquilarVO, Integer> {

    public AlquilarVO obtenerCursosActivosPorIdOperacion(Integer idOperacion);
   

    public AlquilarVO obtenerEstadoPorIdOperacion(Integer idOperacion);
        
    public List obtenerOperacionPorIdOperacionLista(Integer idOperacion);

      
    public AlquilarVO obtenerOperacionPorIdOperacion(Integer idOperacion);
       
    
  
    
   
}