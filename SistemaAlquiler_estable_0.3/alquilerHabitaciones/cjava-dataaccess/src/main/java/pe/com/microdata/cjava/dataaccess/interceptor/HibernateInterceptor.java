/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.dataaccess.interceptor;

import pe.com.microdata.cjava.dataaccess.model.log.LogVO;
import pe.com.microdata.cjava.dataaccess.model.log.LogDetalleVO;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.Date;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import pe.com.microdata.cjava.dataaccess.base.BaseVO;
import pe.com.microdata.cjava.dataaccess.domain.log.LogDAO;


public class HibernateInterceptor extends EmptyInterceptor {

    @Autowired
    LogDAO logDAO;
    private int updates;
    private int creates;
    private int loads;

    private static final int MAX_LENGTH = 1000;

    @Override
    public void onDelete(Object entity,
            Serializable id,
            Object[] state,
            String[] propertyNames,
            Type[] types) {
        if (entity instanceof BaseVO) {
            BaseVO baseVO = (BaseVO) entity;
            if (baseVO.getAccion() != null) {

                LogVO logVO = new LogVO();
                try {
                    logVO.setFecha(new Date());
                    logVO.setEntidad(entity.getClass().getSimpleName().replace("pe.com.microdata.cjava.", "..."));
                    logVO.setAccion(baseVO.getAccion());
                    logVO.setUsuario(baseVO.getUsuario());
                    logVO.setUbicacion(baseVO.getUbicacion());
                    logVO.setDetalles(new ArrayList<LogDetalleVO>());
                    String estado = "";
                    String type = "";
                    for (int i = 0; i < propertyNames.length; i++) {
                        type = types[i].getName().replace("pe.com.microdata.cjava.", "...");
                        if (type.contains("java.util.Set") || type.contains("java.util.List")|| type.contains("java.util.Collection")) {
                            if (state != null) {
                                estado = "...lista...";
                            }
                        } else {
                            if (state != null) {
                                estado = state[i] != null ? state[i].toString().replace("pe.com.microdata.cjava.", "...") : "";
                                if (estado.length() > MAX_LENGTH) {
                                    estado = estado.substring(0, MAX_LENGTH - 1);
                                }
                            }
                        }
                        LogDetalleVO detalleVO = new LogDetalleVO(propertyNames[i], type, estado, null);
                        detalleVO.setLogVO(logVO);
                        logVO.getDetalles().add(detalleVO);

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    logVO.getTexto();
                }
            }

        }

    }

    @Override
    public boolean onFlushDirty(Object entity,
            Serializable id,
            Object[] currentState,
            Object[] previousState,
            String[] propertyNames,
            Type[] types) {

        if (entity instanceof BaseVO) {
            BaseVO baseVO = (BaseVO) entity;
            if (baseVO.getAccion() != null) {
                LogVO logVO = new LogVO();
                try {

                    logVO.setFecha(new Date());
                    logVO.setEntidad(entity.getClass().getSimpleName().replace("pe.com.microdata.cjava.", "..."));
                    logVO.setAccion(baseVO.getAccion());
                    logVO.setUsuario(baseVO.getUsuario());
                    logVO.setUbicacion(baseVO.getUbicacion());
                    logVO.setDetalles(new ArrayList<LogDetalleVO>());
                    String previous = "";
                    String current = "";
                    String type = "";

                    for (int i = 0; i < propertyNames.length; i++) {
                        type = types[i].getName().replace("pe.com.microdata.cjava.", "...");
                        if (type.contains("java.util.Set") || type.contains("java.util.List")|| type.contains("java.util.Collection")) {
                            if (previousState != null) {
                                previous = "...lista...";
                            }
                            if (currentState != null) {
                                current = "...lista...";
                            }
                        } else {
                            if (previousState != null) {

                                previous = previousState[i] != null ? previousState[i].toString().replace("pe.com.microdata.cjava.", "...") : "";
                                if (previous.length() > MAX_LENGTH) {
                                    previous = previous.substring(0, MAX_LENGTH - 1);
                                }
                            }
                            if (currentState != null) {

                                current = currentState[i] != null ? currentState[i].toString().replace("pe.com.microdata.cjava.", "...") : "";
                                if (current.length() > MAX_LENGTH) {
                                    current = previous.substring(0, MAX_LENGTH - 1);
                                }
                            }
                        }

                        LogDetalleVO detalleVO = new LogDetalleVO(propertyNames[i], type, current, previous);
                        detalleVO.setLogVO(logVO);
                        logVO.getDetalles().add(detalleVO);
                    }
                    updates++;
                    logDAO.saveOrUpdate(logVO);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    logVO.getTexto();
                }
            }
        }
        return false;
    }

    @Override
    public boolean onLoad(Object entity,
            Serializable id,
            Object[] state,
            String[] propertyNames,
            Type[] types) {
        if (entity instanceof BaseVO) {
            loads++;
        }
        return false;
    }

    @Override
    public boolean onSave(Object entity,
            Serializable id,
            Object[] state,
            String[] propertyNames,
            Type[] types) {

        if (entity instanceof BaseVO) {
            BaseVO baseVO = (BaseVO) entity;
            if (baseVO.getAccion() != null) {
                LogVO logVO = new LogVO();
                try {

                    logVO.setFecha(new Date());
                    logVO.setEntidad(entity.getClass().getSimpleName().replace("pe.com.microdata.cjava.", "..."));
                    logVO.setAccion(baseVO.getAccion());
                    logVO.setUsuario(baseVO.getUsuario());
                    logVO.setUbicacion(baseVO.getUbicacion());
                    logVO.setDetalles(new ArrayList<LogDetalleVO>());
                    String estado = "";
                    String type = "";
                    for (int i = 0; i < propertyNames.length; i++) {
                        type = types[i].getName().replace("pe.com.microdata.cjava.", "...");
                        if (type.contains("java.util.Set") || type.contains("java.util.List")|| type.contains("java.util.Collection")) {
                            if (state != null) {
                                estado = "...lista...";
                            }
                        } else {
                            if (state != null) {
                                estado = state[i] != null ? state[i].toString().replace("pe.com.microdata.cjava.", "...") : "";
                                if (estado.length() > MAX_LENGTH) {
                                    estado = estado.substring(0, MAX_LENGTH - 1);
                                }
                            }
                        }
                        LogDetalleVO detalleVO = new LogDetalleVO(propertyNames[i], type, estado, null);
                        detalleVO.setLogVO(logVO);
                        logVO.getDetalles().add(detalleVO);
                    }

                    creates++;
                    logDAO.saveOrUpdate(logVO);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    logVO.getTexto();

                }
            }
        }

        return false;
    }

    @Override
    public void afterTransactionCompletion(Transaction tx) {
        if (tx.wasCommitted()) {
            System.out.println("Creations: " + creates + ", Updates: " + updates + "Loads: " + loads);

        }
        updates = 0;
        creates = 0;
        loads = 0;
    }
}
