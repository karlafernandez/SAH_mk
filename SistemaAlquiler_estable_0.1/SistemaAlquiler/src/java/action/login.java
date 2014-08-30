/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
 
/**
 *
 * @author karla
 */
public class login extends ActionSupport {
 
    private String usuario;
    private String clave;
 
    public String getClave() {
        return clave;
    }
 
    @RequiredStringValidator(message = "La clave es requerido", trim = true)
    @StringLengthFieldValidator(message = "Su clave debe contener mìnimo 5 caracteres", trim = true, minLength = "5")
    public void setClave(String clave) {
        this.clave = clave;
    }
 
    public String getUsuario() {
        return usuario;
    }
 
    @RequiredStringValidator(message = "Nombre del usuario es requerido", trim = true)
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
 
    @Override
    public String execute() throws Exception {
        if (getUsuario().equals("user") && getClave().equals("123456")) {
            return SUCCESS;
        }
        return INPUT;
    }  
}
