/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.base.dto;

/**
 *
 * @author pcmd005
 */
public class UserDTO {
    private Integer idUser;
    private String nomUsuario;
    private String clvUsuario;
    private String nomCompleto;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getClvUsuario() {
        return clvUsuario;
    }

    public void setClvUsuario(String clvUsuario) {
        this.clvUsuario = clvUsuario;
    }

    public String getNomCompleto() {
        return nomCompleto;
    }

    public void setNomCompleto(String nomCompleto) {
        this.nomCompleto = nomCompleto;
    }
    
    
}
