/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.archivo.dto;

import java.io.ByteArrayOutputStream;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


public class ArchivoDTO {

    private CommonsMultipartFile archivo;
    private ByteArrayOutputStream archivoOutput;
    private Integer idArchivo;
    private String nomArchivo;
    private String rutaArchivo;
    private String rutaServidor;
    private String extension;
    private String fecCreacion;

    public CommonsMultipartFile getArchivo() {
        return archivo;
    }

    public void setArchivo(CommonsMultipartFile archivo) {
        this.archivo = archivo;
    }

    public ByteArrayOutputStream getArchivoOutput() {
        return archivoOutput;
    }

    public void setArchivoOutput(ByteArrayOutputStream archivoOutput) {
        this.archivoOutput = archivoOutput;
    }

    public void setIdArchivo(Integer idArchivo) {
        this.idArchivo = idArchivo;
    }

    public Integer getIdArchivo() {
        return idArchivo;
    }

    public String getNomArchivo() {
        return nomArchivo;
    }

    public void setNomArchivo(String nomArchivo) {
        this.nomArchivo = nomArchivo;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getRutaServidor() {
        return rutaServidor;
    }

    public void setRutaServidor(String rutaServidor) {
        this.rutaServidor = rutaServidor;
    }

    public String getFecCreacion() {
        return fecCreacion;
    }

    public void setFecCreacion(String fecCreacion) {
        this.fecCreacion = fecCreacion;
    }

    
    
}
