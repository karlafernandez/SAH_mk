/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sah.business.bo;

import com.sah.business.dto.HabitacionDTO;
import com.sah.model.dao.HabitacionDAOHibernate;

/**
 *
 * @author Meli
 */
public class HabitacionBO {
    private HabitacionDAOHibernate habitacionDAOHibernate=new HabitacionDAOHibernate();
    
    public boolean insertHabitacion(HabitacionDTO habitacionDTO){
        return habitacionDAOHibernate.insert(habitacionDTO);
    }
    public boolean updatehabitacion(HabitacionDTO habitacionDTO){
        return habitacionDAOHibernate.update(habitacionDTO);
    }
    public boolean deleteHabitacion(HabitacionDTO habitacionDTO){
        return habitacionDAOHibernate.delete(habitacionDTO);
    }
    
//     public boolean updateTotalhabitacion(){
//        return habitacionDAOHibernate
//    }
    
}
