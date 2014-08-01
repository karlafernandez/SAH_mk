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
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.ClienteDAO;
import pe.com.microdata.cjava.service.registro.dto.ClienteDTO;

/**
 *
 * @author meliMeli
 */
@Service("modificarAlumnoValidador")
public class ModificarClienteValidador implements Validator {

    @SuppressWarnings("unchecked")
    @Autowired
    ClienteDAO clienteDAO;

    @Override
    public boolean supports(Class<?> clazz) {
        return ClienteDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ClienteDTO dto = (ClienteDTO) target;
        if (!Validador.noNuloNoVacio(dto.getNombre())) {
            errors.rejectValue("usuario", "val.cliente.usuario_vacio");
        } else {
            Boolean existe = clienteDAO.existeUsuario(dto.getUsuario());
            if (existe) {
                errors.rejectValue("usuario", "val.cliente.usuario");
            }
        }


        if (!Validador.noNuloNoVacio(dto.getNombre())) {
            errors.rejectValue("nombre", "val.cliente.nombre");
        }
        if (!Validador.noNuloNoVacio(dto.getPrimerApellido())) {
            errors.rejectValue("primerApellido", "val.cliente.primerApellido");
        }

        if (!Validador.esFecha(dto.getFechaNacimiento(), Constants.FORMATO_FECHA)) {
            errors.rejectValue("fechaNacimiento", "val.cliente.fechaNacimiento");
        }

        if (!Validador.esMayorCero(dto.getIdTipdocumento())) {
            errors.rejectValue("idTipdocumento", "val.cliente.tipNroDocumento");
        }
        if (!Validador.contieneSoloNumeros(dto.getDocumento())) {
            errors.rejectValue("documento", "val.cliente.documento");
        }
        if (Validador.noNuloNoVacio(dto.getTelefono()) && !Validador.contieneSoloNumeros(dto.getTelefono())) {
            errors.rejectValue("telefono", "val.cliente.telefono");
        }
        if (Validador.noNuloNoVacio(dto.getCelular()) && !Validador.contieneSoloNumeros(dto.getCelular())) {
            errors.rejectValue("celular", "val.cliente.celular");
        }
        if (!Validador.esEmail(dto.getCorreoPersonal())) {
            errors.rejectValue("correoPersonal", "val.cliente.correoPersonal");
        }


        if (Validador.noNuloNoVacio(dto.getCorreoCoorporativo()) && !Validador.esEmail(dto.getCorreoCoorporativo())) {
            errors.rejectValue("correoCoorporativo", "val.cliente.correoCoorporativo");
        }
        if (!Validador.noNuloNoVacio(dto.getPais())) {
            errors.rejectValue("pais", "val.cliente.pais");
        }

        if (!Validador.noNuloNoVacio(dto.getDepartamento())) {
            errors.rejectValue("departamento", "val.cliente.departamento");
        }

        if (!Validador.noNuloNoVacio(dto.getProvincia())) {
            errors.rejectValue("provincia", "val.cliente.provincia");
        }

        if (!Validador.noNuloNoVacio(dto.getDistrito())) {
            errors.rejectValue("distrito", "val.cliente.distrito");
        }

        if (!Validador.noNuloNoVacio(dto.getDireccion())) {
            errors.rejectValue("direccion", "val.alumno.direccion");
        }

        if (!Validador.esMayorCero(dto.getIdOcupacion())) {
            errors.rejectValue("idOcupacion", "val.cliente.ocupacion");
        }

        if (Validador.noNuloNoVacio(dto.getCorreoFace()) && !Validador.esEmail(dto.getCorreoFace())) {
            errors.rejectValue("correoFace", "val.cliente.correoPersonal");
        }
        
        if (Validador.noNuloNoVacio(dto.getCorreoFace())&& !Validador.esEmail(dto.getCorreoLinke())) {
            errors.rejectValue("correoLinke", "val.cliente.correoPersonal");
        } 

    }
}
