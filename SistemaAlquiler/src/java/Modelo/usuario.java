/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author Karla
 */
public class usuario {
    private String nombre;
    private String clave;
    
    public usuario() {
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave=clave;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre (String nombre) {
        this.nombre=nombre;
    }
}
