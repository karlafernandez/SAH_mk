package pe.com.microdata.cjava.dataaccess.model.administracion.persona;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import pe.com.microdata.cjava.dataaccess.base.BaseVO;

@Entity
@Table(name = "cliente")
public class ClienteVO extends BaseVO {

    //primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alu", unique = true, nullable = false)
    private Integer idCliente;
    

    @Column(name = "corr_fac_alu")
    private String correoFaceAlumno;

 
    
    /*=========ONE TO ONE ==========*/
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id_per")
    private PersonaVO clientePersonaVO;
    
 
    public ClienteVO() {
    }

    public ClienteVO(Integer idAlumno) {
        this.idCliente = idCliente;
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
   
        this.correoFaceAlumno = correoFaceAlumno;

    }

 

    public String getCorreoFaceAlumno() {
        return correoFaceAlumno;
    }

    public void setCorreoFaceAlumno(String correoFaceAlumno) {
        this.correoFaceAlumno = correoFaceAlumno;
    }

  

    /**
     * @return the idCliente
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the clientePersonaVO
     */
    public PersonaVO getClientePersonaVO() {
        return clientePersonaVO;
    }

    /**
     * @param clientePersonaVO the clientePersonaVO to set
     */
    public void setClientePersonaVO(PersonaVO clientePersonaVO) {
        this.clientePersonaVO = clientePersonaVO;
    }

  
}
