/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.registro.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.common.codificacion.EncriptacionUtil;
import pe.com.microdata.cjava.dataaccess.domain.acceso.AccesoTemplateDAO;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.ArrendatarioDAO;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.PersonaDAO;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.UbigeoDAO;
import pe.com.microdata.cjava.dataaccess.model.acceso.AccesoTemplateVO;
import pe.com.microdata.cjava.dataaccess.model.acceso.AccesoVO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.ArrendatarioVO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.PersonaVO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.SubTipoVO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.UbigeoVO;
import pe.com.microdata.cjava.service.mail.MailService;
import pe.com.microdata.cjava.service.mail.dto.MailParametersDTO;
import pe.com.microdata.cjava.service.registro.GestionarInstructor;
import pe.com.microdata.cjava.service.registro.dto.ArrendatarioDTO;

/**
 *
 * @author meliMeli
 */
@Service("gestionarInstructor")
public class GestionarInstructorImpl implements GestionarInstructor {

    @Autowired
    ArrendatarioDAO instructorDAO;
    @Autowired
    PersonaDAO personaDAO;
    @Autowired
    UbigeoDAO ubigeoDAO;
    @Autowired
    MailService mailService;
    @Autowired
    @Qualifier("mailBean")
    MailParametersDTO mailParametersDTO;

    @Autowired
    AccesoTemplateDAO accesoTemplateDAO;

    SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.FORMATO_FECHA);

    private static final Logger logger = Logger.getLogger(GestionarInstructorImpl.class.getName());
    
    @Override
    public SIGAMessage registrarInstructor(ArrendatarioDTO instructorDTO) {

        SIGAMessage msg = new SIGAMessage();
        msg.setSuccess(Boolean.FALSE);
        PersonaVO personaVO = new PersonaVO();

        try {

            //////////////////////////////PERSONAVO//////////////////////////////
            personaVO.setNomPersona(instructorDTO.getNombre());
            personaVO.setPrimerApellidoPer(instructorDTO.getPrimerApellido());
            personaVO.setSegundoApellidoPer(instructorDTO.getSegundoApellido());
            personaVO.setFechaNacimientoPer(dateFormat.parse(instructorDTO.getFechaNacimiento()));
            personaVO.setDireccionPer(instructorDTO.getDireccion());
            personaVO.setReferenciaPer(instructorDTO.getReferenciaDir());
            personaVO.setIdDocumentoVO(new SubTipoVO(instructorDTO.getIdTipdocumento()));
            personaVO.setDocumentoPer(instructorDTO.getDocumento());
            personaVO.setTelefono(instructorDTO.getTelefono());
            personaVO.setCelular(instructorDTO.getCelular());
                        
            personaVO.setCorreoPersonalPer(instructorDTO.getCorreoPersonal());
            personaVO.setCorreoCoorPer(instructorDTO.getCorreoCoorporativo());
            personaVO.setUrbanizacionPer(instructorDTO.getUrbPer());
            personaVO.setDireccionPer(instructorDTO.getDireccion());
            personaVO.setReferenciaPer(instructorDTO.getReferenciaDir());
            personaVO.setUbigeoVO(new UbigeoVO(instructorDTO.getPais(), instructorDTO.getDepartamento(), instructorDTO.getProvincia(), instructorDTO.getDistrito(), instructorDTO.getNombreUbigeo()));
            personaVO.setTipoUserVO(new SubTipoVO(Constants.SUBTIPO_USER_INSTRUCTOR));
            personaVO.setEstBloqueado(Constants.USUARIO_ESTADO_NO_BLOQUEADO);
            UbigeoVO ubiVO = ubigeoDAO.obtenerUbigeoPorCodigo(instructorDTO.getPais(), instructorDTO.getDepartamento(), instructorDTO.getProvincia(), instructorDTO.getDistrito());
            personaVO.setUbigeoVO(ubiVO);
            personaVO.setEstEliminado(Constants.USUARIO_ESTADO_NO_ELIMINADO);
            personaVO.setNroIntento(0);
            personaVO.setFechaRegistroPer(Calendar.getInstance());
                
            //////////////////AUTOGENERAR  PASSWORD/////////////
            String password = EncriptacionUtil.encriptar(instructorDTO.getUsuario()).substring(0, 6);
            personaVO.setUsuarioPersona(instructorDTO.getUsuario());
            personaVO.setPassPersona(EncriptacionUtil.encriptar(password));

            ////////////////////////////INGRESANDO ACCESOS/////////////////////////
            AccesoTemplateVO accesoTemplateVO = accesoTemplateDAO.obtenerAccesosPorTemplate("PREDETERMINADO_INSTRUCTOR");
            if (accesoTemplateVO != null && !accesoTemplateVO.getAccesoVOs().isEmpty()) {
                Set<AccesoVO> accesoVOs = new HashSet<AccesoVO>();
                for (AccesoVO accesoVO : accesoTemplateVO.getAccesoVOs()) {
                    accesoVOs.add(new AccesoVO(accesoVO.getIdAcceso()));
                }
                personaVO.setAccesoVOs(accesoVOs);
            } 
            //////////////////////////////INSTRUCTOR VO/////////////////////////////
            ArrendatarioVO instructorVO = new ArrendatarioVO(); 
            instructorVO.setInstructorPersonaVO(personaVO);
            Integer idInstructor = instructorDAO.insert(instructorVO);
            if (idInstructor != 0) {
                obtenerCodigoInstructor(idInstructor);
            }
            //////////////////CORREO/////////////
             StringBuilder builder = new StringBuilder();
            builder.append("<strong><font color=\"#0b5394\">Bienvenido(a):</font></strong><br><br>");
            builder.append("<font color=\"#0b5394\">Gracias por formar parte de CJava Perú.<br>");
            builder.append("A continuación, le brindamos los accesos a la intranet de nuestra institución:</font><br><br>");    
            builder.append("<font color=\"#0b5394\">Usuario :<b>").append(instructorDTO.getUsuario()).append("</b></font><br>");
            builder.append("<font color=\"#0b5394\">Clave :<b>").append(password).append("</b></font><br>");
            builder.append("<font color=\"#0b5394\">Link de acceso :</font> <a href=\"http://www.cjavaperu.com:8080/cjava-web/login.html\">http://www.cjavaperu.com:8080/cjava-web/login.html </a><br><br>");
            builder.append("<font color=\"#0b5394\">Nota: A fin de mantener confidencialidad en su cuenta, solicitamos cambiar su clave después de acceder a ella.</font><br>");
            builder.append("<font color=\"#0b5394\">Cordialmente.</font><br>");
            builder.append("<font color=\"#0b5394\">------------------</font><br>");
            builder.append("<strong><font color=\"#0b5394\">CJava Perú.</font></strong><br>");
            builder.append("<strong><font color=\"#0b5394\">Siempre para apoyarte...</font></strong><br>");            
             mailService.sendAsHtml(mailParametersDTO.getUsername(), mailParametersDTO.getUsername(), instructorDTO.getCorreoPersonal(), null, "Bienvenido a CJAVA", builder.toString());

            msg.setSuccess(Boolean.TRUE);
        } catch (Exception ex) {
            ex.printStackTrace();
            msg.setSuccess(Boolean.FALSE);
        }
        return msg;

    }

    private void obtenerCodigoInstructor(Integer idInstructor) {
        Calendar c = new GregorianCalendar();
        String annio = Integer.toString(c.get(Calendar.YEAR));
        PersonaVO personaVO = new PersonaVO();
        ArrendatarioVO instructorVO = instructorDAO.obtenerInstructorPorIdInstructor(idInstructor);
        personaVO = instructorVO.getInstructorPersonaVO();

        personaVO.setCodigo(annio + "-" + idInstructor.toString());
        personaDAO.saveOrUpdate(personaVO);

    }

    @Override
    public ArrendatarioDTO obtenerInstructorPorId(Integer idInstructor) {

        ArrendatarioDTO instructorDTO = new ArrendatarioDTO();
        ArrendatarioVO instructorVO = instructorDAO.obtenerInstructorPorIdInstructor(idInstructor);
        //  List<PersonaVO> personaVOs = personaDAO.obtenerPersonasPorBusqueda(busquedaDTO);
        PersonaVO personaVO;
        //////////////////////////////INSTRUCTOR VO/////////////////////////////
        instructorDTO.setIdInstructor(instructorVO.getIdInstructor());

        /////////////////////////PERSONA /////////////////////////
        personaVO = instructorVO.getInstructorPersonaVO();
        instructorDTO.setIdPersona(personaVO.getIdPersona());
        instructorDTO.setNombre(personaVO.getNomPersona());
        instructorDTO.setPrimerApellido(personaVO.getPrimerApellidoPer());
        instructorDTO.setSegundoApellido(personaVO.getSegundoApellidoPer());
        instructorDTO.setNombreCompleto(personaVO.getNomPersona() + ", " + personaVO.getPrimerApellidoPer() + " " + personaVO.getSegundoApellidoPer());
        instructorDTO.setFechaNacimiento(dateFormat.format(personaVO.getFechaNacimientoPer()));
        instructorDTO.setIdTipdocumento(personaVO.getIdDocumentoVO() != null ? personaVO.getIdDocumentoVO().getIdSubTipo() : 0);
        instructorDTO.setDocumento(personaVO.getDocumentoPer());
        instructorDTO.setTelefono(personaVO.getTelefono());
        instructorDTO.setCelular(personaVO.getCelular());
        instructorDTO.setCodigo(personaVO.getCodigo());

        instructorDTO.setCorreoPersonal(personaVO.getCorreoPersonalPer());
        instructorDTO.setCorreoCoorporativo(personaVO.getCorreoCoorPer());

        instructorDTO.setUrbPer(personaVO.getUrbanizacionPer());
        instructorDTO.setDireccion(personaVO.getDireccionPer());
        instructorDTO.setReferenciaDir(personaVO.getReferenciaPer());

        instructorDTO.setPais(personaVO.getUbigeoVO().getIdPais());
        instructorDTO.setDepartamento(personaVO.getUbigeoVO().getIdDepartamento());
        instructorDTO.setProvincia(personaVO.getUbigeoVO().getIdProvincia());
        instructorDTO.setDistrito(personaVO.getUbigeoVO().getIdDistrito());
//        instructorDTO.setNombreUbigeo(personaVO.getUbigeoVO().getNombreUbigeo());
        return instructorDTO;
    }

    @Override
    public SIGAMessage modificarInstructor(ArrendatarioDTO instructorDTO) {

        SIGAMessage msg = new SIGAMessage();
        msg.setSuccess(Boolean.FALSE);
//        PersonaVO personaVO = new PersonaVO();
        PersonaVO personaVO = personaDAO.obtenerPersonaPorIdPersona(instructorDTO.getIdPersona());
        ArrendatarioVO instructorVO = instructorDAO.obtenerInstructorPorIdInstructor(instructorDTO.getIdInstructor());

        Calendar c = new GregorianCalendar();
        String annio = Integer.toString(c.get(Calendar.YEAR));

        //////////////////////////////PERSONAVO//////////////////////////////
        personaVO.setNomPersona(instructorDTO.getNombre());
        personaVO.setPrimerApellidoPer(instructorDTO.getPrimerApellido());
        personaVO.setSegundoApellidoPer(instructorDTO.getSegundoApellido());
        personaVO.setDireccionPer(instructorDTO.getDireccion());
        personaVO.setReferenciaPer(instructorDTO.getReferenciaDir());
        personaVO.setIdDocumentoVO(new SubTipoVO(instructorDTO.getIdTipdocumento()));
        personaVO.setDocumentoPer(instructorDTO.getDocumento());
        personaVO.setTelefono(instructorDTO.getTelefono());
        personaVO.setCelular(instructorDTO.getCelular());
        personaVO.setCodigo(annio + "-" + instructorDTO.getIdInstructor().toString());
        personaVO.setCorreoPersonalPer(instructorDTO.getCorreoPersonal());
        personaVO.setCorreoCoorPer(instructorDTO.getCorreoCoorporativo());
        personaVO.setUrbanizacionPer(instructorDTO.getUrbPer());
        personaVO.setDireccionPer(instructorDTO.getDireccion());
        personaVO.setReferenciaPer(instructorDTO.getReferenciaDir());
        UbigeoVO ubiVO = ubigeoDAO.obtenerUbigeoPorCodigo(instructorDTO.getPais(), instructorDTO.getDepartamento(), instructorDTO.getProvincia(), instructorDTO.getDistrito());
        personaVO.setUbigeoVO(ubiVO);

        //////////////////AUTOGENERAR USUARIO PASSWORD/////////////
        //personaVO.setUsuarioPersona(alumnoDTO.getUsuario());
        //personaVO.setPassPersona(alumnoDTO.getPass());
        try {
            personaVO.setFechaNacimientoPer(dateFormat.parse(instructorDTO.getFechaNacimiento()));
        } catch (ParseException ex) {
            Logger.getLogger(GestionarInstructorImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        personaVO.setTipoUserVO(new SubTipoVO(Constants.SUBTIPO_USER_INSTRUCTOR));
        personaDAO.saveOrUpdate(personaVO);

        //////////////////////////////INSTRUCTOR VO/////////////////////////////
        instructorVO.setIdInstructor(instructorDTO.getIdInstructor());

        instructorVO.setInstructorPersonaVO(personaVO);
        instructorDAO.saveOrUpdate(instructorVO);
        msg.setSuccess(Boolean.TRUE);
        return msg;

    }

    @Override
    public void eliminarInstructor(Integer instructor) {

        ArrendatarioVO instructorVO = instructorDAO.obtenerInstructorPorIdInstructor(instructor);
        instructorDAO.delete(instructorVO);
//        PersonaVO personaVO = personaDAO.get(instructorVO.getInstructorPersonaVO().getIdPersona());
//        personaDAO.delete(personaVO);
    }

    @Override
    public List obtenerInstructorPorBusqueda(BusquedaDTO busquedaDTO) {
        List<ArrendatarioDTO> instructorDTOs = new ArrayList<ArrendatarioDTO>();
        List<ArrendatarioVO> instructorVOs = instructorDAO.obtenerInstructorPorBusqueda(busquedaDTO);

        PersonaVO personaVO;

        for (ArrendatarioVO instructorVO : instructorVOs) {
            ArrendatarioDTO instructorDTO = new ArrendatarioDTO();
            //////////////////////////////ALUMNO VO//////////////////////
            instructorDTO.setIdInstructor(instructorVO.getIdInstructor());

            /////////////////////////PERSONA /////////////////////////
            personaVO = instructorVO.getInstructorPersonaVO();
            instructorDTO.setIdPersona(personaVO.getIdPersona());
            instructorDTO.setNombre(personaVO.getNomPersona());
            instructorDTO.setPrimerApellido(personaVO.getPrimerApellidoPer());
            instructorDTO.setSegundoApellido(personaVO.getSegundoApellidoPer());
            instructorDTO.setNombreCompleto(personaVO.getNomPersona() + ", " + personaVO.getPrimerApellidoPer() + " " + personaVO.getSegundoApellidoPer());
            instructorDTO.setFechaNacimiento(personaVO.getFechaNacimientoPer() != null ? dateFormat.format(personaVO.getFechaNacimientoPer()) : "");
            instructorDTO.setIdTipdocumento(personaVO.getIdDocumentoVO() != null ? personaVO.getIdDocumentoVO().getIdSubTipo() : 0);
            instructorDTO.setDocumento(personaVO.getDocumentoPer());
            instructorDTO.setTelefono(personaVO.getTelefono());
            instructorDTO.setCelular(personaVO.getCelular());
            instructorDTO.setCodigo(personaVO.getCodigo());
            instructorDTO.setCorreoPersonal(personaVO.getCorreoPersonalPer());
            instructorDTO.setCorreoCoorporativo(personaVO.getCorreoCoorPer());
            instructorDTO.setUrbPer(personaVO.getUrbanizacionPer());
            instructorDTO.setDireccion(personaVO.getDireccionPer());
            instructorDTO.setReferenciaDir(personaVO.getReferenciaPer());
            instructorDTO.setPais(personaVO.getUbigeoVO().getIdPais());
            instructorDTO.setDepartamento(personaVO.getUbigeoVO().getIdDepartamento());
            instructorDTO.setProvincia(personaVO.getUbigeoVO().getIdProvincia());
            instructorDTO.setDistrito(personaVO.getUbigeoVO().getIdDistrito());
            instructorDTO.setNombreUbigeo(personaVO.getUbigeoVO().getNombreUbigeo());

            instructorDTOs.add(instructorDTO);
        }
        return instructorDTOs;
    }

    @Override
    public Long obtenerTotalInstructoresPorBusqueda(BusquedaDTO busquedaDTO) {
        Long total = instructorDAO.obtenerTotalInstructoresPorBusqueda(busquedaDTO);

        return total;
    }
}
