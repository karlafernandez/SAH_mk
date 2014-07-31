/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.paciente.impl;

 
import pe.com.microdata.cjava.service.paciente.GestionarPaciente;
import pe.com.microdata.cjava.service.paciente.dto.PacienteDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import pe.com.microdata.cjava.dataaccess.domain.PacienteDAO;
//import pe.com.microdata.cjava.dataaccess.model.PacienteVO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.SubTipoVO;

/**
 *
 * @author Alejandra Gonzales
 */

@Service("gestionarPaciente")
public class GestionarPacienteImpl implements GestionarPaciente {
/*
    @Autowired
    PacienteDAO pacienteDAO;

    @Override
    public List obtenerPaciente() {
        List<PacienteDTO> pacienteDTOs = new ArrayList<PacienteDTO>();
        List<PacienteVO> pacienteVOs = pacienteDAO.getAll();
        PacienteDTO pacienteDTO = new PacienteDTO();
        for (PacienteVO pacienteVO : pacienteVOs) {
            pacienteDTO = new PacienteDTO();
            pacienteDTO.setNombre(pacienteVO.getNombre());
            pacienteDTO.setApePaterno(pacienteVO.getApePaterno());
            pacienteDTO.setApeMaterno(pacienteVO.getApeMaterno());
            pacienteDTOs.add(pacienteDTO);

        }
        return pacienteDTOs;


    }

    @Override
    public boolean registrarPaciente(PacienteDTO dto) {
        boolean registrado = false;
        PacienteVO vo = new PacienteVO();
        vo.setNumDocumento(dto.getNumDocumento());
        vo.setApePaterno(dto.getApePaterno());
        vo.setApeMaterno(dto.getApeMaterno());
        vo.setNombre(dto.getNombre());
//        vo.setTipDocumento(new SubTipoVO(dto.getIdTipoDocumento()));
        Integer id = pacienteDAO.insert(vo);
        if (id != 0) {
            registrado = true;
        }
        return registrado; 
    }
    * 
    * */
}
