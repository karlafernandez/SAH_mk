/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.microdata.cjava.service.log.dto;

/**
 *
 * @author Alejandra Gonzales
 */
public class LogDetalleDTO {
    
    private Integer idLogDetalleVO;

   
    private Integer idLog ;
   
    private String nombrePropiedad;
   
    private String tipo;
 
    private String estadoFinal;
    
    private String estadoInicial;

    public Integer getIdLogDetalleVO() {
        return idLogDetalleVO;
    }

    public void setIdLogDetalleVO(Integer idLogDetalleVO) {
        this.idLogDetalleVO = idLogDetalleVO;
    }

    public Integer getIdLog() {
        return idLog;
    }

    public void setIdLog(Integer idLog) {
        this.idLog = idLog;
    }

    public String getNombrePropiedad() {
        return nombrePropiedad;
    }

    public void setNombrePropiedad(String nombrePropiedad) {
        this.nombrePropiedad = nombrePropiedad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstadoFinal() {
        return estadoFinal;
    }

    public void setEstadoFinal(String estadoFinal) {
        this.estadoFinal = estadoFinal;
    }

    public String getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(String estadoInicial) {
        this.estadoInicial = estadoInicial;
    }
    
    
    
    
}
