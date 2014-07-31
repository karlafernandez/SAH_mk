/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.dataaccess.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Alejandra Gonzales
 */
@Entity
@Table(name = "paciente" )
public class PacienteVO implements java.io.Serializable {

    //primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_paciente", unique = true, nullable = false)
    private Integer idPaciente;

    //texto
    @Column(name = "num_documento")
    private String numDocumento;

    @Column(name = "ape_paterno")
    private String apePaterno;
    @Column(name = "ape_materno")
    private String apeMaterno;

    @Column(name = "nombre")
    private String nombre;

//    //relacion many to one
//    @ManyToOne(fetch = FetchType.LAZY)    
//    @JoinColumn(name = "id_tip_documento", nullable = false, updatable = false )
//    private SubTipoVO tipDocumento;
//
//    //relacion one to many
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pacienteVO")
//    private List<EstudioMedicoVO> estudioMedicoVOs = new ArrayList<EstudioMedicoVO>();

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

//    public List<EstudioMedicoVO> getEstudioMedicoVOs() {
//        return estudioMedicoVOs;
//    }
//
//    public void setEstudioMedicoVOs(List<EstudioMedicoVO> estudioMedicoVOs) {
//        this.estudioMedicoVOs = estudioMedicoVOs;
//    }
//
//    public SubTipoVO getTipDocumento() {
//        return tipDocumento;
//    }
//
//    public void setTipDocumento(SubTipoVO tipDocumento) {
//        this.tipDocumento = tipDocumento;
//    }
}
