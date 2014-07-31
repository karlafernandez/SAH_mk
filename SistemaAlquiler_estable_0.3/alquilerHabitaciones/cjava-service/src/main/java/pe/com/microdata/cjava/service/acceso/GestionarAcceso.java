/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.acceso;

import java.util.List;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.service.acceso.dto.AsignarAccesoDTO;
 


public interface GestionarAcceso {

    public List obtenerAccesosPorIdUsuario(Integer idUsuario);

    public SIGAMessage asignarAccesosPorUsuario(AsignarAccesoDTO asignarAccesoDTO);

    public List obtenerAccesos();
}
