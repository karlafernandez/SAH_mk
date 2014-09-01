/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.registro.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pe.com.microdata.cjava.common.base.BusquedaDTO;
import pe.com.microdata.cjava.common.base.Constants;

import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.common.codificacion.EncriptacionUtil;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.ClienteDAO;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.PersonaDAO;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.UbigeoDAO;
import pe.com.microdata.cjava.dataaccess.domain.operacion.operacion.OperacionClienteDAO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.ClienteVO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.PersonaVO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.SubTipoVO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.UbigeoVO;
import pe.com.microdata.cjava.dataaccess.model.operacion.alquilado.OperacionClienteVO;
import pe.com.microdata.cjava.service.mail.MailService;
import pe.com.microdata.cjava.service.mail.dto.MailParametersDTO;
import pe.com.microdata.cjava.service.registro.GestionarCliente;
import pe.com.microdata.cjava.service.registro.dto.ClienteDTO;
import pe.com.microdata.cjava.service.registro.dto.HistorialCursoDTO;
import pe.com.microdata.cjava.service.registro.dto.ItemCursoHistorialDTO;


@Service("gestionarAlumno")
public class GestionarClienteImpl implements GestionarCliente {

    @Autowired
    ClienteDAO clienteDAO;
    @Autowired
    PersonaDAO personaDAO;
    @Autowired
    UbigeoDAO ubigeoDAO;
    @Autowired
    OperacionClienteDAO operacionClienteDAO;
    @Autowired
    MailService mailService;
    @Autowired
    @Qualifier("mailBean")
    MailParametersDTO mailParametersDTO;
    SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.FORMATO_FECHA);
    private Logger logger = Logger.getLogger(GestionarClienteImpl.class.getCanonicalName());

    
    @Override
    public SIGAMessage registrarCliente(ClienteDTO alumnoDTO) {
        SIGAMessage msg = new SIGAMessage();
        msg.setSuccess(Boolean.FALSE);
        PersonaVO personaVO = new PersonaVO();
        try {
            //////////////////////////////PERSONAVO//////////////////////////////
            personaVO.setNomPersona(alumnoDTO.getNombre());
            personaVO.setPrimerApellidoPer(alumnoDTO.getPrimerApellido());
            personaVO.setSegundoApellidoPer(alumnoDTO.getSegundoApellido());
            personaVO.setFechaNacimientoPer(dateFormat.parse(alumnoDTO.getFechaNacimiento()));
            personaVO.setDireccionPer(alumnoDTO.getDireccion());
            personaVO.setReferenciaPer(alumnoDTO.getReferenciaDir());
            personaVO.setIdDocumentoVO(new SubTipoVO(alumnoDTO.getIdTipdocumento()));
            personaVO.setDocumentoPer(alumnoDTO.getDocumento());
            personaVO.setTelefono(alumnoDTO.getTelefono());
            personaVO.setCelular(alumnoDTO.getCelular());

            personaVO.setCorreoPersonalPer(alumnoDTO.getCorreoPersonal());
            personaVO.setCorreoCoorPer(alumnoDTO.getCorreoCoorporativo());
            personaVO.setUrbanizacionPer(alumnoDTO.getUrbPer());
            personaVO.setDireccionPer(alumnoDTO.getDireccion());
            personaVO.setReferenciaPer(alumnoDTO.getReferenciaDir());
            personaVO.setTipoUserVO(new SubTipoVO(Constants.SUBTIPO_USER_ALUMNO));
            personaVO.setEstBloqueado(Constants.USUARIO_ESTADO_NO_BLOQUEADO);
            personaVO.setEstEliminado(Constants.USUARIO_ESTADO_NO_ELIMINADO);
            personaVO.setNroIntento(0);
            personaVO.setFechaRegistroPer(Calendar.getInstance());
            UbigeoVO ubiVO = ubigeoDAO.obtenerUbigeoPorCodigo(alumnoDTO.getPais(), alumnoDTO.getDepartamento(), alumnoDTO.getProvincia(), alumnoDTO.getDistrito());
            personaVO.setUbigeoVO(ubiVO);
            //////////////////AUTOGENERAR  PASSWORD/////////////
            String password = EncriptacionUtil.encriptar(alumnoDTO.getUsuario()).substring(0, 6);
            personaVO.setUsuarioPersona(alumnoDTO.getUsuario());
            personaVO.setPassPersona(EncriptacionUtil.encriptar(password));
            //////////////////////////////ALUMNO VO/////////////////////////////
            ClienteVO alumnoVO = new ClienteVO();
            
            alumnoVO.setCorreoFaceAlumno(alumnoDTO.getCorreoFace());
           
            Integer idAlumno = clienteDAO.insert(alumnoVO);
            if (idAlumno != 0) {
                obtenerCodigoCliente(idAlumno);
            }
            //////////////////CORREO/////////////
            StringBuilder builder = new StringBuilder();
            builder.append("<strong><font color=\"#0b5394\">Bienvenido(a):</font></strong><br><br>");
            builder.append("<font color=\"#0b5394\">Gracias por formar parte de CJava Perú.<br>");
            builder.append("A continuación, le brindamos los accesos a la extranet de nuestra institución:</font><br><br>");
            builder.append("<font color=\"#0b5394\">Usuario :<b>").append(alumnoDTO.getUsuario()).append("</b></font><br>");
            builder.append("<font color=\"#0b5394\">Clave :<b>").append(password).append("</b></font><br>");
            builder.append("<font color=\"#0b5394\">Link de acceso :</font> <a href=\"http://www.cjavaperu.com:8080/cjava-web-externo/login.html\">http://www.cjavaperu.com:8080/cjava-web-externo/login.html </a><br><br>");
            builder.append("<font color=\"#0b5394\">Nota: A fin de mantener confidencialidad en su cuenta, solicitamos cambiar su clave después de acceder a ella.</font><br>");
            builder.append("<font color=\"#0b5394\">Cordialmente.</font><br>");
            builder.append("<font color=\"#0b5394\">------------------</font><br>");
            builder.append("<strong><font color=\"#0b5394\">CJava Perú.</font></strong><br>");
            builder.append("<strong><font color=\"#0b5394\">Siempre para apoyarte...</font></strong><br>");
            mailService.sendAsHtml(mailParametersDTO.getUsername(), mailParametersDTO.getUsername(), alumnoDTO.getCorreoPersonal(), null, "Bienvenido a CJAVA", builder.toString());

            msg.setSuccess(Boolean.TRUE);
        } catch (Exception ex) {
            ex.printStackTrace();
            msg.setSuccess(Boolean.FALSE);
        }
        return msg;
    }

    private void obtenerCodigoCliente(Integer idAlumno) {
        Calendar c = new GregorianCalendar();
        String annio = Integer.toString(c.get(Calendar.YEAR));
        PersonaVO personaVO = new PersonaVO();
        ClienteVO alumnoVO = clienteDAO.obtenerClientePorIdCliente(idAlumno);
               
        personaVO = alumnoVO.getClientePersonaVO();
        personaVO.setCodigo(annio + "-" + idAlumno.toString());
        personaDAO.saveOrUpdate(personaVO);
    }

    @Override
    public ClienteDTO obtenerClientePorId(Integer idAlumno) {

        ClienteDTO alumnoDTO = new ClienteDTO();
        ClienteVO alumnoVO = clienteDAO.obtenerClientePorIdCliente(idAlumno);
             
        PersonaVO personaVO;
        //////////////////////////////ALUMNO VO/////////////////////////////
     
        alumnoDTO.setCorreoFace(alumnoVO.getCorreoFaceAlumno());
       
       
        /////////////////////////PERSONA /////////////////////////
        personaVO = alumnoVO.getClientePersonaVO();
        alumnoDTO.setNombre(personaVO.getNomPersona());
        alumnoDTO.setPrimerApellido(personaVO.getPrimerApellidoPer());
        alumnoDTO.setSegundoApellido(personaVO.getSegundoApellidoPer());
        alumnoDTO.setNombreCompleto(personaVO.getNomPersona() + ", " + personaVO.getPrimerApellidoPer() + " " + personaVO.getSegundoApellidoPer());
        alumnoDTO.setFechaNacimiento(dateFormat.format(personaVO.getFechaNacimientoPer()));
        alumnoDTO.setIdTipdocumento(personaVO.getIdDocumentoVO() != null ? personaVO.getIdDocumentoVO().getIdSubTipo() : 0);
        alumnoDTO.setDocumento(personaVO.getDocumentoPer());
        alumnoDTO.setTelefono(personaVO.getTelefono());
        alumnoDTO.setCelular(personaVO.getCelular());
        alumnoDTO.setCodigo(personaVO.getCodigo());
        alumnoDTO.setCorreoPersonal(personaVO.getCorreoPersonalPer());
        alumnoDTO.setCorreoCoorporativo(personaVO.getCorreoCoorPer());
        alumnoDTO.setIdPersona(personaVO.getIdPersona());

        alumnoDTO.setUrbPer(personaVO.getUrbanizacionPer());
        alumnoDTO.setDireccion(personaVO.getDireccionPer());
        alumnoDTO.setReferenciaDir(personaVO.getReferenciaPer());

        alumnoDTO.setPais(personaVO.getUbigeoVO().getIdPais());
        alumnoDTO.setDepartamento(personaVO.getUbigeoVO().getIdDepartamento());
        alumnoDTO.setProvincia(personaVO.getUbigeoVO().getIdProvincia());
        alumnoDTO.setDistrito(personaVO.getUbigeoVO().getIdDistrito());
        alumnoDTO.setNombreUbigeo(personaVO.getUbigeoVO().getNombreUbigeo());

        return alumnoDTO;
    }

    @Override
    public SIGAMessage modificarCliente(ClienteDTO alumnoDTO) {

        SIGAMessage msg = new SIGAMessage();
        msg.setSuccess(Boolean.FALSE);
        PersonaVO personaVO = personaDAO.obtenerPersonaPorIdPersona(alumnoDTO.getIdPersona());

        ClienteVO alumnoVO = clienteDAO.obtenerClientePorIdCliente(alumnoDTO.getIdAlumno());
             
        Date fecha = new Date();
        Calendar c = new GregorianCalendar();
        String annio = Integer.toString(c.get(Calendar.YEAR));
        //////////////////////////////PERSONAVO//////////////////////////////
        personaVO.setNomPersona(alumnoDTO.getNombre());
        personaVO.setPrimerApellidoPer(alumnoDTO.getPrimerApellido());
        personaVO.setSegundoApellidoPer(alumnoDTO.getSegundoApellido());
        personaVO.setDireccionPer(alumnoDTO.getDireccion());
        personaVO.setReferenciaPer(alumnoDTO.getReferenciaDir());
        personaVO.setIdDocumentoVO(new SubTipoVO(alumnoDTO.getIdTipdocumento()));
        personaVO.setDocumentoPer(alumnoDTO.getDocumento());
        personaVO.setTelefono(alumnoDTO.getTelefono());
        personaVO.setCelular(alumnoDTO.getCelular());
        personaVO.setCodigo(annio + "-" + alumnoDTO.getIdAlumno().toString());
        personaVO.setCorreoPersonalPer(alumnoDTO.getCorreoPersonal());
        personaVO.setCorreoCoorPer(alumnoDTO.getCorreoCoorporativo());
        personaVO.setUrbanizacionPer(alumnoDTO.getUrbPer());
        personaVO.setDireccionPer(alumnoDTO.getDireccion());
        personaVO.setReferenciaPer(alumnoDTO.getReferenciaDir());
        UbigeoVO ubiVO = ubigeoDAO.obtenerUbigeoPorCodigo(alumnoDTO.getPais(), alumnoDTO.getDepartamento(), alumnoDTO.getProvincia(), alumnoDTO.getDistrito());
        personaVO.setUbigeoVO(ubiVO);
        //////////////////AUTOGENERAR USUARIO PASSWORD/////////////
        try {
            personaVO.setFechaNacimientoPer(dateFormat.parse(alumnoDTO.getFechaNacimiento()));
        } catch (ParseException ex) {
            Logger.getLogger(GestionarClienteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        personaVO.setTipoUserVO(new SubTipoVO(Constants.SUBTIPO_USER_ALUMNO));
        personaDAO.saveOrUpdate(personaVO);
        //////////////////////////////ALUMNO VO/////////////////////////////
        
        alumnoVO.setCorreoFaceAlumno(alumnoDTO.getCorreoFace());
       
        clienteDAO.saveOrUpdate(alumnoVO);
        
        msg.setSuccess(Boolean.TRUE);
        return msg;
    }

    @Override
    public void eliminarCliente(Integer alumno) {
        ClienteVO alumnoVO = clienteDAO.obtenerClientePorIdCliente(alumno);
                
        clienteDAO.delete(alumnoVO);
    }

    @Override
    public List obtenerClientePorBusqueda(BusquedaDTO busquedaDTO) {
        List<ClienteDTO> alumnoDTOs = new ArrayList<ClienteDTO>();
        List<ClienteVO> alumnoVOs = clienteDAO.obtenerClientesPorBusqueda(busquedaDTO);
               
        PersonaVO personaVO;
        
        for (ClienteVO alumnoVO : alumnoVOs) {
            ClienteDTO alumnoDTO = new ClienteDTO();
  
            alumnoDTO.setCorreoFace(alumnoVO.getCorreoFaceAlumno());
        
            /////////////////////////PERSONA /////////////////////////
            personaVO = alumnoVO.getClientePersonaVO();
            alumnoDTO.setNombre(personaVO.getNomPersona());
            alumnoDTO.setPrimerApellido(personaVO.getPrimerApellidoPer());
            alumnoDTO.setSegundoApellido(personaVO.getSegundoApellidoPer());
            alumnoDTO.setNombreCompleto(personaVO.getNomPersona() + ", " + personaVO.getPrimerApellidoPer() + " " + personaVO.getSegundoApellidoPer());
            alumnoDTO.setFechaNacimiento(personaVO.getFechaNacimientoPer() != null ? dateFormat.format(personaVO.getFechaNacimientoPer()) : "");
            alumnoDTO.setIdTipdocumento(personaVO.getIdDocumentoVO() != null ? personaVO.getIdDocumentoVO().getIdSubTipo() : 0);
            alumnoDTO.setDocumento(personaVO.getDocumentoPer());
            alumnoDTO.setTelefono(personaVO.getTelefono());
            alumnoDTO.setCelular(personaVO.getCelular());
            alumnoDTO.setCodigo(personaVO.getCodigo());
            alumnoDTO.setCorreoPersonal(personaVO.getCorreoPersonalPer());
            alumnoDTO.setCorreoCoorporativo(personaVO.getCorreoCoorPer());
            alumnoDTO.setUrbPer(personaVO.getUrbanizacionPer());
            alumnoDTO.setDireccion(personaVO.getDireccionPer());
            alumnoDTO.setReferenciaDir(personaVO.getReferenciaPer());
            alumnoDTO.setPais(personaVO.getUbigeoVO().getIdPais());
            alumnoDTO.setDepartamento(personaVO.getUbigeoVO().getIdDepartamento());
            alumnoDTO.setDistrito(personaVO.getUbigeoVO().getIdDistrito());
            alumnoDTO.setNombreUbigeo(personaVO.getUbigeoVO().getNombreUbigeo());
            alumnoDTOs.add(alumnoDTO);
        }
        return alumnoDTOs;
    }

    @Override
    public Long obtenerTotalClientesPorBusqueda(BusquedaDTO busquedaDTO) {
        Long total = clienteDAO.obtenerTotalClientesPorBusqueda(busquedaDTO);
              
        return total;
    }

    @Override
    public ClienteDTO obtenerCodigoAutogenerado(BusquedaDTO busquedaDTO) {
        Long pretotal = clienteDAO.obtenerTotalClientesPorBusqueda(busquedaDTO);
             
        int intValue = pretotal.intValue();
        Integer codigo = intValue + 1;
        ClienteDTO alumno = new ClienteDTO();
        alumno.setCodigo(codigo.toString());
        return alumno;
    }

    @Override
    public List obtenerTotalClientes() {
        List<ClienteDTO> alumnoDTOs = new ArrayList<ClienteDTO>();
        List<ClienteVO> alumnoVOs = clienteDAO.obtenerTotalClientes();
                
        PersonaVO personaVO;
        for (ClienteVO alumnoVO : alumnoVOs) {
            ClienteDTO alumnoDTO = new ClienteDTO();
            //////////////////////////////ALUMNO VO//////////////////////
            alumnoDTO.setIdAlumno(alumnoVO.getIdCliente());

            /////////////////////////PERSONA /////////////////////////
            personaVO = alumnoVO.getClientePersonaVO();
            alumnoDTO.setNombre(personaVO.getNomPersona());
            alumnoDTO.setPrimerApellido(personaVO.getPrimerApellidoPer());
            alumnoDTO.setSegundoApellido(personaVO.getSegundoApellidoPer());
            alumnoDTO.setNombreCompleto(personaVO.getNomPersona() + ", " + personaVO.getPrimerApellidoPer() + " " + personaVO.getSegundoApellidoPer());
            alumnoDTOs.add(alumnoDTO);
        }
        return alumnoDTOs;
    }
/*
    @Override
    public HistorialCursoDTO obtenerHistorialCursoPorIdAlumno(Integer idAlum) {
        HistorialCursoDTO historialDTO = new HistorialCursoDTO();
        List<OperacionClienteVO> listOpe = operacionClienteDAO.obtenerListaOperacionPorIdAlum(idAlum);
        List<ItemCursoHistorialDTO> listLLevados = new ArrayList<ItemCursoHistorialDTO>();
        List<ItemCursoHistorialDTO> listCursando = new ArrayList<ItemCursoHistorialDTO>();
        for (OperacionClienteVO vo : listOpe) {
            String tipo = vo.getIdOperacionVO().getIdEstadoVO().getNomSubtipo();
            ItemCursoHistorialDTO itemDTO = new ItemCursoHistorialDTO();
            itemDTO.setIdOperacion(vo.getIdOperacionVO().getIdOperacion());
            itemDTO.setFecInicio(dateFormat.format(vo.getIdOperacionVO().getFechaInicioOp()));
            itemDTO.setFecFin(dateFormat.format(vo.getIdOperacionVO().getFechaFinOp()));
            itemDTO.setCodOperacion(vo.getIdOperacionVO().getCodigoOperacion());
            itemDTO.setNomCurso(vo.getIdOperacionVO().getIdCursoEspVO().getNomCursoEspecifico() + " - " + vo.getIdOperacionVO().getIdCursoEspVO().getNumSesCursoEspecifico() + " sesiones");
            if (tipo.equals(Constants.SUBTIPO_NOM_ESTADO_OPE_ALU_INACTIVO)) {
                listLLevados.add(itemDTO);
            } else {
                listCursando.add(itemDTO);
            }
        }
        historialDTO.setListCursoCursando(listCursando);
        historialDTO.setListCursoLlevado(listLLevados);
        return historialDTO;
    }*/
}
