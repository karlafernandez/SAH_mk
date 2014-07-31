package pe.com.microdata.cjava.dataaccess.domain.acceso;

import java.util.List;
import pe.com.microdata.cjava.dataaccess.base.GenericDAO;
import pe.com.microdata.cjava.dataaccess.model.acceso.AccesoModuloVO;
 


public interface AccesoModuloDAO extends GenericDAO<AccesoModuloVO, Integer> {

      public List<AccesoModuloVO> obtenerModulosAccesos();
 
  

}