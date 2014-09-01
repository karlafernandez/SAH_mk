/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.base.autenticacion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.stereotype.Service;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.common.codificacion.EncriptacionUtil;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.ArrendatarioDAO;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.PersonaDAO;
import pe.com.microdata.cjava.dataaccess.model.acceso.AccesoVO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.ArrendatarioVO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.PersonaVO;
import pe.com.microdata.cjava.service.base.dto.UserDetailsDTO;

@Service("webAuthenticationProvider")
public class WebAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private PersonaDAO personaDAO;
    
    @Autowired
    private ArrendatarioDAO instructorDAO;

    private static final Logger logger = Logger.getLogger(WebAuthenticationProvider.class.getName());
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //Obtener USERDETAILS por authentication
        UserDetailsDTO userDetailsDTO = obtenerDatosCliente(
                (String) authentication.getPrincipal(),
                (String) authentication.getCredentials());

        //Crear ACCESOS de usuario
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String acceso : userDetailsDTO.getLstAccesos()) {
            authorities.add(new GrantedAuthorityImpl(acceso));
        }

        //Crear TOKEN
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), authorities);
        token.setDetails(userDetailsDTO);
        return token;
    }

    private UserDetailsDTO obtenerDatosCliente(String nomUsuario, String clvUsuario) {
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        if (!nomUsuario.trim().isEmpty() && !clvUsuario.trim().isEmpty()) {
            PersonaVO usuario = this.personaDAO.obtenerUsuarioPorNombreUsuario(nomUsuario);
            if (usuario != null) {
                if (usuario.getPassPersona().equals(EncriptacionUtil.encriptar(clvUsuario))) {
                    userDetailsDTO.setNomNombre(usuario.getNomPersona() + "  " + usuario.getPrimerApellidoPer() + "  " + usuario.getSegundoApellidoPer());
                    userDetailsDTO.setNomUsuario(usuario.getUsuarioPersona());
                    userDetailsDTO.setTipoUser(Constants.SUBTIPO_USER_ADMINISTRADOR);
                    userDetailsDTO.setNomCargo(usuario.getTipoUserVO().getDesSubtipo());
                    /*
                    if(usuario.getTipoUserVO().getIdSubTipo() == Constants.SUBTIPO_USER_INSTRUCTOR){
                        ArrendatarioVO instrucVO = instructorDAO.obtenerInstructorPorIdPersona(usuario.getIdPersona());
                        userDetailsDTO.setIdUsuario(instrucVO.getIdInstructor());
                        userDetailsDTO.setTipoUser(Constants.SUBTIPO_USER_INSTRUCTOR);
                    }else{  
                        userDetailsDTO.setIdUsuario(usuario.getIdPersona());                                                
                    }
                            */
                    List<String> accesos = new ArrayList<String>();
                    for (AccesoVO acceso : new ArrayList<AccesoVO>(usuario.getAccesoVOs())) {
                        accesos.add(acceso.getNomAcceso());
                    }
                  //  accesos.add("ROLE_USER");
                    userDetailsDTO.setLstAccesos(accesos);
                } else {
                    throw new BadCredentialsException("La contraseña ingresada no es correcta");
                }
            } else {
                throw new AuthenticationServiceException("El usuario ingresado no existe en el sistema.");
            }
        } else {
            throw new AuthenticationServiceException("Debe ingresar los datos requeridos.");
        }
        return userDetailsDTO;
    }

    @Override
    public boolean supports(Class<?> type) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(type));
    }
}
