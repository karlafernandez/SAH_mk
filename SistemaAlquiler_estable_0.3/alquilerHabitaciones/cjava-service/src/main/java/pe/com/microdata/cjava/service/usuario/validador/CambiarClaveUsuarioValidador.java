/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.usuario.validador;

import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pe.com.microdata.cjava.common.codificacion.EncriptacionUtil;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.PersonaDAO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.PersonaVO;
import pe.com.microdata.cjava.service.usuario.dto.CambiarClaveUsuarioDTO;

/**
 *
 * @author César Bragagnini
 */
@Service("cambiarClaveUsuarioValidador")
public class CambiarClaveUsuarioValidador implements Validator{

    @Autowired
    PersonaDAO personaDAO;
    
    private String expresionRegular = "^[a-zA-Z0-9]{5,}$";
    
    @Override
    public boolean supports(Class<?> clazz) {
        return CambiarClaveUsuarioValidador.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CambiarClaveUsuarioDTO usuarioDTO = (CambiarClaveUsuarioDTO) target;
        int minLength = 6;
        if (usuarioDTO.getClvNueva().trim().isEmpty()) {
            errors.rejectValue("clvNueva", "val.clave.clave_nueva_vacia");
        } else if (usuarioDTO.getClvNueva().length() < minLength) {
            errors.rejectValue("clvNueva", "val.clave.long_min");
        } else if (!Pattern.matches(expresionRegular, usuarioDTO.getClvNueva())) {
            errors.rejectValue("clvNueva", "val.clave.error_patron");
        }

        if (usuarioDTO.getClvConfirmacion().trim().isEmpty()) {
            errors.rejectValue("clvConfirmacion", "val.clave.clave_confirmacion_vacia");
        } else if (usuarioDTO.getClvConfirmacion().length() < minLength) {
            errors.rejectValue("clvConfirmacion", "val.clave.long_min");
        } else if (!Pattern.matches(expresionRegular, usuarioDTO.getClvConfirmacion())) {
            errors.rejectValue("clvConfirmacion", "val.clave.error_patron");
        } else if (!usuarioDTO.getClvNueva().equals(usuarioDTO.getClvConfirmacion())) {
            errors.rejectValue("clvConfirmacion", "val.clave.clave_confirmacion_no_coincide");
        }

        if (usuarioDTO.getClvAnterior().trim().isEmpty()) {
            errors.rejectValue("clvAnterior", "val.clave.clave_anterior_vacia");
        } else {
            String clvAnteriorEncriptada = EncriptacionUtil.encriptar(usuarioDTO.getClvAnterior());
            PersonaVO personaVO = this.personaDAO.obtenerPersonaPorId(usuarioDTO.getIdPersona());
            if (personaVO != null) {
                if (!personaVO.getPassPersona().equals(clvAnteriorEncriptada)) {
                    errors.rejectValue("clvAnterior", "val.clave.clave_anterior_no_coincide");
                }
            }
        }
    }
        
}
