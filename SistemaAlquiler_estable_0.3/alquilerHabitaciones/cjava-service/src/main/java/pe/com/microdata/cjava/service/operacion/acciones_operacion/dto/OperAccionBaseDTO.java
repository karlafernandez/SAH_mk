/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.operacion.acciones_operacion.dto;

/**
 *
 * @author César Bragagnini
 */
public class OperAccionBaseDTO {
    
    private Boolean permisoFunc1;
    private Boolean permisoFunc2;
    private Boolean fueraPermisoVista;
    private String motivoVista;
    private String metodoBoton;
    private String disabledBoton;    

    public Boolean getPermisoFunc1() {
        return permisoFunc1;
    }

    public void setPermisoFunc1(Boolean permisoFunc1) {
        this.permisoFunc1 = permisoFunc1;
    }

    public Boolean getPermisoFunc2() {
        return permisoFunc2;
    }

    public void setPermisoFunc2(Boolean permisoFunc2) {
        this.permisoFunc2 = permisoFunc2;
    }

    public Boolean getFueraPermisoVista() {
        return fueraPermisoVista;
    }

    public void setFueraPermisoVista(Boolean fueraPermisoVista) {
        this.fueraPermisoVista = fueraPermisoVista;
    }
        
    public String getMotivoVista() {
        return motivoVista;
    }

    public void setMotivoVista(String motivoVista) {
        this.motivoVista = motivoVista;
    }

    public String getMetodoBoton() {
        return metodoBoton;
    }

    public void setMetodoBoton(String metodoBoton) {
        this.metodoBoton = metodoBoton;
    }

    public String getDisabledBoton() {
        return disabledBoton;
    }

    public void setDisabledBoton(String disabledBoton) {
        this.disabledBoton = disabledBoton;
    }
             
}
