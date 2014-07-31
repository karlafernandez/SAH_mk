package pe.com.microdata.cjava.dataaccess.domain.administracion.persona;

import java.util.Date;
import java.util.List;
import pe.com.microdata.cjava.dataaccess.base.GenericDAO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.PersonaVO;
import pe.com.microdata.cjava.common.base.BusquedaDTO;

public interface PersonaDAO extends GenericDAO<PersonaVO, Integer> {

    public PersonaVO obtenerUsuarioPorNombreUsuario(String nomUsuario);

    public PersonaVO obtenerPersonaPorIdPersona(Integer idPersona);
    
     public List<PersonaVO> obtenerPersonasPorNombre(String[] arrNombres);
     
     public List<PersonaVO> obtenerPersonasPorBusqueda(BusquedaDTO busquedaDTO); 

    public PersonaVO obtenerPersonaPorId(Integer idUsuario);    
    
    public List<PersonaVO> obtenerListaUsurioPorBusquedaYTipo(BusquedaDTO busquedaDTO, Integer idTipo);
    
    public Long obtenerTotalUsurioPorBusquedaYTipo(BusquedaDTO busquedaDTO, Integer idTipo);
    
    public Boolean existeUsuario(String usuario);
    
    public List<PersonaVO> obtenerListaCumpleanio(Integer month);
    
}