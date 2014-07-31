package pe.com.microdata.cjava.common.base;

public class Constants {

    public final static int TAMANIO_FOTO = 524288;
    public final static int CANT_FILAS = 10;
    public final static String FORMATO_JPG = "image/jpeg";
    public final static String FORMATO_PNG = "image/png";
    public final static String FORMATO_GIF = "image/gif";
    public final static String FORMATO_FECHA = "dd/MM/yyyy";
    public final static String FORMATO_FECHA_CALENDAR = "yyyy-MM-dd";
    public final static String FORMATO_HORA = "HH:mm";
    public final static String FORMATO_HORA_SEGUNDO = "HH:mm:ss";
    public final static String FORMATO_FECHA_HORA = "dd/MM/yyyy HH:mm";
    public final static int ID_PAIS_PERU = 1;
    public final static String LOCALE_ES = "ES";
    public final static String CMD_CREAR = "crear";
    public final static String CMD_MODIFICAR = "modificar";
    public final static String CMD_ELIMINAR = "eliminar";
    public static final int ANHO_OFFSET_PLUS = 10;
    public static final int ANHO_OFFSET_MINUS = 10;
    /**
     * *
     * REDONDEO
     */
    public static final String ESCALA_REDONDEO_TRABAJO = "6";
    public static final String ESCALA_REDONDEO_VISTA = "2";
    /**
     * REDIRECT
     */
    public static final String REDIRECT_WEB_LOGIN = "";
    public static final String REDIRECT_WEB_PRINCIPAL = "principal.html";
    public static final String REDIRECT_WEB_PRIMER_LOGIN = "primer-login-usuario.html";
    public static final String REDIRECT_ADM_LOGIN = "";
    public static final String REDIRECT_ADM_PRINCIPAL = "principal.html";
    public static final String REDIRECT_ADM_PRIMER_LOGIN = "primer-login-usuario.html";
    /**
     * *
     * ID DE TIPOS
     */
    public static final Integer TIPO_DOCUMENTO = 1;
    public static final Integer TIPO_CENTRO_ED = 2;
    public static final Integer TIPO_NIVEL_EST = 3;
    public static final Integer TIPO_TELEF = 4;
    public static final Integer TIPO_TURNO = 5;
    public static final Integer TIPO_REGISTRO_OPE_ALU = 6;
    public static final Integer TIPO_ESTADO_OPE_ALU = 7;
    public static final Integer TIPO_CALIFICACION = 8;
    public static final Integer TIPO_ASISTENCIA = 9;
    public static final Integer TIPO_PREGUNTA = 10;
    public static final Integer TIPO_OCUPACION = 11;
    public static final Integer TIPO_ESTADO_OPERACION = 12;
    /**
     * *
     * ID DE SUB TIPOS
     */
    public static final Integer SUBTIPO_ASISTENCIA_ASISTIO = 26;
    public static final Integer SUBTIPO_ASISTENCIA_FALTO = 27;
    public static final Integer SUBTIPO_ASISTENCIA_JUSTIFICO = 28;
    public static final Integer SUBTIPO_ESTADO_OPE_ALU_APERTURA = 39;
    public static final Integer SUBTIPO_ESTADO_OPE_ALU_ACTIVO = 40;
    public static final Integer SUBTIPO_ESTADO_OPE_ALU_FINALIZADO = 41;
    public static final String SUBTIPO_NOM_ESTADO_OPE_ALU_APERTURA = "APERTURADO";
    public static final String SUBTIPO_NOM_ESTADO_OPE_ALU_ACTIVO = "INICIADO";
    public static final String SUBTIPO_NOM_ESTADO_OPE_ALU_INACTIVO = "INACTIVO";
    public static final String SUBTIPO_ASISTENCIA_NOM_ASISTIO = "ASISTIO";
    public static final String SUBTIPO_ASISTENCIA_NOM_FALTO = "FALTA";
    public static final String SUBTIPO_ASISTENCIA_NOM_JUSTIFICO = "JUSTIFICO";
    public static final String SUBTIPO_NOM_USER_ALUMNO = "ALUMNO";

