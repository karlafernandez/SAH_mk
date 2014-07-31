/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.dataaccess.model.acceso;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import pe.com.microdata.cjava.dataaccess.base.BaseVO;

/**
 *
 * @author Alejandra Gonzales
 */
@Entity
@Table(name = "rol_modulo")
public class AccesoModuloVO  extends BaseVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modulo", unique = true, nullable = false)
    private Integer idModulo;
    @Column(name = "nom_modulo")
    private String nombreModulo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "accesoModuloVO", cascade = CascadeType.ALL)
    Set<AccesoGrupoVO> accesoGrupoVOs;

    public Integer getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Integer idModulo) {
        this.idModulo = idModulo;
    }

    public String getNombreModulo() {
        return nombreModulo;
    }

    public void setNombreModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }

    public Set<AccesoGrupoVO> getAccesoGrupoVOs() {
        return accesoGrupoVOs;
    }

    public void setAccesoGrupoVOs(Set<AccesoGrupoVO> accesoGrupoVOs) {
        this.accesoGrupoVOs = accesoGrupoVOs;
    }

}
