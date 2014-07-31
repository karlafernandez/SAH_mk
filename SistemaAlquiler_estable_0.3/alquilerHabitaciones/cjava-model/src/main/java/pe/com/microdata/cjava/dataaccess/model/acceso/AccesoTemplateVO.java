/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.dataaccess.model.acceso;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import pe.com.microdata.cjava.dataaccess.base.BaseVO;

/**
 *
 * @author Alejandra Gonzales
 */
@Entity
@Table(name = "rol_template")
public class AccesoTemplateVO  extends BaseVO{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol_template", unique = true, nullable = false)
    private Integer idRolTemplate;
    @Column(name = "nom_rol_template")
    private String nombreTemplate;

    @ManyToMany 
    @JoinTable(name = "rol_template_detalle", joinColumns = {
        @JoinColumn(name = "id_rol_template")}, inverseJoinColumns = {
        @JoinColumn(name = "id_rol")})
    private Set<AccesoVO> accesoVOs;

    public Integer getIdRolTemplate() {
        return idRolTemplate;
    }

    public void setIdRolTemplate(Integer idRolTemplate) {
        this.idRolTemplate = idRolTemplate;
    }

    public String getNombreTemplate() {
        return nombreTemplate;
    }

    public void setNombreTemplate(String nombreTemplate) {
        this.nombreTemplate = nombreTemplate;
    }

    public Set<AccesoVO> getAccesoVOs() {
        return accesoVOs;
    }

    public void setAccesoVOs(Set<AccesoVO> accesoVOs) {
        this.accesoVOs = accesoVOs;
    }

    
}
