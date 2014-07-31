

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<sec:authorize access="hasRole('MOD_OPE_DETALLE_CURSO_ACTIVO_APERTURADO')">
    <link el="stylesheet" type="text/css" href="<c:url value="/css/paging.css"/>"/>
    <script src="<c:url value='/js/jquery.paging.js'/>" type="text/javascript"></script>    
    <script src="<c:url value='/js/operacion/operacion/apertura_curso.js'/>" type="text/javascript"></script>     

    <div class="container-fluid fondoGris">

        <div class="row-fluid">
            <div class="span3">
                <a href="lista-curso-operacion.html" class="btn btn-info fa-input" >Volver a Listado</a>       
            </div>       
            <div class="span11 fondoGris">

                <div >
                    <c:url var="url" value="/detalle-curso-apertura.html" />
                    <form:form id="frmApertura" modelAttribute="apertura" action="${url}" cssStyle="margin:auto;">
                        <form:hidden id="idOperacion" path="idOperacion" />                          
                        <fieldset class="min-height">
                            <div  >
                                <legend>${apertura.estadoCurso}</legend>
                                <br>            
                                <div id="table-resumen table table-bordere">
                                    <table style="width: 50%; margin-left: 1%">
                                        <tr>
                                            <td>
                                                <table class="table table-bordered">
                                                    <tr>
                                                        <td class="onlyRead"> CURSO: </td>
                                                        <td> ${apertura.nombreCurso} </td>
                                                        <td class="onlyRead"> FECHA INICIO: </td>
                                                        <td> ${apertura.fechaInicio} </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="onlyRead"> CODIGO: </td>
                                                        <td> ${apertura.codOperacion} </td>
                                                        <td class="onlyRead"> FECHA FIN: </td>
                                                        <td> ${apertura.fechaFin} </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="onlyRead"> # SESIÓN: </td>
                                                        <td> ${apertura.numSesion} </td>
                                                        <td class="onlyRead"> # HORA: </td>
                                                        <td> ${apertura.numHora} </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="onlyRead"> SALÓN: </td>
                                                        <td> ${apertura.nomSalon} </td>
                                                        <td class="onlyRead"> </td>
                                                        <td> </td>
                                                    </tr>
                                                </table>
                                            </td> 
                                        </tr>
                                    </table>
                                </div>

                                <c:if test="${!apertura.cursoFinalizado}">
                                    <c:if test="${apertura.terminoUltimaClase}">
                                        <c:if test="${!apertura.paso21DiasYActivo}">
                                            <div id="div-error" class="message-box info" style="color : red; ">
                                                <strong><h4><spring:message code="msg.operacion.cierre_curso_1"/>${apertura.diasCierre}</h4></strong>
                                                <strong><h4><spring:message code="msg.operacion.cierre_curso_2"/>${apertura.diasCierre}</h4></strong>                                        
                                            </div>
                                        </c:if>
                                        <c:if test="${apertura.paso21DiasYActivo}">
                                            <div id="div-error" class="message-box info" style="color : red; ">                                            
                                                <strong><h4><spring:message code="msg.operacion.cierre_curso_3"/></h4></strong>                                        
                                            </div>
                                        </c:if>
                                    </c:if>                       
                                </c:if>

                                <c:if test="${!apertura.paso21DiasYActivo}">
                                    <div class="span5">
                                        <legend>Requisitos para activar curso</legend>
                                        <br>
                                        <table id ="listado" class="table table-bordered " align="center" name="rsTable">                       
                                            <thead> 
                                                <tr style="background-color:#6ED7D7" >                                       
                                                    <th>Requisito</th>  
                                                    <th>Agregar</th> 
                                                    <th>Cantidad</th> 
                                                    <th>Estado</th>                                                                                                                             
                                                </tr>  
                                            </thead>
                                            <tbody id="bodyEstados">                                                     
                                                <tr>
                                                    <td> Alumnos inscritos </td>
                                                    <td> Agregar Alumnos <a class="btn btn-link fa-input" href="asignar-alumno.html?idOperacion=${estOpe.idOperacion}"><i class="icon-pencil"></i></a> </td>
                                                    <td style="text-align: center;"> ${estOpe.cantAlumnos} </td>
                                                    <td style="text-align: center;"> 
                                                        <c:if test="${estOpe.estAlumnos}"> <i style="color:green;" class="icon-ok"></i> </c:if>
                                                        <c:if test="${!estOpe.estAlumnos}"> <i style="color:red;" class="icon-remove"></i> </c:if>
                                                        </td>                                                
                                                    </tr>       
                                                    <tr>
                                                        <td> Instructores Asignados </td>
                                                        <td> Agregar Instructores <a class="btn btn-link fa-input" href="asignar-instructor.html?idOperacion=${estOpe.idOperacion}"><i class="icon-pencil"></i></a> </td>
                                                    <td style="text-align: center;"> ${estOpe.cantInstructore}</td>   
                                                    <td style="text-align: center;"> 
                                                        <c:if test="${estOpe.estInstructores}"> <i style="color:green;" class="icon-ok"></i> </c:if>
                                                        <c:if test="${!estOpe.estInstructores}"> <i style="color:red;" class="icon-remove"></i> </c:if>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td> Programación de sesiones </td>
                                                        <td> Agregar Sesiones <a class="btn btn-link fa-input" href="listar-cronograma.html?idOperacion=${estOpe.idOperacion}"><i class="icon-pencil"></i></a> </td>
                                                    <td style="text-align: center;"> <spring:message code="lbl.operacion.curso_apertura.cronograma" /> </td>   
                                                    <td style="text-align: center;"> 
                                                        <c:if test="${estOpe.estSesiones}"> <i style="color:green;" class="icon-ok"></i> </c:if>
                                                        <c:if test="${!estOpe.estSesiones}"> <i style="color:red;" class="icon-remove"></i> </c:if>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td> Inasistencias </td>
                                                        <td> Registrar Justificación <a class="btn btn-link fa-input" href="lista-operacion-alumno.html?idOperacion=${estOpe.idOperacion}"><i class="icon-pencil"></i></a> </td>
                                                    <td style="text-align: center;"> <spring:message code="lbl.operacion.curso_apertura.inasistencias" /> </td>   
                                                    <td style="text-align: center;"> <spring:message code="lbl.operacion.curso_apertura.inasistencias" /> </td>
                                                </tr>
                                                <tr>
                                                    <td> Criterio de Calificación </td>
                                                    <td> Registrar porcentajes <a class="btn btn-link fa-input" href="modificar-criterio-calif.html?idOperacion=${estOpe.idOperacion}"><i class="icon-pencil"></i></a> </td>
                                                    <td style="text-align: center;"> <spring:message code="lbl.operacion.curso_apertura.calificaciones" /> </td>   
                                                    <td style="text-align: center;"> 
                                                        <c:if test="${estOpe.estCalificaciones}"> <i style="color:green;" class="icon-ok"></i> </c:if>
                                                        <c:if test="${!estOpe.estCalificaciones}"> <i style="color:red;" class="icon-remove"></i> </c:if>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td> Eventos </td>
                                                        <td> Registro eventos <a class="btn btn-link fa-input" href="listar-evento.html?idOperacion=${estOpe.idOperacion}"><i class="icon-pencil"></i></a> </td>
                                                    <td style="text-align: center;"> <spring:message code="lbl.operacion.curso_apertura.eventos" /> </td>   
                                                    <td style="text-align: center;"> <spring:message code="lbl.operacion.curso_apertura.eventos" /> </td>   
                                                </tr>
                                                <tr>
                                                    <td> Abandono </td>
                                                    <td> Registro abandono <a class="btn btn-link fa-input" href="listar-alumno-abandono.html?idOperacion=${estOpe.idOperacion}"><i class="icon-pencil"></i></a> </td>
                                                    <td style="text-align: center;"> ${estOpe.cantAbandono}</td>   
                                                    <td style="text-align: center;"> <spring:message code="lbl.operacion.curso_apertura.abandono" /> </td>                                               
                                                </tr>
                                                <tr>
                                                    <td> Encuestas </td>
                                                    <td> Activar encuestas <a class="btn btn-link fa-input" href="activar-encuesta.html?idOperacion=${estOpe.idOperacion}"><i class="icon-pencil"></i></a> </td>
                                                    <td style="text-align: center;"> ${estOpe.cantEncuResp}</td>   
                                                    <td style="text-align: center;"> 
                                                        <c:if test="${estOpe.estEncuesta}"> <i style="color:green;" class="icon-ok"></i> </c:if>
                                                        <c:if test="${!estOpe.estEncuesta}"> <i style="color:red;" class="icon-remove"></i> </c:if>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td> Certificados </td>
                                                        <td> Entrega de certificados <a class="btn btn-link fa-input" href="lista-certificado-especifico.html?idOperacion=${estOpe.idOperacion}"><i class="icon-pencil"></i></a> </td>
                                                    <td style="text-align: center;"> ${estOpe.cantCertificados}</td>   
                                                    <td style="text-align: center;">  <spring:message code="lbl.operacion.curso_apertura.certificado" /> </td>                                                                                                   
                                                </tr>
                                                <tr>
                                                    <td> Editar Fecha </td>
                                                    <c:if test="${apertura.editarFecha}">
                                                        <td>Fecha Inicio y fin <a class="btn btn-link fa-input" href="editar-fecha-operacion.html?idOperacion=${estOpe.idOperacion}"><i class="icon-pencil"></i></a></td>     
                                                        <td style="text-align: center;"> <spring:message code="lbl.operacion.curso_apertura.editar_fecha" /> </td>   
                                                        <td style="text-align: center;"> <spring:message code="lbl.operacion.curso_apertura.editar_fecha" /> </td>
                                                    </c:if>

                                                    <c:if test="${!apertura.editarFecha}">
                                                        <td></td>     
                                                        <td> <spring:message code="lbl.operacion.curso_apertura.editar_fecha_no" /> </td>   
                                                        <td> <spring:message code="lbl.operacion.curso_apertura.editar_fecha_curso" /> </td>
                                                    </c:if>                                                                                                
                                                </tr>   

                                            </tbody>
                                        </table> 
                                    </div>
                                </c:if>
                                <br>
                            </div>

                            <c:if test="${apertura.poderModificar}">
                                <div id="divBtnGenerar" class="span12" style="text-align: center">                                                                                       
                                    <c:if test="${apertura.activarCurso}">
                                        <sec:authorize access="hasRole('MOD_OPE_ACTIVAR_CURSO')">
                                            <input id="btnGuardar" type="submit" class="btn btn-info fa-input" name="guardar" value="Iniciar Curso"> &nbsp;
                                        </sec:authorize>
                                    </c:if>

                                    <c:if test="${!apertura.activarCurso}">
                                        <sec:authorize access="hasRole('MOD_OPE_ACTIVAR_CURSO')">
                                            <input id="btnGuardar" type="submit" class="btn btn-info fa-input" name="guardar" value="Iniciar Curso" disabled="true"> &nbsp;
                                        </sec:authorize>
                                    </c:if>

                                </div> 
                            </c:if>


                               <c:if test="${apertura.poderCerrar}">
                                <div id="divBtnGenerar" class="span12" style="text-align: center">      
                                    <c:if test="${apertura.paso7Dias}">
                                        <sec:authorize access="hasRole('MOD_OPE_CERRAR_CURSO')">
                                            <input id="btnGuardar" type="submit" class="btn btn-info fa-input" name="cerrarOpe" value="Cerrar Curso"> &nbsp;
                                        </sec:authorize>
                                    </c:if>    
                                    <c:if test="${!apertura.paso7Dias}">
                                        <sec:authorize access="hasRole('MOD_OPE_CERRAR_CURSO')">
                                            <input id="btnGuardar" type="submit" class="btn btn-info fa-input" name="cerrarOpe" value="Cerrar Curso" disabled="true"> &nbsp;
                                        </sec:authorize>
                                    </c:if>
                                </div>
                            </c:if>

                        </fieldset>
                    </form:form>

                </div>
            </div>
        </div>
    </div>
</sec:authorize>