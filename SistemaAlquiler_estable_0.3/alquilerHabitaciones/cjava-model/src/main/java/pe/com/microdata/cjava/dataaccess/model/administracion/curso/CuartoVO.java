/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.dataaccess.model.administracion.curso;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import pe.com.microdata.cjava.dataaccess.base.BaseVO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.ArrendatarioVO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.UbigeoVO;
import pe.com.microdata.cjava.dataaccess.model.operacion.alquilado.AlquilarVO;


@Entity
@Table(name = "cuarto")
public class CuartoVO extends BaseVO{
    
    @Id     
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cur", unique = true, nullable = false)
    private Integer idCuarto;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "nomen_cur")
    private String nomenclaturaCuarto;
    
    @Column(name = "num_ambientes")
    private Integer numAmbientes;
   
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fec_reg_cur")
    private Calendar fecRegCur; 

    @Column(name = "act_cur_esp")
    private Boolean actCurEsp;
    
    @Column(name = "restricciones")
    private String restricciones;
    
    @Column(name = "detalle_ubi")
    private String detalleUbicacion;
      
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ubigeo_id_ubi", nullable = false, updatable = false)
    private UbigeoVO ubigeoCuartoVO;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_arrendatario", nullable = false, updatable = false)
    private ArrendatarioVO arrendatarioCuartoVO;
         
     @OneToMany(fetch = FetchType.LAZY, mappedBy = "idCursoEspVO", cascade = CascadeType.ALL)
    private List<AlquilarVO> listaOperacionVO = new ArrayList<AlquilarVO>();

    
    public CuartoVO(){        
    }
    
    public CuartoVO(Integer idCuarto) {
        this.idCuarto = idCuarto;
    }   
        
   

    public Calendar getFecRegCur() {
        return fecRegCur;
    }

    public void setFecRegCur(Calendar fecRegCur) {
        this.fecRegCur = fecRegCur;
    }                  

    public Boolean getActCurEsp() {
        return actCurEsp;
    }

    public void setActCurEsp(Boolean actCurEsp) {
        this.actCurEsp = actCurEsp;
    }

    /**
     * @return the listaOperacionVO
     */
    public List<AlquilarVO> getListaOperacionVO() {
        return listaOperacionVO;
    }

    /**
     * @param listaOperacionVO the listaOperacionVO to set
     */
    public void setListaOperacionVO(List<AlquilarVO> listaOperacionVO) {
        this.listaOperacionVO = listaOperacionVO;
    }

    /**
     * @return the idCuarto
     */
    public Integer getIdCuarto() {
        return idCuarto;
    }

    /**
     * @param idCuarto the idCuarto to set
     */
    public void setIdCuarto(Integer idCuarto) {
        this.idCuarto = idCuarto;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the nomenclaturaCuarto
     */
    public String getNomenclaturaCuarto() {
        return nomenclaturaCuarto;
    }

    /**
     * @param nomenclaturaCuarto the nomenclaturaCuarto to set
     */
    public void setNomenclaturaCuarto(String nomenclaturaCuarto) {
        this.nomenclaturaCuarto = nomenclaturaCuarto;
    }

    /**
     * @return the numAmbientes
     */
    public Integer getNumAmbientes() {
        return numAmbientes;
    }

    /**
     * @param numAmbientes the numAmbientes to set
     */
    public void setNumAmbientes(Integer numAmbientes) {
        this.numAmbientes = numAmbientes;
    }

    /**
     * @return the restricciones
     */
    public String getRestricciones() {
        return restricciones;
    }

    /**
     * @param restricciones the restricciones to set
     */
    public void setRestricciones(String restricciones) {
        this.restricciones = restricciones;
    }

    /**
     * @return the detalleUbicacion
     */
    public String getDetalleUbicacion() {
        return detalleUbicacion;
    }

    /**
     * @param detalleUbicacion the detalleUbicacion to set
     */
    public void setDetalleUbicacion(String detalleUbicacion) {
        this.detalleUbicacion = detalleUbicacion;
    }

    /**
     * @return the ubigeoCuartoVO
     */
    public UbigeoVO getUbigeoCuartoVO() {
        return ubigeoCuartoVO;
    }

    /**
     * @param ubigeoCuartoVO the ubigeoCuartoVO to set
     */
    public void setUbigeoCuartoVO(UbigeoVO ubigeoCuartoVO) {
        this.ubigeoCuartoVO = ubigeoCuartoVO;
    }

    /**
     * @return the arrendatarioCuartoVO
     */
    public ArrendatarioVO getArrendatarioCuartoVO() {
        return arrendatarioCuartoVO;
    }

    /**
     * @param arrendatarioCuartoVO the arrendatarioCuartoVO to set
     */
    public void setArrendatarioCuartoVO(ArrendatarioVO arrendatarioCuartoVO) {
        this.arrendatarioCuartoVO = arrendatarioCuartoVO;
    }
                    
}
 