
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<sec:authorize access="hasRole('MOD_OPE_APERTURA_OPERACION')">
    <link el="stylesheet" type="text/css" href="<c:url value="/css/paging.css"/>"/>
    <script src="<c:url value='/js/jquery.paging.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/js/validaciones.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/js/operacion/operacion/activar_curso.js'/>" type="text/javascript"></script> 

    <div id="activar_curso" class="container-fluid fondoGris">
        <div class="row-fluid">
            <a href="lista-curso-operacion.html" class="btn btn-info fa-input"><spring:message code="val.operacion.curso_activar.volverLista"/></a>                   
        </div>
        <div class="row-fluid">
            <h3> Activación del Curso Específico</h3>            
        </div>
        <div class ="row-fluid formulario">                                        
            <c:url var="url" value="/activar-curso.html" />
            <form:form id="frmActivarCurso" modelAttribute="opeAct" method="post" action="${url}" cssClass="form-horizontal">     
                <fieldset>
                    <legend> Datos de Operación </legend>
                    <form:hidden id="idCurEsp" path="idCurEsp"/>
                    <div class="row-fluid">
                        <div class="span12">
                            <div class="control-group">
                                <label class="control-label" for="turno"><spring:message code="lbl.operacion.curso_activar.turno"/>*</label>
                                <div class="controls">
                                    <form:select id="idTurno" path="idTurno" cssClass="input-medium" style="margin-top: 0px" >
                                        <form:option value="0" label="Seleccione"/>
                                        <form:options items="${lstTurno}" itemValue="idSubTipo" itemLabel="nomSubtipo"/>
                                    </form:select>
                                    <form:errors cssClass="help-block" path="idTurno" /> 
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="tipoCurso"><spring:message code="lbl.operacion.curso_activar.tipo_curso"/>*</label>
                                <div class="controls">
                                    <form:select id="tipoCurso" path="tipoCurso" cssClass="input-medium" style="margin-top: 0px">
                                        <form:option value="false" label="Publico en general"/>
                                        <form:option value="true" label="Corporativo"/>                                   
                                    </form:select> 
                                    <form:errors path="tipoCurso" cssClass="help-block"/>    
                                </div>
                            </div>

                            <div id="listaEmpresa" class="control-group">
                                <label class="control-label" for="empresa"><spring:message code="lbl.operacion.curso_activar.empresa"/>*</label>
                                <div class="controls">
                                    <form:select id="idEmpresa" path="idEmpresa" cssClass="input-xxlarge" style="margin-top: 0px" >
                                        <form:option value="0" label="Seleccione"/>
                                        <form:options items="${lstEmpresa}" itemValue="id" itemLabel="nombre"/>
                                    </form:select> 
                                    <form:errors path="idEmpresa" cssClass="help-block"/>    
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="fecInicio"><spring:message code="lbl.operacion.curso_activar.fec_ini"/>*</label> 
                                <div class="controls">
                                    <form:input id="fecInicio" path="fecInicio" cssClass="input-medium" type="text" style="margin-top: 0px"/>
                                    <form:errors path="fecInicio" cssClass="help-block" />
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="fecFin"><spring:message code="lbl.operacion.curso_activar.fec_fin" />*</label> 
                                <div class="controls">
                                    <form:input id="fecFin" path="fecFin" cssClass="input-medium" type="text" style="margin-top: 0px"/>
                                    <form:errors path="fecFin" cssClass="help-block"/>
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="fecFin"><spring:message code="lbl.operacion.curso_activar.nom_salon" />*</label> 
                                <div class="controls">
                                    <form:input id="nomSalon" path="nomSalon" cssClass="input-medium" type="text" style="margin-top: 0px"/>
                                    <form:errors path="nomSalon" cssClass="help-block"/>
                                </div>
                            </div>
                                                                                               
                            <form:errors path="idCurEsp" cssClass="text-error"/>       
                            <fieldset >
                                <div class="row-fluid">
                                    <legend class="legendSmall">INGRESE NOMBRE DEL CURSO*</legend>
                                    <div class="input-append" style="text-align: center; margin-left:20px">                                       
                                        <input class="input-xxlarge" id="curso" type="text" placeholder="Escriba el nombre del curso y selecione"/>                              
                                        <input type="button" id="btnBuscar" class="btn btn-info fa-input span4" value="<spring:message code="btn.buscar"/>">                                                                                                                                                    
                                    </div> 
                                </div>
                            </fieldset>  
                            <br>

                            <div class="row-fluid" id="tablaCurso">
                                <table id="cabeceraTablaCurso" class="table table-bordered table-hover table-striped"   >
                                    <thead>
                                        <tr>
                                            <th class="hidden-phone"> Nomenclatura </th>
                                            <th> Nombre </th>
                                            <th> Horas </th>
                                            <th class="hidden-phone"> Sesiones </th>
                                        </tr>
                                    </thead>
                                    <tbody id="cuerpoTablaCurso">                                 
                                    </tbody>
                                </table>                                                    
                            </div>   
                            <fieldset>
                                <div class="row-fluid">
                                    <span><spring:message code="ttl.campos.obligatorios"/></span>
                                </div>
                                <div class="row-fluid">
                                    <div class="span12 form-actions">
                                        <div class="control-group">
                                            <div class="controls">
                                                <input id="btnGuardar" type="submit" class="btn btn-info fa-input" name="guardar" value="<spring:message code="btn.guardar"/>"> &nbsp;
                                                <a class="btn btn-info fa-input right" href="lista-curso-operacion.html"><spring:message code="btn.cancelar"/></a>                                
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </fieldset>
                        </div>
                    </div>
                </fieldset>
            </form:form>                                             
        </div>
    </div>                           
</sec:authorize>
