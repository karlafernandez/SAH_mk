/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.dataaccess.domain.hibernate.administracion.cuarto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.common.base.CondicionDTO;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.common.base.ReglaDTO;
import pe.com.microdata.cjava.dataaccess.base.hibernate.HibernateGenericDAO;
import pe.com.microdata.cjava.dataaccess.domain.administracion.cuarto.CuartoDAO;
import pe.com.microdata.cjava.dataaccess.model.administracion.curso.CuartoVO;
import pe.com.microdata.cjava.dataaccess.util.GeneradorRestricciones;


public class HibernateCuartoDAO extends HibernateGenericDAO<CuartoVO, Integer>
    implements CuartoDAO{
   
    HashMap<String, ReglaDTO> eq;  
    
    public HibernateCuartoDAO() {
        super(CuartoVO.class);
        eq = new HashMap<String, ReglaDTO>();
      //  eq.put("buscarIdCuarto", new ReglaDTO(Constants.OPE_EQ, Constants.TYPE_INTEGER, "idCuarto" ));
       // eq.put("buscarPorNombre", new ReglaDTO(Constants.OPE_EQ, Constants.TYPE_STRING, "nomCursoEspecifico"));    
      //  eq.put("buscarPorNomemclatura", new ReglaDTO(Constants.OPE_EQ, Constants.TYPE_STRING, "nomenCursoEspecifico"));
    }
        /*
    @Override
    public CuartoVO obtenerCuartoPorId(Integer id) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CuartoVO.class);
        CuartoVO curEspVO = null;
        detachedCriteria.add(Restrictions.eq("idCuarto", id));        
        List<CuartoVO> listaCursoEspVO = new ArrayList<CuartoVO>();
        listaCursoEspVO = listByCriteria(detachedCriteria);
        if(!listaCursoEspVO.isEmpty()){
            curEspVO = listaCursoEspVO.get(0);
        }
        return curEspVO;                      
    }

    @Override
    public List<CuartoVO> obtenerListaCuartoPorBusqueda(BusquedaDTO busquedaDTO) {
        List<CuartoVO> listaCursoEspe = new ArrayList<CuartoVO>();
        ReglaDTO reglasDTO;
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CuartoVO.class);
        detachedCriteria.add(Restrictions.eq("actCurEsp", Boolean.TRUE));
        
        if(busquedaDTO != null && busquedaDTO.getCondiciones() != null)   {
            for(CondicionDTO condicionDTO : busquedaDTO.getCondiciones()){
                reglasDTO = new ReglaDTO();
                if(eq.containsKey(condicionDTO.getField())){
                    reglasDTO = eq.get(condicionDTO.getField());
                    reglasDTO.setData("%"+condicionDTO.getData()+"%");
                    Criterion c = GeneradorRestricciones.generar(reglasDTO);
                    if(c != null)
                            detachedCriteria.add(c);
                }
            }
        } 
        
        if(busquedaDTO.getOrden() != null){
            if(busquedaDTO.getOrden().equals(Constants.ORD_ASCENDENTE)){
                detachedCriteria.addOrder(Order.asc(busquedaDTO.getOrdenCampo()));
            }
            else{
                detachedCriteria.addOrder(Order.desc(busquedaDTO.getOrdenCampo()));
            }
        }
        
        if(busquedaDTO.getInicio() > 0 && busquedaDTO.getCantidad() > 0){
            listaCursoEspe = listByCriteria(detachedCriteria, ((busquedaDTO.getInicio() - 1) * busquedaDTO.getCantidad()), busquedaDTO.getCantidad());            
        }else{
            listaCursoEspe = listByCriteria(detachedCriteria);
        }
                                     
        return listaCursoEspe;
    }

    @Override
    public Long obtenerTotalCuartoPorBusqueda(BusquedaDTO busquedaDTO) {        
        ReglaDTO reglasDTO;        
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CuartoVO.class);
        detachedCriteria.add(Restrictions.eq("actCurEsp", Boolean.TRUE));
        detachedCriteria.setProjection(Projections.rowCount());
        if( busquedaDTO != null && busquedaDTO.getCondiciones() != null){
            for( CondicionDTO condicionDTO : busquedaDTO.getCondiciones()){
                if(eq.containsKey(condicionDTO.getField())){
                    reglasDTO = eq.get(condicionDTO.getField());
                    reglasDTO.setData("%"+condicionDTO.getData()+"%");
                    Criterion c = GeneradorRestricciones.generar(reglasDTO);
                    if(c != null){
                        detachedCriteria.add(c);
                    }
                }
            }
        }
            
        Long total = ((Long) getHibernateTemplate().findByCriteria(detachedCriteria).get(0)).longValue();                
        return total;
    }
    
    
       @Override
    public List obtenerNombreCuartoPorBusqueda(String strBusqueda) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CuartoVO.class);
        detachedCriteria.add((Restrictions.ilike("direccion", "%" + strBusqueda + "%")));
        detachedCriteria.add(Restrictions.eq("actCurEsp", Boolean.TRUE));
        List<CuartoVO> lstComercio = new ArrayList();
        lstComercio = listByCriteria(detachedCriteria);
        return lstComercio;
    }
       
    */
    }
