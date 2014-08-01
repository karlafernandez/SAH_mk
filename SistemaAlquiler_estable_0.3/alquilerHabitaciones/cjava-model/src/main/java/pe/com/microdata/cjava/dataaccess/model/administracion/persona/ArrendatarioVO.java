package pe.com.microdata.cjava.dataaccess.model.administracion.persona;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import pe.com.microdata.cjava.dataaccess.base.BaseVO;


/**
 *
 * @author meliMeli
 */
@Entity
@Table(name = "arrendatario" )
public class ArrendatarioVO  extends BaseVO{

    //primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_ins", unique = true, nullable = false)
    private Integer idArrendatario;

 
    ////////////////// one to one 
    @OneToOne(fetch= FetchType.LAZY, cascade= CascadeType.ALL,optional=false)
    @JoinColumn(name = "persona_id_per")
    private PersonaVO arrendatarioPersonaVO;

    public ArrendatarioVO(){
     
    }
    
        public ArrendatarioVO(
                PersonaVO instructorPersondaVO
            ){
            this.arrendatarioPersonaVO = arrendatarioPersonaVO;
        
     
    }    

    public Integer getIdInstructor() {
        return idArrendatario;
    }

    public void setIdInstructor(Integer idInstructor) {
        this.idArrendatario = idInstructor;
    }

    public PersonaVO getInstructorPersonaVO() {
        return arrendatarioPersonaVO;
    }

    public void setInstructorPersonaVO(PersonaVO instructorPersonaVO) {
        this.arrendatarioPersonaVO = instructorPersonaVO;
    }
    
 
 
    
   


  
   
}
