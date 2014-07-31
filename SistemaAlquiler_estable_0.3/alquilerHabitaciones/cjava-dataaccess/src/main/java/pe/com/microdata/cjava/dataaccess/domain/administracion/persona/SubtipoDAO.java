package pe.com.microdata.cjava.dataaccess.domain.administracion.persona;

import java.util.List;
import pe.com.microdata.cjava.dataaccess.base.GenericDAO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.SubTipoVO;



/*******************************************************************************
Fecha de creación: 10-01-2012
Nombre: Jimmy Valverde Sanchez
Descripción: Interfaz SubTipoDAO
Actualizaciones:
Fecha           Autor			Descripción
--------------------------------------------------------------------------------

*******************************************************************************/
public interface SubtipoDAO extends GenericDAO<SubTipoVO, Integer> {
    
    /***************************************************************************
    Descripcion: Obtiene una lista de SubTipoVOs a partir de un id de TipoVO
    Parametros de Entrada: idTipo id del TipoVO
    Parametros de Salida: List: lista de subtipos
    ***************************************************************************/
    public List getSubTiposPorTipo(Integer idTipo);
    
    public SubTipoVO obtenerSubtipoPorId(Integer idSubtipo);
    public SubTipoVO obtenerSubtipoPorNom(String keyNom);
}