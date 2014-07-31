package pe.com.microdata.cjava.service.base.autenticacion;

import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
//import pe.com.sigca.dataaccess.domain.UsuarioDAO;
//import pe.com.sigca.dataaccess.model.UsuarioVO;

@Service("loginSuccessHandler")
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
 //   private UsuarioDAO usuarioDAO;
    public static final String REDIRECT_WEB_PRINCIPAL = "principal.html";

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws ServletException, IOException {
 //       UsuarioVO usuarioVO = this.usuarioDAO.obtenerUsuarioPorNombreUsuario(authentication.getName());

        response.sendRedirect(response.encodeRedirectURL(REDIRECT_WEB_PRINCIPAL));

    }
}