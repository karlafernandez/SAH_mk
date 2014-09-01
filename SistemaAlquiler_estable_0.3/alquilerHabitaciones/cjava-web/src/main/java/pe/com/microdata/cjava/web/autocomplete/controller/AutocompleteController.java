package pe.com.microdata.cjava.web.autocomplete.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.com.microdata.cjava.service.autocomplete.Autocomplete;


@Controller
@RequestMapping(value = "/autocomplete")
public class AutocompleteController {
/*
    private static final String AUTOCOMPLETE = "autocomplete";
    @Autowired
    private Autocomplete autocomplete;

    @RequestMapping(value = "/nomCursoGral", method = RequestMethod.GET)
    public @ResponseBody
    List obtenerNombreCursoGeneral(@RequestParam("term") String search) {
        List lista = new ArrayList();
     //   lista = this.autocomplete.buscarPorNombreCursoGeneral(search);
   
        return lista;
    }
  
    @RequestMapping(value = "/nomCursoEsp", method = RequestMethod.GET)
    public @ResponseBody
    List obtenerNombreCursoEspecifico(@RequestParam("term") String search) {
        List lista = new ArrayList();
        lista = this.autocomplete.buscarPorNombreCursoEspecifico(search);   
        return lista;
    }
      
    @RequestMapping(value = "/nomAlumnos", method = RequestMethod.GET)
    public @ResponseBody
    List obtenerNombreAlumnos(@RequestParam("term") String search) {
        List lista = new ArrayList();
        lista = this.autocomplete.buscarPorNombreAlumnos(search);
         
        return lista;
    }
    
        @RequestMapping(value = "/nomInstructores", method = RequestMethod.GET)
    public @ResponseBody
    List obtenerNombreInstructores(@RequestParam("term") String search) {
        List lista = new ArrayList();
      //  lista = this.autocomplete.buscarPorNombreInstructores(search);                        
        return lista;
    }
        
    @RequestMapping(value = "/nomAlumnoCursoGeneral", method = RequestMethod.GET)
    public @ResponseBody
    List obtenerNombreAlumnosCursoGeneral(@RequestParam("term") String search){
        List lista = new ArrayList();
        lista = this.autocomplete.buscarPorNombreAlumnos(search);         
        return lista;
    }
  */          
}