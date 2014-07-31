/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.log.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.dataaccess.domain.log.LogDAO;
import pe.com.microdata.cjava.dataaccess.model.log.LogDetalleVO;
import pe.com.microdata.cjava.dataaccess.model.log.LogVO;
import pe.com.microdata.cjava.service.log.GestionarLog;
import pe.com.microdata.cjava.service.log.dto.LogDTO;
import pe.com.microdata.cjava.service.log.dto.LogDetalleDTO;

/**
 *
 * @author Alejandra Gonzales
 */
@Service("gestionarLog")
public class GestionarLogImpl implements GestionarLog {

    private SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.FORMATO_FECHA_HORA);

    @Autowired
    LogDAO logDAO;

    @Override
    public List obtenerLogsPorBusqueda(BusquedaDTO busquedaDTO) {
        List<LogVO> logVOs = logDAO.obtenerLogsPorBusqueda(busquedaDTO);
        List<LogDTO> logDTOs = new ArrayList<LogDTO>();
        for (LogVO vo : logVOs) {
            LogDTO dto = new LogDTO();
            dto.setIdLog(vo.getIdLog());
            dto.setUsuario(vo.getUsuario());
            dto.setAccion(vo.getAccion());
            dto.setUbicacion(vo.getUbicacion());
            dto.setEntidad(vo.getEntidad());
            dto.setFecha(dateFormat.format(vo.getFecha()));
            logDTOs.add(dto);
        }
        return logDTOs;

    }

    @Override
    public Long obtenerTotalLogsPorBusqueda(BusquedaDTO busquedaDTO) {
        Long total = logDAO.obtenerTotalLogsPorBusqueda(busquedaDTO);
        return total;
    }

    @Override
    public LogDTO obtenerLogPorId(Integer idLog) {
        LogVO vo = logDAO.obtenerLogId(idLog);
        LogDTO logDTO = new LogDTO();
        logDTO.setIdLog(vo.getIdLog());
        logDTO.setUsuario(vo.getUsuario());
        logDTO.setAccion(vo.getAccion());
        logDTO.setUbicacion(vo.getUbicacion());
        logDTO.setEntidad(vo.getEntidad());
        logDTO.setFecha(dateFormat.format(vo.getFecha()));
        logDTO.setDetalles(new ArrayList<LogDetalleDTO>());
        LogDetalleDTO detalleDTO = new LogDetalleDTO();
        for (LogDetalleVO detalleVO : vo.getDetalles()) {
            detalleDTO = new LogDetalleDTO();
            detalleDTO.setIdLogDetalleVO(detalleVO.getIdLogDetalleVO());
            detalleDTO.setNombrePropiedad(detalleVO.getNombrePropiedad());
            detalleDTO.setTipo(detalleVO.getTipo());
            detalleDTO.setEstadoFinal(detalleVO.getEstadoFinal());
            detalleDTO.setEstadoInicial(detalleVO.getEstadoInicial());
            logDTO.getDetalles().add(detalleDTO);
        }
        return logDTO;

    }

}
