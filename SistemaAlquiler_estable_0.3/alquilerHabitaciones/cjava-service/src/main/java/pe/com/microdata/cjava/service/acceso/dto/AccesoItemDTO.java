/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.acceso.dto;

import java.util.ArrayList;
import java.util.List;


public class AccesoItemDTO {

    Integer idAcceso;
    String nomAcceso;
    List<AccesoItemDTO> listado=new ArrayList<AccesoItemDTO>();

    public AccesoItemDTO() {
    }

    public AccesoItemDTO(Integer idAcceso, String nomAcceso) {
        this.idAcceso = idAcceso;
        this.nomAcceso = nomAcceso;
    }

    
    public Integer getIdAcceso() {
        return idAcceso;
    }
    

    public void setIdAcceso(Integer idAcceso) {
        this.idAcceso = idAcceso;
    }

    public String getNomAcceso() {
        return nomAcceso;
    }

    public void setNomAcceso(String nomAcceso) {
        this.nomAcceso = nomAcceso;
    }

    public List<AccesoItemDTO> getListado() {
        return listado;
    }

    public void setListado(List<AccesoItemDTO> listado) {
        this.listado = listado;
    }

    
    

}
