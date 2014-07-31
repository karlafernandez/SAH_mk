/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.dataaccess.domain.archivo.hibernate;
 
import java.util.List;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import pe.com.microdata.cjava.dataaccess.base.hibernate.HibernateGenericDAO;
import pe.com.microdata.cjava.dataaccess.domain.archivo.ArchivoDAO;
import pe.com.microdata.cjava.dataaccess.model.archivo.ArchivoVO;

/**
 *
 * @author Alejandra Gonzales
 */
public class HibernateArchivoDAO extends HibernateGenericDAO<ArchivoVO, Integer>
        implements ArchivoDAO {

    public HibernateArchivoDAO() {
        super(ArchivoVO.class);
    }

    @Override
    public List<ArchivoVO> obtenerArchivos() {
        ArchivoVO empVO = new ArchivoVO();
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ArchivoVO.class);
        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.property("idArchivo"));
        projectionList.add(Projections.property("nomArchivo"));
        projectionList.add(Projections.property("extension"));
        projectionList.add(Projections.property("ruta"));
        detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        
        List<ArchivoVO> archivoVOs = listByCriteria(detachedCriteria);
        return archivoVOs;
    }

}
