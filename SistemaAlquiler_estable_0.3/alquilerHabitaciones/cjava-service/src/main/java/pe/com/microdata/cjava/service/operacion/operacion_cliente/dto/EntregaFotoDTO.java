/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.operacion.operacion_cliente.dto;

/**
 *
 * @author César Bragagnini
 */
public class EntregaFotoDTO {
   
    private Integer idOperacion;
    private Integer idOpeAlum;
    private Integer numFoto;
    private String nombreCurso;
    private String nombreAlum;
    private String codOperacion;
    private String documento;

    public Integer getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public Integer getIdOpeAlum() {
        return idOpeAlum;
    }

    public void setIdOpeAlum(Integer idOpeAlum) {
        this.idOpeAlum = idOpeAlum;
    }

    public Integer getNumFoto() {
        return numFoto;
    }

    public void setNumFoto(Integer numFoto) {
        this.numFoto = numFoto;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getNombreAlum() {
        return nombreAlum;
    }

    public void setNombreAlum(String nombreAlum) {
        this.nombreAlum = nombreAlum;
    }

    public String getCodOperacion() {
        return codOperacion;
    }

    public void setCodOperacion(String codOperacion) {
        this.codOperacion = codOperacion;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
            
}
