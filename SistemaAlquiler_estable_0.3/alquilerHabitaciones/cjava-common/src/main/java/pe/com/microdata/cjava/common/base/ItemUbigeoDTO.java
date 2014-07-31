/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.common.base;

/**
 *
 * @author Alejandra Gonzales
 */
public class ItemUbigeoDTO {

    String codigo;

    String nombre;

    public ItemUbigeoDTO() {
    }

    public ItemUbigeoDTO(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public ItemUbigeoDTO(String codigo) {
        this.codigo = codigo;

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     
}
