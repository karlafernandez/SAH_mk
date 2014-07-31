/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.operacion.operacion.dto;

/**
 *
 * @author César Bragagnini
 */
public class AperturaBaseDTO {
    
    private String probaBase;
    private String disabledButton;
    private Boolean booleanBase;
    
    
    public String getProbaBase() {
        return probaBase;
    }

    public void setProbaBase(String probaBase) {
        this.probaBase = probaBase;
    }

    public Boolean getBooleanBase() {
        return booleanBase;
    }

    public void setBooleanBase(Boolean booleanBase) {
        this.booleanBase = booleanBase;
    }

    public String getDisabledButton() {
        return disabledButton;
    }

    public void setDisabledButton(String disabledButton) {
        this.disabledButton = disabledButton;
    }
        
}
