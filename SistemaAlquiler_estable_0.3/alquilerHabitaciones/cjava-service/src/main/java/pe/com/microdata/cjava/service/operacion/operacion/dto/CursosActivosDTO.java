/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.operacion.operacion.dto;

import pe.com.microdata.cjava.service.paciente.dto.*;

/**
 *
 * @author meliMeli
 */
public class CursosActivosDTO {
    
    private Integer idOperacion;
    private String codigoOpe;
    private String fechaInicio;
    private String fechaFin;
    private String fechaRegistro;
    private Boolean cursoEmpresa;
    
    private Integer idCurso; //CURSO ESPECIFICO
    private Integer idCalificacion;
    private Integer idEmpresa;
    ///////////////////////////////////////////////////
    private Integer idCursoGeneralPlantilla;
    private Integer idCursoGeneral;
    private Boolean activoCursoGralPlan;
    private Integer idDetaCursoEspPlan;
    private Integer idCursoEspecifico;
    ///////////////////////////////////////////////////
    
    
    
    private Integer idTurno;
    private Integer idEstado;
    
    private String nombreCurso;
    private String seccion;
    private String tipoCurso;

    public Integer getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public String getCodigoOpe() {
        return codigoOpe;
    }

    public void setCodigoOpe(String codigoOpe) {
        this.codigoOpe = codigoOpe;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Boolean getCursoEmpresa() {
        return cursoEmpresa;
    }

    public void setCursoEmpresa(Boolean cursoEmpresa) {
        this.cursoEmpresa = cursoEmpresa;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Integer idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdCursoGeneralPlantilla() {
        return idCursoGeneralPlantilla;
    }

    public void setIdCursoGeneralPlantilla(Integer idCursoGeneralPlantilla) {
        this.idCursoGeneralPlantilla = idCursoGeneralPlantilla;
    }

    public Integer getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public Integer getIdCursoGeneral() {
        return idCursoGeneral;
    }

    public void setIdCursoGeneral(Integer idCursoGeneral) {
        this.idCursoGeneral = idCursoGeneral;
    }

    public Boolean getActivoCursoGralPlan() {
        return activoCursoGralPlan;
    }

    public void setActivoCursoGralPlan(Boolean activoCursoGralPlan) {
        this.activoCursoGralPlan = activoCursoGralPlan;
    }

    public Integer getIdDetaCursoEspPlan() {
        return idDetaCursoEspPlan;
    }

    public void setIdDetaCursoEspPlan(Integer idDetaCursoEspPlan) {
        this.idDetaCursoEspPlan = idDetaCursoEspPlan;
    }

    public Integer getIdCursoEspecifico() {
        return idCursoEspecifico;
    }

    public void setIdCursoEspecifico(Integer idCursoEspecifico) {
        this.idCursoEspecifico = idCursoEspecifico;
    }
    
    
}
