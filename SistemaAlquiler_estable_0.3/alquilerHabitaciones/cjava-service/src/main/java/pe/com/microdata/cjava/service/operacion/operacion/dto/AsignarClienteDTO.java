/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.operacion.operacion.dto;

import java.util.List;
import pe.com.microdata.cjava.service.operacion.acciones_operacion.dto.OperAccionBaseDTO;

/**
 *
 * @author César Bragagnini
 */
public class AsignarClienteDTO extends OperAccionBaseDTO{ 
    
    private List<OperacionAlumnoDTO> lstAlumnos;

    public List<OperacionAlumnoDTO> getLstAlumnos() {
        return lstAlumnos;
    }

    public void setLstAlumnos(List<OperacionAlumnoDTO> lstAlumnos) {
        this.lstAlumnos = lstAlumnos;
    }
        
}
