

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<sec:authorize access="hasRole('MOD_SEG_BLOQUEO_ALUMNO')">    
    <div id="BloquearAlumno" class="container-fluid fondoGris">
        <div class="row-fluid">        
            <a href="listar_adm_alumno.html" class="btn btn-info fa-input">Volver a Listado</a>               
        </div>    

        <div class="row-fluid">        
            <h3>Bloquear/Desbloquear alumno</h3>
        </div>
        <div class="row-fluid formulario">
            <c:url var="url" value="/bloquear-alumno.html" />
            <form:form id="frmBloquearAlumno" modelAttribute="alumno" method="post" action="${url}" cssClass="form-horizontal" >
                <fieldset>
                    <legend>Datos Alumno</legend>
                    <form:hidden id="idPersona" path="idPersona"/>
                    <div class="row-fluid">
                        <div class="span12">                        
                            <div class="control-group">
                                <label class="control-label" for="nombreCompleto"><spring:message code="lbl.segu.alumNombre"/>:</label>
                                <div class="controls">
                                    <form:input id="nombreCompleto" cssClass="input-xxlarge" path="nombreCompleto" readonly="true"/>                                   
                                </div>
                            </div>

                            <div class="control-group ">
                                <label class="control-label" for="usuario"><spring:message code="lbl.segu.alumUsuario"/>:</label>
                                <div class="controls">
                                    <form:input id="usuario" cssClass="input-medium" path="usuario" readonly="true"/>                                    
                                </div>
                            </div>
                                
                            <div class="control-group" >
                                <label  class="control-label" for="estadoBloqueado"><spring:message code="lbl.segu.alumEstado"/>*</label>
                                <div class="controls"> 
                                    <form:select   path="estadoBloqueado" cssClass="input-medium" >
                                        <form:option value="true"  label="Bloqueado" ></form:option>
                                        <form:option value="false" label="No bloqueado" ></form:option>                        
                                    </form:select>  
                                    <form:errors cssClass="help-block" path="estadoBloqueado" />
                                </div>
                            </div>
                        </div>
                </fieldset>
                <fieldset> 
                    <div class="row-fluid">
                        <span><spring:message code="ttl.campos.obligatorios"/></span>
                    </div>
                    <div class="row-fluid">
                        <div class="span12 form-actions">
                            <div class="control-group">
                                <div class="controls">                                                                                             
                                    <input id="btnGuardar" type="submit" class="btn btn-info fa-input" name="guardar" value="<spring:message code="btn.guardar"/>"> &nbsp;                                                                                                               
                                    <a class="btn btn-info fa-input right" href="listar_adm_alumno.html"><spring:message code="btn.cancelar"/></a>                        
                                </div>                             
                            </div>                        
                        </div>
                    </div>
                </fieldset>          
            </form:form>
        </div>
    </div>
</sec:authorize>
