/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.registro.validador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.common.validador.Validador;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.ArrendatarioDAO;
import pe.com.microdata.cjava.service.registro.dto.InstructorDTO;

/**
 *
 * @author meliMeli
 */
@Service("registrarInstructorValidador")
public class RegistrarInstructorValidador implements Validator {

    @SuppressWarnings("unchecked")
    @Autowired
    ArrendatarioDAO instructorDAO;

    @Override
    public boolean supports(Class<?> clazz) {
        return InstructorDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        InstructorDTO dto = (InstructorDTO) target;
        if (!Validador.noNuloNoVacio(dto.getNombre())) {
            errors.rejectValue("usuario", "val.alumno.usuario_vacio");
        } else {
            Boolean existe = instructorDAO.existeUsuario(dto.getUsuario());
            if (existe) {
                errors.rejectValue("usuario", "val.alumno.usuario");
            }
        }


        if (!Validador.noNuloNoVacio(dto.getNombre())) {
            errors.rejectValue("nombre", "val.alumno.nombre");
        }
        if (!Validador.noNuloNoVacio(dto.getPrimerApellido())) {
            errors.rejectValue("primerApellido", "val.alumno.primerApellido");
        }
        
         if (!Validador.noNuloNoVacio(dto.getSegundoApellido())) {
            errors.rejectValue("segundoApellido", "val.alumno.segundoApellido");
        }

        if (!Validador.esFecha(dto.getFechaNacimiento(), Constants.FORMATO_FECHA)) {
            errors.rejectValue("fechaNacimiento", "val.alumno.fechaNacimiento");
        }

        if (!Validador.esMayorCero(dto.getIdTipdocumento())) {
            errors.rejectValue("idTipdocumento", "val.alumno.tipNroDocumento");
        }
        if (!Validador.contieneSoloNumeros(dto.getDocumento())) {
            errors.rejectValue("documento", "val.alumno.documento");
        }
        if (Validador.noNuloNoVacio(dto.getTelefono()) && !Validador.contieneSoloNumeros(dto.getTelefono())) {
            errors.rejectValue("telefono", "val.alumno.telefono");
        }
        if (Validador.noNuloNoVacio(dto.getCelular()) && !Validador.contieneSoloNumeros(dto.getCelular())) {
            errors.rejectValue("celular", "val.alumno.celular");
        }
        if (!Validador.esEmail(dto.getCorreoPersonal())) {
            errors.rejectValue("correoPersonal", "val.alumno.correoPersonal");
        }

        if (Validador.noNuloNoVacio(dto.getCorreoCoorporativo()) && !Validador.esEmail(dto.getCorreoCoorporativo())) {
            errors.rejectValue("correoCoorporativo", "val.alumno.correoCoorporativo");
        }
        if (!Validador.noNuloNoVacio(dto.getPais())) {
            errors.rejectValue("pais", "val.alumno.pais");
        }

        if (!Validador.noNuloNoVacio(dto.getDepartamento())) {
            errors.rejectValue("departamento", "val.alumno.departamento");
        }

        if (!Validador.noNuloNoVacio(dto.getProvincia())) {
            errors.rejectValue("provincia", "val.alumno.provincia");
        }

        if (!Validador.noNuloNoVacio(dto.getDistrito())) {
            errors.rejectValue("distrito", "val.alumno.distrito");
        }

        if (!Validador.noNuloNoVacio(dto.getDireccion())) {
            errors.rejectValue("direccion", "val.alumno.direccion");
        }



    }
}
