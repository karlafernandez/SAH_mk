/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.archivo;

import java.util.List;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.service.archivo.dto.ArchivoDTO;


public interface GestionarArchivo {

    public SIGAMessage cargarArchivo(ArchivoDTO archivoDTO);

    public SIGAMessage eliminarArchivo(Integer idArchivo);

    public ArchivoDTO obtenerArchivoEnRutaPorId(Integer idArchivo, String ruta);

    public List obtenerArchivos();
}
