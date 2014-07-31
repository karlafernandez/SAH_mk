/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.operacion.operacion.dto;

import pe.com.microdata.cjava.service.operacion.acciones_operacion.dto.OperAccionBaseDTO;

/**
 *
 * @author César Bragagnini
 */
public class ResumenOperacionDTO extends OperAccionBaseDTO{
    
    private Integer idOperacion;
    private String codOperacion;
    private String nomCurso;

    public Integer getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public String getCodOperacion() {
        return codOperacion;
    }

    public void setCodOperacion(String codOperacion) {
        this.codOperacion = codOperacion;
    }

    public String getNomCurso() {
        return nomCurso;
    }

    public void setNomCurso(String nomCurso) {
        this.nomCurso = nomCurso;
    }
    
              
}
