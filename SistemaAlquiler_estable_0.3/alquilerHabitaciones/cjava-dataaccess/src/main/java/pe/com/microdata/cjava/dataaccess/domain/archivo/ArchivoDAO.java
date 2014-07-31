/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.microdata.cjava.dataaccess.domain.archivo;

import java.util.List;
import pe.com.microdata.cjava.dataaccess.base.GenericDAO;
import pe.com.microdata.cjava.dataaccess.model.archivo.ArchivoVO;

/**
 *
 * @author Alejandra Gonzales
 */
public interface ArchivoDAO extends GenericDAO<ArchivoVO , Integer> {

    public List<ArchivoVO> obtenerArchivos();
    
}
