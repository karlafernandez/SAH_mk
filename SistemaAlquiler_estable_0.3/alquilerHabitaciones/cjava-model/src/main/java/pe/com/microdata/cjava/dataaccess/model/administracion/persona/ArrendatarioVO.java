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
    private Integer idInstructor;

 
    ////////////////// one to one 
    @OneToOne(fetch= FetchType.LAZY, cascade= CascadeType.ALL,optional=false)
    @JoinColumn(name = "persona_id_per")
    private PersonaVO instructorPersonaVO;

    public ArrendatarioVO(){
     
    }
    
        public ArrendatarioVO(
                PersonaVO instructorPersondaVO
            ){
            this.instructorPersonaVO = instructorPersonaVO;
        
     
    }    

    public Integer getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(Integer idInstructor) {
        this.idInstructor = idInstructor;
    }

    public PersonaVO getInstructorPersonaVO() {
        return instructorPersonaVO;
    }

    public void setInstructorPersonaVO(PersonaVO instructorPersonaVO) {
        this.instructorPersonaVO = instructorPersonaVO;
    }
    
 
 
    
   


  
   
}
