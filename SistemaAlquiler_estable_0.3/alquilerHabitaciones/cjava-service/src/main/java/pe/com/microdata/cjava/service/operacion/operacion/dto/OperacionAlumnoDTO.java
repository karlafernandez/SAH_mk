/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.operacion.operacion.dto;

import java.util.List;

import pe.com.microdata.cjava.service.registro.dto.ClienteDTO;

/**
 *
 * @author meliMeli
 */
public class OperacionAlumnoDTO {

    private Integer idOperacionAlumno;
    private Boolean abandonoAlumno;
    private Boolean certificadoAlumno;
    private String fechaInscripcion;
    private Double notaFinal;
    private String motivoAbandono;
    private String fechaAbandono;
    private Integer idAlumno;
    private Integer idOperacion;
    private Integer idRegistro;
    private Integer idEstado;
    private Integer idPersona;
    private Integer cantFotos;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String nombreCompleto;
    private String documento;
    private List<ClienteDTO> lstAlumnos;

    private Integer porcentajeAsistencia;
    private String descripcion;

    public Integer getIdOperacionAlumno() {
        return idOperacionAlumno;
    }

    public void setIdOperacionAlumno(Integer idOperacionAlumno) {
        this.idOperacionAlumno = idOperacionAlumno;
    }

    public Boolean getAbandonoAlumno() {
        return abandonoAlumno;
    }

    public void setAbandonoAlumno(Boolean abandonoAlumno) {
        this.abandonoAlumno = abandonoAlumno;
    }

    public Boolean getCertificadoAlumno() {
        return certificadoAlumno;
    }

    public void setCertificadoAlumno(Boolean certificadoAlumno) {
        this.certificadoAlumno = certificadoAlumno;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public String getMotivoAbandono() {
        return motivoAbandono;
    }

    public void setMotivoAbandono(String motivoAbandono) {
        this.motivoAbandono = motivoAbandono;
    }

    public String getFechaAbandono() {
        return fechaAbandono;
    }

    public void setFechaAbandono(String fechaAbandono) {
        this.fechaAbandono = fechaAbandono;
    }

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

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public List<ClienteDTO> getLstAlumnos() {
        return lstAlumnos;
    }

    public void setLstAlumnos(List<ClienteDTO> lstAlumnos) {
        this.lstAlumnos = lstAlumnos;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getCantFotos() {
        return cantFotos;
    }

    public void setCantFotos(Integer cantFotos) {
        this.cantFotos = cantFotos;
    }
       
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    

    public Integer getPorcentajeAsistencia() {
        return porcentajeAsistencia;
    }

    public void setPorcentajeAsistencia(Integer porcentajeAsistencia) {
        this.porcentajeAsistencia = porcentajeAsistencia;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
