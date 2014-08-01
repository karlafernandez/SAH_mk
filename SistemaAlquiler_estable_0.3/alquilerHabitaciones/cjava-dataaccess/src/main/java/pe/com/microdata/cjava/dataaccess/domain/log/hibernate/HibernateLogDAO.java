/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.dataaccess.domain.log.hibernate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.common.base.CondicionDTO;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.common.base.ReglaDTO;
import pe.com.microdata.cjava.dataaccess.base.hibernate.HibernateGenericDAO;
import pe.com.microdata.cjava.dataaccess.domain.log.LogDAO;
import pe.com.microdata.cjava.dataaccess.model.log.LogVO;
import pe.com.microdata.cjava.dataaccess.util.GeneradorRestricciones;


public class HibernateLogDAO extends HibernateGenericDAO<LogVO, Integer>
        implements LogDAO {

    HashMap<String, ReglaDTO> eq;

    public HibernateLogDAO() {
        super(LogVO.class);
        eq = new HashMap<String, ReglaDTO>();
        eq.put("usuario", new ReglaDTO(Constants.OPE_LIKE, Constants.TYPE_STRING, "usuario"));
        eq.put("accion", new ReglaDTO(Constants.OPE_LIKE, Constants.TYPE_STRING, "accion"));
        eq.put("entidad", new ReglaDTO(Constants.OPE_LIKE, Constants.TYPE_STRING, "entidad"));
        eq.put("fechaIni", new ReglaDTO(Constants.OPE_GE, Constants.TYPE_DATE, "fecha"));
        eq.put("fechaFin", new ReglaDTO(Constants.OPE_LT, Constants.TYPE_DATE, "fecha"));
        eq.put("ubicacion", new ReglaDTO(Constants.OPE_LIKE, Constants.TYPE_STRING, "ubicacion"));

    }

    @Override
    public List obtenerLogsPorBusqueda(BusquedaDTO busquedaDTO) {
        List<LogVO> listaCursoEspe = new ArrayList<LogVO>();
        ReglaDTO reglasDTO;
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LogVO.class);
        detachedCriteria.addOrder(Order.desc("fecha"));
        if (busquedaDTO != null && busquedaDTO.getCondiciones() != null) {
            for (CondicionDTO condicionDTO : busquedaDTO.getCondiciones()) {
                reglasDTO = new ReglaDTO();
                if (eq.containsKey(condicionDTO.getField())) {
                    reglasDTO = eq.get(condicionDTO.getField());
                    reglasDTO.setData(condicionDTO.getData());
                    Criterion c = GeneradorRestricciones.generar(reglasDTO);
                    if (c != null) {
                        detachedCriteria.add(c);
                    }
                }
            }
        }
        if (busquedaDTO.getOrden() != null) {
            if (busquedaDTO.getOrden().equals(Constants.ORD_ASCENDENTE)) {
                detachedCriteria.addOrder(Order.asc(busquedaDTO.getOrdenCampo()));
            } else {
                detachedCriteria.addOrder(Order.desc(busquedaDTO.getOrdenCampo()));
            }
        }

        if (busquedaDTO.getInicio() > 0 && busquedaDTO.getCantidad() > 0) {
            listaCursoEspe = listByCriteria(detachedCriteria, ((busquedaDTO.getInicio() - 1) * busquedaDTO.getCantidad()), busquedaDTO.getCantidad());
        } else {
            listaCursoEspe = listByCriteria(detachedCriteria);
        }

        return listaCursoEspe;
    }

    @Override
    public Long obtenerTotalLogsPorBusqueda(BusquedaDTO busquedaDTO) {
        ReglaDTO reglasDTO;
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LogVO.class);
        detachedCriteria.setProjection(Projections.rowCount());
        if (busquedaDTO != null && busquedaDTO.getCondiciones() != null) {
            for (CondicionDTO condicionDTO : busquedaDTO.getCondiciones()) {
                if (eq.containsKey(condicionDTO.getField())) {
                    reglasDTO = eq.get(condicionDTO.getField());
                    reglasDTO.setData(condicionDTO.getData());
                    Criterion c = GeneradorRestricciones.generar(reglasDTO);
                    if (c != null) {
                        detachedCriteria.add(c);
                    }
                }
            }
        }
        Long total = ((Long) getHibernateTemplate().findByCriteria(detachedCriteria).get(0)).longValue();
        return total;
    }

    @Override
    public LogVO obtenerLogId(Integer idLog) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LogVO.class);
        detachedCriteria.createAlias("detalles", "detalles", DetachedCriteria.LEFT_JOIN);
        detachedCriteria.add(Restrictions.eq("idLog", idLog));
        List<LogVO> logVOs = listByCriteria(detachedCriteria);
        LogVO logVO = null;
        if (!logVOs.isEmpty()) {
            logVO = logVOs.get(0);

        }
        return logVO;

    }

}
