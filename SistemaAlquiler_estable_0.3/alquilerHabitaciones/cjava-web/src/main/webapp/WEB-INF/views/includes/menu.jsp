<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<link href="css/dropdown/dropdown.css" media="screen" rel="stylesheet" type="text/css" />
<link href="css/dropdown/themes/vimeo.com/default.advanced.css" media="screen" rel="stylesheet" type="text/css" />
<link href="css/helper.css" media="screen" rel="stylesheet" type="text/css" />  
<div class="container-fluid subbanner well-small"> 
    <div class="row-fluid div-header">
        <div class="span4">
            <strong>Usuario:&nbsp;</strong>${userDetails.nomNombre}
        </div>
<!--        <div class="span3 hidden-phone">
            <strong>Cargo:&nbsp;</strong>${userDetails.nomCargo}
        </div>
        <div class="span2 hidden-phone">
            <strong>Area:&nbsp;</strong>Académica
        </div>
        <div class="span1 hidden-phone">
            <strong>BD:&nbsp;</strong> Cjava
        </div>-->
        <div class="span2 hidden-phone">
            <strong> Fecha:&nbsp;</strong>${userDetails.fecha}
        </div>

    </div>
</div>
<div class="menu clearfix fix" >
    <ul id="nav" class="dropdown dropdown-horizontal">
        <li><a href="principal.html">Inicio</a></li>
            <%--<sec:authorize access="hasAnyRole('MOD_ADM_LISTAR_INSTRUCTOR', 'MOD_ADM_LISTAR_ALUMNOS', 'MOD_ADM_LISTAR_CUR_ESP', 'MOD_ADM_LISTAR_CUR_GEN', 'MOD_ADM_LISTAR_EMPRESAS', 'MOD_ADM_LISTAR_ENCUESTAS', 'MOD_ADM_LISTAR_ADMINISTRADORES')">--%> 
            <li class="dir" >Cliente
                <ul> 
                    <sec:authorize access="hasAnyRole('MOD_ADM_LISTAR_CUR_ESP', 'MOD_ADM_LISTAR_CUR_GEN')"> 
                        <li><a href="lista-cuarto.html">Ver Habitaciones</a></li> 
                        <li><a href="lista-curso-especifico.html">Registro Cursos Especifico</a></li>                               
                        <li><a href="registrarClientes.html">Registro Clientes</a></li>                                               
                       <li><a href="registrarClientes.html">Registro Arrendatarios</a></li>                                               
                    </sec:authorize>
                    
                   <%--             
                     <sec:authorize access="hasRole('MOD_ADM_LISTAR_ALUMNOS')">
                        <li>
                            <a href="listarAlumnos.html">Registro Alumnos</a>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('MOD_ADM_LISTAR_INSTRUCTOR')">
                        <li>
                            <a href="listarInstructores.html">Registro Instructores</a>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('MOD_ADM_LISTAR_EMPRESAS')">
                        <li>
                            <a href="lista-empresa.html">Registro Empresas</a>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('MOD_ADM_LISTAR_ADMINISTRADORES')">
                        <li>
                            <a href="listar-administrador.html">Registro Administradores</a>
                        </li>
                    </sec:authorize>--%>
                </ul>
            </li>                    
        <%--</sec:authorize>--%>

        <sec:authorize access="hasAnyRole('MOD_OPE_LISTAR_CURSO_ACTIVO_APERTURADO')">    
            <li class="dir" >Arrendatario
                <ul> 
                    <li class="dir"> Agregar Habitaciones
                        <ul>
                            <%--<sec:authorize access="hasRole('MOD_OPE_LISTAR_CURSO_ACTIVO_APERTURADO')">--%>
                                <li>
                                    <a href="lista-curso-operacion.html">Programación de Cursos</a>
                                </li>                               
                            <%--</sec:authorize>--%>                                                    
                        </ul>
                    </li>
                    <%--<sec:authorize access="hasRole('MOD_OPE_ESCOGER_ALUMNOS_PARA_CURSO_GENERAL')">--%>
                        <li class="dir">Certificados Generales
                            <ul>
                                <li><a href="escoger-curso-general.html">Consulta Certificadost Generales</a></li>                               
                                <li><a href="lista-certificado-general.html">Lista Entregado</a></li>                                               
                            </ul>         
                        </li>
                    <%--</sec:authorize>--%>
                </ul>
            </li> 
        </sec:authorize>
        <%--<sec:authorize access="hasAnyRole('MOD_INS_LISTAR_OPE_INSTR')">--%>
            <li class="dir" >Reservas
                <ul> 
                    <sec:authorize access="hasRole('MOD_INS_LISTAR_OPE_INSTR')">
                        <li>
                            <a href="lista-operacion-instructor.html">Registro de Asistencia</a>
                        </li>                               
                    </sec:authorize>
                    <sec:authorize access="hasRole('MOD_INS_LISTAR_OPE_INSTR')">
                        <li>
                            <a href="lista-cursos-calificacion.html">Asignar Calificaciones</a>
                        </li>                                              
                    </sec:authorize>
                </ul>
            </li> 
        <%--</sec:authorize>--%>
       
  <%--
        <sec:authorize access="hasAnyRole('MOD_SEG_LISTA_ACCESO','MOD_SEG_LISTA_ADMINISTRADOR','MOD_SEG_LISTA_ALUMNO')">
            <li class="dir"> Seguridad
                <ul> 
                    <sec:authorize access="hasRole('MOD_SEG_LISTA_ADMINISTRADOR')">
                        <li>
                            <a href="listar_seg_administrador.html">Permisos</a>
                        </li>
                    </sec:authorize>                        
                    <sec:authorize access="hasRole('MOD_SEG_LISTA_ACCESO')">
                        <li>
                            <a href="listar_adm_instructor.html">Permiso de Instructores</a>
                        </li>                               
                    </sec:authorize>
                    <sec:authorize access="hasRole('MOD_SEG_LISTA_ALUMNO')">
                        <li>
                            <a href="listar_adm_alumno.html">Bloqueo de alumnos</a>
                        </li>
                    </sec:authorize>                                            
                </ul>                                        
            </li>
        </sec:authorize>
        <sec:authorize access="hasAnyRole('MOD_OPE_LISTAR_ARCHIVO')">
            <li class="dir" >Archivos
                <ul> 
                    <sec:authorize access="hasRole('MOD_OPE_LISTAR_ARCHIVO')">
                        <li>
                            <a href="gestionar_archivo.html">Listado de Archivos</a>
                        </li>                               
                    </sec:authorize>
                </ul>
            </li> 
        </sec:authorize>
        <sec:authorize access="hasAnyRole('MOD_SEG_LOG_LISTA_EVENTO')">
            <li class="dir" >Auditoria
                <ul>  
                    <sec:authorize access="hasRole('MOD_SEG_LOG_LISTA_EVENTO')">
                        <li>
                            <a href="listar-log.html">Log</a>
                        </li>    
                    </sec:authorize>
                </ul>
            </li> 
        </sec:authorize>
        <li class="dir"> Perfil 
            <ul>
                <li> <a href="cambiar-clave.html">Cambiar contraseña</a> </li>
            </ul>            
        </li>
        <li class="dir"> Ayuda
            <ul> 
                <li><a href="mantenimiento.html">Guía Rápida de Uso</a></li>                               
                <li><a href="mantenimiento.html">Acerca de ...</a></li>                                              
            </ul>                        
        </li>

--%>
    </ul>
</div>
<div> &nbsp;</div><div > &nbsp;</div>

