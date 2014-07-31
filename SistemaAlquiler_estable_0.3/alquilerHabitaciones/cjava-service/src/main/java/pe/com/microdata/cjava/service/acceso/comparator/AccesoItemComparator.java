/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.microdata.cjava.service.acceso.comparator; 

import java.util.Comparator;
import pe.com.microdata.cjava.service.acceso.dto.AccesoItemDTO;



public class AccesoItemComparator implements Comparator<AccesoItemDTO>{
 
    @Override
    public int compare(AccesoItemDTO o1, AccesoItemDTO o2) {
        Integer i = new Integer(o1.getIdAcceso()); 
         return i.compareTo(o2.getIdAcceso());
         
    }
} 
