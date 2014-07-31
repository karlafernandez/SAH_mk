/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.dataaccess.domain.administracion.persona;

import java.util.List;
import pe.com.microdata.cjava.dataaccess.base.GenericDAO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.UbigeoVO;

/**
 *
 * @author Alejandra Gonzales
 */
public interface UbigeoDAO extends GenericDAO<UbigeoVO, Integer> {

    List obtenerPaises();

    List obtenerDepartamentosPorPais(String codPais);

    public List<UbigeoVO> obtenerProvinciasPorDepartamento(String codPais, String codDepartamento);

    public List<UbigeoVO> obtenerDistritoPorProvincia(String codPais, String codDepartamento, String codProvincia);
    
    public UbigeoVO obtenerUbigeoPorCodigo(String codPais, String codDepartamento, String codProvincia, String codDistrito);
}
