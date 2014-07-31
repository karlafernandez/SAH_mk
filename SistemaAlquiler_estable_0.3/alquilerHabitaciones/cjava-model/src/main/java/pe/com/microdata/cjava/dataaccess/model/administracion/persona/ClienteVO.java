package pe.com.microdata.cjava.dataaccess.model.administracion.persona;

import java.util.ArrayList;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.IndexColumn;
import pe.com.microdata.cjava.dataaccess.base.BaseVO;
import pe.com.microdata.cjava.dataaccess.model.operacion.alquilado.OperacionClienteVO;

@Entity
@Table(name = "cliente")
public class ClienteVO extends BaseVO {

    //primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alu", unique = true, nullable = false)
    private Integer idAlumno;
    
    //texto
    @Column(name = "ins_alu")
    private String institucionAlumno;
    
    @Column(name = "cen_tra_alu")
    private String centroTrabajoAlumno;
    
    @Column(name = "corr_fac_alu")
    private String correoFaceAlumno;
    
    @Column(name = "corr_lin_alu")
    private String correoLinkeAlumno;
    
    @Column(name = "fot_alu")
    private Integer fotoAlumno;
    
    /*=========ONE TO ONE ==========*/
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id_per")
    private PersonaVO alumnoPersonaVO;
    
    /*=========MANY TO ONE ==========*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subtipo_id_cen_edu", nullable = true, updatable = true)
    private SubTipoVO centroEducativo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subtipo_id_niv_est", nullable = true, updatable = true)
    private SubTipoVO nivelEstudio;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subtipo_id_ocupacion", nullable = true, updatable = true)
    private SubTipoVO ocupacion;
    
    /*=========ONE TO MANY ==========*/      
    @OneToMany(mappedBy = "alumnoVO", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @IndexColumn(name="id_sal")    
    private List<OperacionClienteVO> lstOperacionAlumnoDevVOs = new ArrayList<OperacionClienteVO>();
    
    public ClienteVO() {
    }

    public ClienteVO(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }
    
    public ClienteVO(
            String institucionAlumno,
            String centroTrabajoAlumno,
            String correoFaceAlumno,
            String correoLinkeAlumno,
            Integer fotoAlumno,
            PersonaVO idPersonaVO,
            SubTipoVO centroEducativo,
            SubTipoVO nivelEstudio,
            SubTipoVO ocupacion,
            PersonaVO alumnoPersonaVO) {
        this.institucionAlumno = institucionAlumno;
        this.centroTrabajoAlumno = centroTrabajoAlumno;
        this.correoFaceAlumno = correoFaceAlumno;
        this.correoLinkeAlumno = correoLinkeAlumno;
        this.fotoAlumno = fotoAlumno;
        this.alumnoPersonaVO = alumnoPersonaVO;
        this.centroEducativo = centroEducativo;
        this.nivelEstudio = nivelEstudio;
        this.ocupacion = ocupacion;
    }

    public String getInstitucionAlumno() {
        return institucionAlumno;
    }

    public void setInstitucionAlumno(String institucionAlumno) {
        this.institucionAlumno = institucionAlumno;
    }

    public String getCentroTrabajoAlumno() {
        return centroTrabajoAlumno;
    }

    public void setCentroTrabajoAlumno(String centroTrabajoAlumno) {
        this.centroTrabajoAlumno = centroTrabajoAlumno;
    }

    public String getCorreoFaceAlumno() {
        return correoFaceAlumno;
    }

    public void setCorreoFaceAlumno(String correoFaceAlumno) {
        this.correoFaceAlumno = correoFaceAlumno;
    }

    public String getCorreoLinkeAlumno() {
        return correoLinkeAlumno;
    }

    public void setCorreoLinkeAlumno(String correoLinkeAlumno) {
        this.correoLinkeAlumno = correoLinkeAlumno;
    }

    public Integer getFotoAlumno() {
        return fotoAlumno;
    }

    public void setFotoAlumno(Integer fotoAlumno) {
        this.fotoAlumno = fotoAlumno;
    }

    public SubTipoVO getCentroEducativo() {
        return centroEducativo;
    }

    public void setCentroEducativo(SubTipoVO centroEducativo) {
        this.centroEducativo = centroEducativo;
    }

    public SubTipoVO getNivelEstudio() {
        return nivelEstudio;
    }

    public void setNivelEstudio(SubTipoVO nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public PersonaVO getAlumnoPersonaVO() {
        return alumnoPersonaVO;
    }

    public void setAlumnoPersonaVO(PersonaVO alumnoPersonaVO) {
        this.alumnoPersonaVO = alumnoPersonaVO;
    }

    public SubTipoVO getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(SubTipoVO ocupacion) {
        this.ocupacion = ocupacion;
    }

    public List<OperacionClienteVO> getLstOperacionAlumnoDevVOs() {
        return lstOperacionAlumnoDevVOs;
    }

    public void setLstOperacionAlumnoDevVOs(List<OperacionClienteVO> lstOperacionAlumnoDevVOs) {
        this.lstOperacionAlumnoDevVOs = lstOperacionAlumnoDevVOs;
    }
}
