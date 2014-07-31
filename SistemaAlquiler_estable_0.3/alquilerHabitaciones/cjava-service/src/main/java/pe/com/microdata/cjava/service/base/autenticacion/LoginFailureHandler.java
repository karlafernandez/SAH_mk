package pe.com.microdata.cjava.service.base.autenticacion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Service;



@Service("loginFailureHandler")
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private static final String DEFAULT_FAILURE_URL = "";

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {

        request.getSession().setAttribute("msgErrorAuthentication", exception.getMessage());
        response.sendRedirect(response.encodeRedirectURL(getFailureUrl(exception)));
    }

    private String getFailureUrl(AuthenticationException exception) {

        if (exception instanceof AuthenticationServiceException) {
            logger.info("Login failure -> Authentication Service");
            return DEFAULT_FAILURE_URL;
        }
        if (exception instanceof DisabledException) {
            logger.info("Login failure -> Disabled Account");
            return DEFAULT_FAILURE_URL;
        }
        if (exception instanceof BadCredentialsException) {
            logger.info("Login failure -> Bad Credentials");
            return DEFAULT_FAILURE_URL;
        }
        if (exception instanceof AccountExpiredException) {
            logger.info("Login failure -> Account Expired");
            return DEFAULT_FAILURE_URL;
        }
        logger.info("Login failure -> ??");
        return DEFAULT_FAILURE_URL;
    }
}
