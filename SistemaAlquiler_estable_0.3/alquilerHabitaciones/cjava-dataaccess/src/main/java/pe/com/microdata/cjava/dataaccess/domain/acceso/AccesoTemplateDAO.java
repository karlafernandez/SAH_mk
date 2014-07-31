/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.dataaccess.domain.acceso;

import java.util.List;
import pe.com.microdata.cjava.dataaccess.base.GenericDAO;
import pe.com.microdata.cjava.dataaccess.model.acceso.AccesoTemplateVO;

/**
 *
 * @author Alejandra Gonzales
 */
public interface AccesoTemplateDAO extends GenericDAO<AccesoTemplateVO, Integer> {

    public  AccesoTemplateVO obtenerAccesosPorTemplate(String nomTemplate);

}
