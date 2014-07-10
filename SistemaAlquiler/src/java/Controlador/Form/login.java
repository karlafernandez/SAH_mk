/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador.Form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author karla
 */
public class login extends org.apache.struts.action.ActionForm {
    
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
//    public login() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (usuario.length()<=0)
            errors.add("usu", new ActionMessage("errors.usuario"));
        else
        {
            if(pass.length()<=0)
                errors.add("pass", new ActionMessage("errors.clave"));
        }
        mapping.getInputForward();
        return errors;
        }
}
