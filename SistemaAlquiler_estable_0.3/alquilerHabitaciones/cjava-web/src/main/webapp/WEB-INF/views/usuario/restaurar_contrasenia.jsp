

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="UsuarioRegistrar">
    <div class="fondoGris">
        <div class="titleBlock clearfix">
            <div class="titleBlock-inner">
                <h1 class="medi2">CJava/SIGA Recuperar Contraseña</h1>
                <a class="back btn fa-input" href="<c:url value='/login.html'/>" ><i class="icon-circle-arrow-left"></i>&nbsp;&nbsp;<span>Regresar</span></a>
            </div>
        </div>
        <br>
        <c:if test="${ not empty mensaje}">
            <c:if test="${mensaje.messageType eq 'SUCCESS'}">
                <c:set var="msgStyle" value="alert alert-success"/>
            </c:if>
            <c:if test="${mensaje.messageType eq 'WARNING'}">
                <c:set var="msgStyle" value="alert alert"/>
            </c:if>
            <c:if test="${mensaje.messageType eq 'ERROR'}">
                <c:set var="msgStyle" value="alert alert-error"/>
            </c:if>
            <div class="${msgStyle}">
                <c:if test="${not empty  mensaje.messages}">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                </c:if> 
                <c:forEach items="${mensaje.messages}" var="message">
                    <strong>  <c:out value="${message}"/></strong>
                </c:forEach>
            </div>
        </c:if>
        <c:url var="url" value="/restaurar-contrasenia.html" />
        <div class="row-fluid formulario">
            <form:form id="restContrasenia"  method="post" commandName="persona" action="${url}" cssClass="form-horizontal" >
                <fieldset>  
                    <div class="row-fluid">
                        <div class="span12">
                            <div class="control-group">
                                <label class="control-label" for="nomUsuario"><spring:message code="lbl.rest.contra.nom_user"/>*</label>
                                <div class="controls">
                                    <form:input path="nomUsuario" maxlength="100" style="height: 29px; width: 250px" /> 
                                </div>
                            </div>                       
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span12">
                            <div class="control-group">
                                <label class="control-label" for="correo"><spring:message code="lbl.rest.contra.correo"/>*</label>
                                <div class="controls">
                                    <form:input path="correo" maxlength="100" style="height: 29px; width: 250px" /> 
                                </div>
                            </div>                       
                        </div>
                    </div>                            
                </fieldset>
                <fieldset>
                    <div class="row-fluid">
                        <span> <spring:message code="ttl.campos.obligatorios"/> </span> 
                        <input class="medibutton2 btn right fa-input" style="margin-left: 11%" name="submit" type="submit" value="&#xf00c;&nbsp;Enviar" >
                    </div>
                </fieldset>                             
            </form:form>
        </div>
    </div>
    <div class="row-fluid">
        <div class="span12 form-actions">
            <div class="control-group">                            
                <div class="controls">                                                                                                                            
                </div> 
            </div>
        </div>
    </div>
</div>

