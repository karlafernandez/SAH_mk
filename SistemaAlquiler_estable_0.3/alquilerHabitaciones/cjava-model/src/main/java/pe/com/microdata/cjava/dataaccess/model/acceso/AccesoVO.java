/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.dataaccess.model.acceso;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import pe.com.microdata.cjava.dataaccess.base.BaseVO;
 
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.PersonaVO;

/**
 *
 * @author lidia
 */
@Entity
@Table(name = "rol")
public class AccesoVO   extends BaseVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol", unique = true, nullable = false)
    private Integer idAcceso;
    @Column(name = "nom_rol")
    private String nomAcceso;
    @Column(name = "desc_rol")
    private String desAcceso;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_grupo_id_grupo", nullable = false, updatable = false)
    private AccesoGrupoVO accesoGrupoVO;

    @ManyToMany(mappedBy = "accesoVOs")
    private Set<PersonaVO> personaVOs;

    @ManyToMany(mappedBy = "accesoVOs")
    private Set<AccesoTemplateVO> accesoTemplateVOs;

    public AccesoVO() {
    }

    public AccesoVO(Integer idAcceso) {
        this.idAcceso = idAcceso;

    }

    public Integer getIdAcceso() {
        return idAcceso;
    }

    public void setIdAcceso(Integer idAcceso) {
        this.idAcceso = idAcceso;
    }

    public String getNomAcceso() {
        return nomAcceso;
    }

    public void setNomAcceso(String nomAcceso) {
        this.nomAcceso = nomAcceso;
    }

    public String getDesAcceso() {
        return desAcceso;
    }

    public void setDesAcceso(String desAcceso) {
        this.desAcceso = desAcceso;
    }

    public AccesoGrupoVO getAccesoGrupoVO() {
        return accesoGrupoVO;
    }

    public void setAccesoGrupoVO(AccesoGrupoVO accesoGrupoVO) {
        this.accesoGrupoVO = accesoGrupoVO;
    }

    public Set<PersonaVO> getPersonaVOs() {
        return personaVOs;
    }

    public void setPersonaVOs(Set<PersonaVO> personaVOs) {
        this.personaVOs = personaVOs;
    }

    public Set<AccesoTemplateVO> getAccesoTemplateVOs() {
        return accesoTemplateVOs;
    }

    public void setAccesoTemplateVOs(Set<AccesoTemplateVO> accesoTemplateVOs) {
        this.accesoTemplateVOs = accesoTemplateVOs;
    }

}
