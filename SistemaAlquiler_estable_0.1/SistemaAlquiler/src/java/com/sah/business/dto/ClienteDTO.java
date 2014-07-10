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
public class ClienteDTO {
   
     private String nombre;
     private String apellido;
     private String correo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
   
    
}
