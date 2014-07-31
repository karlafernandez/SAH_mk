package pe.com.microdata.cjava.dataaccess.model.administracion.persona;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import pe.com.microdata.cjava.dataaccess.base.BaseVO;

 
/*******************************************************************************
Fecha de creación: 09-01-2012
Nombre: Jimmy Valverde Sanchez
Descripción: Esta clase representa a la tabla tipo
Actualizaciones:
Fecha           Autor			Descripción
--------------------------------------------------------------------------------

*******************************************************************************/
@Entity
@Table(name = "tipo")
public class TipoVO  extends BaseVO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tip", unique = true, nullable = false)
    private Integer idTipo;
    
    @Column(name = "nom_tip")
    private String nomTipo;

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getNomTipo() {
        return nomTipo;
    }

    public void setNomTipo(String nomTipo) {
        this.nomTipo = nomTipo;
    }
    
    
    
}