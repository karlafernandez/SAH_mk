/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.autocomplete;

import java.util.List;

/**
 *
 * @author meliMeli
 */
public interface Autocomplete {

     
      
    List buscarPorNombreCursoEspecifico(String strBusqueda) ;
    
    List buscarPorNombreAlumnos(String strBusqueda);
    
   // public List buscarPorNombreInstructores(String strBusqueda);
    
}
