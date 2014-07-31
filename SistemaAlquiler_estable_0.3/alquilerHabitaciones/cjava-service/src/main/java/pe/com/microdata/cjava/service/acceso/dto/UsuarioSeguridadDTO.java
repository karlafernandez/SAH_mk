/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.acceso.dto;


public class UsuarioSeguridadDTO {

    private Integer idPersona;
    private String nombreCompleto;
    private String usuario;
    private Boolean estadoBloqueado;

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Boolean getEstadoBloqueado() {
        return estadoBloqueado;
    }

    public void setEstadoBloqueado(Boolean estadoBloqueado) {
        this.estadoBloqueado = estadoBloqueado;
    }
    
}
