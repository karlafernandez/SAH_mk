/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.common.base;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author MICRODATA_ACER
 */
public class ItemDTO {

    BigInteger id;
    String nombre;
    BigDecimal monto;
    ///Aqui otro 
    int intId;
    Integer tipo;
    String descripcion;
    String link;
    String cod;

    public ItemDTO() {
    }

    public ItemDTO(int intId, String nombre) {
        this.intId = intId;
        this.nombre = nombre;
    }

    public ItemDTO(BigInteger id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public ItemDTO(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getIntId() {
        return intId;
    }

    public void setIntId(int intId) {
        this.intId = intId;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
    
}
