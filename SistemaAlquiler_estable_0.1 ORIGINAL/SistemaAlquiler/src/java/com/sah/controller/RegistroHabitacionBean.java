/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sah.controller;

import com.sah.business.bo.HabitacionBO;
import com.sah.business.dto.HabitacionDTO;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Meli
 */
@ManagedBean
@ViewScoped
public class RegistroHabitacionBean {
    private String direccion;
    private String caracteristicas;
    private HabitacionDTO habitacionDTO = new HabitacionDTO();
    private String txtMsg;
    FacesMessage msg;
    HabitacionBO habitacionBO=new HabitacionBO();
    
    public void enviarRegistro(){
        msg=new FacesMessage();
        msg.setSummary("Registrado");
        msg.setDetail("Cuarto Registrado exitosamente");
        FacesContext facesContext=FacesContext.getCurrentInstance();
        facesContext.addMessage("Registro", msg);
        FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("frmRegistro:msgForm");
        //facesContext.renderResponse();
        habitacionDTO.setIdArrendatario(1);
        habitacionBO.insertHabitacion(habitacionDTO);
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public HabitacionDTO getHabitacionDTO() {
        return habitacionDTO;
    }

    public void setHabitacionDTO(HabitacionDTO habitacionDTO) {
        this.habitacionDTO = habitacionDTO;
    }

    public FacesMessage getMsg() {
        return msg;
    }

    public void setMsg(FacesMessage msg) {
        this.msg = msg;
    }
    
    
}
