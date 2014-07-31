/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.dataaccess.model.log_externo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Alejandra Gonzales
 */
@Entity
@Table(name = "log_externo_detalle")
public class LogExternoDetalleVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log_detalle")
    private Integer idLogDetalleVO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_log", nullable = false, updatable = false)
    private LogExternoVO logVO;
    @Column(name = "propiedad")
    private String nombrePropiedad;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "est_final")
    private String estadoFinal;
    @Column(name = "est_inicial")
    private String estadoInicial;

    public LogExternoDetalleVO() {
    }

    public LogExternoDetalleVO(String nombrePropiedad, String tipo, String estadoFinal, String estadoInicial) {

        this.nombrePropiedad = nombrePropiedad;
        this.tipo = tipo;
        this.estadoFinal = estadoFinal;
        this.estadoInicial = estadoInicial;
    }

    public Integer getIdLogDetalleVO() {
        return idLogDetalleVO;
    }

    public void setIdLogDetalleVO(Integer idLogDetalleVO) {
        this.idLogDetalleVO = idLogDetalleVO;
    }

    public LogExternoVO getLogVO() {
        return logVO;
    }

    public void setLogVO(LogExternoVO logVO) {
        this.logVO = logVO;
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

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("\tnombrePropiedad: ").append(nombrePropiedad).append("\n");
//        builder.append("\ttipo: ").append(tipo).append("\n");
//        builder.append("\testadoFinal: ").append(estadoFinal).append("\n");
//        builder.append("\testadoInicial: ").append(estadoInicial).append("\n");
//        return builder.toString();
//    }
}
