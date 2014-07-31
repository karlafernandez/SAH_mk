/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.operacion.operacion.dto;

/**
 *
 * @author meliMeli
 */
public class EstadosDTO {
    
    private Integer idOperacion;
    private Boolean estAlumnos;
    private Boolean estInstructores;
    private Boolean estEncuesta;
    private Boolean estCalificaciones;
    private Boolean estAsistencia;
    private Boolean estSesiones;
    
    private Integer cantAlumnos;
    private Integer cantInstructore;
    private Integer cantEncuResp;
    private Integer cantAbandono;
    private Integer cantCertificados;

    public Integer getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }
       
    public Integer getCantAlumnos() {
        return cantAlumnos;
    }

    public void setCantAlumnos(Integer cantAlumnos) {
        this.cantAlumnos = cantAlumnos;
    }

    public Integer getCantInstructore() {
        return cantInstructore;
    }

    public void setCantInstructore(Integer cantInstructore) {
        this.cantInstructore = cantInstructore;
    }

    public Integer getCantEncuResp() {
        return cantEncuResp;
    }

    public void setCantEncuResp(Integer cantEncuResp) {
        this.cantEncuResp = cantEncuResp;
    }

    public Integer getCantAbandono() {
        return cantAbandono;
    }

    public void setCantAbandono(Integer cantAbandono) {
        this.cantAbandono = cantAbandono;
    }

    public Integer getCantCertificados() {
        return cantCertificados;
    }

    public void setCantCertificados(Integer cantCertificados) {
        this.cantCertificados = cantCertificados;
    }
    
    
    public Boolean getEstAlumnos() {
        return estAlumnos;
    }

    public void setEstAlumnos(Boolean estAlumnos) {
        this.estAlumnos = estAlumnos;
    }

    public Boolean getEstInstructores() {
        return estInstructores;
    }

    public void setEstInstructores(Boolean estInstructores) {
        this.estInstructores = estInstructores;
    }

    public Boolean getEstEncuesta() {
        return estEncuesta;
    }

    public void setEstEncuesta(Boolean estEncuesta) {
        this.estEncuesta = estEncuesta;
    }

    public Boolean getEstCalificaciones() {
        return estCalificaciones;
    }

    public void setEstCalificaciones(Boolean estCalificaciones) {
        this.estCalificaciones = estCalificaciones;
    }

    public Boolean getEstAsistencia() {
        return estAsistencia;
    }

    public void setEstAsistencia(Boolean estAsistencia) {
        this.estAsistencia = estAsistencia;
    }

    public Boolean getEstSesiones() {
        return estSesiones;
    }

    public void setEstSesiones(Boolean estSesiones) {
        this.estSesiones = estSesiones;
    }
    
}
