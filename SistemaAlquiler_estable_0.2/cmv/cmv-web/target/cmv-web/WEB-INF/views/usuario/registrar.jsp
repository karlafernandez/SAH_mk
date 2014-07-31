<%-- 
    Document   : registrar
    Created on : 11/01/2014, 01:43:57 PM
    Author     : Alejandra Gonzales
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div class="container-fluid">
    <c:url var="url" value="/registrar-usuario.html" />
    <form:form id="frmRegistrar" modelAttribute="paciente" method="post" action="${url}" cssStyle="margin:auto;">
        <div class="clearfix fix" >
            <label for="numDocumento" > Numero de documento </label>
            <form:input path="numDocumento" />
            <div><form:errors path="numDocumento" cssClass="error_val" /></div>
        </div> 
        <div class="clearfix fix" >
            <label for="nombre" > Nombre </label>
            <form:input path="nombre" />
            <div><form:errors path="nombre" cssClass="error_val" /></div>
        </div> 
        <div class="clearfix fix" > 
            <label for="numDocumento" > Tipo de documento</label>
            <form:select id="idTipoDocumento" path="idTipoDocumento" cssClass="span-5">
                <form:option value="1">DNI</form:option>
                <form:option value="2">CARNET</form:option>
            </form:select>
            <div><form:errors path="numDocumento" cssClass="error_val" /></div>
        </div>
        
        
         
        <button type="submit" name="guardar" value="Aceptar"> Aceptar</button>

    </form:form>
</div>