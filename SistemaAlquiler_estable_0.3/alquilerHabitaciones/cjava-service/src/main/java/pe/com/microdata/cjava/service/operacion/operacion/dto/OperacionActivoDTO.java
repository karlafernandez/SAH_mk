/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.operacion.operacion.dto;

/**
 *
 * @author Cesar Bragagnini
 */
public class OperacionActivoDTO {
    
    private Integer idTurno;    
    private Integer idEmpresa;
    private Integer idCurEsp;        
    private String fecInicio;
    private String fecFin;
    private String nomSalon;
    private Boolean tipoCurso;

    public Integer getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdCurEsp() {
        return idCurEsp;
    }

    public void setIdCurEsp(Integer idCurEsp) {
        this.idCurEsp = idCurEsp;
    }

    public String getFecInicio() {
        return fecInicio;
    }

    public void setFecInicio(String fecInicio) {
        this.fecInicio = fecInicio;
    }

    public String getFecFin() {
        return fecFin;
    }

    public void setFecFin(String fecFin) {
        this.fecFin = fecFin;
    }

    public String getNomSalon() {
        return nomSalon;
    }

    public void setNomSalon(String nomSalon) {
        this.nomSalon = nomSalon;
    }
        
    public Boolean getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(Boolean tipoCurso) {
        this.tipoCurso = tipoCurso;
    }
           
}
