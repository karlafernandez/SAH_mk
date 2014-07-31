/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.registro.dto;

import java.util.List;

/**
 *
 * @author César Bragagnini
 */
public class HistorialCursoDTO {
    
    private String nomAlumno;   
    private Integer idAlumno; 
    private List<ItemCursoHistorialDTO> listCursoLlevado;
    private List<ItemCursoHistorialDTO> listCursoCursando;

    public String getNomAlumno() {
        return nomAlumno;
    }

    public void setNomAlumno(String nomAlumno) {
        this.nomAlumno = nomAlumno;
    }
    
    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public List<ItemCursoHistorialDTO> getListCursoLlevado() {
        return listCursoLlevado;
    }

    public void setListCursoLlevado(List<ItemCursoHistorialDTO> listCursoLlevado) {
        this.listCursoLlevado = listCursoLlevado;
    }

    public List<ItemCursoHistorialDTO> getListCursoCursando() {
        return listCursoCursando;
    }

    public void setListCursoCursando(List<ItemCursoHistorialDTO> listCursoCursando) {
        this.listCursoCursando = listCursoCursando;
    }
                    
}
