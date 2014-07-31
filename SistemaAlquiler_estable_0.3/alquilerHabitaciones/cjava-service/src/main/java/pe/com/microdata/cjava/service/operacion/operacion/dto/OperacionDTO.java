/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.operacion.operacion.dto;

/**
 *
 * @author meliMeli
 */
public class OperacionDTO {

    private Integer idOperacion;
    private String codigoOpe;
    private String fechaInicio;
    private String fechaFin;
    private String fechaRegistro;
   
    private Integer idCuarto; //CURSO ESPECIFICO
    private Integer idCalificacion;
    
    private Integer idTurno;
    private Integer idEstado;
    private Integer numSesion;
    private Integer numHora;
    private String descripcionEstado;
   
    private String direccion; //    private String nombreCurso; 
    private String seccion;
    private String tipoCurso;
    private String diasCierre;
    private Long cantSesiones;
    private Long cantAlumnos;
    private Boolean editarFecha;
    private Boolean terminoUltimaClase;
    private Boolean poderModificar;
    private Boolean poderCerrar;
    private Boolean paso21DiasYActivo;
    private Boolean cuartoFinalizado;
    private Boolean paso7Dias;
    /*Activar encuesta*/
    private String existEncuAsig;

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

    


    public Integer getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Integer idCalificacion) {
        this.idCalificacion = idCalificacion;
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

    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }


    public Long getCantSesiones() {
        return cantSesiones;
    }

    public void setCantSesiones(Long cantSesiones) {
        this.cantSesiones = cantSesiones;
    }

    public Long getCantAlumnos() {
        return cantAlumnos;
    }

    public void setCantAlumnos(Long cantAlumnos) {
        this.cantAlumnos = cantAlumnos;
    }

    public void setEditarFecha(Boolean editarFecha) {
        this.editarFecha = editarFecha;
    }

    public Boolean getEditarFecha() {
        return editarFecha;
    }

    public void setPoderModificar(Boolean poderModificar) {
        this.poderModificar = poderModificar;
    }

    public Boolean getPoderModificar() {
        return poderModificar;
    }

    public void setTerminoUltimaClase(Boolean terminoUltimaClase) {
        this.terminoUltimaClase = terminoUltimaClase;
    }

    public Boolean getTerminoUltimaClase() {
        return terminoUltimaClase;
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

    public Boolean getPaso21DiasYActivo() {
        return paso21DiasYActivo;
    }

    public void setPaso21DiasYActivo(Boolean paso21DiasYActivo) {
        this.paso21DiasYActivo = paso21DiasYActivo;
    }

   

  
    public Boolean getPaso7Dias() {
        return paso7Dias;
    }

    public void setPaso7Dias(Boolean paso7Dias) {
        this.paso7Dias = paso7Dias;
    }

    public String getExistEncuAsig() {
        return existEncuAsig;
    }

    public void setExistEncuAsig(String existEncuAsig) {
        this.existEncuAsig = existEncuAsig;
    }

    /**
     * @return the idCuarto
     */
    public Integer getIdCuarto() {
        return idCuarto;
    }

    /**
     * @param idCuarto the idCuarto to set
     */
    public void setIdCuarto(Integer idCuarto) {
        this.idCuarto = idCuarto;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the cuartoFinalizado
     */
    public Boolean getCuartoFinalizado() {
        return cuartoFinalizado;
    }

    /**
     * @param cuartoFinalizado the cuartoFinalizado to set
     */
    public void setCuartoFinalizado(Boolean cuartoFinalizado) {
        this.cuartoFinalizado = cuartoFinalizado;
    }
    
}
