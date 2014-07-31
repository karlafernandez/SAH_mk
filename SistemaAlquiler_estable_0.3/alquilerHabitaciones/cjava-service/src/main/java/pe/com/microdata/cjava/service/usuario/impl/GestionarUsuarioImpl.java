/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.usuario.impl;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.common.codificacion.EncriptacionUtil;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.ArrendatarioDAO;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.PersonaDAO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.ArrendatarioVO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.PersonaVO;
import pe.com.microdata.cjava.service.mail.MailService;
import pe.com.microdata.cjava.service.usuario.GestionarUsuario;
import pe.com.microdata.cjava.service.usuario.dto.CambiarClaveUsuarioDTO;
import pe.com.microdata.cjava.service.usuario.dto.RestaurarClaveDTO;

/**
 *
 * @author César Bragagnini
 */
@Service("GestionarUsuario")
public class GestionarUsuarioImpl implements GestionarUsuario{

    @Autowired
    PersonaDAO personaDAO;
    @Autowired
    ArrendatarioDAO instructorDAO;
    @Autowired
    MailService mailService;    
    
    @Override
    public SIGAMessage cambiarClaveUsuario(CambiarClaveUsuarioDTO dto) {
        SIGAMessage m = new SIGAMessage();
        m.setSuccess(Boolean.FALSE);
        try {
            Integer id = dto.getIdPersona();
            if(dto.getTipoUser() != Constants.SUBTIPO_USER_ADMINISTRADOR){
                ArrendatarioVO instructorVO = instructorDAO.obtenerInstructorPorIdInstructor(id);
                id = instructorVO.getInstructorPersonaVO().getIdPersona();
            }
            PersonaVO vo = personaDAO.obtenerPersonaPorIdPersona(id);                  
            vo.setPassPersona(EncriptacionUtil.encriptar(dto.getClvNueva()));
            personaDAO.saveOrUpdate(vo);
            m.setSuccess(Boolean.TRUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }

    @Override
    public SIGAMessage restaurarContraseina(RestaurarClaveDTO dto) {
        SIGAMessage message = new SIGAMessage();
        message.setSuccess(Boolean.FALSE);
        PersonaVO usuarioVO = this.personaDAO.obtenerUsuarioPorNombreUsuario(dto.getNomUsuario());
        try {
            if (usuarioVO != null && dto.getCorreo().equals(usuarioVO.getCorreoPersonalPer()) && usuarioVO.getTipoUserVO().getIdSubTipo() != Constants.SUBTIPO_USER_ALUMNO) {
                Random r = new Random();
                String nuevaPass = EncriptacionUtil.encriptar(r.toString()).substring(1, 6);
                usuarioVO.setPassPersona(EncriptacionUtil.encriptar(nuevaPass));
                personaDAO.saveOrUpdate(usuarioVO);
               
                StringBuilder builder = new StringBuilder();

                builder.append("<strong><font color=\"#0b5394\">Bienvenido(a):</font></strong><br><br>");
                builder.append("<font color=\"#0b5394\">Gracias por formar parte de CJava Perú.<br>");
                builder.append("A continuación, le brindamos los accesos a la intranet de nuestra institución:</font><br><br>"); 
                builder.append("<font color=\"#0b5394\">Usuario :<b>").append(usuarioVO.getUsuarioPersona()).append("</b></font><br>");
                builder.append("<font color=\"#0b5394\">Clave :<b>").append(nuevaPass).append("</b></font><br>");
                builder.append("<font color=\"#0b5394\">Link de acceso :</font> <a href=\"http://www.cjavaperu.com:8080/cjava-web/login.html\">http://www.cjavaperu.com:8080/cjava-web/login.html </a><br><br>");                
                builder.append("<font color=\"#0b5394\">Nota: A fin de mantener confidencialidad en su cuenta, solicitamos cambiar su clave después de acceder a ella.</font><br>");
                builder.append("<font color=\"#0b5394\">Cordialmente.</font><br>");
                builder.append("<font color=\"#0b5394\">------------------</font><br>");
                builder.append("<strong><font color=\"#0b5394\">CJava Perú.</font></strong><br>");
                builder.append("<strong><font color=\"#0b5394\">Siempre para apoyarte...</font></strong><br>");  
                mailService.sendAsHtml("siga_cjava@cjavaperu.com", usuarioVO.getCorreoPersonalPer(), null, null, "Cambio de contraseña", builder.toString());
                
                message.setMessageType(SIGAMessage.MessageType.SUCCESS);
                message.addMessages("Contraseña enviada");
                message.setSuccess(Boolean.TRUE);
            } else {
                message.setMessageType(SIGAMessage.MessageType.ERROR);
                message.addMessages("User y/o correo invalido");
                message.setSuccess(Boolean.FALSE);
            }
        } catch (Exception e) {
            message.setMessageType(SIGAMessage.MessageType.ERROR);
            e.printStackTrace();
            message.setSuccess(Boolean.FALSE);
            message.addMessages("User y/o correo invalido");
        }
        return message;                
    }
            
}
