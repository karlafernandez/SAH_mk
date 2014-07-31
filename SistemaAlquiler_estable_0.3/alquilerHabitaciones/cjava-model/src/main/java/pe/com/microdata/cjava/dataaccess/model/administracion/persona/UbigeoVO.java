package pe.com.microdata.cjava.dataaccess.model.administracion.persona;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import pe.com.microdata.cjava.dataaccess.base.BaseVO;


/**
 *
 * @author meliMeli
 */
@Entity
@Table(name = "ubigeo" )
public class UbigeoVO  extends BaseVO {

    //primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_ubi", unique = true, nullable = false)
    private Integer idUbigeo;

    //texto
    @Column(name = "id_pai_ubi")
    private String idPais;

    @Column(name = "id_dep_ubi")
    private String idDepartamento;

    @Column(name = "id_pro_ubi")
    private String idProvincia;

    @Column(name = "id_dis_ubi")
    private String idDistrito;
    
    @Column(name = "nom_ubi")
    private String nombreUbigeo;
    
    
    
     public UbigeoVO(){
     
    }
    
        public UbigeoVO(
                String idPais, 
                String idDepartamento, 
                String idProvincia, 
                String idDistrito,
                String nombreUbigeo
                ){
            this.idPais = idPais;
            this.idDepartamento =idDepartamento;
            this.idProvincia = idProvincia;
            this.idDistrito=idDistrito;
            this.nombreUbigeo =nombreUbigeo;
       
     
    }    
    
    
 

    public Integer getIdUbigeo() {
        return idUbigeo;
    }

    public void setIdUbigeo(Integer idUbigeo) {
        this.idUbigeo = idUbigeo;
    }

    public String getIdPais() {
        return idPais;
    }

    public void setIdPais(String idPais) {
        this.idPais = idPais;
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(String idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(String idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getNombreUbigeo() {
        return nombreUbigeo;
    }

    public void setNombreUbigeo(String nombreUbigeo) {
        this.nombreUbigeo = nombreUbigeo;
    }

   
}
