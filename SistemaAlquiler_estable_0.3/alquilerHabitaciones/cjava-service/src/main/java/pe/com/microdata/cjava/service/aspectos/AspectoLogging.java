/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.aspectos;

import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import pe.com.microdata.cjava.common.base.Constants;
import static pe.com.microdata.cjava.common.codificacion.EncriptacionUtil.logger;
import pe.com.microdata.cjava.dataaccess.base.BaseVO;
import pe.com.microdata.cjava.dataaccess.domain.log.LogDAO;
import pe.com.microdata.cjava.dataaccess.model.log.LogVO;

@Aspect
public class AspectoLogging {

    @Autowired
    LogDAO logDAO;

    public final static String UBICACION = "intranet";

    @Before("execution(*  pe.com.microdata.cjava.dataaccess.base.hibernate.HibernateGenericDAO.saveOrUpdate(..))")
    public void logSave(JoinPoint joinPoint) {
        logger.info(" >ASPECTO - saveOrUpdate");
        Object paramsObj[] = {};
        for (Object object : joinPoint.getArgs()) {
            try {
                if ((object instanceof BaseVO) && !(object instanceof LogVO)) {
                    ((BaseVO) object).setUsuario(getUsuario());
                    ((BaseVO) object).setAccion(Constants.ACCION_SAVE);
                    ((BaseVO) object).setUbicacion(UBICACION);
                }
            } catch (IllegalArgumentException ex) {
                logger.error("Error  ASPECTO saveOrUpdate" + AspectoLogging.class.getName());
            } catch (SecurityException ex) {
                logger.error("Error  ASPECTO saveOrUpdate" + AspectoLogging.class.getName());
            } catch (Exception ex) {
                logger.error("Error GENERAL ASPECTO despues de saveOrUpdate");
            }
        }
    }

    @Before("execution(*  pe.com.microdata.cjava.dataaccess.base.hibernate.HibernateGenericDAO.insert(..))")
    public void logInsert(JoinPoint joinPoint) {
        logger.info(" >ASPECTO - insert");
        Object paramsObj[] = {};
        for (Object object : joinPoint.getArgs()) {
            try {
                if ((object instanceof BaseVO) && !(object instanceof LogVO)) {
                    ((BaseVO) object).setUsuario(getUsuario());
                    ((BaseVO) object).setAccion(Constants.ACCION_INSERT);
                    ((BaseVO) object).setUbicacion(UBICACION);
                }
            } catch (IllegalArgumentException ex) {
                logger.error("Error  ASPECTO insert" + AspectoLogging.class.getName());
            } catch (SecurityException ex) {
                logger.error("Error  ASPECTO insert" + AspectoLogging.class.getName());
            } catch (Exception ex) {
                logger.error("Error GENERAL ASPECTO insert");
            }
        }
    }

    @Before("execution(*  pe.com.microdata.cjava.dataaccess.base.hibernate.HibernateGenericDAO.merge(..))")
    public void logMerge(JoinPoint joinPoint) {
        logger.info(" >ASPECTO - merge");
        Object paramsObj[] = {};
        for (Object object : joinPoint.getArgs()) {
            try {
                if ((object instanceof BaseVO) && !(object instanceof LogVO)) {
                    ((BaseVO) object).setUsuario(getUsuario());
                    ((BaseVO) object).setAccion(Constants.ACCION_UPDATE);
                    ((BaseVO) object).setUbicacion(UBICACION);
                }
            } catch (IllegalArgumentException ex) {
                logger.error("Error  ASPECTO merge" + AspectoLogging.class.getName());
            } catch (SecurityException ex) {
                logger.error("Error  ASPECTO merge" + AspectoLogging.class.getName());
            } catch (Exception ex) {
                logger.error("Error GENERAL ASPECTO merge");
            }
        }
    }

    @Before("execution(*  pe.com.microdata.cjava.dataaccess.base.hibernate.HibernateGenericDAO.update(..))")
    public void logUpdate(JoinPoint joinPoint) {
        logger.info(" >ASPECTO - update");
        Object paramsObj[] = {};
        for (Object object : joinPoint.getArgs()) {
            try {
                if ((object instanceof BaseVO) && !(object instanceof LogVO)) {
                    ((BaseVO) object).setUsuario(getUsuario());
                    ((BaseVO) object).setAccion(Constants.ACCION_UPDATE);
                    ((BaseVO) object).setUbicacion(UBICACION);
                }
            } catch (IllegalArgumentException ex) {
                logger.error("Error  ASPECTO update" + AspectoLogging.class.getName());
            } catch (SecurityException ex) {
                logger.error("Error  ASPECTO update" + AspectoLogging.class.getName());
            } catch (Exception ex) {
                logger.error("Error GENERAL ASPECTO update");
            }
        }
    }

