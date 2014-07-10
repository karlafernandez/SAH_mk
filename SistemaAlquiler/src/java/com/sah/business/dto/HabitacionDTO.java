/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sah.business.dto;

import com.sah.model.entities.Arrendatario;
import com.sah.model.entities.Ubicacion;

/**
 *
 * @author Meli
 */
public class HabitacionDTO {
     private int idcuarto;
     private int idUbicacion;
     private int idArrendatario;
     private String caracteristicas;
     private String banio;
     private String restricciones;
     private String estado;
     private String detalleUbicacion; 
     private String direccion;
     private String telefonoContacto;
     
    public int getIdcuarto() {
        return idcuarto;
    }

    public void setIdcuarto(int idcuarto) {
        this.idcuarto = idcuarto;
    }

    public int getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public int getIdArrendatario() {
        return idArrendatario;
    }

    public void setIdArrendatario(int idArrendatario) {
        this.idArrendatario = idArrendatario;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getBanio() {
        return banio;
    }

    public void setBanio(String banio) {
        this.banio = banio;
    }

    public String getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(String restricciones) {
        this.restricciones = restricciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDetalleUbicacion() {
        return detalleUbicacion;
    }

    public void setDetalleUbicacion(String detalleUbicacion) {
        this.detalleUbicacion = detalleUbicacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }
     
    
}
