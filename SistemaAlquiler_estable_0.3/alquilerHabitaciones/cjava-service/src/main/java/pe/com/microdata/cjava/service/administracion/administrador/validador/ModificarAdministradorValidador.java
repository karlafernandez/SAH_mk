/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.administracion.administrador.validador;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.common.validador.Validador;
import pe.com.microdata.cjava.service.administracion.administrador.dto.AdministradorDTO;



@Service("modificarAdministradorValidador")
public class ModificarAdministradorValidador implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ModificarAdministradorValidador.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AdministradorDTO dto = (AdministradorDTO) target;
        if(!Validador.esMayorCero(dto.getIdAdmin())){
            errors.rejectValue("idAdmin", null);
        }            
        if (!Validador.noNuloNoVacio(dto.getNomUser())) {
            errors.rejectValue("nomAdmin", "val.admin.nombre");
        }
        if (!Validador.noNuloNoVacio(dto.getPrimerApellido())) {
            errors.rejectValue("primerApellido", "val.admin.primerApellido");
        }
        if (!Validador.noNuloNoVacio(dto.getSegundoApellido())) {
            errors.rejectValue("segundoApellido", "val.admin.segundoApellido");
        }
        if (!Validador.esFecha(dto.getFechaNacimiento(), Constants.FORMATO_FECHA)) {
            errors.rejectValue("fechaNacimiento", "val.admin.fechaNacimiento");
        }
        if (!Validador.esMayorCero(dto.getIdTipdocumento())) {
            errors.rejectValue("idTipdocumento", "val.admin.tipNroDocumento");
        }
        if (!Validador.contieneSoloNumeros(dto.getDocumento())) {
            errors.rejectValue("documento", "val.admin.documento");
        }
        if (Validador.noNuloNoVacio(dto.getTelefono()) && !Validador.contieneSoloNumeros(dto.getTelefono())) {
            errors.rejectValue("telefono", "val.admin.telefono");
        }
        if (Validador.noNuloNoVacio(dto.getCelular()) && !Validador.contieneSoloNumeros(dto.getCelular())) {
            errors.rejectValue("celular", "val.admin.celular");
        }
        if (!Validador.esEmail(dto.getCorreoPersonal())) {
            errors.rejectValue("correoPersonal", "val.admin.correoPersonal");
        }
        if(Validador.noNuloNoVacio(dto.getCorreoCoorporativo()) && !Validador.esEmail(dto.getCorreoCoorporativo())) {
            errors.rejectValue("correoCoorporativo", "val.admin.correoCoorporativo");
        }
        if (!Validador.noNuloNoVacio(dto.getPais())) {
            errors.rejectValue("pais", "val.admin.pais");
        }
        if (!Validador.noNuloNoVacio(dto.getDepartamento())) {
           errors.rejectValue("departamento", "val.admin.departamento");        
        }
        if (!Validador.noNuloNoVacio(dto.getProvincia())) {
            errors.rejectValue("provincia", "val.admin.provincia");
        }
        if (!Validador.noNuloNoVacio(dto.getDistrito())) {
            errors.rejectValue("distrito", "val.admin.distrito");
        }
        if (!Validador.noNuloNoVacio(dto.getDireccion())) {
            errors.rejectValue("direccion", "val.admin.direccion");
        }                       
    }
                
}
