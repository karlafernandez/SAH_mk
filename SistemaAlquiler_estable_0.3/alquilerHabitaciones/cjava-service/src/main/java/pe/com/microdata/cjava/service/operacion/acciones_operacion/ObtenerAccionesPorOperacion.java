/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.operacion.acciones_operacion;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import pe.com.microdata.cjava.common.base.Constants;

import pe.com.microdata.cjava.dataaccess.model.operacion.alquilado.AlquilarVO;
import pe.com.microdata.cjava.service.operacion.acciones_operacion.dto.OperAccionBaseDTO;



public class ObtenerAccionesPorOperacion<T extends OperAccionBaseDTO>  {
        
    public static final Integer INTERFACE_ASIGNACION_ALUMNOS = 1;
    public static final Integer INTERFACE_ASIGNACION_INSTRUCTOR = 2;
    public static final Integer INTERFACE_PROGRAMACION_SESIONES = 3;
    public static final Integer INTERFACE_REPROGRAMACION_SESIONES = 4;
    public static final Integer INTERFACE_CREACION_SESIONES = 5;
    public static final Integer INTERFACE_PROGRAMACION_EVENTOS = 6;
    public static final Integer INTERFACE_REGISTRO_ABANDONO = 7;
    public static final Integer INTERFACE_ACTIVAR_ENCUESTA = 8;
    public static final Integer INTERFACE_ENTREGA_CERTIFICADOS_ESPECIFICO = 9;
    public static final Integer INTERFACE_EDITAR_FECHA = 10;
    public static final Integer INTERFACE_REGISTRO_JUSTIFICACION = 11;
    public static final Integer INTERFACE_REGISTRO_CRITERIO_CALIFICATIVO = 12;
    public static final Integer INTERFACE_LISTA_EVENTO = 13;
    public static final Integer INTERFACE_LISTA_ABANDONO = 14;        
    public static final Integer INTERFACE_LISTA_CRONOGRAMA = 15;
    public static final Integer INTERFACE_LISTA_JUSTIFICACION = 16;
    public static final Integer INTERFACE_APERTURA_CURSO = 17;
    
    private static final Integer ESTADO_APERTURA = 101;
    private static final Integer ESTADO_INICIADO_MENOR_FECHA_FIN = 102;    
    private static final Integer ESTADO_INICIADO_MAYOR_FECHA_FIN_MENOR_21 = 103;
    private static final Integer ESTADO_INICIADO_MAYOR_FECHA_FIN_MAYOR_21 = 104;
    private static final Integer ESTADO_FINALIZADO = 105;
    
    private static final Integer CANTIDAD_DIAS = 21;
    
