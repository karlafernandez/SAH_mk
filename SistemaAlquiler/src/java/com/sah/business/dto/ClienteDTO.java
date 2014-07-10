/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sah.business.dto;

import com.sah.model.entities.Arrendatario;
import com.sah.model.entities.Ubicacion;

/**
 *
 * @author Karla
 */
public class ClienteDTO {
   
    private int idcliente; 
    private String nombre;
    private String apellido;
    private String ocupacion;
    private String correo;
    private String telefono;
    private String dni;
    
    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

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
    
    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
}
