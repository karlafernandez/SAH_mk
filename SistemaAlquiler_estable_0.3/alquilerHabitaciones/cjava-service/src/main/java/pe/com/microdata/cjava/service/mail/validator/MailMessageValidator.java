/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.mail.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pe.com.microdata.cjava.common.validador.Validador;
import pe.com.microdata.cjava.service.mail.dto.MailMessageDTO;

/**
 *
 * @author Alejandra Gonzales
 */
@Service("mailValidator")
public class MailMessageValidator implements Validator {

    @SuppressWarnings("unchecked")
    @Override
    public boolean supports(Class<?> clazz) {
        return MailMessageDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        MailMessageDTO dTO = (MailMessageDTO) target;
        String[] receptores = dTO.getReceptores().split(";");
        if (receptores == null || receptores.length == 0) {
            errors.rejectValue("receptores", "Ingrese un correo");
        } else {
            for (int i = 0; i < receptores.length; i++) {
                String email = receptores[i];
                if (!Validador.esEmail(email)) {
                    errors.rejectValue("receptores", "Error en correo electronico");
                }
            }
        }

    }
}