    /**
     * *
     * FORMATOS PARA JASPERREPORT
     */
    public static final String JR_PDF = "pdf";
    public static final String JR_CSV = "csv";
    public static final String JR_XLS = "xls";
    public static final String JR_HTML = "html";
    /**
     * *
     * OPERACIONES SQL
     */
    public static final int OPE_LIKE = 1;
    public static final int OPE_EQ = 2;
    public static final int OPE_GE = 3;
    public static final int OPE_LE = 4;
    public static final int OPE_NE = 5;
    public static final int OPE_LIKE_INICIO = 6;
    public static final int OPE_GT = 7;
    public static final int OPE_LT = 8;
    public static final int OPE_NULL = 9;
    //
    public static final int TYPE_INTEGER = 1;
    public static final int TYPE_STRING = 2;
    public static final int TYPE_DATE = 3;
    public static final int TYPE_BIG_INTEGER = 4;
    public static final int TYPE_CALENDAR = 5;
    public static final int TYPE_CHARACTER = 6;
    //
    public static final int LOG_OR = 1;
    public static final int LOG_AND = 2;
    //
    public static final String ORD_ASCENDENTE = "asc";
    public static final String ORD_DESCENDENTE = "desc";
    public static final String ORD_NINGUNO = "";
    /**
     * *
     * PARAMETROS
     *
     */
    /* SESIONES */
    public static final Integer NUMERO_DIAS_SEMANA = 7;
    public static final Integer ESTADO_OK = 1;
    public static final Boolean REPROGRAMACION_MOVER_FECHA = false;
    public static final Boolean REPROGRAMACION_RECORRER_CRONOGRAMA = true;
    /* USUARIOS */
    public static final Integer SUBTIPO_USER_ADMINISTRADOR = 42;
    public static final Integer SUBTIPO_USER_INSTRUCTOR = 43;
    public static final Integer SUBTIPO_USER_ALUMNO = 44;
    public static final Boolean USUARIO_ESTADO_BLOQUEADO = true;
    public static final Boolean USUARIO_ESTADO_NO_BLOQUEADO = false;
    public static final Boolean USUARIO_ESTADO_NO_ELIMINADO = false;
    public static final Boolean USUARIO_ESTADO_ELIMINADO = true;
    /* BUSQUEDAS*/
    public static final Integer BUSQUEDA_TOTAL = 0;
    /*OPERACION*/
    public static final Boolean OPERACION_ESTADO_CON_SESION = Boolean.TRUE;
    public static final Boolean OPERACION_ESTADO_SIN_SESION = Boolean.FALSE;
    public static final Integer OPERACION_CANTIDAD_MINIMA_ALUMNO = 5;
    public static final Integer OPERACION_CANTIDAD_MINIMA_INSTRUCTOR = 1;
    public static final Boolean OPERACION_NO_BORRADA = Boolean.TRUE;
    public static final Boolean OPERACION_BORRADA = Boolean.FALSE;
    public static final String OPERACION_MSG_DEBE_CERRAR_CURSO = " ahora.";
    public static final Integer OPERACION_DIAS_CONFIGURABLE = 14;
    public static final Integer OPERACION_DIAS_MAXIMO_LLENAR = 21;

    /*OPERACION ALUMNO*/
    public static final String ASISTENCIA = "A";
    public static final String FALTA = "F";
    public static final Integer HISTORIAL_CURSO_LLEVO = 0;
    public static final Integer HISTORIAL_CURSO_CURSANDO = 1;

    public final static String ACCION_SAVE = "saveOrUpdate";
    public final static String ACCION_INSERT = "insert";
    public final static String ACCION_UPDATE = "update";
    public final static String ACCION_DELETE = "delete";
    public final static String ACCION_LOGIN_SUCCESS = "login - success";
    public final static String ACCION_LOGIN_ERROR = "login - error";

    public static final Integer IND_ABANDONO = 1;
    public static final String ABANDONO = "ABANDONÓ";
    public static final String NO_ABANDONO = "NO ABANDONÓ";
    
    public static final Integer IND_CERTIFICADO = 1;
    public static final String ENTREGO_CERTIFICADO = "SI";
    public static final String NO_ENTREGO_CERTIFICADO = "NO";

    /*CERTIFICADO*/
    public static final Double CERTIFICADO_PORCENTAJE_MINIMO_ASISTENCIA = 80.00;
    public static final Double CERTIFICADO_NOTA_MINIMA_APROBATORIA = 13.00;
    public static final String CERTIFICADO_ASISTENCIA_NO_MINIMO = "No llego al minimo";
    public static final String CERTIFICADO_NOTA_DESAPROBADO = "desaprobado";
    public static final String CERTIFICADO_NOTA_APROBADO = "aprobado";
    public static final String CERTIFICADO_GENERAL_MODEL = "modelCertiGeneral";
    public static final Integer CERTIFICADO_VALOR_ENTREGO_CERTI = 1;
    public static final Integer CERTIFICADO_VALOR_NO_ENTREGO_CERTIFICADO = 0;

