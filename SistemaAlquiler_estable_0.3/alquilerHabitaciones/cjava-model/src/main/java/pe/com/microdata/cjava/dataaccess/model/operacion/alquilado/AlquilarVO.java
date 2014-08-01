package pe.com.microdata.cjava.dataaccess.model.operacion.alquilado;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.Formula;
import pe.com.microdata.cjava.dataaccess.base.BaseVO;
import pe.com.microdata.cjava.dataaccess.model.administracion.curso.CuartoVO;


@Entity
@Table(name = "alquilar")
public class AlquilarVO extends BaseVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ope", unique = true, nullable = false)
    private Integer idAlquilar;
    
    @Column(name = "cod_ope")
    private String codigoOperacion;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fec_ini_ope")
    private Date fechaInicioOp;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fec_fin_ope")
    private Date fechaFinOp;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fec_registro_ope")
    private Date fechaRegistroOpe;
    
      
  
    @Formula("datediff(fec_fin_ope, date(now()))")   
    private Integer difDias;
    
    /*========= ONE TO ONE===========*/
  
    @Column(name = "act_ope")
    private Boolean activaOperacion;
    
    @Column(name = "nom_sal")
    private String nomSalon;
    
    /*========= MANY TO ONE===========*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuarto_id_cur", nullable = true, updatable = true)
    private CuartoVO idCuartoVO;
    
   
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subtipo_id_tur", nullable = true, updatable = true)
    private SubTipoVO idTurnoVO;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subtipo_id_est", nullable = true, updatable = true)
    private SubTipoVO idEstadoVO;
    
 
    @IndexColumn(name="id_sal")   
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idOperacionVO", cascade = CascadeType.ALL)
    private List<OperacionClienteVO> listaClienteVO = new ArrayList<OperacionClienteVO>();
        

    public AlquilarVO() {
    }

   

  
    public String getCodigoOperacion() {
        return codigoOperacion;
    }

    public void setCodigoOperacion(String codigoOperacion) {
        this.codigoOperacion = codigoOperacion;
    }

    public Date getFechaInicioOp() {
        return fechaInicioOp;
    }

    public void setFechaInicioOp(Date fechaInicioOp) {
        this.fechaInicioOp = fechaInicioOp;
    }

    public Date getFechaFinOp() {
        return fechaFinOp;
    }

    public void setFechaFinOp(Date fechaFinOp) {
        this.fechaFinOp = fechaFinOp;
    }

    public Boolean getActivaOperacion() {
        return activaOperacion;
    }

    public void setActivaOperacion(Boolean activaOperacion) {
        this.activaOperacion = activaOperacion;
    }
      
  

   

    public SubTipoVO getIdTurnoVO() {
        return idTurnoVO;
    }

    public void setIdTurnoVO(SubTipoVO idTurnoVO) {
        this.idTurnoVO = idTurnoVO;
    }

    public SubTipoVO getIdEstadoVO() {
        return idEstadoVO;
    }

    public void setIdEstadoVO(SubTipoVO idEstadoVO) {
        this.idEstadoVO = idEstadoVO;
    }

    public Date getFechaRegistroOpe() {
        return fechaRegistroOpe;
    }

    public void setFechaRegistroOpe(Date fechaRegistroOpe) {
        this.fechaRegistroOpe = fechaRegistroOpe;
    }

      

    public String getNomSalon() {
        return nomSalon;
    }

    public void setNomSalon(String nomSalon) {
        this.nomSalon = nomSalon;
    }

   

  

    public Integer getDifDias() {
        return difDias;
    }

    public void setDifDias(Integer difDias) {
        this.difDias = difDias;
    }

    /**
     * @return the idAlquilar
     */
    public Integer getIdAlquilar() {
        return idAlquilar;
    }

    /**
     * @param idAlquilar the idAlquilar to set
     */
    public void setIdAlquilar(Integer idAlquilar) {
        this.idAlquilar = idAlquilar;
    }

    /**
     * @return the idCuartoVO
     */
    public CuartoVO getIdCuartoVO() {
        return idCuartoVO;
    }

    /**
     * @param idCuartoVO the idCuartoVO to set
     */
    public void setIdCuartoVO(CuartoVO idCuartoVO) {
        this.idCuartoVO = idCuartoVO;
    }

    /**
     * @return the listaClienteVO
     */
    public List<OperacionClienteVO> getListaClienteVO() {
        return listaClienteVO;
    }

    /**
     * @param listaClienteVO the listaClienteVO to set
     */
    public void setListaClienteVO(List<OperacionClienteVO> listaClienteVO) {
        this.listaClienteVO = listaClienteVO;
    }

   
                    
}
