package pe.com.microdata.cjava.dataaccess.domain.hibernate.administracion.persona;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Order;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import pe.com.microdata.cjava.dataaccess.base.hibernate.HibernateGenericDAO;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.SubtipoDAO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.SubTipoVO;

/*******************************************************************************
Fecha de creación: 02-02-2011
Nombre: Jimmy Valverde Sanchez
Descripción: Implementacion de la Interfaz SubTipoDAO
Actualizaciones:
Fecha           Autor			Descripción
--------------------------------------------------------------------------------

*******************************************************************************/
public class HibernateSubTipoDAO extends HibernateGenericDAO<SubTipoVO,Integer> implements SubtipoDAO {

    public HibernateSubTipoDAO() {
        super(SubTipoVO.class);
    }

    /***************************************************************************
    Descripcion: Obtiene una lista de SubTipoVOs a partir de un id de TipoVO
    Parametros de Entrada: idTipo id del TipoVO
    Parametros de Salida: List: lista de subtipos
    ***************************************************************************/
    @Override
    public List getSubTiposPorTipo(Integer idTipo) {
        List subTipos = new ArrayList();
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SubTipoVO.class);
        detachedCriteria.createAlias("tipoVO", "tipo");
        detachedCriteria.add(Restrictions.eq("tipo.idTipo", idTipo));
        detachedCriteria.addOrder(org.hibernate.criterion.Order.asc("idSubTipo"));
        subTipos = listByCriteria(detachedCriteria);
        return subTipos;
    }

    @Override
    public SubTipoVO obtenerSubtipoPorId(Integer idSubtipo) {
        SubTipoVO subtipo = null;
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SubTipoVO.class);
        detachedCriteria.add(Restrictions.eq("idSubTipo", idSubtipo));
        List subtipos = listByCriteria(detachedCriteria);
        if (!subtipos.isEmpty()) {
            subtipo = (SubTipoVO) subtipos.get(0);
        }
        return subtipo;
    }

    @Override
    public SubTipoVO obtenerSubtipoPorNom(String keyNom) {
        SubTipoVO subtipo = null;
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SubTipoVO.class);
        detachedCriteria.add(Restrictions.eq("nomSubtipo", keyNom));
        List<SubTipoVO> listSubtipo = listByCriteria(detachedCriteria);
        if(!listSubtipo.isEmpty())
            subtipo = listSubtipo.get(0);
        return subtipo;
    }        
}