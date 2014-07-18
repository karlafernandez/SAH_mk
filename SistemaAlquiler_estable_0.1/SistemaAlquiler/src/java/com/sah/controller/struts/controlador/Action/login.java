/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sah.controller.struts.controlador.Action;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author karla
 */
public class Login extends ActionSupport {
    private static final long serialVersionUID = 1L;
    
    private String usuario;    
    private String pass;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
//
    public Login() {
        
        
    }
    public String execute(){
        return "success";
    }
}
