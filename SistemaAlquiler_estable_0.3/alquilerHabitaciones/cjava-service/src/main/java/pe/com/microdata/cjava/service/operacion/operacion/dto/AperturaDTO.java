/*  
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.operacion.operacion.dto;

import pe.com.microdata.cjava.service.operacion.acciones_operacion.dto.OperAccionBaseDTO;

/**
 *
 * @author meliMeli
 */
public class AperturaDTO extends OperAccionBaseDTO {
    
   private Integer idOperacion;
    private String fechaActual;
    private String fechaInicio;
    private String fechaFin;
    private Integer anio;
    private Integer mes;
    private Integer numSesion;
    private Integer numHora;
    private String observaciones;
    private String nombreCurso;
    private String codOperacion;
    private String nomSalon;
    private String estadoCurso;
    private String diasCierre;
    private Boolean activarCurso;
    private Boolean editarFecha;
    private Boolean terminoUltimaClase;
    private Boolean poderModificar;
    private Boolean poderCerrar;
    private Boolean paso21DiasYActivo;
    private Boolean cursoFinalizado;
    private Boolean paso7Dias;
    
    public Integer getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public String getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(String fechaActual) {
        this.fechaActual = fechaActual;
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

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getNumHora() {
        return numHora;
    }

    public void setNumHora(Integer numHora) {
        this.numHora = numHora;
    }

    public Integer getNumSesion() {
        return numSesion;
    }

    public void setNumSesion(Integer numSesion) {
        this.numSesion = numSesion;
    }
        
    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getCodOperacion() {
        return codOperacion;
    }

    public void setNomSalon(String nomSalon) {
        this.nomSalon = nomSalon;
    }

    public String getNomSalon() {
        return nomSalon;
    }
                    
    public void setCodOperacion(String codOperacion) {
        this.codOperacion = codOperacion;
    }

    public String getEstadoCurso() {
        return estadoCurso;
    }

    public void setEstadoCurso(String estadoCurso) {
        this.estadoCurso = estadoCurso;
    }
            
    public Boolean getActivarCurso() {
        return activarCurso;
    }

    public void setActivarCurso(Boolean activarCurso) {
        this.activarCurso = activarCurso;
    }

    public Boolean getEditarFecha() {
        return editarFecha;
    }

    public void setEditarFecha(Boolean editarFecha) {
        this.editarFecha = editarFecha;
    }

    public Boolean getPoderModificar() {
        return poderModificar;
    }

    public void setPoderModificar(Boolean poderModificar) {
        this.poderModificar = poderModificar;
    }

    public Boolean getTerminoUltimaClase() {
        return terminoUltimaClase;
    }

    public void setTerminoUltimaClase(Boolean terminoUltimaClase) {
        this.terminoUltimaClase = terminoUltimaClase;
    }

    public String getDiasCierre() {
        return diasCierre;
    }

    public void setDiasCierre(String diasCierre) {
        this.diasCierre = diasCierre;
    }

    public Boolean getPoderCerrar() {
        return poderCerrar;
    }

    public void setPoderCerrar(Boolean poderCerrar) {
        this.poderCerrar = poderCerrar;
    }

    @Override
    public String getDisabledBoton() {
        return super.getDisabledBoton(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDisabledBoton(String disabledBoton) {
        super.setDisabledBoton(disabledBoton); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean getPaso21DiasYActivo() {
        return paso21DiasYActivo;
    }

    public void setPaso21DiasYActivo(Boolean paso21DiasYActivo) {
        this.paso21DiasYActivo = paso21DiasYActivo;
    }

    public Boolean getCursoFinalizado() {
        return cursoFinalizado;
    }

    public void setCursoFinalizado(Boolean cursoFinalizado) {
        this.cursoFinalizado = cursoFinalizado;
    }

    public Boolean getPaso7Dias() {
        return paso7Dias;
    }

    public void setPaso7Dias(Boolean paso7Dias) {
        this.paso7Dias = paso7Dias;
    }
                                  
}
