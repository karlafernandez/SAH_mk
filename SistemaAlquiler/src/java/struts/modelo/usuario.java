/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package struts.modelo;

/**
 *
 * @author Karla
 */
public class usuario {
    private String usuario;
    private String clave;
    
    public usuario() {
        
    }
    
    public String getClave() {
        return clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario (String usuario) {
        this.usuario = usuario;
    }
}
