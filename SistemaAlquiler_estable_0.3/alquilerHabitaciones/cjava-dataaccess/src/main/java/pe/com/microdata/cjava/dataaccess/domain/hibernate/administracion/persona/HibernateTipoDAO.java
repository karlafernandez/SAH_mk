package pe.com.microdata.cjava.dataaccess.domain.hibernate.administracion.persona;
 
import pe.com.microdata.cjava.dataaccess.base.hibernate.HibernateGenericDAO;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.TipoDAO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.TipoVO;


/*******************************************************************************
Fecha de creación: 11-01-2012
Nombre: Jimmy Valverde Sanchez
Descripción: Implementacion de la Interfaz TipoDAO
Actualizaciones:
Fecha           Autor			Descripción
--------------------------------------------------------------------------------

*******************************************************************************/
public class HibernateTipoDAO extends HibernateGenericDAO<TipoVO, Integer>
        implements TipoDAO {
    
    public HibernateTipoDAO() {
        super(TipoVO.class);
    }    
}