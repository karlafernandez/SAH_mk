/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.cmv.dataaccess.domain;

import com.demo.cmv.dataaccess.base.GenericDAO;
import com.demo.cmv.dataaccess.model.ClienteVO;
import java.util.List;

/**
 *
 * @author meliMeli
 */
public interface ClienteDAO extends GenericDAO<ClienteVO, Integer>{
    
    public List obtenerClientesConDNI();
    
}
