/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.administracion.administrador.impl;

import org.apache.log4j.Logger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.common.codificacion.EncriptacionUtil;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.PersonaDAO;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.UbigeoDAO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.PersonaVO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.SubTipoVO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.UbigeoVO;
import pe.com.microdata.cjava.service.administracion.administrador.GestionarAdministrador;
import pe.com.microdata.cjava.service.administracion.administrador.dto.AdministradorDTO;
import pe.com.microdata.cjava.service.mail.MailService;
import pe.com.microdata.cjava.service.mail.dto.MailParametersDTO;


@Service("gestionarAdministrador")
public class GestionarAdministradorImpl implements GestionarAdministrador {

    @Autowired
    PersonaDAO personaDAO;
    @Autowired
    MailService mailService;
    @Autowired
    UbigeoDAO ubigeoDAO;
    @Autowired
    @Qualifier("mailBean")
    MailParametersDTO mailParametersDTO;            
    
    private SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.FORMATO_FECHA);
    private static Logger logger = Logger.getLogger(GestionarAdministradorImpl.class);
    
    @Override
    public AdministradorDTO obtenerAdministradorPorId(Integer idAdmin) {
        AdministradorDTO adminDTO = new AdministradorDTO();
        PersonaVO personaVO = personaDAO.obtenerPersonaPorIdPersona(idAdmin);
        adminDTO.setIdAdmin(personaVO.getIdPersona());
        adminDTO.setNomAdmin(personaVO.getNomPersona());
        adminDTO.setPrimerApellido(personaVO.getPrimerApellidoPer());
        adminDTO.setSegundoApellido(personaVO.getSegundoApellidoPer());        
        adminDTO.setFechaNacimiento(dateFormat.format(personaVO.getFechaNacimientoPer()));
        adminDTO.setIdTipdocumento(personaVO.getIdDocumentoVO() != null ? personaVO.getIdDocumentoVO().getIdSubTipo() : 0);
        adminDTO.setDocumento(personaVO.getDocumentoPer());
        adminDTO.setTelefono(personaVO.getTelefono());
        adminDTO.setCelular(personaVO.getCelular());
        adminDTO.setCodigo(personaVO.getCodigo());                    
        adminDTO.setCorreoPersonal(personaVO.getCorreoPersonalPer());
        adminDTO.setCorreoCoorporativo(personaVO.getCorreoCoorPer());
        adminDTO.setUrbPer(personaVO.getUrbanizacionPer());
        adminDTO.setDireccion(personaVO.getDireccionPer());
        adminDTO.setReferenciaDir(personaVO.getReferenciaPer());
        adminDTO.setPais(personaVO.getUbigeoVO().getIdPais());
        adminDTO.setDepartamento(personaVO.getUbigeoVO().getIdDepartamento());
        adminDTO.setProvincia(personaVO.getUbigeoVO().getIdProvincia());
        adminDTO.setDistrito(personaVO.getUbigeoVO().getIdDistrito());
                
        return adminDTO;
    }
        
    @Override
    public SIGAMessage registrarAdministrador(AdministradorDTO adminDTO) {
        SIGAMessage msg = new SIGAMessage();
        msg.setSuccess(Boolean.FALSE);        
        PersonaVO personaVO = new PersonaVO();
        try {            
            personaVO.setNomPersona(adminDTO.getNomAdmin());
            personaVO.setPrimerApellidoPer(adminDTO.getPrimerApellido());
            personaVO.setSegundoApellidoPer(adminDTO.getSegundoApellido());
            personaVO.setFechaNacimientoPer(dateFormat.parse(adminDTO.getFechaNacimiento()));
            personaVO.setDireccionPer(adminDTO.getDireccion());
            personaVO.setReferenciaPer(adminDTO.getReferenciaDir());
            personaVO.setIdDocumentoVO(new SubTipoVO(adminDTO.getIdTipdocumento()));
            personaVO.setDocumentoPer(adminDTO.getDocumento());
            personaVO.setTelefono(adminDTO.getTelefono());
            personaVO.setCelular(adminDTO.getCelular());
            personaVO.setCorreoPersonalPer(adminDTO.getCorreoPersonal());
            personaVO.setCorreoCoorPer(adminDTO.getCorreoCoorporativo());
            personaVO.setDireccionPer(adminDTO.getDireccion());
            personaVO.setReferenciaPer(adminDTO.getReferenciaDir());
            personaVO.setTipoUserVO(new SubTipoVO(Constants.SUBTIPO_USER_ADMINISTRADOR));
            personaVO.setEstBloqueado(Constants.USUARIO_ESTADO_NO_BLOQUEADO);
            UbigeoVO ubiVO = ubigeoDAO.obtenerUbigeoPorCodigo(adminDTO.getPais(), adminDTO.getDepartamento(), adminDTO.getProvincia(), adminDTO.getDistrito());
            personaVO.setUbigeoVO(ubiVO);
            personaVO.setEstEliminado(Constants.USUARIO_ESTADO_NO_ELIMINADO);
            personaVO.setNroIntento(0);
            personaVO.setFechaRegistroPer(Calendar.getInstance());
                
            String password = EncriptacionUtil.encriptar(adminDTO.getNomUser()).substring(0, 6);
            personaVO.setUsuarioPersona(adminDTO.getNomUser());
            personaVO.setPassPersona(EncriptacionUtil.encriptar(password));

            StringBuilder builder = new StringBuilder();
            builder.append("<strong><font color=\"#0b5394\">Bienvenido(a):</font></strong><br><br>");
            builder.append("<font color=\"#0b5394\">Gracias por formar parte de CJava Perú.<br>");
            builder.append("A continuación, le brindamos los accesos a la intranet de nuestra institución:</font><br><br>");   
            builder.append("<font color=\"#0b5394\">Usuario :<b>").append(adminDTO.getNomUser()).append("</b></font><br>");
            builder.append("<font color=\"#0b5394\">Clave :<b>").append(password).append("</b></font><br>");
            builder.append("<font color=\"#0b5394\">Link de acceso :</font> <a href=\"http://www.cjavaperu.com:8080/cjava-web/login.html\">http://www.cjavaperu.com:8080/cjava-web/login.html </a><br><br>");
            builder.append("<font color=\"#0b5394\">Nota: A fin de mantener confidencialidad en su cuenta, solicitamos cambiar su clave después de acceder a ella.</font><br>");
            builder.append("<font color=\"#0b5394\">Cordialmente.</font><br>");
            builder.append("<font color=\"#0b5394\">------------------</font><br>");
            builder.append("<strong><font color=\"#0b5394\">CJava Perú.</font></strong><br>");
            builder.append("<strong><font color=\"#0b5394\">Siempre para apoyarte...</font></strong><br>");
            mailService.sendAsHtml(mailParametersDTO.getUsername(), mailParametersDTO.getUsername(), adminDTO.getCorreoPersonal(), null, "Bienvenido a CJAVA", builder.toString());
            
            Integer idPersona = personaDAO.insert(personaVO);
            PersonaVO nuevoVO = personaDAO.get(idPersona);
            Calendar c = new GregorianCalendar();
            nuevoVO.setCodigo(Integer.toString(c.get(Calendar.YEAR)) + "-" + nuevoVO.getIdPersona());
            personaDAO.saveOrUpdate(nuevoVO);
                       
            msg.setSuccess(Boolean.TRUE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return msg;
    }

    @Override
    public SIGAMessage modificarAdministrador(AdministradorDTO adminDTO) {
        SIGAMessage msg = new SIGAMessage();
        msg.setSuccess(Boolean.FALSE);
        PersonaVO personaVO = personaDAO.obtenerPersonaPorIdPersona(adminDTO.getIdAdmin());

        personaVO.setNomPersona(adminDTO.getNomAdmin());
        personaVO.setPrimerApellidoPer(adminDTO.getPrimerApellido());
        personaVO.setSegundoApellidoPer(adminDTO.getSegundoApellido());
        personaVO.setDireccionPer(adminDTO.getDireccion());
        personaVO.setReferenciaPer(adminDTO.getReferenciaDir());
        personaVO.setIdDocumentoVO(new SubTipoVO(adminDTO.getIdTipdocumento()));
        personaVO.setDocumentoPer(adminDTO.getDocumento());
        personaVO.setTelefono(adminDTO.getTelefono());
        personaVO.setCelular(adminDTO.getCelular());       
        personaVO.setCorreoPersonalPer(adminDTO.getCorreoPersonal());
        personaVO.setCorreoCoorPer(adminDTO.getCorreoCoorporativo());
        personaVO.setUrbanizacionPer(adminDTO.getUrbPer());
        personaVO.setDireccionPer(adminDTO.getDireccion());
        personaVO.setReferenciaPer(adminDTO.getReferenciaDir());
        UbigeoVO ubiVO = ubigeoDAO.obtenerUbigeoPorCodigo(adminDTO.getPais(), adminDTO.getDepartamento(), adminDTO.getProvincia(), adminDTO.getDistrito());
        personaVO.setUbigeoVO(ubiVO);

        try {
            personaVO.setFechaNacimientoPer(dateFormat.parse(adminDTO.getFechaNacimiento()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }        
        personaDAO.saveOrUpdate(personaVO);    
        msg.setSuccess(Boolean.TRUE);
        return msg;
    }

    @Override
    public SIGAMessage eliminarAdministrador(Integer idAdmin) {
        SIGAMessage m = new SIGAMessage();
        m.setSuccess(Boolean.FALSE);
        try{
            PersonaVO vo = personaDAO.get(idAdmin);
            vo.setEstEliminado(Constants.USUARIO_ESTADO_ELIMINADO);
            personaDAO.saveOrUpdate(vo);
            m.setSuccess(Boolean.TRUE);
        }catch(Exception e){
            e.printStackTrace();
        }
        return m;
    }

    @Override
    public Long obtenerTotalAdministradoresPorBusqueda(BusquedaDTO busquedaDTO) {
        return personaDAO.obtenerTotalUsurioPorBusquedaYTipo(busquedaDTO, Constants.SUBTIPO_USER_ADMINISTRADOR);
    }
    
    @Override
    public List obtenerAdministradorPorBusqueda(BusquedaDTO busquedaDTO) {
        List<AdministradorDTO> listDTO = new ArrayList<AdministradorDTO>();
        List<PersonaVO> listaVO = personaDAO.obtenerListaUsurioPorBusquedaYTipo(busquedaDTO, Constants.SUBTIPO_USER_ADMINISTRADOR);
        for(PersonaVO vo : listaVO){
            AdministradorDTO itemDTO = new AdministradorDTO();
            itemDTO.setIdAdmin(vo.getIdPersona());
            itemDTO.setNomAdmin(vo.getPrimerApellidoPer() + " " + vo.getSegundoApellidoPer() + " " + vo.getNomPersona());
            itemDTO.setNomUser(vo.getUsuarioPersona());
            itemDTO.setDocumento(vo.getDocumentoPer());
            listDTO.add(itemDTO);
        }        
        return listDTO;
    }           
        
}
