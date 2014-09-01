package pe.com.microdata.cjava.dataaccess.domain.administracion.persona;

import java.util.List;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.dataaccess.base.GenericDAO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.PersonaVO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.ClienteVO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.ArrendatarioVO;

public interface ArrendatarioDAO extends GenericDAO<ArrendatarioVO, Integer> {

     public ArrendatarioVO obtenerArrendatarioPorIdArrendatario(Integer idInstructor);
    /*
    public ArrendatarioVO obtenerInstructorPorNombreUsuario(String nomPersona);

   

    public List obtenerInstructorPorIdInstructorLista(Integer idInstructor);

   

   

    public Boolean existeUsuario(String usuario);
    
    public List obtenerNombreDniInstructorPorBusqueda(String strBusqueda);
    
    public ArrendatarioVO obtenerInstructorPorIdPersona(Integer idPersona);
    
    */
     
      public Long obtenerTotalArrendatariosPorBusqueda(BusquedaDTO busquedaDTO);
      
       public List<ArrendatarioVO> obtenerArrendatarioPorBusqueda(BusquedaDTO busquedaDTO);
}