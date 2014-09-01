/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.dataaccess.domain.operacion.operacion;

import pe.com.microdata.cjava.dataaccess.base.GenericDAO;
import pe.com.microdata.cjava.dataaccess.model.operacion.alquilado.FrecuenciaDiaVO;


public interface FrecuenciaDiaDAO extends GenericDAO<FrecuenciaDiaVO, Integer> {
    public FrecuenciaDiaVO obtenerFrecuenciaPorIdOperacion(Integer idOperacion);   
}
