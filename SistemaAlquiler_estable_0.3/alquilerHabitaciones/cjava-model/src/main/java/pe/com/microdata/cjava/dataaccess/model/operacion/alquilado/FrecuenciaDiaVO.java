/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.dataaccess.model.operacion.alquilado;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import pe.com.microdata.cjava.dataaccess.base.BaseVO;

/**
 *
 * @author César Bragagnini
 */
@Entity
@Table(name = "frecuencia_dia")
public class FrecuenciaDiaVO  extends BaseVO {
    
    @Id     
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fre", unique = true, nullable = false)
    private Integer idFrecuDia;
    
    @Column(name = "id_ope")
    private Integer idOperacion;
    
    @Column(name = "dia_lunes")
    private Boolean diaLunes;
    
    @Column(name = "dia_martes")
    private Boolean diaMartes;
    
    @Column(name = "dia_miercoles")
    private Boolean diaMiercoles;
    
    @Column(name = "dia_jueves")
    private Boolean diaJueves;
    
    @Column(name = "dia_viernes")
    private Boolean diaViernes;
    
    @Column(name = "dia_sabado")
    private Boolean diaSabado;
    
    @Column(name = "dia_domingo")
    private Boolean diaDomingo;

    public Integer getIdFrecuDia() {
        return idFrecuDia;
    }

    public void setIdFrecuDia(Integer idFrecuDia) {
        this.idFrecuDia = idFrecuDia;
    }

    public Integer getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public Boolean getDiaLunes() {
        return diaLunes;
    }

    public void setDiaLunes(Boolean diaLunes) {
        this.diaLunes = diaLunes;
    }

    public Boolean getDiaMartes() {
        return diaMartes;
    }

    public void setDiaMartes(Boolean diaMartes) {
        this.diaMartes = diaMartes;
    }

    public Boolean getDiaMiercoles() {
        return diaMiercoles;
    }

    public void setDiaMiercoles(Boolean diaMiercoles) {
        this.diaMiercoles = diaMiercoles;
    }

    public Boolean getDiaJueves() {
        return diaJueves;
    }

    public void setDiaJueves(Boolean diaJueves) {
        this.diaJueves = diaJueves;
    }

    public Boolean getDiaViernes() {
        return diaViernes;
    }

    public void setDiaViernes(Boolean diaViernes) {
        this.diaViernes = diaViernes;
    }

    public Boolean getDiaSabado() {
        return diaSabado;
    }

    public void setDiaSabado(Boolean diaSabado) {
        this.diaSabado = diaSabado;
    }

    public Boolean getDiaDomingo() {
        return diaDomingo;
    }

    public void setDiaDomingo(Boolean diaDomingo) {
        this.diaDomingo = diaDomingo;
    }
        
}