    private Map<Integer, Map<Integer, OperAccionBaseDTO>> mapDobleKey;
    private SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.FORMATO_FECHA);
    
    public ObtenerAccionesPorOperacion(){
        this.mapDobleKey = new HashMap<Integer, Map<Integer, OperAccionBaseDTO>>();
        generarPermisosParaEstadoAperturado();
        generarPermisosParaEstadoIniciadoMenorFechaFin();
        generarPermisosParaEstadoIniciadoMayorFechaFinMenor21();
        generarPermisosParaEstadoIniciadoMayorFechaFinMayor21();
        generarPermisosParaEstadoFinalizado();        
    }
                    
    public void obtenerAccionesSegunEstadoPorOperacion(AlquilarVO vo, Integer nomInterface, T dtoGUI){
        Integer tipoEstado = null;
        if(vo.getIdEstadoVO().getIdSubTipo() == Constants.SUBTIPO_ESTADO_OPE_ALU_APERTURA){
            dtoGUI.setMetodoBoton("guardar");                        
            tipoEstado = ESTADO_APERTURA;
        }else if(vo.getIdEstadoVO().getIdSubTipo() == Constants.SUBTIPO_ESTADO_OPE_ALU_ACTIVO){           
            long diferentDays = diferenciaDiasEntreFechaVOyFechaActual(vo.getFechaFinOp());
            if(diferentDays <= 0){
                dtoGUI.setMetodoBoton("cerrarOpe");
                dtoGUI.setDisabledBoton("disabled=\"true\"");
                tipoEstado = ESTADO_INICIADO_MENOR_FECHA_FIN;
            }else if(diferentDays > 0 && diferentDays <= CANTIDAD_DIAS){
                tipoEstado = ESTADO_INICIADO_MAYOR_FECHA_FIN_MENOR_21;
                dtoGUI.setMetodoBoton("cerrarOpe");
                dtoGUI.setDisabledBoton("disabled=\"true\"");
            }else if(diferentDays > CANTIDAD_DIAS ){
                dtoGUI.setMetodoBoton("cerrarOpe");
                dtoGUI.setDisabledBoton("");
                tipoEstado = ESTADO_INICIADO_MAYOR_FECHA_FIN_MAYOR_21;
            }                                    
        }else if(vo.getIdEstadoVO().getIdSubTipo() == Constants.SUBTIPO_ESTADO_OPE_ALU_FINALIZADO){
            dtoGUI.setMetodoBoton("cerrarOpe");
            dtoGUI.setDisabledBoton("");
            tipoEstado = ESTADO_FINALIZADO;
        }
        OperAccionBaseDTO dto = mapDobleKey.get(tipoEstado).get(nomInterface);
        if(dto == null )
            dto = setearObtenerAccionDTOSiEsNulo();
        dtoGUI.setPermisoFunc1(dto.getPermisoFunc1());
        dtoGUI.setPermisoFunc2(dto.getPermisoFunc2());
        dtoGUI.setFueraPermisoVista(dto.getFueraPermisoVista());
        dtoGUI.setMotivoVista(dto.getMotivoVista());
    }
    /*
    public void obtenerAccionesSegunEstadoPorOperacion(AlquilarVO vo, Integer nomInterface, T dtoGUI){
        Integer tipoEstado = null;
        if(vo.getIdEstadoVO().getIdSubTipo() == Constants.SUBTIPO_ESTADO_OPE_ALU_APERTURA){
            dtoGUI.setMetodoBoton("guardar");                        
            tipoEstado = ESTADO_APERTURA;
        }else if(vo.getIdEstadoVO().getIdSubTipo() == Constants.SUBTIPO_ESTADO_OPE_ALU_ACTIVO){           
            long diferentDays = diferenciaDiasEntreFechaVOyFechaActual(vo.getFechaFinOp());
            if(diferentDays <= 0){
                dtoGUI.setMetodoBoton("cerrarOpe");
                dtoGUI.setDisabledBoton("disabled=\"true\"");
                tipoEstado = ESTADO_INICIADO_MENOR_FECHA_FIN;
            }else if(diferentDays > 0 && diferentDays <= CANTIDAD_DIAS){
                tipoEstado = ESTADO_INICIADO_MAYOR_FECHA_FIN_MENOR_21;
                dtoGUI.setMetodoBoton("cerrarOpe");
                dtoGUI.setDisabledBoton("disabled=\"true\"");
            }else if(diferentDays > CANTIDAD_DIAS ){
                dtoGUI.setMetodoBoton("cerrarOpe");
                dtoGUI.setDisabledBoton("");
                tipoEstado = ESTADO_INICIADO_MAYOR_FECHA_FIN_MAYOR_21;
            }                                    
        }else if(vo.getIdEstadoVO().getIdSubTipo() == Constants.SUBTIPO_ESTADO_OPE_ALU_FINALIZADO){
            dtoGUI.setMetodoBoton("cerrarOpe");
            dtoGUI.setDisabledBoton("");
            tipoEstado = ESTADO_FINALIZADO;
        }
        OperAccionBaseDTO dto = mapDobleKey.get(tipoEstado).get(nomInterface);
        if(dto == null )
            dto = setearObtenerAccionDTOSiEsNulo();
        dtoGUI.setPermisoFunc1(dto.getPermisoFunc1());
        dtoGUI.setPermisoFunc2(dto.getPermisoFunc2());
        dtoGUI.setFueraPermisoVista(dto.getFueraPermisoVista());
        dtoGUI.setMotivoVista(dto.getMotivoVista());
    }
    */
    private void generarPermisosParaEstadoAperturado(){
        Map<Integer, OperAccionBaseDTO> mapIni = new HashMap<Integer, OperAccionBaseDTO>();
        mapIni.put(INTERFACE_ASIGNACION_ALUMNOS, construirOperAccDTOBasadoPermisoFuncion(Boolean.TRUE, Boolean.TRUE));
        mapIni.put(INTERFACE_ASIGNACION_INSTRUCTOR, construirOperAccDTOBasadoPermisoFuncion(Boolean.TRUE, Boolean.FALSE));
        mapIni.put(INTERFACE_LISTA_CRONOGRAMA, construirOperAccDTOBasadoPermisoFuncion(Boolean.TRUE, Boolean.FALSE));
        mapIni.put(INTERFACE_REGISTRO_ABANDONO, construirOperAccDTOBasadoPermisoVista("El curso no se encuentra iniciado."));
        mapIni.put(INTERFACE_ENTREGA_CERTIFICADOS_ESPECIFICO, construirOperAccDTOBasadoPermisoVista("El curso no se encuentra iniciado."));
        mapIni.put(INTERFACE_REGISTRO_JUSTIFICACION, construirOperAccDTOBasadoPermisoVista("El curso no se encuentra iniciado."));
        mapIni.put(INTERFACE_REGISTRO_CRITERIO_CALIFICATIVO, construirOperAccDTOBasadoPermisoFuncion(Boolean.TRUE, Boolean.FALSE));
        mapIni.put(INTERFACE_LISTA_EVENTO, construirOperAccDTOBasadoPermisoFuncion(Boolean.TRUE, Boolean.FALSE));        
        mapIni.put(INTERFACE_LISTA_JUSTIFICACION, construirOperAccDTOBasadoPermisoFuncion(Boolean.TRUE, Boolean.FALSE));        
        mapDobleKey.put(ESTADO_APERTURA, mapIni);
    }
    
    private void generarPermisosParaEstadoIniciadoMenorFechaFin(){
        Map<Integer, OperAccionBaseDTO> mapIni = new HashMap<Integer, OperAccionBaseDTO>();
        mapIni.put(INTERFACE_ASIGNACION_ALUMNOS, construirOperAccDTOBasadoPermisoFuncion(Boolean.TRUE, Boolean.TRUE));
        mapIni.put(INTERFACE_ASIGNACION_INSTRUCTOR, construirOperAccDTOBasadoPermisoFuncion(Boolean.TRUE, Boolean.FALSE));
        mapIni.put(INTERFACE_CREACION_SESIONES, construirOperAccDTOBasadoPermisoVista("Ya se inicio el curso imposible crear un cronograma."));
        mapIni.put(INTERFACE_ENTREGA_CERTIFICADOS_ESPECIFICO, construirOperAccDTOBasadoPermisoVista("Aun no se ha dictado la ultima fecha de clases para entregar certificados."));
        mapIni.put(INTERFACE_EDITAR_FECHA, construirOperAccDTOBasadoPermisoVista("El curso ya se encuentra iniciado."));
        mapIni.put(INTERFACE_LISTA_EVENTO, construirOperAccDTOBasadoPermisoFuncion(Boolean.TRUE, Boolean.FALSE));
        mapIni.put(INTERFACE_LISTA_ABANDONO, construirOperAccDTOBasadoPermisoFuncion(Boolean.TRUE, Boolean.FALSE));
        mapIni.put(INTERFACE_LISTA_JUSTIFICACION, construirOperAccDTOBasadoPermisoFuncion(Boolean.TRUE, Boolean.FALSE));
        mapIni.put(INTERFACE_LISTA_CRONOGRAMA, construirOperAccDTOBasadoPermisoFuncion(Boolean.FALSE, Boolean.FALSE));        
        mapDobleKey.put(ESTADO_INICIADO_MENOR_FECHA_FIN, mapIni);
    }
    
    private void generarPermisosParaEstadoIniciadoMayorFechaFinMenor21(){
        Map<Integer, OperAccionBaseDTO> mapIni = new HashMap<Integer, OperAccionBaseDTO>();
        mapIni.put(INTERFACE_ASIGNACION_ALUMNOS, construirOperAccDTOBasadoPermisoFuncion(Boolean.FALSE, Boolean.TRUE));
        mapIni.put(INTERFACE_REPROGRAMACION_SESIONES, construirOperAccDTOBasadoPermisoVista("El curso ya termino imposible reprogramar sesiones"));
        mapIni.put(INTERFACE_CREACION_SESIONES, construirOperAccDTOBasadoPermisoVista("El curso ya termino imposible crear cronograma"));
        mapIni.put(INTERFACE_PROGRAMACION_EVENTOS, construirOperAccDTOBasadoPermisoVista("El curso ya termino imposible programar eventos"));
        mapIni.put(INTERFACE_ACTIVAR_ENCUESTA, construirOperAccDTOBasadoPermisoVista("El curso ya termino imposible activar encuesta"));
        mapIni.put(INTERFACE_ENTREGA_CERTIFICADOS_ESPECIFICO, construirOperAccDTOBasadoPermisoFuncion(Boolean.TRUE, Boolean.FALSE));
        mapIni.put(INTERFACE_EDITAR_FECHA, construirOperAccDTOBasadoPermisoVista("El curso ya termino imposible editar su fecha inicio y fin"));
        mapIni.put(INTERFACE_LISTA_ABANDONO, construirOperAccDTOBasadoPermisoFuncion(Boolean.TRUE, Boolean.FALSE));
        mapIni.put(INTERFACE_LISTA_JUSTIFICACION, construirOperAccDTOBasadoPermisoFuncion(Boolean.TRUE, Boolean.FALSE));
        mapDobleKey.put(ESTADO_INICIADO_MAYOR_FECHA_FIN_MENOR_21, mapIni);
    }
    
    private void generarPermisosParaEstadoIniciadoMayorFechaFinMayor21(){
        Map<Integer, OperAccionBaseDTO> mapIni = new HashMap<Integer, OperAccionBaseDTO>();
        mapIni.put(INTERFACE_ASIGNACION_ALUMNOS, construirOperAccDTOBasadoPermisoFuncion(Boolean.FALSE, Boolean.TRUE));
        mapIni.put(INTERFACE_REPROGRAMACION_SESIONES, construirOperAccDTOBasadoPermisoVista("El curso ya termino imposible reprogramar sesiones"));
        mapIni.put(INTERFACE_CREACION_SESIONES, construirOperAccDTOBasadoPermisoVista("El curso ya termino imposible crear cronograma"));
        mapIni.put(INTERFACE_PROGRAMACION_EVENTOS, construirOperAccDTOBasadoPermisoVista("El curso ya termino imposible programar eventos"));
        mapIni.put(INTERFACE_ACTIVAR_ENCUESTA, construirOperAccDTOBasadoPermisoVista("El curso ya termino imposible activar encuesta"));
        mapIni.put(INTERFACE_ENTREGA_CERTIFICADOS_ESPECIFICO, construirOperAccDTOBasadoPermisoFuncion(Boolean.TRUE, Boolean.FALSE));
        mapIni.put(INTERFACE_EDITAR_FECHA, construirOperAccDTOBasadoPermisoVista("El curso ya termino imposible editar su fecha inicio y fin"));
        mapIni.put(INTERFACE_LISTA_ABANDONO, construirOperAccDTOBasadoPermisoFuncion(Boolean.FALSE, Boolean.FALSE));
        mapIni.put(INTERFACE_LISTA_JUSTIFICACION, construirOperAccDTOBasadoPermisoFuncion(Boolean.TRUE, Boolean.FALSE));
        mapIni.put(INTERFACE_REGISTRO_ABANDONO, construirOperAccDTOBasadoPermisoVista("La fecha actual ya supero las 3 semanas posibles para realizar cambios"));
        mapIni.put(INTERFACE_REGISTRO_JUSTIFICACION, construirOperAccDTOBasadoPermisoVista("La fecha actual ya supero las 3 semanas posibles para realizar cambios  "));
        mapDobleKey.put(ESTADO_INICIADO_MAYOR_FECHA_FIN_MAYOR_21, mapIni);
    }
    
    private void generarPermisosParaEstadoFinalizado(){
        Map<Integer, OperAccionBaseDTO> mapIni = new HashMap<Integer, OperAccionBaseDTO>();       
        mapIni.put(INTERFACE_REPROGRAMACION_SESIONES, construirOperAccDTOBasadoPermisoVista("El curso ya termino imposible reprogramar sesiones"));
        mapIni.put(INTERFACE_CREACION_SESIONES, construirOperAccDTOBasadoPermisoVista("El curso ya termino imposible crear cronograma"));
        mapIni.put(INTERFACE_REGISTRO_ABANDONO, construirOperAccDTOBasadoPermisoVista("El curso ya finalizo imposible registrar abandonos"));
        mapIni.put(INTERFACE_PROGRAMACION_EVENTOS, construirOperAccDTOBasadoPermisoVista("El curso ya termino imposible programar eventos"));
        mapIni.put(INTERFACE_ACTIVAR_ENCUESTA, construirOperAccDTOBasadoPermisoVista("El curso ya termino imposible activar encuesta"));
        mapIni.put(INTERFACE_ENTREGA_CERTIFICADOS_ESPECIFICO, construirOperAccDTOBasadoPermisoFuncion(Boolean.TRUE, Boolean.FALSE));
        mapIni.put(INTERFACE_EDITAR_FECHA, construirOperAccDTOBasadoPermisoVista("El curso ya termino imposible editar su fecha inicio y fin"));
        mapIni.put(INTERFACE_APERTURA_CURSO, construirOperAccDTOBasadoPermisoVista("Sr. administrador tiene que cerrar el curso obligadamente"));
        mapIni.put(INTERFACE_REGISTRO_JUSTIFICACION, construirOperAccDTOBasadoPermisoVista("El curso ya finalizo."));
        mapDobleKey.put(ESTADO_FINALIZADO, mapIni);
    }

    
    private OperAccionBaseDTO construirOperAccDTOBasadoPermisoFuncion(Boolean a, Boolean b){
        OperAccionBaseDTO dto = new OperAccionBaseDTO();
        dto.setPermisoFunc1(a);
        dto.setPermisoFunc2(b);
        dto.setFueraPermisoVista(Boolean.FALSE);
        dto.setDisabledBoton("");
        dto.setMetodoBoton("");        
        dto.setMotivoVista("");
        return dto;
    }
            
    private OperAccionBaseDTO construirOperAccDTOBasadoPermisoVista(String motivo){
        OperAccionBaseDTO dto = new OperAccionBaseDTO();
        dto.setPermisoFunc1(Boolean.FALSE);
        dto.setPermisoFunc2(Boolean.FALSE);
        dto.setFueraPermisoVista(Boolean.TRUE);
        dto.setDisabledBoton("");
        dto.setMotivoVista(motivo);
        dto.setMetodoBoton("");
        return dto;        
    }
    
    private long diferenciaDiasEntreFechaVOyFechaActual(Date x){
        long result = 0;
        try {
            Date fechaActual = dateFormat.parse(dateFormat.format(Calendar.getInstance().getTime()));
            result = fechaActual.getTime() - x.getTime();
            result = TimeUnit.DAYS.convert(result, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    private OperAccionBaseDTO setearObtenerAccionDTOSiEsNulo(){
        OperAccionBaseDTO dto = new OperAccionBaseDTO();
        dto.setPermisoFunc1(Boolean.FALSE);
        dto.setPermisoFunc2(Boolean.FALSE);
        dto.setFueraPermisoVista(Boolean.FALSE);
        dto.setDisabledBoton("");
        dto.setMetodoBoton("");
        dto.setMotivoVista("");
        return dto;
    }
}