    @Before("execution(*  pe.com.microdata.cjava.dataaccess.base.hibernate.HibernateGenericDAO.update(..))")
    public void logDelete(JoinPoint joinPoint) {
        logger.info(" >ASPECTO - delete");
        Object paramsObj[] = {};
        for (Object object : joinPoint.getArgs()) {
            try {
                if ((object instanceof BaseVO) && !(object instanceof LogVO)) {
                    ((BaseVO) object).setUsuario(getUsuario());
                    ((BaseVO) object).setAccion(Constants.ACCION_DELETE);
                    ((BaseVO) object).setUbicacion(UBICACION);
                }
            } catch (IllegalArgumentException ex) {
                logger.error("Error  ASPECTO delete" + AspectoLogging.class.getName());
            } catch (SecurityException ex) {
                logger.error("Error  ASPECTO delete" + AspectoLogging.class.getName());
            } catch (Exception ex) {
                logger.error("Error GENERAL ASPECTO delete");
            }
        }
    }

    @AfterReturning("execution(* pe.com.microdata.cjava.service.base.autenticacion.WebAuthenticationProvider.authenticate(..))")
    public void logAccesoSistema(JoinPoint joinPoint) {
        logger.info(" >ASPECTO - LOGIN");
        Object paramsObj[] = {};
        for (Object object : joinPoint.getArgs()) {
            try {
                if (object instanceof Authentication) {
                    String clase = object.getClass().getName();
                    Authentication authentication = (Authentication) object;
                    String usuario = authentication.getName();
                    LogVO logVO = new LogVO();
                    logVO.setUsuario(usuario);
                    logVO.setAccion(Constants.ACCION_LOGIN_SUCCESS);
                    logVO.setUbicacion(UBICACION);
                    logVO.setEntidad("");
                    logVO.setFecha(new Date());
                    logDAO.saveOrUpdate(logVO);
                }
            } catch (IllegalArgumentException ex) {
                logger.error("Error  ASPECTO despues de iniciar sesion" + AspectoLogging.class.getName());
            } catch (SecurityException ex) {
                logger.error("Error  ASPECTO despues de iniciar sesion" + AspectoLogging.class.getName());
            } catch (Exception ex) {
                logger.error("Error GENERAL ASPECTO despues de iniciar sesion");
            }
        }
        logger.info(" > ASPECTO  fin");

    }

    @AfterThrowing("execution(* pe.com.microdata.cjava.service.base.autenticacion.WebAuthenticationProvider.authenticate(..))")
    public void logErrorAccesoSistema(JoinPoint joinPoint) {
        logger.info(" >ASPECTO - LOGIN -ERROR");
        Object paramsObj[] = {};
        for (Object object : joinPoint.getArgs()) {
            try {
                if (object instanceof Authentication) {
                    String clase = object.getClass().getName();
                    Authentication authentication = (Authentication) object;
                    String usuario = authentication.getName();
                    LogVO logVO = new LogVO();
                    logVO.setUsuario(usuario);
                    logVO.setAccion(Constants.ACCION_LOGIN_ERROR);
                    logVO.setUbicacion(UBICACION);
                    logVO.setEntidad("");
                    logVO.setFecha(new Date());
                    logDAO.saveOrUpdate(logVO);
                }
            } catch (IllegalArgumentException ex) {
                logger.error("Error  ASPECTO despues de iniciar sesion" + AspectoLogging.class.getName());
            } catch (SecurityException ex) {
                logger.error("Error  ASPECTO despues de iniciar sesion" + AspectoLogging.class.getName());
            } catch (Exception ex) {
                logger.error("Error GENERAL ASPECTO despues de iniciar sesion");
            }
        }
        logger.info(" > ASPECTO  fin");

    }

    private String getUsuario() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String usuario = authentication.getName();
        if (!usuario.equals("anonymousUser")) {
            usuario = authentication.getName();
            return usuario;
        } else {
            return null;
        }
    }
}
