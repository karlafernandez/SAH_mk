/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sah.model.dao;

import com.sah.business.bo.HabitacionBO;
import com.sah.business.dto.HabitacionDTO;
import com.sah.model.entities.Arrendatario;
import com.sah.model.entities.Cuarto;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Meli
 */
public class HabitacionDAOHibernate extends DAOGenerico{

    public HabitacionDAOHibernate() {
        logger=Logger.getLogger(HabitacionDAOHibernate.class.getName());
    }
    
    @Override
    public HabitacionDTO convertPojo_DTO(Object object) {
        Cuarto cuarto=(Cuarto)object;
        HabitacionDTO habitacionDTO=new HabitacionDTO();
       // habitacionDTO.setArrendatario(cuarto.getArrendatario().getIdArrendatario());
        habitacionDTO.setIdcuarto(cuarto.getIdcuarto());
        habitacionDTO.setBanio(cuarto.getBanio());
        habitacionDTO.setCaracteristicas(cuarto.getCaracteristicas());
        habitacionDTO.setEstado(cuarto.getEstado());
        return habitacionDTO;
    }

    @Override
    public Cuarto convertDTO_Pojo(Object object) {
        Cuarto cuarto=new Cuarto();
        HabitacionDTO habitacionDTO=(HabitacionDTO)object;
        Arrendatario arrendatario=new Arrendatario();
        arrendatario.setIdArrendatario(habitacionDTO.getIdArrendatario());
        cuarto.setArrendatario(arrendatario);
        cuarto.setBanio(habitacionDTO.getBanio());
        cuarto.setCaracteristicas(habitacionDTO.getCaracteristicas());
        cuarto.setDetalleUbicacion(habitacionDTO.getDetalleUbicacion());
        cuarto.setDireccion(habitacionDTO.getDireccion());
        cuarto.setIdcuarto(habitacionDTO.getIdcuarto());
        cuarto.setRestricciones(habitacionDTO.getRestricciones());
        cuarto.setTelefonoContacto(habitacionDTO.getTelefonoContacto());
        return cuarto;
    }
    

     public List<Cuarto> obtenerListaHabitaciones() {
               
       // List<HabitacionBO> listaOperacion = new ArrayList<HabitacionBO>();
        //DetachedCriteria detachedCriteria = DetachedCriteria.forClass(HabitacionBO.class);
        return session.createCriteria(Cuarto.class).list();
         
    }

 

/*
 
 @Override
    public OperacionDevVO obtenerOperacionConAlumnosPorIdOperacion(Integer idOpe) {
        List<OperacionDevVO> listaOperacion = new ArrayList<OperacionDevVO>();
        OperacionDevVO operacionDevVO = new OperacionDevVO();
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(OperacionDevVO.class);
        detachedCriteria.createAlias("estadoVO", "estadoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("curEspVO", "curEspVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("listaAlumnoVO", "listaAlumnoVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.createAlias("listaAlumnoVO.alumnoVO", "alumnoVO", DetachedCriteria.LEFT_JOIN);        
        detachedCriteria.createAlias("alumnoVO.alumnoPersonaVO", "alumnoPersonaVO", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("idOperacion", idOpe));
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.primerApellidoPer"));
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.segundoApellidoPer"));
        detachedCriteria.addOrder(Order.asc("alumnoPersonaVO.nomPersona"));
        detachedCriteria.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);
        listaOperacion = listByCriteria(detachedCriteria);
        if(!listaOperacion.isEmpty())
               operacionDevVO = listaOperacion.get(0);
        return operacionDevVO;
    }

 */
     
}