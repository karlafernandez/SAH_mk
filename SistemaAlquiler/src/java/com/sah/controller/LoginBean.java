/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sah.controller;

import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Karla
 */
@ManagedBean
@SessionScoped
public class LoginBean {

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() { }
        private String usuario;
        private String clave;
        private String msg;
    
    public void loguearse(){
        msg="Usuario Logueado";
    }
    public String getClave() {
        return clave;
    }
    
    public void setClave (String clave) {
        this.clave = clave;
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public String btnEntar()
    {
        //System.out.println("Usuario")
        return null;   
    }
}
