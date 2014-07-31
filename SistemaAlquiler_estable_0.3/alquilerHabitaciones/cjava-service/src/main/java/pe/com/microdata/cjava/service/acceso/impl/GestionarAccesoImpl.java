/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.acceso.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.dataaccess.domain.acceso.AccesoDAO;
import pe.com.microdata.cjava.dataaccess.domain.acceso.AccesoModuloDAO;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.PersonaDAO;
import pe.com.microdata.cjava.dataaccess.model.acceso.AccesoGrupoVO;
import pe.com.microdata.cjava.dataaccess.model.acceso.AccesoModuloVO;
import pe.com.microdata.cjava.dataaccess.model.acceso.AccesoVO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.PersonaVO;
import pe.com.microdata.cjava.service.acceso.GestionarAcceso;
import pe.com.microdata.cjava.service.acceso.comparator.AccesoItemComparator;
import pe.com.microdata.cjava.service.acceso.dto.AccesoItemDTO;
import pe.com.microdata.cjava.service.acceso.dto.AsignarAccesoDTO;
 


@Service("gestionarAcceso")
public class GestionarAccesoImpl implements GestionarAcceso {

    @Autowired
    private PersonaDAO personaDAO;
    @Autowired
    private AccesoDAO accesoDAO;
    @Autowired
    private AccesoModuloDAO moduloDAO;

    @Override
    public List obtenerAccesosPorIdUsuario(Integer idUsuario) {
        PersonaVO personaVO = this.personaDAO.obtenerPersonaPorId(idUsuario);
        List<Integer> accesoItemDTOs = new ArrayList<Integer>();
        for (AccesoVO accesoVO : personaVO.getAccesoVOs()) {
            accesoItemDTOs.add(accesoVO.getIdAcceso());
        }
        return accesoItemDTOs;
    }

    @Override
    public SIGAMessage asignarAccesosPorUsuario(AsignarAccesoDTO asignarAccesoDTO) {
        SIGAMessage message = new SIGAMessage();
        PersonaVO usuario = this.personaDAO.obtenerPersonaPorId(asignarAccesoDTO.getIdUsuario());

        Set accesos = new HashSet(0);
        for (Integer idAcceso : asignarAccesoDTO.getLstAccesos()) {
            AccesoVO acceso = this.accesoDAO.get(idAcceso);
            accesos.add(acceso);
        }
        usuario.setAccesoVOs(accesos);

        if (this.personaDAO.merge(usuario) != null) {
            message.setMessageType(SIGAMessage.MessageType.SUCCESS);
            message.addMessages("Los accesos han sido otorgados al usuario satisfactoriamente.");
        } else {
            message.setMessageType(SIGAMessage.MessageType.ERROR);
            message.addMessages("La acción no pudo ser realizada.");
        }

        return message;
    }

    @Override
    public List obtenerAccesos() {

        List<AccesoItemDTO> modulosDTOs = new ArrayList<AccesoItemDTO>();
        List<AccesoModuloVO> modulos = moduloDAO.obtenerModulosAccesos();

        AccesoItemDTO moduloItem = new AccesoItemDTO();
        for (AccesoModuloVO modulo : modulos) {
            moduloItem = new AccesoItemDTO(modulo.getIdModulo(), modulo.getNombreModulo());
            List<AccesoItemDTO> grupos = new ArrayList<AccesoItemDTO>();
            AccesoItemDTO grupoItem = new AccesoItemDTO();
            for (AccesoGrupoVO grupo : modulo.getAccesoGrupoVOs()) {
                grupoItem = new AccesoItemDTO(grupo.getIdGrupo(), grupo.getNombreGrupo());
                List<AccesoItemDTO> accesos = new ArrayList<AccesoItemDTO>();
                for (AccesoVO acceso : grupo.getAccesoVOs()) {
                    accesos.add(new AccesoItemDTO(acceso.getIdAcceso(), acceso.getDesAcceso()));
                }
                Collections.sort(accesos, new AccesoItemComparator());
                grupoItem.setListado(accesos);
                grupos.add(grupoItem);
            }
            Collections.sort(grupos, new AccesoItemComparator());
            moduloItem.setListado(grupos);
            modulosDTOs.add(moduloItem);
        } 
        Collections.sort(modulosDTOs, new AccesoItemComparator());

        return modulosDTOs;

    }
}
