/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.usuario.dto;

/**
 *
 * @author César Bragagnini
 */
public class CambiarClaveUsuarioDTO {

    private Integer idPersona;
    private Integer tipoUser;
    private String clvAnterior;
    private String clvNueva;
    private String clvConfirmacion;

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(Integer tipoUser) {
        this.tipoUser = tipoUser;
    }
    
    public String getClvAnterior() {
        return clvAnterior;
    }

    public void setClvAnterior(String clvAnterior) {
        this.clvAnterior = clvAnterior;
    }

    public String getClvNueva() {
        return clvNueva;
    }

    public void setClvNueva(String clvNueva) {
        this.clvNueva = clvNueva;
    }

    public String getClvConfirmacion() {
        return clvConfirmacion;
    }

    public void setClvConfirmacion(String clvConfirmacion) {
        this.clvConfirmacion = clvConfirmacion;
    }
  
}
