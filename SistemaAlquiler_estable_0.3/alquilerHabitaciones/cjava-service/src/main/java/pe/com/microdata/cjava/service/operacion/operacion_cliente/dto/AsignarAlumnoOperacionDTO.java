/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.operacion.operacion_cliente.dto;

/**
 *
 * @author César Bragagnini
 */
public class AsignarAlumnoOperacionDTO {
    
    private Integer idAlumno;
    private Integer idOperacion;
    private Integer cantFotos;

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Integer getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public Integer getCantFotos() {
        return cantFotos;
    }

    public void setCantFotos(Integer cantFotos) {
        this.cantFotos = cantFotos;
    }
        
}
