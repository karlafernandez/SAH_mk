package pe.com.microdata.cjava.dataaccess.model.administracion.persona;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Formula;
import pe.com.microdata.cjava.dataaccess.base.BaseVO;
import pe.com.microdata.cjava.dataaccess.model.acceso.AccesoVO;

/**
 *
 * @author meliMeli
 */
@Entity
@Table(name = "persona")
//@Inheritance(strategy = InheritanceType.JOINED)
public class PersonaVO  extends BaseVO {

    //primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_per", unique = true, nullable = false)
    private Integer idPersona;
    //texto
    @Column(name = "user_per")
    private String usuarioPersona;
    @Column(name = "pass_per")
    private String passPersona;
    @Column(name = "nom_per")
    private String nomPersona;
    @Column(name = "pri_ape_per")
    private String primerApellidoPer;
    @Column(name = "seg_ape_per")
    private String segundoApellidoPer;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fec_nac_per")
    private Date fechaNacimientoPer;
    @Column(name = "dire_per")
    private String direccionPer;
    @Column(name = "ref_per")
    private String referenciaPer;
    @Column(name = "doc_per")
    private String documentoPer;
    @Temporal(TemporalType.TIMESTAMP) //DATE TIME
    @Column(name = "fec_registro_per")
    private Calendar fechaRegistroPer;
    @Column(name = "urb_per")
    private String urbanizacionPer;
    @Column(name = "corr_pers_per")
    private String correoPersonalPer;
    @Column(name = "corr_coor_per")
    private String correoCoorPer;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "celular")
    private String celular;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "est_eli")
    private Boolean estEliminado;
    @Column(name = "est_blo")
    private Boolean estBloqueado;
    @Formula("MONTH(fec_nac_per)")
    private Integer numeroMes;
    @Formula("DAY(fec_nac_per)")
    private Integer numeroDia;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ubigeo_id_ubi", nullable = false, updatable = false)
    private UbigeoVO ubigeoVO;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subtipo_id_doc", nullable = false, updatable = false)
    private SubTipoVO idDocumentoVO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tip_user", nullable = false)
    private SubTipoVO tipoUserVO;
    
    @ManyToMany (cascade = CascadeType.MERGE)
    @JoinTable(name = "rol_persona", joinColumns = {
        @JoinColumn(name = "persona_id_per")},  inverseJoinColumns = {
        @JoinColumn(name = "rol_id_rol" )} )
    private Set<AccesoVO> accesoVOs;
    
    @Column(name = "nro_intento")
    private Integer nroIntento;

    @Temporal(TemporalType.TIMESTAMP) //DATE TIME
    @Column(name = "fec_login")
    private Date fecLogin;

    public PersonaVO() {
    }

    public PersonaVO(String passPersona,
            String nomPersona,
            String primerApellidoPer,
            String segundoApellidoPer,
            Date fechaNacimientoPer,
            String direccionPer,
            String referenciaPer,
            String documentoPer,
            Calendar fechaRegistroPer,
            String urbanizacionPer,
            String correoPersonalPer,
            String correoCoorPer,
            UbigeoVO ubigeoVO,
            SubTipoVO idDocumentoVO,
            String telefono,
            String celular,
            String codigo
            ) {

        this.passPersona = passPersona;
        this.primerApellidoPer = primerApellidoPer;
        this.segundoApellidoPer = segundoApellidoPer;
        this.fechaNacimientoPer = fechaNacimientoPer;
        this.direccionPer = direccionPer;
        this.referenciaPer = referenciaPer;
        this.documentoPer = documentoPer;
        this.fechaRegistroPer = fechaRegistroPer;
        this.urbanizacionPer = urbanizacionPer;
        this.correoPersonalPer = correoPersonalPer;
        this.correoCoorPer = correoCoorPer;
        this.ubigeoVO = ubigeoVO;
        this.idDocumentoVO = idDocumentoVO;
        this.telefono = telefono;
        this.celular = celular;
        this.codigo = codigo;
        
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getUsuarioPersona() {
        return usuarioPersona;
    }

    public void setUsuarioPersona(String usuarioPersona) {
        this.usuarioPersona = usuarioPersona;
    }

    public String getPassPersona() {
        return passPersona;
    }

    public void setPassPersona(String passPersona) {
        this.passPersona = passPersona;
    }

    public String getNomPersona() {
        return nomPersona;
    }

    public void setNomPersona(String nomPersona) {
        this.nomPersona = nomPersona;
    }

    public String getPrimerApellidoPer() {
        return primerApellidoPer;
    }

    public void setPrimerApellidoPer(String primerApellidoPer) {
        this.primerApellidoPer = primerApellidoPer;
    }

    public String getSegundoApellidoPer() {
        return segundoApellidoPer;
    }

    public void setSegundoApellidoPer(String segundoApellidoPer) {
        this.segundoApellidoPer = segundoApellidoPer;
    }

    public Date getFechaNacimientoPer() {
        return fechaNacimientoPer;
    }

    public void setFechaNacimientoPer(Date fechaNacimientoPer) {
        this.fechaNacimientoPer = fechaNacimientoPer;
    }

    public String getDireccionPer() {
        return direccionPer;
    }

    public void setDireccionPer(String direccionPer) {
        this.direccionPer = direccionPer;
    }

    public String getReferenciaPer() {
        return referenciaPer;
    }

    public void setReferenciaPer(String referenciaPer) {
        this.referenciaPer = referenciaPer;
    }

    public String getDocumentoPer() {
        return documentoPer;
    }

    public void setDocumentoPer(String documentoPer) {
        this.documentoPer = documentoPer;
    }

    public Calendar getFechaRegistroPer() {
        return fechaRegistroPer;
    }

    public void setFechaRegistroPer(Calendar fechaRegistroPer) {
        this.fechaRegistroPer = fechaRegistroPer;
    }

    public String getUrbanizacionPer() {
        return urbanizacionPer;
    }

    public void setUrbanizacionPer(String urbanizacionPer) {
        this.urbanizacionPer = urbanizacionPer;
    }

    public String getCorreoPersonalPer() {
        return correoPersonalPer;
    }

    public void setCorreoPersonalPer(String correoPersonalPer) {
        this.correoPersonalPer = correoPersonalPer;
    }

    public String getCorreoCoorPer() {
        return correoCoorPer;
    }

    public void setCorreoCoorPer(String correoCoorPer) {
        this.correoCoorPer = correoCoorPer;
    }

    public UbigeoVO getUbigeoVO() {
        return ubigeoVO;
    }

    public void setUbigeoVO(UbigeoVO ubigeoVO) {
        this.ubigeoVO = ubigeoVO;
    }

    public Set<AccesoVO> getAccesoVOs() {
        return accesoVOs;
    }

    public void setAccesoVOs(Set<AccesoVO> accesoVOs) {
        this.accesoVOs = accesoVOs;
    }
  
    public SubTipoVO getIdDocumentoVO() {
        return idDocumentoVO;
    }

    public void setIdDocumentoVO(SubTipoVO idDocumentoVO) {
        this.idDocumentoVO = idDocumentoVO;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public SubTipoVO getTipoUserVO() {
        return tipoUserVO;
    }

    public void setTipoUserVO(SubTipoVO tipoUserVO) {
        this.tipoUserVO = tipoUserVO;
    }

    public Boolean getEstBloqueado() {
        return estBloqueado;
    }

    public void setEstBloqueado(Boolean estBloqueado) {
        this.estBloqueado = estBloqueado;
    }

    public Date getFecLogin() {
        return fecLogin;
    }

    public void setFecLogin(Date fecLogin) {
        this.fecLogin = fecLogin;
    }

    public Integer getNroIntento() {
        return nroIntento;
    }

    public void setNroIntento(Integer nroIntento) {
        this.nroIntento = nroIntento;
    }

    public Boolean getEstEliminado() {
        return estEliminado;
    }

    public void setEstEliminado(Boolean estEliminado) {
        this.estEliminado = estEliminado;
    }

    public Integer getNumeroMes() {
        return numeroMes;
    }

    public void setNumeroMes(Integer numeroMes) {
        this.numeroMes = numeroMes;
    }

    public Integer getNumeroDia() {
        return numeroDia;
    }

    public void setNumeroDia(Integer numeroDia) {
        this.numeroDia = numeroDia;
    }
    
}
