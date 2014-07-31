package pe.com.microdata.cjava.dataaccess.domain.log;

import java.util.List;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.dataaccess.base.GenericDAO;
import pe.com.microdata.cjava.dataaccess.model.log.LogVO;

public interface LogDAO extends GenericDAO<LogVO, Integer> {

    public List obtenerLogsPorBusqueda(BusquedaDTO busquedaDTO);

    public Long obtenerTotalLogsPorBusqueda(BusquedaDTO busquedaDTO);

    public LogVO obtenerLogId(Integer idLog);

}
