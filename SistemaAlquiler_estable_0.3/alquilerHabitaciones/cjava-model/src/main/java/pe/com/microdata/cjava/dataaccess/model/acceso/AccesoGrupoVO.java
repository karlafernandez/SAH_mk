package pe.com.microdata.cjava.dataaccess.model.acceso;

import java.util.Set;
import javax.persistence.CascadeType;
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
import pe.com.microdata.cjava.dataaccess.base.BaseVO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alejandra Gonzales
 */
@Entity
@Table(name = "rol_grupo")
public class AccesoGrupoVO  extends BaseVO{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo", unique = true, nullable = false)
    private Integer idGrupo;
    @Column(name = "nom_grupo")
    private String nombreGrupo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_modulo_id_modulo", nullable = false, updatable = false)
    AccesoModuloVO accesoModuloVO; 
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "accesoGrupoVO", cascade = CascadeType.ALL)
    Set<AccesoVO> accesoVOs;

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public AccesoModuloVO getAccesoModuloVO() {
        return accesoModuloVO;
    }

    public void setAccesoModuloVO(AccesoModuloVO accesoModuloVO) {
        this.accesoModuloVO = accesoModuloVO;
    }

    public Set<AccesoVO> getAccesoVOs() {
        return accesoVOs;
    }

    public void setAccesoVOs(Set<AccesoVO> accesoVOs) {
        this.accesoVOs = accesoVOs;
    }

}
