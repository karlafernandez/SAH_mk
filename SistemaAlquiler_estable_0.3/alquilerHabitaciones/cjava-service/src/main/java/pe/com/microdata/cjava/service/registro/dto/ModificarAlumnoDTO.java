/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.registro.dto;

import java.util.Map;
import pe.com.microdata.cjava.common.base.ItemUbigeoDTO;

/**
 *
 * @author Alejandra Gonzales
 */
public class ModificarAlumnoDTO {

   Integer idRepresentante;

    String departamento;

    String provincia;

    String distrito;

    String ubigeo;

    String descUbigeo;

    Map<Integer, ItemUbigeoDTO> mapUbigeos;

    String nomRepresentante;

    String telFijo;

    String telCelular;

    String direccion;

    String anexo;

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public void setDescUbigeo(String descUbigeo) {
        this.descUbigeo = descUbigeo;
    }

    public String getDescUbigeo() {
        return descUbigeo;
    }

    public Integer getIdRepresentante() {
        return idRepresentante;
    }

    public void setIdRepresentante(Integer idRepresentante) {
        this.idRepresentante = idRepresentante;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Map<Integer, ItemUbigeoDTO> getMapUbigeos() {
        return mapUbigeos;
    }

    public void setMapUbigeos(Map<Integer, ItemUbigeoDTO> mapUbigeos) {
        this.mapUbigeos = mapUbigeos;
    }

    public String getNomRepresentante() {
        return nomRepresentante;
    }

    public void setNomRepresentante(String nomRepresentante) {
        this.nomRepresentante = nomRepresentante;
    }

    public String getTelFijo() {
        return telFijo;
    }

    public void setTelFijo(String telFijo) {
        this.telFijo = telFijo;
    }

    public String getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }
}
