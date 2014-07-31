/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.dataaccess.model.log_externo;

import pe.com.microdata.cjava.dataaccess.model.log.*;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Alejandra Gonzales
 */
@Entity
@Table(name = "log_externo")
public class LogExternoVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log")
    Integer idLog;
    @Column(name = "usuario")
    String usuario;
    @Column(name = "accion")
    String accion;
     
    
    @Column(name = "entidad")
    String entidad;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha")
    Date fecha;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "logVO", cascade = CascadeType.ALL)
    List<LogExternoDetalleVO> detalles;

    public Integer getIdLog() {
        return idLog;
    }

    public void setIdLog(Integer idLog) {
        this.idLog = idLog;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<LogExternoDetalleVO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<LogExternoDetalleVO> detalles) {
        this.detalles = detalles;
    }

     

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("accion:").append(accion).append("\n");
//        builder.append("usuario:").append(usuario).append("\n");
//        builder.append("entidad:").append(entidad).append("\n");
//        builder.append("fecha:").append(new SimpleDateFormat(Constants.FORMATO_FECHA_HORA).format(fecha));
//        for (LogDetalleVO logDetalleVO : detalles) {
//            builder.append(logDetalleVO.toString()).append("\n");
//        }
//        return builder.toString();
//    }

}
