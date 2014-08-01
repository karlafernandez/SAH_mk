/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.registro.dto;

import java.util.Date;
import java.util.List;
import pe.com.microdata.cjava.common.base.ItemDTO;
import pe.com.microdata.cjava.common.base.ItemUbigeoDTO;

/**
 *
 * @author meliMeli
 */
public class ClienteDTO {

    private Integer idAlumno;
   
    
    // private SubTipoDTO centroEducativo;
    // private SubTipoDTO nivelEstudios;
    // FOTO ALUM
    private Integer idPersona;

    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String nombreCompleto;
    private String fechaNacimiento;
    private Integer idTipdocumento;
    private String documento;
    
    private Integer idTelefono;   
    private String telefono;   
    
    private String celular;   
    private String correoPersonal;
    private String correoCoorporativo;
    private Integer idCentroEdu;
    private String institucion;
    private Integer idOcupacion;
    
    private Integer idNivelEstudio;
    private String centroTrabajo;
    
    private String correoFace;
    private String correoLinke;
    
    private String usuario;
    private String pass;
    private String codigo;
    
    private String pais;
    private String departamento;
    private String provincia;
    private String distrito;
    private String nombreUbigeo;
      
    private String urbPer;
    private String direccion;
    private String referenciaDir;
 
    private String fechaRegistro;
    
    private String idUbigeo;
    

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

   

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getReferenciaDir() {
        return referenciaDir;
    }

    public void setReferenciaDir(String referenciaDir) {
        this.referenciaDir = referenciaDir;
    }

    

  

    public String getUrbPer() {
        return urbPer;
    }

    public void setUrbPer(String urbPer) {
        this.urbPer = urbPer;
    }

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public String getCorreoCoorporativo() {
        return correoCoorporativo;
    }

    public void setCorreoCoorporativo(String correoCoorporativo) {
        this.correoCoorporativo = correoCoorporativo;
    }

   

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

   

    public String getCentroTrabajo() {
        return centroTrabajo;
    }

    public void setCentroTrabajo(String centroTrabajo) {
        this.centroTrabajo = centroTrabajo;
    }

    public String getCorreoFace() {
        return correoFace;
    }

    public void setCorreoFace(String correoFace) {
        this.correoFace = correoFace;
    }

    public String getCorreoLinke() {
        return correoLinke;
    }

    public void setCorreoLinke(String correoLinke) {
        this.correoLinke = correoLinke;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    

    public Integer getIdTipdocumento() {
        return idTipdocumento;
    }

    public void setIdTipdocumento(Integer idTipdocumento) {
        this.idTipdocumento = idTipdocumento;
    }

    public Integer getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(Integer idTelefono) {
        this.idTelefono = idTelefono;
    }

   

    public Integer getIdNivelEstudio() {
        return idNivelEstudio;
    }

    public void setIdNivelEstudio(Integer idNivelEstudio) {
        this.idNivelEstudio = idNivelEstudio;
    }

  
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getIdUbigeo() {
        return idUbigeo;
    }

    public void setIdUbigeo(String idUbigeo) {
        this.idUbigeo = idUbigeo;
    }

    public String getNombreUbigeo() {
        return nombreUbigeo;
    }

    public void setNombreUbigeo(String nombreUbigeo) {
        this.nombreUbigeo = nombreUbigeo;
    }

    public Integer getIdCentroEdu() {
        return idCentroEdu;
    }

    public void setIdCentroEdu(Integer idCentroEdu) {
        this.idCentroEdu = idCentroEdu;
    }

    public Integer getIdOcupacion() {
        return idOcupacion;
    }

    public void setIdOcupacion(Integer idOcupacion) {
        this.idOcupacion = idOcupacion;
    }

    


    
}
