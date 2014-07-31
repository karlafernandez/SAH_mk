
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<sec:authorize access="hasRole('MOD_OPE_EDITAR_FECHA')">
    <link el="stylesheet" type="text/css" href="<c:url value="/css/paging.css"/>"/>
    <script src="<c:url value='/js/jquery.paging.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/js/validaciones.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/js/operacion/operacion/editar_fecha_operacion.js'/>" type="text/javascript"></script> 

    <div id="activar_curso" class="container-fluid fondoGris">
        <div class="row-fluid">
            <a href="detalle-curso-apertura.html?idOperacion=${operacion.idOperacion}" class="btn btn-info fa-input"><spring:message code="val.operacion.curso_activar.volverLista"/></a>                   
        </div>
        <div class="row-fluid">
            <h3> Modificación de fecha de Inicio y Fin</h3>            
        </div>
        <div class ="row-fluid formulario">                                        
            <c:url var="url" value="/editar-fecha-operacion.html" />
            <form:form id="frmEditarOperacion" modelAttribute="operacion" method="post" action="${url}" cssClass="form-horizontal">     
                <form:hidden id="idOperacion" path="idOperacion"/>
                <fieldset>
                    <legend> Datos de Operación </legend>

                    <div class="row-fluid">
                        <div class="span12">

                            <div id="table-resumen">
                                <table style="width: 60%; margin-left: 1%">
                                    <tr>
                                        <td>
                                            <table class="table table-bordered">
                                                <tr>
                                                    <td class="onlyRead"> CURSO: </td>
                                                    <td> ${operacion.nombreCurso} </td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td>&nbsp;&nbsp;</td>
                                        <td>
                                            <table class="table table-bordered">
                                                <tr>
                                                    <td class="onlyRead"> CODIGO: </td>
                                                    <td> ${operacion.codOperacion} </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                </table>
                            </div>

                            <c:if test="${operacion.fueraPermisoVista}">
                                <div id="div-error" class="message-box info" style="color : red; ">
                                    <strong><h4>${operacion.motivoVista}</h4></strong>
                                </div>
                            </c:if>

                            <c:if test="${!operacion.fueraPermisoVista}">
                                <div class="control-group">
                                    <label class="control-label" for="fecInicio"><spring:message code="lbl.operacion.curso_activar.fec_ini"/>*</label> 
                                    <div class="controls">
                                        <form:input id="fechaInicio" path="fechaInicio" cssClass="input-medium" type="text" style="margin-top: 0px"/>
                                        <form:errors path="fechaInicio" cssClass="help-block" />
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="fechaFin"><spring:message code="lbl.operacion.curso_activar.fec_fin" />*</label> 
                                    <div class="controls">
                                        <form:input id="fechaFin" path="fechaFin" cssClass="input-medium" type="text" style="margin-top: 0px"/>
                                        <form:errors path="fechaFin" cssClass="help-block"/>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${!operacion.fueraPermisoVista}">
                                <fieldset>
                                    <div class="row-fluid">
                                        <span><spring:message code="ttl.campos.obligatorios"/></span>
                                    </div>
                                    <div class="row-fluid">
                                        <div class="span12 form-actions">
                                            <div class="control-group">
                                                <div class="controls">
                                                    <input id="btnGuardar" type="submit" class="btn btn-info fa-input" name="guardar" value="<spring:message code="btn.guardar"/>"> &nbsp;
                                                    <a class="btn btn-info fa-input right" href="detalle-curso-apertura.html?idOperacion=${operacion.idOperacion}"><spring:message code="btn.cancelar"/></a>                                
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </fieldset>
                            </c:if>
                        </div>
                    </div>
                </fieldset>
            </form:form>                                             
        </div>
    </div>                           
</sec:authorize>

