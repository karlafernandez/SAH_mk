package pe.com.microdata.cjava.service.autocomplete.impl;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.microdata.cjava.dataaccess.domain.administracion.curso.CuartoDAO;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.ClienteDAO;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.ArrendatarioDAO;
import pe.com.microdata.cjava.dataaccess.domain.operacion.operacion.OperacionClienteDAO;
import pe.com.microdata.cjava.dataaccess.domain.operacion.operacion.OperacionDAO;

import pe.com.microdata.cjava.dataaccess.model.administracion.curso.CuartoVO;
import pe.com.microdata.cjava.service.autocomplete.Autocomplete;

import pe.com.microdata.cjava.dataaccess.model.administracion.persona.ClienteVO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.ArrendatarioVO;
import pe.com.microdata.cjava.service.administracion.curso.cuarto.dto.CuartoDTO;
import pe.com.microdata.cjava.service.operacion.operacion.dto.OperacionAlumnoDTO;

/**
 *
 * @author meliMeli
 */
@Service("autocomplete")
public class AutocompleteImpl implements Autocomplete {

    @Autowired
    private OperacionDAO operacionDAO;
    @Autowired
    private OperacionClienteDAO operacionAlumnoDAO;
      
    @Autowired
    private CuartoDAO curEspecificoDAO;
    @Autowired
    private ClienteDAO alumnoDAO;
    @Autowired
    private ArrendatarioDAO instructorDAO;


    @Override
    public List buscarPorNombreCursoEspecifico(String strBusqueda) {
        int min = 3;
        List<CuartoDTO> autoList = new ArrayList<CuartoDTO>();
        if (strBusqueda.length() > min) {
            List<CuartoVO> objs = curEspecificoDAO.obtenerNombreCuartoPorBusqueda(strBusqueda);
            CuartoDTO autocompleteDTO;
            for (CuartoVO curEspVO : objs) {
                autocompleteDTO = new CuartoDTO();
                autocompleteDTO.setIdCuarto(curEspVO.getIdCuarto());
                autocompleteDTO.setNomenCuarto(curEspVO.getNomenclaturaCuarto());
                autocompleteDTO.setNumAmbientes(curEspVO.getNumAmbientes());
                
                
                autoList.add(autocompleteDTO);
            }
        } else {
            CuartoDTO temp = new CuartoDTO();
            temp.setNomenCuarto("Ingrese mas de " + min + " caracteres");
            temp.setIdCuarto(0);
            temp.setNomenCuarto("00000");
            temp.setNumAmbientes(0);
          
            autoList.add(temp);
        }
        return autoList;
    }

    @Override
    public List buscarPorNombreAlumnos(String strBusqueda) {
        int min = 1;
        List<OperacionAlumnoDTO> autoList = new ArrayList<OperacionAlumnoDTO>();
        if (strBusqueda.length() > min) {
            List<ClienteVO> objs = alumnoDAO.obtenerNombreDNIAlumnosPorBusqueda(strBusqueda);

            OperacionAlumnoDTO autocompleteDTO;
            for (ClienteVO alumnoVO : objs) {
                autocompleteDTO = new OperacionAlumnoDTO();
                //autocompleteDTO.setNombreCompleto(alumnoVO.getAlumnoPersonaVO().getNomPersona()+""+alumnoVO.getAlumnoPersonaVO().getPrimerApellidoPer()+""+alumnoVO.getAlumnoPersonaVO().getSegundoApellidoPer());
                autocompleteDTO.setNombre(alumnoVO.getClientePersonaVO().getNomPersona());
                autocompleteDTO.setPrimerApellido(alumnoVO.getClientePersonaVO().getPrimerApellidoPer());
                autocompleteDTO.setSegundoApellido(alumnoVO.getClientePersonaVO().getSegundoApellidoPer());
                autocompleteDTO.setDocumento(alumnoVO.getClientePersonaVO().getDocumentoPer());
                autocompleteDTO.setIdAlumno(alumnoVO.getIdCliente());
                autocompleteDTO.setNombreCompleto(autocompleteDTO.getPrimerApellido() + " " + autocompleteDTO.getSegundoApellido() + " " + autocompleteDTO.getNombre());
                autocompleteDTO.setDescripcion(alumnoVO.getClientePersonaVO().getPrimerApellidoPer() + " "
                        + alumnoVO.getClientePersonaVO().getSegundoApellidoPer() + " "
                        + alumnoVO.getClientePersonaVO().getNomPersona());
                autoList.add(autocompleteDTO);
            }
        } else {
            OperacionAlumnoDTO temp = new OperacionAlumnoDTO();
            temp.setDescripcion("Ingrese mas de " + min + " caracteres");
            temp.setNombre("0000");
            temp.setDocumento("0000");
            autoList.add(temp);
        }
        return autoList;
    }

    /*
    @Override
    public List buscarPorNombreInstructores(String strBusqueda) {
        int min = 1;
        List<OperacionInstructorDTO> autoList = new ArrayList<OperacionInstructorDTO>();
        if (strBusqueda.length() > min) {
            List<ArrendatarioVO> objs = instructorDAO.obtenerNombreDniInstructorPorBusqueda(strBusqueda);

            OperacionInstructorDTO autocompleteDTO;
            for (ArrendatarioVO operInstructorVO : objs) {
                autocompleteDTO = new OperacionInstructorDTO();
                //autocompleteDTO.setNombreCompleto(alumnoVO.getAlumnoPersonaVO().getNomPersona()+""+alumnoVO.getAlumnoPersonaVO().getPrimerApellidoPer()+""+alumnoVO.getAlumnoPersonaVO().getSegundoApellidoPer());
                autocompleteDTO.setNombre(operInstructorVO.getInstructorPersonaVO().getNomPersona());
                autocompleteDTO.setPrimerApellido(operInstructorVO.getInstructorPersonaVO().getPrimerApellidoPer());
                autocompleteDTO.setSegundoApellido(operInstructorVO.getInstructorPersonaVO().getSegundoApellidoPer());
                autocompleteDTO.setDocumento(operInstructorVO.getInstructorPersonaVO().getDocumentoPer());
                autocompleteDTO.setIdInstructor(operInstructorVO.getIdInstructor());
                autocompleteDTO.setDescripcion(operInstructorVO.getInstructorPersonaVO().getNomPersona() + " "
                        + operInstructorVO.getInstructorPersonaVO().getPrimerApellidoPer() + " "
                        + operInstructorVO.getInstructorPersonaVO().getSegundoApellidoPer());
                autoList.add(autocompleteDTO);
            }
        } else {
            OperacionInstructorDTO temp = new OperacionInstructorDTO();
            temp.setDescripcion("Ingrese mas de " + min + " caracteres");
            temp.setNombre("0000");
            temp.setDocumento("0000");
            autoList.add(temp);
        }
        return autoList;
    }*/
}
