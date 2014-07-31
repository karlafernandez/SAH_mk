/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.log;

import java.util.List;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.service.log.dto.LogDTO;

/**
 *
 * @author Alejandra Gonzales
 */
public interface GestionarLog {

    List obtenerLogsPorBusqueda(BusquedaDTO busquedaDTO);

    Long obtenerTotalLogsPorBusqueda(BusquedaDTO busquedaDTO);

    public LogDTO obtenerLogPorId(Integer idLog);

}
