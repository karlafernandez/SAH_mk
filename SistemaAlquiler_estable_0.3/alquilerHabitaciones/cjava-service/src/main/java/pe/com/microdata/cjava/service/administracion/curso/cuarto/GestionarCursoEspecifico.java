/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.administracion.curso.cuarto;

import java.util.List;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.service.administracion.curso.cuarto.dto.CuartoDTO;


public interface GestionarCursoEspecifico {
    
    public List obtenerListaCursoEspecifico();
 //   public List obtenerListaCursoEspecificoPorBusqueda(BusquedaDTO busquedaDTO);    
    public SIGAMessage registrarCursoEspecifico(CuartoDTO dto);
    public SIGAMessage eliminarCursoEspecifico(Integer idCursoEspecifico);
    public SIGAMessage modificarCursoEspecifico(CuartoDTO dto);
  //  public CuartoDTO obtenerCursoEspecificoPorId(Integer idCursoEsp);     
   // public Long obtenerTotalListaCursoEspecificoPorBusqueda(BusquedaDTO busquedaDTO);
}
