package pe.com.microdata.cjava.web.base;

import java.util.Locale;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.service.base.dto.UserDetailsDTO;


public class BaseController {
       private MessageSourceAccessor messages;
    private ServletContext servletContext;
    protected Locale locale = new Locale(Constants.LOCALE_ES);
    protected final String MENSAJE = "mensaje";
    protected final String MENSAJE_VAL = "valMensaje";
    
    @Autowired
    public void setMessages(MessageSource messageSource) {
        messages = new MessageSourceAccessor(messageSource);
    }

    @ModelAttribute(MENSAJE)
    public SIGAMessage initMensaje(HttpServletRequest request) {
        SIGAMessage mensaje = new SIGAMessage();
        if (request.getSession().getAttribute(MENSAJE) != null) {
            mensaje = (SIGAMessage) request.getSession().getAttribute(MENSAJE);
            request.getSession().removeAttribute(MENSAJE);
        }
        return mensaje;
    }
    
    public Locale getLocate() {
        return locale;
    }

    public String getText(String msgKey) {
        return messages.getMessage(msgKey, locale);
    }

    public String getText(String msgKey, String arg) {
        return getText(msgKey, new Object[]{arg});
    }

    public String getText(String msgKey, Object[] args) {
        return messages.getMessage(msgKey, args, locale);
    }

    public Integer getIdUsuario() {
      
         UserDetailsDTO userDetailDTO;
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            userDetailDTO = (UserDetailsDTO) authentication.getDetails();
        } catch (Exception ex) {
            userDetailDTO = null;
        }
        return userDetailDTO.getIdUsuario();
    }

    public String getUsuario() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String usuario = authentication.getName();
        if (!usuario.equals("anonymousUser")) {
            usuario = authentication.getName();
            return usuario;
        } else {
            return null;
        }
    }

   public UserDetailsDTO getDatosUsuario() {
        UserDetailsDTO userDetailDTO;
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            userDetailDTO = (UserDetailsDTO) authentication.getDetails();
        } catch (Exception ex) {
            userDetailDTO = null;
        }
        return userDetailDTO;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
