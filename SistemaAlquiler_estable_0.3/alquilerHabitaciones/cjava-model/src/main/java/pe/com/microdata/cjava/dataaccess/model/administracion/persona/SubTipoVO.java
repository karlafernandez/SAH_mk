package pe.com.microdata.cjava.dataaccess.model.administracion.persona;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import pe.com.microdata.cjava.dataaccess.base.BaseVO;

/**
 * *****************************************************************************
 * Fecha de creación: 09-01-2012 Nombre: Jimmy Valverde Sanchez Descripción:
 * Esta clase representa a la tabla subtipo Actualizaciones: Fecha Autor
 * Descripción
 * --------------------------------------------------------------------------------
 *
 ******************************************************************************
 */
@Entity
@Table(name = "subtipo")
public class SubTipoVO  extends BaseVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sub_tip", unique = true, nullable = false)
    private Integer idSubTipo;

    @Column(name = "nom_sub_tip")
    private String nomSubtipo;
    
    @Column(name = "des_sub_tip")
    private String desSubtipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_id_tip", nullable = false, updatable = false )
    private TipoVO tipoVO;

    /*
     @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subtipo_id_doc", nullable = false, updatable = false )
    private SubTipoVO idTipoDocumento;
     
     */
    
    public SubTipoVO() {
    }
    public SubTipoVO(Integer idTipoModo) {
        this.idSubTipo=idTipoModo;
    }
    
    
    
    public Integer getIdSubTipo() {
        return idSubTipo;
    }

    public void setIdSubTipo(Integer idSubTipo) {
        this.idSubTipo = idSubTipo;
    }

    public String getNomSubtipo() {
        return nomSubtipo;
    }

    public void setNomSubtipo(String nomSubtipo) {
        this.nomSubtipo = nomSubtipo;
    }

    public TipoVO getTipoVO() {
        return tipoVO;
    }

    public void setTipoVO(TipoVO tipoVO) {
        this.tipoVO = tipoVO;
    }

    public String getDesSubtipo() {
        return desSubtipo;
    }

    public void setDesSubtipo(String desSubtipo) {
        this.desSubtipo = desSubtipo;
    }
            
}