/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.gestionar_listas;

import java.util.List;
import pe.com.microdata.cjava.common.base.ItemUbigeoDTO;

/**
 *
 * @author pcmd005
 */
public interface GestionarListas {

    public List obtenerSubTiposPorTipo(Integer idTipo);

    public String obtenerDesSubtipoPorId(Integer idSubTipo);

    public String obtenerMes(Integer mes);

    public List obtenerMeses();

    public List obtenerAnhos();

    public List obtenerSubTiposPorTipoInicioZero(Integer idTipo);

    public List<ItemUbigeoDTO> obtenerPaises();

    public List<ItemUbigeoDTO> obtenerDepartamentosPorPais(String codPais);
 

    public List<ItemUbigeoDTO> obtenerProvinciaPorDepartamento(String codPais, String codDepartamento);

    public List<ItemUbigeoDTO> obtenerDistritoPorProvincia(String codPais, String codDepartamento, String codProvincia);
}
