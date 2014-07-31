<%-- 
    Document   : modificar_curso_especifico
    Created on : 21-ene-2014, 9:54:32
    Author     : César
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<sec:authorize access="hasRole('MOD_ADM_MODIFICAR_CUR_ESP')">
    <script src="<c:url value='/js/validaciones.js'/>" type="text/javascript"></script> 

    <div id="ModificarCursoEspecifico" class="container-fluid fondoGris">
        <div class="row-fluid">
            <a href="lista-curso-especifico.html" class="btn btn-info fa-input">Volver a Listado</a>       
        </div>
        <div class="row-fluid">        
            <h3>Modificar Curso Específico</h3>
        </div>
        <div class="row-fluid formulario">
            <c:url var="url" value="/modificar-curso-especifico.html" />
            <form:form id="frmModificarCursoEspecifico" modelAttribute="cursoEspecifico" method="post" action="${url}" cssClass="form-horizontal" >
                <fieldset>
                    <legend>Datos Curso</legend>
                    <form:hidden id="idCursoEspecifico" path="idCursoEspecifico"/>
                    <div class="row-fluid">
                        <div class="span12">
                            <div class="control-group">
                                <label class="control-label" for="nomCurso"><spring:message code="lbl.curesp.nombreCurso"/>*</label>
                                <div class="controls">
                                    <form:input id="nomCurso" cssClass="input-xxlarge" path="nomCurso" onChange="javascript:this.value=this.value.toUpperCase();" placeholder="Nom cur"/>
                                    <form:errors cssClass="help-block" path="nomCurso"/>
                                </div>
                            </div>

                            <div class="control-group ">
                                <label class="control-label" for="nomenCurso"><spring:message code="lbl.curesp.nomenCurso"/>*</label>
                                <div class="controls">
                                    <form:input id="nomenCurso" cssClass="input-medium" minlength="15" path="nomenCurso" onkeypress="return valSoloAlfanumerico(event) " placeholder="XXXXXXXX" onChange="javascript:this.value=this.value.toUpperCase(event);"/>
                                    <form:errors cssClass="help-block" path="nomenCurso" />                        
                                </div>
                            </div>

                            <div class="control-group ">
                                <label class="control-label" for="numSesion"><spring:message code="lbl.curesp.numSesion"/>*</label>
                                <div class="controls">
                                    <form:input id="numSesion" cssClass="input-mini" maxlength="3" path="numSesion" onkeypress="return valSoloDigitos(event)" placeholder="000" />
                                    <form:errors cssClass="help-block" path="numSesion"/>
                                </div>
                            </div>    

                            <div class="control-group ">
                                <label class="control-label" for="numHora"><spring:message code="lbl.curesp.numHora"/>*</label>
                                <div class="controls">
                                    <form:input id="numHora" cssClass="input-mini" maxlength="3" path="numHora" onkeypress="return valSoloDigitos(event)" placeholder="000"/>
                                    <form:errors cssClass="help-block" path="numHora"/>
                                </div>    
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
                                    <a class="btn btn-info fa-input right" href="lista-curso-especifico.html"><spring:message code="btn.cancelar"/></a>                        
                                </div> 
                            </div>
                        </div>
                    </div>
                </fieldset>   
            </form:form>
        </div>
    </div>
</sec:authorize>



