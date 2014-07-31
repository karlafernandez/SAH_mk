

<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<script src="<c:url value='/js/administracion/empresa/empresa.registrar.js'/>" type="text/javascript"></script>
<script src="<c:url value='/js/validaciones.js'/>" type="text/javascript"></script>

<div class="container-fluid fondoGris">
    <div class="row-fluid">
        <h3>Cambiar contraseña</h3>
    </div>
    <div class="row-fluid formulario">        
        <c:url var="url" value="/cambiar-clave.html" />
        <form:form id="frmEmpr" modelAttribute="modCamCont" action="${url}" cssClass="form-horizontal">
            <fieldset>
                <legend> Datos Usuario </legend>
                <div class="row-fluid">
                    <div class="span12">
                        <div class="control-group">
                            <label class="control-label" for="clvAnterior"><spring:message code="lbl.cam.contra.clave_anterior"/>*</label>
                            <div class="controls">
                                <form:password id="clvAnterior" cssClass="input-medium" path="clvAnterior"/>
                                <form:errors cssClass="help-block" path="clvAnterior"/>
                            </div>
                        </div>

                        <div class="control-group ">
                            <label class="control-label" for="clvNueva"><spring:message code="lbl.cam.contra.clave_nueva"/>*</label>
                            <div class="controls">
                                <form:password id="clvNueva" cssClass="input-medium" path="clvNueva"/>
                                <form:errors cssClass="help-block" path="clvNueva" />                        
                            </div>
                        </div>

                        <div class="control-group ">
                            <label class="control-label" for="clvConfirmacion"><spring:message code="lbl.cam.contra.clave_confirmar"/>*</label>
                            <div class="controls">
                                <form:password id="clvConfirmacion" cssClass="input-medium" path="clvConfirmacion" />
                                <form:errors cssClass="help-block" path="clvConfirmacion"/>
                            </div>
                        </div>                          
                    </div>
                </div>      
            </fieldset>
            <fieldset>
                <div class="row-fluid">
                    <span> <spring:message code="ttl.campos.obligatorios"/> </span> 
                </div>
                <div class="row-fluid">
                    <div class="span12 form-actions">
                        <div class="control-group">                            
                            <div class="controls">                                                                                             
                                <input id="btnGuardar" type="submit" class="btn btn-info fa-input" name="guardar" value="<spring:message code="btn.guardar"/>"> &nbsp;                                                                                                               
                                <a class="btn btn-info fa-input right" href="principal.html"><spring:message code="btn.cancelar"/></a>                        
                            </div> 
                        </div>
                    </div>
                </div>
            </fieldset>                             
        </form:form>
    </div>
</div>


