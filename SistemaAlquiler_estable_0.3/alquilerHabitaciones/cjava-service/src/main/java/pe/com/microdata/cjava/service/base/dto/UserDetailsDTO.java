package pe.com.microdata.cjava.service.base.dto;

import java.util.List;


/**
 * Clase utilizada para transportar los datos de un usuario logeado.
 * 
 * @author robert
 */
public class UserDetailsDTO extends BaseDTO{
    
    private Integer idUsuario;    
    private Integer tipoUser;
    private String nomUsuario;
    private String nomNombre;
    private String nomApePaterno;
    private String nomApeMaterno;
    private String numDocumento;
    private String nomCargo;
    private String nomArea;
    private String fecha;
    private List<String> lstAccesos;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getNomNombre() {
        return nomNombre;
    }

    public void setNomNombre(String nomNombre) {
        this.nomNombre = nomNombre;
    }

    public String getNomApePaterno() {
        return nomApePaterno;
    }

    public void setNomApePaterno(String nomApePaterno) {
        this.nomApePaterno = nomApePaterno;
    }

    public String getNomApeMaterno() {
        return nomApeMaterno;
    }

    public void setNomApeMaterno(String nomApeMaterno) {
        this.nomApeMaterno = nomApeMaterno;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getNomCargo() {
        return nomCargo;
    }

    public void setNomCargo(String nomCargo) {
        this.nomCargo = nomCargo;
    }

    public String getNomArea() {
        return nomArea;
    }

    public void setNomArea(String nomArea) {
        this.nomArea = nomArea;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<String> getLstAccesos() {
        return lstAccesos;
    }

    public void setLstAccesos(List<String> lstAccesos) {
        this.lstAccesos = lstAccesos;
    }

    public Integer getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(Integer tipoUser) {
        this.tipoUser = tipoUser;
    }
        
}