    /*REPORTE ASISTENCIA*/
    public static final Integer TOTAL_ASISTENCIA_KEY = -1;
    public static final Integer MIN_ALTO_REPORTE = 150;
    public static final String REPORTE_FIELD_NAME = "column";

    /*ENCUESTAS*/
    public static final Integer SUBTIPO_PREGUNTA_SI_NO = 29;
    public static final Integer SUBTIPO_PREGUNTA_SI_NO_LLENAR = 30;
    public static final Integer SUBTIPO_PREGUNTA_MARCAR5 = 31;
    public static final Integer SUBTIPO_PREGUNTA_MARCAR_Y_LLENAR = 32;
    public static final Integer SUBTIPO_PREGUNTA_LLENAR = 33;
    public static final Integer SUBTIPO_PREGUNTA_LLENAR_TABLA = 47;
    public static final Integer ID_ENCUESTA = 1;
    public static final String ENC_NOM_PREG_CURSO = "CURSO QUE LE GUSTARIA LLEVAR EN CJAVA";
    public static final String ENC_NOM_PREG_RECOMENDACION = "RECOMENDACIONES Y/O SUGERENCIAS";

    /*CERTIFICADO CURSO GENERAL */
    public static final String CURSO_GENERA_NO_LLEVO = "NO LLEVO";
    public static final String CURSO_GENERAL_SESION_ENTREGO = "modelCurGenListaEntre";
    public static final Float NOTA_MAXIMA = Float.valueOf("20");
    public static final Float NOTA_MINIMA = Float.valueOf("0");
    public static final Integer NOTA_MINIMA_APROBATORIA = 13;
    public static final Integer PORCENTAJE_MINIMO_ARPOBATORIO = 80;

    public static final Integer SUBTIPO_PREGUNTAS_IGUALES = 45 ;
    public static final Integer SUBTIPO_PREGUNTAS_DIF = 46 ;
    
    /*ALTERNATIVAS*/
    public static final String ALT_DES_SIEMPRE = "Siempre";
    public static final String ALT_DES_CASI_SIEMPRE = "Casi siempre";
    public static final String ALT_DES_ALG_VECES = "Algunas Veces";
    public static final String ALT_DES_POCAS_VECES = "Pocas veces";
    public static final String ALT_DES_NADA = "Nada";
    
    public static final String ALT_DES_MUY_BUENO = "Muy Bueno";
    public static final String ALT_DES_BUENO = "Bueno";
    public static final String ALT_DES_REGULAR = "Regular";
    public static final String ALT_DES_MALO = "Malo";
    public static final String ALT_DES_MUY_MALO = "Muy Malo";
    
    public static final String ALT_EVAL_FINAL = "EVALUACIÓN FINAL";
    
    public static final Integer ALT_PON_5 = 20;
    public static final Integer ALT_PON_4 = 15;
    public static final Integer ALT_PON_3 = 10;
    public static final Integer ALT_PON_2 = 5;
    public static final Integer ALT_PON_1 = 0;
    
    public static final Integer CANT_ALT_MARCAR5 = 5;
    
    /*PREGUNTA*/
    public static final Integer ID_PREGUNTA_CURSO = 26;
    public static final Integer ID_PREGUNTA_RECOMENDACION = 29;
    
    /*DIMINUTIVOS DE LOS DIAS*/
    public  static final  String DIM_DIA_LUNES = "Lun";
    public  static final  String DIM_DIA_MARTES = "Mar";
    public  static final  String DIM_DIA_MIERCOLES = "Mie";
    public  static final  String DIM_DIA_JUEVES = "Jue";
    public  static final  String DIM_DIA_VIERNES = "Vier";
    public  static final  String DIM_DIA_SABADO= "Sáb";
    public  static final  String DIM_DIA_DOMINGO= "Dom";
       
    /*TIPOS DE VALORES PARA ACTUALIZAR PORCENTAJE*/
    public static final Integer NO_ACTUALIZAR_PORCENTAJE = -999;
    
    public static final Integer CANT_FILTROS_RECORD = 7;
    
}
