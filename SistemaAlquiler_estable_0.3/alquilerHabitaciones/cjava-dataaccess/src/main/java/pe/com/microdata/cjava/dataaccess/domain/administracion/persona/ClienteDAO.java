package pe.com.microdata.cjava.dataaccess.domain.administracion.persona;

import java.util.List;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.dataaccess.base.GenericDAO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.ClienteVO;

public interface ClienteDAO extends GenericDAO<ClienteVO, Integer> {

  
    public ClienteVO obtenerClientePorNombreUsuario(String nomPersona);

    public ClienteVO obtenerClientePorIdCliente(Integer idAlumno);

    public List<ClienteVO> obtenerClientesPorBusqueda(BusquedaDTO busquedaDTO);

    public Long obtenerTotalClientesPorBusqueda(BusquedaDTO busquedaDTO);

    public List obtenerClientePorIdClienteLista(Integer idAlumno);

    public Boolean existeUsuario(String usuario);

    public List obtenerTotalClientes();

    public List obtenerNombreDNIClientesPorBusqueda(String strBusqueda);

    public List obtenerClientesConCursoPorBusqueda(BusquedaDTO busquedaDTO);

    public Long obtenerTotalClientesConCursoPorBusqueda(BusquedaDTO busquedaDTO);

    }