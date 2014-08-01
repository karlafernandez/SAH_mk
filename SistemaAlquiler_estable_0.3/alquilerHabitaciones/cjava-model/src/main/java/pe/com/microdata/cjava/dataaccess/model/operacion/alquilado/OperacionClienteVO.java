package pe.com.microdata.cjava.dataaccess.model.operacion.alquilado;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import pe.com.microdata.cjava.dataaccess.base.BaseVO;



/**
 *
 * @author meliMeli
*/
@Entity
@Table(name = "operacion_cliente")
public class OperacionClienteVO extends BaseVO {

    //primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sal", unique = true, nullable = false)
    private Integer idOpeCliente;

    @Column(name = "calificacion")
    private Integer calificacion;


    //////////////////many to one

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operacion_id_ope", nullable = true, updatable = false)
    private AlquilarVO operacionVO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id_cli", nullable = true, updatable = false)
    private ClienteVO clienteVO;

 
 
    public OperacionClienteVO() {
    }

  

   
   
    /**
     * @return the idOpeCliente
     */
    public Integer getIdOpeCliente() {
        return idOpeCliente;
    }

    /**
     * @param idOpeCliente the idOpeCliente to set
     */
    public void setIdOpeCliente(Integer idOpeCliente) {
        this.idOpeCliente = idOpeCliente;
    }

    /**
     * @return the calificacion
     */
    public Integer getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * @return the clienteVO
     */
    public ClienteVO getClienteVO() {
        return clienteVO;
    }

    /**
     * @param clienteVO the clienteVO to set
     */
    public void setClienteVO(ClienteVO clienteVO) {
        this.clienteVO = clienteVO;
    }

    /**
     * @return the operacionVO
     */
    public AlquilarVO getOperacionVO() {
        return operacionVO;
    }

    /**
     * @param operacionVO the operacionVO to set
     */
    public void setOperacionVO(AlquilarVO operacionVO) {
        this.operacionVO = operacionVO;
    }

    /**
     * @return the idClienteVO
     */
  

 

}
